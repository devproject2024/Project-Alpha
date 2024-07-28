package net.one97.paytm.upi.mandate.data.model;

import com.alipay.mobile.nebula.util.tar.TarConstants;
import com.google.gson.a.c;
import kotlin.g.b.k;
import net.one97.paytm.nativesdk.emiSubvention.utils.EmiUtil;
import net.one97.paytm.phoenix.provider.download.FileDownloadDefaultParamsKt;
import net.one97.paytm.upi.common.UpiBaseDataModel;
import net.one97.paytm.upi.mandate.d.a;
import net.one97.paytm.upi.mandate.utils.m;
import net.one97.paytm.upi.util.UpiConstants;

public final class MandateItem implements UpiBaseDataModel {
    @c(a = "accRefId")
    private String accRefId;
    @c(a = "amount")
    private final String amount;
    @c(a = "amountRule")
    private final String amountRule;
    @c(a = "category")
    private final String category;
    @c(a = "createdDate")
    private final String createdDate;
    @c(a = "lastAmount")
    private final String lastAmount;
    @c(a = "mandateApprovalExpireOn")
    private final String mandateApprovalExpireOn;
    @c(a = "mandateName")
    private final String mandateName;
    @c(a = "modifyAllowed")
    private final String modifyAllowed;
    @c(a = "narration")
    private final String narration;
    @c(a = "narrationDirection")
    private final String narrationDirection;
    @c(a = "note")
    private final String note;
    @c(a = "payee")
    private final MandatePayee payee;
    @c(a = "payer")
    private final MandatePayer payer;
    @c(a = "purpose")
    private final String purpose;
    @c(a = "qrData")
    private final String qrData;
    @c(a = "recurrence")
    private final String recurrence;
    @c(a = "recurrenceRule")
    private final String recurrenceRule;
    @c(a = "recurrenceType")
    private final String recurrenceType;
    @c(a = "refCategory")
    private final String refCategory;
    @c(a = "refUrl")
    private final String refUrl;
    @c(a = "revokeAllowed")
    private final String revokeAllowed;
    @c(a = "rrn")
    private final String rrn;
    @c(a = "state")
    private final String state;
    @c(a = "stateMessage")
    private final String stateMessage;
    @c(a = "txnId")
    private final String txnId;
    @c(a = "type")
    private final String type;
    @c(a = "umn")
    private final String umn;
    @c(a = "updatedApprovalRequest")
    private final Boolean updatedApprovalRequest;
    @c(a = "validityEndDate")
    private String validityEndDate;
    @c(a = "validityStartDate")
    private String validityStartDate;

