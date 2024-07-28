package com.paytm.android.chat.data.models.channels;

import com.alipay.mobile.nebula.util.tar.TarConstants;
import com.paytm.android.chat.bean.ChannelMetaData;
import com.paytm.android.chat.bean.ReceiverDisplayInfo;
import com.paytm.android.chat.data.models.messages.ChatMessageDataModel;
import com.paytm.android.chat.data.models.messages.MPCMessagePreview;
import com.paytm.android.chat.data.models.users.ChatUserDataModel;
import java.util.List;
import kotlin.g.b.g;
import kotlin.g.b.k;
import net.one97.paytm.nativesdk.emiSubvention.utils.EmiUtil;
import net.one97.paytm.phoenix.provider.download.FileDownloadDefaultParamsKt;
import net.one97.paytm.upi.util.UpiConstants;

public final class ChatGroupChannelDataModel {
    private final String channelUrl;
    private String createdBy;
    private String customType;
    private String data;
    private String draftMessage;
    private Long invitedAt;
    private String inviter;
    private boolean isBroadcast;
    private boolean isDiscoverable;
    private boolean isDistinct;
    private boolean isFake;
    private boolean isHidden;
    private boolean isPayAllowed;
    private boolean isPinned;
    private boolean isPublic;
    private boolean isPushEnabled;
    private boolean isReplyAllowed;
    private boolean isRequestAllowed;
    private boolean isTyping;
    private int joinedMemberCount;
    private ChatMessageDataModel lastMessage;
    private MPCMessagePreview lastMessagePreview;
    private String lastMessageType;
    private Long lastmessageId;
    private int memberCount;
    private List<ChatUserDataModel> members;
    private ChannelMetaData metaData;
    private long myLastRead;
    private String name;
    private ReceiverDisplayInfo receiverDisplayInfo;
    private int unreadMentionCount;
    private int unreadMessageCount;

    public static /* synthetic */ ChatGroupChannelDataModel copy$default(ChatGroupChannelDataModel chatGroupChannelDataModel, boolean z, String str, ReceiverDisplayInfo receiverDisplayInfo2, boolean z2, ChatMessageDataModel chatMessageDataModel, MPCMessagePreview mPCMessagePreview, String str2, List list, Long l, String str3, int i2, long j, int i3, int i4, String str4, String str5, boolean z3, String str6, Long l2, String str7, boolean z4, boolean z5, boolean z6, boolean z7, boolean z8, ChannelMetaData channelMetaData, int i5, boolean z9, boolean z10, boolean z11, String str8, int i6, Object obj) {
        ChatGroupChannelDataModel chatGroupChannelDataModel2 = chatGroupChannelDataModel;
        int i7 = i6;
        return chatGroupChannelDataModel.copy((i7 & 1) != 0 ? chatGroupChannelDataModel2.isFake : z, (i7 & 2) != 0 ? chatGroupChannelDataModel2.channelUrl : str, (i7 & 4) != 0 ? chatGroupChannelDataModel2.receiverDisplayInfo : receiverDisplayInfo2, (i7 & 8) != 0 ? chatGroupChannelDataModel2.isPinned : z2, (i7 & 16) != 0 ? chatGroupChannelDataModel2.lastMessage : chatMessageDataModel, (i7 & 32) != 0 ? chatGroupChannelDataModel2.lastMessagePreview : mPCMessagePreview, (i7 & 64) != 0 ? chatGroupChannelDataModel2.draftMessage : str2, (i7 & 128) != 0 ? chatGroupChannelDataModel2.members : list, (i7 & UpiConstants.REQUEST_OPEN_APP_PERMISSION_READ_SMS) != 0 ? chatGroupChannelDataModel2.lastmessageId : l, (i7 & 512) != 0 ? chatGroupChannelDataModel2.lastMessageType : str3, (i7 & TarConstants.EOF_BLOCK) != 0 ? chatGroupChannelDataModel2.memberCount : i2, (i7 & EmiUtil.EMI_PLAN_REQUEST_CODE) != 0 ? chatGroupChannelDataModel2.myLastRead : j, (i7 & 4096) != 0 ? chatGroupChannelDataModel2.unreadMessageCount : i3, (i7 & FileDownloadDefaultParamsKt.DOWNLOAD_BUFFER_SIZE) != 0 ? chatGroupChannelDataModel2.unreadMentionCount : i4, (i7 & 16384) != 0 ? chatGroupChannelDataModel2.data : str4, (i7 & 32768) != 0 ? chatGroupChannelDataModel2.createdBy : str5, (i7 & 65536) != 0 ? chatGroupChannelDataModel2.isBroadcast : z3, (i7 & 131072) != 0 ? chatGroupChannelDataModel2.customType : str6, (i7 & 262144) != 0 ? chatGroupChannelDataModel2.invitedAt : l2, (i7 & 524288) != 0 ? chatGroupChannelDataModel2.inviter : str7, (i7 & 1048576) != 0 ? chatGroupChannelDataModel2.isDiscoverable : z4, (i7 & 2097152) != 0 ? chatGroupChannelDataModel2.isDistinct : z5, (i7 & 4194304) != 0 ? chatGroupChannelDataModel2.isHidden : z6, (i7 & 8388608) != 0 ? chatGroupChannelDataModel2.isPublic : z7, (i7 & 16777216) != 0 ? chatGroupChannelDataModel2.isPushEnabled : z8, (i7 & 33554432) != 0 ? chatGroupChannelDataModel2.metaData : channelMetaData, (i7 & 67108864) != 0 ? chatGroupChannelDataModel2.joinedMemberCount : i5, (i7 & 134217728) != 0 ? chatGroupChannelDataModel2.isReplyAllowed : z9, (i7 & 268435456) != 0 ? chatGroupChannelDataModel2.isRequestAllowed : z10, (i7 & 536870912) != 0 ? chatGroupChannelDataModel2.isPayAllowed : z11, (i7 & 1073741824) != 0 ? chatGroupChannelDataModel2.name : str8);
    }

