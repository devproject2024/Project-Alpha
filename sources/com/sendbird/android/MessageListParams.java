package com.sendbird.android;

import com.sendbird.android.BaseChannel;
import java.util.List;

public class MessageListParams extends h {
    protected boolean includeReplies;
    protected boolean includeThreadInfo;
    protected boolean showSubchannelMessagesOnly;

    public /* bridge */ /* synthetic */ String getCustomType() {
        return super.getCustomType();
    }

    public /* bridge */ /* synthetic */ BaseChannel.MessageTypeFilter getMessageType() {
        return super.getMessageType();
    }

    public /* bridge */ /* synthetic */ int getNextResultSize() {
        return super.getNextResultSize();
    }

    public /* bridge */ /* synthetic */ int getPreviousResultSize() {
        return super.getPreviousResultSize();
    }

    public /* bridge */ /* synthetic */ List getSenderUserIds() {
        return super.getSenderUserIds();
    }

    public /* bridge */ /* synthetic */ boolean isInclusive() {
        return super.isInclusive();
    }

    public /* bridge */ /* synthetic */ void setCustomType(String str) {
        super.setCustomType(str);
    }

    public /* bridge */ /* synthetic */ void setIncludeMetaArray(boolean z) {
        super.setIncludeMetaArray(z);
    }

    public /* bridge */ /* synthetic */ void setIncludeParentMessageText(boolean z) {
        super.setIncludeParentMessageText(z);
    }

    public /* bridge */ /* synthetic */ void setIncludeReactions(boolean z) {
        super.setIncludeReactions(z);
    }

    public /* bridge */ /* synthetic */ void setInclusive(boolean z) {
        super.setInclusive(z);
    }

    public /* bridge */ /* synthetic */ void setMessageType(BaseChannel.MessageTypeFilter messageTypeFilter) {
        super.setMessageType(messageTypeFilter);
    }

    public /* bridge */ /* synthetic */ void setNextResultSize(int i2) {
        super.setNextResultSize(i2);
    }

    public /* bridge */ /* synthetic */ void setPreviousResultSize(int i2) {
        super.setPreviousResultSize(i2);
    }

    public /* bridge */ /* synthetic */ void setReverse(boolean z) {
        super.setReverse(z);
    }

    public /* bridge */ /* synthetic */ void setSenderUserIds(List list) {
        super.setSenderUserIds(list);
    }

    public /* bridge */ /* synthetic */ boolean shouldIncludeMetaArray() {
        return super.shouldIncludeMetaArray();
    }

    public /* bridge */ /* synthetic */ boolean shouldIncludeParentMessageText() {
        return super.shouldIncludeParentMessageText();
    }

    public /* bridge */ /* synthetic */ boolean shouldIncludeReactions() {
        return super.shouldIncludeReactions();
    }

    public /* bridge */ /* synthetic */ boolean shouldReverse() {
        return super.shouldReverse();
    }

    public MessageListParams() {
        this.showSubchannelMessagesOnly = false;
        this.includeThreadInfo = false;
        this.includeReplies = false;
    }

    public MessageListParams(int i2, int i3, BaseChannel.MessageTypeFilter messageTypeFilter, String str, List<String> list, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7) {
        super(i2, i3, messageTypeFilter, str, list, z, z2, z3, z4, z5);
        this.showSubchannelMessagesOnly = false;
        this.includeThreadInfo = z6;
        this.includeReplies = z7;
    }

    public void setIncludeThreadInfo(boolean z) {
        this.includeThreadInfo = z;
    }

    public void setIncludeReplies(boolean z) {
        this.includeReplies = z;
    }

    public void setShowSubchannelMessagesOnly(boolean z) {
        this.showSubchannelMessagesOnly = z;
    }

    public boolean shouldIncludeThreadInfo() {
        return this.includeThreadInfo;
    }

    public boolean shouldIncludeReplies() {
        return this.includeReplies;
    }

    public boolean shouldShowSubchannelMessagesOnly() {
        return this.showSubchannelMessagesOnly;
    }

    public MessageListParams clone() {
        return new MessageListParams(this.previousResultSize, this.nextResultSize, this.messageType, this.customType, this.senderUserIds, this.isInclusive, this.reverse, this.includeMetaArray, this.includeReactions, this.includeParentMessageText, this.includeThreadInfo, this.includeReplies);
    }

    public String toString() {
        return "MessageListParams{includeThreadInfo=" + this.includeThreadInfo + ", includeReplies=" + this.includeReplies + ", previousResultSize=" + this.previousResultSize + ", nextResultSize=" + this.nextResultSize + ", messageType=" + this.messageType + ", customType='" + this.customType + '\'' + ", senderUserIds=" + this.senderUserIds + ", isInclusive=" + this.isInclusive + ", reverse=" + this.reverse + ", includeMetaArray=" + this.includeMetaArray + ", includeReactions=" + this.includeReactions + ", includeParentMessageText=" + this.includeParentMessageText + ", showSubchannelMessagesOnly=" + this.showSubchannelMessagesOnly + '}';
    }
}
