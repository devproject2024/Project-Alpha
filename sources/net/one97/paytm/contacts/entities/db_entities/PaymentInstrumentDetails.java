package net.one97.paytm.contacts.entities.db_entities;

import com.alipay.mobile.nebula.util.tar.TarConstants;
import kotlin.g.b.g;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.nativesdk.emiSubvention.utils.EmiUtil;
import net.one97.paytm.phoenix.provider.download.FileDownloadDefaultParamsKt;
import net.one97.paytm.upi.util.UpiConstants;

public final class PaymentInstrumentDetails implements IJRDataModel {
    private String accountNo;
    private String bankName;
    private String custId;
    private String expiryTime;
    private long id;
    private String ifsc;
    private String instrument_meta_status;
    private String mobileNo;
    private String payeeInfoId;
    private String payeeMetaId;
    private String paymentInstrumentId;
    private String score;
    private String status;
    private String type;
    private String vpa;

    public static /* synthetic */ PaymentInstrumentDetails copy$default(PaymentInstrumentDetails paymentInstrumentDetails, long j, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, int i2, Object obj) {
        PaymentInstrumentDetails paymentInstrumentDetails2 = paymentInstrumentDetails;
        int i3 = i2;
        return paymentInstrumentDetails.copy((i3 & 1) != 0 ? paymentInstrumentDetails2.id : j, (i3 & 2) != 0 ? paymentInstrumentDetails2.paymentInstrumentId : str, (i3 & 4) != 0 ? paymentInstrumentDetails2.type : str2, (i3 & 8) != 0 ? paymentInstrumentDetails2.status : str3, (i3 & 16) != 0 ? paymentInstrumentDetails2.score : str4, (i3 & 32) != 0 ? paymentInstrumentDetails2.payeeInfoId : str5, (i3 & 64) != 0 ? paymentInstrumentDetails2.payeeMetaId : str6, (i3 & 128) != 0 ? paymentInstrumentDetails2.mobileNo : str7, (i3 & UpiConstants.REQUEST_OPEN_APP_PERMISSION_READ_SMS) != 0 ? paymentInstrumentDetails2.custId : str8, (i3 & 512) != 0 ? paymentInstrumentDetails2.bankName : str9, (i3 & TarConstants.EOF_BLOCK) != 0 ? paymentInstrumentDetails2.instrument_meta_status : str10, (i3 & EmiUtil.EMI_PLAN_REQUEST_CODE) != 0 ? paymentInstrumentDetails2.accountNo : str11, (i3 & 4096) != 0 ? paymentInstrumentDetails2.ifsc : str12, (i3 & FileDownloadDefaultParamsKt.DOWNLOAD_BUFFER_SIZE) != 0 ? paymentInstrumentDetails2.vpa : str13, (i3 & 16384) != 0 ? paymentInstrumentDetails2.expiryTime : str14);
    }

    public final long component1() {
        return this.id;
    }

    public final String component10() {
        return this.bankName;
    }

    public final String component11() {
        return this.instrument_meta_status;
    }

    public final String component12() {
        return this.accountNo;
    }

    public final String component13() {
        return this.ifsc;
    }

    public final String component14() {
        return this.vpa;
    }

    public final String component15() {
        return this.expiryTime;
    }

    public final String component2() {
        return this.paymentInstrumentId;
    }

    public final String component3() {
        return this.type;
    }

    public final String component4() {
        return this.status;
    }

    public final String component5() {
        return this.score;
    }

    public final String component6() {
        return this.payeeInfoId;
    }

    public final String component7() {
        return this.payeeMetaId;
    }

    public final String component8() {
        return this.mobileNo;
    }

    public final String component9() {
        return this.custId;
    }

    public final PaymentInstrumentDetails copy(long j, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14) {
        long j2 = j;
        k.c(str6, "payeeMetaId");
        return new PaymentInstrumentDetails(j, str, str2, str3, str4, str5, str6, str7, str8, str9, str10, str11, str12, str13, str14);
    }