    public static /* synthetic */ MandateItem copy$default(MandateItem mandateItem, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, Boolean bool, String str9, String str10, String str11, String str12, String str13, String str14, String str15, MandatePayer mandatePayer, MandatePayee mandatePayee, String str16, String str17, String str18, String str19, String str20, String str21, String str22, String str23, String str24, String str25, String str26, String str27, String str28, int i2, Object obj) {
        MandateItem mandateItem2 = mandateItem;
        int i3 = i2;
        return mandateItem.copy((i3 & 1) != 0 ? mandateItem2.accRefId : str, (i3 & 2) != 0 ? mandateItem2.umn : str2, (i3 & 4) != 0 ? mandateItem2.mandateName : str3, (i3 & 8) != 0 ? mandateItem2.note : str4, (i3 & 16) != 0 ? mandateItem2.amount : str5, (i3 & 32) != 0 ? mandateItem2.createdDate : str6, (i3 & 64) != 0 ? mandateItem2.validityStartDate : str7, (i3 & 128) != 0 ? mandateItem2.validityEndDate : str8, (i3 & UpiConstants.REQUEST_OPEN_APP_PERMISSION_READ_SMS) != 0 ? mandateItem2.updatedApprovalRequest : bool, (i3 & 512) != 0 ? mandateItem2.mandateApprovalExpireOn : str9, (i3 & TarConstants.EOF_BLOCK) != 0 ? mandateItem2.modifyAllowed : str10, (i3 & EmiUtil.EMI_PLAN_REQUEST_CODE) != 0 ? mandateItem2.revokeAllowed : str11, (i3 & 4096) != 0 ? mandateItem2.refUrl : str12, (i3 & FileDownloadDefaultParamsKt.DOWNLOAD_BUFFER_SIZE) != 0 ? mandateItem2.refCategory : str13, (i3 & 16384) != 0 ? mandateItem2.recurrence : str14, (i3 & 32768) != 0 ? mandateItem2.amountRule : str15, (i3 & 65536) != 0 ? mandateItem2.payer : mandatePayer, (i3 & 131072) != 0 ? mandateItem2.payee : mandatePayee, (i3 & 262144) != 0 ? mandateItem2.category : str16, (i3 & 524288) != 0 ? mandateItem2.rrn : str17, (i3 & 1048576) != 0 ? mandateItem2.state : str18, (i3 & 2097152) != 0 ? mandateItem2.stateMessage : str19, (i3 & 4194304) != 0 ? mandateItem2.txnId : str20, (i3 & 8388608) != 0 ? mandateItem2.qrData : str21, (i3 & 16777216) != 0 ? mandateItem2.narration : str22, (i3 & 33554432) != 0 ? mandateItem2.narrationDirection : str23, (i3 & 67108864) != 0 ? mandateItem2.recurrenceType : str24, (i3 & 134217728) != 0 ? mandateItem2.recurrenceRule : str25, (i3 & 268435456) != 0 ? mandateItem2.lastAmount : str26, (i3 & 536870912) != 0 ? mandateItem2.type : str27, (i3 & 1073741824) != 0 ? mandateItem2.purpose : str28);
    }

    public final String component1() {
        return this.accRefId;
    }

    public final String component10() {
        return this.mandateApprovalExpireOn;
    }

    public final String component11() {
        return this.modifyAllowed;
    }

    public final String component12() {
        return this.revokeAllowed;
    }

    public final String component13() {
        return this.refUrl;
    }

    public final String component14() {
        return this.refCategory;
    }

    public final String component15() {
        return this.recurrence;
    }

    public final String component16() {
        return this.amountRule;
    }

    public final MandatePayer component17() {
        return this.payer;
    }

    public final MandatePayee component18() {
        return this.payee;
    }

    public final String component19() {
        return this.category;
    }

    public final String component2() {
        return this.umn;
    }

    public final String component20() {
        return this.rrn;
    }

    public final String component21() {
        return this.state;
    }

    public final String component22() {
        return this.stateMessage;
    }

    public final String component23() {
        return this.txnId;
    }

    public final String component24() {
        return this.qrData;
    }

    public final String component25() {
        return this.narration;
    }

    public final String component26() {
        return this.narrationDirection;
    }

    public final String component27() {
        return this.recurrenceType;
    }

    public final String component28() {
        return this.recurrenceRule;
    }

    public final String component29() {
        return this.lastAmount;
    }

    public final String component3() {
        return this.mandateName;
    }

    public final String component30() {
        return this.type;
    }

    public final String component31() {
        return this.purpose;
    }

    public final String component4() {
        return this.note;
    }

    public final String component5() {
        return this.amount;
    }

    public final String component6() {
        return this.createdDate;
    }

    public final String component7() {
        return this.validityStartDate;
    }

    public final String component8() {
        return this.validityEndDate;
    }

    public final Boolean component9() {
        return this.updatedApprovalRequest;
    }

