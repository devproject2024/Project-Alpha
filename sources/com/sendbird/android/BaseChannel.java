package com.sendbird.android;

import android.text.TextUtils;
import android.util.Base64;
import com.paytm.business.merchantprofile.view.RequestConfirmationDialogFragment;
import com.sendbird.android.APIClient;
import com.sendbird.android.BaseMessage;
import com.sendbird.android.BaseMessageParams;
import com.sendbird.android.Command;
import com.sendbird.android.FileMessage;
import com.sendbird.android.GroupChannel;
import com.sendbird.android.Member;
import com.sendbird.android.OpenChannel;
import com.sendbird.android.SendBird;
import com.sendbird.android.constant.StringSet;
import com.sendbird.android.handlers.AddOperatorsHandler;
import com.sendbird.android.handlers.RemoveAllOperatorsHandler;
import com.sendbird.android.handlers.RemoveOperatorsHandler;
import com.sendbird.android.log.Logger;
import com.sendbird.android.shadow.com.google.gson.JsonArray;
import com.sendbird.android.shadow.com.google.gson.JsonElement;
import com.sendbird.android.shadow.com.google.gson.JsonObject;
import com.sendbird.android.shadow.com.google.gson.JsonParser;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedQueue;

public abstract class BaseChannel {
    @Deprecated
    protected static final String CHANNEL_TYPE_GROUP = "group";
    @Deprecated
    protected static final String CHANNEL_TYPE_OPEN = "open";
    protected String mCoverUrl;
    protected long mCreatedAt;
    protected String mData;
    private boolean mDirty = false;
    protected boolean mFreeze;
    protected boolean mIsEphemeral;
    /* access modifiers changed from: private */
    public boolean mIsSendingFileMessage = false;
    protected String mName;
    /* access modifiers changed from: private */
    public final ConcurrentLinkedQueue<b> mSendFileMessageDataList = new ConcurrentLinkedQueue<>();
    protected String mUrl;

    public interface CopyFileMessageHandler {
        void onCopied(FileMessage fileMessage, SendBirdException sendBirdException);
    }

    public interface CopyUserMessageHandler {
        void onCopied(UserMessage userMessage, SendBirdException sendBirdException);
    }

    public interface DeleteMessageHandler {
        void onResult(SendBirdException sendBirdException);
    }

    public interface DeleteMetaCounterHandler {
        void onResult(SendBirdException sendBirdException);
    }

    public interface DeleteMetaDataHandler {
        void onResult(SendBirdException sendBirdException);
    }

    public interface GetMessageChangeLogsByTokenHandler extends GetMessageChangeLogsHandler {
        void onResult(List<BaseMessage> list, List<Long> list2, boolean z, String str, SendBirdException sendBirdException);
    }

    public interface GetMessageChangeLogsHandler {
        void onResult(List<BaseMessage> list, List<Long> list2, boolean z, String str, SendBirdException sendBirdException);
    }

    public interface GetMessagesHandler {
        void onResult(List<BaseMessage> list, SendBirdException sendBirdException);
    }

    public interface GetMyMutedInfoHandler {
        void onResult(boolean z, String str, long j, long j2, long j3, SendBirdException sendBirdException);
    }

    public interface MessageMetaArrayHandler {
        void onResult(BaseMessage baseMessage, SendBirdException sendBirdException);
    }

    public interface MetaCounterHandler {
        void onResult(Map<String, Integer> map, SendBirdException sendBirdException);
    }

    public interface MetaDataHandler {
        void onResult(Map<String, String> map, SendBirdException sendBirdException);
    }

    public interface ReactionHandler {
        void onResult(ReactionEvent reactionEvent, SendBirdException sendBirdException);
    }

    public enum ReportCategory {
        SUSPICIOUS,
        HARASSING,
        SPAM,
        INAPPROPRIATE
    }

    public interface ReportHandler {
        void onResult(SendBirdException sendBirdException);
    }

    public interface ReportMessageHandler {
        void onResult(SendBirdException sendBirdException);
    }

    public interface ReportUserHandler {
        void onResult(SendBirdException sendBirdException);
    }

    public interface ResendFileMessageHandler {
        void onSent(FileMessage fileMessage, SendBirdException sendBirdException);
    }

    public interface ResendFileMessageWithProgressHandler {
        void onProgress(int i2, int i3, int i4);

        void onSent(FileMessage fileMessage, SendBirdException sendBirdException);
    }

    public interface ResendUserMessageHandler {
        void onSent(UserMessage userMessage, SendBirdException sendBirdException);
    }

    public interface SendFileMessageHandler {
        void onSent(FileMessage fileMessage, SendBirdException sendBirdException);
    }

    public interface SendFileMessageWithProgressHandler {
        void onProgress(int i2, int i3, int i4);

        void onSent(FileMessage fileMessage, SendBirdException sendBirdException);
    }

    public interface SendFileMessagesHandler {
        void onResult(SendBirdException sendBirdException);

        void onSent(FileMessage fileMessage, SendBirdException sendBirdException);
    }

    public interface SendFileMessagesWithProgressHandler {
        void onProgress(String str, int i2, int i3, int i4);

        void onResult(SendBirdException sendBirdException);

        void onSent(FileMessage fileMessage, SendBirdException sendBirdException);
    }

    public interface SendUserMessageHandler {
        void onSent(UserMessage userMessage, SendBirdException sendBirdException);
    }

    public interface TranslateUserMessageHandler {
        void onTranslated(UserMessage userMessage, SendBirdException sendBirdException);
    }

    public interface UpdateFileMessageHandler {
        void onUpdated(FileMessage fileMessage, SendBirdException sendBirdException);
    }

    public interface UpdateUserMessageHandler {
        void onUpdated(UserMessage userMessage, SendBirdException sendBirdException);
    }

    interface a {
        void a(BaseChannel baseChannel);
    }

    /* access modifiers changed from: package-private */
    public abstract Member.Role getCurrentUserRole();

    public enum ChannelType {
        OPEN(BaseChannel.CHANNEL_TYPE_OPEN),
        GROUP(BaseChannel.CHANNEL_TYPE_GROUP);
        
        private final String value;

        private ChannelType(String str) {
            this.value = str;
        }

        public static ChannelType fromValue(String str) {
            for (ChannelType channelType : values()) {
                if (channelType.value.equalsIgnoreCase(str)) {
                    return channelType;
                }
            }
            return GROUP;
        }

        public final String value() {
            return this.value;
        }
    }

    public enum MessageTypeFilter {
        ALL(""),
        USER(StringSet.MESG),
        FILE(StringSet.FILE),
        ADMIN(StringSet.ADMM);
        
        private final String value;

        private MessageTypeFilter(String str) {
            this.value = str;
        }

        public static MessageTypeFilter fromValue(String str) {
            for (MessageTypeFilter messageTypeFilter : values()) {
                if (messageTypeFilter.value.equalsIgnoreCase(str)) {
                    return messageTypeFilter;
                }
            }
            return null;
        }

        public final String value() {
            return this.value;
        }
    }

    class b {

        /* renamed from: a  reason: collision with root package name */
        boolean f44197a;

        /* renamed from: b  reason: collision with root package name */
        String f44198b;

        /* renamed from: c  reason: collision with root package name */
        long f44199c;

        /* renamed from: d  reason: collision with root package name */
        long f44200d;

        /* renamed from: e  reason: collision with root package name */
        String f44201e;

        /* renamed from: f  reason: collision with root package name */
        final FileMessage f44202f;

        /* renamed from: g  reason: collision with root package name */
        final String f44203g;

        /* renamed from: h  reason: collision with root package name */
        final String f44204h;

