package com.sendbird.android;

import com.sendbird.android.constant.StringSet;
import com.sendbird.android.shadow.com.google.gson.JsonArray;
import com.sendbird.android.shadow.com.google.gson.JsonElement;
import com.sendbird.android.shadow.com.google.gson.JsonObject;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserListQuery {
    /* access modifiers changed from: private */
    public BaseChannel mChannel;
    /* access modifiers changed from: private */
    public boolean mHasNext;
    /* access modifiers changed from: private */
    public String mJsonArrayName;
    /* access modifiers changed from: private */
    public int mLimit;
    private boolean mLoading;
    Map<String, List<String>> mMetaDataFilter;
    /* access modifiers changed from: private */
    public a mQueryType;
    /* access modifiers changed from: private */
    public String mToken;
    ArrayList<String> mUserIds;

    public interface UserListQueryResultHandler {
        void onResult(List<User> list, SendBirdException sendBirdException);
    }

    enum a {
        ALL_USER,
        FILTERED_USER,
        BLOCKED_USER,
        PARTICIPANT,
        MUTED_USER,
        BANNED_USER
    }

    UserListQuery(a aVar) {
        this.mToken = "";
        this.mLimit = 20;
        this.mHasNext = true;
        this.mLoading = false;
        this.mQueryType = aVar;
        switch (this.mQueryType) {
            case ALL_USER:
            case FILTERED_USER:
            case BLOCKED_USER:
                this.mJsonArrayName = StringSet.users;
                return;
            case PARTICIPANT:
                this.mJsonArrayName = "participants";
                return;
            case MUTED_USER:
                this.mJsonArrayName = "muted_list";
                return;
            case BANNED_USER:
                this.mJsonArrayName = "banned_list";
                return;
            default:
                return;
        }
    }

    UserListQuery(a aVar, BaseChannel baseChannel) {
        this(aVar);
        this.mChannel = baseChannel;
    }

    UserListQuery(a aVar, List<String> list) {
        this(aVar);
        if (list != null) {
            this.mUserIds = new ArrayList<>(list);
        }
    }

    public void setLimit(int i2) {
        this.mLimit = i2;
    }

    public boolean hasNext() {
        return this.mHasNext;
    }

    public synchronized boolean isLoading() {
        return this.mLoading;
    }

    /* access modifiers changed from: package-private */
    public synchronized void setLoading(boolean z) {
        this.mLoading = z;
    }

    @Deprecated
    public void setMetaDataFilter(String str, List<String> list) {
        if (str != null && list != null) {
            this.mMetaDataFilter = new HashMap();
            this.mMetaDataFilter.put(str, list);
        }
    }

    public synchronized void next(final UserListQueryResultHandler userListQueryResultHandler) {
        if (isLoading()) {
            SendBird.runOnUIThread(new Runnable() {
                public final void run() {
                    UserListQueryResultHandler userListQueryResultHandler = userListQueryResultHandler;
                    if (userListQueryResultHandler != null) {
                        userListQueryResultHandler.onResult((List<User>) null, new SendBirdException("Query in progress.", SendBirdError.ERR_QUERY_IN_PROGRESS));
                    }
                }
            });
        } else if (!hasNext()) {
            SendBird.runOnUIThread(new Runnable() {
                public final void run() {
                    UserListQueryResultHandler userListQueryResultHandler = userListQueryResultHandler;
                    if (userListQueryResultHandler != null) {
                        userListQueryResultHandler.onResult(new ArrayList(), (SendBirdException) null);
                    }
                }
            });
        } else {
            setLoading(true);
            d.a(new q<List<User>>() {
                public final /* synthetic */ void a(Object obj, SendBirdException sendBirdException) {
                    List list = (List) obj;
                    UserListQuery.this.setLoading(false);
                    UserListQueryResultHandler userListQueryResultHandler = userListQueryResultHandler;
                    if (userListQueryResultHandler != null) {
                        userListQueryResultHandler.onResult(list, sendBirdException);
                    }
                }

                public final /* synthetic */ Object call() throws Exception {
                    String str;
                    String str2;
                    ArrayList arrayList = new ArrayList();
                    JsonElement jsonElement = null;
                    switch (AnonymousClass4.f44697a[UserListQuery.this.mQueryType.ordinal()]) {
                        case 1:
                            jsonElement = APIClient.a().a(UserListQuery.this.mToken, UserListQuery.this.mLimit, (List<String>) null, UserListQuery.this.mMetaDataFilter);
                            break;
                        case 2:
                            jsonElement = APIClient.a().a(UserListQuery.this.mToken, UserListQuery.this.mLimit, (List<String>) UserListQuery.this.mUserIds, UserListQuery.this.mMetaDataFilter);
                            break;
                        case 3:
                            APIClient a2 = APIClient.a();
                            String access$100 = UserListQuery.this.mToken;
                            int access$200 = UserListQuery.this.mLimit;
                            ArrayList<String> arrayList2 = UserListQuery.this.mUserIds;
                            if (SendBird.getCurrentUser() != null) {
                                String format = String.format(b.USERS_USERID_BLOCK.publicUrl(), new Object[]{b.urlEncodeUTF8(SendBird.getCurrentUser().getUserId())});
                                HashMap hashMap = new HashMap();
                                hashMap.put(StringSet.token, access$100);
                                hashMap.put("limit", String.valueOf(access$200));
                                HashMap hashMap2 = new HashMap();
                                if (arrayList2 != null && arrayList2.size() > 0) {
                                    hashMap2.put("user_ids", arrayList2);
                                }
                                jsonElement = a2.a(format, (Map<String, String>) hashMap, (Map<String, Collection<String>>) hashMap2);
                                break;
                            } else {
                                throw u.b();
                            }
                        case 4:
                            APIClient a3 = APIClient.a();
                            String url = UserListQuery.this.mChannel.getUrl();
                            String access$1002 = UserListQuery.this.mToken;
                            int access$2002 = UserListQuery.this.mLimit;
                            String format2 = String.format(b.OPENCHANNELS_CHANNELURL_PARTICIPANTS.publicUrl(), new Object[]{b.urlEncodeUTF8(url)});
                            HashMap hashMap3 = new HashMap();
                            hashMap3.put(StringSet.token, access$1002);
                            hashMap3.put("limit", String.valueOf(access$2002));
                            jsonElement = a3.a(format2, (Map<String, String>) hashMap3, (Map<String, Collection<String>>) null);
                            break;
                        case 5:
                            APIClient a4 = APIClient.a();
                            boolean z = UserListQuery.this.mChannel instanceof OpenChannel;
                            String url2 = UserListQuery.this.mChannel.getUrl();
                            String access$1003 = UserListQuery.this.mToken;
                            int access$2003 = UserListQuery.this.mLimit;
                            if (z) {
                                str = String.format(b.OPENCHANNELS_CHANNELURL_MUTE.publicUrl(), new Object[]{b.urlEncodeUTF8(url2)});
                            } else {
                                str = String.format(b.GROUPCHANNELS_CHANNELURL_MUTE.publicUrl(), new Object[]{b.urlEncodeUTF8(url2)});
                            }
                            HashMap hashMap4 = new HashMap();
                            hashMap4.put(StringSet.token, access$1003);
                            hashMap4.put("limit", String.valueOf(access$2003));
                            jsonElement = a4.a(str, (Map<String, String>) hashMap4, (Map<String, Collection<String>>) null);
                            break;
                        case 6:
                            APIClient a5 = APIClient.a();
                            boolean z2 = UserListQuery.this.mChannel instanceof OpenChannel;
                            String url3 = UserListQuery.this.mChannel.getUrl();
                            String access$1004 = UserListQuery.this.mToken;
                            int access$2004 = UserListQuery.this.mLimit;
                            if (z2) {
                                str2 = String.format(b.OPENCHANNELS_CHANNELURL_BAN.publicUrl(), new Object[]{b.urlEncodeUTF8(url3)});
                            } else {
                                str2 = String.format(b.GROUPCHANNELS_CHANNELURL_BAN.publicUrl(), new Object[]{b.urlEncodeUTF8(url3)});
                            }
                            HashMap hashMap5 = new HashMap();
                            hashMap5.put(StringSet.token, access$1004);
                            hashMap5.put("limit", String.valueOf(access$2004));
                            jsonElement = a5.a(str2, (Map<String, String>) hashMap5, (Map<String, Collection<String>>) null);
                            break;
                    }
                    if (jsonElement != null) {
                        JsonObject asJsonObject = jsonElement.getAsJsonObject();
                        String unused = UserListQuery.this.mToken = asJsonObject.get("next").getAsString();
                        if (UserListQuery.this.mToken == null || UserListQuery.this.mToken.length() <= 0) {
                            boolean unused2 = UserListQuery.this.mHasNext = false;
                        }
                        JsonArray asJsonArray = asJsonObject.get(UserListQuery.this.mJsonArrayName).getAsJsonArray();
                        for (int i2 = 0; i2 < asJsonArray.size(); i2++) {
                            if (UserListQuery.this.mQueryType != a.BANNED_USER) {
                                arrayList.add(new User(asJsonArray.get(i2)));
                            } else {
                                arrayList.add(new User(asJsonArray.get(i2).getAsJsonObject().get(StringSet.user)));
                            }
                        }
                    }
                    return arrayList;
                }
            });
        }
    }
}
