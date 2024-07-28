package com.paytm.android.chat.data.db.room.db_entities;

import com.alipay.mobile.nebula.util.tar.TarConstants;
import com.paytm.android.chat.bean.UserExtendedMetaData;
import com.paytm.android.chat.bean.UserMetaData;
import com.paytm.android.chat.contact.a;
import kotlin.g.b.g;
import kotlin.g.b.k;
import kotlin.m.p;
import net.one97.paytm.common.entity.chat.moneytransfer.ChatUserType;
import net.one97.paytm.upi.util.UpiConstants;

public final class ChatUserEntity {
    private a addressBookContact;
    private String avatarUrl;
    private ChatPaymentMetadata chatPaymentMetadata;
    private String connectionStatus;
    private String contactId;
    private long createdAt = -1;
    private String friendDiscoveryKey;
    private String friendName;
    private String identifier = "NOT_SET";
    private Boolean isActive;
    private boolean isBlockedByMe;
    private boolean isBlockingMe;
    private boolean isMuted;
    private boolean isUserFake;
    private String lastSeenAt;
    private long lastUpdatedUserExtendedMetaData = -1;
    private String paymentIdentifier;
    private String paymentIdentifierType;
    private String phoneHash;
    private String phoneNumber;
    private long primaryKey;
    private byte[] rawMember;
    private String sendbirdUserId = "NOT_SET";
    private String sendbirdUserName;
    private UserInfoSource source;
    private String type;
    private long updatedAt = -1;
    private UserExtendedMetaData userExtendedMetaData;
    private UserMetaData userMetadata;

    public final long getPrimaryKey() {
        return this.primaryKey;
    }

    public final void setPrimaryKey(long j) {
        this.primaryKey = j;
    }

    public final String getIdentifier() {
        return this.identifier;
    }

    public final void setIdentifier(String str) {
        k.c(str, "<set-?>");
        this.identifier = str;
    }

    public final String getSendbirdUserId() {
        return this.sendbirdUserId;
    }

    public final void setSendbirdUserId(String str) {
        k.c(str, "<set-?>");
        this.sendbirdUserId = str;
    }

    public final String getType() {
        return this.type;
    }

    public final void setType(String str) {
        this.type = str;
    }

    public final String getAvatarUrl() {
        return this.avatarUrl;
    }

    public final void setAvatarUrl(String str) {
        this.avatarUrl = str;
    }

    public final boolean isUserFake() {
        return this.isUserFake;
    }

    public final void setUserFake(boolean z) {
        this.isUserFake = z;
    }

    public final String getSendbirdUserName() {
        return this.sendbirdUserName;
    }