    public final MandateItem copy(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, Boolean bool, String str9, String str10, String str11, String str12, String str13, String str14, String str15, MandatePayer mandatePayer, MandatePayee mandatePayee, String str16, String str17, String str18, String str19, String str20, String str21, String str22, String str23, String str24, String str25, String str26, String str27, String str28) {
        String str29 = str;
        k.c(str2, "umn");
        k.c(mandatePayer, "payer");
        k.c(mandatePayee, "payee");
        k.c(str20, "txnId");
        k.c(str27, "type");
        return new MandateItem(str, str2, str3, str4, str5, str6, str7, str8, bool, str9, str10, str11, str12, str13, str14, str15, mandatePayer, mandatePayee, str16, str17, str18, str19, str20, str21, str22, str23, str24, str25, str26, str27, str28);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MandateItem)) {
            return false;
        }
        MandateItem mandateItem = (MandateItem) obj;
        return k.a((Object) this.accRefId, (Object) mandateItem.accRefId) && k.a((Object) this.umn, (Object) mandateItem.umn) && k.a((Object) this.mandateName, (Object) mandateItem.mandateName) && k.a((Object) this.note, (Object) mandateItem.note) && k.a((Object) this.amount, (Object) mandateItem.amount) && k.a((Object) this.createdDate, (Object) mandateItem.createdDate) && k.a((Object) this.validityStartDate, (Object) mandateItem.validityStartDate) && k.a((Object) this.validityEndDate, (Object) mandateItem.validityEndDate) && k.a((Object) this.updatedApprovalRequest, (Object) mandateItem.updatedApprovalRequest) && k.a((Object) this.mandateApprovalExpireOn, (Object) mandateItem.mandateApprovalExpireOn) && k.a((Object) this.modifyAllowed, (Object) mandateItem.modifyAllowed) && k.a((Object) this.revokeAllowed, (Object) mandateItem.revokeAllowed) && k.a((Object) this.refUrl, (Object) mandateItem.refUrl) && k.a((Object) this.refCategory, (Object) mandateItem.refCategory) && k.a((Object) this.recurrence, (Object) mandateItem.recurrence) && k.a((Object) this.amountRule, (Object) mandateItem.amountRule) && k.a((Object) this.payer, (Object) mandateItem.payer) && k.a((Object) this.payee, (Object) mandateItem.payee) && k.a((Object) this.category, (Object) mandateItem.category) && k.a((Object) this.rrn, (Object) mandateItem.rrn) && k.a((Object) this.state, (Object) mandateItem.state) && k.a((Object) this.stateMessage, (Object) mandateItem.stateMessage) && k.a((Object) this.txnId, (Object) mandateItem.txnId) && k.a((Object) this.qrData, (Object) mandateItem.qrData) && k.a((Object) this.narration, (Object) mandateItem.narration) && k.a((Object) this.narrationDirection, (Object) mandateItem.narrationDirection) && k.a((Object) this.recurrenceType, (Object) mandateItem.recurrenceType) && k.a((Object) this.recurrenceRule, (Object) mandateItem.recurrenceRule) && k.a((Object) this.lastAmount, (Object) mandateItem.lastAmount) && k.a((Object) this.type, (Object) mandateItem.type) && k.a((Object) this.purpose, (Object) mandateItem.purpose);
    }

    public final int hashCode() {
        String str = this.accRefId;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.umn;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.mandateName;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.note;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.amount;
        int hashCode5 = (hashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String str6 = this.createdDate;
        int hashCode6 = (hashCode5 + (str6 != null ? str6.hashCode() : 0)) * 31;
        String str7 = this.validityStartDate;
        int hashCode7 = (hashCode6 + (str7 != null ? str7.hashCode() : 0)) * 31;
        String str8 = this.validityEndDate;
        int hashCode8 = (hashCode7 + (str8 != null ? str8.hashCode() : 0)) * 31;
        Boolean bool = this.updatedApprovalRequest;
        int hashCode9 = (hashCode8 + (bool != null ? bool.hashCode() : 0)) * 31;
        String str9 = this.mandateApprovalExpireOn;
        int hashCode10 = (hashCode9 + (str9 != null ? str9.hashCode() : 0)) * 31;
        String str10 = this.modifyAllowed;
        int hashCode11 = (hashCode10 + (str10 != null ? str10.hashCode() : 0)) * 31;
        String str11 = this.revokeAllowed;
        int hashCode12 = (hashCode11 + (str11 != null ? str11.hashCode() : 0)) * 31;
        String str12 = this.refUrl;
        int hashCode13 = (hashCode12 + (str12 != null ? str12.hashCode() : 0)) * 31;
        String str13 = this.refCategory;
        int hashCode14 = (hashCode13 + (str13 != null ? str13.hashCode() : 0)) * 31;
        String str14 = this.recurrence;
        int hashCode15 = (hashCode14 + (str14 != null ? str14.hashCode() : 0)) * 31;
        String str15 = this.amountRule;
        int hashCode16 = (hashCode15 + (str15 != null ? str15.hashCode() : 0)) * 31;
        MandatePayer mandatePayer = this.payer;
        int hashCode17 = (hashCode16 + (mandatePayer != null ? mandatePayer.hashCode() : 0)) * 31;
        MandatePayee mandatePayee = this.payee;
        int hashCode18 = (hashCode17 + (mandatePayee != null ? mandatePayee.hashCode() : 0)) * 31;
        String str16 = this.category;
        int hashCode19 = (hashCode18 + (str16 != null ? str16.hashCode() : 0)) * 31;
        String str17 = this.rrn;
        int hashCode20 = (hashCode19 + (str17 != null ? str17.hashCode() : 0)) * 31;
        String str18 = this.state;
        int hashCode21 = (hashCode20 + (str18 != null ? str18.hashCode() : 0)) * 31;
        String str19 = this.stateMessage;
        int hashCode22 = (hashCode21 + (str19 != null ? str19.hashCode() : 0)) * 31;
        String str20 = this.txnId;
        int hashCode23 = (hashCode22 + (str20 != null ? str20.hashCode() : 0)) * 31;
        String str21 = this.qrData;
        int hashCode24 = (hashCode23 + (str21 != null ? str21.hashCode() : 0)) * 31;
        String str22 = this.narration;
        int hashCode25 = (hashCode24 + (str22 != null ? str22.hashCode() : 0)) * 31;
        String str23 = this.narrationDirection;
        int hashCode26 = (hashCode25 + (str23 != null ? str23.hashCode() : 0)) * 31;
        String str24 = this.recurrenceType;
        int hashCode27 = (hashCode26 + (str24 != null ? str24.hashCode() : 0)) * 31;
        String str25 = this.recurrenceRule;
        int hashCode28 = (hashCode27 + (str25 != null ? str25.hashCode() : 0)) * 31;
        String str26 = this.lastAmount;
        int hashCode29 = (hashCode28 + (str26 != null ? str26.hashCode() : 0)) * 31;
        String str27 = this.type;
        int hashCode30 = (hashCode29 + (str27 != null ? str27.hashCode() : 0)) * 31;
        String str28 = this.purpose;
        if (str28 != null) {
            i2 = str28.hashCode();
        }
        return hashCode30 + i2;
    }

    public final String toString() {
        return "MandateItem(accRefId=" + this.accRefId + ", umn=" + this.umn + ", mandateName=" + this.mandateName + ", note=" + this.note + ", amount=" + this.amount + ", createdDate=" + this.createdDate + ", validityStartDate=" + this.validityStartDate + ", validityEndDate=" + this.validityEndDate + ", updatedApprovalRequest=" + this.updatedApprovalRequest + ", mandateApprovalExpireOn=" + this.mandateApprovalExpireOn + ", modifyAllowed=" + this.modifyAllowed + ", revokeAllowed=" + this.revokeAllowed + ", refUrl=" + this.refUrl + ", refCategory=" + this.refCategory + ", recurrence=" + this.recurrence + ", amountRule=" + this.amountRule + ", payer=" + this.payer + ", payee=" + this.payee + ", category=" + this.category + ", rrn=" + this.rrn + ", state=" + this.state + ", stateMessage=" + this.stateMessage + ", txnId=" + this.txnId + ", qrData=" + this.qrData + ", narration=" + this.narration + ", narrationDirection=" + this.narrationDirection + ", recurrenceType=" + this.recurrenceType + ", recurrenceRule=" + this.recurrenceRule + ", lastAmount=" + this.lastAmount + ", type=" + this.type + ", purpose=" + this.purpose + ")";
    }

    public MandateItem(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, Boolean bool, String str9, String str10, String str11, String str12, String str13, String str14, String str15, MandatePayer mandatePayer, MandatePayee mandatePayee, String str16, String str17, String str18, String str19, String str20, String str21, String str22, String str23, String str24, String str25, String str26, String str27, String str28) {
        MandatePayer mandatePayer2 = mandatePayer;
        MandatePayee mandatePayee2 = mandatePayee;
        String str29 = str20;
        String str30 = str27;
        k.c(str2, "umn");
        k.c(mandatePayer2, "payer");
        k.c(mandatePayee2, "payee");
        k.c(str29, "txnId");
        k.c(str30, "type");
        this.accRefId = str;
        this.umn = str2;
        this.mandateName = str3;
        this.note = str4;
        this.amount = str5;
        this.createdDate = str6;
        this.validityStartDate = str7;
        this.validityEndDate = str8;
        this.updatedApprovalRequest = bool;
        this.mandateApprovalExpireOn = str9;
        this.modifyAllowed = str10;
        this.revokeAllowed = str11;
        this.refUrl = str12;
        this.refCategory = str13;
        this.recurrence = str14;
        this.amountRule = str15;
        this.payer = mandatePayer2;
        this.payee = mandatePayee2;
        this.category = str16;
        this.rrn = str17;
        this.state = str18;
        this.stateMessage = str19;
        this.txnId = str29;
        this.qrData = str21;
        this.narration = str22;
        this.narrationDirection = str23;
        this.recurrenceType = str24;
        this.recurrenceRule = str25;
        this.lastAmount = str26;
        this.type = str30;
        this.purpose = str28;
    }

    public final String getAccRefId() {
        return this.accRefId;
    }

    public final void setAccRefId(String str) {
        this.accRefId = str;
    }

    public final String getUmn() {
        return this.umn;
    }

    public final String getMandateName() {
        return this.mandateName;
    }

    public final String getNote() {
        return this.note;
    }

    public final String getAmount() {
        return this.amount;
    }

    public final String getCreatedDate() {
        return this.createdDate;
    }

    public final String getValidityStartDate() {
        return this.validityStartDate;
    }

    public final void setValidityStartDate(String str) {
        this.validityStartDate = str;
    }

    public final String getValidityEndDate() {
        return this.validityEndDate;
    }

    public final void setValidityEndDate(String str) {
        this.validityEndDate = str;
    }

    public final Boolean getUpdatedApprovalRequest() {
        return this.updatedApprovalRequest;
    }

    public final String getMandateApprovalExpireOn() {
        return this.mandateApprovalExpireOn;
    }

    public final String getModifyAllowed() {
        return this.modifyAllowed;
    }

    public final String getRevokeAllowed() {
        return this.revokeAllowed;
    }

    public final String getRefUrl() {
        return this.refUrl;
    }

    public final String getRefCategory() {
        return this.refCategory;
    }

    public final String getRecurrence() {
        return this.recurrence;
    }

    public final String getAmountRule() {
        return this.amountRule;
    }

    public final MandatePayer getPayer() {
        return this.payer;
    }

    public final MandatePayee getPayee() {
        return this.payee;
    }

    public final String getCategory() {
        return this.category;
    }

    public final String getRrn() {
        return this.rrn;
    }

    public final String getState() {
        return this.state;
    }

    public final String getStateMessage() {
        return this.stateMessage;
    }

    public final String getTxnId() {
        return this.txnId;
    }

    public final String getQrData() {
        return this.qrData;
    }

    public final String getNarration() {
        return this.narration;
    }

    public final String getNarrationDirection() {
        return this.narrationDirection;
    }

    public final String getRecurrenceType() {
        return this.recurrenceType;
    }

    public final String getRecurrenceRule() {
        return this.recurrenceRule;
    }

    public final String getLastAmount() {
        return this.lastAmount;
    }

    public final String getType() {
        return this.type;
    }

    public final String getPurpose() {
        return this.purpose;
    }

    public final String getBankFilterType() {
        return getMandateTransactionType().getBankFilterType();
    }

    public final m getMandateTransactionType() {
        a aVar = a.f67112a;
        return a.a(this.recurrence, this.payee.getMcc(), this.purpose);
    }
}
