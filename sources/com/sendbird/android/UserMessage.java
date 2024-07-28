package com.sendbird.android;

import com.sendbird.android.BaseChannel;
import com.sendbird.android.BaseMessage;
import com.sendbird.android.BaseMessageParams;
import com.sendbird.android.constant.StringSet;
import com.sendbird.android.shadow.com.google.gson.JsonArray;
import com.sendbird.android.shadow.com.google.gson.JsonElement;
import com.sendbird.android.shadow.com.google.gson.JsonObject;
import com.sendbird.android.shadow.com.google.gson.JsonParser;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserMessage extends BaseMessage {
    private String mMessage;
    private String mReqId;
    private HashMap<String, String> mTranslations;

    @Deprecated
    public enum RequestState {
        NONE,
        PENDING,
        FAILED,
        SUCCEEDED
    }

    static JsonElement build(String str, BaseMessage.SendingStatus sendingStatus, long j, long j2, long j3, Sender sender, String str2, String str3, String str4, String str5, String str6, String str7, long j4, long j5, BaseMessageParams.MentionType mentionType, List<String> list, String str8, String str9, String str10, String str11, String str12, boolean z, int i2, boolean z2, boolean z3, int i3, String str13, ThreadInfo threadInfo, OGMetaData oGMetaData, boolean z4) {
        String str14 = str5;
        String str15 = str6;
        String str16 = str7;
        BaseMessageParams.MentionType mentionType2 = mentionType;
        String str17 = str8;
        String str18 = str9;
        String str19 = str10;
        String str20 = str11;
        String str21 = str12;
        String str22 = str13;
        JsonObject jsonObject = new JsonObject();
        String str23 = str;
        jsonObject.addProperty("req_id", str);
        jsonObject.addProperty("request_state", sendingStatus.getValue());
        jsonObject.addProperty(StringSet.msg_id, (Number) Long.valueOf(j));
        jsonObject.addProperty(StringSet.root_message_id, (Number) Long.valueOf(j2));
        jsonObject.addProperty(StringSet.parent_message_id, (Number) Long.valueOf(j3));
        jsonObject.addProperty(StringSet.channel_url, str2);
        jsonObject.addProperty(StringSet.channel_type, str3);
        jsonObject.addProperty(StringSet.ts, (Number) Long.valueOf(j4));
        jsonObject.addProperty(StringSet.updated_at, (Number) Long.valueOf(j5));
        jsonObject.addProperty("message", str4);
        if (str14 != null) {
            jsonObject.addProperty("data", str14);
        }
        if (str15 != null) {
            jsonObject.addProperty(StringSet.custom_type, str15);
        }
        if (str16 != null) {
            jsonObject.add("translations", new JsonParser().parse(str16));
        }
        if (sender != null) {
            jsonObject.add(StringSet.user, sender.toJson().getAsJsonObject());
        }
        if (mentionType2 == BaseMessageParams.MentionType.USERS) {
            jsonObject.addProperty(StringSet.mention_type, StringSet.users);
        } else if (mentionType2 == BaseMessageParams.MentionType.CHANNEL) {
            jsonObject.addProperty(StringSet.mention_type, "channel");
        }
        if (list != null && list.size() > 0) {
            JsonArray jsonArray = new JsonArray();
            for (String next : list) {
                if (next != null && next.length() > 0) {
                    jsonArray.add(next);
                }
            }
            jsonObject.add(StringSet.mentioned_user_ids, jsonArray);
        }
        if (str17 != null) {
            jsonObject.add("mentioned_users", new JsonParser().parse(str17));
        }
        if (str18 != null) {
            jsonObject.add("reactions", new JsonParser().parse(str18));
        }
        if (str19 != null) {
            jsonObject.add("metaarray", new JsonParser().parse(str19));
        }
        if (str20 != null) {
            jsonObject.add("metaarray_key_order", new JsonParser().parse(str20));
        }
        if (str21 != null) {
            jsonObject.add("sorted_metaarray", new JsonParser().parse(str21));
        }
        jsonObject.addProperty("is_global_block", Boolean.valueOf(z));
        jsonObject.addProperty("error_code", (Number) Integer.valueOf(i2));
        jsonObject.addProperty("silent", Boolean.valueOf(z2));
        jsonObject.addProperty("force_update_last_message", Boolean.valueOf(z3));
        jsonObject.addProperty(StringSet.message_survival_seconds, (Number) Integer.valueOf(i3));
        if (str22 != null) {
            jsonObject.addProperty(StringSet.parent_message_text, str22);
        }
        jsonObject.add(StringSet.thread_info, threadInfo.toJson());
        if (oGMetaData != null) {
            jsonObject.add(StringSet.og_tag, oGMetaData.toJson());
        }
        jsonObject.addProperty(StringSet.is_op_msg, Boolean.valueOf(z4));
        return jsonObject;
    }

    UserMessage(JsonElement jsonElement) {
        super(jsonElement);
        String str = "";
        this.mMessage = str;
        JsonObject asJsonObject = jsonElement.getAsJsonObject();
        this.mMessage = asJsonObject.get("message").getAsString();
        this.mData = asJsonObject.has("data") ? asJsonObject.get("data").getAsString() : str;
        this.mReqId = str;
        if (asJsonObject.has("request_id")) {
            this.mReqId = asJsonObject.get("request_id").getAsString();
        }
        if (asJsonObject.has("req_id")) {
            this.mReqId = asJsonObject.get("req_id").getAsString();
        }
        this.mCustomType = asJsonObject.has(StringSet.custom_type) ? asJsonObject.get(StringSet.custom_type).getAsString() : str;
        this.mTranslations = new HashMap<>();
        if (asJsonObject.has("translations")) {
            for (Map.Entry next : asJsonObject.get("translations").getAsJsonObject().entrySet()) {
                this.mTranslations.put(next.getKey(), ((JsonElement) next.getValue()).getAsString());
            }
        }
        this.mErrorCode = asJsonObject.has("error_code") ? asJsonObject.get("error_code").getAsInt() : 0;
    }

    /* access modifiers changed from: package-private */
    public JsonElement toJson() {
        JsonObject asJsonObject = super.toJson().getAsJsonObject();
        asJsonObject.addProperty("type", BaseChannel.MessageTypeFilter.USER.value());
        asJsonObject.addProperty("req_id", this.mReqId);
        asJsonObject.addProperty("message", this.mMessage);
        asJsonObject.addProperty("data", this.mData);
        asJsonObject.addProperty(StringSet.custom_type, this.mCustomType);
        JsonObject jsonObject = new JsonObject();
        for (Map.Entry next : this.mTranslations.entrySet()) {
            jsonObject.addProperty((String) next.getKey(), (String) next.getValue());
        }
        asJsonObject.add("translations", jsonObject);
        asJsonObject.addProperty("error_code", (Number) Integer.valueOf(this.mErrorCode));
        return asJsonObject;
    }

    public String getMessage() {
        return this.mMessage;
    }

    public String getRequestId() {
        return this.mReqId;
    }

    public Map<String, String> getTranslations() {
        return this.mTranslations;
    }

    @Deprecated
    public RequestState getRequestState() {
        if (getSendingStatus() == BaseMessage.SendingStatus.SUCCEEDED) {
            return RequestState.SUCCEEDED;
        }
        if (getSendingStatus() == BaseMessage.SendingStatus.FAILED) {
            return RequestState.FAILED;
        }
        if (getSendingStatus() == BaseMessage.SendingStatus.PENDING) {
            return RequestState.PENDING;
        }
        if (getSendingStatus() == BaseMessage.SendingStatus.CANCELED) {
            return RequestState.FAILED;
        }
        return RequestState.NONE;
    }

    public List<String> getRequestedMentionUserIds() {
        if (getSendingStatus() == BaseMessage.SendingStatus.PENDING || getSendingStatus() == BaseMessage.SendingStatus.FAILED || getSendingStatus() == BaseMessage.SendingStatus.CANCELED) {
            return getMentionedUserIds();
        }
        return new ArrayList();
    }

    public String toString() {
        return super.toString() + "\nUserMessage{mMessage='" + this.mMessage + '\'' + ", mReqId='" + this.mReqId + '\'' + ", mTranslations=" + this.mTranslations + '}';
    }
}
