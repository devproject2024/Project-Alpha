package com.sendbird.android;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

public abstract class BaseMessageParams {
    String mCustomType;
    String mData;
    MentionType mMentionType = MentionType.USERS;
    List<String> mMentionedUserIds;
    List<MessageMetaArray> mMetaArrays;
    PushNotificationDeliveryOption mPushNotificationDeliveryOption;
    long parentMessageId = 0;
    long rootMessageId = 0;

    public enum MentionType {
        USERS,
        CHANNEL
    }

    public enum PushNotificationDeliveryOption {
        DEFAULT,
        SUPPRESS
    }

    /* access modifiers changed from: package-private */
    public BaseMessageParams setRootMessageId(long j) {
        this.rootMessageId = j;
        return this;
    }

    /* access modifiers changed from: package-private */
    public BaseMessageParams setParentMessageId(long j) {
        this.parentMessageId = j;
        return this;
    }

    /* access modifiers changed from: package-private */
    public BaseMessageParams setData(String str) {
        this.mData = str;
        return this;
    }

    /* access modifiers changed from: package-private */
    public BaseMessageParams setCustomType(String str) {
        this.mCustomType = str;
        return this;
    }

    /* access modifiers changed from: package-private */
    public BaseMessageParams setMentionType(MentionType mentionType) {
        this.mMentionType = mentionType;
        return this;
    }

    /* access modifiers changed from: package-private */
    public BaseMessageParams setMentionedUsers(List<User> list) {
        String userId;
        if (this.mMentionedUserIds == null) {
            this.mMentionedUserIds = new ArrayList();
        }
        this.mMentionedUserIds.clear();
        if (list != null && list.size() > 0) {
            ArrayList<User> arrayList = new ArrayList<>(new LinkedHashSet(list));
            String userId2 = SendBird.getCurrentUser() != null ? SendBird.getCurrentUser().getUserId() : null;
            for (User user : arrayList) {
                if (!(user == null || (userId = user.getUserId()) == null || userId.length() <= 0)) {
                    if (userId2 == null || !userId2.equals(userId)) {
                        this.mMentionedUserIds.add(user.getUserId());
                    }
                }
            }
        }
        return this;
    }

    /* access modifiers changed from: package-private */
    public BaseMessageParams setMentionedUserIds(List<String> list) {
        if (this.mMentionedUserIds == null) {
            this.mMentionedUserIds = new ArrayList();
        }
        this.mMentionedUserIds.clear();
        if (list != null && list.size() > 0) {
            ArrayList<String> arrayList = new ArrayList<>(new LinkedHashSet(list));
            String userId = SendBird.getCurrentUser() != null ? SendBird.getCurrentUser().getUserId() : null;
            for (String str : arrayList) {
                if (str != null && str.length() > 0) {
                    if (userId == null || !userId.equals(str)) {
                        this.mMentionedUserIds.add(str);
                    }
                }
            }
        }
        return this;
    }

    /* access modifiers changed from: package-private */
    public BaseMessageParams setPushNotificationDeliveryOption(PushNotificationDeliveryOption pushNotificationDeliveryOption) {
        this.mPushNotificationDeliveryOption = pushNotificationDeliveryOption;
        return this;
    }

    /* access modifiers changed from: package-private */
    @Deprecated
    public synchronized BaseMessageParams setMetaArrayKeys(List<String> list) {
        if (list != null) {
            if (list.size() > 0) {
                ArrayList<String> arrayList = new ArrayList<>(new LinkedHashSet(list));
                if (this.mMetaArrays == null) {
                    this.mMetaArrays = new ArrayList();
                }
                for (String str : arrayList) {
                    if (str != null) {
                        this.mMetaArrays.add(new MessageMetaArray(str));
                    }
                }
            }
        }
        return this;
    }

    /* access modifiers changed from: package-private */
    public synchronized BaseMessageParams setMetaArrays(List<MessageMetaArray> list) {
        this.mMetaArrays = new ArrayList();
        if (list != null && !list.isEmpty()) {
            for (MessageMetaArray next : list) {
                int indexOf = this.mMetaArrays.indexOf(next);
                if (indexOf != -1) {
                    this.mMetaArrays.get(indexOf).addValue(next.getValue());
                } else {
                    this.mMetaArrays.add(next);
                }
            }
        }
        return this;
    }

    public String toString() {
        return "BaseMessageParams{mData='" + this.mData + '\'' + ", mCustomType='" + this.mCustomType + '\'' + ", mMentionType=" + this.mMentionType + ", mMentionedUserIds=" + this.mMentionedUserIds + ", mPushNotificationDeliveryOption=" + this.mPushNotificationDeliveryOption + ", mMetaArrays=" + this.mMetaArrays + '}';
    }
}
