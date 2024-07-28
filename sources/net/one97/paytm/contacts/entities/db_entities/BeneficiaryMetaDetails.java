package net.one97.paytm.contacts.entities.db_entities;

import com.alipay.mobile.nebula.util.tar.TarConstants;
import kotlin.g.b.g;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.nativesdk.emiSubvention.utils.EmiUtil;
import net.one97.paytm.phoenix.provider.download.FileDownloadDefaultParamsKt;
import net.one97.paytm.upi.util.UpiConstants;

public final class BeneficiaryMetaDetails implements IJRDataModel {
    private String accountNo;
    private String bankName;
    private String contactStatus;
    private Integer contact_type;
    private String custId;
    private long id;
    private String ifsc;
    private String imageUrl;
    private String instrumentStatus;
    private String instrumentType;
    private String instrument_meta_status;
    private String mobileNo;
    private String name;
    private String nickname;
    private String payeeInfoId;
    private String paymentInstrumentId;
    private String score;
    private String vpa;

    public static /* synthetic */ BeneficiaryMetaDetails copy$default(BeneficiaryMetaDetails beneficiaryMetaDetails, long j, String str, String str2, String str3, String str4, Integer num, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16, int i2, Object obj) {
        BeneficiaryMetaDetails beneficiaryMetaDetails2 = beneficiaryMetaDetails;
        int i3 = i2;
        return beneficiaryMetaDetails.copy((i3 & 1) != 0 ? beneficiaryMetaDetails2.id : j, (i3 & 2) != 0 ? beneficiaryMetaDetails2.payeeInfoId : str, (i3 & 4) != 0 ? beneficiaryMetaDetails2.name : str2, (i3 & 8) != 0 ? beneficiaryMetaDetails2.nickname : str3, (i3 & 16) != 0 ? beneficiaryMetaDetails2.contactStatus : str4, (i3 & 32) != 0 ? beneficiaryMetaDetails2.contact_type : num, (i3 & 64) != 0 ? beneficiaryMetaDetails2.paymentInstrumentId : str5, (i3 & 128) != 0 ? beneficiaryMetaDetails2.instrumentType : str6, (i3 & UpiConstants.REQUEST_OPEN_APP_PERMISSION_READ_SMS) != 0 ? beneficiaryMetaDetails2.score : str7, (i3 & 512) != 0 ? beneficiaryMetaDetails2.instrumentStatus : str8, (i3 & TarConstants.EOF_BLOCK) != 0 ? beneficiaryMetaDetails2.imageUrl : str9, (i3 & EmiUtil.EMI_PLAN_REQUEST_CODE) != 0 ? beneficiaryMetaDetails2.mobileNo : str10, (i3 & 4096) != 0 ? beneficiaryMetaDetails2.custId : str11, (i3 & FileDownloadDefaultParamsKt.DOWNLOAD_BUFFER_SIZE) != 0 ? beneficiaryMetaDetails2.bankName : str12, (i3 & 16384) != 0 ? beneficiaryMetaDetails2.instrument_meta_status : str13, (i3 & 32768) != 0 ? beneficiaryMetaDetails2.accountNo : str14, (i3 & 65536) != 0 ? beneficiaryMetaDetails2.ifsc : str15, (i3 & 131072) != 0 ? beneficiaryMetaDetails2.vpa : str16);
    }

    public final long component1() {
        return this.id;
    }

    public final String component10() {
        return this.instrumentStatus;
    }

    public final String component11() {
        return this.imageUrl;
    }

    public final String component12() {
        return this.mobileNo;
    }

    public final String component13() {
        return this.custId;
    }

    public final String component14() {
        return this.bankName;
    }

    public final String component15() {
        return this.instrument_meta_status;
    }

    public final String component16() {
        return this.accountNo;
    }

    public final String component17() {
        return this.ifsc;
    }

    public final String component18() {
        return this.vpa;
    }

    public final String component2() {
        return this.payeeInfoId;
    }

    public final String component3() {
        return this.name;
    }

    public final String component4() {
        return this.nickname;
    }

    public final String component5() {
        return this.contactStatus;
    }

    public final Integer component6() {
        return this.contact_type;
    }

    public final String component7() {
        return this.paymentInstrumentId;
    }

