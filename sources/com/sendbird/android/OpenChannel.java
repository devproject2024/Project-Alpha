package com.sendbird.android;

import com.sendbird.android.BaseChannel;
import com.sendbird.android.Command;
import com.sendbird.android.Member;
import com.sendbird.android.constant.StringSet;
import com.sendbird.android.shadow.com.google.gson.JsonArray;
import com.sendbird.android.shadow.com.google.gson.JsonElement;
import com.sendbird.android.shadow.com.google.gson.JsonObject;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicLong;

public final class OpenChannel extends BaseChannel {
    /* access modifiers changed from: private */
    public static final ConcurrentHashMap<String, OpenChannel> sCachedChannels = new ConcurrentHashMap<>();
    /* access modifiers changed from: private */
    public static final ConcurrentHashMap<String, OpenChannel> sEnteredChannels = new ConcurrentHashMap<>();
    private String mCustomType;
    protected List<User> mOperators;
    protected int mParticipantCount;
    private final Object operatorLock = new Object();
    private AtomicLong operatorsUpdatedAt;

    public interface OpenChannelBanHandler {
        void onResult(SendBirdException sendBirdException);
    }

    public interface OpenChannelCreateHandler {
        void onResult(OpenChannel openChannel, SendBirdException sendBirdException);
    }

    public interface OpenChannelDeleteHandler {
        void onResult(SendBirdException sendBirdException);
    }

    public interface OpenChannelEnterHandler {
        void onResult(SendBirdException sendBirdException);
    }

    public interface OpenChannelExitHandler {
        void onResult(SendBirdException sendBirdException);
    }

    public interface OpenChannelGetHandler {
        void onResult(OpenChannel openChannel, SendBirdException sendBirdException);
    }

    public interface OpenChannelMuteHandler {
        void onResult(SendBirdException sendBirdException);
    }

    public interface OpenChannelRefreshHandler {
        void onResult(SendBirdException sendBirdException);
    }

    public interface OpenChannelUnbanHandler {
        void onResult(SendBirdException sendBirdException);
    }

    public interface OpenChannelUnmuteHandler {
        void onResult(SendBirdException sendBirdException);
    }

    public interface OpenChannelUpdateHandler {
        void onResult(OpenChannel openChannel, SendBirdException sendBirdException);
    }

    static synchronized void clearCache() {
        synchronized (OpenChannel.class) {
            sCachedChannels.clear();
        }
    }

    protected static void clearEnteredChannels() {
        sEnteredChannels.clear();
    }

    static synchronized void removeChannelFromCache(String str) {
        synchronized (OpenChannel.class) {
            sCachedChannels.remove(str);
        }
    }

    static synchronized void removeChannelFromEntered(String str) {
        synchronized (OpenChannel.class) {
            sEnteredChannels.remove(str);
        }
    }

    protected static Collection<OpenChannel> getEnteredChannels() {
        return sEnteredChannels.values();
    }

    static boolean isEnteredChannel(String str) {
        return sEnteredChannels.get(str) != null;
    }

    public final void refresh(final OpenChannelRefreshHandler openChannelRefreshHandler) {
        getChannelWithoutCache(false, getUrl(), new OpenChannelGetHandler() {
            public final void onResult(OpenChannel openChannel, final SendBirdException sendBirdException) {
                if (sendBirdException != null) {
                    if (openChannelRefreshHandler != null) {
                        SendBird.runOnUIThread(new Runnable() {
                            public final void run() {
                                openChannelRefreshHandler.onResult(sendBirdException);
                            }
                        });
                    }
                } else if (openChannelRefreshHandler != null) {
                    SendBird.runOnUIThread(new Runnable() {
                        public final void run() {
                            openChannelRefreshHandler.onResult((SendBirdException) null);
                        }
                    });
                }
            }
        });
    }

