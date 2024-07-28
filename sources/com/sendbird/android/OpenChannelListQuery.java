package com.sendbird.android;

import com.sendbird.android.constant.StringSet;
import com.sendbird.android.shadow.com.google.gson.JsonArray;
import com.sendbird.android.shadow.com.google.gson.JsonObject;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class OpenChannelListQuery {
    /* access modifiers changed from: private */
    public boolean includeFrozen = true;
    /* access modifiers changed from: private */
    public String mCustomType;
    /* access modifiers changed from: private */
    public String mCustomTypeStartsWith;
    /* access modifiers changed from: private */
    public ArrayList<String> mCustomTypes;
    /* access modifiers changed from: private */
    public boolean mHasNext = true;
    /* access modifiers changed from: private */
    public int mLimit = 20;
    private boolean mLoading = false;
    /* access modifiers changed from: private */
    public String mNameKeyword;
    /* access modifiers changed from: private */
    public String mToken = "";
    /* access modifiers changed from: private */
    public String mUrlKeyword;

    public interface OpenChannelListQueryResultHandler {
        void onResult(List<OpenChannel> list, SendBirdException sendBirdException);
    }

    OpenChannelListQuery() {
    }

    public final void setLimit(int i2) {
        this.mLimit = i2;
    }

    public final void setNameKeyword(String str) {
        this.mNameKeyword = str;
    }

    public final void setUrlKeyword(String str) {
        this.mUrlKeyword = str;
    }

    public final void setCustomTypeFilter(String str) {
        this.mCustomType = str;
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

    public final boolean isIncludeFrozen() {
        return this.includeFrozen;
    }

    public final void setIncludeFrozen(boolean z) {
        this.includeFrozen = z;
    }

    public final synchronized void next(final OpenChannelListQueryResultHandler openChannelListQueryResultHandler) {
        if (isLoading()) {
            SendBird.runOnUIThread(new Runnable() {
                public final void run() {
                    OpenChannelListQueryResultHandler openChannelListQueryResultHandler = openChannelListQueryResultHandler;
                    if (openChannelListQueryResultHandler != null) {
                        openChannelListQueryResultHandler.onResult((List<OpenChannel>) null, new SendBirdException("Query in progress.", SendBirdError.ERR_QUERY_IN_PROGRESS));
                    }
                }
            });
        } else if (!hasNext()) {
            SendBird.runOnUIThread(new Runnable() {
                public final void run() {
                    OpenChannelListQueryResultHandler openChannelListQueryResultHandler = openChannelListQueryResultHandler;
                    if (openChannelListQueryResultHandler != null) {
                        openChannelListQueryResultHandler.onResult(new ArrayList(), (SendBirdException) null);
                    }
                }
            });
        } else {
            setLoading(true);
            d.a(new q<List<OpenChannel>>() {
                public final /* synthetic */ void a(Object obj, SendBirdException sendBirdException) {
                    List list = (List) obj;
                    OpenChannelListQuery.this.setLoading(false);
                    OpenChannelListQueryResultHandler openChannelListQueryResultHandler = openChannelListQueryResultHandler;
                    if (openChannelListQueryResultHandler != null) {
                        openChannelListQueryResultHandler.onResult(list, sendBirdException);
                    }
                }

                public final /* synthetic */ Object call() throws Exception {
                    APIClient a2 = APIClient.a();
                    String access$000 = OpenChannelListQuery.this.mToken;
                    int access$100 = OpenChannelListQuery.this.mLimit;
                    String access$200 = OpenChannelListQuery.this.mNameKeyword;
                    String access$300 = OpenChannelListQuery.this.mUrlKeyword;
                    String access$400 = OpenChannelListQuery.this.mCustomType;
                    String access$500 = OpenChannelListQuery.this.mCustomTypeStartsWith;
                    ArrayList access$600 = OpenChannelListQuery.this.mCustomTypes;
                    boolean access$700 = OpenChannelListQuery.this.includeFrozen;
                    String publicUrl = b.OPENCHANNELS.publicUrl();
                    HashMap hashMap = new HashMap();
                    hashMap.put(StringSet.token, access$000);
                    hashMap.put("limit", String.valueOf(access$100));
                    if (access$400 != null) {
                        hashMap.put(StringSet.custom_type, access$400);
                    }
                    if (access$200 != null) {
                        hashMap.put(StringSet.name_contains, access$200);
                    }
                    if (access$300 != null) {
                        hashMap.put(StringSet.url_contains, access$300);
                    }
                    if (access$500 != null) {
                        hashMap.put(StringSet.custom_type_startswith, access$500);
                    }
                    HashMap hashMap2 = new HashMap();
                    if (access$600 != null && access$600.size() > 0) {
                        hashMap2.put(StringSet.custom_types, access$600);
                    }
                    hashMap.put(StringSet.show_frozen, String.valueOf(access$700));
                    JsonObject asJsonObject = a2.a(publicUrl, (Map<String, String>) hashMap, (Map<String, Collection<String>>) hashMap2).getAsJsonObject();
                    String unused = OpenChannelListQuery.this.mToken = asJsonObject.get("next").getAsString();
                    if (OpenChannelListQuery.this.mToken == null || OpenChannelListQuery.this.mToken.length() <= 0) {
                        boolean unused2 = OpenChannelListQuery.this.mHasNext = false;
                    }
                    JsonArray asJsonArray = asJsonObject.get("channels").getAsJsonArray();
                    ArrayList arrayList = new ArrayList();
                    for (int i2 = 0; i2 < asJsonArray.size(); i2++) {
                        arrayList.add(OpenChannel.upsert(asJsonArray.get(i2), false));
                    }
                    return arrayList;
                }
            });
        }
    }
}
