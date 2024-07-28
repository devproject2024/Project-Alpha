package net.one97.paytm.upi.mandate.data.model;

import com.alipay.mobile.nebula.util.tar.TarConstants;
import com.google.gson.a.c;
import kotlin.g.b.k;
import net.one97.paytm.nativesdk.emiSubvention.utils.EmiUtil;
import net.one97.paytm.nativesdk.transcation.PayUtility;
import net.one97.paytm.phoenix.provider.download.FileDownloadDefaultParamsKt;
import net.one97.paytm.upi.common.UpiBaseDataModel;
import net.one97.paytm.upi.util.UpiConstants;
import net.one97.paytm.upi.util.UpiRequestBuilder;

public final class CreateRecurringMandateRequestModel implements UpiBaseDataModel {
    @c(a = "accRefId")
    private final String accRefId;
    @c(a = "amount")
    private final String amount;
    @c(a = "amountRule")
    private final String amountRule;
    @c(a = "deviceId")
    private final String deviceId;
    @c(a = "frequencyPattern")
    private final String frequencyPattern;
    @c(a = "frequencyRule")
    private final String frequencyRule;
    @c(a = "frequencyType")
    private final String frequencyType;
    @c(a = "initiationMode")
    private final String initiationMode;
    @c(a = "minimumAmount")
    private final String minimumAmount;
    @c(a = "mpin")
    private final String mpin;
    @c(a = "note")
    private final String note;
    @c(a = "payeeMcc")
    private final String payeeMcc;
    @c(a = "payeeName")
    private final String payeeName;
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
    @c(a = "qrExpire")
    private final String qrExpire;
    @c(a = "qrTs")
    private final String qrTs;
    @c(a = "query")
    private final String query;
    @c(a = "seqNo")
    private final String seqNo;
    @c(a = "refId")
    private final String subscriptionId;
    @c(a = "validityEndDate")
    private final String validityEndDate;
    @c(a = "validityStartDate")
    private final String validityStartDate;

    public static /* synthetic */ CreateRecurringMandateRequestModel copy$default(CreateRecurringMandateRequestModel createRecurringMandateRequestModel, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16, String str17, String str18, String str19, String str20, String str21, String str22, String str23, String str24, String str25, int i2, Object obj) {
        CreateRecurringMandateRequestModel createRecurringMandateRequestModel2 = createRecurringMandateRequestModel;
        int i3 = i2;
        return createRecurringMandateRequestModel.copy((i3 & 1) != 0 ? createRecurringMandateRequestModel2.seqNo : str, (i3 & 2) != 0 ? createRecurringMandateRequestModel2.deviceId : str2, (i3 & 4) != 0 ? createRecurringMandateRequestModel2.mpin : str3, (i3 & 8) != 0 ? createRecurringMandateRequestModel2.payerVa : str4, (i3 & 16) != 0 ? createRecurringMandateRequestModel2.payerAccountIfsc : str5, (i3 & 32) != 0 ? createRecurringMandateRequestModel2.payerAccountNo : str6, (i3 & 64) != 0 ? createRecurringMandateRequestModel2.payeeVa : str7, (i3 & 128) != 0 ? createRecurringMandateRequestModel2.payeeName : str8, (i3 & UpiConstants.REQUEST_OPEN_APP_PERMISSION_READ_SMS) != 0 ? createRecurringMandateRequestModel2.payeeMcc : str9, (i3 & 512) != 0 ? createRecurringMandateRequestModel2.amount : str10, (i3 & TarConstants.EOF_BLOCK) != 0 ? createRecurringMandateRequestModel2.validityStartDate : str11, (i3 & EmiUtil.EMI_PLAN_REQUEST_CODE) != 0 ? createRecurringMandateRequestModel2.validityEndDate : str12, (i3 & 4096) != 0 ? createRecurringMandateRequestModel2.amountRule : str13, (i3 & FileDownloadDefaultParamsKt.DOWNLOAD_BUFFER_SIZE) != 0 ? createRecurringMandateRequestModel2.note : str14, (i3 & 16384) != 0 ? createRecurringMandateRequestModel2.frequencyType : str15, (i3 & 32768) != 0 ? createRecurringMandateRequestModel2.frequencyRule : str16, (i3 & 65536) != 0 ? createRecurringMandateRequestModel2.frequencyPattern : str17, (i3 & 131072) != 0 ? createRecurringMandateRequestModel2.accRefId : str18, (i3 & 262144) != 0 ? createRecurringMandateRequestModel2.purpose : str19, (i3 & 524288) != 0 ? createRecurringMandateRequestModel2.initiationMode : str20, (i3 & 1048576) != 0 ? createRecurringMandateRequestModel2.subscriptionId : str21, (i3 & 2097152) != 0 ? createRecurringMandateRequestModel2.qrExpire : str22, (i3 & 4194304) != 0 ? createRecurringMandateRequestModel2.qrTs : str23, (i3 & 8388608) != 0 ? createRecurringMandateRequestModel2.query : str24, (i3 & 16777216) != 0 ? createRecurringMandateRequestModel2.minimumAmount : str25);
    }

