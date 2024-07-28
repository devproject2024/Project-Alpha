package com.paytm.android.chat.data.models.users;

import com.alipay.mobile.nebula.util.tar.TarConstants;
import com.paytm.android.chat.bean.UserExtendedMetaData;
import com.paytm.android.chat.bean.UserMetaData;
import com.paytm.android.chat.bean.jsonbean.UsersInfoJsonBean;
import com.paytm.android.chat.contact.a;
import com.paytm.android.chat.data.db.room.db_entities.ChatUserEntity;
import com.paytm.android.chat.data.db.room.db_entities.UserInfoSource;
import com.paytm.android.chat.data.models.users.payments.UserPaymentDataModel;
import com.paytm.android.chat.utils.AppUtilKt;
import java.util.Arrays;
import kotlin.g.b.g;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.chat.moneytransfer.BankChatPayeeUser;
import net.one97.paytm.common.entity.chat.moneytransfer.ChatPayeeUser;
import net.one97.paytm.common.entity.chat.moneytransfer.ChatUserType;
import net.one97.paytm.common.entity.chat.moneytransfer.CustomerChatPayeeUser;
import net.one97.paytm.common.entity.chat.moneytransfer.MerchantChatPayeeUser;
import net.one97.paytm.common.entity.chat.moneytransfer.MobileNumberChatPayeeUser;
import net.one97.paytm.common.entity.chat.moneytransfer.VpaChatPayeeUser;
import net.one97.paytm.nativesdk.emiSubvention.utils.EmiUtil;
import net.one97.paytm.phoenix.provider.download.FileDownloadDefaultParamsKt;
import net.one97.paytm.upi.util.UpiConstants;

public final class ChatUserDataModel {
    private a addressBookContact;
    private String avatarUrl;
    private ChatUserEntity.ChatPaymentMetadata chatPaymentMetadata;
    private String connectionStatus;
    private String contactId;
    private long createdAt;
    private String friendDiscoverykey;
    private String friendName;
    private String identifier;
    private Boolean isActive;
    private boolean isBlockedByMe;
    private boolean isBlocking;
    private boolean isMe;
    private boolean isMuted;
    private String lastSeenAt;
    private Long lastUpdatedUserExtendedMetaData;
    private String phoneHash;
    private String phoneNumber;
    private byte[] rawMember;
    private String sendbirdUserId;
    private String sendbirdUsername;
    private UserInfoSource source;
    private ChatUserType type;
    private long updatedAt;
    private UserExtendedMetaData userExtendedMetaData;
    private UserMetaData userMetaData;

    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;
        public static final /* synthetic */ int[] $EnumSwitchMapping$2;

        static {
            int[] iArr = new int[ChatUserType.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[ChatUserType.BANK.ordinal()] = 1;
            $EnumSwitchMapping$0[ChatUserType.CUSTOMER.ordinal()] = 2;
            $EnumSwitchMapping$0[ChatUserType.VPA.ordinal()] = 3;
            $EnumSwitchMapping$0[ChatUserType.MOBILE_NUMBER.ordinal()] = 4;
            $EnumSwitchMapping$0[ChatUserType.MERCHANT.ordinal()] = 5;
            int[] iArr2 = new int[ChatUserType.values().length];
            $EnumSwitchMapping$1 = iArr2;
            iArr2[ChatUserType.BANK.ordinal()] = 1;
            $EnumSwitchMapping$1[ChatUserType.VPA.ordinal()] = 2;
            $EnumSwitchMapping$1[ChatUserType.MERCHANT.ordinal()] = 3;
            $EnumSwitchMapping$1[ChatUserType.CUSTOMER.ordinal()] = 4;
            $EnumSwitchMapping$1[ChatUserType.MOBILE_NUMBER.ordinal()] = 5;
            int[] iArr3 = new int[UserInfoSource.values().length];
            $EnumSwitchMapping$2 = iArr3;
            iArr3[UserInfoSource.USER_API.ordinal()] = 1;
            $EnumSwitchMapping$2[UserInfoSource.SENDBIRD_USER.ordinal()] = 2;
            $EnumSwitchMapping$2[UserInfoSource.FRIENDS_API.ordinal()] = 3;
        }
    }

    public ChatUserDataModel() {
        this((String) null, (String) null, (ChatUserType) null, (String) null, (String) null, (String) null, (Boolean) null, (String) null, (String) null, false, false, false, (byte[]) null, (String) null, (String) null, (String) null, (UserInfoSource) null, (UserMetaData) null, (UserExtendedMetaData) null, (Long) null, 0, 0, (ChatUserEntity.ChatPaymentMetadata) null, (a) null, (String) null, 33554431, (g) null);
    }

