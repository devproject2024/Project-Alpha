package com.sendbird.android;

import com.sendbird.android.BaseChannel;
import com.sendbird.android.BaseMessage;
import com.sendbird.android.BaseMessageParams;
import com.sendbird.android.constant.StringSet;
import com.sendbird.android.shadow.com.google.gson.JsonArray;
import com.sendbird.android.shadow.com.google.gson.JsonElement;
import com.sendbird.android.shadow.com.google.gson.JsonObject;
import com.sendbird.android.shadow.com.google.gson.JsonParser;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.activities.CommunityPostActivity;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import net.one97.paytm.dynamic.module.fastag.helper.ImagePickerUtils;

public final class FileMessage extends BaseMessage {
    private String mName;
    private String mReqId;
    private boolean mRequireAuth;
    private int mSize;
    private List<Thumbnail> mThumbnails;
    private String mType;
    private String mUrl;

    @Deprecated
    public enum RequestState {
        NONE,
        PENDING,
        FAILED,
        SUCCEEDED
    }

    public final String getMessage() {
        return "File Message";
    }

    static JsonElement build(String str, BaseMessage.SendingStatus sendingStatus, long j, long j2, long j3, Sender sender, String str2, String str3, String str4, String str5, String str6, int i2, String str7, String str8, String str9, boolean z, long j4, long j5, BaseMessageParams.MentionType mentionType, List<String> list, String str10, String str11, String str12, String str13, String str14, boolean z2, int i3, boolean z3, boolean z4, int i4, String str15, ThreadInfo threadInfo, boolean z5) {
        String str16 = str7;
        String str17 = str8;
        String str18 = str9;
        BaseMessageParams.MentionType mentionType2 = mentionType;
        String str19 = str10;
        String str20 = str11;
        String str21 = str12;
        String str22 = str13;
        String str23 = str14;
        String str24 = str15;
        JsonObject jsonObject = new JsonObject();
        String str25 = str;
        jsonObject.addProperty("req_id", str);
        jsonObject.addProperty("request_state", sendingStatus.getValue());
        jsonObject.addProperty(StringSet.msg_id, (Number) Long.valueOf(j));
        jsonObject.addProperty(StringSet.root_message_id, (Number) Long.valueOf(j2));
        jsonObject.addProperty(StringSet.parent_message_id, (Number) Long.valueOf(j3));
        jsonObject.addProperty(StringSet.channel_url, str2);
        jsonObject.addProperty(StringSet.channel_type, str3);
        jsonObject.addProperty(StringSet.ts, (Number) Long.valueOf(j4));
        jsonObject.addProperty(StringSet.updated_at, (Number) Long.valueOf(j5));
        jsonObject.addProperty("url", str4);
        jsonObject.addProperty("name", str5);
        jsonObject.addProperty("type", str6);
        jsonObject.addProperty(ImagePickerUtils.IMAGE_PICKER_KEY_SIZE, (Number) Integer.valueOf(i2));
        if (str16 != null) {
            jsonObject.addProperty("custom", str16);
        }
        if (str17 != null) {
            jsonObject.addProperty(StringSet.custom_type, str17);
        }
        if (str18 != null) {
            jsonObject.add("thumbnails", new JsonParser().parse(str18));
        }
        if (z) {
            jsonObject.addProperty("require_auth", Boolean.valueOf(z));
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
        if (str19 != null) {
            jsonObject.add("mentioned_users", new JsonParser().parse(str19));
        }
        if (str20 != null) {
            jsonObject.add("reactions", new JsonParser().parse(str20));
        }
        if (str21 != null) {
            jsonObject.add("metaarray", new JsonParser().parse(str21));
        }
        if (str22 != null) {
            jsonObject.add("metaarray_key_order", new JsonParser().parse(str22));
        }
        if (str23 != null) {
            jsonObject.add("sorted_metaarray", new JsonParser().parse(str23));
        }
        jsonObject.addProperty("is_global_block", Boolean.valueOf(z2));
        jsonObject.addProperty("error_code", (Number) Integer.valueOf(i3));
        jsonObject.addProperty("silent", Boolean.valueOf(z3));
        jsonObject.addProperty("force_update_last_message", Boolean.valueOf(z4));
        jsonObject.addProperty(StringSet.message_survival_seconds, (Number) Integer.valueOf(i4));
        if (str24 != null) {
            jsonObject.addProperty(StringSet.parent_message_text, str24);
        }
        jsonObject.add(StringSet.thread_info, threadInfo.toJson());
        jsonObject.addProperty(StringSet.is_op_msg, Boolean.valueOf(z5));
        return jsonObject;
    }

    FileMessage(JsonElement jsonElement) {
        super(jsonElement);
        JsonObject asJsonObject = jsonElement.getAsJsonObject();
        String str = "";
        this.mUrl = asJsonObject.has("url") ? asJsonObject.get("url").getAsString() : str;
        String str2 = "File";
        this.mName = asJsonObject.has("name") ? asJsonObject.get("name").getAsString() : str2;
        int i2 = 0;
        this.mSize = asJsonObject.has(ImagePickerUtils.IMAGE_PICKER_KEY_SIZE) ? asJsonObject.get(ImagePickerUtils.IMAGE_PICKER_KEY_SIZE).getAsInt() : 0;
        this.mType = asJsonObject.has("type") ? asJsonObject.get("type").getAsString() : str;
        this.mData = asJsonObject.has("custom") ? asJsonObject.get("custom").getAsString() : str;
        this.mReqId = str;
        if (asJsonObject.has("request_id")) {
            this.mReqId = asJsonObject.get("request_id").getAsString();
        }
        if (asJsonObject.has("req_id")) {
            this.mReqId = asJsonObject.get("req_id").getAsString();
        }
        this.mCustomType = asJsonObject.has(StringSet.custom_type) ? asJsonObject.get(StringSet.custom_type).getAsString() : str;
        this.mRequireAuth = asJsonObject.has("require_auth") && asJsonObject.get("require_auth").getAsBoolean();
        this.mThumbnails = new ArrayList();
        if (asJsonObject.has("thumbnails")) {
            Iterator<JsonElement> it2 = asJsonObject.get("thumbnails").getAsJsonArray().iterator();
            while (it2.hasNext()) {
                this.mThumbnails.add(new Thumbnail(it2.next(), this.mRequireAuth));
            }
        }
        if (getSendingStatus() != BaseMessage.SendingStatus.SUCCEEDED && asJsonObject.has(CommunityPostActivity.TYPE_FILE)) {
            JsonObject asJsonObject2 = asJsonObject.get(CommunityPostActivity.TYPE_FILE).getAsJsonObject();
            this.mUrl = asJsonObject2.has("url") ? asJsonObject2.get("url").getAsString() : str;
            this.mName = asJsonObject2.has("name") ? asJsonObject2.get("name").getAsString() : str2;
            this.mSize = asJsonObject2.has(ImagePickerUtils.IMAGE_PICKER_KEY_SIZE) ? asJsonObject2.get(ImagePickerUtils.IMAGE_PICKER_KEY_SIZE).getAsInt() : 0;
            this.mType = asJsonObject2.has("type") ? asJsonObject2.get("type").getAsString() : str;
            this.mData = asJsonObject2.has("data") ? asJsonObject2.get("data").getAsString() : str;
        }
        this.mErrorCode = asJsonObject.has("error_code") ? asJsonObject.get("error_code").getAsInt() : i2;
    }

    /* access modifiers changed from: package-private */
    public final JsonElement toJson() {
        JsonObject asJsonObject = super.toJson().getAsJsonObject();
        asJsonObject.addProperty("type", BaseChannel.MessageTypeFilter.FILE.value());
        asJsonObject.addProperty("req_id", this.mReqId);
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("url", this.mUrl);
        jsonObject.addProperty("name", this.mName);
        jsonObject.addProperty("type", this.mType);
        jsonObject.addProperty(ImagePickerUtils.IMAGE_PICKER_KEY_SIZE, (Number) Integer.valueOf(this.mSize));
        jsonObject.addProperty("data", this.mData);
        asJsonObject.add(CommunityPostActivity.TYPE_FILE, jsonObject);
        asJsonObject.addProperty(StringSet.custom_type, this.mCustomType);
        boolean z = this.mRequireAuth;
        if (z) {
            asJsonObject.addProperty("require_auth", Boolean.valueOf(z));
        }
        JsonArray jsonArray = new JsonArray();
        for (Thumbnail json : this.mThumbnails) {
            jsonArray.add(json.toJson());
        }
        asJsonObject.add("thumbnails", jsonArray);
        asJsonObject.addProperty("error_code", (Number) Integer.valueOf(this.mErrorCode));
        return asJsonObject;
    }

    /* access modifiers changed from: package-private */
    public final boolean requiredAuth() {
        return this.mRequireAuth;
    }

    public final String getRequestId() {
        return this.mReqId;
    }

    public final String getUrl() {
        if (!this.mRequireAuth) {
            return this.mUrl;
        }
        return String.format("%s?auth=%s", new Object[]{this.mUrl, SendBird.getEkey()});
    }

    public final String getPlainUrl() {
        return this.mUrl;
    }

    public final String getName() {
        return this.mName;
    }

    public final int getSize() {
        return this.mSize;
    }

    public final String getType() {
        return this.mType;
    }

    public final List<Thumbnail> getThumbnails() {
        return this.mThumbnails;
    }

    public static class Thumbnail {
        private int mMaxHeight;
        private int mMaxWidth;
        private int mRealHeight;
        private int mRealWidth;
        private boolean mRequireAuth;
        private String mUrl;

        private Thumbnail(JsonElement jsonElement, boolean z) {
            JsonObject asJsonObject = jsonElement.getAsJsonObject();
            int i2 = 0;
            this.mMaxWidth = asJsonObject.has(StringSet.width) ? asJsonObject.get(StringSet.width).getAsInt() : 0;
            this.mMaxHeight = asJsonObject.has(StringSet.height) ? asJsonObject.get(StringSet.height).getAsInt() : i2;
            int i3 = -1;
            this.mRealWidth = asJsonObject.has("real_width") ? asJsonObject.get("real_width").getAsInt() : -1;
            this.mRealHeight = asJsonObject.has("real_height") ? asJsonObject.get("real_height").getAsInt() : i3;
            this.mUrl = asJsonObject.has("url") ? asJsonObject.get("url").getAsString() : "";
            this.mRequireAuth = z;
        }

        public int getMaxWidth() {
            return this.mMaxWidth;
        }

        public int getMaxHeight() {
            return this.mMaxHeight;
        }

        public int getRealWidth() {
            return this.mRealWidth;
        }

        public int getRealHeight() {
            return this.mRealHeight;
        }

        public String getUrl() {
            if (!this.mRequireAuth) {
                return this.mUrl;
            }
            return String.format("%s?auth=%s", new Object[]{this.mUrl, SendBird.getEkey()});
        }

        public String getPlainUrl() {
            return this.mUrl;
        }

        /* access modifiers changed from: package-private */
        public JsonElement toJson() {
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty(StringSet.width, (Number) Integer.valueOf(this.mMaxWidth));
            jsonObject.addProperty(StringSet.height, (Number) Integer.valueOf(this.mMaxHeight));
            jsonObject.addProperty("real_width", (Number) Integer.valueOf(this.mRealWidth));
            jsonObject.addProperty("real_height", (Number) Integer.valueOf(this.mRealHeight));
            jsonObject.addProperty("url", this.mUrl);
            return jsonObject;
        }

        public boolean equals(Object obj) {
            if (obj != null && obj.getClass() == getClass()) {
                Thumbnail thumbnail = (Thumbnail) obj;
                if (getMaxWidth() == thumbnail.getMaxWidth() && getMaxHeight() == thumbnail.getMaxHeight() && getRealWidth() == thumbnail.getRealWidth() && getRealHeight() == thumbnail.getRealHeight() && getUrl().equals(thumbnail.getUrl()) && this.mRequireAuth == thumbnail.mRequireAuth) {
                    return true;
                }
                return false;
            }
            return false;
        }

        public int hashCode() {
            return p.a(Integer.valueOf(getMaxWidth()), Integer.valueOf(getMaxHeight()), Integer.valueOf(getRealWidth()), Integer.valueOf(getRealHeight()), getUrl(), Boolean.valueOf(this.mRequireAuth));
        }

        public String toString() {
            return "Thumbnail{mMaxWidth=" + this.mMaxWidth + ", mMaxHeight=" + this.mMaxHeight + ", mRealWidth=" + this.mRealWidth + ", mRealHeight=" + this.mRealHeight + ", mUrl='" + this.mUrl + '\'' + ", mRequireAuth=" + this.mRequireAuth + '}';
        }
    }

    public static class ThumbnailSize {
        private int mMaxHeight;
        private int mMaxWidth;

        public ThumbnailSize(int i2, int i3) {
            this.mMaxWidth = i2 < 0 ? 0 : i2;
            this.mMaxHeight = i3 < 0 ? 0 : i3;
        }

        public int getMaxWidth() {
            return this.mMaxWidth;
        }

        public int getMaxHeight() {
            return this.mMaxHeight;
        }

        public boolean equals(Object obj) {
            if (obj != null && obj.getClass() == getClass()) {
                ThumbnailSize thumbnailSize = (ThumbnailSize) obj;
                if (getMaxWidth() == thumbnailSize.getMaxWidth() && getMaxHeight() == thumbnailSize.getMaxHeight()) {
                    return true;
                }
                return false;
            }
            return false;
        }

        public int hashCode() {
            return p.a(Integer.valueOf(getMaxWidth()), Integer.valueOf(getMaxHeight()));
        }

        public String toString() {
            return "ThumbnailSize{mMaxWidth=" + this.mMaxWidth + ", mMaxHeight=" + this.mMaxHeight + '}';
        }
    }

    @Deprecated
    public final RequestState getRequestState() {
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

    public final List<String> getRequestedMentionUserIds() {
        if (getSendingStatus() == BaseMessage.SendingStatus.PENDING || getSendingStatus() == BaseMessage.SendingStatus.FAILED || getSendingStatus() == BaseMessage.SendingStatus.CANCELED) {
            return getMentionedUserIds();
        }
        return new ArrayList();
    }

    public final String toString() {
        return super.toString() + "\nFileMessage{, mUrl='" + this.mUrl + '\'' + ", mName='" + this.mName + '\'' + ", mSize=" + this.mSize + ", mType='" + this.mType + '\'' + ", mReqId='" + this.mReqId + '\'' + ", mThumbnails=" + this.mThumbnails + ", mRequireAuth=" + this.mRequireAuth + '}';
    }
}