    public final void setSendbirdUserName(String str) {
        this.sendbirdUserName = str;
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

    public final String getFriendDiscoveryKey() {
        return this.friendDiscoveryKey;
    }

    public final void setFriendDiscoveryKey(String str) {
        this.friendDiscoveryKey = str;
    }

    public final boolean isBlockingMe() {
        return this.isBlockingMe;
    }

    public final void setBlockingMe(boolean z) {
        this.isBlockingMe = z;
    }

    public final boolean isBlockedByMe() {
        return this.isBlockedByMe;
    }

    public final void setBlockedByMe(boolean z) {
        this.isBlockedByMe = z;
    }

    public final String getConnectionStatus() {
        return this.connectionStatus;
    }

    public final void setConnectionStatus(String str) {
        this.connectionStatus = str;
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

    public final UserMetaData getUserMetadata() {
        return this.userMetadata;
    }

    public final void setUserMetadata(UserMetaData userMetaData) {
        this.userMetadata = userMetaData;
    }

    public final UserExtendedMetaData getUserExtendedMetaData() {
        return this.userExtendedMetaData;
    }

    public final void setUserExtendedMetaData(UserExtendedMetaData userExtendedMetaData2) {
        this.userExtendedMetaData = userExtendedMetaData2;
    }

    public final long getLastUpdatedUserExtendedMetaData() {
        return this.lastUpdatedUserExtendedMetaData;
    }

    public final void setLastUpdatedUserExtendedMetaData(long j) {
        this.lastUpdatedUserExtendedMetaData = j;
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

    public final String getPaymentIdentifier() {
        return this.paymentIdentifier;
    }

    public final void setPaymentIdentifier(String str) {
        this.paymentIdentifier = str;
    }

    public final String getPaymentIdentifierType() {
        return this.paymentIdentifierType;
    }

    public final void setPaymentIdentifierType(String str) {
        this.paymentIdentifierType = str;
    }

    public final a getAddressBookContact() {
        return this.addressBookContact;
    }

    public final void setAddressBookContact(a aVar) {
        this.addressBookContact = aVar;
    }

    public final ChatPaymentMetadata getChatPaymentMetadata() {
        return this.chatPaymentMetadata;
    }

    public final void setChatPaymentMetadata(ChatPaymentMetadata chatPaymentMetadata2) {
        this.chatPaymentMetadata = chatPaymentMetadata2;
    }

    public static final class ChatPaymentMetadata {
        private String accRefId;
        private String bankLogoUrl;
        private String bankName;
        private String ifsc;
        private Boolean isVerifiedMerchant;
        private String maskedAccNo;
        private String mid;
        private String mobileNo;
        private String name;
        private String txnCategory;
        private String vpa;

        public ChatPaymentMetadata() {
            this((String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (Boolean) null, (String) null, (String) null, (String) null, 2047, (g) null);
        }

        public static /* synthetic */ ChatPaymentMetadata copy$default(ChatPaymentMetadata chatPaymentMetadata, String str, String str2, String str3, String str4, String str5, String str6, String str7, Boolean bool, String str8, String str9, String str10, int i2, Object obj) {
            ChatPaymentMetadata chatPaymentMetadata2 = chatPaymentMetadata;
            int i3 = i2;
            return chatPaymentMetadata.copy((i3 & 1) != 0 ? chatPaymentMetadata2.name : str, (i3 & 2) != 0 ? chatPaymentMetadata2.bankName : str2, (i3 & 4) != 0 ? chatPaymentMetadata2.accRefId : str3, (i3 & 8) != 0 ? chatPaymentMetadata2.mobileNo : str4, (i3 & 16) != 0 ? chatPaymentMetadata2.mid : str5, (i3 & 32) != 0 ? chatPaymentMetadata2.txnCategory : str6, (i3 & 64) != 0 ? chatPaymentMetadata2.vpa : str7, (i3 & 128) != 0 ? chatPaymentMetadata2.isVerifiedMerchant : bool, (i3 & UpiConstants.REQUEST_OPEN_APP_PERMISSION_READ_SMS) != 0 ? chatPaymentMetadata2.bankLogoUrl : str8, (i3 & 512) != 0 ? chatPaymentMetadata2.ifsc : str9, (i3 & TarConstants.EOF_BLOCK) != 0 ? chatPaymentMetadata2.maskedAccNo : str10);
        }

        public final String component1() {
            return this.name;
        }

        public final String component10() {
            return this.ifsc;
        }

        public final String component11() {
            return this.maskedAccNo;
        }

        public final String component2() {
            return this.bankName;
        }

        public final String component3() {
            return this.accRefId;
        }

        public final String component4() {
            return this.mobileNo;
        }

        public final String component5() {
            return this.mid;
        }

        public final String component6() {
            return this.txnCategory;
        }

        public final String component7() {
            return this.vpa;
        }

        public final Boolean component8() {
            return this.isVerifiedMerchant;
        }

        public final String component9() {
            return this.bankLogoUrl;
        }

        public final ChatPaymentMetadata copy(String str, String str2, String str3, String str4, String str5, String str6, String str7, Boolean bool, String str8, String str9, String str10) {
            return new ChatPaymentMetadata(str, str2, str3, str4, str5, str6, str7, bool, str8, str9, str10);
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ChatPaymentMetadata)) {
                return false;
            }
            ChatPaymentMetadata chatPaymentMetadata = (ChatPaymentMetadata) obj;
            return k.a((Object) this.name, (Object) chatPaymentMetadata.name) && k.a((Object) this.bankName, (Object) chatPaymentMetadata.bankName) && k.a((Object) this.accRefId, (Object) chatPaymentMetadata.accRefId) && k.a((Object) this.mobileNo, (Object) chatPaymentMetadata.mobileNo) && k.a((Object) this.mid, (Object) chatPaymentMetadata.mid) && k.a((Object) this.txnCategory, (Object) chatPaymentMetadata.txnCategory) && k.a((Object) this.vpa, (Object) chatPaymentMetadata.vpa) && k.a((Object) this.isVerifiedMerchant, (Object) chatPaymentMetadata.isVerifiedMerchant) && k.a((Object) this.bankLogoUrl, (Object) chatPaymentMetadata.bankLogoUrl) && k.a((Object) this.ifsc, (Object) chatPaymentMetadata.ifsc) && k.a((Object) this.maskedAccNo, (Object) chatPaymentMetadata.maskedAccNo);
        }

        public final int hashCode() {
            String str = this.name;
            int i2 = 0;
            int hashCode = (str != null ? str.hashCode() : 0) * 31;
            String str2 = this.bankName;
            int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
            String str3 = this.accRefId;
            int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
            String str4 = this.mobileNo;
            int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
            String str5 = this.mid;
            int hashCode5 = (hashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31;
            String str6 = this.txnCategory;
            int hashCode6 = (hashCode5 + (str6 != null ? str6.hashCode() : 0)) * 31;
            String str7 = this.vpa;
            int hashCode7 = (hashCode6 + (str7 != null ? str7.hashCode() : 0)) * 31;
            Boolean bool = this.isVerifiedMerchant;
            int hashCode8 = (hashCode7 + (bool != null ? bool.hashCode() : 0)) * 31;
            String str8 = this.bankLogoUrl;
            int hashCode9 = (hashCode8 + (str8 != null ? str8.hashCode() : 0)) * 31;
            String str9 = this.ifsc;
            int hashCode10 = (hashCode9 + (str9 != null ? str9.hashCode() : 0)) * 31;
            String str10 = this.maskedAccNo;
            if (str10 != null) {
                i2 = str10.hashCode();
            }
            return hashCode10 + i2;
        }

        public final String toString() {
            return "ChatPaymentMetadata(name=" + this.name + ", bankName=" + this.bankName + ", accRefId=" + this.accRefId + ", mobileNo=" + this.mobileNo + ", mid=" + this.mid + ", txnCategory=" + this.txnCategory + ", vpa=" + this.vpa + ", isVerifiedMerchant=" + this.isVerifiedMerchant + ", bankLogoUrl=" + this.bankLogoUrl + ", ifsc=" + this.ifsc + ", maskedAccNo=" + this.maskedAccNo + ")";
        }

        public ChatPaymentMetadata(String str, String str2, String str3, String str4, String str5, String str6, String str7, Boolean bool, String str8, String str9, String str10) {
            this.name = str;
            this.bankName = str2;
            this.accRefId = str3;
            this.mobileNo = str4;
            this.mid = str5;
            this.txnCategory = str6;
            this.vpa = str7;
            this.isVerifiedMerchant = bool;
            this.bankLogoUrl = str8;
            this.ifsc = str9;
            this.maskedAccNo = str10;
        }

        public final String getName() {
            return this.name;
        }

        public final void setName(String str) {
            this.name = str;
        }

        public final String getBankName() {
            return this.bankName;
        }

        public final void setBankName(String str) {
            this.bankName = str;
        }

        public final String getAccRefId() {
            return this.accRefId;
        }

        public final void setAccRefId(String str) {
            this.accRefId = str;
        }

        public final String getMobileNo() {
            return this.mobileNo;
        }

        public final void setMobileNo(String str) {
            this.mobileNo = str;
        }

        public final String getMid() {
            return this.mid;
        }

        public final void setMid(String str) {
            this.mid = str;
        }

        public final String getTxnCategory() {
            return this.txnCategory;
        }

        public final void setTxnCategory(String str) {
            this.txnCategory = str;
        }

        public final String getVpa() {
            return this.vpa;
        }

        public final void setVpa(String str) {
            this.vpa = str;
        }

        public final Boolean isVerifiedMerchant() {
            return this.isVerifiedMerchant;
        }

        public final void setVerifiedMerchant(Boolean bool) {
            this.isVerifiedMerchant = bool;
        }

        public final String getBankLogoUrl() {
            return this.bankLogoUrl;
        }

        public final void setBankLogoUrl(String str) {
            this.bankLogoUrl = str;
        }

        public final String getIfsc() {
            return this.ifsc;
        }

        public final void setIfsc(String str) {
            this.ifsc = str;
        }

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public /* synthetic */ ChatPaymentMetadata(java.lang.String r13, java.lang.String r14, java.lang.String r15, java.lang.String r16, java.lang.String r17, java.lang.String r18, java.lang.String r19, java.lang.Boolean r20, java.lang.String r21, java.lang.String r22, java.lang.String r23, int r24, kotlin.g.b.g r25) {
            /*
                r12 = this;
                r0 = r24
                r1 = r0 & 1
                r2 = 0
                if (r1 == 0) goto L_0x0009
                r1 = r2
                goto L_0x000a
            L_0x0009:
                r1 = r13
            L_0x000a:
                r3 = r0 & 2
                if (r3 == 0) goto L_0x0010
                r3 = r2
                goto L_0x0011
            L_0x0010:
                r3 = r14
            L_0x0011:
                r4 = r0 & 4
                if (r4 == 0) goto L_0x0017
                r4 = r2
                goto L_0x0018
            L_0x0017:
                r4 = r15
            L_0x0018:
                r5 = r0 & 8
                if (r5 == 0) goto L_0x001e
                r5 = r2
                goto L_0x0020
            L_0x001e:
                r5 = r16
            L_0x0020:
                r6 = r0 & 16
                if (r6 == 0) goto L_0x0026
                r6 = r2
                goto L_0x0028
            L_0x0026:
                r6 = r17
            L_0x0028:
                r7 = r0 & 32
                if (r7 == 0) goto L_0x002e
                r7 = r2
                goto L_0x0030
            L_0x002e:
                r7 = r18
            L_0x0030:
                r8 = r0 & 64
                if (r8 == 0) goto L_0x0036
                r8 = r2
                goto L_0x0038
            L_0x0036:
                r8 = r19
            L_0x0038:
                r9 = r0 & 128(0x80, float:1.794E-43)
                if (r9 == 0) goto L_0x003e
                r9 = r2
                goto L_0x0040
            L_0x003e:
                r9 = r20
            L_0x0040:
                r10 = r0 & 256(0x100, float:3.59E-43)
                if (r10 == 0) goto L_0x0046
                r10 = r2
                goto L_0x0048
            L_0x0046:
                r10 = r21
            L_0x0048:
                r11 = r0 & 512(0x200, float:7.175E-43)
                if (r11 == 0) goto L_0x004e
                r11 = r2
                goto L_0x0050
            L_0x004e:
                r11 = r22
            L_0x0050:
                r0 = r0 & 1024(0x400, float:1.435E-42)
                if (r0 == 0) goto L_0x0055
                goto L_0x0057
            L_0x0055:
                r2 = r23
            L_0x0057:
                r13 = r12
                r14 = r1
                r15 = r3
                r16 = r4
                r17 = r5
                r18 = r6
                r19 = r7
                r20 = r8
                r21 = r9
                r22 = r10
                r23 = r11
                r24 = r2
                r13.<init>(r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.paytm.android.chat.data.db.room.db_entities.ChatUserEntity.ChatPaymentMetadata.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.Boolean, java.lang.String, java.lang.String, java.lang.String, int, kotlin.g.b.g):void");
        }

        public final String getMaskedAccNo() {
            return this.maskedAccNo;
        }

        public final void setMaskedAccNo(String str) {
            this.maskedAccNo = str;
        }
    }

    public final ChatUserType getChatUserType() {
        for (ChatUserType chatUserType : ChatUserType.values()) {
            if (p.a(chatUserType.toString(), this.type, true)) {
                return chatUserType;
            }
        }
        return null;
    }
}