    public static /* synthetic */ ChatUserDataModel copy$default(ChatUserDataModel chatUserDataModel, String str, String str2, ChatUserType chatUserType, String str3, String str4, String str5, Boolean bool, String str6, String str7, boolean z, boolean z2, boolean z3, byte[] bArr, String str8, String str9, String str10, UserInfoSource userInfoSource, UserMetaData userMetaData2, UserExtendedMetaData userExtendedMetaData2, Long l, long j, long j2, ChatUserEntity.ChatPaymentMetadata chatPaymentMetadata2, a aVar, String str11, int i2, Object obj) {
        ChatUserDataModel chatUserDataModel2 = chatUserDataModel;
        int i3 = i2;
        return chatUserDataModel.copy((i3 & 1) != 0 ? chatUserDataModel2.sendbirdUserId : str, (i3 & 2) != 0 ? chatUserDataModel2.identifier : str2, (i3 & 4) != 0 ? chatUserDataModel2.type : chatUserType, (i3 & 8) != 0 ? chatUserDataModel2.sendbirdUsername : str3, (i3 & 16) != 0 ? chatUserDataModel2.avatarUrl : str4, (i3 & 32) != 0 ? chatUserDataModel2.lastSeenAt : str5, (i3 & 64) != 0 ? chatUserDataModel2.isActive : bool, (i3 & 128) != 0 ? chatUserDataModel2.friendName : str6, (i3 & UpiConstants.REQUEST_OPEN_APP_PERMISSION_READ_SMS) != 0 ? chatUserDataModel2.friendDiscoverykey : str7, (i3 & 512) != 0 ? chatUserDataModel2.isBlocking : z, (i3 & TarConstants.EOF_BLOCK) != 0 ? chatUserDataModel2.isBlockedByMe : z2, (i3 & EmiUtil.EMI_PLAN_REQUEST_CODE) != 0 ? chatUserDataModel2.isMuted : z3, (i3 & 4096) != 0 ? chatUserDataModel2.rawMember : bArr, (i3 & FileDownloadDefaultParamsKt.DOWNLOAD_BUFFER_SIZE) != 0 ? chatUserDataModel2.phoneNumber : str8, (i3 & 16384) != 0 ? chatUserDataModel2.phoneHash : str9, (i3 & 32768) != 0 ? chatUserDataModel2.contactId : str10, (i3 & 65536) != 0 ? chatUserDataModel2.source : userInfoSource, (i3 & 131072) != 0 ? chatUserDataModel2.userMetaData : userMetaData2, (i3 & 262144) != 0 ? chatUserDataModel2.userExtendedMetaData : userExtendedMetaData2, (i3 & 524288) != 0 ? chatUserDataModel2.lastUpdatedUserExtendedMetaData : l, (i3 & 1048576) != 0 ? chatUserDataModel2.createdAt : j, (i3 & 2097152) != 0 ? chatUserDataModel2.updatedAt : j2, (i3 & 4194304) != 0 ? chatUserDataModel2.chatPaymentMetadata : chatPaymentMetadata2, (8388608 & i3) != 0 ? chatUserDataModel2.addressBookContact : aVar, (i3 & 16777216) != 0 ? chatUserDataModel2.connectionStatus : str11);
    }

    public final String component1() {
        return this.sendbirdUserId;
    }

    public final boolean component10() {
        return this.isBlocking;
    }

    public final boolean component11() {
        return this.isBlockedByMe;
    }

    public final boolean component12() {
        return this.isMuted;
    }

    public final byte[] component13() {
        return this.rawMember;
    }

    public final String component14() {
        return this.phoneNumber;
    }

    public final String component15() {
        return this.phoneHash;
    }

    public final String component16() {
        return this.contactId;
    }

    public final UserInfoSource component17() {
        return this.source;
    }

    public final UserMetaData component18() {
        return this.userMetaData;
    }

    public final UserExtendedMetaData component19() {
        return this.userExtendedMetaData;
    }

    public final String component2() {
        return this.identifier;
    }

    public final Long component20() {
        return this.lastUpdatedUserExtendedMetaData;
    }

    public final long component21() {
        return this.createdAt;
    }

    public final long component22() {
        return this.updatedAt;
    }

    public final ChatUserEntity.ChatPaymentMetadata component23() {
        return this.chatPaymentMetadata;
    }

    public final a component24() {
        return this.addressBookContact;
    }

    public final String component25() {
        return this.connectionStatus;
    }

    public final ChatUserType component3() {
        return this.type;
    }

    public final String component4() {
        return this.sendbirdUsername;
    }

    public final String component5() {
        return this.avatarUrl;
    }

    public final String component6() {
        return this.lastSeenAt;
    }

    public final Boolean component7() {
        return this.isActive;
    }

    public final String component8() {
        return this.friendName;
    }

    public final String component9() {
        return this.friendDiscoverykey;
    }