    protected static synchronized OpenChannel upsert(JsonElement jsonElement, boolean z) {
        OpenChannel openChannel;
        synchronized (OpenChannel.class) {
            String asString = jsonElement.getAsJsonObject().get(StringSet.channel_url).getAsString();
            if (sCachedChannels.containsKey(asString)) {
                OpenChannel openChannel2 = sCachedChannels.get(asString);
                if (!z || openChannel2.isDirty()) {
                    openChannel2.update(jsonElement);
                    openChannel2.setDirty(z);
                }
            } else {
                sCachedChannels.put(asString, new OpenChannel(jsonElement));
            }
            openChannel = sCachedChannels.get(asString);
        }
        return openChannel;
    }

    protected static synchronized void setDirtyToAllCachedChannels(boolean z) {
        synchronized (OpenChannel.class) {
            if (sCachedChannels != null) {
                for (OpenChannel dirty : sCachedChannels.values()) {
                    dirty.setDirty(z);
                }
            }
        }
    }

    protected OpenChannel(JsonElement jsonElement) {
        super(jsonElement);
    }

    /* access modifiers changed from: protected */
    public final void update(JsonElement jsonElement) {
        super.update(jsonElement);
        parse(jsonElement);
    }

    private void parse(JsonElement jsonElement) {
        JsonObject asJsonObject = jsonElement.getAsJsonObject();
        if (asJsonObject.has("participant_count")) {
            this.mParticipantCount = asJsonObject.get("participant_count").getAsInt();
        }
        if (asJsonObject.has("operators") && asJsonObject.get("operators").isJsonArray()) {
            this.mOperators = new ArrayList();
            JsonArray asJsonArray = asJsonObject.get("operators").getAsJsonArray();
            for (int i2 = 0; i2 < asJsonArray.size(); i2++) {
                this.mOperators.add(new User(asJsonArray.get(i2)));
            }
        }
        this.operatorsUpdatedAt = new AtomicLong(0);
        if (asJsonObject.has(StringSet.custom_type)) {
            this.mCustomType = asJsonObject.get(StringSet.custom_type).getAsString();
        }
    }

    /* access modifiers changed from: package-private */
    public final JsonElement toJson() {
        JsonObject asJsonObject = super.toJson().getAsJsonObject();
        asJsonObject.addProperty(StringSet.channel_type, BaseChannel.ChannelType.OPEN.value());
        asJsonObject.addProperty("participant_count", (Number) Integer.valueOf(this.mParticipantCount));
        String str = this.mCustomType;
        if (str != null) {
            asJsonObject.addProperty(StringSet.custom_type, str);
        }
        JsonArray jsonArray = new JsonArray();
        synchronized (this.operatorLock) {
            for (User json : this.mOperators) {
                jsonArray.add(json.toJson());
            }
        }
        asJsonObject.add("operators", jsonArray);
        return asJsonObject;
    }

    public final int getParticipantCount() {
        return this.mParticipantCount;
    }

    /* access modifiers changed from: protected */
    public final void setParticipantCount(int i2) {
        this.mParticipantCount = i2;
    }

