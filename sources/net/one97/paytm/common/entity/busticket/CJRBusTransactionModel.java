package net.one97.paytm.common.entity.busticket;

import com.google.gsonhtcfix.a.b;
import easypay.manager.Constants;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.upi.util.UpiConstants;

public final class CJRBusTransactionModel implements IJRDataModel {
    @b(a = "amount")
    private String amount;
    @b(a = "cardScheme")
    private String cardScheme;
    @b(a = "issuingBankName")
    private String issuingBankName;
    @b(a = "maskedBankAccountNumber")
    private String maskedBankAccountNumber;
    @b(a = "maskedCardNumber")
    private String maskedCardNumber;
    @b(a = "maskedVpa")
    private String maskedVpa;
    @b(a = "message")
    private String message;
    @b(a = "payMethod")
    private String payMethod;
    @b(a = "payment_mode")
    private String paymentMode;
    @b(a = "refundAmount")
    private String refundAmount;
    @b(a = "refundType")
    private String refundType;
    @b(a = "rrn")
    private String rrn;
    @b(a = "userCreditExpectedDate")
    private String userCreditExpectedDate;
    @b(a = "userMobileNo")
    private String userMobileNo;

    public CJRBusTransactionModel(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14) {
        k.c(str, "amount");
        k.c(str2, "message");
        k.c(str3, "paymentMode");
        k.c(str4, UpiConstants.EXTRA_RRN);
        k.c(str5, "issuingBankName");
        k.c(str6, "userCreditExpectedDate");
        k.c(str7, "maskedCardNumber");
        k.c(str8, Constants.EXTRA_BANK_SCHEME);
        k.c(str9, "refundType");
        k.c(str10, "userMobileNo");
        k.c(str11, "maskedVpa");
        k.c(str12, "maskedBankAccountNumber");
        k.c(str13, SDKConstants.PAY_METHOD);
        k.c(str14, "refundAmount");
        this.amount = str;
        this.message = str2;
        this.paymentMode = str3;
        this.rrn = str4;
        this.issuingBankName = str5;
        this.userCreditExpectedDate = str6;
        this.maskedCardNumber = str7;
        this.cardScheme = str8;
        this.refundType = str9;
        this.userMobileNo = str10;
        this.maskedVpa = str11;
        this.maskedBankAccountNumber = str12;
        this.payMethod = str13;
        this.refundAmount = str14;
    }

    public final String getAmount() {
        return this.amount;
    }

    public final void setAmount(String str) {
        k.c(str, "<set-?>");
        this.amount = str;
    }

    public final String getMessage() {
        return this.message;
    }

    public final void setMessage(String str) {
        k.c(str, "<set-?>");
        this.message = str;
    }

    public final String getPaymentMode() {
        return this.paymentMode;
    }

    public final void setPaymentMode(String str) {
        k.c(str, "<set-?>");
        this.paymentMode = str;
    }

    public final String getRrn() {
        return this.rrn;
    }

    public final void setRrn(String str) {
        k.c(str, "<set-?>");
        this.rrn = str;
    }

    public final String getIssuingBankName() {
        return this.issuingBankName;
    }

    public final void setIssuingBankName(String str) {
        k.c(str, "<set-?>");
        this.issuingBankName = str;
    }

    public final String getUserCreditExpectedDate() {
        return this.userCreditExpectedDate;
    }

    public final void setUserCreditExpectedDate(String str) {
        k.c(str, "<set-?>");
        this.userCreditExpectedDate = str;
    }

    public final String getMaskedCardNumber() {
        return this.maskedCardNumber;
    }

    public final void setMaskedCardNumber(String str) {
        k.c(str, "<set-?>");
        this.maskedCardNumber = str;
    }

    public final String getCardScheme() {
        return this.cardScheme;
    }

    public final void setCardScheme(String str) {
        k.c(str, "<set-?>");
        this.cardScheme = str;
    }

    public final String getRefundType() {
        return this.refundType;
    }

    public final void setRefundType(String str) {
        k.c(str, "<set-?>");
        this.refundType = str;
    }

    public final String getUserMobileNo() {
        return this.userMobileNo;
    }

    public final void setUserMobileNo(String str) {
        k.c(str, "<set-?>");
        this.userMobileNo = str;
    }

    public final String getMaskedVpa() {
        return this.maskedVpa;
    }

    public final void setMaskedVpa(String str) {
        k.c(str, "<set-?>");
        this.maskedVpa = str;
    }

    public final String getMaskedBankAccountNumber() {
        return this.maskedBankAccountNumber;
    }

    public final void setMaskedBankAccountNumber(String str) {
        k.c(str, "<set-?>");
        this.maskedBankAccountNumber = str;
    }

    public final String getPayMethod() {
        return this.payMethod;
    }

    public final void setPayMethod(String str) {
        k.c(str, "<set-?>");
        this.payMethod = str;
    }

    public final String getRefundAmount() {
        return this.refundAmount;
    }

    public final void setRefundAmount(String str) {
        k.c(str, "<set-?>");
        this.refundAmount = str;
    }
}
