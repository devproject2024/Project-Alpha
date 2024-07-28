package com.sendbird.android;

import com.sendbird.android.BaseChannel;
import com.sendbird.android.BaseMessageParams;
import com.sendbird.android.SendBird;
import com.sendbird.android.constant.StringSet;
import com.sendbird.android.shadow.com.google.gson.JsonArray;
import com.sendbird.android.shadow.com.google.gson.JsonElement;
import com.sendbird.android.shadow.com.google.gson.JsonObject;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;

public final class ScheduledUserMessage {
    private String mChannelType;
    private String mChannelUrl;
    private long mCreatedAt;
    private String mCustomType;
    private String mData;
    private int mErrorCode;
    private String mErrorMessage;
    private BaseMessageParams.MentionType mMentionType = BaseMessageParams.MentionType.USERS;
    private List<User> mMentionedUsers;
    private String mMessage;
    private List<MessageMetaArray> mMetaArrays;
    private String mPushOption;
    private String mScheduledDateTime;
    private long mScheduledId;
    private String mScheduledTimezone;
    private User mSender;
    private String mStatus;
    private ArrayList<String> mTargetLanguages;
    private long mUpdatedAt;

    public enum Status {
        SCHEDULED,
        SENT,
        CANCELED,
        FAILED
    }

    ScheduledUserMessage(JsonElement jsonElement) {
        String str = "";
        this.mData = str;
        this.mCustomType = str;
        this.mMessage = str;
        JsonObject asJsonObject = jsonElement.getAsJsonObject();
        long j = 0;
        this.mScheduledId = asJsonObject.has("scheduled_id") ? asJsonObject.get("scheduled_id").getAsLong() : 0;
        this.mScheduledDateTime = asJsonObject.has("scheduled_dt") ? asJsonObject.get("scheduled_dt").getAsString() : str;
        this.mScheduledTimezone = asJsonObject.has("scheduled_timezone") ? asJsonObject.get("scheduled_timezone").getAsString() : "UTC";
        this.mStatus = asJsonObject.has("status") ? asJsonObject.get("status").getAsString() : str;
        if (asJsonObject.has("error")) {
            JsonObject asJsonObject2 = asJsonObject.get("error").getAsJsonObject();
            this.mErrorCode = asJsonObject2.has("code") ? asJsonObject2.get("code").getAsInt() : 0;
            this.mErrorMessage = asJsonObject2.has("message") ? asJsonObject2.get("message").getAsString() : str;
        }
        this.mPushOption = asJsonObject.has("push_option") ? asJsonObject.get("push_option").getAsString() : str;
        this.mChannelUrl = asJsonObject.has(StringSet.channel_url) ? asJsonObject.get(StringSet.channel_url).getAsString() : str;
        this.mChannelType = asJsonObject.has(StringSet.channel_type) ? asJsonObject.get(StringSet.channel_type).getAsString() : BaseChannel.ChannelType.GROUP.value();
        this.mCreatedAt = asJsonObject.has("created_at") ? asJsonObject.get("created_at").getAsLong() : 0;
        this.mUpdatedAt = asJsonObject.has(StringSet.updated_at) ? asJsonObject.get(StringSet.updated_at).getAsLong() : j;
        if (asJsonObject.has(StringSet.mention_type)) {
            String asString = asJsonObject.get(StringSet.mention_type).getAsString();
            if (asString.equals(StringSet.users)) {
                this.mMentionType = BaseMessageParams.MentionType.USERS;
            } else if (asString.equals("channel")) {
                this.mMentionType = BaseMessageParams.MentionType.CHANNEL;
            }
        }
        this.mMentionedUsers = new ArrayList();
        if (asJsonObject.has("mentioned_users")) {
            JsonArray asJsonArray = asJsonObject.getAsJsonArray("mentioned_users");
            for (int i2 = 0; i2 < asJsonArray.size(); i2++) {
                this.mMentionedUsers.add(new User(asJsonArray.get(i2)));
            }
        }
        this.mMetaArrays = new ArrayList();
        if (asJsonObject.has("metaarray")) {
            HashMap hashMap = new HashMap();
            JsonObject asJsonObject3 = asJsonObject.getAsJsonObject("metaarray");
            for (String next : asJsonObject3.keySet()) {
                if (next != null) {
                    ArrayList arrayList = new ArrayList();
                    JsonArray asJsonArray2 = asJsonObject3.get(next).getAsJsonArray();
                    for (int i3 = 0; i3 < asJsonArray2.size(); i3++) {
                        arrayList.add(asJsonArray2.get(i3).getAsString());
                    }
                    hashMap.put(next, new MessageMetaArray(next, arrayList));
                }
            }
            if (asJsonObject.has("metaarray_key_order")) {
                JsonArray asJsonArray3 = asJsonObject.getAsJsonArray("metaarray_key_order");
                for (int i4 = 0; i4 < asJsonArray3.size(); i4++) {
                    String asString2 = asJsonArray3.get(i4).getAsString();
                    if (hashMap.containsKey(asString2)) {
                        this.mMetaArrays.add(hashMap.get(asString2));
                    }
                }
            } else {
                this.mMetaArrays.addAll(hashMap.values());
            }
        }
        this.mMessage = asJsonObject.get("message").getAsString();
        this.mData = asJsonObject.has("data") ? asJsonObject.get("data").getAsString() : str;
        this.mSender = new User(asJsonObject.get(StringSet.user));
        this.mCustomType = asJsonObject.has(StringSet.custom_type) ? asJsonObject.get(StringSet.custom_type).getAsString() : str;
        this.mTargetLanguages = new ArrayList<>();
        if (asJsonObject.has("translation_target_langs")) {
            JsonArray asJsonArray4 = asJsonObject.getAsJsonArray("translation_target_langs");
            for (int i5 = 0; i5 < asJsonArray4.size(); i5++) {
                this.mTargetLanguages.add(asJsonArray4.get(i5).getAsString());
            }
        }
    }