    public final ChatUserDataModel copy(String str, String str2, ChatUserType chatUserType, String str3, String str4, String str5, Boolean bool, String str6, String str7, boolean z, boolean z2, boolean z3, byte[] bArr, String str8, String str9, String str10, UserInfoSource userInfoSource, UserMetaData userMetaData2, UserExtendedMetaData userExtendedMetaData2, Long l, long j, long j2, ChatUserEntity.ChatPaymentMetadata chatPaymentMetadata2, a aVar, String str11) {
        return new ChatUserDataModel(str, str2, chatUserType, str3, str4, str5, bool, str6, str7, z, z2, z3, bArr, str8, str9, str10, userInfoSource, userMetaData2, userExtendedMetaData2, l, j, j2, chatPaymentMetadata2, aVar, str11);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ChatUserDataModel)) {
            return false;
        }
        ChatUserDataModel chatUserDataModel = (ChatUserDataModel) obj;
        return k.a((Object) this.sendbirdUserId, (Object) chatUserDataModel.sendbirdUserId) && k.a((Object) this.identifier, (Object) chatUserDataModel.identifier) && k.a((Object) this.type, (Object) chatUserDataModel.type) && k.a((Object) this.sendbirdUsername, (Object) chatUserDataModel.sendbirdUsername) && k.a((Object) this.avatarUrl, (Object) chatUserDataModel.avatarUrl) && k.a((Object) this.lastSeenAt, (Object) chatUserDataModel.lastSeenAt) && k.a((Object) this.isActive, (Object) chatUserDataModel.isActive) && k.a((Object) this.friendName, (Object) chatUserDataModel.friendName) && k.a((Object) this.friendDiscoverykey, (Object) chatUserDataModel.friendDiscoverykey) && this.isBlocking == chatUserDataModel.isBlocking && this.isBlockedByMe == chatUserDataModel.isBlockedByMe && this.isMuted == chatUserDataModel.isMuted && k.a((Object) this.rawMember, (Object) chatUserDataModel.rawMember) && k.a((Object) this.phoneNumber, (Object) chatUserDataModel.phoneNumber) && k.a((Object) this.phoneHash, (Object) chatUserDataModel.phoneHash) && k.a((Object) this.contactId, (Object) chatUserDataModel.contactId) && k.a((Object) this.source, (Object) chatUserDataModel.source) && k.a((Object) this.userMetaData, (Object) chatUserDataModel.userMetaData) && k.a((Object) this.userExtendedMetaData, (Object) chatUserDataModel.userExtendedMetaData) && k.a((Object) this.lastUpdatedUserExtendedMetaData, (Object) chatUserDataModel.lastUpdatedUserExtendedMetaData) && this.createdAt == chatUserDataModel.createdAt && this.updatedAt == chatUserDataModel.updatedAt && k.a((Object) this.chatPaymentMetadata, (Object) chatUserDataModel.chatPaymentMetadata) && k.a((Object) this.addressBookContact, (Object) chatUserDataModel.addressBookContact) && k.a((Object) this.connectionStatus, (Object) chatUserDataModel.connectionStatus);
    }

    public final int hashCode() {
        String str = this.sendbirdUserId;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.identifier;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        ChatUserType chatUserType = this.type;
        int hashCode3 = (hashCode2 + (chatUserType != null ? chatUserType.hashCode() : 0)) * 31;
        String str3 = this.sendbirdUsername;
        int hashCode4 = (hashCode3 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.avatarUrl;
        int hashCode5 = (hashCode4 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.lastSeenAt;
        int hashCode6 = (hashCode5 + (str5 != null ? str5.hashCode() : 0)) * 31;
        Boolean bool = this.isActive;
        int hashCode7 = (hashCode6 + (bool != null ? bool.hashCode() : 0)) * 31;
        String str6 = this.friendName;
        int hashCode8 = (hashCode7 + (str6 != null ? str6.hashCode() : 0)) * 31;
        String str7 = this.friendDiscoverykey;
        int hashCode9 = (hashCode8 + (str7 != null ? str7.hashCode() : 0)) * 31;
        boolean z = this.isBlocking;
        if (z) {
            z = true;
        }
        int i3 = (hashCode9 + (z ? 1 : 0)) * 31;
        boolean z2 = this.isBlockedByMe;
        if (z2) {
            z2 = true;
        }
        int i4 = (i3 + (z2 ? 1 : 0)) * 31;
        boolean z3 = this.isMuted;
        if (z3) {
            z3 = true;
        }
        int i5 = (i4 + (z3 ? 1 : 0)) * 31;
        byte[] bArr = this.rawMember;
        int hashCode10 = (i5 + (bArr != null ? Arrays.hashCode(bArr) : 0)) * 31;
        String str8 = this.phoneNumber;
        int hashCode11 = (hashCode10 + (str8 != null ? str8.hashCode() : 0)) * 31;
        String str9 = this.phoneHash;
        int hashCode12 = (hashCode11 + (str9 != null ? str9.hashCode() : 0)) * 31;
        String str10 = this.contactId;
        int hashCode13 = (hashCode12 + (str10 != null ? str10.hashCode() : 0)) * 31;
        UserInfoSource userInfoSource = this.source;
        int hashCode14 = (hashCode13 + (userInfoSource != null ? userInfoSource.hashCode() : 0)) * 31;
        UserMetaData userMetaData2 = this.userMetaData;
        int hashCode15 = (hashCode14 + (userMetaData2 != null ? userMetaData2.hashCode() : 0)) * 31;
        UserExtendedMetaData userExtendedMetaData2 = this.userExtendedMetaData;
        int hashCode16 = (hashCode15 + (userExtendedMetaData2 != null ? userExtendedMetaData2.hashCode() : 0)) * 31;
        Long l = this.lastUpdatedUserExtendedMetaData;
        int hashCode17 = l != null ? l.hashCode() : 0;
        long j = this.createdAt;
        long j2 = this.updatedAt;
        int i6 = (((((hashCode16 + hashCode17) * 31) + ((int) (j ^ (j >>> 32)))) * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31;
        ChatUserEntity.ChatPaymentMetadata chatPaymentMetadata2 = this.chatPaymentMetadata;
        int hashCode18 = (i6 + (chatPaymentMetadata2 != null ? chatPaymentMetadata2.hashCode() : 0)) * 31;
        a aVar = this.addressBookContact;
        int hashCode19 = (hashCode18 + (aVar != null ? aVar.hashCode() : 0)) * 31;
        String str11 = this.connectionStatus;
        if (str11 != null) {
            i2 = str11.hashCode();
        }
        return hashCode19 + i2;
    }

    public final String toString() {
        return "ChatUserDataModel(sendbirdUserId=" + this.sendbirdUserId + ", identifier=" + this.identifier + ", type=" + this.type + ", sendbirdUsername=" + this.sendbirdUsername + ", avatarUrl=" + this.avatarUrl + ", lastSeenAt=" + this.lastSeenAt + ", isActive=" + this.isActive + ", friendName=" + this.friendName + ", friendDiscoverykey=" + this.friendDiscoverykey + ", isBlocking=" + this.isBlocking + ", isBlockedByMe=" + this.isBlockedByMe + ", isMuted=" + this.isMuted + ", rawMember=" + Arrays.toString(this.rawMember) + ", phoneNumber=" + this.phoneNumber + ", phoneHash=" + this.phoneHash + ", contactId=" + this.contactId + ", source=" + this.source + ", userMetaData=" + this.userMetaData + ", userExtendedMetaData=" + this.userExtendedMetaData + ", lastUpdatedUserExtendedMetaData=" + this.lastUpdatedUserExtendedMetaData + ", createdAt=" + this.createdAt + ", updatedAt=" + this.updatedAt + ", chatPaymentMetadata=" + this.chatPaymentMetadata + ", addressBookContact=" + this.addressBookContact + ", connectionStatus=" + this.connectionStatus + ")";
    }

    public ChatUserDataModel(String str, String str2, ChatUserType chatUserType, String str3, String str4, String str5, Boolean bool, String str6, String str7, boolean z, boolean z2, boolean z3, byte[] bArr, String str8, String str9, String str10, UserInfoSource userInfoSource, UserMetaData userMetaData2, UserExtendedMetaData userExtendedMetaData2, Long l, long j, long j2, ChatUserEntity.ChatPaymentMetadata chatPaymentMetadata2, a aVar, String str11) {
        this.sendbirdUserId = str;
        this.identifier = str2;
        this.type = chatUserType;
        this.sendbirdUsername = str3;
        this.avatarUrl = str4;
        this.lastSeenAt = str5;
        this.isActive = bool;
        this.friendName = str6;
        this.friendDiscoverykey = str7;
        this.isBlocking = z;
        this.isBlockedByMe = z2;
        this.isMuted = z3;
        this.rawMember = bArr;
        this.phoneNumber = str8;
        this.phoneHash = str9;
        this.contactId = str10;
        this.source = userInfoSource;
        this.userMetaData = userMetaData2;
        this.userExtendedMetaData = userExtendedMetaData2;
        this.lastUpdatedUserExtendedMetaData = l;
        this.createdAt = j;
        this.updatedAt = j2;
        this.chatPaymentMetadata = chatPaymentMetadata2;
        this.addressBookContact = aVar;
        this.connectionStatus = str11;
    }

    public final String getSendbirdUserId() {
        return this.sendbirdUserId;
    }

    public final void setSendbirdUserId(String str) {
        this.sendbirdUserId = str;
    }

    public final String getIdentifier() {
        return this.identifier;
    }

    public final void setIdentifier(String str) {
        this.identifier = str;
    }

    public final ChatUserType getType() {
        return this.type;
    }

    public final void setType(ChatUserType chatUserType) {
        this.type = chatUserType;
    }

    public final String getSendbirdUsername() {
        return this.sendbirdUsername;
    }

    public final void setSendbirdUsername(String str) {
        this.sendbirdUsername = str;
    }

    public final String getAvatarUrl() {
        return this.avatarUrl;
    }

    public final void setAvatarUrl(String str) {
        this.avatarUrl = str;
    }

    public final String getLastSeenAt() {
        return this.lastSeenAt;
    }

    public final void setLastSeenAt(String str) {
        this.lastSeenAt = str;
    }

    public final Boolean isActive() {
        return this.isActive;
    }

    public final void setActive(Boolean bool) {
        this.isActive = bool;
    }

    public final String getFriendName() {
        return this.friendName;
    }

    public final void setFriendName(String str) {
        this.friendName = str;
    }

    public final String getFriendDiscoverykey() {
        return this.friendDiscoverykey;
    }

    public final void setFriendDiscoverykey(String str) {
        this.friendDiscoverykey = str;
    }

    public final boolean isBlocking() {
        return this.isBlocking;
    }

    public final void setBlocking(boolean z) {
        this.isBlocking = z;
    }

    public final boolean isBlockedByMe() {
        return this.isBlockedByMe;
    }

    public final void setBlockedByMe(boolean z) {
        this.isBlockedByMe = z;
    }

    public final boolean isMuted() {
        return this.isMuted;
    }

    public final void setMuted(boolean z) {
        this.isMuted = z;
    }

    public final byte[] getRawMember() {
        return this.rawMember;
    }

    public final void setRawMember(byte[] bArr) {
        this.rawMember = bArr;
    }

    public final String getPhoneNumber() {
        return this.phoneNumber;
    }

    public final void setPhoneNumber(String str) {
        this.phoneNumber = str;
    }

    public final String getPhoneHash() {
        return this.phoneHash;
    }

    public final void setPhoneHash(String str) {
        this.phoneHash = str;
    }

    public final String getContactId() {
        return this.contactId;
    }

    public final void setContactId(String str) {
        this.contactId = str;
    }

    public final UserInfoSource getSource() {
        return this.source;
    }

    public final void setSource(UserInfoSource userInfoSource) {
        this.source = userInfoSource;
    }

    public final UserMetaData getUserMetaData() {
        return this.userMetaData;
    }

    public final void setUserMetaData(UserMetaData userMetaData2) {
        this.userMetaData = userMetaData2;
    }

    public final UserExtendedMetaData getUserExtendedMetaData() {
        return this.userExtendedMetaData;
    }

    public final void setUserExtendedMetaData(UserExtendedMetaData userExtendedMetaData2) {
        this.userExtendedMetaData = userExtendedMetaData2;
    }

    public final Long getLastUpdatedUserExtendedMetaData() {
        return this.lastUpdatedUserExtendedMetaData;
    }

    public final void setLastUpdatedUserExtendedMetaData(Long l) {
        this.lastUpdatedUserExtendedMetaData = l;
    }

    public final long getCreatedAt() {
        return this.createdAt;
    }

    public final void setCreatedAt(long j) {
        this.createdAt = j;
    }

    public final long getUpdatedAt() {
        return this.updatedAt;
    }

    public final void setUpdatedAt(long j) {
        this.updatedAt = j;
    }

    public final ChatUserEntity.ChatPaymentMetadata getChatPaymentMetadata() {
        return this.chatPaymentMetadata;
    }

    public final void setChatPaymentMetadata(ChatUserEntity.ChatPaymentMetadata chatPaymentMetadata2) {
        this.chatPaymentMetadata = chatPaymentMetadata2;
    }

    public final a getAddressBookContact() {
        return this.addressBookContact;
    }

    public final void setAddressBookContact(a aVar) {
        this.addressBookContact = aVar;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ ChatUserDataModel(java.lang.String r29, java.lang.String r30, net.one97.paytm.common.entity.chat.moneytransfer.ChatUserType r31, java.lang.String r32, java.lang.String r33, java.lang.String r34, java.lang.Boolean r35, java.lang.String r36, java.lang.String r37, boolean r38, boolean r39, boolean r40, byte[] r41, java.lang.String r42, java.lang.String r43, java.lang.String r44, com.paytm.android.chat.data.db.room.db_entities.UserInfoSource r45, com.paytm.android.chat.bean.UserMetaData r46, com.paytm.android.chat.bean.UserExtendedMetaData r47, java.lang.Long r48, long r49, long r51, com.paytm.android.chat.data.db.room.db_entities.ChatUserEntity.ChatPaymentMetadata r53, com.paytm.android.chat.contact.a r54, java.lang.String r55, int r56, kotlin.g.b.g r57) {
        /*
            r28 = this;
            r0 = r56
            r1 = r0 & 1
            if (r1 == 0) goto L_0x0008
            r1 = 0
            goto L_0x000a
        L_0x0008:
            r1 = r29
        L_0x000a:
            r3 = r0 & 2
            if (r3 == 0) goto L_0x0010
            r3 = 0
            goto L_0x0012
        L_0x0010:
            r3 = r30
        L_0x0012:
            r4 = r0 & 4
            if (r4 == 0) goto L_0x0018
            r4 = 0
            goto L_0x001a
        L_0x0018:
            r4 = r31
        L_0x001a:
            r5 = r0 & 8
            if (r5 == 0) goto L_0x0020
            r5 = 0
            goto L_0x0022
        L_0x0020:
            r5 = r32
        L_0x0022:
            r6 = r0 & 16
            if (r6 == 0) goto L_0x0028
            r6 = 0
            goto L_0x002a
        L_0x0028:
            r6 = r33
        L_0x002a:
            r7 = r0 & 32
            if (r7 == 0) goto L_0x0030
            r7 = 0
            goto L_0x0032
        L_0x0030:
            r7 = r34
        L_0x0032:
            r8 = r0 & 64
            if (r8 == 0) goto L_0x0038
            r8 = 0
            goto L_0x003a
        L_0x0038:
            r8 = r35
        L_0x003a:
            r9 = r0 & 128(0x80, float:1.794E-43)
            if (r9 == 0) goto L_0x0040
            r9 = 0
            goto L_0x0042
        L_0x0040:
            r9 = r36
        L_0x0042:
            r10 = r0 & 256(0x100, float:3.59E-43)
            if (r10 == 0) goto L_0x0048
            r10 = 0
            goto L_0x004a
        L_0x0048:
            r10 = r37
        L_0x004a:
            r11 = r0 & 512(0x200, float:7.175E-43)
            r12 = 0
            if (r11 == 0) goto L_0x0051
            r11 = 0
            goto L_0x0053
        L_0x0051:
            r11 = r38
        L_0x0053:
            r13 = r0 & 1024(0x400, float:1.435E-42)
            if (r13 == 0) goto L_0x0059
            r13 = 0
            goto L_0x005b
        L_0x0059:
            r13 = r39
        L_0x005b:
            r14 = r0 & 2048(0x800, float:2.87E-42)
            if (r14 == 0) goto L_0x0060
            goto L_0x0062
        L_0x0060:
            r12 = r40
        L_0x0062:
            r14 = r0 & 4096(0x1000, float:5.74E-42)
            if (r14 == 0) goto L_0x0068
            r14 = 0
            goto L_0x006a
        L_0x0068:
            r14 = r41
        L_0x006a:
            r15 = r0 & 8192(0x2000, float:1.14794E-41)
            if (r15 == 0) goto L_0x0070
            r15 = 0
            goto L_0x0072
        L_0x0070:
            r15 = r42
        L_0x0072:
            r2 = r0 & 16384(0x4000, float:2.2959E-41)
            if (r2 == 0) goto L_0x0078
            r2 = 0
            goto L_0x007a
        L_0x0078:
            r2 = r43
        L_0x007a:
            r16 = 32768(0x8000, float:4.5918E-41)
            r16 = r0 & r16
            if (r16 == 0) goto L_0x0084
            r16 = 0
            goto L_0x0086
        L_0x0084:
            r16 = r44
        L_0x0086:
            r17 = 65536(0x10000, float:9.18355E-41)
            r17 = r0 & r17
            if (r17 == 0) goto L_0x008f
            r17 = 0
            goto L_0x0091
        L_0x008f:
            r17 = r45
        L_0x0091:
            r18 = 131072(0x20000, float:1.83671E-40)
            r18 = r0 & r18
            if (r18 == 0) goto L_0x009a
            r18 = 0
            goto L_0x009c
        L_0x009a:
            r18 = r46
        L_0x009c:
            r19 = 262144(0x40000, float:3.67342E-40)
            r19 = r0 & r19
            if (r19 == 0) goto L_0x00a5
            r19 = 0
            goto L_0x00a7
        L_0x00a5:
            r19 = r47
        L_0x00a7:
            r20 = 524288(0x80000, float:7.34684E-40)
            r20 = r0 & r20
            if (r20 == 0) goto L_0x00b0
            r20 = 0
            goto L_0x00b2
        L_0x00b0:
            r20 = r48
        L_0x00b2:
            r21 = 1048576(0x100000, float:1.469368E-39)
            r21 = r0 & r21
            r22 = 0
            if (r21 == 0) goto L_0x00bd
            r24 = r22
            goto L_0x00bf
        L_0x00bd:
            r24 = r49
        L_0x00bf:
            r21 = 2097152(0x200000, float:2.938736E-39)
            r21 = r0 & r21
            if (r21 == 0) goto L_0x00c6
            goto L_0x00c8
        L_0x00c6:
            r22 = r51
        L_0x00c8:
            r21 = 4194304(0x400000, float:5.877472E-39)
            r21 = r0 & r21
            if (r21 == 0) goto L_0x00d1
            r21 = 0
            goto L_0x00d3
        L_0x00d1:
            r21 = r53
        L_0x00d3:
            r26 = 8388608(0x800000, float:1.17549435E-38)
            r26 = r0 & r26
            if (r26 == 0) goto L_0x00dc
            r26 = 0
            goto L_0x00de
        L_0x00dc:
            r26 = r54
        L_0x00de:
            r27 = 16777216(0x1000000, float:2.3509887E-38)
            r0 = r0 & r27
            if (r0 == 0) goto L_0x00e6
            r0 = 0
            goto L_0x00e8
        L_0x00e6:
            r0 = r55
        L_0x00e8:
            r29 = r28
            r30 = r1
            r31 = r3
            r32 = r4
            r33 = r5
            r34 = r6
            r35 = r7
            r36 = r8
            r37 = r9
            r38 = r10
            r39 = r11
            r40 = r13
            r41 = r12
            r42 = r14
            r43 = r15
            r44 = r2
            r45 = r16
            r46 = r17
            r47 = r18
            r48 = r19
            r49 = r20
            r50 = r24
            r52 = r22
            r54 = r21
            r55 = r26
            r56 = r0
            r29.<init>(r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40, r41, r42, r43, r44, r45, r46, r47, r48, r49, r50, r52, r54, r55, r56)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.paytm.android.chat.data.models.users.ChatUserDataModel.<init>(java.lang.String, java.lang.String, net.one97.paytm.common.entity.chat.moneytransfer.ChatUserType, java.lang.String, java.lang.String, java.lang.String, java.lang.Boolean, java.lang.String, java.lang.String, boolean, boolean, boolean, byte[], java.lang.String, java.lang.String, java.lang.String, com.paytm.android.chat.data.db.room.db_entities.UserInfoSource, com.paytm.android.chat.bean.UserMetaData, com.paytm.android.chat.bean.UserExtendedMetaData, java.lang.Long, long, long, com.paytm.android.chat.data.db.room.db_entities.ChatUserEntity$ChatPaymentMetadata, com.paytm.android.chat.contact.a, java.lang.String, int, kotlin.g.b.g):void");
    }

    public final String getConnectionStatus() {
        return this.connectionStatus;
    }

    public final void setConnectionStatus(String str) {
        this.connectionStatus = str;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public ChatUserDataModel(ChatPayeeUser chatPayeeUser) {
        this((String) null, (String) null, (ChatUserType) null, (String) null, (String) null, (String) null, (Boolean) null, (String) null, (String) null, false, false, false, (byte[]) null, (String) null, (String) null, (String) null, (UserInfoSource) null, (UserMetaData) null, (UserExtendedMetaData) null, (Long) null, 0, 0, (ChatUserEntity.ChatPaymentMetadata) null, (a) null, (String) null, 33554431, (g) null);
        k.c(chatPayeeUser, "chatPayeeUser");
        bindChatPayeeUser(chatPayeeUser);
    }

    public final boolean isMe() {
        String str = this.sendbirdUserId;
        if (str == null) {
            return false;
        }
        if (str == null) {
            k.a();
        }
        return AppUtilKt.isMe(str);
    }

    public final void bindUserInfoApiData(UsersInfoJsonBean usersInfoJsonBean) {
        String identifier2;
        k.c(usersInfoJsonBean, "userInfoApiData");
        this.source = UserInfoSource.USER_API;
        this.sendbirdUsername = usersInfoJsonBean.getPfName();
        this.avatarUrl = usersInfoJsonBean.getImageUrl();
        this.phoneNumber = usersInfoJsonBean.getPhoneNumber();
        UserPaymentDataModel userPaymentDataModel = usersInfoJsonBean.getUserPaymentDataModel();
        if (!(userPaymentDataModel == null || (identifier2 = userPaymentDataModel.getIdentifier()) == null)) {
            this.identifier = identifier2;
        }
        UserPaymentDataModel userPaymentDataModel2 = usersInfoJsonBean.getUserPaymentDataModel();
        if (userPaymentDataModel2 != null) {
            ChatUserEntity.ChatPaymentMetadata chatPaymentMetadata2 = r2;
            ChatUserEntity.ChatPaymentMetadata chatPaymentMetadata3 = new ChatUserEntity.ChatPaymentMetadata((String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (Boolean) null, (String) null, (String) null, (String) null, 2047, (g) null);
            chatPaymentMetadata2.setName(userPaymentDataModel2.getName());
            chatPaymentMetadata2.setMobileNo(userPaymentDataModel2.getMobileNumber());
            chatPaymentMetadata2.setBankName(userPaymentDataModel2.getBankName());
            chatPaymentMetadata2.setMaskedAccNo(userPaymentDataModel2.getMaskedAccNo());
            chatPaymentMetadata2.setBankLogoUrl(userPaymentDataModel2.getBankLogoUrl());
            chatPaymentMetadata2.setAccRefId(userPaymentDataModel2.getAccRefId());
            chatPaymentMetadata2.setIfsc(userPaymentDataModel2.getIfsc());
            chatPaymentMetadata2.setVpa(userPaymentDataModel2.getVpa());
            chatPaymentMetadata2.setMid(userPaymentDataModel2.getMid());
            chatPaymentMetadata2.setVerifiedMerchant(userPaymentDataModel2.isVerifiedMerchant());
            chatPaymentMetadata2.setTxnCategory(userPaymentDataModel2.getTxnCategory());
            this.chatPaymentMetadata = chatPaymentMetadata2;
        }
    }

    public final void bindChatPayeeUser(ChatPayeeUser chatPayeeUser) {
        ChatPayeeUser chatPayeeUser2 = chatPayeeUser;
        k.c(chatPayeeUser2, "chatPayeeUser");
        this.identifier = chatPayeeUser.getIdentifier();
        this.type = chatPayeeUser.getType();
        this.chatPaymentMetadata = new ChatUserEntity.ChatPaymentMetadata((String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (Boolean) null, (String) null, (String) null, (String) null, 2047, (g) null);
        if (chatPayeeUser2 instanceof BankChatPayeeUser) {
            BankChatPayeeUser bankChatPayeeUser = (BankChatPayeeUser) chatPayeeUser2;
            String accRefId = bankChatPayeeUser.getAccRefId();
            String bankLogoUrl = bankChatPayeeUser.getBankLogoUrl();
            String bankName = bankChatPayeeUser.getBankName();
            String ifsc = bankChatPayeeUser.getIfsc();
            String maskedAccNo = bankChatPayeeUser.getMaskedAccNo();
            this.chatPaymentMetadata = new ChatUserEntity.ChatPaymentMetadata(bankChatPayeeUser.getName(), bankName, accRefId, bankChatPayeeUser.getMobileNo(), (String) null, (String) null, (String) null, (Boolean) null, bankLogoUrl, ifsc, maskedAccNo, 240, (g) null);
        } else if (chatPayeeUser2 instanceof CustomerChatPayeeUser) {
            CustomerChatPayeeUser customerChatPayeeUser = (CustomerChatPayeeUser) chatPayeeUser2;
            this.chatPaymentMetadata = new ChatUserEntity.ChatPaymentMetadata(customerChatPayeeUser.getName(), (String) null, (String) null, customerChatPayeeUser.getMobileNo(), (String) null, (String) null, (String) null, (Boolean) null, (String) null, (String) null, (String) null, 2038, (g) null);
        } else if (chatPayeeUser2 instanceof VpaChatPayeeUser) {
            VpaChatPayeeUser vpaChatPayeeUser = (VpaChatPayeeUser) chatPayeeUser2;
            Boolean isVerifiedMerchant = vpaChatPayeeUser.isVerifiedMerchant();
            this.chatPaymentMetadata = new ChatUserEntity.ChatPaymentMetadata(vpaChatPayeeUser.getName(), (String) null, (String) null, (String) null, vpaChatPayeeUser.getMid(), vpaChatPayeeUser.getTxnCategory(), vpaChatPayeeUser.getVpa(), isVerifiedMerchant, (String) null, (String) null, (String) null, 1806, (g) null);
        } else if (chatPayeeUser2 instanceof MobileNumberChatPayeeUser) {
            this.chatPaymentMetadata = new ChatUserEntity.ChatPaymentMetadata(((MobileNumberChatPayeeUser) chatPayeeUser2).getName(), (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (Boolean) null, (String) null, (String) null, (String) null, 2046, (g) null);
        } else if (chatPayeeUser2 instanceof MerchantChatPayeeUser) {
            this.chatPaymentMetadata = new ChatUserEntity.ChatPaymentMetadata((String) null, (String) null, (String) null, (String) null, chatPayeeUser.getIdentifier(), (String) null, (String) null, (Boolean) null, (String) null, (String) null, (String) null, 2031, (g) null);
        } else {
            throw new TypeNotPresentException(k.a(chatPayeeUser.getClass().getCanonicalName(), (Object) " type is not yet supported for construction"), new Throwable());
        }
    }

    public final ChatPayeeUser constructChatPayeeUser() {
        ChatUserType chatUserType = this.type;
        if (chatUserType != null) {
            int i2 = WhenMappings.$EnumSwitchMapping$0[chatUserType.ordinal()];
            String str = null;
            if (i2 != 1) {
                if (i2 != 2) {
                    if (i2 != 3) {
                        if (i2 != 4) {
                            if (i2 == 5) {
                                if (canConstructPayeeUserForType(ChatUserType.MERCHANT)) {
                                    String str2 = this.identifier;
                                    if (str2 == null) {
                                        k.a();
                                    }
                                    return new MerchantChatPayeeUser(str2);
                                }
                                throw new Exception("One or more mandatory fields is missing for construction of type " + this.type);
                            }
                        } else if (canConstructPayeeUserForType(ChatUserType.MOBILE_NUMBER)) {
                            String str3 = this.identifier;
                            if (str3 == null) {
                                k.a();
                            }
                            ChatUserEntity.ChatPaymentMetadata chatPaymentMetadata2 = this.chatPaymentMetadata;
                            if (chatPaymentMetadata2 != null) {
                                str = chatPaymentMetadata2.getName();
                            }
                            return new MobileNumberChatPayeeUser(str3, str);
                        } else {
                            throw new Exception("One or more mandatory fields is missing for construction of type " + this.type);
                        }
                    } else if (canConstructPayeeUserForType(ChatUserType.VPA)) {
                        String str4 = this.identifier;
                        if (str4 == null) {
                            k.a();
                        }
                        ChatUserEntity.ChatPaymentMetadata chatPaymentMetadata3 = this.chatPaymentMetadata;
                        Boolean isVerifiedMerchant = chatPaymentMetadata3 != null ? chatPaymentMetadata3.isVerifiedMerchant() : null;
                        ChatUserEntity.ChatPaymentMetadata chatPaymentMetadata4 = this.chatPaymentMetadata;
                        String mid = chatPaymentMetadata4 != null ? chatPaymentMetadata4.getMid() : null;
                        ChatUserEntity.ChatPaymentMetadata chatPaymentMetadata5 = this.chatPaymentMetadata;
                        String name = chatPaymentMetadata5 != null ? chatPaymentMetadata5.getName() : null;
                        ChatUserEntity.ChatPaymentMetadata chatPaymentMetadata6 = this.chatPaymentMetadata;
                        if (chatPaymentMetadata6 == null) {
                            k.a();
                        }
                        String txnCategory = chatPaymentMetadata6.getTxnCategory();
                        if (txnCategory == null) {
                            k.a();
                        }
                        ChatUserEntity.ChatPaymentMetadata chatPaymentMetadata7 = this.chatPaymentMetadata;
                        if (chatPaymentMetadata7 == null) {
                            k.a();
                        }
                        String vpa = chatPaymentMetadata7.getVpa();
                        if (vpa == null) {
                            k.a();
                        }
                        ChatUserEntity.ChatPaymentMetadata chatPaymentMetadata8 = this.chatPaymentMetadata;
                        if (chatPaymentMetadata8 != null) {
                            str = chatPaymentMetadata8.getBankName();
                        }
                        return new VpaChatPayeeUser(str4, vpa, txnCategory, name, mid, str, isVerifiedMerchant);
                    } else {
                        throw new Exception("One or more mandatory fields is missing for construction of type " + this.type);
                    }
                } else if (canConstructPayeeUserForType(ChatUserType.CUSTOMER)) {
                    String str5 = this.identifier;
                    if (str5 == null) {
                        k.a();
                    }
                    ChatUserEntity.ChatPaymentMetadata chatPaymentMetadata9 = this.chatPaymentMetadata;
                    String mobileNo = chatPaymentMetadata9 != null ? chatPaymentMetadata9.getMobileNo() : null;
                    ChatUserEntity.ChatPaymentMetadata chatPaymentMetadata10 = this.chatPaymentMetadata;
                    if (chatPaymentMetadata10 != null) {
                        str = chatPaymentMetadata10.getName();
                    }
                    return new CustomerChatPayeeUser(str5, str, mobileNo);
                } else {
                    throw new Exception("One or more mandatory fields is missing for construction of type " + this.type);
                }
            } else if (canConstructPayeeUserForType(ChatUserType.BANK)) {
                String str6 = this.identifier;
                if (str6 == null) {
                    k.a();
                }
                ChatUserEntity.ChatPaymentMetadata chatPaymentMetadata11 = this.chatPaymentMetadata;
                if (chatPaymentMetadata11 == null) {
                    k.a();
                }
                String accRefId = chatPaymentMetadata11.getAccRefId();
                if (accRefId == null) {
                    k.a();
                }
                ChatUserEntity.ChatPaymentMetadata chatPaymentMetadata12 = this.chatPaymentMetadata;
                String bankLogoUrl = chatPaymentMetadata12 != null ? chatPaymentMetadata12.getBankLogoUrl() : null;
                ChatUserEntity.ChatPaymentMetadata chatPaymentMetadata13 = this.chatPaymentMetadata;
                if (chatPaymentMetadata13 == null) {
                    k.a();
                }
                String bankName = chatPaymentMetadata13.getBankName();
                if (bankName == null) {
                    k.a();
                }
                ChatUserEntity.ChatPaymentMetadata chatPaymentMetadata14 = this.chatPaymentMetadata;
                String ifsc = chatPaymentMetadata14 != null ? chatPaymentMetadata14.getIfsc() : null;
                ChatUserEntity.ChatPaymentMetadata chatPaymentMetadata15 = this.chatPaymentMetadata;
                if (chatPaymentMetadata15 == null) {
                    k.a();
                }
                String maskedAccNo = chatPaymentMetadata15.getMaskedAccNo();
                if (maskedAccNo == null) {
                    k.a();
                }
                ChatUserEntity.ChatPaymentMetadata chatPaymentMetadata16 = this.chatPaymentMetadata;
                String mobileNo2 = chatPaymentMetadata16 != null ? chatPaymentMetadata16.getMobileNo() : null;
                ChatUserEntity.ChatPaymentMetadata chatPaymentMetadata17 = this.chatPaymentMetadata;
                if (chatPaymentMetadata17 != null) {
                    str = chatPaymentMetadata17.getName();
                }
                return new BankChatPayeeUser(str6, bankName, accRefId, maskedAccNo, str, mobileNo2, bankLogoUrl, ifsc);
            } else {
                throw new Exception("One or more mandatory fields is missing for construction of type " + this.type);
            }
        }
        throw new Exception("Payee type {" + this.type + "} is not supported");
    }

    private final boolean canConstructPayeeUserForType(ChatUserType chatUserType) {
        ChatUserEntity.ChatPaymentMetadata chatPaymentMetadata2;
        ChatUserEntity.ChatPaymentMetadata chatPaymentMetadata3;
        int i2 = WhenMappings.$EnumSwitchMapping$1[chatUserType.ordinal()];
        String str = null;
        if (i2 == 1) {
            if (!(this.identifier == null || (chatPaymentMetadata2 = this.chatPaymentMetadata) == null)) {
                if ((chatPaymentMetadata2 != null ? chatPaymentMetadata2.getBankName() : null) != null) {
                    ChatUserEntity.ChatPaymentMetadata chatPaymentMetadata4 = this.chatPaymentMetadata;
                    if ((chatPaymentMetadata4 != null ? chatPaymentMetadata4.getAccRefId() : null) != null) {
                        ChatUserEntity.ChatPaymentMetadata chatPaymentMetadata5 = this.chatPaymentMetadata;
                        if (chatPaymentMetadata5 != null) {
                            str = chatPaymentMetadata5.getMaskedAccNo();
                        }
                        if (str != null) {
                            return true;
                        }
                    }
                }
            }
            return false;
        } else if (i2 != 2) {
            return i2 != 3 ? i2 != 4 ? i2 == 5 && this.identifier != null : this.identifier != null : this.identifier != null;
        } else {
            if (!(this.identifier == null || (chatPaymentMetadata3 = this.chatPaymentMetadata) == null)) {
                if ((chatPaymentMetadata3 != null ? chatPaymentMetadata3.getVpa() : null) != null) {
                    ChatUserEntity.ChatPaymentMetadata chatPaymentMetadata6 = this.chatPaymentMetadata;
                    if (chatPaymentMetadata6 != null) {
                        str = chatPaymentMetadata6.getTxnCategory();
                    }
                    if (str != null) {
                        return true;
                    }
                }
            }
            return false;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000d, code lost:
        r0 = com.paytm.android.chat.data.models.users.ChatUserDataModel.WhenMappings.$EnumSwitchMapping$2[r0.ordinal()];
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean isOutDated(com.paytm.android.chat.data.db.room.db_entities.ChatUserEntity r5) {
        /*
            r4 = this;
            java.lang.String r0 = "other"
            kotlin.g.b.k.c(r5, r0)
            com.paytm.android.chat.data.db.room.db_entities.UserInfoSource r0 = r5.getSource()
            r1 = 1
            if (r0 != 0) goto L_0x000d
            goto L_0x003f
        L_0x000d:
            int[] r2 = com.paytm.android.chat.data.models.users.ChatUserDataModel.WhenMappings.$EnumSwitchMapping$2
            int r0 = r0.ordinal()
            r0 = r2[r0]
            if (r0 == r1) goto L_0x0031
            r2 = 2
            if (r0 == r2) goto L_0x001e
            r2 = 3
            if (r0 == r2) goto L_0x001e
            goto L_0x003f
        L_0x001e:
            java.lang.String r0 = r5.getPhoneHash()
            if (r0 == 0) goto L_0x003f
            java.lang.String r0 = r4.phoneHash
            java.lang.String r2 = r5.getPhoneHash()
            boolean r0 = com.paytm.android.chat.utils.AppUtilKt.areStringsEqual(r0, r2)
            if (r0 != 0) goto L_0x003f
            goto L_0x003d
        L_0x0031:
            java.lang.String r0 = r4.phoneNumber
            java.lang.String r2 = r5.getPhoneNumber()
            boolean r0 = com.paytm.android.chat.utils.AppUtilKt.areStringsEqual(r0, r2)
            if (r0 != 0) goto L_0x003f
        L_0x003d:
            r0 = 1
            goto L_0x0040
        L_0x003f:
            r0 = 0
        L_0x0040:
            java.lang.String r2 = r4.sendbirdUsername
            java.lang.String r3 = r5.getSendbirdUserName()
            boolean r2 = com.paytm.android.chat.utils.AppUtilKt.areStringsEqual(r2, r3)
            if (r2 != 0) goto L_0x0053
            java.lang.String r2 = r5.getSendbirdUserName()
            if (r2 == 0) goto L_0x0053
            r0 = 1
        L_0x0053:
            java.lang.String r2 = r4.avatarUrl
            java.lang.String r3 = r5.getAvatarUrl()
            boolean r2 = com.paytm.android.chat.utils.AppUtilKt.areStringsEqual(r2, r3)
            if (r2 != 0) goto L_0x0066
            java.lang.String r2 = r5.getAvatarUrl()
            if (r2 == 0) goto L_0x0066
            r0 = 1
        L_0x0066:
            boolean r2 = r4.isBlockedByMe
            boolean r5 = r5.isBlockedByMe()
            if (r2 == r5) goto L_0x006f
            r0 = 1
        L_0x006f:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.paytm.android.chat.data.models.users.ChatUserDataModel.isOutDated(com.paytm.android.chat.data.db.room.db_entities.ChatUserEntity):boolean");
    }
}
