package com.sendbird.android;

import com.sendbird.android.BaseMessageParams;
import java.util.List;

public class UserMessageParams extends BaseMessageParams {
    String mMessage;
    List<String> mTargetLanguages;

    public UserMessageParams() {
        this.mMessage = null;
    }

    public UserMessageParams(String str) {
        this.mMessage = str;
    }

    public UserMessageParams setMessage(String str) {
        this.mMessage = str;
        return this;
    }

    @Deprecated
    public UserMessageParams setTargetLanguages(List<String> list) {
        this.mTargetLanguages = list;
        return this;
    }

    public UserMessageParams setTranslationTargetLanguages(List<String> list) {
        this.mTargetLanguages = list;
        return this;
    }

    public UserMessageParams setData(String str) {
        return (UserMessageParams) super.setData(str);
    }

    public UserMessageParams setCustomType(String str) {
        return (UserMessageParams) super.setCustomType(str);
    }

    public UserMessageParams setMentionType(BaseMessageParams.MentionType mentionType) {
        return (UserMessageParams) super.setMentionType(mentionType);
    }

    public UserMessageParams setMentionedUsers(List<User> list) {
        return (UserMessageParams) super.setMentionedUsers(list);
    }

    public UserMessageParams setMentionedUserIds(List<String> list) {
        return (UserMessageParams) super.setMentionedUserIds(list);
    }

    public UserMessageParams setPushNotificationDeliveryOption(BaseMessageParams.PushNotificationDeliveryOption pushNotificationDeliveryOption) {
        return (UserMessageParams) super.setPushNotificationDeliveryOption(pushNotificationDeliveryOption);
    }

    public UserMessageParams setMetaArrayKeys(List<String> list) {
        return (UserMessageParams) super.setMetaArrayKeys(list);
    }

    public UserMessageParams setMetaArrays(List<MessageMetaArray> list) {
        return (UserMessageParams) super.setMetaArrays(list);
    }

    public UserMessageParams setParentMessageId(long j) {
        return (UserMessageParams) super.setParentMessageId(j);
    }

    public String toString() {
        return "UserMessageParams{mMessage='" + this.mMessage + '\'' + ", mTargetLanguages=" + this.mTargetLanguages + ", mData='" + this.mData + '\'' + ", mCustomType='" + this.mCustomType + '\'' + ", mMentionType=" + this.mMentionType + ", mMentionedUserIds=" + this.mMentionedUserIds + ", mPushNotificationDeliveryOption=" + this.mPushNotificationDeliveryOption + ", mMetaArrays=" + this.mMetaArrays + ", parentMessageId=" + this.parentMessageId + '}';
    }
}