    public final boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof PaymentInstrumentDetails) {
                PaymentInstrumentDetails paymentInstrumentDetails = (PaymentInstrumentDetails) obj;
                if (!(this.id == paymentInstrumentDetails.id) || !k.a((Object) this.paymentInstrumentId, (Object) paymentInstrumentDetails.paymentInstrumentId) || !k.a((Object) this.type, (Object) paymentInstrumentDetails.type) || !k.a((Object) this.status, (Object) paymentInstrumentDetails.status) || !k.a((Object) this.score, (Object) paymentInstrumentDetails.score) || !k.a((Object) this.payeeInfoId, (Object) paymentInstrumentDetails.payeeInfoId) || !k.a((Object) this.payeeMetaId, (Object) paymentInstrumentDetails.payeeMetaId) || !k.a((Object) this.mobileNo, (Object) paymentInstrumentDetails.mobileNo) || !k.a((Object) this.custId, (Object) paymentInstrumentDetails.custId) || !k.a((Object) this.bankName, (Object) paymentInstrumentDetails.bankName) || !k.a((Object) this.instrument_meta_status, (Object) paymentInstrumentDetails.instrument_meta_status) || !k.a((Object) this.accountNo, (Object) paymentInstrumentDetails.accountNo) || !k.a((Object) this.ifsc, (Object) paymentInstrumentDetails.ifsc) || !k.a((Object) this.vpa, (Object) paymentInstrumentDetails.vpa) || !k.a((Object) this.expiryTime, (Object) paymentInstrumentDetails.expiryTime)) {
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
        String str = this.paymentInstrumentId;
        int i3 = 0;
        int hashCode = (i2 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.type;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.status;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.score;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.payeeInfoId;
        int hashCode5 = (hashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String str6 = this.payeeMetaId;
        int hashCode6 = (hashCode5 + (str6 != null ? str6.hashCode() : 0)) * 31;
        String str7 = this.mobileNo;
        int hashCode7 = (hashCode6 + (str7 != null ? str7.hashCode() : 0)) * 31;
        String str8 = this.custId;
        int hashCode8 = (hashCode7 + (str8 != null ? str8.hashCode() : 0)) * 31;
        String str9 = this.bankName;
        int hashCode9 = (hashCode8 + (str9 != null ? str9.hashCode() : 0)) * 31;
        String str10 = this.instrument_meta_status;
        int hashCode10 = (hashCode9 + (str10 != null ? str10.hashCode() : 0)) * 31;
        String str11 = this.accountNo;
        int hashCode11 = (hashCode10 + (str11 != null ? str11.hashCode() : 0)) * 31;
        String str12 = this.ifsc;
        int hashCode12 = (hashCode11 + (str12 != null ? str12.hashCode() : 0)) * 31;
        String str13 = this.vpa;
        int hashCode13 = (hashCode12 + (str13 != null ? str13.hashCode() : 0)) * 31;
        String str14 = this.expiryTime;
        if (str14 != null) {
            i3 = str14.hashCode();
        }
        return hashCode13 + i3;
    }

    public final String toString() {
        return "PaymentInstrumentDetails(id=" + this.id + ", paymentInstrumentId=" + this.paymentInstrumentId + ", type=" + this.type + ", status=" + this.status + ", score=" + this.score + ", payeeInfoId=" + this.payeeInfoId + ", payeeMetaId=" + this.payeeMetaId + ", mobileNo=" + this.mobileNo + ", custId=" + this.custId + ", bankName=" + this.bankName + ", instrument_meta_status=" + this.instrument_meta_status + ", accountNo=" + this.accountNo + ", ifsc=" + this.ifsc + ", vpa=" + this.vpa + ", expiryTime=" + this.expiryTime + ")";
    }

    public PaymentInstrumentDetails(long j, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14) {
        k.c(str6, "payeeMetaId");
        this.id = j;
        this.paymentInstrumentId = str;
        this.type = str2;
        this.status = str3;
        this.score = str4;
        this.payeeInfoId = str5;
        this.payeeMetaId = str6;
        this.mobileNo = str7;
        this.custId = str8;
        this.bankName = str9;
        this.instrument_meta_status = str10;
        this.accountNo = str11;
        this.ifsc = str12;
        this.vpa = str13;
        this.expiryTime = str14;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ PaymentInstrumentDetails(long j, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, int i2, g gVar) {
        this((i2 & 1) != 0 ? 0 : j, str, str2, str3, str4, str5, str6, str7, str8, str9, str10, str11, str12, str13, str14);
    }

    public final long getId() {
        return this.id;
    }

    public final void setId(long j) {
        this.id = j;
    }

    public final String getPaymentInstrumentId() {
        return this.paymentInstrumentId;
    }

    public final void setPaymentInstrumentId(String str) {
        this.paymentInstrumentId = str;
    }

    public final String getType() {
        return this.type;
    }

    public final void setType(String str) {
        this.type = str;
    }

    public final String getStatus() {
        return this.status;
    }

    public final void setStatus(String str) {
        this.status = str;
    }

    public final String getScore() {
        return this.score;
    }

    public final void setScore(String str) {
        this.score = str;
    }

    public final String getPayeeInfoId() {
        return this.payeeInfoId;
    }

    public final void setPayeeInfoId(String str) {
        this.payeeInfoId = str;
    }

    public final String getPayeeMetaId() {
        return this.payeeMetaId;
    }

    public final void setPayeeMetaId(String str) {
        k.c(str, "<set-?>");
        this.payeeMetaId = str;
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

    public final String getExpiryTime() {
        return this.expiryTime;
    }

    public final void setExpiryTime(String str) {
        this.expiryTime = str;
    }
}
