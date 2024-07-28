package com.paytm.android.chat.data.db.room.db_entities;

import com.paytm.android.chat.data.models.messages.MPCMessagePreview;
import com.paytm.android.chat.utils.ChatMessageState;
import kotlin.g.b.k;

public final class ChatMessageEntity {
    private String channelType;
    private String channelUrl = "";
    private Long createdAt;
    private String customType;
    private String data;
    private int errorCode;
    private String fileName;
    private String fileUrl;
    private int id;
    private boolean isOperatorMessage;
    private boolean isSilent;
    private String mentionType;
    private String messageContent;
    private String messageCustomType;
    private long messageId;
    private MPCMessagePreview messagePreview;
    private int messageState = -1;
    private String messageType;
    private Long parentMessageId = 0L;
    private String parentMessageText;
    private byte[] rawMessage;
    private boolean readEngageEventSent;
    private String requestId = "";
    private byte[] sender;
    private String senderId;
    private String senderName;
    private Boolean showAnim;
    private String type;
    private Long updatedAt;

    public final int getId() {
        return this.id;
    }

    public final void setId(int i2) {
        this.id = i2;
    }

    public final long getMessageId() {
        return this.messageId;
    }

    public final void setMessageId(long j) {
        this.messageId = j;
    }

    public final String getMessageType() {
        return this.messageType;
    }

    public final void setMessageType(String str) {
        this.messageType = str;
    }

    public final MPCMessagePreview getMessagePreview() {
        return this.messagePreview;
    }

    public final void setMessagePreview(MPCMessagePreview mPCMessagePreview) {
        this.messagePreview = mPCMessagePreview;
    }

    public final String getRequestId() {
        return this.requestId;
    }

    public final void setRequestId(String str) {
        k.c(str, "<set-?>");
        this.requestId = str;
    }

    public final String getChannelUrl() {
        return this.channelUrl;
    }

    public final void setChannelUrl(String str) {
        k.c(str, "<set-?>");
        this.channelUrl = str;
    }

    public final String getSenderId() {
        return this.senderId;
    }

    public final void setSenderId(String str) {
        this.senderId = str;
    }

    public final String getSenderName() {
        return this.senderName;
    }

    public final void setSenderName(String str) {
        this.senderName = str;
    }

    public final String getMessageCustomType() {
        return this.messageCustomType;
    }

    public final void setMessageCustomType(String str) {
        this.messageCustomType = str;
    }

    public final Long getCreatedAt() {
        return this.createdAt;
    }

    public final void setCreatedAt(Long l) {
        this.createdAt = l;
    }

    public final Long getUpdatedAt() {
        return this.updatedAt;
    }

    public final void setUpdatedAt(Long l) {
        this.updatedAt = l;
    }

    public final int getMessageState() {
        return this.messageState;
    }

    public final void setMessageState(int i2) {
        this.messageState = i2;
    }

    public final boolean getReadEngageEventSent() {
        return this.readEngageEventSent;
    }

    public final void setReadEngageEventSent(boolean z) {
        this.readEngageEventSent = z;
    }

    public final byte[] getRawMessage() {
        return this.rawMessage;
    }

    public final void setRawMessage(byte[] bArr) {
        this.rawMessage = bArr;
    }

    public final Boolean getShowAnim() {
        return this.showAnim;
    }

    public final void setShowAnim(Boolean bool) {
        this.showAnim = bool;
    }

    /* renamed from: getMessageState  reason: collision with other method in class */
    public final ChatMessageState m511getMessageState() {
        return ChatMessageState.Companion.fromInt(Integer.valueOf(this.messageState));
    }

    public final String getMessageContent() {
        return this.messageContent;
    }

    public final void setMessageContent(String str) {
        this.messageContent = str;
    }

    public final boolean isOperatorMessage() {
        return this.isOperatorMessage;
    }

    public final void setOperatorMessage(boolean z) {
        this.isOperatorMessage = z;
    }

    public final String getChannelType() {
        return this.channelType;
    }

    public final void setChannelType(String str) {
        this.channelType = str;
    }

    public final String getCustomType() {
        return this.customType;
    }

    public final void setCustomType(String str) {
        this.customType = str;
    }

    public final String getData() {
        return this.data;
    }

    public final void setData(String str) {
        this.data = str;
    }

    public final int getErrorCode() {
        return this.errorCode;
    }

    public final void setErrorCode(int i2) {
        this.errorCode = i2;
    }

    public final boolean isSilent() {
        return this.isSilent;
    }

    public final void setSilent(boolean z) {
        this.isSilent = z;
    }

    public final String getMentionType() {
        return this.mentionType;
    }

    public final void setMentionType(String str) {
        this.mentionType = str;
    }

    public final byte[] getSender() {
        return this.sender;
    }

    public final void setSender(byte[] bArr) {
        this.sender = bArr;
    }

    public final Long getParentMessageId() {
        return this.parentMessageId;
    }

    public final void setParentMessageId(Long l) {
        this.parentMessageId = l;
    }

    public final String getParentMessageText() {
        return this.parentMessageText;
    }

    public final void setParentMessageText(String str) {
        this.parentMessageText = str;
    }

    public final String getType() {
        return this.type;
    }

    public final void setType(String str) {
        this.type = str;
    }

    public final String getFileUrl() {
        return this.fileUrl;
    }

    public final void setFileUrl(String str) {
        this.fileUrl = str;
    }

    public final String getFileName() {
        return this.fileName;
    }

    public final void setFileName(String str) {
        this.fileName = str;
    }
}