    public final List<User> getOperators() {
        List<User> list = this.mOperators;
        if (list != null) {
            return Collections.unmodifiableList(list);
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public final synchronized void updateOperators(List<User> list, long j) {
        if (j > this.operatorsUpdatedAt.get()) {
            this.operatorsUpdatedAt.set(j);
            synchronized (this.operatorLock) {
                this.mOperators.clear();
                this.mOperators.addAll(list);
            }
        }
    }

    public final String getCustomType() {
        return this.mCustomType;
    }

    public static OpenChannelListQuery createOpenChannelListQuery() {
        return new OpenChannelListQuery();
    }

    public static void createChannel(OpenChannelCreateHandler openChannelCreateHandler) {
        createChannelWithOperatorUserIds((String) null, (Object) null, (String) null, (List<String>) null, openChannelCreateHandler);
    }

    @Deprecated
    public static void createChannel(String str, Object obj, String str2, OpenChannelCreateHandler openChannelCreateHandler) throws ClassCastException {
        createChannelWithOperatorUserIds(str, obj, str2, (List<String>) null, openChannelCreateHandler);
    }

    @Deprecated
    public static void createChannel(String str, Object obj, String str2, List<User> list, OpenChannelCreateHandler openChannelCreateHandler) throws ClassCastException {
        ArrayList arrayList = new ArrayList();
        if (list != null) {
            for (User next : list) {
                if (next != null) {
                    arrayList.add(next.getUserId());
                }
            }
        }
        createChannelWithOperatorUserIds(str, obj, str2, arrayList, openChannelCreateHandler);
    }

    public static void createChannel(String str, Object obj, String str2, String str3, List<User> list, OpenChannelCreateHandler openChannelCreateHandler) throws ClassCastException {
        ArrayList arrayList = new ArrayList();
        if (list != null) {
            for (User next : list) {
                if (next != null) {
                    arrayList.add(next.getUserId());
                }
            }
        }
        createChannelWithOperatorUserIds(str, obj, str2, str3, arrayList, openChannelCreateHandler);
    }

    public static void createChannelWithOperatorUserIds(String str, Object obj, String str2, List<String> list, OpenChannelCreateHandler openChannelCreateHandler) throws ClassCastException {
        createChannelWithOperatorUserIds(str, obj, str2, (String) null, list, openChannelCreateHandler);
    }

    public static void createChannelWithOperatorUserIds(String str, Object obj, String str2, String str3, List<String> list, OpenChannelCreateHandler openChannelCreateHandler) throws ClassCastException {
        if ((obj instanceof String) || (obj instanceof File) || obj == null) {
            final Object obj2 = obj;
            final String str4 = str;
            final String str5 = str2;
            final String str6 = str3;
            final List<String> list2 = list;
            final OpenChannelCreateHandler openChannelCreateHandler2 = openChannelCreateHandler;
            d.a(new q<OpenChannel>() {
                public final /* synthetic */ void a(Object obj, SendBirdException sendBirdException) {
                    OpenChannel openChannel = (OpenChannel) obj;
                    OpenChannelCreateHandler openChannelCreateHandler = openChannelCreateHandler2;
                    if (openChannelCreateHandler != null) {
                        openChannelCreateHandler.onResult(openChannel, sendBirdException);
                    }
                }

                public final /* synthetic */ Object call() throws Exception {
                    JsonElement jsonElement;
                    Object obj = obj2;
                    if ((obj instanceof String) || obj == null) {
                        jsonElement = APIClient.a().a(str4, (String) null, (String) obj2, str5, str6, (List<String>) list2);
                    } else {
                        jsonElement = APIClient.a().a(str4, (String) null, (File) obj2, str5, str6, (List<String>) list2);
                    }
                    return OpenChannel.upsert(jsonElement, false);
                }
            });
            return;
        }
        throw new ClassCastException();
    }

    public static void createChannelWithOperatorUserIds(String str, String str2, Object obj, String str3, String str4, List<String> list, OpenChannelCreateHandler openChannelCreateHandler) throws ClassCastException {
        if ((obj instanceof String) || (obj instanceof File) || obj == null) {
            final Object obj2 = obj;
            final String str5 = str;
            final String str6 = str2;
            final String str7 = str3;
            final String str8 = str4;
            final List<String> list2 = list;
            final OpenChannelCreateHandler openChannelCreateHandler2 = openChannelCreateHandler;
            d.a(new q<OpenChannel>() {
                public final /* synthetic */ void a(Object obj, SendBirdException sendBirdException) {
                    OpenChannel openChannel = (OpenChannel) obj;
                    OpenChannelCreateHandler openChannelCreateHandler = openChannelCreateHandler2;
                    if (openChannelCreateHandler != null) {
                        openChannelCreateHandler.onResult(openChannel, sendBirdException);
                    }
                }

                public final /* synthetic */ Object call() throws Exception {
                    JsonElement jsonElement;
                    Object obj = obj2;
                    if ((obj instanceof String) || obj == null) {
                        jsonElement = APIClient.a().a(str5, str6, (String) obj2, str7, str8, (List<String>) list2);
                    } else {
                        jsonElement = APIClient.a().a(str5, str6, (File) obj2, str7, str8, (List<String>) list2);
                    }
                    return OpenChannel.upsert(jsonElement, false);
                }
            });
            return;
        }
        throw new ClassCastException();
    }

    protected static void getChannelWithoutCache(String str, OpenChannelGetHandler openChannelGetHandler) {
        getChannelWithoutCache(false, str, openChannelGetHandler);
    }

    protected static void getChannelWithoutCacheInternal(String str, OpenChannelGetHandler openChannelGetHandler) {
        getChannelWithoutCache(true, str, openChannelGetHandler);
    }

    public static void getChannel(String str, OpenChannelGetHandler openChannelGetHandler) {
        getChannel(false, str, openChannelGetHandler);
    }

    static void getChannelInternal(String str, OpenChannelGetHandler openChannelGetHandler) {
        getChannel(true, str, openChannelGetHandler);
    }

    private static void getChannel(boolean z, final String str, final OpenChannelGetHandler openChannelGetHandler) {
        if (str == null || str.length() == 0) {
            if (openChannelGetHandler != null) {
                SendBird.runOnUIThread(new Runnable() {
                    public final void run() {
                        openChannelGetHandler.onResult((OpenChannel) null, new SendBirdException("Invalid arguments.", SendBirdError.ERR_INVALID_PARAMETER));
                    }
                });
            }
        } else if (!sCachedChannels.containsKey(str) || sCachedChannels.get(str).isDirty()) {
            getChannelWithoutCache(z, str, new OpenChannelGetHandler() {
                public final void onResult(final OpenChannel openChannel, final SendBirdException sendBirdException) {
                    if (openChannelGetHandler != null) {
                        SendBird.runOnUIThread(new Runnable() {
                            public final void run() {
                                if (openChannel != null || sendBirdException != null) {
                                    openChannelGetHandler.onResult(openChannel, sendBirdException);
                                }
                            }
                        });
                    }
                }
            });
        } else if (openChannelGetHandler != null) {
            SendBird.runOnUIThread(new Runnable() {
                public final void run() {
                    OpenChannel openChannel = (OpenChannel) OpenChannel.sCachedChannels.get(str);
                    if (openChannel != null) {
                        openChannelGetHandler.onResult(openChannel, (SendBirdException) null);
                    }
                }
            });
        }
    }

    private static void getChannelWithoutCache(final boolean z, final String str, final OpenChannelGetHandler openChannelGetHandler) {
        d.a(new q<OpenChannel>() {
            public final /* synthetic */ void a(Object obj, SendBirdException sendBirdException) {
                OpenChannel openChannel = (OpenChannel) obj;
                OpenChannelGetHandler openChannelGetHandler = openChannelGetHandler;
                if (openChannelGetHandler != null) {
                    openChannelGetHandler.onResult(openChannel, sendBirdException);
                }
            }

            public final /* synthetic */ Object call() throws Exception {
                APIClient a2 = APIClient.a();
                String str = str;
                return OpenChannel.upsert(a2.a(String.format(b.OPENCHANNELS_CHANNELURL.url(z), new Object[]{b.urlEncodeUTF8(str)}), (Map<String, String>) null, (Map<String, Collection<String>>) null), false);
            }
        });
    }

    public final void delete(final OpenChannelDeleteHandler openChannelDeleteHandler) {
        final String url = getUrl();
        d.a(new q<JsonElement>() {
            public final /* synthetic */ void a(Object obj, SendBirdException sendBirdException) {
                OpenChannelDeleteHandler openChannelDeleteHandler = openChannelDeleteHandler;
                if (openChannelDeleteHandler != null) {
                    openChannelDeleteHandler.onResult(sendBirdException);
                }
            }

            public final /* synthetic */ Object call() throws Exception {
                JsonElement a2 = APIClient.a().a(true, url);
                OpenChannel.removeChannelFromEntered(url);
                OpenChannel.removeChannelFromCache(url);
                return a2;
            }
        });
    }

    public final void updateChannel(String str, Object obj, String str2, OpenChannelUpdateHandler openChannelUpdateHandler) throws ClassCastException {
        updateChannelWithOperatorUserIds(str, obj, str2, (List<String>) null, openChannelUpdateHandler);
    }

    @Deprecated
    public final void updateChannel(String str, Object obj, String str2, List<User> list, OpenChannelUpdateHandler openChannelUpdateHandler) throws ClassCastException {
        ArrayList arrayList = new ArrayList();
        if (list != null) {
            for (User next : list) {
                if (next != null) {
                    arrayList.add(next.getUserId());
                }
            }
        }
        updateChannelWithOperatorUserIds(str, obj, str2, arrayList, openChannelUpdateHandler);
    }

    public final void updateChannel(String str, Object obj, String str2, String str3, List<User> list, OpenChannelUpdateHandler openChannelUpdateHandler) throws ClassCastException {
        ArrayList arrayList = new ArrayList();
        if (list != null) {
            for (User next : list) {
                if (next != null) {
                    arrayList.add(next.getUserId());
                }
            }
        }
        updateChannelWithOperatorUserIds(str, obj, str2, str3, arrayList, openChannelUpdateHandler);
    }

    public final void updateChannelWithOperatorUserIds(String str, Object obj, String str2, List<String> list, OpenChannelUpdateHandler openChannelUpdateHandler) throws ClassCastException {
        updateChannelWithOperatorUserIds(str, obj, str2, (String) null, list, openChannelUpdateHandler);
    }

    public final void updateChannelWithOperatorUserIds(String str, Object obj, String str2, String str3, List<String> list, OpenChannelUpdateHandler openChannelUpdateHandler) throws ClassCastException {
        if ((obj instanceof String) || (obj instanceof File) || obj == null) {
            final Object obj2 = obj;
            final String str4 = str;
            final String str5 = str2;
            final String str6 = str3;
            final List<String> list2 = list;
            final OpenChannelUpdateHandler openChannelUpdateHandler2 = openChannelUpdateHandler;
            d.a(new q<OpenChannel>() {
                public final /* synthetic */ void a(Object obj, SendBirdException sendBirdException) {
                    OpenChannel openChannel = (OpenChannel) obj;
                    OpenChannelUpdateHandler openChannelUpdateHandler = openChannelUpdateHandler2;
                    if (openChannelUpdateHandler != null) {
                        openChannelUpdateHandler.onResult(openChannel, sendBirdException);
                    }
                }

                public final /* synthetic */ Object call() throws Exception {
                    JsonElement jsonElement;
                    Object obj = obj2;
                    if ((obj instanceof String) || obj == null) {
                        APIClient a2 = APIClient.a();
                        String url = OpenChannel.this.getUrl();
                        String str = str4;
                        String str2 = (String) obj2;
                        String str3 = str5;
                        String str4 = str6;
                        List<String> list = list2;
                        String format = String.format(b.OPENCHANNELS_CHANNELURL.publicUrl(), new Object[]{b.urlEncodeUTF8(url)});
                        JsonObject e2 = APIClient.e();
                        if (str != null) {
                            e2.addProperty("name", str);
                        }
                        if (str2 != null) {
                            e2.addProperty("cover_url", str2);
                        }
                        if (str3 != null) {
                            e2.addProperty("data", str3);
                        }
                        if (str4 != null) {
                            e2.addProperty(StringSet.custom_type, str4);
                        }
                        if (list != null) {
                            JsonArray jsonArray = new JsonArray();
                            for (String add : list) {
                                jsonArray.add(add);
                            }
                            e2.add(StringSet.operator_ids, jsonArray);
                        }
                        jsonElement = a2.b(format, e2);
                    } else {
                        APIClient a3 = APIClient.a();
                        String url2 = OpenChannel.this.getUrl();
                        String str5 = str4;
                        File file = (File) obj2;
                        String str6 = str5;
                        String str7 = str6;
                        List list2 = list2;
                        String format2 = String.format(b.OPENCHANNELS_CHANNELURL.publicUrl(), new Object[]{b.urlEncodeUTF8(url2)});
                        HashMap hashMap = new HashMap();
                        String str8 = null;
                        if (str5 != null) {
                            hashMap.put("name", str5);
                        }
                        if (file != null) {
                            str8 = "cover_file";
                        }
                        if (str6 != null) {
                            hashMap.put("data", str6);
                        }
                        if (str7 != null) {
                            hashMap.put(StringSet.custom_type, str7);
                        }
                        if (list2 != null) {
                            hashMap.put(StringSet.operator_ids, b.urlEncodeUTF8((Collection<String>) list2));
                        }
                        jsonElement = a3.b(format2, hashMap, str8, file);
                    }
                    return OpenChannel.upsert(jsonElement, false);
                }
            });
            return;
        }
        throw new ClassCastException();
    }

    public final Future<Boolean> enter(OpenChannelEnterHandler openChannelEnterHandler) {
        return enter(true, openChannelEnterHandler);
    }

    /* access modifiers changed from: package-private */
    public final Future<Boolean> enter(boolean z, final OpenChannelEnterHandler openChannelEnterHandler) {
        return u.a().a(Command.b(getUrl()), z, (Command.SendCommandHandler) new Command.SendCommandHandler() {
            public final void onResult(Command command, SendBirdException sendBirdException) {
                if (sendBirdException != null) {
                    OpenChannelEnterHandler openChannelEnterHandler = openChannelEnterHandler;
                    if (openChannelEnterHandler != null) {
                        openChannelEnterHandler.onResult(sendBirdException);
                        return;
                    }
                    return;
                }
                OpenChannel.sEnteredChannels.put(OpenChannel.this.getUrl(), OpenChannel.this);
                JsonObject asJsonObject = command.c().getAsJsonObject();
                if (asJsonObject.has("participant_count")) {
                    OpenChannel.this.setParticipantCount(asJsonObject.get("participant_count").getAsInt());
                }
                if (openChannelEnterHandler != null) {
                    SendBird.runOnUIThread(new Runnable() {
                        public final void run() {
                            openChannelEnterHandler.onResult((SendBirdException) null);
                        }
                    });
                }
            }
        });
    }

    public final void exit(final OpenChannelExitHandler openChannelExitHandler) {
        SendBird.getInstance().sendCommand(Command.c(getUrl()), true, new Command.SendCommandHandler() {
            public final void onResult(Command command, final SendBirdException sendBirdException) {
                if (sendBirdException == null) {
                    OpenChannel.sEnteredChannels.remove(OpenChannel.this.getUrl());
                    JsonObject asJsonObject = command.c().getAsJsonObject();
                    if (asJsonObject.has("participant_count")) {
                        OpenChannel.this.setParticipantCount(asJsonObject.get("participant_count").getAsInt());
                    }
                    if (openChannelExitHandler != null) {
                        SendBird.runOnUIThread(new Runnable() {
                            public final void run() {
                                openChannelExitHandler.onResult((SendBirdException) null);
                            }
                        });
                    }
                } else if (openChannelExitHandler != null) {
                    SendBird.runOnUIThread(new Runnable() {
                        public final void run() {
                            openChannelExitHandler.onResult(sendBirdException);
                        }
                    });
                }
            }
        });
    }

    public final ParticipantListQuery createParticipantListQuery() {
        return new ParticipantListQuery(this);
    }

    public final MutedUserListQuery createMutedUserListQuery() {
        return new MutedUserListQuery(this);
    }

    public final BannedUserListQuery createBannedUserListQuery() {
        return new BannedUserListQuery(this);
    }

    public final void banUser(User user, int i2, final OpenChannelBanHandler openChannelBanHandler) {
        if (user != null) {
            banUserWithUserId(user.getUserId(), i2, openChannelBanHandler);
        } else if (openChannelBanHandler != null) {
            SendBird.runOnUIThread(new Runnable() {
                public final void run() {
                    openChannelBanHandler.onResult(new SendBirdException("Invalid arguments.", SendBirdError.ERR_INVALID_PARAMETER));
                }
            });
        }
    }

    public final void banUserWithUserId(final String str, final int i2, final OpenChannelBanHandler openChannelBanHandler) {
        d.a(new q<JsonElement>() {
            public final /* synthetic */ void a(Object obj, SendBirdException sendBirdException) {
                OpenChannelBanHandler openChannelBanHandler = openChannelBanHandler;
                if (openChannelBanHandler != null) {
                    openChannelBanHandler.onResult(sendBirdException);
                }
            }

            public final /* synthetic */ Object call() throws Exception {
                if (str != null) {
                    return APIClient.a().a(true, OpenChannel.this.getUrl(), str, (String) null, i2);
                }
                throw new SendBirdException("Invalid arguments.", SendBirdError.ERR_INVALID_PARAMETER);
            }
        });
    }

    public final void unbanUser(User user, final OpenChannelUnbanHandler openChannelUnbanHandler) {
        if (user != null) {
            unbanUserWithUserId(user.getUserId(), openChannelUnbanHandler);
        } else if (openChannelUnbanHandler != null) {
            SendBird.runOnUIThread(new Runnable() {
                public final void run() {
                    openChannelUnbanHandler.onResult(new SendBirdException("Invalid arguments.", SendBirdError.ERR_INVALID_PARAMETER));
                }
            });
        }
    }

    public final void unbanUserWithUserId(final String str, final OpenChannelUnbanHandler openChannelUnbanHandler) {
        d.a(new q<JsonElement>() {
            public final /* synthetic */ void a(Object obj, SendBirdException sendBirdException) {
                OpenChannelUnbanHandler openChannelUnbanHandler = openChannelUnbanHandler;
                if (openChannelUnbanHandler != null) {
                    openChannelUnbanHandler.onResult(sendBirdException);
                }
            }

            public final /* synthetic */ Object call() throws Exception {
                if (str != null) {
                    return APIClient.a().a(true, OpenChannel.this.getUrl(), str);
                }
                throw new SendBirdException("Invalid arguments.", SendBirdError.ERR_INVALID_PARAMETER);
            }
        });
    }

    public final void muteUser(User user, final OpenChannelMuteHandler openChannelMuteHandler) {
        if (user != null) {
            localMuteUserWithUserId(user.getUserId(), (String) null, (Integer) null, openChannelMuteHandler);
        } else if (openChannelMuteHandler != null) {
            SendBird.runOnUIThread(new Runnable() {
                public final void run() {
                    openChannelMuteHandler.onResult(new SendBirdException("Invalid arguments.", SendBirdError.ERR_INVALID_PARAMETER));
                }
            });
        }
    }

    public final void muteUserWithUserId(String str, OpenChannelMuteHandler openChannelMuteHandler) {
        localMuteUserWithUserId(str, (String) null, (Integer) null, openChannelMuteHandler);
    }

    public final void muteUser(User user, String str, int i2, final OpenChannelMuteHandler openChannelMuteHandler) {
        if (user != null) {
            localMuteUserWithUserId(user.getUserId(), str, Integer.valueOf(i2), openChannelMuteHandler);
        } else if (openChannelMuteHandler != null) {
            SendBird.runOnUIThread(new Runnable() {
                public final void run() {
                    openChannelMuteHandler.onResult(new SendBirdException("Invalid arguments.", SendBirdError.ERR_INVALID_PARAMETER));
                }
            });
        }
    }

    public final void muteUserWithUserId(String str, String str2, int i2, OpenChannelMuteHandler openChannelMuteHandler) {
        localMuteUserWithUserId(str, str2, Integer.valueOf(i2), openChannelMuteHandler);
    }

    private void localMuteUserWithUserId(String str, String str2, Integer num, OpenChannelMuteHandler openChannelMuteHandler) {
        final String str3 = str;
        final String str4 = str2;
        final Integer num2 = num;
        final OpenChannelMuteHandler openChannelMuteHandler2 = openChannelMuteHandler;
        d.a(new q<JsonElement>() {
            public final /* synthetic */ void a(Object obj, SendBirdException sendBirdException) {
                OpenChannelMuteHandler openChannelMuteHandler = openChannelMuteHandler2;
                if (openChannelMuteHandler != null) {
                    openChannelMuteHandler.onResult(sendBirdException);
                }
            }

            public final /* synthetic */ Object call() throws Exception {
                if (str3 != null) {
                    return APIClient.a().a(true, OpenChannel.this.getUrl(), str3, str4, num2);
                }
                throw new SendBirdException("Invalid arguments.", SendBirdError.ERR_INVALID_PARAMETER);
            }
        });
    }

    public final void unmuteUser(User user, final OpenChannelUnmuteHandler openChannelUnmuteHandler) {
        if (user != null) {
            unmuteUserWithUserId(user.getUserId(), openChannelUnmuteHandler);
        } else if (openChannelUnmuteHandler != null) {
            SendBird.runOnUIThread(new Runnable() {
                public final void run() {
                    openChannelUnmuteHandler.onResult(new SendBirdException("Invalid arguments.", SendBirdError.ERR_INVALID_PARAMETER));
                }
            });
        }
    }

    public final void unmuteUserWithUserId(final String str, final OpenChannelUnmuteHandler openChannelUnmuteHandler) {
        d.a(new q<JsonElement>() {
            public final /* synthetic */ void a(Object obj, SendBirdException sendBirdException) {
                OpenChannelUnmuteHandler openChannelUnmuteHandler = openChannelUnmuteHandler;
                if (openChannelUnmuteHandler != null) {
                    openChannelUnmuteHandler.onResult(sendBirdException);
                }
            }

            public final /* synthetic */ Object call() throws Exception {
                if (str != null) {
                    return APIClient.a().b(true, OpenChannel.this.getUrl(), str);
                }
                throw new SendBirdException("Invalid arguments.", SendBirdError.ERR_INVALID_PARAMETER);
            }
        });
    }

    public final boolean isOperator(User user) {
        if (user == null) {
            return false;
        }
        return isOperatorWithUserId(user.getUserId());
    }

    public final boolean isOperatorWithUserId(String str) {
        boolean z;
        synchronized (this.operatorLock) {
            Iterator<User> it2 = this.mOperators.iterator();
            while (true) {
                if (it2.hasNext()) {
                    if (it2.next().getUserId().equals(str)) {
                        z = true;
                        break;
                    }
                } else {
                    z = false;
                    break;
                }
            }
        }
        return z;
    }

    /* access modifiers changed from: package-private */
    public final Member.Role getCurrentUserRole() {
        List<User> operators = getOperators();
        if (operators == null) {
            return Member.Role.NONE;
        }
        User currentUser = SendBird.getCurrentUser();
        if (currentUser == null) {
            return Member.Role.NONE;
        }
        for (User userId : operators) {
            if (userId.getUserId().equals(currentUser.getUserId())) {
                return Member.Role.OPERATOR;
            }
        }
        return Member.Role.NONE;
    }

    public final String toString() {
        return super.toString() + "\nOpenChannel{mParticipantCount=" + this.mParticipantCount + ", mOperators=" + this.mOperators + ", mCustomType='" + this.mCustomType + '\'' + ", operatorsUpdatedAt='" + this.operatorsUpdatedAt + '\'' + '}';
    }

    public static OpenChannel clone(OpenChannel openChannel) {
        return new OpenChannel(openChannel.toJson());
    }
}