        /* renamed from: i  reason: collision with root package name */
        String f44205i = null;
        boolean j = false;
        final BaseMessageParams.MentionType k;
        final List<String> l;
        final BaseMessageParams.PushNotificationDeliveryOption m;
        final List<MessageMetaArray> n;
        final Object o;
        final Object p;
        final /* synthetic */ BaseChannel q;

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v11, resolved type: com.sendbird.android.BaseMessageParams$MentionType} */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        b(com.sendbird.android.BaseChannel r4, boolean r5, java.lang.String r6, long r7, long r9, java.lang.String r11, com.sendbird.android.FileMessage r12, java.lang.String r13, java.lang.String r14, java.lang.String r15, java.util.List<java.lang.String> r16, com.sendbird.android.BaseMessageParams.PushNotificationDeliveryOption r17, java.util.List<com.sendbird.android.MessageMetaArray> r18, java.lang.Object r19, java.lang.Object r20) {
            /*
                r3 = this;
                r0 = r3
                r1 = r4
                r0.q = r1
                r3.<init>()
                r1 = r5
                r0.f44197a = r1
                r1 = r6
                r0.f44198b = r1
                r1 = r7
                r0.f44199c = r1
                r1 = r9
                r0.f44200d = r1
                r1 = r11
                r0.f44201e = r1
                r1 = r12
                r0.f44202f = r1
                r1 = r13
                r0.f44203g = r1
                r1 = r14
                r0.f44204h = r1
                r1 = 0
                r0.f44205i = r1
                r1 = 0
                r0.j = r1
                r1 = r15
                r0.k = r1
                r1 = r16
                r0.l = r1
                r1 = r17
                r0.m = r1
                r1 = r18
                r0.n = r1
                r1 = r19
                r0.o = r1
                r1 = r20
                r0.p = r1
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.sendbird.android.BaseChannel.b.<init>(com.sendbird.android.BaseChannel, boolean, java.lang.String, long, long, java.lang.String, com.sendbird.android.FileMessage, java.lang.String, java.lang.String, com.sendbird.android.BaseMessageParams$MentionType, java.util.List, com.sendbird.android.BaseMessageParams$PushNotificationDeliveryOption, java.util.List, java.lang.Object, java.lang.Object):void");
        }
    }

    protected BaseChannel(JsonElement jsonElement) {
        update(jsonElement);
    }

    /* access modifiers changed from: protected */
    public void update(JsonElement jsonElement) {
        JsonObject asJsonObject = jsonElement.getAsJsonObject();
        String str = "";
        this.mUrl = (!asJsonObject.has(StringSet.channel_url) || asJsonObject.get(StringSet.channel_url).isJsonNull()) ? str : asJsonObject.get(StringSet.channel_url).getAsString();
        this.mName = (!asJsonObject.has("name") || asJsonObject.get("name").isJsonNull()) ? str : asJsonObject.get("name").getAsString();
        this.mCreatedAt = (!asJsonObject.has("created_at") || asJsonObject.get("created_at").isJsonNull()) ? 0 : asJsonObject.get("created_at").getAsLong() * 1000;
        this.mCoverUrl = (!asJsonObject.has("cover_url") || asJsonObject.get("cover_url").isJsonNull()) ? str : asJsonObject.get("cover_url").getAsString();
        if (asJsonObject.has("data") && !asJsonObject.get("data").isJsonNull()) {
            str = asJsonObject.get("data").getAsString();
        }
        this.mData = str;
        boolean z = true;
        this.mFreeze = asJsonObject.has("freeze") && asJsonObject.get("freeze").getAsBoolean();
        if (!asJsonObject.has("is_ephemeral") || !asJsonObject.get("is_ephemeral").getAsBoolean()) {
            z = false;
        }
        this.mIsEphemeral = z;
    }

    /* access modifiers changed from: package-private */
    public JsonElement toJson() {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty(StringSet.channel_url, this.mUrl);
        jsonObject.addProperty("name", this.mName);
        jsonObject.addProperty("created_at", (Number) Long.valueOf(this.mCreatedAt / 1000));
        jsonObject.addProperty("cover_url", this.mCoverUrl);
        jsonObject.addProperty("data", this.mData);
        jsonObject.addProperty("freeze", Boolean.valueOf(this.mFreeze));
        jsonObject.addProperty("is_ephemeral", Boolean.valueOf(this.mIsEphemeral));
        return jsonObject;
    }

    /* access modifiers changed from: protected */
    public void setDirty(boolean z) {
        this.mDirty = z;
    }

    /* access modifiers changed from: protected */
    public boolean isDirty() {
        return this.mDirty;
    }

    public static BaseChannel buildFromSerializedData(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        byte[] bArr2 = new byte[bArr.length];
        for (int i2 = 0; i2 < bArr.length; i2++) {
            bArr2[i2] = (byte) (bArr[i2] ^ (i2 & 255));
        }
        try {
            JsonObject asJsonObject = new JsonParser().parse(new String(Base64.decode(bArr2, 0), AppConstants.UTF_8)).getAsJsonObject();
            if (asJsonObject.get(StringSet.channel_type).getAsString().equals(ChannelType.OPEN.value())) {
                return OpenChannel.upsert(asJsonObject, true);
            }
            if (asJsonObject.get(StringSet.channel_type).getAsString().equals(ChannelType.GROUP.value())) {
                return GroupChannel.upsert(asJsonObject, true);
            }
            return null;
        } catch (UnsupportedEncodingException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public byte[] serialize() {
        JsonObject asJsonObject = toJson().getAsJsonObject();
        asJsonObject.addProperty("version", SendBird.getSDKVersion());
        try {
            byte[] encode = Base64.encode(asJsonObject.toString().getBytes(AppConstants.UTF_8), 0);
            for (int i2 = 0; i2 < encode.length; i2++) {
                encode[i2] = (byte) (encode[i2] ^ (i2 & 255));
            }
            return encode;
        } catch (UnsupportedEncodingException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    public String getType() {
        if (isOpenChannel()) {
            return ChannelType.OPEN.value();
        }
        return ChannelType.GROUP.value();
    }

    public String getData() {
        return this.mData;
    }

    public String getUrl() {
        return this.mUrl;
    }

    public long getCreatedAt() {
        return this.mCreatedAt;
    }

    public String getName() {
        return this.mName;
    }

    public String getCoverUrl() {
        return this.mCoverUrl;
    }

    public boolean isOpenChannel() {
        return this instanceof OpenChannel;
    }

    public boolean isGroupChannel() {
        return this instanceof GroupChannel;
    }

    public boolean isFrozen() {
        return this.mFreeze;
    }

    /* access modifiers changed from: package-private */
    public void setFreeze(boolean z) {
        this.mFreeze = z;
    }

    public boolean isEphemeral() {
        return this.mIsEphemeral;
    }

    /* access modifiers changed from: package-private */
    public void setEphemeral(boolean z) {
        this.mIsEphemeral = z;
    }

    public PreviousMessageListQuery createPreviousMessageListQuery() {
        return new PreviousMessageListQuery(this);
    }

    @Deprecated
    public MessageListQuery createMessageListQuery() {
        return new MessageListQuery(this);
    }

    public OperatorListQuery createOperatorListQuery() {
        return new OperatorListQuery(this);
    }

    private void getMessagesByTimestamp(long j, boolean z, int i2, int i3, boolean z2, MessageTypeFilter messageTypeFilter, String str, List<String> list, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, boolean z8, GetMessagesHandler getMessagesHandler) {
        final long j2 = j;
        final boolean z9 = z;
        final int i4 = i2;
        final int i5 = i3;
        final boolean z10 = z2;
        final MessageTypeFilter messageTypeFilter2 = messageTypeFilter;
        final String str2 = str;
        final List<String> list2 = list;
        final boolean z11 = z3;
        final boolean z12 = z4;
        final boolean z13 = z5;
        final boolean z14 = z6;
        final boolean z15 = z7;
        final boolean z16 = z8;
        final GetMessagesHandler getMessagesHandler2 = getMessagesHandler;
        final boolean z17 = this instanceof OpenChannel;
        d.a(new q<List<BaseMessage>>(this) {
            final /* synthetic */ BaseChannel q;

            {
                this.q = r4;
            }

            public final /* synthetic */ void a(Object obj, SendBirdException sendBirdException) {
                List list = (List) obj;
                GetMessagesHandler getMessagesHandler = getMessagesHandler2;
                if (getMessagesHandler != null) {
                    getMessagesHandler.onResult(list, sendBirdException);
                }
            }

            public final /* synthetic */ Object call() throws Exception {
                MessageTypeFilter messageTypeFilter = messageTypeFilter2;
                LinkedHashSet linkedHashSet = null;
                String value = (messageTypeFilter == null || messageTypeFilter == MessageTypeFilter.ALL) ? null : messageTypeFilter2.value();
                List list = list2;
                if (list != null) {
                    linkedHashSet = new LinkedHashSet(list);
                }
                JsonArray asJsonArray = APIClient.a().a(z17, this.q.getUrl(), 0, j2, i4, i5, z9, z10, value, str2, linkedHashSet, z11, z12, z13, z14, z15, z16).getAsJsonObject().get(StringSet.messages).getAsJsonArray();
                ArrayList arrayList = new ArrayList();
                for (int i2 = 0; i2 < asJsonArray.size(); i2++) {
                    BaseMessage build = BaseMessage.build(asJsonArray.get(i2), this.q.getUrl(), this.q.getType());
                    if (build != null) {
                        arrayList.add(build);
                    }
                }
                return arrayList;
            }
        });
    }

    private void getMessagesById(long j, boolean z, int i2, int i3, boolean z2, MessageTypeFilter messageTypeFilter, String str, List<String> list, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, boolean z8, GetMessagesHandler getMessagesHandler) {
        final long j2 = j;
        final boolean z9 = z;
        final int i4 = i2;
        final int i5 = i3;
        final boolean z10 = z2;
        final MessageTypeFilter messageTypeFilter2 = messageTypeFilter;
        final String str2 = str;
        final List<String> list2 = list;
        final boolean z11 = z3;
        final boolean z12 = z4;
        final boolean z13 = z5;
        final boolean z14 = z6;
        final boolean z15 = z7;
        final boolean z16 = z8;
        final GetMessagesHandler getMessagesHandler2 = getMessagesHandler;
        final boolean z17 = this instanceof OpenChannel;
        d.a(new q<List<BaseMessage>>(this) {
            final /* synthetic */ BaseChannel q;

            {
                this.q = r4;
            }

            public final /* synthetic */ void a(Object obj, SendBirdException sendBirdException) {
                List list = (List) obj;
                GetMessagesHandler getMessagesHandler = getMessagesHandler2;
                if (getMessagesHandler != null) {
                    getMessagesHandler.onResult(list, sendBirdException);
                }
            }

            public final /* synthetic */ Object call() throws Exception {
                boolean z;
                boolean z2;
                String str;
                MessageTypeFilter messageTypeFilter = messageTypeFilter2;
                LinkedHashSet linkedHashSet = null;
                String value = (messageTypeFilter == null || messageTypeFilter == MessageTypeFilter.ALL) ? null : messageTypeFilter2.value();
                List list = list2;
                if (list != null) {
                    linkedHashSet = new LinkedHashSet(list);
                }
                APIClient a2 = APIClient.a();
                boolean z3 = z17;
                String url = this.q.getUrl();
                long j2 = j2;
                int i2 = i4;
                int i3 = i5;
                boolean z4 = z9;
                boolean z5 = z10;
                String str2 = str2;
                boolean z6 = z11;
                boolean z7 = z12;
                boolean z8 = z13;
                APIClient aPIClient = a2;
                boolean z9 = z14;
                LinkedHashSet linkedHashSet2 = linkedHashSet;
                boolean z10 = z15;
                boolean z11 = z16;
                if (z3) {
                    z = z3;
                    z2 = z11;
                    str = String.format(b.OPENCHANNELS_CHANNELURL_MESSAGES.publicUrl(), new Object[]{b.urlEncodeUTF8(url)});
                } else {
                    z2 = z11;
                    z = z3;
                    str = String.format(b.GROUPCHANNELS_CHANNELURL_MESSAGES.publicUrl(), new Object[]{b.urlEncodeUTF8(url)});
                }
                HashMap hashMap = new HashMap();
                hashMap.put(StringSet.is_sdk, "true");
                hashMap.put(StringSet.message_id, String.valueOf(j2));
                hashMap.put(StringSet.prev_limit, String.valueOf(i2));
                hashMap.put(StringSet.next_limit, String.valueOf(i3));
                hashMap.put(StringSet.reverse, String.valueOf(z5));
                hashMap.put(StringSet.include, String.valueOf((i2 > 0 && i3 > 0) || z4));
                if (value != null) {
                    hashMap.put(StringSet.message_type, value);
                }
                if (str2 != null) {
                    hashMap.put(StringSet.custom_type, str2);
                }
                if (z6) {
                    hashMap.put(StringSet.with_sorted_meta_array, "true");
                }
                if (z7) {
                    hashMap.put(StringSet.include_reactions, "true");
                }
                if (z8) {
                    hashMap.put(StringSet.include_thread_info, "true");
                }
                if (z9) {
                    hashMap.put(StringSet.include_replies, "true");
                }
                if (z10) {
                    hashMap.put(StringSet.include_parent_message_text, "true");
                }
                if (z2 && z) {
                    hashMap.put(StringSet.show_subchannel_messages_only, "true");
                }
                HashMap hashMap2 = new HashMap();
                if (linkedHashSet2 != null && linkedHashSet2.size() > 0) {
                    hashMap2.put(StringSet.sender_ids, linkedHashSet2);
                }
                JsonArray asJsonArray = aPIClient.a(str, (Map<String, String>) hashMap, (Map<String, Collection<String>>) hashMap2).getAsJsonObject().get(StringSet.messages).getAsJsonArray();
                ArrayList arrayList = new ArrayList();
                for (int i4 = 0; i4 < asJsonArray.size(); i4++) {
                    BaseMessage build = BaseMessage.build(asJsonArray.get(i4), this.q.getUrl(), this.q.getType());
                    if (build != null) {
                        arrayList.add(build);
                    }
                }
                return arrayList;
            }
        });
    }

    private void getMessageChangeLogs(String str, Long l, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, GetMessageChangeLogsHandler getMessageChangeLogsHandler) {
        final Long l2 = l;
        final String str2 = str;
        final boolean z6 = z;
        final boolean z7 = z2;
        final boolean z8 = z3;
        final boolean z9 = z4;
        final boolean z10 = z5;
        final GetMessageChangeLogsHandler getMessageChangeLogsHandler2 = getMessageChangeLogsHandler;
        d.a(new s<Boolean>() {
            /* access modifiers changed from: private */
            /* renamed from: a */
            public Boolean call() throws Exception {
                String str;
                try {
                    if (l2 != null) {
                        if (l2.longValue() < 0) {
                            throw new SendBirdException("Invalid Arguments.", SendBirdError.ERR_INVALID_PARAMETER);
                        }
                    }
                    APIClient a2 = APIClient.a();
                    boolean isOpenChannel = BaseChannel.this.isOpenChannel();
                    String url = BaseChannel.this.getUrl();
                    String str2 = str2;
                    Long l = l2;
                    boolean z = z6;
                    boolean z2 = z7;
                    boolean z3 = z8;
                    boolean z4 = z9;
                    boolean z5 = z10;
                    if (isOpenChannel) {
                        str = String.format(b.OPENCHANNELS_CHANNELURL_MESSAGES_CHANGELOGS.publicUrl(), new Object[]{b.urlEncodeUTF8(url)});
                    } else {
                        str = String.format(b.GROUPCHANNELS_CHANNELURL_MESSAGES_CHANGELOGS.publicUrl(), new Object[]{b.urlEncodeUTF8(url)});
                    }
                    HashMap hashMap = new HashMap();
                    if (str2 != null) {
                        hashMap.put(StringSet.token, str2);
                    }
                    if (l != null) {
                        hashMap.put(StringSet.change_ts, String.valueOf(l));
                    }
                    if (z) {
                        hashMap.put(StringSet.with_sorted_meta_array, "true");
                    }
                    if (z2) {
                        hashMap.put(StringSet.include_reactions, "true");
                    }
                    if (z3) {
                        hashMap.put(StringSet.include_thread_info, "true");
                    }
                    if (z4) {
                        hashMap.put(StringSet.include_replies, "true");
                    }
                    if (z5) {
                        hashMap.put(StringSet.include_parent_message_text, "true");
                    }
                    JsonObject asJsonObject = a2.a(str, (Map<String, String>) hashMap, (Map<String, Collection<String>>) null).getAsJsonObject();
                    JsonArray asJsonArray = asJsonObject.get(StringSet.updated).getAsJsonArray();
                    final ArrayList arrayList = new ArrayList();
                    for (int i2 = 0; i2 < asJsonArray.size(); i2++) {
                        BaseMessage build = BaseMessage.build(asJsonArray.get(i2), BaseChannel.this.getUrl(), BaseChannel.this.getType());
                        if (build != null) {
                            arrayList.add(build);
                        }
                    }
                    JsonArray asJsonArray2 = asJsonObject.get(StringSet.deleted).getAsJsonArray();
                    final ArrayList arrayList2 = new ArrayList();
                    for (int i3 = 0; i3 < asJsonArray2.size(); i3++) {
                        arrayList2.add(Long.valueOf(asJsonArray2.get(i3).getAsJsonObject().get(StringSet.message_id).getAsLong()));
                    }
                    final boolean asBoolean = asJsonObject.get(StringSet.has_more).getAsBoolean();
                    final String asString = asJsonObject.get("next").getAsString();
                    if (getMessageChangeLogsHandler2 != null) {
                        SendBird.runOnUIThread(new Runnable() {
                            public final void run() {
                                getMessageChangeLogsHandler2.onResult(arrayList, arrayList2, asBoolean, asString, (SendBirdException) null);
                            }
                        });
                    }
                } catch (SendBirdException e2) {
                    if (getMessageChangeLogsHandler2 != null) {
                        SendBird.runOnUIThread(new Runnable() {
                            public final void run() {
                                getMessageChangeLogsHandler2.onResult((List<BaseMessage>) null, (List<Long>) null, false, (String) null, e2);
                            }
                        });
                    }
                }
                return Boolean.TRUE;
            }
        });
    }

    public void getMessagesByMessageId(long j, MessageListParams messageListParams, GetMessagesHandler getMessagesHandler) {
        MessageListParams messageListParams2 = messageListParams;
        final GetMessagesHandler getMessagesHandler2 = getMessagesHandler;
        if (messageListParams2 != null) {
            getMessagesById(j, messageListParams2.isInclusive, messageListParams2.previousResultSize, messageListParams2.nextResultSize, messageListParams2.reverse, messageListParams2.messageType, messageListParams2.customType, messageListParams2.senderUserIds, messageListParams2.includeMetaArray, messageListParams2.includeReactions, messageListParams2.includeThreadInfo, messageListParams2.includeReplies, messageListParams2.includeParentMessageText, messageListParams2.showSubchannelMessagesOnly, getMessagesHandler);
        } else if (getMessagesHandler2 != null) {
            SendBird.runOnUIThread(new Runnable() {
                public final void run() {
                    getMessagesHandler2.onResult((List<BaseMessage>) null, new SendBirdException("Invalid arguments.", SendBirdError.ERR_INVALID_PARAMETER));
                }
            });
        }
    }

    public void getMessagesByTimestamp(long j, MessageListParams messageListParams, GetMessagesHandler getMessagesHandler) {
        MessageListParams messageListParams2 = messageListParams;
        final GetMessagesHandler getMessagesHandler2 = getMessagesHandler;
        if (messageListParams2 != null) {
            getMessagesByTimestamp(j, messageListParams2.isInclusive, messageListParams2.previousResultSize, messageListParams2.nextResultSize, messageListParams2.reverse, messageListParams2.messageType, messageListParams2.customType, messageListParams2.senderUserIds, messageListParams2.includeMetaArray, messageListParams2.includeReactions, messageListParams2.includeThreadInfo, messageListParams2.includeReplies, messageListParams2.includeParentMessageText, messageListParams2.showSubchannelMessagesOnly, getMessagesHandler);
        } else if (getMessagesHandler2 != null) {
            SendBird.runOnUIThread(new Runnable() {
                public final void run() {
                    getMessagesHandler2.onResult((List<BaseMessage>) null, new SendBirdException("Invalid arguments.", SendBirdError.ERR_INVALID_PARAMETER));
                }
            });
        }
    }

    public void getNextMessagesByTimestamp(long j, boolean z, int i2, boolean z2, MessageTypeFilter messageTypeFilter, String str, GetMessagesHandler getMessagesHandler) {
        getMessagesByTimestamp(j, z, 0, i2, z2, messageTypeFilter, str, (List<String>) null, false, false, false, false, false, false, getMessagesHandler);
    }

    public void getNextMessagesByTimestamp(long j, boolean z, int i2, boolean z2, MessageTypeFilter messageTypeFilter, String str, List<String> list, GetMessagesHandler getMessagesHandler) {
        getMessagesByTimestamp(j, z, 0, i2, z2, messageTypeFilter, str, list, false, false, false, false, false, false, getMessagesHandler);
    }

    public void getNextMessagesByTimestamp(long j, boolean z, int i2, boolean z2, MessageTypeFilter messageTypeFilter, String str, List<String> list, boolean z3, GetMessagesHandler getMessagesHandler) {
        getMessagesByTimestamp(j, z, 0, i2, z2, messageTypeFilter, str, list, z3, false, false, false, false, false, getMessagesHandler);
    }

    public void getNextMessagesByTimestamp(long j, boolean z, int i2, boolean z2, MessageTypeFilter messageTypeFilter, String str, List<String> list, boolean z3, boolean z4, GetMessagesHandler getMessagesHandler) {
        getMessagesByTimestamp(j, z, 0, i2, z2, messageTypeFilter, str, list, z3, z4, false, false, false, false, getMessagesHandler);
    }

    public void getPreviousMessagesByTimestamp(long j, boolean z, int i2, boolean z2, MessageTypeFilter messageTypeFilter, String str, GetMessagesHandler getMessagesHandler) {
        getMessagesByTimestamp(j, z, i2, 0, z2, messageTypeFilter, str, (List<String>) null, false, false, false, false, false, false, getMessagesHandler);
    }

    public void getPreviousMessagesByTimestamp(long j, boolean z, int i2, boolean z2, MessageTypeFilter messageTypeFilter, String str, List<String> list, GetMessagesHandler getMessagesHandler) {
        getMessagesByTimestamp(j, z, i2, 0, z2, messageTypeFilter, str, list, false, false, false, false, false, false, getMessagesHandler);
    }

    public void getPreviousMessagesByTimestamp(long j, boolean z, int i2, boolean z2, MessageTypeFilter messageTypeFilter, String str, List<String> list, boolean z3, GetMessagesHandler getMessagesHandler) {
        getMessagesByTimestamp(j, z, i2, 0, z2, messageTypeFilter, str, list, z3, false, false, false, false, false, getMessagesHandler);
    }

    public void getPreviousMessagesByTimestamp(long j, boolean z, int i2, boolean z2, MessageTypeFilter messageTypeFilter, String str, List<String> list, boolean z3, boolean z4, GetMessagesHandler getMessagesHandler) {
        getMessagesByTimestamp(j, z, i2, 0, z2, messageTypeFilter, str, list, z3, z4, false, false, false, false, getMessagesHandler);
    }

    public void getPreviousAndNextMessagesByTimestamp(long j, int i2, int i3, boolean z, MessageTypeFilter messageTypeFilter, String str, GetMessagesHandler getMessagesHandler) {
        getMessagesByTimestamp(j, true, i2, i3, z, messageTypeFilter, str, (List<String>) null, false, false, false, false, false, false, getMessagesHandler);
    }

    public void getPreviousAndNextMessagesByTimestamp(long j, int i2, int i3, boolean z, MessageTypeFilter messageTypeFilter, String str, List<String> list, GetMessagesHandler getMessagesHandler) {
        getMessagesByTimestamp(j, true, i2, i3, z, messageTypeFilter, str, list, false, false, false, false, false, false, getMessagesHandler);
    }

    public void getPreviousAndNextMessagesByTimestamp(long j, int i2, int i3, boolean z, MessageTypeFilter messageTypeFilter, String str, List<String> list, boolean z2, GetMessagesHandler getMessagesHandler) {
        getMessagesByTimestamp(j, true, i2, i3, z, messageTypeFilter, str, list, z2, false, false, false, false, false, getMessagesHandler);
    }

    public void getPreviousAndNextMessagesByTimestamp(long j, int i2, int i3, boolean z, MessageTypeFilter messageTypeFilter, String str, List<String> list, boolean z2, boolean z3, GetMessagesHandler getMessagesHandler) {
        getMessagesByTimestamp(j, true, i2, i3, z, messageTypeFilter, str, list, z2, z3, false, false, false, false, getMessagesHandler);
    }

    public void getNextMessagesById(long j, boolean z, int i2, boolean z2, MessageTypeFilter messageTypeFilter, String str, GetMessagesHandler getMessagesHandler) {
        getMessagesById(j, z, 0, i2, z2, messageTypeFilter, str, (List<String>) null, false, false, false, false, false, false, getMessagesHandler);
    }

    public void getNextMessagesById(long j, boolean z, int i2, boolean z2, MessageTypeFilter messageTypeFilter, String str, List<String> list, GetMessagesHandler getMessagesHandler) {
        getMessagesById(j, z, 0, i2, z2, messageTypeFilter, str, list, false, false, false, false, false, false, getMessagesHandler);
    }

    public void getNextMessagesById(long j, boolean z, int i2, boolean z2, MessageTypeFilter messageTypeFilter, String str, List<String> list, boolean z3, GetMessagesHandler getMessagesHandler) {
        getMessagesById(j, z, 0, i2, z2, messageTypeFilter, str, list, z3, false, false, false, false, false, getMessagesHandler);
    }

    public void getNextMessagesById(long j, boolean z, int i2, boolean z2, MessageTypeFilter messageTypeFilter, String str, List<String> list, boolean z3, boolean z4, GetMessagesHandler getMessagesHandler) {
        getMessagesById(j, z, 0, i2, z2, messageTypeFilter, str, list, z3, z4, false, false, false, false, getMessagesHandler);
    }

    public void getPreviousMessagesById(long j, boolean z, int i2, boolean z2, MessageTypeFilter messageTypeFilter, String str, GetMessagesHandler getMessagesHandler) {
        getMessagesById(j, z, i2, 0, z2, messageTypeFilter, str, (List<String>) null, false, false, false, false, false, false, getMessagesHandler);
    }

    public void getPreviousMessagesById(long j, boolean z, int i2, boolean z2, MessageTypeFilter messageTypeFilter, String str, List<String> list, GetMessagesHandler getMessagesHandler) {
        getMessagesById(j, z, i2, 0, z2, messageTypeFilter, str, list, false, false, false, false, false, false, getMessagesHandler);
    }

    public void getPreviousMessagesById(long j, boolean z, int i2, boolean z2, MessageTypeFilter messageTypeFilter, String str, List<String> list, boolean z3, GetMessagesHandler getMessagesHandler) {
        getMessagesById(j, z, i2, 0, z2, messageTypeFilter, str, list, z3, false, false, false, false, false, getMessagesHandler);
    }

    public void getPreviousMessagesById(long j, boolean z, int i2, boolean z2, MessageTypeFilter messageTypeFilter, String str, List<String> list, boolean z3, boolean z4, GetMessagesHandler getMessagesHandler) {
        getMessagesById(j, z, i2, 0, z2, messageTypeFilter, str, list, z3, z4, false, false, false, false, getMessagesHandler);
    }

    public void getPreviousAndNextMessagesById(long j, int i2, int i3, boolean z, MessageTypeFilter messageTypeFilter, String str, GetMessagesHandler getMessagesHandler) {
        getMessagesById(j, true, i2, i3, z, messageTypeFilter, str, (List<String>) null, false, false, false, false, false, false, getMessagesHandler);
    }

    public void getPreviousAndNextMessagesById(long j, int i2, int i3, boolean z, MessageTypeFilter messageTypeFilter, String str, List<String> list, GetMessagesHandler getMessagesHandler) {
        getMessagesById(j, true, i2, i3, z, messageTypeFilter, str, list, false, false, false, false, false, false, getMessagesHandler);
    }

    public void getPreviousAndNextMessagesById(long j, int i2, int i3, boolean z, MessageTypeFilter messageTypeFilter, String str, List<String> list, boolean z2, GetMessagesHandler getMessagesHandler) {
        getMessagesById(j, true, i2, i3, z, messageTypeFilter, str, list, z2, false, false, false, false, false, getMessagesHandler);
    }

    public void getPreviousAndNextMessagesById(long j, int i2, int i3, boolean z, MessageTypeFilter messageTypeFilter, String str, List<String> list, boolean z2, boolean z3, GetMessagesHandler getMessagesHandler) {
        getMessagesById(j, true, i2, i3, z, messageTypeFilter, str, list, z2, z3, false, false, false, false, getMessagesHandler);
    }

    public void getMessageChangeLogsByToken(String str, GetMessageChangeLogsByTokenHandler getMessageChangeLogsByTokenHandler) {
        getMessageChangeLogs(str, (Long) null, false, false, false, false, false, getMessageChangeLogsByTokenHandler);
    }

    public void getMessageChangeLogsByToken(String str, boolean z, GetMessageChangeLogsByTokenHandler getMessageChangeLogsByTokenHandler) {
        getMessageChangeLogs(str, (Long) null, z, false, false, false, false, getMessageChangeLogsByTokenHandler);
    }

    public void getMessageChangeLogsByToken(String str, boolean z, boolean z2, GetMessageChangeLogsHandler getMessageChangeLogsHandler) {
        getMessageChangeLogs(str, (Long) null, z, z2, false, false, false, getMessageChangeLogsHandler);
    }

    public void getMessageChangeLogsSinceToken(String str, MessageChangeLogsParams messageChangeLogsParams, final GetMessageChangeLogsHandler getMessageChangeLogsHandler) {
        if (messageChangeLogsParams != null) {
            getMessageChangeLogs(str, (Long) null, messageChangeLogsParams.includeMetaArray, messageChangeLogsParams.includeReactions, messageChangeLogsParams.includeThreadInfo, messageChangeLogsParams.includeReplies, messageChangeLogsParams.includeParentMessageText, getMessageChangeLogsHandler);
        } else if (getMessageChangeLogsHandler != null) {
            SendBird.runOnUIThread(new Runnable() {
                public final void run() {
                    getMessageChangeLogsHandler.onResult((List<BaseMessage>) null, (List<Long>) null, false, (String) null, new SendBirdException("Invalid arguments.", SendBirdError.ERR_INVALID_PARAMETER));
                }
            });
        }
    }

    public void getMessageChangeLogsByTimestamp(long j, GetMessageChangeLogsHandler getMessageChangeLogsHandler) {
        getMessageChangeLogs((String) null, Long.valueOf(j), false, false, false, false, false, getMessageChangeLogsHandler);
    }

    public void getMessageChangeLogsByTimestamp(long j, boolean z, GetMessageChangeLogsHandler getMessageChangeLogsHandler) {
        getMessageChangeLogs((String) null, Long.valueOf(j), z, false, false, false, false, getMessageChangeLogsHandler);
    }

    public void getMessageChangeLogsByTimestamp(long j, boolean z, boolean z2, GetMessageChangeLogsHandler getMessageChangeLogsHandler) {
        getMessageChangeLogs((String) null, Long.valueOf(j), z, z2, false, false, false, getMessageChangeLogsHandler);
    }

    public void getMessageChangeLogsSinceTimestamp(long j, MessageChangeLogsParams messageChangeLogsParams, final GetMessageChangeLogsHandler getMessageChangeLogsHandler) {
        if (messageChangeLogsParams != null) {
            getMessageChangeLogs((String) null, Long.valueOf(j), messageChangeLogsParams.includeMetaArray, messageChangeLogsParams.includeReactions, messageChangeLogsParams.includeThreadInfo, messageChangeLogsParams.includeReplies, messageChangeLogsParams.includeParentMessageText, getMessageChangeLogsHandler);
        } else if (getMessageChangeLogsHandler != null) {
            SendBird.runOnUIThread(new Runnable() {
                public final void run() {
                    getMessageChangeLogsHandler.onResult((List<BaseMessage>) null, (List<Long>) null, false, (String) null, new SendBirdException("Invalid arguments.", SendBirdError.ERR_INVALID_PARAMETER));
                }
            });
        }
    }

    public FileMessage sendFileMessage(String str, String str2, String str3, int i2, String str4, SendFileMessageHandler sendFileMessageHandler) {
        return sendFileMessage(str, str2, str3, i2, str4, (String) null, sendFileMessageHandler);
    }

    public FileMessage sendFileMessage(String str, String str2, String str3, int i2, String str4, String str5, SendFileMessageHandler sendFileMessageHandler) {
        return localSendFileMessage((String) null, 0, 0, str, str2, str3, Integer.valueOf(i2), str4, str5, (List<FileMessage.ThumbnailSize>) null, (BaseMessageParams.MentionType) null, (List<String>) null, (BaseMessageParams.PushNotificationDeliveryOption) null, (List<MessageMetaArray>) null, sendFileMessageHandler, (Object) null, (FileMessage) null, true);
    }

    public FileMessage sendFileMessage(File file, String str, String str2, int i2, String str3, SendFileMessageHandler sendFileMessageHandler) {
        return sendFileMessage(file, str, str2, i2, str3, (String) null, (List<FileMessage.ThumbnailSize>) null, sendFileMessageHandler);
    }

    @Deprecated
    public FileMessage sendFileMessage(File file, String str, String str2, int i2, String str3, String str4, SendFileMessageHandler sendFileMessageHandler) {
        return sendFileMessage(file, str, str2, i2, str3, str4, (List<FileMessage.ThumbnailSize>) null, sendFileMessageHandler);
    }

    public FileMessage sendFileMessage(File file, String str, String str2, int i2, String str3, String str4, List<FileMessage.ThumbnailSize> list, SendFileMessageHandler sendFileMessageHandler) {
        return localSendFileMessage((String) null, 0, 0, file, str, str2, Integer.valueOf(i2), str3, str4, list, (BaseMessageParams.MentionType) null, (List<String>) null, (BaseMessageParams.PushNotificationDeliveryOption) null, (List<MessageMetaArray>) null, sendFileMessageHandler, (Object) null, (FileMessage) null, true);
    }

    public FileMessage sendFileMessage(File file, String str, String str2, int i2, String str3, SendFileMessageWithProgressHandler sendFileMessageWithProgressHandler) {
        return sendFileMessage(file, str, str2, i2, str3, (String) null, (List<FileMessage.ThumbnailSize>) null, sendFileMessageWithProgressHandler);
    }

    @Deprecated
    public FileMessage sendFileMessage(File file, String str, String str2, int i2, String str3, String str4, SendFileMessageWithProgressHandler sendFileMessageWithProgressHandler) {
        return sendFileMessage(file, str, str2, i2, str3, str4, (List<FileMessage.ThumbnailSize>) null, sendFileMessageWithProgressHandler);
    }

    public FileMessage sendFileMessage(File file, String str, String str2, int i2, String str3, String str4, List<FileMessage.ThumbnailSize> list, SendFileMessageWithProgressHandler sendFileMessageWithProgressHandler) {
        return localSendFileMessage((String) null, 0, 0, file, str, str2, Integer.valueOf(i2), str3, str4, list, (BaseMessageParams.MentionType) null, (List<String>) null, (BaseMessageParams.PushNotificationDeliveryOption) null, (List<MessageMetaArray>) null, (Object) null, sendFileMessageWithProgressHandler, (FileMessage) null, true);
    }

    public FileMessage sendFileMessage(FileMessageParams fileMessageParams, SendFileMessageHandler sendFileMessageHandler) {
        FileMessageParams fileMessageParams2 = fileMessageParams;
        final SendFileMessageHandler sendFileMessageHandler2 = sendFileMessageHandler;
        if (fileMessageParams2 != null) {
            return localSendFileMessage((String) null, fileMessageParams2.rootMessageId, fileMessageParams2.parentMessageId, fileMessageParams2.mFileUrlOrFile, fileMessageParams2.mFileName, fileMessageParams2.mMimeType, fileMessageParams2.mFileSize, fileMessageParams2.mData, fileMessageParams2.mCustomType, fileMessageParams2.mThumbnailSizes, fileMessageParams2.mMentionType, fileMessageParams2.mMentionedUserIds, fileMessageParams2.mPushNotificationDeliveryOption, fileMessageParams2.mMetaArrays, sendFileMessageHandler, (Object) null, (FileMessage) null, true);
        } else if (sendFileMessageHandler2 != null) {
            SendBird.runOnUIThread(new Runnable() {
                public final void run() {
                    sendFileMessageHandler2.onSent((FileMessage) null, new SendBirdException("Invalid arguments.", SendBirdError.ERR_INVALID_PARAMETER));
                }
            });
            return null;
        } else {
            return null;
        }
    }

    public FileMessage sendFileMessage(FileMessageParams fileMessageParams, SendFileMessageWithProgressHandler sendFileMessageWithProgressHandler) {
        FileMessageParams fileMessageParams2 = fileMessageParams;
        SendFileMessageWithProgressHandler sendFileMessageWithProgressHandler2 = sendFileMessageWithProgressHandler;
        if (fileMessageParams2 == null || !(fileMessageParams2.mFileUrlOrFile instanceof File)) {
            final SendFileMessageWithProgressHandler sendFileMessageWithProgressHandler3 = sendFileMessageWithProgressHandler2;
            if (sendFileMessageWithProgressHandler3 != null) {
                SendBird.runOnUIThread(new Runnable() {
                    public final void run() {
                        sendFileMessageWithProgressHandler3.onSent((FileMessage) null, new SendBirdException("Invalid arguments.", SendBirdError.ERR_INVALID_PARAMETER));
                    }
                });
                return null;
            }
            return null;
        }
        List list = fileMessageParams2.mMetaArrays;
        SendFileMessageWithProgressHandler sendFileMessageWithProgressHandler4 = sendFileMessageWithProgressHandler2;
        return localSendFileMessage((String) null, fileMessageParams2.rootMessageId, fileMessageParams2.parentMessageId, fileMessageParams2.mFileUrlOrFile, fileMessageParams2.mFileName, fileMessageParams2.mMimeType, fileMessageParams2.mFileSize, fileMessageParams2.mData, fileMessageParams2.mCustomType, fileMessageParams2.mThumbnailSizes, fileMessageParams2.mMentionType, fileMessageParams2.mMentionedUserIds, fileMessageParams2.mPushNotificationDeliveryOption, list, (Object) null, sendFileMessageWithProgressHandler, (FileMessage) null, true);
    }

    public List<FileMessage> sendFileMessages(List<FileMessageParams> list, SendFileMessagesHandler sendFileMessagesHandler) {
        int i2;
        FileMessage fileMessage;
        ArrayList arrayList;
        BaseChannel baseChannel = this;
        List<FileMessageParams> list2 = list;
        SendFileMessagesHandler sendFileMessagesHandler2 = sendFileMessagesHandler;
        if (list2 == null || list.size() == 0 || list.size() > 20) {
            BaseChannel baseChannel2 = baseChannel;
            final SendFileMessagesHandler sendFileMessagesHandler3 = sendFileMessagesHandler2;
            if (sendFileMessagesHandler3 != null) {
                SendBird.runOnUIThread(new Runnable() {
                    public final void run() {
                        sendFileMessagesHandler3.onResult(new SendBirdException("Invalid arguments.", SendBirdError.ERR_INVALID_PARAMETER));
                    }
                });
            }
            return null;
        }
        ArrayList arrayList2 = new ArrayList();
        int i3 = 0;
        while (i3 < list.size()) {
            FileMessageParams fileMessageParams = list2.get(i3);
            if (fileMessageParams != null) {
                long j = fileMessageParams.rootMessageId;
                long j2 = fileMessageParams.parentMessageId;
                Object obj = fileMessageParams.mFileUrlOrFile;
                String str = fileMessageParams.mFileName;
                String str2 = fileMessageParams.mMimeType;
                Integer num = fileMessageParams.mFileSize;
                FileMessageParams fileMessageParams2 = fileMessageParams;
                String str3 = fileMessageParams.mData;
                i2 = i3;
                String str4 = fileMessageParams2.mCustomType;
                ArrayList arrayList3 = arrayList2;
                List<FileMessage.ThumbnailSize> list3 = fileMessageParams2.mThumbnailSizes;
                BaseMessageParams.MentionType mentionType = fileMessageParams2.mMentionType;
                List list4 = fileMessageParams2.mMentionedUserIds;
                BaseMessageParams.PushNotificationDeliveryOption pushNotificationDeliveryOption = fileMessageParams2.mPushNotificationDeliveryOption;
                List list5 = fileMessageParams2.mMetaArrays;
                fileMessage = localCreateFileMessage((String) null, j, j2, obj, str, str2, num, str3, str4, list3, mentionType, list4, pushNotificationDeliveryOption, list5, sendFileMessagesHandler, (Object) null);
                arrayList = arrayList3;
            } else {
                i2 = i3;
                arrayList = arrayList2;
                fileMessage = null;
            }
            arrayList.add(fileMessage);
            i3 = i2 + 1;
            list2 = list;
            sendFileMessagesHandler2 = sendFileMessagesHandler;
            arrayList2 = arrayList;
            baseChannel = this;
        }
        BaseChannel baseChannel3 = baseChannel;
        ArrayList arrayList4 = arrayList2;
        baseChannel3.localSendFileMessages(list2, arrayList4, sendFileMessagesHandler2, (SendFileMessagesWithProgressHandler) null);
        return arrayList4;
    }

    public List<FileMessage> sendFileMessages(List<FileMessageParams> list, SendFileMessagesWithProgressHandler sendFileMessagesWithProgressHandler) {
        int i2;
        FileMessage fileMessage;
        ArrayList arrayList;
        BaseChannel baseChannel = this;
        List<FileMessageParams> list2 = list;
        SendFileMessagesWithProgressHandler sendFileMessagesWithProgressHandler2 = sendFileMessagesWithProgressHandler;
        if (list2 == null || list.size() == 0 || list.size() > 20) {
            BaseChannel baseChannel2 = baseChannel;
            final SendFileMessagesWithProgressHandler sendFileMessagesWithProgressHandler3 = sendFileMessagesWithProgressHandler2;
            if (sendFileMessagesWithProgressHandler3 != null) {
                SendBird.runOnUIThread(new Runnable() {
                    public final void run() {
                        sendFileMessagesWithProgressHandler3.onResult(new SendBirdException("Invalid arguments.", SendBirdError.ERR_INVALID_PARAMETER));
                    }
                });
            }
            return null;
        }
        ArrayList arrayList2 = new ArrayList();
        int i3 = 0;
        while (i3 < list.size()) {
            FileMessageParams fileMessageParams = list2.get(i3);
            if (fileMessageParams == null || !(fileMessageParams.mFileUrlOrFile instanceof File)) {
                i2 = i3;
                arrayList = arrayList2;
                fileMessage = null;
            } else {
                long j = fileMessageParams.rootMessageId;
                long j2 = fileMessageParams.parentMessageId;
                Object obj = fileMessageParams.mFileUrlOrFile;
                String str = fileMessageParams.mFileName;
                String str2 = fileMessageParams.mMimeType;
                Integer num = fileMessageParams.mFileSize;
                FileMessageParams fileMessageParams2 = fileMessageParams;
                String str3 = fileMessageParams.mData;
                i2 = i3;
                String str4 = fileMessageParams2.mCustomType;
                ArrayList arrayList3 = arrayList2;
                List<FileMessage.ThumbnailSize> list3 = fileMessageParams2.mThumbnailSizes;
                BaseMessageParams.MentionType mentionType = fileMessageParams2.mMentionType;
                List list4 = fileMessageParams2.mMentionedUserIds;
                BaseMessageParams.PushNotificationDeliveryOption pushNotificationDeliveryOption = fileMessageParams2.mPushNotificationDeliveryOption;
                List list5 = fileMessageParams2.mMetaArrays;
                fileMessage = localCreateFileMessage((String) null, j, j2, obj, str, str2, num, str3, str4, list3, mentionType, list4, pushNotificationDeliveryOption, list5, (Object) null, sendFileMessagesWithProgressHandler);
                arrayList = arrayList3;
            }
            arrayList.add(fileMessage);
            i3 = i2 + 1;
            list2 = list;
            sendFileMessagesWithProgressHandler2 = sendFileMessagesWithProgressHandler;
            arrayList2 = arrayList;
            baseChannel = this;
        }
        BaseChannel baseChannel3 = baseChannel;
        ArrayList arrayList4 = arrayList2;
        baseChannel3.localSendFileMessages(list2, arrayList4, (SendFileMessagesHandler) null, sendFileMessagesWithProgressHandler2);
        return arrayList4;
    }

    private FileMessage localCreateFileMessage(String str, long j, long j2, Object obj, String str2, String str3, Integer num, String str4, String str5, List<FileMessage.ThumbnailSize> list, BaseMessageParams.MentionType mentionType, List<String> list2, BaseMessageParams.PushNotificationDeliveryOption pushNotificationDeliveryOption, List<MessageMetaArray> list3, Object obj2, Object obj3) {
        String str6;
        String str7;
        String str8;
        Integer num2;
        String str9;
        String str10;
        String str11;
        Object obj4 = obj;
        String str12 = str3;
        final Object obj5 = obj2;
        final Object obj6 = obj3;
        String str13 = null;
        if (obj4 instanceof String) {
            String str14 = (String) obj4;
            if (str2 == null || str2.length() == 0) {
                str11 = "";
            } else {
                str11 = str2;
            }
            if (str12 == null || str3.length() == 0) {
                str12 = "";
            }
            if (num == null) {
                str8 = str14;
                str6 = str12;
                str7 = str11;
                num2 = 0;
            } else {
                str8 = str14;
                str6 = str12;
                str7 = str11;
                num2 = num;
            }
        } else if (obj4 instanceof File) {
            File file = (File) obj4;
            if (str2 == null || str2.length() == 0) {
                str10 = file.getName();
            } else {
                str10 = str2;
            }
            try {
                str12 = APIClient.a(file, str12);
            } catch (SendBirdException unused) {
            }
            if (str12 == null || str12.length() == 0) {
                str12 = "";
            }
            num2 = num == null ? Integer.valueOf((int) file.length()) : num;
            str6 = str12;
            str7 = str10;
            str8 = "";
        } else {
            if (obj5 != null) {
                SendBird.runOnUIThread(new Runnable() {
                    public final void run() {
                        Object obj = obj5;
                        if (obj instanceof SendFileMessageHandler) {
                            ((SendFileMessageHandler) obj).onSent((FileMessage) null, new SendBirdException("Invalid arguments.", SendBirdError.ERR_INVALID_PARAMETER));
                        } else if (obj instanceof SendFileMessagesHandler) {
                            ((SendFileMessagesHandler) obj).onSent((FileMessage) null, new SendBirdException("Invalid arguments.", SendBirdError.ERR_INVALID_PARAMETER));
                        }
                    }
                });
            } else if (obj6 != null) {
                SendBird.runOnUIThread(new Runnable() {
                    public final void run() {
                        Object obj = obj6;
                        if (obj instanceof SendFileMessageWithProgressHandler) {
                            ((SendFileMessageWithProgressHandler) obj).onSent((FileMessage) null, new SendBirdException("Invalid arguments.", SendBirdError.ERR_INVALID_PARAMETER));
                        } else if (obj instanceof SendFileMessagesWithProgressHandler) {
                            ((SendFileMessagesWithProgressHandler) obj).onSent((FileMessage) null, new SendBirdException("Invalid arguments.", SendBirdError.ERR_INVALID_PARAMETER));
                        }
                    }
                });
            }
            return null;
        }
        JsonObject jsonObject = new JsonObject();
        JsonArray jsonArray = new JsonArray();
        if (list != null) {
            for (FileMessage.ThumbnailSize next : list) {
                JsonObject jsonObject2 = new JsonObject();
                jsonObject2.addProperty(StringSet.width, (Number) Integer.valueOf(next.getMaxWidth()));
                jsonObject2.addProperty(StringSet.height, (Number) Integer.valueOf(next.getMaxHeight()));
                jsonObject2.addProperty("url", "");
                jsonArray.add((JsonElement) jsonObject2);
            }
        }
        jsonObject.add("thumbnails", jsonArray);
        String jsonElement = jsonObject.get("thumbnails").toString();
        if (list3 != null && list3.size() > 0) {
            JsonArray jsonArray2 = new JsonArray();
            for (MessageMetaArray json : list3) {
                jsonArray2.add((JsonElement) json.toJson());
            }
            str13 = jsonArray2.toString();
        }
        String str15 = str13;
        if (str == null || str.length() <= 0) {
            str9 = Command.a();
        } else {
            str9 = str;
        }
        final FileMessage fileMessage = new FileMessage(FileMessage.build(str9, BaseMessage.SendingStatus.NONE, 0, j, j2, Sender.toSender(SendBird.getCurrentUser(), getCurrentUserRole()), getUrl(), getType(), str8, str7, str6, num2.intValue(), str4, str5, jsonElement, false, System.currentTimeMillis(), 0, mentionType, list2, (String) null, (String) null, (String) null, (String) null, str15, false, 0, false, false, -1, (String) null, new ThreadInfo(), getCurrentUserRole() == Member.Role.OPERATOR));
        if (SendBird.getCurrentUser() == null) {
            if (obj5 != null) {
                SendBird.runOnUIThread(new Runnable() {
                    public final void run() {
                        FileMessage fileMessage = new FileMessage(fileMessage.toJson());
                        fileMessage.mCreatedAt = fileMessage.getCreatedAt();
                        fileMessage.setSendingStatus(BaseMessage.SendingStatus.FAILED);
                        fileMessage.mErrorCode = SendBirdError.ERR_CONNECTION_REQUIRED;
                        Object obj = obj5;
                        if (obj instanceof SendFileMessageHandler) {
                            ((SendFileMessageHandler) obj).onSent(fileMessage, new SendBirdException("Connection must be made before you send message.", SendBirdError.ERR_CONNECTION_REQUIRED));
                        } else if (obj instanceof SendFileMessagesHandler) {
                            ((SendFileMessagesHandler) obj).onSent(fileMessage, new SendBirdException("Connection must be made before you send message.", SendBirdError.ERR_CONNECTION_REQUIRED));
                        }
                    }
                });
            } else if (obj6 != null) {
                SendBird.runOnUIThread(new Runnable() {
                    public final void run() {
                        FileMessage fileMessage = new FileMessage(fileMessage.toJson());
                        fileMessage.mCreatedAt = fileMessage.getCreatedAt();
                        fileMessage.setSendingStatus(BaseMessage.SendingStatus.FAILED);
                        fileMessage.mErrorCode = SendBirdError.ERR_CONNECTION_REQUIRED;
                        Object obj = obj6;
                        if (obj instanceof SendFileMessageWithProgressHandler) {
                            ((SendFileMessageWithProgressHandler) obj).onSent(fileMessage, new SendBirdException("Connection must be made before you send message.", SendBirdError.ERR_CONNECTION_REQUIRED));
                        } else if (obj instanceof SendFileMessagesWithProgressHandler) {
                            ((SendFileMessagesWithProgressHandler) obj).onSent(fileMessage, new SendBirdException("Connection must be made before you send message.", SendBirdError.ERR_CONNECTION_REQUIRED));
                        }
                    }
                });
            }
            fileMessage.setSendingStatus(BaseMessage.SendingStatus.PENDING);
            return fileMessage;
        }
        fileMessage.setSendingStatus(BaseMessage.SendingStatus.PENDING);
        return fileMessage;
    }

    private FileMessage localSendFileMessage(String str, long j, long j2, Object obj, String str2, String str3, Integer num, String str4, String str5, List<FileMessage.ThumbnailSize> list, BaseMessageParams.MentionType mentionType, List<String> list2, BaseMessageParams.PushNotificationDeliveryOption pushNotificationDeliveryOption, List<MessageMetaArray> list3, Object obj2, Object obj3, FileMessage fileMessage, boolean z) {
        FileMessage fileMessage2;
        final b bVar;
        final Object obj4;
        b bVar2;
        BaseChannel baseChannel = this;
        Object obj5 = obj;
        Object obj6 = obj3;
        if (fileMessage != null) {
            fileMessage2 = fileMessage;
        } else {
            FileMessage localCreateFileMessage = localCreateFileMessage(str, j, j2, obj, str2, str3, num, str4, str5, list, mentionType, list2, pushNotificationDeliveryOption, list3, obj2, obj3);
            if (localCreateFileMessage == null) {
                return null;
            }
            if (SendBird.getCurrentUser() == null) {
                return localCreateFileMessage;
            }
            fileMessage2 = localCreateFileMessage;
        }
        if (obj5 instanceof String) {
            String str6 = (String) obj5;
            if (z) {
                b bVar3 = r1;
                b bVar4 = new b(this, true, fileMessage2.getRequestId(), fileMessage2.getRootMessageId(), fileMessage2.getParentMessageId(), str6, fileMessage2, str4, str5, mentionType, list2, pushNotificationDeliveryOption, list3, obj2, obj3);
                synchronized (this.mSendFileMessageDataList) {
                    this.mSendFileMessageDataList.add(bVar3);
                }
                localDoSendFileMessageWithOrder();
            } else {
                localDoSendFileMessage(str6, fileMessage2, str4, str5, (String) null, false, mentionType, list2, pushNotificationDeliveryOption, list3, obj2, obj3);
            }
        } else if (obj5 instanceof File) {
            File file = (File) obj5;
            if (z) {
                b bVar5 = r1;
                b bVar6 = new b(this, false, fileMessage2.getRequestId(), fileMessage2.getRootMessageId(), fileMessage2.getParentMessageId(), (String) null, fileMessage2, str4, str5, mentionType, list2, pushNotificationDeliveryOption, list3, obj2, obj3);
                baseChannel = this;
                synchronized (baseChannel.mSendFileMessageDataList) {
                    bVar2 = bVar5;
                    baseChannel.mSendFileMessageDataList.add(bVar2);
                }
                obj4 = obj3;
                bVar = bVar2;
            } else {
                obj4 = obj3;
                bVar = null;
            }
            final AnonymousClass8 r7 = obj4 != null ? new APIClient.APIClientProgressHandler() {
                public final void onProgress(String str, long j, long j2, long j3) {
                    final long j4 = j;
                    final long j5 = j2;
                    final long j6 = j3;
                    final String str2 = str;
                    SendBird.runOnUIThread(new Runnable() {
                        public final void run() {
                            if (obj4 instanceof SendFileMessageWithProgressHandler) {
                                ((SendFileMessageWithProgressHandler) obj4).onProgress((int) j4, (int) j5, (int) j6);
                            } else if (obj4 instanceof SendFileMessagesWithProgressHandler) {
                                ((SendFileMessagesWithProgressHandler) obj4).onProgress(str2, (int) j4, (int) j5, (int) j6);
                            }
                        }
                    });
                }
            } : null;
            final File file2 = file;
            final String str7 = str3;
            final List<FileMessage.ThumbnailSize> list4 = list;
            final FileMessage fileMessage3 = fileMessage2;
            final Object obj7 = obj2;
            final Object obj8 = obj3;
            final boolean z2 = z;
            final String str8 = str4;
            final String str9 = str5;
            final BaseMessageParams.MentionType mentionType2 = mentionType;
            final List<String> list5 = list2;
            final BaseMessageParams.PushNotificationDeliveryOption pushNotificationDeliveryOption2 = pushNotificationDeliveryOption;
            final List<MessageMetaArray> list6 = list3;
            d.a(new q<JsonElement>(this) {
                final /* synthetic */ BaseChannel p;

                {
                    this.p = r3;
                }

                public final /* synthetic */ void a(Object obj, SendBirdException sendBirdException) {
                    BaseMessage.SendingStatus sendingStatus;
                    JsonElement jsonElement = (JsonElement) obj;
                    if (sendBirdException != null) {
                        if (sendBirdException.getCode() == 800240) {
                            sendingStatus = BaseMessage.SendingStatus.CANCELED;
                        } else {
                            sendingStatus = BaseMessage.SendingStatus.FAILED;
                        }
                        FileMessage fileMessage = new FileMessage(fileMessage3.toJson());
                        fileMessage.mCreatedAt = fileMessage3.getCreatedAt();
                        fileMessage.setSendingStatus(sendingStatus);
                        fileMessage.mErrorCode = sendBirdException.getCode();
                        Object obj2 = obj7;
                        if (obj2 == null) {
                            Object obj3 = obj8;
                            if (obj3 != null) {
                                if (obj3 instanceof SendFileMessageWithProgressHandler) {
                                    ((SendFileMessageWithProgressHandler) obj3).onSent(fileMessage, sendBirdException);
                                } else if (obj3 instanceof SendFileMessagesWithProgressHandler) {
                                    ((SendFileMessagesWithProgressHandler) obj3).onSent(fileMessage, sendBirdException);
                                }
                            }
                        } else if (obj2 instanceof SendFileMessageHandler) {
                            ((SendFileMessageHandler) obj2).onSent(fileMessage, sendBirdException);
                        } else if (obj2 instanceof SendFileMessagesHandler) {
                            ((SendFileMessagesHandler) obj2).onSent(fileMessage, sendBirdException);
                        }
                        synchronized (this.p.mSendFileMessageDataList) {
                            this.p.mSendFileMessageDataList.remove(bVar);
                        }
                        this.p.localDoSendFileMessageWithOrder();
                        return;
                    }
                    JsonObject asJsonObject = jsonElement.getAsJsonObject();
                    String asString = asJsonObject.get("url").getAsString();
                    String jsonElement2 = asJsonObject.has("thumbnails") ? asJsonObject.get("thumbnails").toString() : null;
                    boolean z = asJsonObject.has("require_auth") && asJsonObject.get("require_auth").getAsBoolean();
                    if (z2) {
                        b bVar = bVar;
                        bVar.f44197a = true;
                        bVar.f44201e = asString;
                        bVar.f44205i = jsonElement2;
                        bVar.j = z;
                        this.p.localDoSendFileMessageWithOrder();
                        return;
                    }
                    this.p.localDoSendFileMessage(asString, fileMessage3, str8, str9, jsonElement2, z, mentionType2, list5, pushNotificationDeliveryOption2, list6, obj7, obj8);
                }

                public final /* synthetic */ Object call() throws Exception {
                    return APIClient.a().a(b.STORAGE_FILE.publicUrl(), file2, str7, list4, this.p.getUrl(), fileMessage3.getRequestId(), r7);
                }
            });
        }
        return fileMessage2;
    }

    /* access modifiers changed from: private */
    public void localDoSendFileMessageWithOrder() {
        final b bVar;
        b peek;
        if (!this.mIsSendingFileMessage) {
            this.mIsSendingFileMessage = true;
            synchronized (this.mSendFileMessageDataList) {
                bVar = null;
                if (this.mSendFileMessageDataList.size() > 0 && (peek = this.mSendFileMessageDataList.peek()) != null && peek.f44197a) {
                    this.mSendFileMessageDataList.remove(peek);
                    bVar = peek;
                }
            }
            if (bVar == null) {
                this.mIsSendingFileMessage = false;
            } else {
                localDoSendFileMessage(bVar, new SendFileMessageHandler() {
                    public final void onSent(final FileMessage fileMessage, SendBirdException sendBirdException) {
                        final Object obj = bVar.o;
                        final Object obj2 = bVar.p;
                        if (sendBirdException != null) {
                            final FileMessage fileMessage2 = new FileMessage(bVar.f44202f.toJson());
                            fileMessage2.mCreatedAt = bVar.f44202f.getCreatedAt();
                            fileMessage2.setSendingStatus(BaseMessage.SendingStatus.FAILED);
                            fileMessage2.mErrorCode = sendBirdException.getCode();
                            final SendBirdException sendBirdException2 = sendBirdException;
                            SendBird.runOnUIThread(new Runnable() {
                                public final void run() {
                                    Object obj = obj;
                                    if (obj == null) {
                                        Object obj2 = obj2;
                                        if (obj2 == null) {
                                            return;
                                        }
                                        if (obj2 instanceof SendFileMessageWithProgressHandler) {
                                            ((SendFileMessageWithProgressHandler) obj2).onSent(fileMessage2, sendBirdException2);
                                        } else if (obj2 instanceof SendFileMessagesWithProgressHandler) {
                                            ((SendFileMessagesWithProgressHandler) obj2).onSent(fileMessage2, sendBirdException2);
                                        }
                                    } else if (obj instanceof SendFileMessageHandler) {
                                        ((SendFileMessageHandler) obj).onSent(fileMessage2, sendBirdException2);
                                    } else if (obj instanceof SendFileMessagesHandler) {
                                        ((SendFileMessagesHandler) obj).onSent(fileMessage2, sendBirdException2);
                                    }
                                }
                            });
                            boolean unused = BaseChannel.this.mIsSendingFileMessage = false;
                            BaseChannel.this.localDoSendFileMessageWithOrder();
                            return;
                        }
                        SendBird.runOnUIThread(new Runnable() {
                            public final void run() {
                                Object obj = obj;
                                if (obj == null) {
                                    Object obj2 = obj2;
                                    if (obj2 == null) {
                                        return;
                                    }
                                    if (obj2 instanceof SendFileMessageWithProgressHandler) {
                                        ((SendFileMessageWithProgressHandler) obj2).onSent(fileMessage, (SendBirdException) null);
                                    } else if (obj2 instanceof SendFileMessagesWithProgressHandler) {
                                        ((SendFileMessagesWithProgressHandler) obj2).onSent(fileMessage, (SendBirdException) null);
                                    }
                                } else if (obj instanceof SendFileMessageHandler) {
                                    ((SendFileMessageHandler) obj).onSent(fileMessage, (SendBirdException) null);
                                } else if (obj instanceof SendFileMessagesHandler) {
                                    ((SendFileMessagesHandler) obj).onSent(fileMessage, (SendBirdException) null);
                                }
                            }
                        });
                        boolean unused2 = BaseChannel.this.mIsSendingFileMessage = false;
                        BaseChannel.this.localDoSendFileMessageWithOrder();
                    }
                });
            }
        }
    }

    private void localDoSendFileMessage(b bVar, SendFileMessageHandler sendFileMessageHandler) {
        localDoSendFileMessage(bVar.f44201e, bVar.f44202f, bVar.f44203g, bVar.f44204h, bVar.f44205i, bVar.j, bVar.k, bVar.l, bVar.m, bVar.n, sendFileMessageHandler, bVar.p);
    }

    /* access modifiers changed from: private */
    public void localDoSendFileMessage(String str, FileMessage fileMessage, String str2, String str3, String str4, boolean z, BaseMessageParams.MentionType mentionType, List<String> list, BaseMessageParams.PushNotificationDeliveryOption pushNotificationDeliveryOption, List<MessageMetaArray> list2, Object obj, Object obj2) {
        if (SendBird.getConnectionState() == SendBird.ConnectionState.OPEN) {
            String requestId = fileMessage.getRequestId();
            fileMessage.getRootMessageId();
            Command a2 = Command.a(requestId, fileMessage.getParentMessageId(), getUrl(), str, fileMessage.getName(), fileMessage.getType(), fileMessage.getSize(), str2, str3, str4, z, mentionType, list, pushNotificationDeliveryOption, list2);
            final FileMessage fileMessage2 = fileMessage;
            final Object obj3 = obj;
            final Object obj4 = obj2;
            SendBird.getInstance().sendCommand(a2, true, new Command.SendCommandHandler() {
                public final void onResult(final Command command, final SendBirdException sendBirdException) {
                    SendBird.runOnUIThread(new Runnable() {
                        public final void run() {
                            if (sendBirdException != null) {
                                FileMessage fileMessage = new FileMessage(fileMessage2.toJson());
                                fileMessage.mCreatedAt = fileMessage2.getCreatedAt();
                                fileMessage.setSendingStatus(BaseMessage.SendingStatus.FAILED);
                                fileMessage.mErrorCode = sendBirdException.getCode();
                                if (obj3 != null) {
                                    if (obj3 instanceof SendFileMessageHandler) {
                                        ((SendFileMessageHandler) obj3).onSent(fileMessage, sendBirdException);
                                    } else if (obj3 instanceof SendFileMessagesHandler) {
                                        ((SendFileMessagesHandler) obj3).onSent(fileMessage, sendBirdException);
                                    }
                                } else if (obj4 == null) {
                                } else {
                                    if (obj4 instanceof SendFileMessageWithProgressHandler) {
                                        ((SendFileMessageWithProgressHandler) obj4).onSent(fileMessage, sendBirdException);
                                    } else if (obj4 instanceof SendFileMessagesWithProgressHandler) {
                                        ((SendFileMessagesWithProgressHandler) obj4).onSent(fileMessage, sendBirdException);
                                    }
                                }
                            } else {
                                FileMessage fileMessage2 = new FileMessage(command.c());
                                fileMessage2.setSendingStatus(BaseMessage.SendingStatus.SUCCEEDED);
                                if (obj3 != null) {
                                    if (obj3 instanceof SendFileMessageHandler) {
                                        ((SendFileMessageHandler) obj3).onSent(fileMessage2, (SendBirdException) null);
                                    } else if (obj3 instanceof SendFileMessagesHandler) {
                                        ((SendFileMessagesHandler) obj3).onSent(fileMessage2, (SendBirdException) null);
                                    }
                                } else if (obj4 == null) {
                                } else {
                                    if (obj4 instanceof SendFileMessageWithProgressHandler) {
                                        ((SendFileMessageWithProgressHandler) obj4).onSent(fileMessage2, (SendBirdException) null);
                                    } else if (obj4 instanceof SendFileMessagesWithProgressHandler) {
                                        ((SendFileMessagesWithProgressHandler) obj4).onSent(fileMessage2, (SendBirdException) null);
                                    }
                                }
                            }
                        }
                    });
                }
            });
            return;
        }
        final FileMessage fileMessage3 = fileMessage;
        Object obj5 = obj;
        Object obj6 = obj2;
        final String str5 = str;
        final String str6 = str3;
        final String str7 = str2;
        final String str8 = str4;
        final boolean z2 = z;
        final BaseMessageParams.MentionType mentionType2 = mentionType;
        final List<String> list3 = list;
        final BaseMessageParams.PushNotificationDeliveryOption pushNotificationDeliveryOption2 = pushNotificationDeliveryOption;
        final List<MessageMetaArray> list4 = list2;
        final Object obj7 = obj;
        final Object obj8 = obj2;
        d.a(new q<FileMessage>() {
            public final /* synthetic */ void a(Object obj, SendBirdException sendBirdException) {
                FileMessage fileMessage = (FileMessage) obj;
                if (sendBirdException != null) {
                    fileMessage = new FileMessage(fileMessage3.toJson());
                    fileMessage.mCreatedAt = fileMessage3.getCreatedAt();
                    fileMessage.setSendingStatus(BaseMessage.SendingStatus.FAILED);
                    fileMessage.mErrorCode = sendBirdException.getCode();
                }
                Object obj2 = obj7;
                if (obj2 == null) {
                    Object obj3 = obj8;
                    if (obj3 == null) {
                        return;
                    }
                    if (obj3 instanceof SendFileMessageWithProgressHandler) {
                        ((SendFileMessageWithProgressHandler) obj3).onSent(fileMessage, sendBirdException);
                    } else if (obj3 instanceof SendFileMessagesWithProgressHandler) {
                        ((SendFileMessagesWithProgressHandler) obj3).onSent(fileMessage, sendBirdException);
                    }
                } else if (obj2 instanceof SendFileMessageHandler) {
                    ((SendFileMessageHandler) obj2).onSent(fileMessage, sendBirdException);
                } else if (obj2 instanceof SendFileMessagesHandler) {
                    ((SendFileMessagesHandler) obj2).onSent(fileMessage, sendBirdException);
                }
            }

            public final /* synthetic */ Object call() throws Exception {
                APIClient a2 = APIClient.a();
                boolean isOpenChannel = BaseChannel.this.isOpenChannel();
                fileMessage3.getRootMessageId();
                APIClient aPIClient = a2;
                JsonObject asJsonObject = aPIClient.a(isOpenChannel, fileMessage3.getParentMessageId(), BaseChannel.this.getUrl(), str5, fileMessage3.getName(), fileMessage3.getSize(), fileMessage3.getType(), str6, str7, str8, z2, mentionType2, list3, pushNotificationDeliveryOption2, list4).getAsJsonObject();
                asJsonObject.addProperty("req_id", fileMessage3.getRequestId());
                FileMessage fileMessage = (FileMessage) BaseMessage.build(asJsonObject, BaseChannel.this.getUrl(), BaseChannel.this.getType());
                if (fileMessage != null) {
                    fileMessage.setSendingStatus(BaseMessage.SendingStatus.SUCCEEDED);
                }
                return fileMessage;
            }
        });
    }

    private void localSendFileMessages(List<FileMessageParams> list, List<FileMessage> list2, SendFileMessagesHandler sendFileMessagesHandler, SendFileMessagesWithProgressHandler sendFileMessagesWithProgressHandler) {
        List<FileMessageParams> list3 = list;
        List<FileMessage> list4 = list2;
        final LinkedList linkedList = new LinkedList();
        for (int i2 = 0; i2 < list.size(); i2++) {
            FileMessageParams fileMessageParams = list3.get(i2);
            FileMessage fileMessage = list4.get(i2);
            if (!(fileMessageParams == null || fileMessage == null)) {
                linkedList.add(fileMessage.getRequestId());
            }
        }
        for (int i3 = 0; i3 < list.size(); i3++) {
            FileMessageParams fileMessageParams2 = list3.get(i3);
            FileMessage fileMessage2 = list4.get(i3);
            if (fileMessageParams2 != null && fileMessage2 != null) {
                long j = fileMessageParams2.rootMessageId;
                long j2 = fileMessageParams2.parentMessageId;
                Object obj = fileMessageParams2.mFileUrlOrFile;
                String name = fileMessage2.getName();
                String type = fileMessage2.getType();
                Integer valueOf = Integer.valueOf(fileMessage2.getSize());
                String str = fileMessageParams2.mData;
                String str2 = fileMessageParams2.mCustomType;
                List<FileMessage.ThumbnailSize> list5 = fileMessageParams2.mThumbnailSizes;
                BaseMessageParams.MentionType mentionType = fileMessageParams2.mMentionType;
                List list6 = fileMessageParams2.mMentionedUserIds;
                BaseMessageParams.PushNotificationDeliveryOption pushNotificationDeliveryOption = fileMessageParams2.mPushNotificationDeliveryOption;
                List list7 = fileMessageParams2.mMetaArrays;
                AnonymousClass14 r24 = r4;
                final SendFileMessagesHandler sendFileMessagesHandler2 = sendFileMessagesHandler;
                final SendFileMessagesWithProgressHandler sendFileMessagesWithProgressHandler2 = sendFileMessagesWithProgressHandler;
                AnonymousClass14 r4 = new SendFileMessagesWithProgressHandler() {
                    public final void onResult(SendBirdException sendBirdException) {
                    }

                    public final void onProgress(String str, int i2, int i3, int i4) {
                        SendFileMessagesWithProgressHandler sendFileMessagesWithProgressHandler = sendFileMessagesWithProgressHandler2;
                        if (sendFileMessagesWithProgressHandler != null) {
                            sendFileMessagesWithProgressHandler.onProgress(str, i2, i3, i4);
                        }
                    }

                    public final void onSent(FileMessage fileMessage, SendBirdException sendBirdException) {
                        SendFileMessagesHandler sendFileMessagesHandler = sendFileMessagesHandler2;
                        if (sendFileMessagesHandler != null) {
                            sendFileMessagesHandler.onSent(fileMessage, sendBirdException);
                        } else {
                            SendFileMessagesWithProgressHandler sendFileMessagesWithProgressHandler = sendFileMessagesWithProgressHandler2;
                            if (sendFileMessagesWithProgressHandler != null) {
                                sendFileMessagesWithProgressHandler.onSent(fileMessage, sendBirdException);
                            }
                        }
                        if (fileMessage != null && linkedList.remove(fileMessage.getRequestId()) && linkedList.size() == 0) {
                            SendFileMessagesHandler sendFileMessagesHandler2 = sendFileMessagesHandler2;
                            if (sendFileMessagesHandler2 != null) {
                                sendFileMessagesHandler2.onResult((SendBirdException) null);
                                return;
                            }
                            SendFileMessagesWithProgressHandler sendFileMessagesWithProgressHandler2 = sendFileMessagesWithProgressHandler2;
                            if (sendFileMessagesWithProgressHandler2 != null) {
                                sendFileMessagesWithProgressHandler2.onResult((SendBirdException) null);
                            }
                        }
                    }
                };
                localSendFileMessage((String) null, j, j2, obj, name, type, valueOf, str, str2, list5, mentionType, list6, pushNotificationDeliveryOption, list7, (Object) null, r24, fileMessage2, true);
            }
        }
    }

    public UserMessage sendUserMessage(String str, SendUserMessageHandler sendUserMessageHandler) {
        return sendUserMessage(str, (String) null, (String) null, sendUserMessageHandler);
    }

    @Deprecated
    public UserMessage sendUserMessage(String str, String str2, SendUserMessageHandler sendUserMessageHandler) {
        return sendUserMessage(str, str2, (String) null, (List<String>) null, sendUserMessageHandler);
    }

    @Deprecated
    public UserMessage sendUserMessage(String str, String str2, String str3, SendUserMessageHandler sendUserMessageHandler) {
        return sendUserMessage(str, str2, str3, (List<String>) null, sendUserMessageHandler);
    }

    public UserMessage sendUserMessage(String str, String str2, String str3, List<String> list, SendUserMessageHandler sendUserMessageHandler) {
        return localSendUserMessage((String) null, 0, 0, str, str2, str3, list, (BaseMessageParams.MentionType) null, (List<String>) null, (BaseMessageParams.PushNotificationDeliveryOption) null, (List<MessageMetaArray>) null, sendUserMessageHandler);
    }

    public UserMessage sendUserMessage(UserMessageParams userMessageParams, SendUserMessageHandler sendUserMessageHandler) {
        UserMessageParams userMessageParams2 = userMessageParams;
        final SendUserMessageHandler sendUserMessageHandler2 = sendUserMessageHandler;
        if (userMessageParams2 != null) {
            return localSendUserMessage((String) null, userMessageParams2.rootMessageId, userMessageParams2.parentMessageId, userMessageParams2.mMessage, userMessageParams2.mData, userMessageParams2.mCustomType, userMessageParams2.mTargetLanguages, userMessageParams2.mMentionType, userMessageParams2.mMentionedUserIds, userMessageParams2.mPushNotificationDeliveryOption, userMessageParams2.mMetaArrays, sendUserMessageHandler);
        } else if (sendUserMessageHandler2 != null) {
            SendBird.runOnUIThread(new Runnable() {
                public final void run() {
                    sendUserMessageHandler2.onSent((UserMessage) null, new SendBirdException("Invalid arguments.", SendBirdError.ERR_INVALID_PARAMETER));
                }
            });
            return null;
        } else {
            return null;
        }
    }

    private UserMessage localSendUserMessage(String str, long j, long j2, String str2, String str3, String str4, List<String> list, BaseMessageParams.MentionType mentionType, List<String> list2, BaseMessageParams.PushNotificationDeliveryOption pushNotificationDeliveryOption, List<MessageMetaArray> list3, SendUserMessageHandler sendUserMessageHandler) {
        String str5;
        final SendUserMessageHandler sendUserMessageHandler2 = sendUserMessageHandler;
        String str6 = str2 == null ? "" : str2;
        JsonObject jsonObject = new JsonObject();
        JsonObject jsonObject2 = new JsonObject();
        if (list != null) {
            for (String addProperty : list) {
                jsonObject2.addProperty(addProperty, "");
            }
        }
        jsonObject.add("translations", jsonObject2);
        String str7 = null;
        if (list3 != null && list3.size() > 0) {
            JsonArray jsonArray = new JsonArray();
            for (MessageMetaArray json : list3) {
                jsonArray.add((JsonElement) json.toJson());
            }
            str7 = jsonArray.toString();
        }
        String str8 = str7;
        if (str == null || str.length() <= 0) {
            str5 = Command.a();
        } else {
            str5 = str;
        }
        final UserMessage userMessage = new UserMessage(UserMessage.build(str5, BaseMessage.SendingStatus.NONE, 0, j, j2, Sender.toSender(SendBird.getCurrentUser(), getCurrentUserRole()), getUrl(), getType(), str6, str3, str4, jsonObject.get("translations").toString(), System.currentTimeMillis(), 0, mentionType, list2, (String) null, (String) null, (String) null, (String) null, str8, false, 0, false, false, -1, (String) null, new ThreadInfo(), (OGMetaData) null, getCurrentUserRole() == Member.Role.OPERATOR));
        if (SendBird.getCurrentUser() == null) {
            if (sendUserMessageHandler2 != null) {
                SendBird.runOnUIThread(new Runnable() {
                    public final void run() {
                        UserMessage userMessage = new UserMessage(userMessage.toJson());
                        userMessage.mCreatedAt = userMessage.getCreatedAt();
                        userMessage.setSendingStatus(BaseMessage.SendingStatus.FAILED);
                        userMessage.mErrorCode = SendBirdError.ERR_CONNECTION_REQUIRED;
                        sendUserMessageHandler2.onSent(userMessage, new SendBirdException("Connection must be made before you send message.", SendBirdError.ERR_CONNECTION_REQUIRED));
                    }
                });
            }
            userMessage.setSendingStatus(BaseMessage.SendingStatus.PENDING);
            return userMessage;
        }
        SendBird.getInstance().sendCommand(Command.a(userMessage.getRequestId(), j2, getUrl(), str6, str3, str4, mentionType, list2, pushNotificationDeliveryOption, list3, list), true, new Command.SendCommandHandler() {
            public final void onResult(final Command command, final SendBirdException sendBirdException) {
                SendBird.runOnUIThread(new Runnable() {
                    public final void run() {
                        if (sendBirdException != null) {
                            if (sendUserMessageHandler2 != null) {
                                UserMessage userMessage = new UserMessage(userMessage.toJson());
                                userMessage.mCreatedAt = userMessage.getCreatedAt();
                                userMessage.setSendingStatus(BaseMessage.SendingStatus.FAILED);
                                userMessage.mErrorCode = sendBirdException.getCode();
                                sendUserMessageHandler2.onSent(userMessage, sendBirdException);
                            }
                        } else if (sendUserMessageHandler2 != null) {
                            UserMessage userMessage2 = new UserMessage(command.c());
                            userMessage2.setSendingStatus(BaseMessage.SendingStatus.SUCCEEDED);
                            sendUserMessageHandler2.onSent(userMessage2, (SendBirdException) null);
                        }
                    }
                });
            }
        });
        userMessage.setSendingStatus(BaseMessage.SendingStatus.PENDING);
        return userMessage;
    }

    public UserMessage resendMessage(UserMessage userMessage, ResendUserMessageHandler resendUserMessageHandler) {
        return localResendUserMessage(userMessage, resendUserMessageHandler);
    }

    private UserMessage localResendUserMessage(UserMessage userMessage, ResendUserMessageHandler resendUserMessageHandler) {
        UserMessage userMessage2 = userMessage;
        final ResendUserMessageHandler resendUserMessageHandler2 = resendUserMessageHandler;
        if (userMessage2 == null || userMessage2.mMessageId > 0 || !userMessage.isResendable()) {
            if (resendUserMessageHandler2 != null) {
                SendBird.runOnUIThread(new Runnable() {
                    public final void run() {
                        resendUserMessageHandler2.onSent((UserMessage) null, new SendBirdException("Invalid arguments.", SendBirdError.ERR_INVALID_PARAMETER));
                    }
                });
            }
            return userMessage2;
        }
        if (userMessage.getSender() == null) {
            userMessage2.mSender = Sender.toSender(SendBird.getCurrentUser(), getCurrentUserRole());
            if (userMessage.getSender() != null) {
                userMessage2.setIsOperatorMessage(userMessage.getSender().getRole() == Member.Role.OPERATOR);
            }
        }
        if (!getUrl().equals(userMessage.getChannelUrl())) {
            if (resendUserMessageHandler2 != null) {
                SendBird.runOnUIThread(new Runnable() {
                    public final void run() {
                        resendUserMessageHandler2.onSent((UserMessage) null, new SendBirdException("The message does not belong to this channel.", SendBirdError.ERR_INVALID_PARAMETER));
                    }
                });
            }
            return userMessage2;
        }
        Map<String, String> translations = userMessage.getTranslations();
        return localSendUserMessage(userMessage.getRequestId(), userMessage.getRootMessageId(), userMessage.getParentMessageId(), userMessage.getMessage(), userMessage.getData(), userMessage.getCustomType(), (translations == null || translations.size() <= 0) ? null : new ArrayList(translations.keySet()), userMessage.getMentionType(), (userMessage.getMentionedUserIds() == null || userMessage.getMentionedUserIds().size() <= 0) ? null : new ArrayList(userMessage.getMentionedUserIds()), (BaseMessageParams.PushNotificationDeliveryOption) null, (userMessage.getAllMetaArrays() == null || userMessage.getAllMetaArrays().size() <= 0) ? null : new ArrayList(userMessage.getAllMetaArrays()), new SendUserMessageHandler() {
            public final void onSent(UserMessage userMessage, SendBirdException sendBirdException) {
                ResendUserMessageHandler resendUserMessageHandler = resendUserMessageHandler2;
                if (resendUserMessageHandler != null) {
                    resendUserMessageHandler.onSent(userMessage, sendBirdException);
                }
            }
        });
    }

    public FileMessage resendMessage(FileMessage fileMessage, File file, ResendFileMessageHandler resendFileMessageHandler) {
        return localResendFileMessage(fileMessage, file, resendFileMessageHandler);
    }

    public FileMessage resendMessage(FileMessage fileMessage, File file, ResendFileMessageWithProgressHandler resendFileMessageWithProgressHandler) {
        return localResendFileMessage(fileMessage, file, resendFileMessageWithProgressHandler);
    }

    public void resendFileMessage(FileMessage fileMessage, File file, ResendFileMessageHandler resendFileMessageHandler) {
        localResendFileMessage(fileMessage, file, resendFileMessageHandler);
    }

    public void resendFileMessage(FileMessage fileMessage, File file, ResendFileMessageWithProgressHandler resendFileMessageWithProgressHandler) {
        localResendFileMessage(fileMessage, file, resendFileMessageWithProgressHandler);
    }

    /* JADX WARNING: Removed duplicated region for block: B:42:0x00af  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00d9  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00ea  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00f6  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x0108  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x0114  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.sendbird.android.FileMessage localResendFileMessage(com.sendbird.android.FileMessage r23, java.io.File r24, java.lang.Object r25) {
        /*
            r22 = this;
            r14 = r22
            r0 = r23
            r1 = r25
            if (r0 == 0) goto L_0x014e
            long r2 = r0.mMessageId
            r4 = 0
            int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r6 > 0) goto L_0x014e
            boolean r2 = r23.isResendable()
            if (r2 != 0) goto L_0x0018
            goto L_0x014e
        L_0x0018:
            com.sendbird.android.Sender r2 = r23.getSender()
            if (r2 != 0) goto L_0x0044
            com.sendbird.android.User r2 = com.sendbird.android.SendBird.getCurrentUser()
            com.sendbird.android.Member$Role r3 = r22.getCurrentUserRole()
            com.sendbird.android.Sender r2 = com.sendbird.android.Sender.toSender(r2, r3)
            r0.mSender = r2
            com.sendbird.android.Sender r2 = r23.getSender()
            if (r2 == 0) goto L_0x0044
            com.sendbird.android.Sender r2 = r23.getSender()
            com.sendbird.android.Member$Role r2 = r2.getRole()
            com.sendbird.android.Member$Role r3 = com.sendbird.android.Member.Role.OPERATOR
            if (r2 != r3) goto L_0x0040
            r2 = 1
            goto L_0x0041
        L_0x0040:
            r2 = 0
        L_0x0041:
            r0.setIsOperatorMessage(r2)
        L_0x0044:
            java.lang.String r2 = r22.getUrl()
            java.lang.String r3 = r23.getChannelUrl()
            boolean r2 = r2.equals(r3)
            if (r2 != 0) goto L_0x005d
            if (r1 == 0) goto L_0x005c
            com.sendbird.android.BaseChannel$22 r2 = new com.sendbird.android.BaseChannel$22
            r2.<init>(r1)
            com.sendbird.android.SendBird.runOnUIThread(r2)
        L_0x005c:
            return r0
        L_0x005d:
            java.lang.String r2 = r23.getUrl()
            r3 = 0
            if (r2 == 0) goto L_0x0074
            java.lang.String r2 = r23.getUrl()
            int r2 = r2.length()
            if (r2 <= 0) goto L_0x0074
            java.lang.String r2 = r23.getUrl()
            r6 = r2
            goto L_0x007a
        L_0x0074:
            if (r24 == 0) goto L_0x0079
            r6 = r24
            goto L_0x007a
        L_0x0079:
            r6 = r3
        L_0x007a:
            if (r6 != 0) goto L_0x0087
            if (r1 == 0) goto L_0x0086
            com.sendbird.android.BaseChannel$24 r2 = new com.sendbird.android.BaseChannel$24
            r2.<init>(r1)
            com.sendbird.android.SendBird.runOnUIThread(r2)
        L_0x0086:
            return r0
        L_0x0087:
            if (r1 == 0) goto L_0x00a5
            boolean r2 = r1 instanceof com.sendbird.android.BaseChannel.ResendFileMessageHandler
            if (r2 == 0) goto L_0x0097
            com.sendbird.android.BaseChannel$25 r2 = new com.sendbird.android.BaseChannel$25
            r2.<init>(r1)
            r17 = r2
            r18 = r3
            goto L_0x00a9
        L_0x0097:
            boolean r2 = r1 instanceof com.sendbird.android.BaseChannel.ResendFileMessageWithProgressHandler
            if (r2 == 0) goto L_0x00a5
            com.sendbird.android.BaseChannel$26 r2 = new com.sendbird.android.BaseChannel$26
            r2.<init>(r1)
            r18 = r2
            r17 = r3
            goto L_0x00a9
        L_0x00a5:
            r17 = r3
            r18 = r17
        L_0x00a9:
            java.util.List r1 = r23.getThumbnails()
            if (r1 == 0) goto L_0x00d9
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            java.util.Iterator r1 = r1.iterator()
        L_0x00b8:
            boolean r4 = r1.hasNext()
            if (r4 == 0) goto L_0x00d7
            java.lang.Object r4 = r1.next()
            com.sendbird.android.FileMessage$Thumbnail r4 = (com.sendbird.android.FileMessage.Thumbnail) r4
            if (r4 == 0) goto L_0x00b8
            com.sendbird.android.FileMessage$ThumbnailSize r5 = new com.sendbird.android.FileMessage$ThumbnailSize
            int r7 = r4.getMaxWidth()
            int r4 = r4.getMaxHeight()
            r5.<init>(r7, r4)
            r2.add(r5)
            goto L_0x00b8
        L_0x00d7:
            r12 = r2
            goto L_0x00da
        L_0x00d9:
            r12 = r3
        L_0x00da:
            java.util.List r1 = r23.getMentionedUserIds()
            if (r1 == 0) goto L_0x00f6
            java.util.List r1 = r23.getMentionedUserIds()
            int r1 = r1.size()
            if (r1 <= 0) goto L_0x00f6
            java.util.ArrayList r1 = new java.util.ArrayList
            java.util.List r2 = r23.getMentionedUserIds()
            r1.<init>(r2)
            r16 = r1
            goto L_0x00f8
        L_0x00f6:
            r16 = r3
        L_0x00f8:
            java.util.List r1 = r23.getAllMetaArrays()
            if (r1 == 0) goto L_0x0114
            java.util.List r1 = r23.getAllMetaArrays()
            int r1 = r1.size()
            if (r1 <= 0) goto L_0x0114
            java.util.ArrayList r1 = new java.util.ArrayList
            java.util.List r2 = r23.getAllMetaArrays()
            r1.<init>(r2)
            r21 = r1
            goto L_0x0116
        L_0x0114:
            r21 = r3
        L_0x0116:
            java.lang.String r1 = r23.getRequestId()
            long r2 = r23.getRootMessageId()
            long r4 = r23.getParentMessageId()
            java.lang.String r7 = r23.getName()
            java.lang.String r8 = r23.getType()
            int r9 = r23.getSize()
            java.lang.Integer r9 = java.lang.Integer.valueOf(r9)
            java.lang.String r10 = r23.getData()
            java.lang.String r11 = r23.getCustomType()
            com.sendbird.android.BaseMessageParams$MentionType r13 = r23.getMentionType()
            r15 = 0
            r19 = 0
            r20 = 1
            r0 = r22
            r14 = r16
            r16 = r21
            com.sendbird.android.FileMessage r0 = r0.localSendFileMessage(r1, r2, r4, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20)
            return r0
        L_0x014e:
            if (r1 == 0) goto L_0x015b
            com.sendbird.android.BaseChannel$21 r2 = new com.sendbird.android.BaseChannel$21
            r3 = r22
            r2.<init>(r1)
            com.sendbird.android.SendBird.runOnUIThread(r2)
            goto L_0x015d
        L_0x015b:
            r3 = r22
        L_0x015d:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sendbird.android.BaseChannel.localResendFileMessage(com.sendbird.android.FileMessage, java.io.File, java.lang.Object):com.sendbird.android.FileMessage");
    }

    public void resendUserMessage(UserMessage userMessage, ResendUserMessageHandler resendUserMessageHandler) {
        localResendUserMessage(userMessage, resendUserMessageHandler);
    }

    public void translateUserMessage(final UserMessage userMessage, final List<String> list, final TranslateUserMessageHandler translateUserMessageHandler) {
        d.a(new q<UserMessage>() {
            public final /* synthetic */ void a(Object obj, SendBirdException sendBirdException) {
                UserMessage userMessage = (UserMessage) obj;
                TranslateUserMessageHandler translateUserMessageHandler = translateUserMessageHandler;
                if (translateUserMessageHandler != null) {
                    translateUserMessageHandler.onTranslated(userMessage, sendBirdException);
                }
            }

            public final /* synthetic */ Object call() throws Exception {
                List list;
                String str;
                UserMessage userMessage = userMessage;
                if (userMessage == null || userMessage.getMessageId() == 0 || userMessage.getSendingStatus() != BaseMessage.SendingStatus.SUCCEEDED || (list = list) == null || list.size() == 0) {
                    throw new SendBirdException("Invalid arguments.", SendBirdError.ERR_INVALID_PARAMETER);
                } else if (!BaseChannel.this.getUrl().equals(userMessage.getChannelUrl())) {
                    throw new SendBirdException("The message does not belong to this channel.", SendBirdError.ERR_INVALID_PARAMETER);
                } else if (SendBird.getCurrentUser() != null) {
                    APIClient a2 = APIClient.a();
                    BaseChannel baseChannel = BaseChannel.this;
                    boolean z = baseChannel instanceof OpenChannel;
                    String url = baseChannel.getUrl();
                    long messageId = userMessage.getMessageId();
                    List<String> list2 = list;
                    if (z) {
                        str = String.format(b.OPENCHANNELS_CHANNELURL_MESSAGES_MESSAGEID_TRANSLATION.publicUrl(), new Object[]{b.urlEncodeUTF8(url), Long.valueOf(messageId)});
                    } else {
                        str = String.format(b.GROUPCHANNELS_CHANNELURL_MESSAGES_MESSAGEID_TRANSLATION.publicUrl(), new Object[]{b.urlEncodeUTF8(url), Long.valueOf(messageId)});
                    }
                    JsonObject e2 = APIClient.e();
                    if (list2 != null && list2.size() > 0) {
                        JsonArray jsonArray = new JsonArray();
                        for (String add : list2) {
                            jsonArray.add(add);
                        }
                        e2.add("target_langs", jsonArray);
                    }
                    JsonObject asJsonObject = a2.a(str, (JsonElement) e2).getAsJsonObject();
                    asJsonObject.addProperty("req_id", userMessage.getRequestId());
                    UserMessage userMessage2 = (UserMessage) BaseMessage.build(asJsonObject, BaseChannel.this.getUrl(), BaseChannel.this.getType());
                    if (userMessage2 != null) {
                        userMessage2.setSendingStatus(BaseMessage.SendingStatus.SUCCEEDED);
                    }
                    return userMessage2;
                } else {
                    throw new SendBirdException("Connection must be made.", SendBirdError.ERR_CONNECTION_REQUIRED);
                }
            }
        });
    }

    public FileMessage copyFileMessage(BaseChannel baseChannel, FileMessage fileMessage, CopyFileMessageHandler copyFileMessageHandler) {
        FileMessage fileMessage2;
        final CopyFileMessageHandler copyFileMessageHandler2 = copyFileMessageHandler;
        if (baseChannel == null || fileMessage == null) {
            if (copyFileMessageHandler2 != null) {
                SendBird.runOnUIThread(new Runnable() {
                    public final void run() {
                        copyFileMessageHandler2.onCopied((FileMessage) null, new SendBirdException("Invalid arguments.", SendBirdError.ERR_INVALID_PARAMETER));
                    }
                });
            }
            return null;
        } else if (!getUrl().equals(fileMessage.getChannelUrl())) {
            if (copyFileMessageHandler2 != null) {
                SendBird.runOnUIThread(new Runnable() {
                    public final void run() {
                        copyFileMessageHandler2.onCopied((FileMessage) null, new SendBirdException("The message does not belong to this channel.", SendBirdError.ERR_INVALID_PARAMETER));
                    }
                });
            }
            return null;
        } else {
            final JsonArray jsonArray = new JsonArray();
            for (FileMessage.Thumbnail json : fileMessage.getThumbnails()) {
                jsonArray.add(json.toJson());
            }
            JsonArray jsonArray2 = new JsonArray();
            for (User next : fileMessage.getMentionedUsers()) {
                if (next != null) {
                    jsonArray2.add((JsonElement) next.toJson().getAsJsonObject());
                }
            }
            JsonArray jsonArray3 = new JsonArray();
            if (fileMessage.getAllMetaArrays() != null && !fileMessage.getAllMetaArrays().isEmpty()) {
                for (MessageMetaArray json2 : fileMessage.getAllMetaArrays()) {
                    jsonArray3.add((JsonElement) json2.toJson());
                }
            }
            final String a2 = Command.a();
            final FileMessage fileMessage3 = new FileMessage(FileMessage.build(a2, BaseMessage.SendingStatus.NONE, 0, 0, 0, Sender.toSender(SendBird.getCurrentUser(), baseChannel.getCurrentUserRole()), baseChannel.getUrl(), baseChannel.getType(), fileMessage.getPlainUrl(), fileMessage.getName(), fileMessage.getType(), fileMessage.getSize(), fileMessage.getData(), fileMessage.getCustomType(), jsonArray.toString(), fileMessage.requiredAuth(), System.currentTimeMillis(), 0, fileMessage.getMentionType(), fileMessage.getMentionedUserIds(), jsonArray2.toString(), (String) null, (String) null, (String) null, jsonArray3.toString(), false, 0, false, false, -1, (String) null, new ThreadInfo(), baseChannel.getCurrentUserRole() == Member.Role.OPERATOR));
            if (SendBird.getCurrentUser() == null) {
                if (copyFileMessageHandler2 != null) {
                    SendBird.runOnUIThread(new Runnable() {
                        public final void run() {
                            FileMessage fileMessage = new FileMessage(fileMessage3.toJson());
                            fileMessage.mCreatedAt = fileMessage3.getCreatedAt();
                            fileMessage.setSendingStatus(BaseMessage.SendingStatus.FAILED);
                            fileMessage.mErrorCode = SendBirdError.ERR_CONNECTION_REQUIRED;
                            copyFileMessageHandler2.onCopied(fileMessage, new SendBirdException("Connection must be made before you forward message.", SendBirdError.ERR_CONNECTION_REQUIRED));
                        }
                    });
                }
                fileMessage3.setSendingStatus(BaseMessage.SendingStatus.PENDING);
                return fileMessage3;
            }
            if (SendBird.getConnectionState() == SendBird.ConnectionState.OPEN) {
                SendBird.getInstance().sendCommand(Command.a(a2, 0, baseChannel.getUrl(), fileMessage.getPlainUrl(), fileMessage.getName(), fileMessage.getType(), fileMessage.getSize(), fileMessage.getData(), fileMessage.getCustomType(), jsonArray.toString(), fileMessage.requiredAuth(), fileMessage.getMentionType(), fileMessage.getMentionedUserIds(), (BaseMessageParams.PushNotificationDeliveryOption) null, fileMessage.getAllMetaArrays()), true, new Command.SendCommandHandler() {
                    public final void onResult(final Command command, final SendBirdException sendBirdException) {
                        SendBird.runOnUIThread(new Runnable() {
                            public final void run() {
                                if (sendBirdException != null) {
                                    if (copyFileMessageHandler2 != null) {
                                        FileMessage fileMessage = new FileMessage(fileMessage3.toJson());
                                        fileMessage.mCreatedAt = fileMessage3.getCreatedAt();
                                        fileMessage.setSendingStatus(BaseMessage.SendingStatus.FAILED);
                                        fileMessage.mErrorCode = sendBirdException.getCode();
                                        copyFileMessageHandler2.onCopied(fileMessage, sendBirdException);
                                    }
                                } else if (copyFileMessageHandler2 != null) {
                                    FileMessage fileMessage2 = new FileMessage(command.c());
                                    fileMessage2.setSendingStatus(BaseMessage.SendingStatus.SUCCEEDED);
                                    copyFileMessageHandler2.onCopied(fileMessage2, (SendBirdException) null);
                                }
                            }
                        });
                    }
                });
                fileMessage2 = fileMessage3;
            } else {
                final BaseChannel baseChannel2 = baseChannel;
                final FileMessage fileMessage4 = fileMessage;
                fileMessage2 = fileMessage3;
                final CopyFileMessageHandler copyFileMessageHandler3 = copyFileMessageHandler;
                d.a(new q<FileMessage>() {
                    public final /* synthetic */ void a(Object obj, SendBirdException sendBirdException) {
                        FileMessage fileMessage = (FileMessage) obj;
                        CopyFileMessageHandler copyFileMessageHandler = copyFileMessageHandler3;
                        if (copyFileMessageHandler != null) {
                            copyFileMessageHandler.onCopied(fileMessage, sendBirdException);
                        }
                    }

                    /* access modifiers changed from: private */
                    /* renamed from: a */
                    public FileMessage call() throws Exception {
                        try {
                            JsonObject asJsonObject = APIClient.a().a(baseChannel2 instanceof OpenChannel, 0, baseChannel2.getUrl(), fileMessage4.getPlainUrl(), fileMessage4.getName(), fileMessage4.getSize(), fileMessage4.getType(), fileMessage4.getCustomType(), fileMessage4.getData(), jsonArray.toString(), fileMessage4.requiredAuth(), fileMessage4.getMentionType(), fileMessage4.getMentionedUserIds(), (BaseMessageParams.PushNotificationDeliveryOption) null, fileMessage4.getAllMetaArrays()).getAsJsonObject();
                            asJsonObject.addProperty("req_id", a2);
                            FileMessage fileMessage = (FileMessage) BaseMessage.build(asJsonObject, BaseChannel.this.getUrl(), BaseChannel.this.getType());
                            if (fileMessage == null) {
                                return fileMessage;
                            }
                            fileMessage.setSendingStatus(BaseMessage.SendingStatus.SUCCEEDED);
                            return fileMessage;
                        } catch (SendBirdException e2) {
                            FileMessage fileMessage2 = new FileMessage(fileMessage3.toJson());
                            fileMessage2.mCreatedAt = fileMessage3.getCreatedAt();
                            fileMessage2.setSendingStatus(BaseMessage.SendingStatus.FAILED);
                            fileMessage2.mErrorCode = e2.getCode();
                            return fileMessage2;
                        }
                    }
                });
            }
            fileMessage2.setSendingStatus(BaseMessage.SendingStatus.PENDING);
            return fileMessage2;
        }
    }

    public UserMessage copyUserMessage(BaseChannel baseChannel, UserMessage userMessage, CopyUserMessageHandler copyUserMessageHandler) {
        final CopyUserMessageHandler copyUserMessageHandler2 = copyUserMessageHandler;
        ArrayList<String> arrayList = null;
        if (baseChannel == null || userMessage == null) {
            if (copyUserMessageHandler2 != null) {
                SendBird.runOnUIThread(new Runnable() {
                    public final void run() {
                        copyUserMessageHandler2.onCopied((UserMessage) null, new SendBirdException("Invalid arguments.", SendBirdError.ERR_INVALID_PARAMETER));
                    }
                });
            }
            return null;
        } else if (!getUrl().equals(userMessage.getChannelUrl())) {
            if (copyUserMessageHandler2 != null) {
                SendBird.runOnUIThread(new Runnable() {
                    public final void run() {
                        copyUserMessageHandler2.onCopied((UserMessage) null, new SendBirdException("The message does not belong to this channel.", SendBirdError.ERR_INVALID_PARAMETER));
                    }
                });
            }
            return null;
        } else {
            if (userMessage.getTranslations().size() > 0) {
                arrayList = new ArrayList<>(userMessage.getTranslations().keySet());
            }
            Command a2 = Command.a(Command.a(), 0, baseChannel.getUrl(), userMessage.getMessage(), userMessage.getData(), userMessage.getCustomType(), userMessage.getMentionType(), userMessage.getMentionedUserIds(), (BaseMessageParams.PushNotificationDeliveryOption) null, userMessage.getAllMetaArrays(), arrayList);
            JsonObject jsonObject = new JsonObject();
            if (arrayList != null) {
                for (String str : arrayList) {
                    jsonObject.addProperty(str, userMessage.getTranslations().get(str));
                }
            }
            JsonArray jsonArray = new JsonArray();
            for (User next : userMessage.getMentionedUsers()) {
                if (next != null) {
                    jsonArray.add((JsonElement) next.toJson().getAsJsonObject());
                }
            }
            JsonArray jsonArray2 = new JsonArray();
            if (userMessage.getAllMetaArrays() != null && !userMessage.getAllMetaArrays().isEmpty()) {
                for (MessageMetaArray json : userMessage.getAllMetaArrays()) {
                    jsonArray2.add((JsonElement) json.toJson());
                }
            }
            final UserMessage userMessage2 = new UserMessage(UserMessage.build(a2.f44217c, BaseMessage.SendingStatus.NONE, 0, 0, 0, Sender.toSender(SendBird.getCurrentUser(), baseChannel.getCurrentUserRole()), baseChannel.getUrl(), baseChannel.getType(), userMessage.getMessage(), userMessage.getData(), userMessage.getCustomType(), jsonObject.toString(), System.currentTimeMillis(), 0, userMessage.getMentionType(), userMessage.getMentionedUserIds(), jsonArray.toString(), (String) null, (String) null, (String) null, jsonArray2.toString(), false, 0, false, false, -1, (String) null, new ThreadInfo(), userMessage.getOgMetaData(), baseChannel.getCurrentUserRole() == Member.Role.OPERATOR));
            if (SendBird.getCurrentUser() == null) {
                if (copyUserMessageHandler2 != null) {
                    SendBird.runOnUIThread(new Runnable() {
                        public final void run() {
                            UserMessage userMessage = new UserMessage(userMessage2.toJson());
                            userMessage.mCreatedAt = userMessage2.getCreatedAt();
                            userMessage.setSendingStatus(BaseMessage.SendingStatus.FAILED);
                            userMessage.mErrorCode = SendBirdError.ERR_CONNECTION_REQUIRED;
                            copyUserMessageHandler2.onCopied(userMessage, new SendBirdException("Connection must be made before you forward message.", SendBirdError.ERR_CONNECTION_REQUIRED));
                        }
                    });
                }
                userMessage2.setSendingStatus(BaseMessage.SendingStatus.PENDING);
                return userMessage2;
            }
            SendBird.getInstance().sendCommand(a2, true, new Command.SendCommandHandler() {
                public final void onResult(final Command command, final SendBirdException sendBirdException) {
                    SendBird.runOnUIThread(new Runnable() {
                        public final void run() {
                            if (sendBirdException != null) {
                                if (copyUserMessageHandler2 != null) {
                                    UserMessage userMessage = new UserMessage(userMessage2.toJson());
                                    userMessage.mCreatedAt = userMessage2.getCreatedAt();
                                    userMessage.setSendingStatus(BaseMessage.SendingStatus.FAILED);
                                    userMessage.mErrorCode = sendBirdException.getCode();
                                    copyUserMessageHandler2.onCopied(userMessage, sendBirdException);
                                }
                            } else if (copyUserMessageHandler2 != null) {
                                UserMessage userMessage2 = new UserMessage(command.c());
                                userMessage2.setSendingStatus(BaseMessage.SendingStatus.SUCCEEDED);
                                copyUserMessageHandler2.onCopied(userMessage2, (SendBirdException) null);
                            }
                        }
                    });
                }
            });
            userMessage2.setSendingStatus(BaseMessage.SendingStatus.PENDING);
            return userMessage2;
        }
    }

    public void createMetaCounters(final Map<String, Integer> map, final MetaCounterHandler metaCounterHandler) {
        d.a(new q<Map<String, Integer>>() {
            public final /* synthetic */ void a(Object obj, SendBirdException sendBirdException) {
                Map map = (Map) obj;
                MetaCounterHandler metaCounterHandler = metaCounterHandler;
                if (metaCounterHandler != null) {
                    metaCounterHandler.onResult(map, sendBirdException);
                }
            }

            public final /* synthetic */ Object call() throws Exception {
                String str;
                if (map != null) {
                    APIClient a2 = APIClient.a();
                    boolean isOpenChannel = BaseChannel.this.isOpenChannel();
                    String url = BaseChannel.this.getUrl();
                    Map map = map;
                    if (isOpenChannel) {
                        str = String.format(b.OPENCHANNELS_CHANNELURL_METACOUNTER.publicUrl(), new Object[]{b.urlEncodeUTF8(url)});
                    } else {
                        str = String.format(b.GROUPCHANNELS_CHANNELURL_METACOUNTER.publicUrl(), new Object[]{b.urlEncodeUTF8(url)});
                    }
                    JsonObject e2 = APIClient.e();
                    JsonObject jsonObject = new JsonObject();
                    for (Map.Entry entry : map.entrySet()) {
                        jsonObject.addProperty((String) entry.getKey(), (Number) entry.getValue());
                    }
                    e2.add("metacounter", jsonObject);
                    JsonElement a3 = a2.a(str, (JsonElement) e2);
                    HashMap hashMap = new HashMap();
                    for (Map.Entry next : a3.getAsJsonObject().entrySet()) {
                        if (((JsonElement) next.getValue()).isJsonPrimitive()) {
                            hashMap.put(next.getKey(), Integer.valueOf(((JsonElement) next.getValue()).getAsInt()));
                        }
                    }
                    return hashMap;
                }
                throw new SendBirdException("Invalid arguments.", SendBirdError.ERR_INVALID_PARAMETER);
            }
        });
    }

    public void updateMetaCounters(final Map<String, Integer> map, final MetaCounterHandler metaCounterHandler) {
        d.a(new q<Map<String, Integer>>() {
            public final /* synthetic */ void a(Object obj, SendBirdException sendBirdException) {
                Map map = (Map) obj;
                MetaCounterHandler metaCounterHandler = metaCounterHandler;
                if (metaCounterHandler != null) {
                    metaCounterHandler.onResult(map, sendBirdException);
                }
            }

            public final /* synthetic */ Object call() throws Exception {
                if (map != null) {
                    JsonElement a2 = APIClient.a().a(BaseChannel.this.isOpenChannel(), BaseChannel.this.getUrl(), (Map<String, Integer>) map, true, 0);
                    HashMap hashMap = new HashMap();
                    for (Map.Entry next : a2.getAsJsonObject().entrySet()) {
                        if (((JsonElement) next.getValue()).isJsonPrimitive()) {
                            hashMap.put(next.getKey(), Integer.valueOf(((JsonElement) next.getValue()).getAsInt()));
                        }
                    }
                    return hashMap;
                }
                throw new SendBirdException("Invalid arguments.", SendBirdError.ERR_INVALID_PARAMETER);
            }
        });
    }

    public void increaseMetaCounters(final Map<String, Integer> map, final MetaCounterHandler metaCounterHandler) {
        d.a(new q<Map<String, Integer>>() {
            public final /* synthetic */ void a(Object obj, SendBirdException sendBirdException) {
                Map map = (Map) obj;
                MetaCounterHandler metaCounterHandler = metaCounterHandler;
                if (metaCounterHandler != null) {
                    metaCounterHandler.onResult(map, sendBirdException);
                }
            }

            public final /* synthetic */ Object call() throws Exception {
                if (map != null) {
                    JsonElement a2 = APIClient.a().a(BaseChannel.this.isOpenChannel(), BaseChannel.this.getUrl(), (Map<String, Integer>) map, false, 1);
                    HashMap hashMap = new HashMap();
                    for (Map.Entry next : a2.getAsJsonObject().entrySet()) {
                        if (((JsonElement) next.getValue()).isJsonPrimitive()) {
                            hashMap.put(next.getKey(), Integer.valueOf(((JsonElement) next.getValue()).getAsInt()));
                        }
                    }
                    return hashMap;
                }
                throw new SendBirdException("Invalid arguments.", SendBirdError.ERR_INVALID_PARAMETER);
            }
        });
    }

    public void decreaseMetaCounters(final Map<String, Integer> map, final MetaCounterHandler metaCounterHandler) {
        d.a(new q<Map<String, Integer>>() {
            public final /* synthetic */ void a(Object obj, SendBirdException sendBirdException) {
                Map map = (Map) obj;
                MetaCounterHandler metaCounterHandler = metaCounterHandler;
                if (metaCounterHandler != null) {
                    metaCounterHandler.onResult(map, sendBirdException);
                }
            }

            public final /* synthetic */ Object call() throws Exception {
                if (map != null) {
                    JsonElement a2 = APIClient.a().a(BaseChannel.this.isOpenChannel(), BaseChannel.this.getUrl(), (Map<String, Integer>) map, false, 2);
                    HashMap hashMap = new HashMap();
                    for (Map.Entry next : a2.getAsJsonObject().entrySet()) {
                        if (((JsonElement) next.getValue()).isJsonPrimitive()) {
                            hashMap.put(next.getKey(), Integer.valueOf(((JsonElement) next.getValue()).getAsInt()));
                        }
                    }
                    return hashMap;
                }
                throw new SendBirdException("Invalid arguments.", SendBirdError.ERR_INVALID_PARAMETER);
            }
        });
    }

    public void getMetaCounters(final Collection<String> collection, final MetaCounterHandler metaCounterHandler) {
        d.a(new q<Map<String, Integer>>() {
            public final /* synthetic */ void a(Object obj, SendBirdException sendBirdException) {
                Map map = (Map) obj;
                MetaCounterHandler metaCounterHandler = metaCounterHandler;
                if (metaCounterHandler != null) {
                    metaCounterHandler.onResult(map, sendBirdException);
                }
            }

            public final /* synthetic */ Object call() throws Exception {
                if (collection != null) {
                    HashMap hashMap = new HashMap();
                    for (Map.Entry next : APIClient.a().a(BaseChannel.this.isOpenChannel(), BaseChannel.this.getUrl(), (Collection<String>) collection).getAsJsonObject().entrySet()) {
                        if (((JsonElement) next.getValue()).isJsonPrimitive()) {
                            hashMap.put(next.getKey(), Integer.valueOf(((JsonElement) next.getValue()).getAsInt()));
                        }
                    }
                    return hashMap;
                }
                throw new SendBirdException("Invalid arguments.", SendBirdError.ERR_INVALID_PARAMETER);
            }
        });
    }

    public void getAllMetaCounters(final MetaCounterHandler metaCounterHandler) {
        d.a(new q<Map<String, Integer>>() {
            public final /* synthetic */ void a(Object obj, SendBirdException sendBirdException) {
                Map map = (Map) obj;
                MetaCounterHandler metaCounterHandler = metaCounterHandler;
                if (metaCounterHandler != null) {
                    metaCounterHandler.onResult(map, sendBirdException);
                }
            }

            public final /* synthetic */ Object call() throws Exception {
                HashMap hashMap = new HashMap();
                for (Map.Entry next : APIClient.a().a(BaseChannel.this.isOpenChannel(), BaseChannel.this.getUrl(), (Collection<String>) new ArrayList()).getAsJsonObject().entrySet()) {
                    if (((JsonElement) next.getValue()).isJsonPrimitive()) {
                        hashMap.put(next.getKey(), Integer.valueOf(((JsonElement) next.getValue()).getAsInt()));
                    }
                }
                return hashMap;
            }
        });
    }

    public void deleteMetaCounter(final String str, final DeleteMetaCounterHandler deleteMetaCounterHandler) {
        d.a(new q<JsonElement>() {
            public final /* synthetic */ void a(Object obj, SendBirdException sendBirdException) {
                DeleteMetaCounterHandler deleteMetaCounterHandler = deleteMetaCounterHandler;
                if (deleteMetaCounterHandler != null) {
                    deleteMetaCounterHandler.onResult(sendBirdException);
                }
            }

            public final /* synthetic */ Object call() throws Exception {
                String str;
                if (str != null) {
                    APIClient a2 = APIClient.a();
                    boolean isOpenChannel = BaseChannel.this.isOpenChannel();
                    String url = BaseChannel.this.getUrl();
                    String str2 = str;
                    if (isOpenChannel) {
                        str = String.format(b.OPENCHANNELS_CHANNELURL_METACOUNTER_KEY.publicUrl(), new Object[]{b.urlEncodeUTF8(url), b.urlEncodeUTF8(str2)});
                    } else {
                        str = String.format(b.GROUPCHANNELS_CHANNELURL_METACOUNTER_KEY.publicUrl(), new Object[]{b.urlEncodeUTF8(url), b.urlEncodeUTF8(str2)});
                    }
                    JsonElement a3 = a2.a(str, (Map<String, Collection<String>>) null, (JsonElement) APIClient.e());
                    HashMap hashMap = new HashMap();
                    for (Map.Entry next : a3.getAsJsonObject().entrySet()) {
                        if (((JsonElement) next.getValue()).isJsonPrimitive()) {
                            hashMap.put(next.getKey(), Integer.valueOf(((JsonElement) next.getValue()).getAsInt()));
                        }
                    }
                    return a3;
                }
                throw new SendBirdException("Invalid arguments.", SendBirdError.ERR_INVALID_PARAMETER);
            }
        });
    }

    public void deleteAllMetaCounters(final DeleteMetaCounterHandler deleteMetaCounterHandler) {
        d.a(new q<HashMap<String, Integer>>() {
            public final /* synthetic */ void a(Object obj, SendBirdException sendBirdException) {
                DeleteMetaCounterHandler deleteMetaCounterHandler = deleteMetaCounterHandler;
                if (deleteMetaCounterHandler != null) {
                    deleteMetaCounterHandler.onResult(sendBirdException);
                }
            }

            public final /* synthetic */ Object call() throws Exception {
                String str;
                APIClient a2 = APIClient.a();
                boolean isOpenChannel = BaseChannel.this.isOpenChannel();
                String url = BaseChannel.this.getUrl();
                if (isOpenChannel) {
                    str = String.format(b.OPENCHANNELS_CHANNELURL_METACOUNTER.publicUrl(), new Object[]{b.urlEncodeUTF8(url)});
                } else {
                    str = String.format(b.GROUPCHANNELS_CHANNELURL_METACOUNTER.publicUrl(), new Object[]{b.urlEncodeUTF8(url)});
                }
                JsonElement a3 = a2.a(str, (Map<String, Collection<String>>) null, (JsonElement) APIClient.e());
                HashMap hashMap = new HashMap();
                for (Map.Entry next : a3.getAsJsonObject().entrySet()) {
                    if (((JsonElement) next.getValue()).isJsonPrimitive()) {
                        hashMap.put(next.getKey(), Integer.valueOf(((JsonElement) next.getValue()).getAsInt()));
                    }
                }
                return hashMap;
            }
        });
    }

    public void createMetaData(final Map<String, String> map, final MetaDataHandler metaDataHandler) {
        d.a(new q<Map<String, String>>() {
            public final /* synthetic */ void a(Object obj, SendBirdException sendBirdException) {
                Map map = (Map) obj;
                MetaDataHandler metaDataHandler = metaDataHandler;
                if (metaDataHandler != null) {
                    metaDataHandler.onResult(map, sendBirdException);
                }
            }

            public final /* synthetic */ Object call() throws Exception {
                if (map != null) {
                    HashMap hashMap = new HashMap();
                    for (Map.Entry next : APIClient.a().a(BaseChannel.this.isOpenChannel(), BaseChannel.this.getUrl(), (Map<String, String>) map).getAsJsonObject().entrySet()) {
                        if (((JsonElement) next.getValue()).isJsonPrimitive()) {
                            hashMap.put(next.getKey(), ((JsonElement) next.getValue()).getAsString());
                        }
                    }
                    return hashMap;
                }
                throw new SendBirdException("Invalid arguments.", SendBirdError.ERR_INVALID_PARAMETER);
            }
        });
    }

    public void updateMetaData(final Map<String, String> map, final MetaDataHandler metaDataHandler) {
        d.a(new q<Map<String, String>>() {
            public final /* synthetic */ void a(Object obj, SendBirdException sendBirdException) {
                Map map = (Map) obj;
                MetaDataHandler metaDataHandler = metaDataHandler;
                if (metaDataHandler != null) {
                    metaDataHandler.onResult(map, sendBirdException);
                }
            }

            public final /* synthetic */ Object call() throws Exception {
                String str;
                if (map != null) {
                    APIClient a2 = APIClient.a();
                    boolean isOpenChannel = BaseChannel.this.isOpenChannel();
                    String url = BaseChannel.this.getUrl();
                    Map map = map;
                    if (isOpenChannel) {
                        str = String.format(b.OPENCHANNELS_CHANNELURL_METADATA.publicUrl(), new Object[]{b.urlEncodeUTF8(url)});
                    } else {
                        str = String.format(b.GROUPCHANNELS_CHANNELURL_METADATA.publicUrl(), new Object[]{b.urlEncodeUTF8(url)});
                    }
                    JsonObject e2 = APIClient.e();
                    JsonObject jsonObject = new JsonObject();
                    for (Map.Entry entry : map.entrySet()) {
                        jsonObject.addProperty((String) entry.getKey(), (String) entry.getValue());
                    }
                    e2.add("metadata", jsonObject);
                    e2.addProperty("upsert", Boolean.TRUE);
                    JsonElement b2 = a2.b(str, e2);
                    HashMap hashMap = new HashMap();
                    for (Map.Entry next : b2.getAsJsonObject().entrySet()) {
                        if (((JsonElement) next.getValue()).isJsonPrimitive()) {
                            hashMap.put(next.getKey(), ((JsonElement) next.getValue()).getAsString());
                        }
                    }
                    return hashMap;
                }
                throw new SendBirdException("Invalid arguments.", SendBirdError.ERR_INVALID_PARAMETER);
            }
        });
    }

    public void getMetaData(final Collection<String> collection, final MetaDataHandler metaDataHandler) {
        d.a(new q<Map<String, String>>() {
            public final /* synthetic */ void a(Object obj, SendBirdException sendBirdException) {
                Map map = (Map) obj;
                MetaDataHandler metaDataHandler = metaDataHandler;
                if (metaDataHandler != null) {
                    metaDataHandler.onResult(map, sendBirdException);
                }
            }

            public final /* synthetic */ Object call() throws Exception {
                if (collection != null) {
                    HashMap hashMap = new HashMap();
                    JsonObject asJsonObject = APIClient.a().b(BaseChannel.this.isOpenChannel(), BaseChannel.this.getUrl(), (Collection<String>) collection).getAsJsonObject();
                    Logger.i("++ obj : ".concat(String.valueOf(asJsonObject)), new Object[0]);
                    for (Map.Entry next : asJsonObject.entrySet()) {
                        if (((JsonElement) next.getValue()).isJsonPrimitive()) {
                            hashMap.put(next.getKey(), ((JsonElement) next.getValue()).getAsString());
                        }
                    }
                    return hashMap;
                }
                throw new SendBirdException("Invalid arguments.", SendBirdError.ERR_INVALID_PARAMETER);
            }
        });
    }

    public void getAllMetaData(final MetaDataHandler metaDataHandler) {
        d.a(new q<Map<String, String>>() {
            public final /* synthetic */ void a(Object obj, SendBirdException sendBirdException) {
                Map map = (Map) obj;
                MetaDataHandler metaDataHandler = metaDataHandler;
                if (metaDataHandler != null) {
                    metaDataHandler.onResult(map, sendBirdException);
                }
            }

            public final /* synthetic */ Object call() throws Exception {
                HashMap hashMap = new HashMap();
                for (Map.Entry next : APIClient.a().b(BaseChannel.this.isOpenChannel(), BaseChannel.this.getUrl(), (Collection<String>) new ArrayList()).getAsJsonObject().entrySet()) {
                    if (((JsonElement) next.getValue()).isJsonPrimitive()) {
                        hashMap.put(next.getKey(), ((JsonElement) next.getValue()).getAsString());
                    }
                }
                return hashMap;
            }
        });
    }

    public void deleteMetaData(final String str, final DeleteMetaDataHandler deleteMetaDataHandler) {
        d.a(new q<JsonElement>() {
            public final /* synthetic */ void a(Object obj, SendBirdException sendBirdException) {
                DeleteMetaDataHandler deleteMetaDataHandler = deleteMetaDataHandler;
                if (deleteMetaDataHandler != null) {
                    deleteMetaDataHandler.onResult(sendBirdException);
                }
            }

            public final /* synthetic */ Object call() throws Exception {
                String str;
                if (str != null) {
                    APIClient a2 = APIClient.a();
                    boolean isOpenChannel = BaseChannel.this.isOpenChannel();
                    String url = BaseChannel.this.getUrl();
                    String str2 = str;
                    if (isOpenChannel) {
                        str = String.format(b.OPENCHANNELS_CHANNELURL_METADATA_KEY.publicUrl(), new Object[]{b.urlEncodeUTF8(url), b.urlEncodeUTF8(str2)});
                    } else {
                        str = String.format(b.GROUPCHANNELS_CHANNELURL_METADATA_KEY.publicUrl(), new Object[]{b.urlEncodeUTF8(url), b.urlEncodeUTF8(str2)});
                    }
                    return a2.a(str, (Map<String, Collection<String>>) null, (JsonElement) APIClient.e());
                }
                throw new SendBirdException("Invalid arguments.", SendBirdError.ERR_INVALID_PARAMETER);
            }
        });
    }

    public void deleteAllMetaData(final DeleteMetaDataHandler deleteMetaDataHandler) {
        d.a(new q<JsonElement>() {
            public final /* synthetic */ void a(Object obj, SendBirdException sendBirdException) {
                DeleteMetaDataHandler deleteMetaDataHandler = deleteMetaDataHandler;
                if (deleteMetaDataHandler != null) {
                    deleteMetaDataHandler.onResult(sendBirdException);
                }
            }

            public final /* synthetic */ Object call() throws Exception {
                String str;
                APIClient a2 = APIClient.a();
                boolean isOpenChannel = BaseChannel.this.isOpenChannel();
                String url = BaseChannel.this.getUrl();
                if (isOpenChannel) {
                    str = String.format(b.OPENCHANNELS_CHANNELURL_METADATA.publicUrl(), new Object[]{b.urlEncodeUTF8(url)});
                } else {
                    str = String.format(b.GROUPCHANNELS_CHANNELURL_METADATA.publicUrl(), new Object[]{b.urlEncodeUTF8(url)});
                }
                return a2.a(str, (Map<String, Collection<String>>) null, (JsonElement) APIClient.e());
            }
        });
    }

    public void deleteMessage(final BaseMessage baseMessage, final DeleteMessageHandler deleteMessageHandler) {
        d.a(new q<JsonElement>() {
            public final /* synthetic */ void a(Object obj, SendBirdException sendBirdException) {
                DeleteMessageHandler deleteMessageHandler = deleteMessageHandler;
                if (deleteMessageHandler != null) {
                    deleteMessageHandler.onResult(sendBirdException);
                }
            }

            public final /* synthetic */ Object call() throws Exception {
                String str;
                if (baseMessage != null) {
                    APIClient a2 = APIClient.a();
                    boolean isOpenChannel = BaseChannel.this.isOpenChannel();
                    String url = BaseChannel.this.getUrl();
                    long messageId = baseMessage.getMessageId();
                    if (isOpenChannel) {
                        str = String.format(b.OPENCHANNELS_CHANNELURL_MESSAGES_MESSAGEID.publicUrl(), new Object[]{b.urlEncodeUTF8(url), Long.valueOf(messageId)});
                    } else {
                        str = String.format(b.GROUPCHANNELS_CHANNELURL_MESSAGES_MESSAGEID.publicUrl(), new Object[]{b.urlEncodeUTF8(url), Long.valueOf(messageId)});
                    }
                    return a2.a(str, (Map<String, Collection<String>>) null, (JsonElement) APIClient.e());
                }
                throw new SendBirdException("Invalid arguments.", SendBirdError.ERR_INVALID_PARAMETER);
            }
        });
    }

    public void updateUserMessage(long j, String str, String str2, String str3, UpdateUserMessageHandler updateUserMessageHandler) {
        localUpdateUserMessage(j, str, str2, str3, (BaseMessageParams.MentionType) null, (List<String>) null, updateUserMessageHandler);
    }

    public void updateUserMessage(long j, UserMessageParams userMessageParams, UpdateUserMessageHandler updateUserMessageHandler) {
        localUpdateUserMessage(j, userMessageParams.mMessage, userMessageParams.mData, userMessageParams.mCustomType, userMessageParams.mMentionType, userMessageParams.mMentionedUserIds, updateUserMessageHandler);
    }

    private void localUpdateUserMessage(long j, String str, String str2, String str3, BaseMessageParams.MentionType mentionType, List<String> list, UpdateUserMessageHandler updateUserMessageHandler) {
        final UpdateUserMessageHandler updateUserMessageHandler2 = updateUserMessageHandler;
        if (SendBird.getCurrentUser() != null) {
            SendBird.getInstance().sendCommand(Command.a(getUrl(), j, str, str2, str3, mentionType, list, (List<MessageMetaArray>) null, (Boolean) null), true, new Command.SendCommandHandler() {
                public final void onResult(final Command command, final SendBirdException sendBirdException) {
                    SendBird.runOnUIThread(new Runnable() {
                        public final void run() {
                            if (sendBirdException != null) {
                                if (updateUserMessageHandler2 != null) {
                                    updateUserMessageHandler2.onUpdated((UserMessage) null, sendBirdException);
                                }
                            } else if (updateUserMessageHandler2 != null) {
                                UserMessage userMessage = new UserMessage(command.c());
                                userMessage.setSendingStatus(BaseMessage.SendingStatus.SUCCEEDED);
                                updateUserMessageHandler2.onUpdated(userMessage, (SendBirdException) null);
                            }
                        }
                    });
                }
            });
        } else if (updateUserMessageHandler2 != null) {
            SendBird.runOnUIThread(new Runnable() {
                public final void run() {
                    updateUserMessageHandler2.onUpdated((UserMessage) null, new SendBirdException("Connection must be made.", SendBirdError.ERR_CONNECTION_REQUIRED));
                }
            });
        }
    }

    public void updateFileMessage(long j, String str, String str2, UpdateFileMessageHandler updateFileMessageHandler) {
        localUpdateFileMessage(j, str, str2, (BaseMessageParams.MentionType) null, (List<String>) null, updateFileMessageHandler);
    }

    public void updateFileMessage(long j, FileMessageParams fileMessageParams, UpdateFileMessageHandler updateFileMessageHandler) {
        localUpdateFileMessage(j, fileMessageParams.mData, fileMessageParams.mCustomType, fileMessageParams.mMentionType, fileMessageParams.mMentionedUserIds, updateFileMessageHandler);
    }

    private void localUpdateFileMessage(long j, String str, String str2, BaseMessageParams.MentionType mentionType, List<String> list, UpdateFileMessageHandler updateFileMessageHandler) {
        final UpdateFileMessageHandler updateFileMessageHandler2 = updateFileMessageHandler;
        if (SendBird.getCurrentUser() != null) {
            SendBird.getInstance().sendCommand(Command.a(getUrl(), j, str, str2, mentionType, list, (List<MessageMetaArray>) null, (Boolean) null), true, new Command.SendCommandHandler() {
                public final void onResult(final Command command, final SendBirdException sendBirdException) {
                    SendBird.runOnUIThread(new Runnable() {
                        public final void run() {
                            if (sendBirdException != null) {
                                if (updateFileMessageHandler2 != null) {
                                    updateFileMessageHandler2.onUpdated((FileMessage) null, sendBirdException);
                                }
                            } else if (updateFileMessageHandler2 != null) {
                                FileMessage fileMessage = new FileMessage(command.c());
                                fileMessage.setSendingStatus(BaseMessage.SendingStatus.SUCCEEDED);
                                updateFileMessageHandler2.onUpdated(fileMessage, (SendBirdException) null);
                            }
                        }
                    });
                }
            });
        } else if (updateFileMessageHandler2 != null) {
            SendBird.runOnUIThread(new Runnable() {
                public final void run() {
                    updateFileMessageHandler2.onUpdated((FileMessage) null, new SendBirdException("Connection must be made.", SendBirdError.ERR_CONNECTION_REQUIRED));
                }
            });
        }
    }

    public boolean cancelFileMessageUpload(String str) {
        APIClient.a();
        return APIClient.a(str);
    }

    public void addReaction(final BaseMessage baseMessage, final String str, final ReactionHandler reactionHandler) {
        d.a(new q<ReactionEvent>() {
            public final /* synthetic */ void a(Object obj, SendBirdException sendBirdException) {
                ReactionEvent reactionEvent = (ReactionEvent) obj;
                ReactionHandler reactionHandler = reactionHandler;
                if (reactionHandler != null) {
                    reactionHandler.onResult(reactionEvent, sendBirdException);
                }
            }

            public final /* synthetic */ Object call() throws Exception {
                String str;
                if (baseMessage == null || str == null) {
                    throw new SendBirdException("Invalid arguments.", SendBirdError.ERR_INVALID_PARAMETER);
                } else if (SendBird.getCurrentUser() != null) {
                    APIClient a2 = APIClient.a();
                    boolean isOpenChannel = BaseChannel.this.isOpenChannel();
                    String url = BaseChannel.this.getUrl();
                    long messageId = baseMessage.getMessageId();
                    String str2 = str;
                    if (isOpenChannel) {
                        str = String.format(b.OPENCHANNELS_CHANNELURL_MESSAGES_MESSAGEID_REACTIONS.publicUrl(), new Object[]{b.urlEncodeUTF8(url), Long.valueOf(messageId)});
                    } else {
                        str = String.format(b.GROUPCHANNELS_CHANNELURL_MESSAGES_MESSAGEID_REACTIONS.publicUrl(), new Object[]{b.urlEncodeUTF8(url), Long.valueOf(messageId)});
                    }
                    JsonObject e2 = APIClient.e();
                    e2.addProperty("user_id", SendBird.getCurrentUser().getUserId());
                    if (str2 != null) {
                        e2.addProperty("reaction", str2);
                    }
                    return new ReactionEvent(a2.a(str, (JsonElement) e2));
                } else {
                    throw new SendBirdException("Connection must be made before you send message.", SendBirdError.ERR_CONNECTION_REQUIRED);
                }
            }
        });
    }

    public void deleteReaction(final BaseMessage baseMessage, final String str, final ReactionHandler reactionHandler) {
        d.a(new q<ReactionEvent>() {
            public final /* synthetic */ void a(Object obj, SendBirdException sendBirdException) {
                ReactionEvent reactionEvent = (ReactionEvent) obj;
                ReactionHandler reactionHandler = reactionHandler;
                if (reactionHandler != null) {
                    reactionHandler.onResult(reactionEvent, sendBirdException);
                }
            }

            public final /* synthetic */ Object call() throws Exception {
                String str;
                if (baseMessage == null || str == null) {
                    throw new SendBirdException("Invalid arguments.", SendBirdError.ERR_INVALID_PARAMETER);
                } else if (SendBird.getCurrentUser() != null) {
                    APIClient a2 = APIClient.a();
                    boolean isOpenChannel = BaseChannel.this.isOpenChannel();
                    String url = BaseChannel.this.getUrl();
                    long messageId = baseMessage.getMessageId();
                    String str2 = str;
                    if (isOpenChannel) {
                        str = String.format(b.OPENCHANNELS_CHANNELURL_MESSAGES_MESSAGEID_REACTIONS.publicUrl(), new Object[]{b.urlEncodeUTF8(url), Long.valueOf(messageId)});
                    } else {
                        str = String.format(b.GROUPCHANNELS_CHANNELURL_MESSAGES_MESSAGEID_REACTIONS.publicUrl(), new Object[]{b.urlEncodeUTF8(url), Long.valueOf(messageId)});
                    }
                    JsonObject e2 = APIClient.e();
                    e2.addProperty("user_id", SendBird.getCurrentUser().getUserId());
                    e2.addProperty(StringSet.msg_id, (Number) Long.valueOf(messageId));
                    if (str2 != null) {
                        e2.addProperty("reaction", str2);
                    }
                    e2.addProperty(StringSet.updated_at, (Number) Long.valueOf(System.currentTimeMillis()));
                    return new ReactionEvent(a2.a(str, (Map<String, Collection<String>>) null, (JsonElement) e2));
                } else {
                    throw new SendBirdException("Connection must be made before you send message.", SendBirdError.ERR_CONNECTION_REQUIRED);
                }
            }
        });
    }

    public void createMessageMetaArrayKeys(final BaseMessage baseMessage, List<String> list, final MessageMetaArrayHandler messageMetaArrayHandler) {
        if (baseMessage != null && !(baseMessage instanceof AdminMessage) && list != null && list.size() > 0) {
            ArrayList<String> arrayList = new ArrayList<>(new LinkedHashSet(list));
            ArrayList arrayList2 = new ArrayList();
            for (String messageMetaArray : arrayList) {
                arrayList2.add(new MessageMetaArray(messageMetaArray));
            }
            Command command = null;
            if (baseMessage instanceof UserMessage) {
                command = Command.a(getUrl(), baseMessage.getMessageId(), (String) null, (String) null, (String) null, (BaseMessageParams.MentionType) null, (List<String>) null, arrayList2, Boolean.TRUE);
            } else if (baseMessage instanceof FileMessage) {
                command = Command.a(getUrl(), baseMessage.getMessageId(), (String) null, (String) null, (BaseMessageParams.MentionType) null, (List<String>) null, arrayList2, Boolean.TRUE);
            }
            if (command != null) {
                SendBird.getInstance().sendCommand(command, true, new Command.SendCommandHandler() {
                    public final void onResult(Command command, final SendBirdException sendBirdException) {
                        if (sendBirdException == null) {
                            JsonObject asJsonObject = command.c().getAsJsonObject();
                            if (asJsonObject != null && asJsonObject.has("metaarray")) {
                                for (Map.Entry<String, JsonElement> key : asJsonObject.getAsJsonObject("metaarray").entrySet()) {
                                    String str = (String) key.getKey();
                                    if (str != null) {
                                        baseMessage.addMetaArray(str);
                                    }
                                }
                                if (messageMetaArrayHandler != null) {
                                    SendBird.runOnUIThread(new Runnable() {
                                        public final void run() {
                                            messageMetaArrayHandler.onResult(baseMessage, (SendBirdException) null);
                                        }
                                    });
                                }
                            }
                        } else if (messageMetaArrayHandler != null) {
                            SendBird.runOnUIThread(new Runnable() {
                                public final void run() {
                                    messageMetaArrayHandler.onResult(baseMessage, sendBirdException);
                                }
                            });
                        }
                    }
                });
            }
        } else if (messageMetaArrayHandler != null) {
            SendBird.runOnUIThread(new Runnable() {
                public final void run() {
                    messageMetaArrayHandler.onResult(baseMessage, new SendBirdException("Invalid arguments.", SendBirdError.ERR_INVALID_PARAMETER));
                }
            });
        }
    }

    public void deleteMessageMetaArrayKeys(final BaseMessage baseMessage, List<String> list, final MessageMetaArrayHandler messageMetaArrayHandler) {
        if (baseMessage != null && !(baseMessage instanceof AdminMessage) && list != null && list.size() > 0) {
            final ArrayList<String> arrayList = new ArrayList<>(new LinkedHashSet(list));
            ArrayList arrayList2 = new ArrayList();
            for (String messageMetaArray : arrayList) {
                arrayList2.add(new MessageMetaArray(messageMetaArray));
            }
            Command command = null;
            if (baseMessage instanceof UserMessage) {
                String url = getUrl();
                long messageId = baseMessage.getMessageId();
                Boolean bool = Boolean.FALSE;
                Boolean bool2 = Boolean.TRUE;
                command = Command.a(url, messageId, (String) null, (String) null, (String) null, (BaseMessageParams.MentionType) null, (List<String>) null, arrayList2, bool);
            } else if (baseMessage instanceof FileMessage) {
                String url2 = getUrl();
                long messageId2 = baseMessage.getMessageId();
                Boolean bool3 = Boolean.FALSE;
                Boolean bool4 = Boolean.TRUE;
                command = Command.a(url2, messageId2, (String) null, (String) null, (BaseMessageParams.MentionType) null, (List<String>) null, arrayList2, bool3);
            }
            if (command != null) {
                SendBird.getInstance().sendCommand(command, true, new Command.SendCommandHandler() {
                    public final void onResult(Command command, final SendBirdException sendBirdException) {
                        if (sendBirdException == null) {
                            for (String str : arrayList) {
                                if (str != null) {
                                    baseMessage.removeMetaArrayByKey(str);
                                }
                            }
                            if (messageMetaArrayHandler != null) {
                                SendBird.runOnUIThread(new Runnable() {
                                    public final void run() {
                                        messageMetaArrayHandler.onResult(baseMessage, (SendBirdException) null);
                                    }
                                });
                            }
                        } else if (messageMetaArrayHandler != null) {
                            SendBird.runOnUIThread(new Runnable() {
                                public final void run() {
                                    messageMetaArrayHandler.onResult(baseMessage, sendBirdException);
                                }
                            });
                        }
                    }
                });
            }
        } else if (messageMetaArrayHandler != null) {
            SendBird.runOnUIThread(new Runnable() {
                public final void run() {
                    messageMetaArrayHandler.onResult(baseMessage, new SendBirdException("Invalid arguments.", SendBirdError.ERR_INVALID_PARAMETER));
                }
            });
        }
    }

    public void addMessageMetaArrayValues(BaseMessage baseMessage, Map<String, List<String>> map, MessageMetaArrayHandler messageMetaArrayHandler) {
        ArrayList arrayList = new ArrayList();
        for (String next : map.keySet()) {
            if (next != null) {
                arrayList.add(new MessageMetaArray(next, map.get(next)));
            }
        }
        localUpdateMessageMetaArrayValues(baseMessage, arrayList, true, messageMetaArrayHandler);
    }

    public void addMessageMetaArrayValues(BaseMessage baseMessage, List<MessageMetaArray> list, MessageMetaArrayHandler messageMetaArrayHandler) {
        localUpdateMessageMetaArrayValues(baseMessage, list, true, messageMetaArrayHandler);
    }

    public void removeMessageMetaArrayValues(BaseMessage baseMessage, Map<String, List<String>> map, MessageMetaArrayHandler messageMetaArrayHandler) {
        ArrayList arrayList = new ArrayList();
        for (String next : map.keySet()) {
            if (next != null) {
                arrayList.add(new MessageMetaArray(next, map.get(next)));
            }
        }
        localUpdateMessageMetaArrayValues(baseMessage, arrayList, false, messageMetaArrayHandler);
    }

    public void removeMessageMetaArrayValues(BaseMessage baseMessage, List<MessageMetaArray> list, MessageMetaArrayHandler messageMetaArrayHandler) {
        localUpdateMessageMetaArrayValues(baseMessage, list, false, messageMetaArrayHandler);
    }

    private void localUpdateMessageMetaArrayValues(final BaseMessage baseMessage, List<MessageMetaArray> list, boolean z, MessageMetaArrayHandler messageMetaArrayHandler) {
        BaseMessage baseMessage2 = baseMessage;
        final MessageMetaArrayHandler messageMetaArrayHandler2 = messageMetaArrayHandler;
        if (baseMessage2 != null && !(baseMessage2 instanceof AdminMessage) && list != null && list.size() > 0) {
            Command command = null;
            if (baseMessage2 instanceof UserMessage) {
                String url = getUrl();
                long messageId = baseMessage.getMessageId();
                Boolean valueOf = Boolean.valueOf(z);
                Boolean bool = Boolean.FALSE;
                command = Command.a(url, messageId, (String) null, (String) null, (String) null, (BaseMessageParams.MentionType) null, (List<String>) null, list, valueOf);
            } else if (baseMessage2 instanceof FileMessage) {
                String url2 = getUrl();
                long messageId2 = baseMessage.getMessageId();
                Boolean valueOf2 = Boolean.valueOf(z);
                Boolean bool2 = Boolean.FALSE;
                command = Command.a(url2, messageId2, (String) null, (String) null, (BaseMessageParams.MentionType) null, (List<String>) null, list, valueOf2);
            }
            if (command != null) {
                SendBird.getInstance().sendCommand(command, true, new Command.SendCommandHandler() {
                    public final void onResult(Command command, final SendBirdException sendBirdException) {
                        if (sendBirdException == null) {
                            JsonObject asJsonObject = command.c().getAsJsonObject();
                            if (asJsonObject != null && asJsonObject.has("metaarray")) {
                                JsonObject asJsonObject2 = asJsonObject.getAsJsonObject("metaarray");
                                for (Map.Entry<String, JsonElement> key : asJsonObject2.entrySet()) {
                                    String str = (String) key.getKey();
                                    if (str != null && asJsonObject2.get(str).isJsonArray()) {
                                        ArrayList arrayList = new ArrayList();
                                        JsonArray asJsonArray = asJsonObject2.get(str).getAsJsonArray();
                                        if (asJsonArray != null) {
                                            for (int i2 = 0; i2 < asJsonArray.size(); i2++) {
                                                String asString = asJsonArray.get(i2).getAsString();
                                                if (asString != null) {
                                                    arrayList.add(asString);
                                                }
                                            }
                                        }
                                        baseMessage.setMetaArray(str, arrayList);
                                    }
                                }
                                if (messageMetaArrayHandler2 != null) {
                                    SendBird.runOnUIThread(new Runnable() {
                                        public final void run() {
                                            messageMetaArrayHandler2.onResult(baseMessage, (SendBirdException) null);
                                        }
                                    });
                                }
                            }
                        } else if (messageMetaArrayHandler2 != null) {
                            SendBird.runOnUIThread(new Runnable() {
                                public final void run() {
                                    messageMetaArrayHandler2.onResult(baseMessage, sendBirdException);
                                }
                            });
                        }
                    }
                });
            }
        } else if (messageMetaArrayHandler2 != null) {
            SendBird.runOnUIThread(new Runnable() {
                public final void run() {
                    messageMetaArrayHandler2.onResult(baseMessage, new SendBirdException("Invalid arguments.", SendBirdError.ERR_INVALID_PARAMETER));
                }
            });
        }
    }

    public void getMyMutedInfo(final GetMyMutedInfoHandler getMyMutedInfoHandler) {
        d.a(new s<Boolean>() {
            /* access modifiers changed from: private */
            /* renamed from: a */
            public Boolean call() {
                String str;
                try {
                    APIClient a2 = APIClient.a();
                    boolean isOpenChannel = BaseChannel.this.isOpenChannel();
                    String url = BaseChannel.this.getUrl();
                    if (SendBird.getCurrentUser() != null) {
                        boolean z = true;
                        if (isOpenChannel) {
                            str = String.format(b.OPENCHANNELS_CHANNELURL_MUTE_USERID.publicUrl(), new Object[]{b.urlEncodeUTF8(url), b.urlEncodeUTF8(SendBird.getCurrentUser().getUserId())});
                        } else {
                            str = String.format(b.GROUPCHANNELS_CHANNELURL_MUTE_USERID.publicUrl(), new Object[]{b.urlEncodeUTF8(url), b.urlEncodeUTF8(SendBird.getCurrentUser().getUserId())});
                        }
                        JsonObject asJsonObject = a2.a(str, (Map<String, String>) null, (Map<String, Collection<String>>) null).getAsJsonObject();
                        if (!asJsonObject.has(StringSet.is_muted) || !asJsonObject.get(StringSet.is_muted).getAsBoolean()) {
                            z = false;
                        }
                        final String asString = asJsonObject.has(RequestConfirmationDialogFragment.KEY_DESCRIPTION) ? asJsonObject.get(RequestConfirmationDialogFragment.KEY_DESCRIPTION).getAsString() : null;
                        long asLong = asJsonObject.has("start_at") ? asJsonObject.get("start_at").getAsLong() : -1;
                        long asLong2 = asJsonObject.has("end_at") ? asJsonObject.get("end_at").getAsLong() : -1;
                        long asLong3 = asJsonObject.has("remaining_duration") ? asJsonObject.get("remaining_duration").getAsLong() : -1;
                        if (getMyMutedInfoHandler != null) {
                            final boolean z2 = z;
                            final long j = asLong;
                            final long j2 = asLong2;
                            final long j3 = asLong3;
                            SendBird.runOnUIThread(new Runnable() {
                                public final void run() {
                                    getMyMutedInfoHandler.onResult(z2, asString, j, j2, j3, (SendBirdException) null);
                                }
                            });
                        }
                        return Boolean.TRUE;
                    }
                    throw u.b();
                } catch (SendBirdException e2) {
                    if (getMyMutedInfoHandler != null) {
                        SendBird.runOnUIThread(new Runnable() {
                            public final void run() {
                                getMyMutedInfoHandler.onResult(false, (String) null, -1, -1, -1, e2);
                            }
                        });
                    }
                }
            }
        });
    }

    public void report(final ReportCategory reportCategory, final String str, final ReportHandler reportHandler) {
        d.a(new q<JsonElement>() {
            public final /* synthetic */ void a(Object obj, SendBirdException sendBirdException) {
                ReportHandler reportHandler = reportHandler;
                if (reportHandler != null) {
                    reportHandler.onResult(sendBirdException);
                }
            }

            public final /* synthetic */ Object call() throws Exception {
                String str;
                if (reportCategory != null) {
                    APIClient a2 = APIClient.a();
                    boolean isOpenChannel = BaseChannel.this.isOpenChannel();
                    String url = BaseChannel.this.getUrl();
                    ReportCategory reportCategory = reportCategory;
                    String str2 = str;
                    if (SendBird.getCurrentUser() != null) {
                        if (isOpenChannel) {
                            str = String.format(b.REPORT_OPENCHANNELS_CHANNELURL.publicUrl(), new Object[]{b.urlEncodeUTF8(url)});
                        } else {
                            str = String.format(b.REPORT_GROUPCHANNELS_CHANNELURL.publicUrl(), new Object[]{b.urlEncodeUTF8(url)});
                        }
                        JsonObject e2 = APIClient.e();
                        if (reportCategory != null) {
                            int i2 = APIClient.AnonymousClass3.f43889b[reportCategory.ordinal()];
                            if (i2 == 1) {
                                e2.addProperty("report_category", "suspicious");
                            } else if (i2 == 2) {
                                e2.addProperty("report_category", "harassing");
                            } else if (i2 == 3) {
                                e2.addProperty("report_category", "spam");
                            } else if (i2 == 4) {
                                e2.addProperty("report_category", "inappropriate");
                            }
                        }
                        if (str2 != null) {
                            e2.addProperty("report_description", str2);
                        }
                        e2.addProperty("reporting_user_id", SendBird.getCurrentUser().getUserId());
                        return a2.a(str, (JsonElement) e2);
                    }
                    throw u.b();
                }
                throw new SendBirdException("Invalid arguments.", SendBirdError.ERR_INVALID_PARAMETER);
            }
        });
    }

    public void reportUser(User user, ReportCategory reportCategory, String str, ReportUserHandler reportUserHandler) {
        final User user2 = user;
        final ReportCategory reportCategory2 = reportCategory;
        final String str2 = str;
        final ReportUserHandler reportUserHandler2 = reportUserHandler;
        d.a(new q<JsonElement>() {
            public final /* synthetic */ void a(Object obj, SendBirdException sendBirdException) {
                ReportUserHandler reportUserHandler = reportUserHandler2;
                if (reportUserHandler != null) {
                    reportUserHandler.onResult(sendBirdException);
                }
            }

            public final /* synthetic */ Object call() throws Exception {
                if (user2 == null || reportCategory2 == null) {
                    throw new SendBirdException("Invalid arguments.", SendBirdError.ERR_INVALID_PARAMETER);
                }
                APIClient a2 = APIClient.a();
                boolean isOpenChannel = BaseChannel.this.isOpenChannel();
                String url = BaseChannel.this.getUrl();
                String userId = user2.getUserId();
                ReportCategory reportCategory = reportCategory2;
                String str = str2;
                if (SendBird.getCurrentUser() != null) {
                    String format = String.format(b.REPORT_USERS_OFFENDINGUSERID.publicUrl(), new Object[]{b.urlEncodeUTF8(userId)});
                    JsonObject e2 = APIClient.e();
                    e2.addProperty(StringSet.channel_type, isOpenChannel ? "open_channels" : "group_channels");
                    if (url != null) {
                        e2.addProperty(StringSet.channel_url, url);
                    }
                    if (reportCategory != null) {
                        int i2 = APIClient.AnonymousClass3.f43889b[reportCategory.ordinal()];
                        if (i2 == 1) {
                            e2.addProperty("report_category", "suspicious");
                        } else if (i2 == 2) {
                            e2.addProperty("report_category", "harassing");
                        } else if (i2 == 3) {
                            e2.addProperty("report_category", "spam");
                        } else if (i2 == 4) {
                            e2.addProperty("report_category", "inappropriate");
                        }
                    }
                    if (str != null) {
                        e2.addProperty("report_description", str);
                    }
                    e2.addProperty("reporting_user_id", SendBird.getCurrentUser().getUserId());
                    return a2.a(format, (JsonElement) e2);
                }
                throw u.b();
            }
        });
    }

    public void reportMessage(BaseMessage baseMessage, ReportCategory reportCategory, String str, ReportMessageHandler reportMessageHandler) {
        final BaseMessage baseMessage2 = baseMessage;
        final ReportCategory reportCategory2 = reportCategory;
        final String str2 = str;
        final ReportMessageHandler reportMessageHandler2 = reportMessageHandler;
        d.a(new q<JsonElement>() {
            public final /* synthetic */ void a(Object obj, SendBirdException sendBirdException) {
                ReportMessageHandler reportMessageHandler = reportMessageHandler2;
                if (reportMessageHandler != null) {
                    reportMessageHandler.onResult(sendBirdException);
                }
            }

            public final /* synthetic */ Object call() throws Exception {
                String str;
                BaseMessage baseMessage = baseMessage2;
                if (baseMessage == null || (baseMessage instanceof AdminMessage) || reportCategory2 == null) {
                    throw new SendBirdException("Invalid arguments.", SendBirdError.ERR_INVALID_PARAMETER);
                }
                String str2 = null;
                Sender sender = baseMessage.getSender();
                if (sender != null) {
                    str2 = sender.getUserId();
                }
                APIClient a2 = APIClient.a();
                boolean isOpenChannel = BaseChannel.this.isOpenChannel();
                String url = BaseChannel.this.getUrl();
                long messageId = baseMessage2.getMessageId();
                ReportCategory reportCategory = reportCategory2;
                String str3 = str2;
                if (SendBird.getCurrentUser() != null) {
                    if (isOpenChannel) {
                        str = String.format(b.REPORT_OPENCHANNELS_CHANNELURL_MESSAGES_MESSAGEID.publicUrl(), new Object[]{b.urlEncodeUTF8(url), Long.valueOf(messageId)});
                    } else {
                        str = String.format(b.REPORT_GROUPCHANNELS_CHANNELURL_MESSAGES_MESSAGEID.publicUrl(), new Object[]{b.urlEncodeUTF8(url), Long.valueOf(messageId)});
                    }
                    JsonObject e2 = APIClient.e();
                    if (str2 != null) {
                        e2.addProperty("offending_user_id", str2);
                    }
                    if (reportCategory != null) {
                        int i2 = APIClient.AnonymousClass3.f43889b[reportCategory.ordinal()];
                        if (i2 == 1) {
                            e2.addProperty("report_category", "suspicious");
                        } else if (i2 == 2) {
                            e2.addProperty("report_category", "harassing");
                        } else if (i2 == 3) {
                            e2.addProperty("report_category", "spam");
                        } else if (i2 == 4) {
                            e2.addProperty("report_category", "inappropriate");
                        }
                    }
                    if (str3 != null) {
                        e2.addProperty("report_description", str3);
                    }
                    e2.addProperty("reporting_user_id", SendBird.getCurrentUser().getUserId());
                    return a2.a(str, (JsonElement) e2);
                }
                throw u.b();
            }
        });
    }

    public void addOperators(final Collection<String> collection, final AddOperatorsHandler addOperatorsHandler) {
        d.a(new q<JsonElement>() {
            public final /* synthetic */ void a(Object obj, SendBirdException sendBirdException) {
                AddOperatorsHandler addOperatorsHandler = addOperatorsHandler;
                if (addOperatorsHandler != null) {
                    addOperatorsHandler.onResult(sendBirdException);
                }
            }

            public final /* synthetic */ Object call() throws Exception {
                Collection collection = collection;
                if (collection != null && !collection.isEmpty()) {
                    return APIClient.a().a(BaseChannel.this, true, (Collection<String>) collection, false);
                }
                throw new SendBirdException("userIds is null or empty", SendBirdError.ERR_INVALID_PARAMETER);
            }
        });
    }

    public void removeOperators(final Collection<String> collection, final RemoveOperatorsHandler removeOperatorsHandler) {
        d.a(new q<JsonElement>() {
            public final /* synthetic */ void a(Object obj, SendBirdException sendBirdException) {
                RemoveOperatorsHandler removeOperatorsHandler = removeOperatorsHandler;
                if (removeOperatorsHandler != null) {
                    removeOperatorsHandler.onResult(sendBirdException);
                }
            }

            public final /* synthetic */ Object call() throws Exception {
                Collection collection = collection;
                if (collection != null && !collection.isEmpty()) {
                    return APIClient.a().a(BaseChannel.this, false, (Collection<String>) collection, false);
                }
                throw new SendBirdException("userIds is null or empty", SendBirdError.ERR_INVALID_PARAMETER);
            }
        });
    }

    public void removeAllOperators(final RemoveAllOperatorsHandler removeAllOperatorsHandler) {
        d.a(new q<JsonElement>() {
            public final /* synthetic */ void a(Object obj, SendBirdException sendBirdException) {
                RemoveAllOperatorsHandler removeAllOperatorsHandler = removeAllOperatorsHandler;
                if (removeAllOperatorsHandler != null) {
                    removeAllOperatorsHandler.onResult(sendBirdException);
                }
            }

            public final /* synthetic */ Object call() throws Exception {
                return APIClient.a().a(BaseChannel.this, false, (Collection<String>) null, true);
            }
        });
    }

    static void getChannel(Command command, final a aVar) {
        ChannelType channelType;
        boolean z;
        String g2 = command.g();
        if (command.c() != null && command.c().isJsonObject()) {
            channelType = ChannelType.GROUP;
            JsonObject asJsonObject = command.c().getAsJsonObject();
            switch (Command.AnonymousClass1.f44218a[command.f44215a.ordinal()]) {
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                case 8:
                case 11:
                case 12:
                case 13:
                    if (!asJsonObject.has(StringSet.channel_type)) {
                        channelType = ChannelType.GROUP;
                        break;
                    } else {
                        channelType = ChannelType.fromValue(asJsonObject.get(StringSet.channel_type).getAsString());
                        break;
                    }
                case 9:
                case 10:
                    channelType = ChannelType.GROUP;
                    break;
            }
        } else {
            channelType = null;
        }
        if (command.f44215a == m.SYEV) {
            z = new i(command.c()).f44718b.useWithoutCache();
        } else {
            z = false;
        }
        Logger.d("++ channelUrl=%s, channelType = %s, withoutCache=%s", g2, channelType, Boolean.valueOf(z));
        if (TextUtils.isEmpty(g2) || channelType == null) {
            SendBird.runOnUIThread(new Runnable() {
                public final void run() {
                    a aVar = aVar;
                    if (aVar != null) {
                        new SendBirdException("Invalid arguments.", SendBirdError.ERR_INVALID_PARAMETER);
                        aVar.a((BaseChannel) null);
                    }
                }
            });
            return;
        }
        AnonymousClass76 r2 = new OpenChannel.OpenChannelGetHandler() {
            public final void onResult(OpenChannel openChannel, SendBirdException sendBirdException) {
                a aVar = aVar;
                if (aVar != null) {
                    aVar.a(openChannel);
                }
            }
        };
        AnonymousClass77 r3 = new GroupChannel.GroupChannelGetHandler() {
            public final void onResult(GroupChannel groupChannel, SendBirdException sendBirdException) {
                a aVar = aVar;
                if (aVar != null) {
                    aVar.a(groupChannel);
                }
            }
        };
        if (z) {
            if (channelType == ChannelType.OPEN) {
                OpenChannel.getChannelWithoutCacheInternal(g2, r2);
            } else {
                GroupChannel.getChannelWithoutCacheInternal(g2, r3);
            }
        } else if (channelType == ChannelType.OPEN) {
            OpenChannel.getChannelInternal(g2, r2);
        } else {
            GroupChannel.getChannelInternal(g2, r3);
        }
    }

    public String toString() {
        return "BaseChannel{mUrl='" + this.mUrl + '\'' + ", mName='" + this.mName + '\'' + ", mCoverUrl='" + this.mCoverUrl + '\'' + ", mCreatedAt=" + this.mCreatedAt + ", mData='" + this.mData + '\'' + ", mFreeze=" + this.mFreeze + ", mIsEphemeral=" + this.mIsEphemeral + ", mDirty=" + this.mDirty + ", mSendFileMessageDataList=" + this.mSendFileMessageDataList + ", mIsSendingFileMessage=" + this.mIsSendingFileMessage + '}';
    }

    public boolean equals(Object obj) {
        if (obj != null && obj.getClass() == getClass()) {
            BaseChannel baseChannel = (BaseChannel) obj;
            if (!getUrl().equals(baseChannel.getUrl()) || getCreatedAt() != baseChannel.getCreatedAt()) {
                return false;
            }
            return true;
        }
        return false;
    }

    public int hashCode() {
        return p.a(getUrl(), Long.valueOf(getCreatedAt()));
    }
}
