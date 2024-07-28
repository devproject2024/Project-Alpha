package com.sendbird.android;

import com.sendbird.android.constant.StringSet;
import com.sendbird.android.shadow.com.google.gson.JsonArray;
import com.sendbird.android.shadow.com.google.gson.JsonObject;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class OperatorListQuery {
    /* access modifiers changed from: private */
    public BaseChannel mChannel;
    /* access modifiers changed from: private */
    public boolean mHasNext = true;
    /* access modifiers changed from: private */
    public int mLimit = 20;
    private boolean mLoading = false;
    /* access modifiers changed from: private */
    public String mToken = "";

    public interface OperatorListQueryResultHandler {
        void onResult(List<User> list, SendBirdException sendBirdException);
    }

    OperatorListQuery(BaseChannel baseChannel) {
        this.mChannel = baseChannel;
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

    public final synchronized void next(final OperatorListQueryResultHandler operatorListQueryResultHandler) {
        if (isLoading()) {
            SendBird.runOnUIThread(new Runnable() {
                public final void run() {
                    OperatorListQueryResultHandler operatorListQueryResultHandler = operatorListQueryResultHandler;
                    if (operatorListQueryResultHandler != null) {
                        operatorListQueryResultHandler.onResult((List<User>) null, new SendBirdException("Query in progress.", SendBirdError.ERR_QUERY_IN_PROGRESS));
                    }
                }
            });
            return;
        }
        setLoading(true);
        d.a(new q<List<User>>() {
            public final /* synthetic */ void a(Object obj, SendBirdException sendBirdException) {
                List list = (List) obj;
                OperatorListQuery.this.setLoading(false);
                OperatorListQueryResultHandler operatorListQueryResultHandler = operatorListQueryResultHandler;
                if (operatorListQueryResultHandler != null) {
                    operatorListQueryResultHandler.onResult(list, sendBirdException);
                }
            }

            public final /* synthetic */ Object call() throws Exception {
                String str;
                if (!OperatorListQuery.this.hasNext()) {
                    return new ArrayList();
                }
                APIClient a2 = APIClient.a();
                boolean z = OperatorListQuery.this.mChannel instanceof OpenChannel;
                String url = OperatorListQuery.this.mChannel.getUrl();
                String access$100 = OperatorListQuery.this.mToken;
                int access$200 = OperatorListQuery.this.mLimit;
                if (z) {
                    str = String.format(b.OPENCHANNELS_CHANNELURL_OPERATORS.publicUrl(), new Object[]{b.urlEncodeUTF8(url)});
                } else {
                    str = String.format(b.GROUPCHANNELS_CHANNELURL_OPERATORS.publicUrl(), new Object[]{b.urlEncodeUTF8(url)});
                }
                HashMap hashMap = new HashMap();
                hashMap.put(StringSet.token, access$100);
                hashMap.put("limit", String.valueOf(access$200));
                JsonArray jsonArray = null;
                JsonObject asJsonObject = a2.a(str, (Map<String, String>) hashMap, (Map<String, Collection<String>>) null).getAsJsonObject();
                String unused = OperatorListQuery.this.mToken = asJsonObject.get("next").getAsString();
                if (OperatorListQuery.this.mToken == null || OperatorListQuery.this.mToken.length() <= 0) {
                    boolean unused2 = OperatorListQuery.this.mHasNext = false;
                }
                ArrayList arrayList = new ArrayList();
                if (asJsonObject.has("operators")) {
                    jsonArray = asJsonObject.get("operators").getAsJsonArray();
                }
                if (jsonArray != null) {
                    for (int i2 = 0; i2 < jsonArray.size(); i2++) {
                        arrayList.add(new User(jsonArray.get(i2)));
                    }
                }
                return arrayList;
            }
        });
    }
}