    public final String component1() {
        return this.seqNo;
    }

    public final String component10() {
        return this.amount;
    }

    public final String component11() {
        return this.validityStartDate;
    }

    public final String component12() {
        return this.validityEndDate;
    }

    public final String component13() {
        return this.amountRule;
    }

    public final String component14() {
        return this.note;
    }

    public final String component15() {
        return this.frequencyType;
    }

    public final String component16() {
        return this.frequencyRule;
    }

    public final String component17() {
        return this.frequencyPattern;
    }

    public final String component18() {
        return this.accRefId;
    }

    public final String component19() {
        return this.purpose;
    }

    public final String component2() {
        return this.deviceId;
    }

    public final String component20() {
        return this.initiationMode;
    }

    public final String component21() {
        return this.subscriptionId;
    }

    public final String component22() {
        return this.qrExpire;
    }

    public final String component23() {
        return this.qrTs;
    }

    public final String component24() {
        return this.query;
    }

    public final String component25() {
        return this.minimumAmount;
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

    public final CreateRecurringMandateRequestModel copy(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16, String str17, String str18, String str19, String str20, String str21, String str22, String str23, String str24, String str25) {
        String str26 = str;
        k.c(str26, UpiRequestBuilder.KEY_SEQ_NO_CAMEL_CASE);
        k.c(str2, "deviceId");
        k.c(str3, PayUtility.MPIN);
        k.c(str4, "payerVa");
        k.c(str5, "payerAccountIfsc");
        k.c(str6, "payerAccountNo");
        k.c(str7, "payeeVa");
        k.c(str9, "payeeMcc");
        k.c(str10, "amount");
        k.c(str11, "validityStartDate");
        k.c(str12, "validityEndDate");
        k.c(str13, "amountRule");
        k.c(str15, "frequencyType");
        k.c(str16, "frequencyRule");
        k.c(str17, "frequencyPattern");
        k.c(str18, "accRefId");
        k.c(str19, "purpose");
        k.c(str20, "initiationMode");
        k.c(str21, "subscriptionId");
        return new CreateRecurringMandateRequestModel(str26, str2, str3, str4, str5, str6, str7, str8, str9, str10, str11, str12, str13, str14, str15, str16, str17, str18, str19, str20, str21, str22, str23, str24, str25);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CreateRecurringMandateRequestModel)) {
            return false;
        }
        CreateRecurringMandateRequestModel createRecurringMandateRequestModel = (CreateRecurringMandateRequestModel) obj;
        return k.a((Object) this.seqNo, (Object) createRecurringMandateRequestModel.seqNo) && k.a((Object) this.deviceId, (Object) createRecurringMandateRequestModel.deviceId) && k.a((Object) this.mpin, (Object) createRecurringMandateRequestModel.mpin) && k.a((Object) this.payerVa, (Object) createRecurringMandateRequestModel.payerVa) && k.a((Object) this.payerAccountIfsc, (Object) createRecurringMandateRequestModel.payerAccountIfsc) && k.a((Object) this.payerAccountNo, (Object) createRecurringMandateRequestModel.payerAccountNo) && k.a((Object) this.payeeVa, (Object) createRecurringMandateRequestModel.payeeVa) && k.a((Object) this.payeeName, (Object) createRecurringMandateRequestModel.payeeName) && k.a((Object) this.payeeMcc, (Object) createRecurringMandateRequestModel.payeeMcc) && k.a((Object) this.amount, (Object) createRecurringMandateRequestModel.amount) && k.a((Object) this.validityStartDate, (Object) createRecurringMandateRequestModel.validityStartDate) && k.a((Object) this.validityEndDate, (Object) createRecurringMandateRequestModel.validityEndDate) && k.a((Object) this.amountRule, (Object) createRecurringMandateRequestModel.amountRule) && k.a((Object) this.note, (Object) createRecurringMandateRequestModel.note) && k.a((Object) this.frequencyType, (Object) createRecurringMandateRequestModel.frequencyType) && k.a((Object) this.frequencyRule, (Object) createRecurringMandateRequestModel.frequencyRule) && k.a((Object) this.frequencyPattern, (Object) createRecurringMandateRequestModel.frequencyPattern) && k.a((Object) this.accRefId, (Object) createRecurringMandateRequestModel.accRefId) && k.a((Object) this.purpose, (Object) createRecurringMandateRequestModel.purpose) && k.a((Object) this.initiationMode, (Object) createRecurringMandateRequestModel.initiationMode) && k.a((Object) this.subscriptionId, (Object) createRecurringMandateRequestModel.subscriptionId) && k.a((Object) this.qrExpire, (Object) createRecurringMandateRequestModel.qrExpire) && k.a((Object) this.qrTs, (Object) createRecurringMandateRequestModel.qrTs) && k.a((Object) this.query, (Object) createRecurringMandateRequestModel.query) && k.a((Object) this.minimumAmount, (Object) createRecurringMandateRequestModel.minimumAmount);
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
        String str10 = this.amount;
        int hashCode10 = (hashCode9 + (str10 != null ? str10.hashCode() : 0)) * 31;
        String str11 = this.validityStartDate;
        int hashCode11 = (hashCode10 + (str11 != null ? str11.hashCode() : 0)) * 31;
        String str12 = this.validityEndDate;
        int hashCode12 = (hashCode11 + (str12 != null ? str12.hashCode() : 0)) * 31;
        String str13 = this.amountRule;
        int hashCode13 = (hashCode12 + (str13 != null ? str13.hashCode() : 0)) * 31;
        String str14 = this.note;
        int hashCode14 = (hashCode13 + (str14 != null ? str14.hashCode() : 0)) * 31;
        String str15 = this.frequencyType;
        int hashCode15 = (hashCode14 + (str15 != null ? str15.hashCode() : 0)) * 31;
        String str16 = this.frequencyRule;
        int hashCode16 = (hashCode15 + (str16 != null ? str16.hashCode() : 0)) * 31;
        String str17 = this.frequencyPattern;
        int hashCode17 = (hashCode16 + (str17 != null ? str17.hashCode() : 0)) * 31;
        String str18 = this.accRefId;
        int hashCode18 = (hashCode17 + (str18 != null ? str18.hashCode() : 0)) * 31;
        String str19 = this.purpose;
        int hashCode19 = (hashCode18 + (str19 != null ? str19.hashCode() : 0)) * 31;
        String str20 = this.initiationMode;
        int hashCode20 = (hashCode19 + (str20 != null ? str20.hashCode() : 0)) * 31;
        String str21 = this.subscriptionId;
        int hashCode21 = (hashCode20 + (str21 != null ? str21.hashCode() : 0)) * 31;
        String str22 = this.qrExpire;
        int hashCode22 = (hashCode21 + (str22 != null ? str22.hashCode() : 0)) * 31;
        String str23 = this.qrTs;
        int hashCode23 = (hashCode22 + (str23 != null ? str23.hashCode() : 0)) * 31;
        String str24 = this.query;
        int hashCode24 = (hashCode23 + (str24 != null ? str24.hashCode() : 0)) * 31;
        String str25 = this.minimumAmount;
        if (str25 != null) {
            i2 = str25.hashCode();
        }
        return hashCode24 + i2;
    }

    public final String toString() {
        return "CreateRecurringMandateRequestModel(seqNo=" + this.seqNo + ", deviceId=" + this.deviceId + ", mpin=" + this.mpin + ", payerVa=" + this.payerVa + ", payerAccountIfsc=" + this.payerAccountIfsc + ", payerAccountNo=" + this.payerAccountNo + ", payeeVa=" + this.payeeVa + ", payeeName=" + this.payeeName + ", payeeMcc=" + this.payeeMcc + ", amount=" + this.amount + ", validityStartDate=" + this.validityStartDate + ", validityEndDate=" + this.validityEndDate + ", amountRule=" + this.amountRule + ", note=" + this.note + ", frequencyType=" + this.frequencyType + ", frequencyRule=" + this.frequencyRule + ", frequencyPattern=" + this.frequencyPattern + ", accRefId=" + this.accRefId + ", purpose=" + this.purpose + ", initiationMode=" + this.initiationMode + ", subscriptionId=" + this.subscriptionId + ", qrExpire=" + this.qrExpire + ", qrTs=" + this.qrTs + ", query=" + this.query + ", minimumAmount=" + this.minimumAmount + ")";
    }

    public CreateRecurringMandateRequestModel(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16, String str17, String str18, String str19, String str20, String str21, String str22, String str23, String str24, String str25) {
        String str26 = str;
        String str27 = str2;
        String str28 = str3;
        String str29 = str4;
        String str30 = str5;
        String str31 = str6;
        String str32 = str7;
        String str33 = str9;
        String str34 = str10;
        String str35 = str11;
        String str36 = str12;
        String str37 = str13;
        String str38 = str15;
        String str39 = str16;
        String str40 = str18;
        k.c(str26, UpiRequestBuilder.KEY_SEQ_NO_CAMEL_CASE);
        k.c(str27, "deviceId");
        k.c(str28, PayUtility.MPIN);
        k.c(str29, "payerVa");
        k.c(str30, "payerAccountIfsc");
        k.c(str31, "payerAccountNo");
        k.c(str32, "payeeVa");
        k.c(str33, "payeeMcc");
        k.c(str34, "amount");
        k.c(str35, "validityStartDate");
        k.c(str36, "validityEndDate");
        k.c(str37, "amountRule");
        k.c(str38, "frequencyType");
        k.c(str39, "frequencyRule");
        k.c(str17, "frequencyPattern");
        k.c(str18, "accRefId");
        k.c(str19, "purpose");
        k.c(str20, "initiationMode");
        k.c(str21, "subscriptionId");
        this.seqNo = str26;
        this.deviceId = str27;
        this.mpin = str28;
        this.payerVa = str29;
        this.payerAccountIfsc = str30;
        this.payerAccountNo = str31;
        this.payeeVa = str32;
        this.payeeName = str8;
        this.payeeMcc = str33;
        this.amount = str34;
        this.validityStartDate = str35;
        this.validityEndDate = str36;
        this.amountRule = str37;
        this.note = str14;
        this.frequencyType = str38;
        this.frequencyRule = str39;
        this.frequencyPattern = str17;
        this.accRefId = str18;
        this.purpose = str19;
        this.initiationMode = str20;
        this.subscriptionId = str21;
        this.qrExpire = str22;
        this.qrTs = str23;
        this.query = str24;
        this.minimumAmount = str25;
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

    public final String getAmount() {
        return this.amount;
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

    public final String getFrequencyType() {
        return this.frequencyType;
    }

    public final String getFrequencyRule() {
        return this.frequencyRule;
    }

    public final String getFrequencyPattern() {
        return this.frequencyPattern;
    }

    public final String getAccRefId() {
        return this.accRefId;
    }

    public final String getPurpose() {
        return this.purpose;
    }

    public final String getInitiationMode() {
        return this.initiationMode;
    }

    public final String getSubscriptionId() {
        return this.subscriptionId;
    }

    public final String getQrExpire() {
        return this.qrExpire;
    }

    public final String getQrTs() {
        return this.qrTs;
    }

    public final String getQuery() {
        return this.query;
    }

    public final String getMinimumAmount() {
        return this.minimumAmount;
    }
}