    public final long getScheduledId() {
        return this.mScheduledId;
    }

    public final Date getScheduledDateTime() {
        Date date = null;
        try {
            if (this.mScheduledDateTime != null && this.mScheduledDateTime.length() > 0 && this.mScheduledTimezone != null && this.mScheduledTimezone.length() > 0) {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.US);
                simpleDateFormat.setTimeZone(TimeZone.getTimeZone(this.mScheduledTimezone));
                date = simpleDateFormat.parse(this.mScheduledDateTime);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return date == null ? new Date() : date;
    }

    public final String getScheduledTimezone() {
        return this.mScheduledTimezone;
    }

    public final Status getStatus() {
        Status status = Status.FAILED;
        String str = this.mStatus;
        if (str == null) {
            return status;
        }
        if (str.equals("scheduled")) {
            return Status.SCHEDULED;
        }
        if (this.mStatus.equals("sent")) {
            return Status.SENT;
        }
        if (this.mStatus.equals("canceled")) {
            return Status.CANCELED;
        }
        return this.mStatus.equals("failed") ? Status.FAILED : status;
    }

    public final int getErrorCode() {
        return this.mErrorCode;
    }

    public final String getErrorMessage() {
        return this.mErrorMessage;
    }

    public final BaseMessageParams.PushNotificationDeliveryOption getPushNotificationDeliveryOption() {
        BaseMessageParams.PushNotificationDeliveryOption pushNotificationDeliveryOption = BaseMessageParams.PushNotificationDeliveryOption.DEFAULT;
        String str = this.mPushOption;
        return (str == null || !str.equals("suppress")) ? pushNotificationDeliveryOption : BaseMessageParams.PushNotificationDeliveryOption.SUPPRESS;
    }

    public final long getCreatedAt() {
        return this.mCreatedAt;
    }

    public final long getUpdatedAt() {
        return this.mUpdatedAt;
    }

    public final BaseMessageParams.MentionType getMentionType() {
        return this.mMentionType;
    }

    public final List<User> getMentionedUsers() {
        return this.mMentionedUsers;
    }

    /* access modifiers changed from: package-private */
    public final List<String> getMentionedUserIds() {
        List<User> list = this.mMentionedUsers;
        if (list == null || list.size() <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (User next : this.mMentionedUsers) {
            if (!(next == null || next.getUserId() == null || next.getUserId().length() <= 0)) {
                arrayList.add(next.getUserId());
            }
        }
        return arrayList;
    }

    public final String getChannelUrl() {
        return this.mChannelUrl;
    }

    public final boolean isOpenChannel() {
        return this.mChannelType.equals(BaseChannel.ChannelType.OPEN.value());
    }

    public final boolean isGroupChannel() {
        return this.mChannelType.equals(BaseChannel.ChannelType.GROUP.value());
    }

    public final String getData() {
        return this.mData;
    }

    public final String getCustomType() {
        return this.mCustomType;
    }

    public final Map<String, List<String>> getAllMetaArray() {
        HashMap hashMap = new HashMap();
        for (MessageMetaArray next : this.mMetaArrays) {
            hashMap.put(next.getKey(), next.getValue());
        }
        return hashMap;
    }

    public final List<MessageMetaArray> getAllMetaArrays() {
        return new ArrayList(this.mMetaArrays);
    }

    public final Map<String, List<String>> getMetaArray(Collection<String> collection) {
        HashMap hashMap = new HashMap();
        for (MessageMetaArray next : getMetaArrays(collection)) {
            hashMap.put(next.getKey(), next.getValue());
        }
        return hashMap;
    }

    public final List<MessageMetaArray> getMetaArrays(Collection<String> collection) {
        ArrayList arrayList = new ArrayList();
        if (!(this.mMetaArrays == null || collection == null || collection.size() <= 0)) {
            for (String metaArrayByKey : collection) {
                MessageMetaArray metaArrayByKey2 = getMetaArrayByKey(metaArrayByKey);
                if (metaArrayByKey2 != null) {
                    arrayList.add(metaArrayByKey2);
                }
            }
        }
        return arrayList;
    }

    /* access modifiers changed from: package-private */
    public final MessageMetaArray getMetaArrayByKey(String str) {
        if (str == null) {
            return null;
        }
        for (MessageMetaArray next : this.mMetaArrays) {
            if (str.equals(next.getKey())) {
                return next;
            }
        }
        return null;
    }

    public final String getMessage() {
        return this.mMessage;
    }

    public final User getSender() {
        User user;
        if (this.mSender == null) {
            return null;
        }
        if (SendBird.Options.useMemberAsMessageSender && GroupChannel.sCachedChannels.containsKey(this.mChannelUrl) && (user = GroupChannel.sCachedChannels.get(this.mChannelUrl).mMemberMap.get(this.mSender.getUserId())) != null) {
            this.mSender.updatePropertiesByUser(user);
        }
        return this.mSender;
    }

    public final ArrayList<String> getTranslationTargetLanguages() {
        return this.mTargetLanguages;
    }

    public final String toString() {
        return "ScheduledUserMessage{mScheduledId=" + this.mScheduledId + ", mScheduledDateTime='" + this.mScheduledDateTime + '\'' + ", mScheduledTimezone='" + this.mScheduledTimezone + '\'' + ", mStatus='" + this.mStatus + '\'' + ", mErrorCode=" + this.mErrorCode + ", mErrorMessage='" + this.mErrorMessage + '\'' + ", mPushOption='" + this.mPushOption + '\'' + ", mChannelUrl='" + this.mChannelUrl + '\'' + ", mChannelType='" + this.mChannelType + '\'' + ", mCreatedAt=" + this.mCreatedAt + ", mUpdatedAt=" + this.mUpdatedAt + ", mMentionType=" + this.mMentionType + ", mMentionedUsers=" + this.mMentionedUsers + ", mMetaArrays=" + this.mMetaArrays + ", mData='" + this.mData + '\'' + ", mCustomType='" + this.mCustomType + '\'' + ", mMessage='" + this.mMessage + '\'' + ", mSender=" + this.mSender + ", mTargetLanguages=" + this.mTargetLanguages + '}';
    }

    public final boolean equals(Object obj) {
        if (obj != null && obj.getClass() == getClass()) {
            ScheduledUserMessage scheduledUserMessage = (ScheduledUserMessage) obj;
            if (getScheduledId() == scheduledUserMessage.getScheduledId() && getChannelUrl().equals(scheduledUserMessage.getChannelUrl()) && getCreatedAt() == scheduledUserMessage.getCreatedAt()) {
                return true;
            }
            return false;
        }
        return false;
    }

    public final int hashCode() {
        return p.a(Long.valueOf(getScheduledId()), getChannelUrl(), Long.valueOf(getCreatedAt()));
    }
}
