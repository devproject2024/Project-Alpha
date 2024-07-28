package com.sendbird.android;

import com.sendbird.android.BaseChannel;
import java.util.ArrayList;
import java.util.List;

class h {
    protected String customType;
    protected boolean includeMetaArray;
    protected boolean includeParentMessageText;
    protected boolean includeReactions;
    protected boolean isInclusive;
    protected BaseChannel.MessageTypeFilter messageType;
    protected int nextResultSize;
    protected int previousResultSize;
    protected boolean reverse;
    protected List<String> senderUserIds;

    public h() {
        this.previousResultSize = 0;
        this.nextResultSize = 0;
        this.messageType = BaseChannel.MessageTypeFilter.ALL;
        this.customType = null;
        this.senderUserIds = null;
        this.isInclusive = false;
        this.reverse = false;
        this.includeMetaArray = false;
        this.includeReactions = false;
        this.includeParentMessageText = false;
    }

    public h(int i2, int i3, BaseChannel.MessageTypeFilter messageTypeFilter, String str, List<String> list, boolean z, boolean z2, boolean z3, boolean z4, boolean z5) {
        this.previousResultSize = i2;
        this.nextResultSize = i3;
        this.messageType = messageTypeFilter;
        this.customType = str;
        if (list != null) {
            this.senderUserIds = new ArrayList(list);
        } else {
            this.senderUserIds = null;
        }
        this.isInclusive = z;
        this.reverse = z2;
        this.includeMetaArray = z3;
        this.includeReactions = z4;
        this.includeParentMessageText = z5;
    }

    public void setPreviousResultSize(int i2) {
        this.previousResultSize = i2;
    }

    public void setNextResultSize(int i2) {
        this.nextResultSize = i2;
    }

    public void setMessageType(BaseChannel.MessageTypeFilter messageTypeFilter) {
        this.messageType = messageTypeFilter;
    }

    public void setCustomType(String str) {
        this.customType = str;
    }

    public void setSenderUserIds(List<String> list) {
        if (list != null) {
            this.senderUserIds = new ArrayList(list);
        } else {
            this.senderUserIds = null;
        }
    }

    public void setInclusive(boolean z) {
        this.isInclusive = z;
    }

    public void setReverse(boolean z) {
        this.reverse = z;
    }

    public void setIncludeMetaArray(boolean z) {
        this.includeMetaArray = z;
    }

    public void setIncludeReactions(boolean z) {
        this.includeReactions = z;
    }

    public void setIncludeParentMessageText(boolean z) {
        this.includeParentMessageText = z;
    }

    public int getPreviousResultSize() {
        return this.previousResultSize;
    }

    public int getNextResultSize() {
        return this.nextResultSize;
    }

    public BaseChannel.MessageTypeFilter getMessageType() {
        return this.messageType;
    }

    public String getCustomType() {
        return this.customType;
    }

    public List<String> getSenderUserIds() {
        return this.senderUserIds;
    }

    public boolean isInclusive() {
        return this.isInclusive;
    }

    public boolean shouldReverse() {
        return this.reverse;
    }

    public boolean shouldIncludeMetaArray() {
        return this.includeMetaArray;
    }

    public boolean shouldIncludeReactions() {
        return this.includeReactions;
    }

    public boolean shouldIncludeParentMessageText() {
        return this.includeParentMessageText;
    }

    public String toString() {
        return "BaseMessageListParams{previousResultSize=" + this.previousResultSize + ", nextResultSize=" + this.nextResultSize + ", messageType=" + this.messageType + ", customType='" + this.customType + '\'' + ", senderUserIds=" + this.senderUserIds + ", inclusive=" + this.isInclusive + ", reverse=" + this.reverse + ", includeMetaArray=" + this.includeMetaArray + ", includeReactions=" + this.includeReactions + ", includeParentMessageText=" + this.includeParentMessageText + '}';
    }
}
