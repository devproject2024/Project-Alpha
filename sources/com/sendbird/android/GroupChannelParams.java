package com.sendbird.android;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class GroupChannelParams {
    Boolean isBroadcast;
    String mAccessCode;
    String mChannelUrl;
    Object mCoverUrlOrImage;
    String mCustomType;
    String mData;
    Boolean mIsDiscoverable;
    Boolean mIsDistinct;
    Boolean mIsEphemeral;
    Boolean mIsPublic;
    Boolean mIsSuper;
    String mName;
    List<String> mOperatorUserIds;
    Boolean mStrict;
    List<String> mUserIds = new ArrayList();
    Integer messageSurvivalSeconds;

    public GroupChannelParams addUser(User user) {
        if (!(user == null || user.getUserId() == null || user.getUserId().length() <= 0)) {
            this.mUserIds.add(user.getUserId());
        }
        return this;
    }

    public GroupChannelParams addUsers(List<User> list) {
        if (list != null) {
            for (User next : list) {
                if (!(next == null || next.getUserId() == null || next.getUserId().length() <= 0)) {
                    this.mUserIds.add(next.getUserId());
                }
            }
        }
        return this;
    }

    public GroupChannelParams addUserId(String str) {
        if (str != null && str.length() > 0) {
            this.mUserIds.add(str);
        }
        return this;
    }

    public GroupChannelParams addUserIds(List<String> list) {
        if (list != null) {
            for (String next : list) {
                if (next != null && next.length() > 0) {
                    this.mUserIds.add(next);
                }
            }
        }
        return this;
    }

    public GroupChannelParams setSuper(boolean z) {
        this.mIsSuper = Boolean.valueOf(z);
        return this;
    }

    public GroupChannelParams setPublic(boolean z) {
        this.mIsPublic = Boolean.valueOf(z);
        return this;
    }

    public GroupChannelParams setEphemeral(boolean z) {
        this.mIsEphemeral = Boolean.valueOf(z);
        return this;
    }

    public GroupChannelParams setDistinct(boolean z) {
        this.mIsDistinct = Boolean.valueOf(z);
        return this;
    }

    public GroupChannelParams setDiscoverable(boolean z) {
        this.mIsDiscoverable = Boolean.valueOf(z);
        return this;
    }

    public GroupChannelParams setChannelUrl(String str) {
        this.mChannelUrl = str;
        return this;
    }

    public GroupChannelParams setName(String str) {
        this.mName = str;
        return this;
    }

    public GroupChannelParams setCoverUrl(String str) {
        this.mCoverUrlOrImage = str;
        return this;
    }

    public GroupChannelParams setCoverImage(File file) {
        this.mCoverUrlOrImage = file;
        return this;
    }

    public GroupChannelParams setData(String str) {
        this.mData = str;
        return this;
    }

    public GroupChannelParams setCustomType(String str) {
        this.mCustomType = str;
        return this;
    }

    public GroupChannelParams setOperators(List<User> list) {
        if (this.mOperatorUserIds == null) {
            this.mOperatorUserIds = new ArrayList();
        }
        this.mOperatorUserIds.clear();
        if (list != null) {
            for (User next : list) {
                if (!(next == null || next.getUserId() == null || next.getUserId().length() <= 0)) {
                    this.mOperatorUserIds.add(next.getUserId());
                }
            }
        }
        return this;
    }

    public GroupChannelParams setOperatorUserIds(List<String> list) {
        if (this.mOperatorUserIds == null) {
            this.mOperatorUserIds = new ArrayList();
        }
        this.mOperatorUserIds.clear();
        if (list != null) {
            for (String next : list) {
                if (next != null && next.length() > 0) {
                    this.mOperatorUserIds.add(next);
                }
            }
        }
        return this;
    }

    public GroupChannelParams setAccessCode(String str) {
        this.mAccessCode = str;
        return this;
    }

    public GroupChannelParams setStrict(boolean z) {
        this.mStrict = Boolean.valueOf(z);
        return this;
    }

    public GroupChannelParams setBroadcast(boolean z) {
        this.isBroadcast = Boolean.valueOf(z);
        return this;
    }

    public GroupChannelParams setMessageSurvivalSeconds(int i2) {
        this.messageSurvivalSeconds = Integer.valueOf(i2);
        return this;
    }

    public String toString() {
        return "GroupChannelParams{mUserIds=" + this.mUserIds + ", mOperatorUserIds=" + this.mOperatorUserIds + ", mIsSuper=" + this.mIsSuper + ", mIsPublic=" + this.mIsPublic + ", mIsEphemeral=" + this.mIsEphemeral + ", mIsDistinct=" + this.mIsDistinct + ", mIsDiscoverable=" + this.mIsDiscoverable + ", mChannelUrl='" + this.mChannelUrl + '\'' + ", mName='" + this.mName + '\'' + ", mCoverUrlOrImage=" + this.mCoverUrlOrImage + ", mData='" + this.mData + '\'' + ", mCustomType='" + this.mCustomType + '\'' + ", mAccessCode='" + this.mAccessCode + '\'' + ", mStrict=" + this.mStrict + ", isBroadcast=" + this.isBroadcast + ", messageSurvivalSeconds=" + this.messageSurvivalSeconds + '}';
    }
}
