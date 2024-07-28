package com.sendbird.android;

import com.sendbird.android.BaseChannel;
import com.sendbird.android.BaseMessage;
import com.sendbird.android.BaseMessageParams;
import com.sendbird.android.constant.StringSet;
import com.sendbird.android.shadow.com.google.gson.JsonArray;
import com.sendbird.android.shadow.com.google.gson.JsonElement;
import com.sendbird.android.shadow.com.google.gson.JsonObject;
import com.sendbird.android.shadow.com.google.gson.JsonParser;
import java.util.List;

public final class AdminMessage extends BaseMessage {
    private String mMessage;

    public final int getMessageSurvivalSeconds() {
        return -1;
    }

    public final String getRequestId() {
        return "";
    }

    public final Sender getSender() {
        return null;
    }

    public final boolean isResendable() {
        return false;
    }

    static JsonElement build(long j, long j2, long j3, String str, String str2, String str3, String str4, String str5, long j4, long j5, BaseMessageParams.MentionType mentionType, List<String> list, String str6, String str7, String str8, String str9, String str10, boolean z, boolean z2, boolean z3, int i2, String str11, ThreadInfo threadInfo, OGMetaData oGMetaData) {
        String str12 = str4;
        String str13 = str5;
        BaseMessageParams.MentionType mentionType2 = mentionType;
        String str14 = str6;
        String str15 = str7;
        String str16 = str8;
        String str17 = str9;
        String str18 = str10;
        String str19 = str11;
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty(StringSet.msg_id, (Number) Long.valueOf(j));
        jsonObject.addProperty(StringSet.root_message_id, (Number) Long.valueOf(j2));
        jsonObject.addProperty(StringSet.parent_message_id, (Number) Long.valueOf(j3));
        jsonObject.addProperty(StringSet.channel_url, str);
        jsonObject.addProperty(StringSet.channel_type, str2);
        jsonObject.addProperty(StringSet.ts, (Number) Long.valueOf(j4));
        jsonObject.addProperty(StringSet.updated_at, (Number) Long.valueOf(j5));
        jsonObject.addProperty("message", str3);
        if (str12 != null) {
            jsonObject.addProperty("data", str12);
        }
        if (str13 != null) {
            jsonObject.addProperty(StringSet.custom_type, str13);
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
        if (str14 != null) {
            jsonObject.add("mentioned_users", new JsonParser().parse(str14));
        }
        if (str15 != null) {
            jsonObject.add("reactions", new JsonParser().parse(str15));
        }
        if (str16 != null) {
            jsonObject.add("metaarray", new JsonParser().parse(str16));
        }
        if (str17 != null) {
            jsonObject.add("metaarray_key_order", new JsonParser().parse(str17));
        }
        if (str18 != null) {
            jsonObject.add("sorted_metaarray", new JsonParser().parse(str18));
        }
        jsonObject.addProperty("is_global_block", Boolean.valueOf(z));
        jsonObject.addProperty("silent", Boolean.valueOf(z2));
        jsonObject.addProperty("force_update_last_message", Boolean.valueOf(z3));
        jsonObject.addProperty(StringSet.message_survival_seconds, (Number) Integer.valueOf(i2));
        if (str19 != null) {
            jsonObject.addProperty(StringSet.parent_message_text, str19);
        }
        jsonObject.add(StringSet.thread_info, threadInfo.toJson());
        if (oGMetaData != null) {
            jsonObject.add(StringSet.og_tag, oGMetaData.toJson());
        }
        return jsonObject;
    }

    AdminMessage(JsonElement jsonElement) {
        super(jsonElement);
        String str = "";
        this.mMessage = str;
        JsonObject asJsonObject = jsonElement.getAsJsonObject();
        this.mMessage = asJsonObject.get("message").getAsString();
        this.mData = asJsonObject.has("data") ? asJsonObject.get("data").getAsString() : str;
        this.mCustomType = asJsonObject.has(StringSet.custom_type) ? asJsonObject.get(StringSet.custom_type).getAsString() : str;
    }

    /* access modifiers changed from: package-private */
    public final JsonElement toJson() {
        JsonObject asJsonObject = super.toJson().getAsJsonObject();
        asJsonObject.addProperty("type", BaseChannel.MessageTypeFilter.ADMIN.value());
        asJsonObject.addProperty("message", this.mMessage);
        asJsonObject.addProperty("data", this.mData);
        asJsonObject.addProperty(StringSet.custom_type, this.mCustomType);
        return asJsonObject;
    }

    public final String getMessage() {
        return this.mMessage;
    }

    public final BaseMessage.SendingStatus getSendingStatus() {
        return BaseMessage.SendingStatus.NONE;
    }

    public final String toString() {
        return super.toString() + "\nAdminMessage{mMessage='" + this.mMessage + '}';
    }
}
