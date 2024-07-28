package com.sendbird.android;

import com.sendbird.android.constant.StringSet;
import com.sendbird.android.shadow.com.google.gson.JsonArray;
import com.sendbird.android.shadow.com.google.gson.JsonObject;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class FriendListQuery {
    /* access modifiers changed from: private */
    public boolean mHasNext = true;
    /* access modifiers changed from: private */
    public int mLimit = 20;
    private boolean mLoading = false;
    /* access modifiers changed from: private */
    public String mToken = "";

    public interface FriendListQueryResultHandler {
        void onResult(List<User> list, SendBirdException sendBirdException);
    }

    FriendListQuery() {
    }

    public final void setLimit(int i2) {
        this.mLimit = i2;
    }

    public final boolean hasNext() {
        return this.mHasNext;
    }

    public final synchronized boolean isLoading() {
        return this.mLoading;
    }

    /* access modifiers changed from: package-private */
    public final synchronized void setLoading(boolean z) {
        this.mLoading = z;
    }

    public final synchronized void next(final FriendListQueryResultHandler friendListQueryResultHandler) {
        if (isLoading()) {
            SendBird.runOnUIThread(new Runnable() {
                public final void run() {
                    FriendListQueryResultHandler friendListQueryResultHandler = friendListQueryResultHandler;
                    if (friendListQueryResultHandler != null) {
                        friendListQueryResultHandler.onResult((List<User>) null, new SendBirdException("Query in progress.", SendBirdError.ERR_QUERY_IN_PROGRESS));
                    }
                }
            });
        } else if (!hasNext()) {
            SendBird.runOnUIThread(new Runnable() {
                public final void run() {
                    FriendListQueryResultHandler friendListQueryResultHandler = friendListQueryResultHandler;
                    if (friendListQueryResultHandler != null) {
                        friendListQueryResultHandler.onResult(new ArrayList(), (SendBirdException) null);
                    }
                }
            });
        } else {
            setLoading(true);
            d.a(new q<List<User>>() {
                public final /* synthetic */ void a(Object obj, SendBirdException sendBirdException) {
                    List list = (List) obj;
                    FriendListQuery.this.setLoading(false);
                    FriendListQueryResultHandler friendListQueryResultHandler = friendListQueryResultHandler;
                    if (friendListQueryResultHandler != null) {
                        friendListQueryResultHandler.onResult(list, sendBirdException);
                    }
                }

                public final /* synthetic */ Object call() throws Exception {
                    APIClient a2 = APIClient.a();
                    String access$000 = FriendListQuery.this.mToken;
                    int access$100 = FriendListQuery.this.mLimit;
                    if (SendBird.getCurrentUser() != null) {
                        String format = String.format(b.USERS_USERID_FRIENDS.publicUrl(), new Object[]{b.urlEncodeUTF8(SendBird.getCurrentUser().getUserId())});
                        HashMap hashMap = new HashMap();
                        if (access$000 != null) {
                            hashMap.put(StringSet.token, access$000);
                        }
                        hashMap.put("limit", String.valueOf(access$100));
                        JsonObject asJsonObject = a2.a(format, (Map<String, String>) hashMap, (Map<String, Collection<String>>) null).getAsJsonObject();
                        String unused = FriendListQuery.this.mToken = asJsonObject.get("next").getAsString();
                        if (FriendListQuery.this.mToken == null || FriendListQuery.this.mToken.length() <= 0) {
                            boolean unused2 = FriendListQuery.this.mHasNext = false;
                        }
                        JsonArray asJsonArray = asJsonObject.get(StringSet.users).getAsJsonArray();
                        ArrayList arrayList = new ArrayList();
                        for (int i2 = 0; i2 < asJsonArray.size(); i2++) {
                            arrayList.add(new User(asJsonArray.get(i2)));
                        }
                        return arrayList;
                    }
                    throw u.b();
                }
            });
        }
    }
}
