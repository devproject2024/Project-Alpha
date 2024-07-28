package net.one97.paytm.contacts.entities.db_entities;

import com.alipay.mobile.nebula.util.tar.TarConstants;
import kotlin.g.b.g;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.nativesdk.emiSubvention.utils.EmiUtil;
import net.one97.paytm.upi.util.UpiConstants;

public final class PayeeMetaInfo implements IJRDataModel {
    private long id;
    private String imageUrl;
    private Boolean isDeleted;
    private boolean isPrimary;
    private String name;
    private String newContactVisiblity;
    private String newExpiryTime;
    private String nickName;
    private String payeeInfoId;
    private String payeeMetaId;
    private String phoneNumber;
    private String status;
    private int type;

    public static /* synthetic */ PayeeMetaInfo copy$default(PayeeMetaInfo payeeMetaInfo, long j, String str, String str2, String str3, String str4, String str5, String str6, int i2, String str7, boolean z, Boolean bool, String str8, String str9, int i3, Object obj) {
        PayeeMetaInfo payeeMetaInfo2 = payeeMetaInfo;
        int i4 = i3;
        return payeeMetaInfo.copy((i4 & 1) != 0 ? payeeMetaInfo2.id : j, (i4 & 2) != 0 ? payeeMetaInfo2.payeeInfoId : str, (i4 & 4) != 0 ? payeeMetaInfo2.payeeMetaId : str2, (i4 & 8) != 0 ? payeeMetaInfo2.phoneNumber : str3, (i4 & 16) != 0 ? payeeMetaInfo2.name : str4, (i4 & 32) != 0 ? payeeMetaInfo2.nickName : str5, (i4 & 64) != 0 ? payeeMetaInfo2.imageUrl : str6, (i4 & 128) != 0 ? payeeMetaInfo2.type : i2, (i4 & UpiConstants.REQUEST_OPEN_APP_PERMISSION_READ_SMS) != 0 ? payeeMetaInfo2.status : str7, (i4 & 512) != 0 ? payeeMetaInfo2.isPrimary : z, (i4 & TarConstants.EOF_BLOCK) != 0 ? payeeMetaInfo2.isDeleted : bool, (i4 & EmiUtil.EMI_PLAN_REQUEST_CODE) != 0 ? payeeMetaInfo2.newContactVisiblity : str8, (i4 & 4096) != 0 ? payeeMetaInfo2.newExpiryTime : str9);
    }

    public final long component1() {
        return this.id;
    }

    public final boolean component10() {
        return this.isPrimary;
    }

    public final Boolean component11() {
        return this.isDeleted;
    }

    public final String component12() {
        return this.newContactVisiblity;
    }

    public final String component13() {
        return this.newExpiryTime;
    }

    public final String component2() {
        return this.payeeInfoId;
    }

    public final String component3() {
        return this.payeeMetaId;
    }

    public final String component4() {
        return this.phoneNumber;
    }

    public final String component5() {
        return this.name;
    }

    public final String component6() {
        return this.nickName;
    }

    public final String component7() {
        return this.imageUrl;
    }

    public final int component8() {
        return this.type;
    }

    public final String component9() {
        return this.status;
    }

    public final PayeeMetaInfo copy(long j, String str, String str2, String str3, String str4, String str5, String str6, int i2, String str7, boolean z, Boolean bool, String str8, String str9) {
        String str10 = str;
        k.c(str10, "payeeInfoId");
        return new PayeeMetaInfo(j, str10, str2, str3, str4, str5, str6, i2, str7, z, bool, str8, str9);
    }

