package net.one97.paytm.upi.mandate.data.model;

import com.alipay.mobile.nebula.util.tar.TarConstants;
import com.google.gson.a.c;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.wallet.CJRQRScanResultModel;
import net.one97.paytm.nativesdk.emiSubvention.utils.EmiUtil;
import net.one97.paytm.nativesdk.transcation.PayUtility;
import net.one97.paytm.phoenix.provider.download.FileDownloadDefaultParamsKt;
import net.one97.paytm.upi.common.UpiBaseDataModel;
import net.one97.paytm.upi.util.UpiConstants;
import net.one97.paytm.upi.util.UpiRequestBuilder;

public final class CreateMandateRequestModel implements UpiBaseDataModel {
    @c(a = "amount")
    private final String amount;
    @c(a = "amountRule")
    private final String amountRule;
    @c(a = "deviceId")
    private final String deviceId;
    @c(a = "mpin")
    private final String mpin;
    @c(a = "note")
    private final String note;
    @c(a = "payeeMcc")
    private final String payeeMcc;
    @c(a = "payeeName")
    private final String payeeName;
    @c(a = "payeeType")
    private final String payeeType;
    @c(a = "payeeVa")
    private final String payeeVa;
    @c(a = "payerAccountIfsc")
    private final String payerAccountIfsc;
    @c(a = "payerAccountNo")
    private final String payerAccountNo;
    @c(a = "payerVa")
    private final String payerVa;
    @c(a = "purpose")
    private final String purpose;
    @c(a = "refId")
    private final String refId;
    @c(a = "revocable")
    private final String revocable;
    @c(a = "seqNo")
    private final String seqNo;
    @c(a = "shareToPayee")
    private final String shareToPayee;
    @c(a = "validityEndDate")
    private final String validityEndDate;
    @c(a = "validityStartDate")
    private final String validityStartDate;

    public static /* synthetic */ CreateMandateRequestModel copy$default(CreateMandateRequestModel createMandateRequestModel, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16, String str17, String str18, String str19, int i2, Object obj) {
        CreateMandateRequestModel createMandateRequestModel2 = createMandateRequestModel;
        int i3 = i2;
        return createMandateRequestModel.copy((i3 & 1) != 0 ? createMandateRequestModel2.seqNo : str, (i3 & 2) != 0 ? createMandateRequestModel2.deviceId : str2, (i3 & 4) != 0 ? createMandateRequestModel2.mpin : str3, (i3 & 8) != 0 ? createMandateRequestModel2.payerVa : str4, (i3 & 16) != 0 ? createMandateRequestModel2.payerAccountIfsc : str5, (i3 & 32) != 0 ? createMandateRequestModel2.payerAccountNo : str6, (i3 & 64) != 0 ? createMandateRequestModel2.payeeVa : str7, (i3 & 128) != 0 ? createMandateRequestModel2.payeeName : str8, (i3 & UpiConstants.REQUEST_OPEN_APP_PERMISSION_READ_SMS) != 0 ? createMandateRequestModel2.payeeMcc : str9, (i3 & 512) != 0 ? createMandateRequestModel2.payeeType : str10, (i3 & TarConstants.EOF_BLOCK) != 0 ? createMandateRequestModel2.shareToPayee : str11, (i3 & EmiUtil.EMI_PLAN_REQUEST_CODE) != 0 ? createMandateRequestModel2.amount : str12, (i3 & 4096) != 0 ? createMandateRequestModel2.revocable : str13, (i3 & FileDownloadDefaultParamsKt.DOWNLOAD_BUFFER_SIZE) != 0 ? createMandateRequestModel2.validityStartDate : str14, (i3 & 16384) != 0 ? createMandateRequestModel2.validityEndDate : str15, (i3 & 32768) != 0 ? createMandateRequestModel2.amountRule : str16, (i3 & 65536) != 0 ? createMandateRequestModel2.note : str17, (i3 & 131072) != 0 ? createMandateRequestModel2.refId : str18, (i3 & 262144) != 0 ? createMandateRequestModel2.purpose : str19);
    }

    public final String component1() {
        return this.seqNo;
    }

    public final String component10() {
        return this.payeeType;
    }

    public final String component11() {
        return this.shareToPayee;
    }

    public final String component12() {
        return this.amount;
    }

    public final String component13() {
        return this.revocable;
    }

    public final String component14() {
        return this.validityStartDate;
    }

    public final String component15() {
        return this.validityEndDate;
    }

    public final String component16() {
        return this.amountRule;
    }

    public final String component17() {
        return this.note;
    }

    public final String component18() {
        return this.refId;
    }

    public final String component19() {
        return this.purpose;
    }

    public final String component2() {
        return this.deviceId;
    }

