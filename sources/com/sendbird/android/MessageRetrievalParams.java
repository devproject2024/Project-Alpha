package com.sendbird.android;

import com.sendbird.android.BaseChannel;

public class MessageRetrievalParams {
    protected final BaseChannel.ChannelType channelType;
    protected final String channelUrl;
    protected boolean includeMetaArray;
    protected boolean includeParentMessageText;
    protected boolean includeThreadInfo;
    protected final long messageId;

    protected MessageRetrievalParams() {
        this.channelUrl = "";
        this.channelType = BaseChannel.ChannelType.GROUP;
        this.messageId = 0;
    }

    public MessageRetrievalParams(String str, BaseChannel.ChannelType channelType2, long j) {
        this.channelUrl = str;
        this.channelType = channelType2;
        this.messageId = j;
    }

    public void setIncludeMetaArray(boolean z) {
        this.includeMetaArray = z;
    }

    public void setIncludeThreadInfo(boolean z) {
        this.includeThreadInfo = z;
    }

    public void setIncludeParentMessageText(boolean z) {
        this.includeParentMessageText = z;
    }

    public String getChannelUrl() {
        return this.channelUrl;
    }

    public BaseChannel.ChannelType getChannelType() {
        return this.channelType;
    }

    public long getMessageId() {
        return this.messageId;
    }

    public boolean shouldIncludeMetaArray() {
        return this.includeMetaArray;
    }

    public boolean shouldIncludeThreadInfo() {
        return this.includeThreadInfo;
    }

    public boolean shouldIncludeParentMessageText() {
        return this.includeParentMessageText;
    }

    public String toString() {
        return "GetMessageParams{channelUrl='" + this.channelUrl + '\'' + ", channelType=" + this.channelType + ", messageId=" + this.messageId + ", includeMetaArray=" + this.includeMetaArray + ", includeThreadInfo=" + this.includeThreadInfo + ", includeParentMessageText=" + this.includeParentMessageText + '}';
    }
}