    public final boolean component1() {
        return this.isFake;
    }

    public final String component10() {
        return this.lastMessageType;
    }

    public final int component11() {
        return this.memberCount;
    }

    public final long component12() {
        return this.myLastRead;
    }

    public final int component13() {
        return this.unreadMessageCount;
    }

    public final int component14() {
        return this.unreadMentionCount;
    }

    public final String component15() {
        return this.data;
    }

    public final String component16() {
        return this.createdBy;
    }

    public final boolean component17() {
        return this.isBroadcast;
    }

    public final String component18() {
        return this.customType;
    }

    public final Long component19() {
        return this.invitedAt;
    }

    public final String component2() {
        return this.channelUrl;
    }

    public final String component20() {
        return this.inviter;
    }

    public final boolean component21() {
        return this.isDiscoverable;
    }

    public final boolean component22() {
        return this.isDistinct;
    }

    public final boolean component23() {
        return this.isHidden;
    }

    public final boolean component24() {
        return this.isPublic;
    }

    public final boolean component25() {
        return this.isPushEnabled;
    }

    public final ChannelMetaData component26() {
        return this.metaData;
    }

    public final int component27() {
        return this.joinedMemberCount;
    }

    public final boolean component28() {
        return this.isReplyAllowed;
    }

    public final boolean component29() {
        return this.isRequestAllowed;
    }

    public final ReceiverDisplayInfo component3() {
        return this.receiverDisplayInfo;
    }

    public final boolean component30() {
        return this.isPayAllowed;
    }

    public final String component31() {
        return this.name;
    }

    public final boolean component4() {
        return this.isPinned;
    }

    public final ChatMessageDataModel component5() {
        return this.lastMessage;
    }

    public final MPCMessagePreview component6() {
        return this.lastMessagePreview;
    }

    public final String component7() {
        return this.draftMessage;
    }

    public final List<ChatUserDataModel> component8() {
        return this.members;
    }

    public final Long component9() {
        return this.lastmessageId;
    }