    public final String component8() {
        return this.instrumentType;
    }

    public final String component9() {
        return this.score;
    }

    public final BeneficiaryMetaDetails copy(long j, String str, String str2, String str3, String str4, Integer num, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16) {
        long j2 = j;
        k.c(str, "payeeInfoId");
        return new BeneficiaryMetaDetails(j, str, str2, str3, str4, num, str5, str6, str7, str8, str9, str10, str11, str12, str13, str14, str15, str16);
    }

    public final boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof BeneficiaryMetaDetails) {
                BeneficiaryMetaDetails beneficiaryMetaDetails = (BeneficiaryMetaDetails) obj;
                if (!(this.id == beneficiaryMetaDetails.id) || !k.a((Object) this.payeeInfoId, (Object) beneficiaryMetaDetails.payeeInfoId) || !k.a((Object) this.name, (Object) beneficiaryMetaDetails.name) || !k.a((Object) this.nickname, (Object) beneficiaryMetaDetails.nickname) || !k.a((Object) this.contactStatus, (Object) beneficiaryMetaDetails.contactStatus) || !k.a((Object) this.contact_type, (Object) beneficiaryMetaDetails.contact_type) || !k.a((Object) this.paymentInstrumentId, (Object) beneficiaryMetaDetails.paymentInstrumentId) || !k.a((Object) this.instrumentType, (Object) beneficiaryMetaDetails.instrumentType) || !k.a((Object) this.score, (Object) beneficiaryMetaDetails.score) || !k.a((Object) this.instrumentStatus, (Object) beneficiaryMetaDetails.instrumentStatus) || !k.a((Object) this.imageUrl, (Object) beneficiaryMetaDetails.imageUrl) || !k.a((Object) this.mobileNo, (Object) beneficiaryMetaDetails.mobileNo) || !k.a((Object) this.custId, (Object) beneficiaryMetaDetails.custId) || !k.a((Object) this.bankName, (Object) beneficiaryMetaDetails.bankName) || !k.a((Object) this.instrument_meta_status, (Object) beneficiaryMetaDetails.instrument_meta_status) || !k.a((Object) this.accountNo, (Object) beneficiaryMetaDetails.accountNo) || !k.a((Object) this.ifsc, (Object) beneficiaryMetaDetails.ifsc) || !k.a((Object) this.vpa, (Object) beneficiaryMetaDetails.vpa)) {
                    return false;
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
        String str2 = this.name;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.nickname;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.contactStatus;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        Integer num = this.contact_type;
        int hashCode5 = (hashCode4 + (num != null ? num.hashCode() : 0)) * 31;
        String str5 = this.paymentInstrumentId;
        int hashCode6 = (hashCode5 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String str6 = this.instrumentType;
        int hashCode7 = (hashCode6 + (str6 != null ? str6.hashCode() : 0)) * 31;
        String str7 = this.score;
        int hashCode8 = (hashCode7 + (str7 != null ? str7.hashCode() : 0)) * 31;
        String str8 = this.instrumentStatus;
        int hashCode9 = (hashCode8 + (str8 != null ? str8.hashCode() : 0)) * 31;
        String str9 = this.imageUrl;
        int hashCode10 = (hashCode9 + (str9 != null ? str9.hashCode() : 0)) * 31;
        String str10 = this.mobileNo;
        int hashCode11 = (hashCode10 + (str10 != null ? str10.hashCode() : 0)) * 31;
        String str11 = this.custId;
        int hashCode12 = (hashCode11 + (str11 != null ? str11.hashCode() : 0)) * 31;
        String str12 = this.bankName;
        int hashCode13 = (hashCode12 + (str12 != null ? str12.hashCode() : 0)) * 31;
        String str13 = this.instrument_meta_status;
        int hashCode14 = (hashCode13 + (str13 != null ? str13.hashCode() : 0)) * 31;
        String str14 = this.accountNo;
        int hashCode15 = (hashCode14 + (str14 != null ? str14.hashCode() : 0)) * 31;
        String str15 = this.ifsc;
        int hashCode16 = (hashCode15 + (str15 != null ? str15.hashCode() : 0)) * 31;
        String str16 = this.vpa;
        if (str16 != null) {
            i3 = str16.hashCode();
        }
        return hashCode16 + i3;
    }

    public final String toString() {
        return "BeneficiaryMetaDetails(id=" + this.id + ", payeeInfoId=" + this.payeeInfoId + ", name=" + this.name + ", nickname=" + this.nickname + ", contactStatus=" + this.contactStatus + ", contact_type=" + this.contact_type + ", paymentInstrumentId=" + this.paymentInstrumentId + ", instrumentType=" + this.instrumentType + ", score=" + this.score + ", instrumentStatus=" + this.instrumentStatus + ", imageUrl=" + this.imageUrl + ", mobileNo=" + this.mobileNo + ", custId=" + this.custId + ", bankName=" + this.bankName + ", instrument_meta_status=" + this.instrument_meta_status + ", accountNo=" + this.accountNo + ", ifsc=" + this.ifsc + ", vpa=" + this.vpa + ")";
    }

    public BeneficiaryMetaDetails(long j, String str, String str2, String str3, String str4, Integer num, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16) {
        k.c(str, "payeeInfoId");
        this.id = j;
        this.payeeInfoId = str;
        this.name = str2;
        this.nickname = str3;
        this.contactStatus = str4;
        this.contact_type = num;
        this.paymentInstrumentId = str5;
        this.instrumentType = str6;
        this.score = str7;
        this.instrumentStatus = str8;
        this.imageUrl = str9;
        this.mobileNo = str10;
        this.custId = str11;
        this.bankName = str12;
        this.instrument_meta_status = str13;
        this.accountNo = str14;
        this.ifsc = str15;
        this.vpa = str16;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ BeneficiaryMetaDetails(long j, String str, String str2, String str3, String str4, Integer num, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16, int i2, g gVar) {
        this((i2 & 1) != 0 ? 0 : j, str, str2, str3, str4, num, str5, str6, str7, str8, str9, str10, str11, str12, str13, str14, str15, str16);
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

    public final String getName() {
        return this.name;
    }

    public final void setName(String str) {
        this.name = str;
    }

    public final String getNickname() {
        return this.nickname;
    }

    public final void setNickname(String str) {
        this.nickname = str;
    }

    public final String getContactStatus() {
        return this.contactStatus;
    }

    public final void setContactStatus(String str) {
        this.contactStatus = str;
    }

    public final Integer getContact_type() {
        return this.contact_type;
    }

    public final void setContact_type(Integer num) {
        this.contact_type = num;
    }

    public final String getPaymentInstrumentId() {
        return this.paymentInstrumentId;
    }

    public final void setPaymentInstrumentId(String str) {
        this.paymentInstrumentId = str;
    }

    public final String getInstrumentType() {
        return this.instrumentType;
    }

    public final void setInstrumentType(String str) {
        this.instrumentType = str;
    }

    public final String getScore() {
        return this.score;
    }

    public final void setScore(String str) {
        this.score = str;
    }

    public final String getInstrumentStatus() {
        return this.instrumentStatus;
    }

    public final void setInstrumentStatus(String str) {
        this.instrumentStatus = str;
    }

    public final String getImageUrl() {
        return this.imageUrl;
    }

    public final void setImageUrl(String str) {
        this.imageUrl = str;
    }

    public final String getMobileNo() {
        return this.mobileNo;
    }

    public final void setMobileNo(String str) {
        this.mobileNo = str;
    }

    public final String getCustId() {
        return this.custId;
    }

    public final void setCustId(String str) {
        this.custId = str;
    }

    public final String getBankName() {
        return this.bankName;
    }

    public final void setBankName(String str) {
        this.bankName = str;
    }

    public final String getInstrument_meta_status() {
        return this.instrument_meta_status;
    }

    public final void setInstrument_meta_status(String str) {
        this.instrument_meta_status = str;
    }

    public final String getAccountNo() {
        return this.accountNo;
    }

    public final void setAccountNo(String str) {
        this.accountNo = str;
    }

    public final String getIfsc() {
        return this.ifsc;
    }

    public final void setIfsc(String str) {
        this.ifsc = str;
    }

    public final String getVpa() {
        return this.vpa;
    }

    public final void setVpa(String str) {
        this.vpa = str;
    }
}
