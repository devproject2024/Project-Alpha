package com.paytm.android.chat.data.db.room.db_entities;

import com.paytm.android.chat.bean.ChannelMetaData;
import com.paytm.android.chat.data.models.messages.MPCMessagePreview;
import com.sendbird.android.Member;
import java.util.ArrayList;
import java.util.List;
import kotlin.g.b.k;

public final class ChatChannelEntity {
    private String channelUrl = "NOT SET";
    private Long createdAt;
    private String createdBy;
    private String customType;
    private String data;
    private String draftMessage;
    private long invitedAt;
    private String inviter;
    private boolean isBroadcast;
    private boolean isDiscoverable;
    private boolean isDistinct;
    private boolean isFake;
    private boolean isHidden;
    private boolean isPinned;
    private boolean isPublic;
    private boolean isPushEnabled;
    private int joinedMemberCount;
    private Long lastMessageId = 0L;
    private Long lastMessageTs;
    private String lastMessageType;
    private int memberCount;
    private List<? extends Member> members = new ArrayList();
    private MPCMessagePreview messagePreview;
    private ChannelMetaData metaData;
    private long myLastRead;
    private String name;
    private boolean payAllowed;
    private byte[] rawChannel;
    private boolean replyAllowed = true;
    private boolean requestAllowed;
    private int unreadMentionCount;
    private int unreadMessageCount;

    public final boolean isFake() {
        return this.isFake;
    }

    public final void setFake(boolean z) {
        this.isFake = z;
    }

    public final String getChannelUrl() {
        return this.channelUrl;
    }

    public final void setChannelUrl(String str) {
        k.c(str, "<set-?>");
        this.channelUrl = str;
    }

    public final String getName() {
        return this.name;
    }

    public final void setName(String str) {
        this.name = str;
    }

    public final Long getCreatedAt() {
        return this.createdAt;
    }

    public final void setCreatedAt(Long l) {
        this.createdAt = l;
    }

    public final boolean isPinned() {
        return this.isPinned;
    }

    public final void setPinned(boolean z) {
        this.isPinned = z;
    }

    public final String getDraftMessage() {
        return this.draftMessage;
    }

    public final void setDraftMessage(String str) {
        this.draftMessage = str;
    }

    public final Long getLastMessageTs() {
        return this.lastMessageTs;
    }

    public final void setLastMessageTs(Long l) {
        this.lastMessageTs = l;
    }

    public final byte[] getRawChannel() {
        return this.rawChannel;
    }

    public final void setRawChannel(byte[] bArr) {
        this.rawChannel = bArr;
    }

    public final List<Member> getMembers() {
        return this.members;
    }

    public final void setMembers(List<? extends Member> list) {
        k.c(list, "<set-?>");
        this.members = list;
    }

    public final Long getLastMessageId() {
        return this.lastMessageId;
    }

    public final void setLastMessageId(Long l) {
        this.lastMessageId = l;
    }

    public final String getLastMessageType() {
        return this.lastMessageType;
    }

    public final void setLastMessageType(String str) {
        this.lastMessageType = str;
    }

    public final MPCMessagePreview getMessagePreview() {
        return this.messagePreview;
    }

    public final void setMessagePreview(MPCMessagePreview mPCMessagePreview) {
        this.messagePreview = mPCMessagePreview;
    }

    public final int getMemberCount() {
        return this.memberCount;
    }

    public final void setMemberCount(int i2) {
        this.memberCount = i2;
    }

    public final long getMyLastRead() {
        return this.myLastRead;
    }

    public final void setMyLastRead(long j) {
        this.myLastRead = j;
    }

    public final int getUnreadMessageCount() {
        return this.unreadMessageCount;
    }

    public final void setUnreadMessageCount(int i2) {
        this.unreadMessageCount = i2;
    }

    public final int getUnreadMentionCount() {
        return this.unreadMentionCount;
    }

    public final void setUnreadMentionCount(int i2) {
        this.unreadMentionCount = i2;
    }

    public final String getData() {
        return this.data;
    }

    public final void setData(String str) {
        this.data = str;
    }

    public final String getCreatedBy() {
        return this.createdBy;
    }

    public final void setCreatedBy(String str) {
        this.createdBy = str;
    }

    public final boolean isBroadcast() {
        return this.isBroadcast;
    }

    public final void setBroadcast(boolean z) {
        this.isBroadcast = z;
    }

    public final String getCustomType() {
        return this.customType;
    }

    public final void setCustomType(String str) {
        this.customType = str;
    }

    public final long getInvitedAt() {
        return this.invitedAt;
    }

    public final void setInvitedAt(long j) {
        this.invitedAt = j;
    }

    public final String getInviter() {
        return this.inviter;
    }

    public final void setInviter(String str) {
        this.inviter = str;
    }

    public final boolean isDiscoverable() {
        return this.isDiscoverable;
    }

    public final void setDiscoverable(boolean z) {
        this.isDiscoverable = z;
    }

    public final boolean isDistinct() {
        return this.isDistinct;
    }

    public final void setDistinct(boolean z) {
        this.isDistinct = z;
    }

    public final boolean isHidden() {
        return this.isHidden;
    }

    public final void setHidden(boolean z) {
        this.isHidden = z;
    }

    public final boolean isPublic() {
        return this.isPublic;
    }

    public final void setPublic(boolean z) {
        this.isPublic = z;
    }

    public final boolean isPushEnabled() {
        return this.isPushEnabled;
    }

    public final void setPushEnabled(boolean z) {
        this.isPushEnabled = z;
    }

    public final int getJoinedMemberCount() {
        return this.joinedMemberCount;
    }

    public final void setJoinedMemberCount(int i2) {
        this.joinedMemberCount = i2;
    }

    public final ChannelMetaData getMetaData() {
        return this.metaData;
    }

    public final void setMetaData(ChannelMetaData channelMetaData) {
        this.metaData = channelMetaData;
    }

    public final boolean getPayAllowed() {
        return this.payAllowed;
    }

    public final void setPayAllowed(boolean z) {
        this.payAllowed = z;
    }

    public final boolean getRequestAllowed() {
        return this.requestAllowed;
    }

    public final void setRequestAllowed(boolean z) {
        this.requestAllowed = z;
    }

    public final boolean getReplyAllowed() {
        return this.replyAllowed;
    }

    public final void setReplyAllowed(boolean z) {
        this.replyAllowed = z;
    }
}