    public final boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof PayeeMetaInfo) {
                PayeeMetaInfo payeeMetaInfo = (PayeeMetaInfo) obj;
                if ((this.id == payeeMetaInfo.id) && k.a((Object) this.payeeInfoId, (Object) payeeMetaInfo.payeeInfoId) && k.a((Object) this.payeeMetaId, (Object) payeeMetaInfo.payeeMetaId) && k.a((Object) this.phoneNumber, (Object) payeeMetaInfo.phoneNumber) && k.a((Object) this.name, (Object) payeeMetaInfo.name) && k.a((Object) this.nickName, (Object) payeeMetaInfo.nickName) && k.a((Object) this.imageUrl, (Object) payeeMetaInfo.imageUrl)) {
                    if ((this.type == payeeMetaInfo.type) && k.a((Object) this.status, (Object) payeeMetaInfo.status)) {
                        if (!(this.isPrimary == payeeMetaInfo.isPrimary) || !k.a((Object) this.isDeleted, (Object) payeeMetaInfo.isDeleted) || !k.a((Object) this.newContactVisiblity, (Object) payeeMetaInfo.newContactVisiblity) || !k.a((Object) this.newExpiryTime, (Object) payeeMetaInfo.newExpiryTime)) {
                            return false;
                        }
                    }
                }
            }
            return false;
        }
        return true;
    }

    public final int hashCode() {
        long j = this.id;
        int i2 = ((int) (j ^ (j >>> 32))) * 31;
        String str = this.payeeInfoId;
        int i3 = 0;
        int hashCode = (i2 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.payeeMetaId;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.phoneNumber;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.name;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.nickName;
        int hashCode5 = (hashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String str6 = this.imageUrl;
        int hashCode6 = (((hashCode5 + (str6 != null ? str6.hashCode() : 0)) * 31) + this.type) * 31;
        String str7 = this.status;
        int hashCode7 = (hashCode6 + (str7 != null ? str7.hashCode() : 0)) * 31;
        boolean z = this.isPrimary;
        if (z) {
            z = true;
        }
        int i4 = (hashCode7 + (z ? 1 : 0)) * 31;
        Boolean bool = this.isDeleted;
        int hashCode8 = (i4 + (bool != null ? bool.hashCode() : 0)) * 31;
        String str8 = this.newContactVisiblity;
        int hashCode9 = (hashCode8 + (str8 != null ? str8.hashCode() : 0)) * 31;
        String str9 = this.newExpiryTime;
        if (str9 != null) {
            i3 = str9.hashCode();
        }
        return hashCode9 + i3;
    }

    public final String toString() {
        return "PayeeMetaInfo(id=" + this.id + ", payeeInfoId=" + this.payeeInfoId + ", payeeMetaId=" + this.payeeMetaId + ", phoneNumber=" + this.phoneNumber + ", name=" + this.name + ", nickName=" + this.nickName + ", imageUrl=" + this.imageUrl + ", type=" + this.type + ", status=" + this.status + ", isPrimary=" + this.isPrimary + ", isDeleted=" + this.isDeleted + ", newContactVisiblity=" + this.newContactVisiblity + ", newExpiryTime=" + this.newExpiryTime + ")";
    }

    public PayeeMetaInfo(long j, String str, String str2, String str3, String str4, String str5, String str6, int i2, String str7, boolean z, Boolean bool, String str8, String str9) {
        k.c(str, "payeeInfoId");
        this.id = j;
        this.payeeInfoId = str;
        this.payeeMetaId = str2;
        this.phoneNumber = str3;
        this.name = str4;
        this.nickName = str5;
        this.imageUrl = str6;
        this.type = i2;
        this.status = str7;
        this.isPrimary = z;
        this.isDeleted = bool;
        this.newContactVisiblity = str8;
        this.newExpiryTime = str9;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ PayeeMetaInfo(long j, String str, String str2, String str3, String str4, String str5, String str6, int i2, String str7, boolean z, Boolean bool, String str8, String str9, int i3, g gVar) {
        this((i3 & 1) != 0 ? 0 : j, str, str2, str3, str4, str5, str6, i2, str7, z, bool, str8, str9);
    }

    public final long getId() {
        return this.id;
    }

    public final void setId(long j) {
        this.id = j;
    }

    public final String getPayeeInfoId() {
        return this.payeeInfoId;
    }

    public final void setPayeeInfoId(String str) {
        k.c(str, "<set-?>");
        this.payeeInfoId = str;
    }

    public final String getPayeeMetaId() {
        return this.payeeMetaId;
    }

    public final void setPayeeMetaId(String str) {
        this.payeeMetaId = str;
    }

    public final String getPhoneNumber() {
        return this.phoneNumber;
    }

    public final void setPhoneNumber(String str) {
        this.phoneNumber = str;
    }

    public final String getName() {
        return this.name;
    }

    public final void setName(String str) {
        this.name = str;
    }

    public final String getNickName() {
        return this.nickName;
    }

    public final void setNickName(String str) {
        this.nickName = str;
    }

    public final String getImageUrl() {
        return this.imageUrl;
    }

    public final void setImageUrl(String str) {
        this.imageUrl = str;
    }

    public final int getType() {
        return this.type;
    }

    public final void setType(int i2) {
        this.type = i2;
    }

    public final String getStatus() {
        return this.status;
    }

    public final void setStatus(String str) {
        this.status = str;
    }

    public final boolean isPrimary() {
        return this.isPrimary;
    }

    public final void setPrimary(boolean z) {
        this.isPrimary = z;
    }

    public final Boolean isDeleted() {
        return this.isDeleted;
    }

    public final void setDeleted(Boolean bool) {
        this.isDeleted = bool;
    }

    public final String getNewContactVisiblity() {
        return this.newContactVisiblity;
    }

    public final void setNewContactVisiblity(String str) {
        this.newContactVisiblity = str;
    }

    public final String getNewExpiryTime() {
        return this.newExpiryTime;
    }

    public final void setNewExpiryTime(String str) {
        this.newExpiryTime = str;
    }
}
