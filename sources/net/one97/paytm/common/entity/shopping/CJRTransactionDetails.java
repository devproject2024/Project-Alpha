package net.one97.paytm.common.entity.shopping;

import com.google.gsonhtcfix.a.b;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRTransactionDetails implements IJRDataModel {
    @b(a = "amount")
    private double amount;
    private String cardScheme;
    private String issuingBankName;
    private String maskedBankAccountNumber;
    private String maskedCardNumber;
    private String maskedVpa;
    @b(a = "message")
    private String message;
    private String payMethod;
    @b(a = "payment_mode")
    private String payment_mode;
    private String refundAmount;
    private String refundType;
    private String rrn;
    private String userCreditExpectedDate;
    private String userMobileNo;

    public String getPayment_mode() {
        return this.payment_mode;
    }

    public double getAmount() {
        return this.amount;
    }

    public String getMessage() {
        return this.message;
    }

    public String getReferenceNumber() {
        return this.rrn;
    }

    public String getIssuingBankName() {
        return this.issuingBankName;
    }

    public String getUserCreditExpectedDate() {
        return this.userCreditExpectedDate;
    }

    public String getMaskedCardNumber() {
        return this.maskedCardNumber;
    }

    public String getCardScheme() {
        return this.cardScheme;
    }

    public String getRefundType() {
        return this.refundType;
    }

    public String getUserMobileNo() {
        return this.userMobileNo;
    }

    public String getMaskedVPA() {
        return this.maskedVpa;
    }

    public String getMaskedBankAccountNumber() {
        return this.maskedBankAccountNumber;
    }

    public String getPayMethod() {
        return this.payMethod;
    }

    public String getRefundAmount() {
        return this.refundAmount;
    }
}
