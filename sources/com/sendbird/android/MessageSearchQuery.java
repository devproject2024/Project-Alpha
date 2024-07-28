package com.sendbird.android;

import android.text.TextUtils;
import android.util.Base64;
import com.sendbird.android.constant.StringSet;
import com.sendbird.android.log.Logger;
import com.sendbird.android.shadow.com.google.gson.JsonArray;
import com.sendbird.android.shadow.com.google.gson.JsonElement;
import com.sendbird.android.shadow.com.google.gson.JsonObject;
import com.sendbird.android.shadow.com.google.gson.JsonParser;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class MessageSearchQuery {
    /* access modifiers changed from: private */
    public final String channelCustomType;
    /* access modifiers changed from: private */
    public final String channelUrl;
    /* access modifiers changed from: private */
    public String endToken;
    /* access modifiers changed from: private */
    public final boolean exactMatch;
    /* access modifiers changed from: private */
    public boolean hasNext;
    /* access modifiers changed from: private */
    public final String keyword;
    /* access modifiers changed from: private */
    public final int limit;
    private boolean loading;
    /* access modifiers changed from: private */
    public final Long messageTimestampFrom;
    /* access modifiers changed from: private */
    public final Long messageTimestampTo;
    /* access modifiers changed from: private */
    public final Order order;
    /* access modifiers changed from: private */
    public final boolean reverse;
    /* access modifiers changed from: private */
    public int totalCount;

    public interface MessageSearchQueryResultHandler {
        void onResult(List<BaseMessage> list, SendBirdException sendBirdException);
    }

    public enum Order {
        SCORE("score"),
        TIMESTAMP(StringSet.ts);
        
        private String value;

        private Order(String str) {
            this.value = str;
        }

        public static Order fromValue(String str) {
            for (Order order : values()) {
                if (order.getValue().equalsIgnoreCase(str)) {
                    return order;
                }
            }
            return SCORE;
        }

        public final String getValue() {
            return this.value;
        }
    }

    public static class Builder {
        private static final int MESSAGE_SEARCH_QUERY_DEFAULT_LIMIT = 20;
        private String channelCustomType = null;
        private String channelUrl = "";
        private boolean exactMatch = false;
        private String keyword = "";
        private int limit = 20;
        private Long messageTimestampFrom = null;
        private Long messageTimestampTo = null;
        private Order order = Order.SCORE;
        private boolean reverse = false;

        public Builder setLimit(int i2) {
            this.limit = i2;
            return this;
        }

        public Builder setReverse(boolean z) {
            this.reverse = z;
            return this;
        }

        public Builder setKeyword(String str) {
            this.keyword = str;
            return this;
        }

        public Builder setExactMatch(boolean z) {
            this.exactMatch = z;
            return this;
        }

        public Builder setChannelUrl(String str) {
            this.channelUrl = str;
            return this;
        }

        public Builder setChannelCustomType(String str) {
            this.channelCustomType = str;
            return this;
        }

        public Builder setMessageTimestampFrom(long j) {
            this.messageTimestampFrom = Long.valueOf(j);
            return this;
        }

        public Builder setMessageTimestampTo(long j) {
            this.messageTimestampTo = Long.valueOf(j);
            return this;
        }

        public Builder setOrder(Order order2) {
            this.order = order2;
            return this;
        }

        public MessageSearchQuery build() {
            return new MessageSearchQuery(this.limit, this.reverse, this.keyword, this.exactMatch, this.channelUrl, this.channelCustomType, this.messageTimestampFrom, this.messageTimestampTo, this.order);
        }
    }

    private MessageSearchQuery(int i2, boolean z, String str, boolean z2, String str2, String str3, Long l, Long l2, Order order2) {
        this.loading = false;
        this.hasNext = true;
        this.totalCount = 0;
        this.endToken = null;
        this.limit = i2;
        this.reverse = z;
        this.keyword = str;
        this.exactMatch = z2;
        this.channelUrl = str2;
        this.channelCustomType = str3;
        this.messageTimestampFrom = l;
        this.messageTimestampTo = l2;
        this.order = order2;
    }

    MessageSearchQuery(JsonElement jsonElement) {
        boolean z = false;
        this.loading = false;
        boolean z2 = true;
        this.hasNext = true;
        this.totalCount = 0;
        Long l = null;
        this.endToken = null;
        JsonObject asJsonObject = jsonElement.getAsJsonObject();
        this.hasNext = asJsonObject.has(StringSet.has_next) ? asJsonObject.get(StringSet.has_next).getAsBoolean() : z2;
        this.endToken = asJsonObject.has(StringSet.token) ? asJsonObject.get(StringSet.token).getAsString() : null;
        this.totalCount = asJsonObject.has("total_count") ? asJsonObject.get("total_count").getAsInt() : 0;
        this.limit = asJsonObject.has("limit") ? asJsonObject.get("limit").getAsInt() : 20;
        this.reverse = asJsonObject.has(StringSet.reverse) ? asJsonObject.get(StringSet.reverse).getAsBoolean() : false;
        String str = "";
        this.keyword = asJsonObject.has("query") ? asJsonObject.get("query").getAsString() : str;
        this.exactMatch = asJsonObject.has("exact_match") ? asJsonObject.get("exact_match").getAsBoolean() : z;
        this.channelUrl = asJsonObject.has(StringSet.channel_url) ? asJsonObject.get(StringSet.channel_url).getAsString() : str;
        this.channelCustomType = asJsonObject.has(StringSet.custom_type) ? asJsonObject.get(StringSet.custom_type).getAsString() : null;
        this.messageTimestampFrom = asJsonObject.has("message_ts_from") ? Long.valueOf(asJsonObject.get("message_ts_from").getAsLong()) : null;
        this.messageTimestampTo = asJsonObject.has("message_ts_to") ? Long.valueOf(asJsonObject.get("message_ts_to").getAsLong()) : l;
        this.order = asJsonObject.has("sort_field") ? Order.fromValue(asJsonObject.get("sort_field").getAsString()) : Order.SCORE;
    }

    /* access modifiers changed from: package-private */
    public final JsonElement toJson() {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty(StringSet.has_next, Boolean.valueOf(this.hasNext));
        jsonObject.addProperty("end_cursor", this.endToken);
        jsonObject.addProperty("total_count", (Number) Integer.valueOf(this.totalCount));
        jsonObject.addProperty("limit", (Number) Integer.valueOf(this.limit));
        jsonObject.addProperty(StringSet.reverse, Boolean.valueOf(this.reverse));
        jsonObject.addProperty("query", this.keyword);
        jsonObject.addProperty("exact_match", Boolean.valueOf(this.exactMatch));
        String str = this.channelUrl;
        if (str != null) {
            jsonObject.addProperty(StringSet.channel_url, str);
        }
        String str2 = this.channelCustomType;
        if (str2 != null) {
            jsonObject.addProperty(StringSet.custom_type, str2);
        }
        jsonObject.addProperty("message_ts_from", (Number) this.messageTimestampFrom);
        jsonObject.addProperty("message_ts_to", (Number) this.messageTimestampTo);
        jsonObject.addProperty("sort_field", this.order.getValue());
        return jsonObject;
    }

    /* access modifiers changed from: package-private */
    public final synchronized void setLoading(boolean z) {
        this.loading = z;
    }

    public final synchronized void next(final MessageSearchQueryResultHandler messageSearchQueryResultHandler) {
        if (isLoading()) {
            SendBird.runOnUIThread(new Runnable() {
                public final void run() {
                    MessageSearchQueryResultHandler messageSearchQueryResultHandler = messageSearchQueryResultHandler;
                    if (messageSearchQueryResultHandler != null) {
                        messageSearchQueryResultHandler.onResult((List<BaseMessage>) null, new SendBirdException("Query in progress.", SendBirdError.ERR_QUERY_IN_PROGRESS));
                    }
                }
            });
        } else if (!hasNext()) {
            SendBird.runOnUIThread(new Runnable() {
                public final void run() {
                    MessageSearchQueryResultHandler messageSearchQueryResultHandler = messageSearchQueryResultHandler;
                    if (messageSearchQueryResultHandler != null) {
                        messageSearchQueryResultHandler.onResult(new ArrayList(), (SendBirdException) null);
                    }
                }
            });
        } else {
            setLoading(true);
            d.a(new q<List<BaseMessage>>() {
                public final /* synthetic */ void a(Object obj, SendBirdException sendBirdException) {
                    List list = (List) obj;
                    MessageSearchQuery.this.setLoading(false);
                    MessageSearchQueryResultHandler messageSearchQueryResultHandler = messageSearchQueryResultHandler;
                    if (messageSearchQueryResultHandler != null) {
                        messageSearchQueryResultHandler.onResult(list, sendBirdException);
                    }
                }

                /* access modifiers changed from: private */
                /* renamed from: a */
                public List<BaseMessage> call() throws Exception {
                    APIClient a2 = APIClient.a();
                    String access$100 = MessageSearchQuery.this.keyword;
                    String access$200 = MessageSearchQuery.this.channelUrl;
                    String access$300 = MessageSearchQuery.this.channelCustomType;
                    int access$400 = MessageSearchQuery.this.limit;
                    String access$500 = MessageSearchQuery.this.endToken;
                    Long access$600 = MessageSearchQuery.this.messageTimestampFrom;
                    Long access$700 = MessageSearchQuery.this.messageTimestampTo;
                    String value = MessageSearchQuery.this.order.getValue();
                    boolean access$900 = MessageSearchQuery.this.reverse;
                    boolean access$1000 = MessageSearchQuery.this.exactMatch;
                    if (SendBird.getCurrentUser() != null) {
                        HashMap hashMap = new HashMap();
                        hashMap.put("query", access$100);
                        if (!TextUtils.isEmpty(access$200)) {
                            hashMap.put(StringSet.channel_url, access$200);
                        }
                        if (!TextUtils.isEmpty(access$300)) {
                            hashMap.put(StringSet.custom_type, access$300);
                        }
                        hashMap.put("limit", String.valueOf(access$400));
                        if (access$500 != null) {
                            hashMap.put("after", String.valueOf(access$500));
                        }
                        String str = null;
                        if (!TextUtils.isEmpty((CharSequence) null)) {
                            hashMap.put(StringSet.token, (Object) null);
                        }
                        if (access$600 != null) {
                            hashMap.put("message_ts_from", String.valueOf(access$600));
                        }
                        if (access$700 != null) {
                            hashMap.put("message_ts_to", String.valueOf(access$700));
                        }
                        hashMap.put("sort_field", value);
                        hashMap.put(StringSet.reverse, String.valueOf(access$900));
                        hashMap.put("exact_match", String.valueOf(access$1000));
                        JsonObject asJsonObject = a2.a(b.SEARCH_MESSAGES.publicUrl(), (Map<String, String>) hashMap, (Map<String, Collection<String>>) null).getAsJsonObject();
                        MessageSearchQuery messageSearchQuery = MessageSearchQuery.this;
                        if (asJsonObject.has("end_cursor")) {
                            str = asJsonObject.get("end_cursor").getAsString();
                        }
                        String unused = messageSearchQuery.endToken = str;
                        boolean unused2 = MessageSearchQuery.this.hasNext = asJsonObject.has(StringSet.has_next) ? asJsonObject.get(StringSet.has_next).getAsBoolean() : !TextUtils.isEmpty(MessageSearchQuery.this.endToken);
                        int unused3 = MessageSearchQuery.this.totalCount = asJsonObject.has("total_count") ? asJsonObject.get("total_count").getAsInt() : 0;
                        JsonArray asJsonArray = asJsonObject.get("results").getAsJsonArray();
                        ArrayList arrayList = new ArrayList();
                        for (int i2 = 0; i2 < asJsonArray.size(); i2++) {
                            JsonElement jsonElement = asJsonArray.get(i2);
                            if (jsonElement.isJsonObject()) {
                                JsonObject asJsonObject2 = jsonElement.getAsJsonObject().get("channel").getAsJsonObject();
                                try {
                                    arrayList.add(BaseMessage.build(jsonElement, asJsonObject2.get(StringSet.channel_url).getAsString(), asJsonObject2.get(StringSet.channel_type).getAsString()));
                                } catch (Exception e2) {
                                    Logger.e((Throwable) e2);
                                }
                            }
                        }
                        return arrayList;
                    }
                    throw u.b();
                }
            });
        }
    }

    public static MessageSearchQuery buildFromSerializedData(byte[] bArr) {
        if (bArr != null) {
            byte[] bArr2 = new byte[bArr.length];
            for (int i2 = 0; i2 < bArr.length; i2++) {
                bArr2[i2] = (byte) (bArr[i2] ^ (i2 & 255));
            }
            try {
                return new MessageSearchQuery(new JsonParser().parse(new String(Base64.decode(bArr2, 0), AppConstants.UTF_8)));
            } catch (UnsupportedEncodingException e2) {
                Logger.e((Throwable) e2);
            }
        }
        return null;
    }

    public final byte[] serialize() {
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

    public final boolean hasNext() {
        return this.hasNext;
    }

    public final synchronized boolean isLoading() {
        return this.loading;
    }

    public final int getLimit() {
        return this.limit;
    }

    public final boolean isReverse() {
        return this.reverse;
    }

    public final String getKeyword() {
        return this.keyword;
    }

    public final boolean isExactMatch() {
        return this.exactMatch;
    }

    public final String getChannelUrl() {
        return this.channelUrl;
    }

    public final String getChannelCustomType() {
        return this.channelCustomType;
    }

    public final long getMessageTimestampFrom() {
        return this.messageTimestampFrom.longValue();
    }

    public final long getMessageTimestampTo() {
        return this.messageTimestampTo.longValue();
    }

    public final Order getOrder() {
        return this.order;
    }
}