    public final ChatGroupChannelDataModel copy(boolean z, String str, ReceiverDisplayInfo receiverDisplayInfo2, boolean z2, ChatMessageDataModel chatMessageDataModel, MPCMessagePreview mPCMessagePreview, String str2, List<ChatUserDataModel> list, Long l, String str3, int i2, long j, int i3, int i4, String str4, String str5, boolean z3, String str6, Long l2, String str7, boolean z4, boolean z5, boolean z6, boolean z7, boolean z8, ChannelMetaData channelMetaData, int i5, boolean z9, boolean z10, boolean z11, String str8) {
        boolean z12 = z;
        k.c(str, "channelUrl");
        k.c(receiverDisplayInfo2, "receiverDisplayInfo");
        k.c(list, "members");
        k.c(str8, "name");
        return new ChatGroupChannelDataModel(z, str, receiverDisplayInfo2, z2, chatMessageDataModel, mPCMessagePreview, str2, list, l, str3, i2, j, i3, i4, str4, str5, z3, str6, l2, str7, z4, z5, z6, z7, z8, channelMetaData, i5, z9, z10, z11, str8);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ChatGroupChannelDataModel)) {
            return false;
        }
        ChatGroupChannelDataModel chatGroupChannelDataModel = (ChatGroupChannelDataModel) obj;
        return this.isFake == chatGroupChannelDataModel.isFake && k.a((Object) this.channelUrl, (Object) chatGroupChannelDataModel.channelUrl) && k.a((Object) this.receiverDisplayInfo, (Object) chatGroupChannelDataModel.receiverDisplayInfo) && this.isPinned == chatGroupChannelDataModel.isPinned && k.a((Object) this.lastMessage, (Object) chatGroupChannelDataModel.lastMessage) && k.a((Object) this.lastMessagePreview, (Object) chatGroupChannelDataModel.lastMessagePreview) && k.a((Object) this.draftMessage, (Object) chatGroupChannelDataModel.draftMessage) && k.a((Object) this.members, (Object) chatGroupChannelDataModel.members) && k.a((Object) this.lastmessageId, (Object) chatGroupChannelDataModel.lastmessageId) && k.a((Object) this.lastMessageType, (Object) chatGroupChannelDataModel.lastMessageType) && this.memberCount == chatGroupChannelDataModel.memberCount && this.myLastRead == chatGroupChannelDataModel.myLastRead && this.unreadMessageCount == chatGroupChannelDataModel.unreadMessageCount && this.unreadMentionCount == chatGroupChannelDataModel.unreadMentionCount && k.a((Object) this.data, (Object) chatGroupChannelDataModel.data) && k.a((Object) this.createdBy, (Object) chatGroupChannelDataModel.createdBy) && this.isBroadcast == chatGroupChannelDataModel.isBroadcast && k.a((Object) this.customType, (Object) chatGroupChannelDataModel.customType) && k.a((Object) this.invitedAt, (Object) chatGroupChannelDataModel.invitedAt) && k.a((Object) this.inviter, (Object) chatGroupChannelDataModel.inviter) && this.isDiscoverable == chatGroupChannelDataModel.isDiscoverable && this.isDistinct == chatGroupChannelDataModel.isDistinct && this.isHidden == chatGroupChannelDataModel.isHidden && this.isPublic == chatGroupChannelDataModel.isPublic && this.isPushEnabled == chatGroupChannelDataModel.isPushEnabled && k.a((Object) this.metaData, (Object) chatGroupChannelDataModel.metaData) && this.joinedMemberCount == chatGroupChannelDataModel.joinedMemberCount && this.isReplyAllowed == chatGroupChannelDataModel.isReplyAllowed && this.isRequestAllowed == chatGroupChannelDataModel.isRequestAllowed && this.isPayAllowed == chatGroupChannelDataModel.isPayAllowed && k.a((Object) this.name, (Object) chatGroupChannelDataModel.name);
    }

    public final int hashCode() {
        boolean z = this.isFake;
        boolean z2 = true;
        if (z) {
            z = true;
        }
        int i2 = (z ? 1 : 0) * true;
        String str = this.channelUrl;
        int i3 = 0;
        int hashCode = (i2 + (str != null ? str.hashCode() : 0)) * 31;
        ReceiverDisplayInfo receiverDisplayInfo2 = this.receiverDisplayInfo;
        int hashCode2 = (hashCode + (receiverDisplayInfo2 != null ? receiverDisplayInfo2.hashCode() : 0)) * 31;
        boolean z3 = this.isPinned;
        if (z3) {
            z3 = true;
        }
        int i4 = (hashCode2 + (z3 ? 1 : 0)) * 31;
        ChatMessageDataModel chatMessageDataModel = this.lastMessage;
        int hashCode3 = (i4 + (chatMessageDataModel != null ? chatMessageDataModel.hashCode() : 0)) * 31;
        MPCMessagePreview mPCMessagePreview = this.lastMessagePreview;
        int hashCode4 = (hashCode3 + (mPCMessagePreview != null ? mPCMessagePreview.hashCode() : 0)) * 31;
        String str2 = this.draftMessage;
        int hashCode5 = (hashCode4 + (str2 != null ? str2.hashCode() : 0)) * 31;
        List<ChatUserDataModel> list = this.members;
        int hashCode6 = (hashCode5 + (list != null ? list.hashCode() : 0)) * 31;
        Long l = this.lastmessageId;
        int hashCode7 = (hashCode6 + (l != null ? l.hashCode() : 0)) * 31;
        String str3 = this.lastMessageType;
        int hashCode8 = str3 != null ? str3.hashCode() : 0;
        long j = this.myLastRead;
        int i5 = (((((((((hashCode7 + hashCode8) * 31) + this.memberCount) * 31) + ((int) (j ^ (j >>> 32)))) * 31) + this.unreadMessageCount) * 31) + this.unreadMentionCount) * 31;
        String str4 = this.data;
        int hashCode9 = (i5 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.createdBy;
        int hashCode10 = (hashCode9 + (str5 != null ? str5.hashCode() : 0)) * 31;
        boolean z4 = this.isBroadcast;
        if (z4) {
            z4 = true;
        }
        int i6 = (hashCode10 + (z4 ? 1 : 0)) * 31;
        String str6 = this.customType;
        int hashCode11 = (i6 + (str6 != null ? str6.hashCode() : 0)) * 31;
        Long l2 = this.invitedAt;
        int hashCode12 = (hashCode11 + (l2 != null ? l2.hashCode() : 0)) * 31;
        String str7 = this.inviter;
        int hashCode13 = (hashCode12 + (str7 != null ? str7.hashCode() : 0)) * 31;
        boolean z5 = this.isDiscoverable;
        if (z5) {
            z5 = true;
        }
        int i7 = (hashCode13 + (z5 ? 1 : 0)) * 31;
        boolean z6 = this.isDistinct;
        if (z6) {
            z6 = true;
        }
        int i8 = (i7 + (z6 ? 1 : 0)) * 31;
        boolean z7 = this.isHidden;
        if (z7) {
            z7 = true;
        }
        int i9 = (i8 + (z7 ? 1 : 0)) * 31;
        boolean z8 = this.isPublic;
        if (z8) {
            z8 = true;
        }
        int i10 = (i9 + (z8 ? 1 : 0)) * 31;
        boolean z9 = this.isPushEnabled;
        if (z9) {
            z9 = true;
        }
        int i11 = (i10 + (z9 ? 1 : 0)) * 31;
        ChannelMetaData channelMetaData = this.metaData;
        int hashCode14 = (((i11 + (channelMetaData != null ? channelMetaData.hashCode() : 0)) * 31) + this.joinedMemberCount) * 31;
        boolean z10 = this.isReplyAllowed;
        if (z10) {
            z10 = true;
        }
        int i12 = (hashCode14 + (z10 ? 1 : 0)) * 31;
        boolean z11 = this.isRequestAllowed;
        if (z11) {
            z11 = true;
        }
        int i13 = (i12 + (z11 ? 1 : 0)) * 31;
        boolean z12 = this.isPayAllowed;
        if (!z12) {
            z2 = z12;
        }
        int i14 = (i13 + (z2 ? 1 : 0)) * 31;
        String str8 = this.name;
        if (str8 != null) {
            i3 = str8.hashCode();
        }
        return i14 + i3;
    }

    public final String toString() {
        return "ChatGroupChannelDataModel(isFake=" + this.isFake + ", channelUrl=" + this.channelUrl + ", receiverDisplayInfo=" + this.receiverDisplayInfo + ", isPinned=" + this.isPinned + ", lastMessage=" + this.lastMessage + ", lastMessagePreview=" + this.lastMessagePreview + ", draftMessage=" + this.draftMessage + ", members=" + this.members + ", lastmessageId=" + this.lastmessageId + ", lastMessageType=" + this.lastMessageType + ", memberCount=" + this.memberCount + ", myLastRead=" + this.myLastRead + ", unreadMessageCount=" + this.unreadMessageCount + ", unreadMentionCount=" + this.unreadMentionCount + ", data=" + this.data + ", createdBy=" + this.createdBy + ", isBroadcast=" + this.isBroadcast + ", customType=" + this.customType + ", invitedAt=" + this.invitedAt + ", inviter=" + this.inviter + ", isDiscoverable=" + this.isDiscoverable + ", isDistinct=" + this.isDistinct + ", isHidden=" + this.isHidden + ", isPublic=" + this.isPublic + ", isPushEnabled=" + this.isPushEnabled + ", metaData=" + this.metaData + ", joinedMemberCount=" + this.joinedMemberCount + ", isReplyAllowed=" + this.isReplyAllowed + ", isRequestAllowed=" + this.isRequestAllowed + ", isPayAllowed=" + this.isPayAllowed + ", name=" + this.name + ")";
    }

    public ChatGroupChannelDataModel(boolean z, String str, ReceiverDisplayInfo receiverDisplayInfo2, boolean z2, ChatMessageDataModel chatMessageDataModel, MPCMessagePreview mPCMessagePreview, String str2, List<ChatUserDataModel> list, Long l, String str3, int i2, long j, int i3, int i4, String str4, String str5, boolean z3, String str6, Long l2, String str7, boolean z4, boolean z5, boolean z6, boolean z7, boolean z8, ChannelMetaData channelMetaData, int i5, boolean z9, boolean z10, boolean z11, String str8) {
        String str9 = str8;
        k.c(str, "channelUrl");
        k.c(receiverDisplayInfo2, "receiverDisplayInfo");
        k.c(list, "members");
        k.c(str9, "name");
        this.isFake = z;
        this.channelUrl = str;
        this.receiverDisplayInfo = receiverDisplayInfo2;
        this.isPinned = z2;
        this.lastMessage = chatMessageDataModel;
        this.lastMessagePreview = mPCMessagePreview;
        this.draftMessage = str2;
        this.members = list;
        this.lastmessageId = l;
        this.lastMessageType = str3;
        this.memberCount = i2;
        this.myLastRead = j;
        this.unreadMessageCount = i3;
        this.unreadMentionCount = i4;
        this.data = str4;
        this.createdBy = str5;
        this.isBroadcast = z3;
        this.customType = str6;
        this.invitedAt = l2;
        this.inviter = str7;
        this.isDiscoverable = z4;
        this.isDistinct = z5;
        this.isHidden = z6;
        this.isPublic = z7;
        this.isPushEnabled = z8;
        this.metaData = channelMetaData;
        this.joinedMemberCount = i5;
        this.isReplyAllowed = z9;
        this.isRequestAllowed = z10;
        this.isPayAllowed = z11;
        this.name = str9;
    }

    public final boolean isFake() {
        return this.isFake;
    }

    public final void setFake(boolean z) {
        this.isFake = z;
    }

    public final String getChannelUrl() {
        return this.channelUrl;
    }

    public final ReceiverDisplayInfo getReceiverDisplayInfo() {
        return this.receiverDisplayInfo;
    }

    public final void setReceiverDisplayInfo(ReceiverDisplayInfo receiverDisplayInfo2) {
        k.c(receiverDisplayInfo2, "<set-?>");
        this.receiverDisplayInfo = receiverDisplayInfo2;
    }

    public final boolean isPinned() {
        return this.isPinned;
    }

    public final void setPinned(boolean z) {
        this.isPinned = z;
    }

    public final ChatMessageDataModel getLastMessage() {
        return this.lastMessage;
    }

    public final void setLastMessage(ChatMessageDataModel chatMessageDataModel) {
        this.lastMessage = chatMessageDataModel;
    }

    public final MPCMessagePreview getLastMessagePreview() {
        return this.lastMessagePreview;
    }

    public final void setLastMessagePreview(MPCMessagePreview mPCMessagePreview) {
        this.lastMessagePreview = mPCMessagePreview;
    }

    public final String getDraftMessage() {
        return this.draftMessage;
    }

    public final void setDraftMessage(String str) {
        this.draftMessage = str;
    }

    public final List<ChatUserDataModel> getMembers() {
        return this.members;
    }

    public final void setMembers(List<ChatUserDataModel> list) {
        k.c(list, "<set-?>");
        this.members = list;
    }

    public final Long getLastmessageId() {
        return this.lastmessageId;
    }

    public final void setLastmessageId(Long l) {
        this.lastmessageId = l;
    }

    public final String getLastMessageType() {
        return this.lastMessageType;
    }

    public final void setLastMessageType(String str) {
        this.lastMessageType = str;
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

    public final Long getInvitedAt() {
        return this.invitedAt;
    }

    public final void setInvitedAt(Long l) {
        this.invitedAt = l;
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

    public final ChannelMetaData getMetaData() {
        return this.metaData;
    }

    public final void setMetaData(ChannelMetaData channelMetaData) {
        this.metaData = channelMetaData;
    }

    public final int getJoinedMemberCount() {
        return this.joinedMemberCount;
    }

    public final void setJoinedMemberCount(int i2) {
        this.joinedMemberCount = i2;
    }

    public final boolean isReplyAllowed() {
        return this.isReplyAllowed;
    }

    public final void setReplyAllowed(boolean z) {
        this.isReplyAllowed = z;
    }

    public final boolean isRequestAllowed() {
        return this.isRequestAllowed;
    }

    public final void setRequestAllowed(boolean z) {
        this.isRequestAllowed = z;
    }

    public final boolean isPayAllowed() {
        return this.isPayAllowed;
    }

    public final void setPayAllowed(boolean z) {
        this.isPayAllowed = z;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ChatGroupChannelDataModel(boolean z, String str, ReceiverDisplayInfo receiverDisplayInfo2, boolean z2, ChatMessageDataModel chatMessageDataModel, MPCMessagePreview mPCMessagePreview, String str2, List list, Long l, String str3, int i2, long j, int i3, int i4, String str4, String str5, boolean z3, String str6, Long l2, String str7, boolean z4, boolean z5, boolean z6, boolean z7, boolean z8, ChannelMetaData channelMetaData, int i5, boolean z9, boolean z10, boolean z11, String str8, int i6, g gVar) {
        this((i6 & 1) != 0 ? false : z, str, receiverDisplayInfo2, (i6 & 8) != 0 ? false : z2, chatMessageDataModel, mPCMessagePreview, (i6 & 64) != 0 ? null : str2, list, l, str3, i2, j, i3, i4, str4, str5, z3, str6, l2, str7, z4, z5, z6, z7, z8, channelMetaData, i5, z9, z10, z11, (i6 & 1073741824) != 0 ? "" : str8);
    }

    public final String getName() {
        return this.name;
    }

    public final void setName(String str) {
        k.c(str, "<set-?>");
        this.name = str;
    }

    public final boolean isTyping() {
        return this.isTyping;
    }

    public final void setTyping(boolean z) {
        this.isTyping = z;
    }
}
