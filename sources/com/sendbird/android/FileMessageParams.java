package com.sendbird.android;

import com.sendbird.android.BaseMessageParams;
import com.sendbird.android.FileMessage;
import java.io.File;
import java.util.List;

public class FileMessageParams extends BaseMessageParams {
    String mFileName;
    Integer mFileSize;
    Object mFileUrlOrFile;
    String mMimeType;
    List<FileMessage.ThumbnailSize> mThumbnailSizes;

    public FileMessageParams() {
        this.mFileUrlOrFile = null;
    }

    public FileMessageParams(String str) {
        this.mFileUrlOrFile = str;
    }

    public FileMessageParams(File file) {
        this.mFileUrlOrFile = file;
    }

    public FileMessageParams setFileUrl(String str) {
        this.mFileUrlOrFile = str;
        return this;
    }

    public FileMessageParams setFile(File file) {
        this.mFileUrlOrFile = file;
        return this;
    }

    public FileMessageParams setFileName(String str) {
        this.mFileName = str;
        return this;
    }

    public FileMessageParams setMimeType(String str) {
        this.mMimeType = str;
        return this;
    }

    public FileMessageParams setFileSize(int i2) {
        this.mFileSize = Integer.valueOf(i2);
        return this;
    }

    public FileMessageParams setThumbnailSizes(List<FileMessage.ThumbnailSize> list) {
        this.mThumbnailSizes = list;
        return this;
    }

    public FileMessageParams setData(String str) {
        return (FileMessageParams) super.setData(str);
    }

    public FileMessageParams setCustomType(String str) {
        return (FileMessageParams) super.setCustomType(str);
    }

    public FileMessageParams setMentionType(BaseMessageParams.MentionType mentionType) {
        return (FileMessageParams) super.setMentionType(mentionType);
    }

    public FileMessageParams setMentionedUsers(List<User> list) {
        return (FileMessageParams) super.setMentionedUsers(list);
    }

    public FileMessageParams setMentionedUserIds(List<String> list) {
        return (FileMessageParams) super.setMentionedUserIds(list);
    }

    public FileMessageParams setPushNotificationDeliveryOption(BaseMessageParams.PushNotificationDeliveryOption pushNotificationDeliveryOption) {
        return (FileMessageParams) super.setPushNotificationDeliveryOption(pushNotificationDeliveryOption);
    }

    public FileMessageParams setMetaArrayKeys(List<String> list) {
        return (FileMessageParams) super.setMetaArrayKeys(list);
    }

    public FileMessageParams setMetaArrays(List<MessageMetaArray> list) {
        return (FileMessageParams) super.setMetaArrays(list);
    }

    public FileMessageParams setParentMessageId(long j) {
        return (FileMessageParams) super.setParentMessageId(j);
    }

    public String toString() {
        return "FileMessageParams{mFileUrlOrFile=" + this.mFileUrlOrFile + ", mFileName='" + this.mFileName + '\'' + ", mMimeType='" + this.mMimeType + '\'' + ", mFileSize=" + this.mFileSize + ", mThumbnailSizes=" + this.mThumbnailSizes + ", mData='" + this.mData + '\'' + ", mCustomType='" + this.mCustomType + '\'' + ", mMentionType=" + this.mMentionType + ", mMentionedUserIds=" + this.mMentionedUserIds + ", mPushNotificationDeliveryOption=" + this.mPushNotificationDeliveryOption + ", mMetaArrays=" + this.mMetaArrays + ", parentMessageId=" + this.parentMessageId + '}';
    }
}