    public final String component3() {
        return this.mpin;
    }

    public final String component4() {
        return this.payerVa;
    }

    public final String component5() {
        return this.payerAccountIfsc;
    }

    public final String component6() {
        return this.payerAccountNo;
    }

    public final String component7() {
        return this.payeeVa;
    }

    public final String component8() {
        return this.payeeName;
    }

    public final String component9() {
        return this.payeeMcc;
    }

    public final CreateMandateRequestModel copy(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16, String str17, String str18, String str19) {
        String str20 = str;
        k.c(str20, UpiRequestBuilder.KEY_SEQ_NO_CAMEL_CASE);
        k.c(str2, "deviceId");
        k.c(str3, PayUtility.MPIN);
        k.c(str4, "payerVa");
        k.c(str5, "payerAccountIfsc");
        k.c(str6, "payerAccountNo");
        k.c(str7, "payeeVa");
        k.c(str9, "payeeMcc");
        k.c(str10, CJRQRScanResultModel.KEY_PAYEE_TYPE);
        k.c(str11, "shareToPayee");
        k.c(str12, "amount");
        k.c(str13, "revocable");
        k.c(str14, "validityStartDate");
        k.c(str15, "validityEndDate");
        k.c(str16, "amountRule");
        k.c(str19, "purpose");
        return new CreateMandateRequestModel(str20, str2, str3, str4, str5, str6, str7, str8, str9, str10, str11, str12, str13, str14, str15, str16, str17, str18, str19);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CreateMandateRequestModel)) {
            return false;
        }
        CreateMandateRequestModel createMandateRequestModel = (CreateMandateRequestModel) obj;
        return k.a((Object) this.seqNo, (Object) createMandateRequestModel.seqNo) && k.a((Object) this.deviceId, (Object) createMandateRequestModel.deviceId) && k.a((Object) this.mpin, (Object) createMandateRequestModel.mpin) && k.a((Object) this.payerVa, (Object) createMandateRequestModel.payerVa) && k.a((Object) this.payerAccountIfsc, (Object) createMandateRequestModel.payerAccountIfsc) && k.a((Object) this.payerAccountNo, (Object) createMandateRequestModel.payerAccountNo) && k.a((Object) this.payeeVa, (Object) createMandateRequestModel.payeeVa) && k.a((Object) this.payeeName, (Object) createMandateRequestModel.payeeName) && k.a((Object) this.payeeMcc, (Object) createMandateRequestModel.payeeMcc) && k.a((Object) this.payeeType, (Object) createMandateRequestModel.payeeType) && k.a((Object) this.shareToPayee, (Object) createMandateRequestModel.shareToPayee) && k.a((Object) this.amount, (Object) createMandateRequestModel.amount) && k.a((Object) this.revocable, (Object) createMandateRequestModel.revocable) && k.a((Object) this.validityStartDate, (Object) createMandateRequestModel.validityStartDate) && k.a((Object) this.validityEndDate, (Object) createMandateRequestModel.validityEndDate) && k.a((Object) this.amountRule, (Object) createMandateRequestModel.amountRule) && k.a((Object) this.note, (Object) createMandateRequestModel.note) && k.a((Object) this.refId, (Object) createMandateRequestModel.refId) && k.a((Object) this.purpose, (Object) createMandateRequestModel.purpose);
    }

    public final int hashCode() {
        String str = this.seqNo;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.deviceId;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.mpin;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.payerVa;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.payerAccountIfsc;
        int hashCode5 = (hashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String str6 = this.payerAccountNo;
        int hashCode6 = (hashCode5 + (str6 != null ? str6.hashCode() : 0)) * 31;
        String str7 = this.payeeVa;
        int hashCode7 = (hashCode6 + (str7 != null ? str7.hashCode() : 0)) * 31;
        String str8 = this.payeeName;
        int hashCode8 = (hashCode7 + (str8 != null ? str8.hashCode() : 0)) * 31;
        String str9 = this.payeeMcc;
        int hashCode9 = (hashCode8 + (str9 != null ? str9.hashCode() : 0)) * 31;
        String str10 = this.payeeType;
        int hashCode10 = (hashCode9 + (str10 != null ? str10.hashCode() : 0)) * 31;
        String str11 = this.shareToPayee;
        int hashCode11 = (hashCode10 + (str11 != null ? str11.hashCode() : 0)) * 31;
        String str12 = this.amount;
        int hashCode12 = (hashCode11 + (str12 != null ? str12.hashCode() : 0)) * 31;
        String str13 = this.revocable;
        int hashCode13 = (hashCode12 + (str13 != null ? str13.hashCode() : 0)) * 31;
        String str14 = this.validityStartDate;
        int hashCode14 = (hashCode13 + (str14 != null ? str14.hashCode() : 0)) * 31;
        String str15 = this.validityEndDate;
        int hashCode15 = (hashCode14 + (str15 != null ? str15.hashCode() : 0)) * 31;
        String str16 = this.amountRule;
        int hashCode16 = (hashCode15 + (str16 != null ? str16.hashCode() : 0)) * 31;
        String str17 = this.note;
        int hashCode17 = (hashCode16 + (str17 != null ? str17.hashCode() : 0)) * 31;
        String str18 = this.refId;
        int hashCode18 = (hashCode17 + (str18 != null ? str18.hashCode() : 0)) * 31;
        String str19 = this.purpose;
        if (str19 != null) {
            i2 = str19.hashCode();
        }
        return hashCode18 + i2;
    }

    public final String toString() {
        return "CreateMandateRequestModel(seqNo=" + this.seqNo + ", deviceId=" + this.deviceId + ", mpin=" + this.mpin + ", payerVa=" + this.payerVa + ", payerAccountIfsc=" + this.payerAccountIfsc + ", payerAccountNo=" + this.payerAccountNo + ", payeeVa=" + this.payeeVa + ", payeeName=" + this.payeeName + ", payeeMcc=" + this.payeeMcc + ", payeeType=" + this.payeeType + ", shareToPayee=" + this.shareToPayee + ", amount=" + this.amount + ", revocable=" + this.revocable + ", validityStartDate=" + this.validityStartDate + ", validityEndDate=" + this.validityEndDate + ", amountRule=" + this.amountRule + ", note=" + this.note + ", refId=" + this.refId + ", purpose=" + this.purpose + ")";
    }

    public CreateMandateRequestModel(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16, String str17, String str18, String str19) {
        String str20 = str;
        String str21 = str2;
        String str22 = str3;
        String str23 = str4;
        String str24 = str5;
        String str25 = str6;
        String str26 = str7;
        String str27 = str9;
        String str28 = str10;
        String str29 = str11;
        String str30 = str12;
        String str31 = str13;
        String str32 = str14;
        String str33 = str15;
        k.c(str20, UpiRequestBuilder.KEY_SEQ_NO_CAMEL_CASE);
        k.c(str21, "deviceId");
        k.c(str22, PayUtility.MPIN);
        k.c(str23, "payerVa");
        k.c(str24, "payerAccountIfsc");
        k.c(str25, "payerAccountNo");
        k.c(str26, "payeeVa");
        k.c(str27, "payeeMcc");
        k.c(str28, CJRQRScanResultModel.KEY_PAYEE_TYPE);
        k.c(str29, "shareToPayee");
        k.c(str30, "amount");
        k.c(str31, "revocable");
        k.c(str32, "validityStartDate");
        k.c(str33, "validityEndDate");
        k.c(str16, "amountRule");
        String str34 = str19;
        k.c(str34, "purpose");
        this.seqNo = str20;
        this.deviceId = str21;
        this.mpin = str22;
        this.payerVa = str23;
        this.payerAccountIfsc = str24;
        this.payerAccountNo = str25;
        this.payeeVa = str26;
        this.payeeName = str8;
        this.payeeMcc = str27;
        this.payeeType = str28;
        this.shareToPayee = str29;
        this.amount = str30;
        this.revocable = str31;
        this.validityStartDate = str32;
        this.validityEndDate = str33;
        this.amountRule = str16;
        this.note = str17;
        this.refId = str18;
        this.purpose = str34;
    }

    public final String getSeqNo() {
        return this.seqNo;
    }

    public final String getDeviceId() {
        return this.deviceId;
    }

    public final String getMpin() {
        return this.mpin;
    }

    public final String getPayerVa() {
        return this.payerVa;
    }

    public final String getPayerAccountIfsc() {
        return this.payerAccountIfsc;
    }

    public final String getPayerAccountNo() {
        return this.payerAccountNo;
    }

    public final String getPayeeVa() {
        return this.payeeVa;
    }

    public final String getPayeeName() {
        return this.payeeName;
    }

    public final String getPayeeMcc() {
        return this.payeeMcc;
    }

    public final String getPayeeType() {
        return this.payeeType;
    }

    public final String getShareToPayee() {
        return this.shareToPayee;
    }

    public final String getAmount() {
        return this.amount;
    }

    public final String getRevocable() {
        return this.revocable;
    }

    public final String getValidityStartDate() {
        return this.validityStartDate;
    }

    public final String getValidityEndDate() {
        return this.validityEndDate;
    }

    public final String getAmountRule() {
        return this.amountRule;
    }

    public final String getNote() {
        return this.note;
    }

    public final String getRefId() {
        return this.refId;
    }

    public final String getPurpose() {
        return this.purpose;
    }
}
