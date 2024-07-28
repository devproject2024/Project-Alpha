package com.sendbird.android;

public class MessageChangeLogsParams {
    protected boolean includeMetaArray;
    protected boolean includeParentMessageText;
    protected boolean includeReactions;
    protected boolean includeReplies;
    protected boolean includeThreadInfo;

    public MessageChangeLogsParams() {
        this.includeMetaArray = false;
        this.includeReactions = false;
        this.includeThreadInfo = false;
        this.includeReplies = false;
        this.includeParentMessageText = false;
    }

    public MessageChangeLogsParams(boolean z, boolean z2, boolean z3, boolean z4, boolean z5) {
        this.includeMetaArray = z;
        this.includeReactions = z2;
        this.includeThreadInfo = z3;
        this.includeReplies = z4;
        this.includeParentMessageText = z5;
    }

    public void setIncludeMetaArray(boolean z) {
        this.includeMetaArray = z;
    }

    public void setIncludeReactions(boolean z) {
        this.includeReactions = z;
    }

    public void setIncludeThreadInfo(boolean z) {
        this.includeThreadInfo = z;
    }

    public void setIncludeReplies(boolean z) {
        this.includeReplies = z;
    }

    public void setIncludeParentMessageText(boolean z) {
        this.includeParentMessageText = z;
    }

    public boolean shouldIncludeMetaArray() {
        return this.includeMetaArray;
    }

    public boolean shouldIncludeReactions() {
        return this.includeReactions;
    }

    public boolean shouldIncludeThreadInfo() {
        return this.includeThreadInfo;
    }

    public boolean shouldIncludeReplies() {
        return this.includeReplies;
    }

    public boolean isIncludeParentMessageText() {
        return this.includeParentMessageText;
    }

    public MessageChangeLogsParams clone() {
        return new MessageChangeLogsParams(this.includeMetaArray, this.includeReactions, this.includeThreadInfo, this.includeReplies, this.includeParentMessageText);
    }

    public static MessageChangeLogsParams from(PreviousMessageListQuery previousMessageListQuery) {
        return new MessageChangeLogsParams(previousMessageListQuery.shouldIncludeMetaArray(), previousMessageListQuery.shouldIncludeReactions(), previousMessageListQuery.isIncludeThreadInfo(), previousMessageListQuery.shouldIncludeReplies(), previousMessageListQuery.shouldIncludeParentMessageText());
    }

    public static MessageChangeLogsParams from(MessageListParams messageListParams) {
        return new MessageChangeLogsParams(messageListParams.shouldIncludeMetaArray(), messageListParams.shouldIncludeReactions(), messageListParams.shouldIncludeThreadInfo(), messageListParams.shouldIncludeReplies(), messageListParams.shouldIncludeParentMessageText());
    }

    public static MessageChangeLogsParams from(ThreadMessageListParams threadMessageListParams) {
        return new MessageChangeLogsParams(threadMessageListParams.shouldIncludeMetaArray(), threadMessageListParams.shouldIncludeReactions(), true, true, threadMessageListParams.shouldIncludeParentMessageText());
    }

    public String toString() {
        return "MessageChangeLogsParams{includeMetaArray=" + this.includeMetaArray + ", includeReactions=" + this.includeReactions + ", includeThreadInfo=" + this.includeThreadInfo + ", includeReplies=" + this.includeReplies + ", includeParentMessageText=" + this.includeParentMessageText + '}';
    }
}
