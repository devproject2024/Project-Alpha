package com.travel.train.model.trainticket;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRTrainOrderPayment extends IJRPaytmDataModel implements IJRDataModel {
    @b(a = "amount")
    private String amount;
    @b(a = "date")
    private String date;
    @b(a = "userCreditExpectedDate")
    private String expectedDate;
    @b(a = "maskedNumber")
    private String maskedNumber;
    @b(a = "payment_status")
    private int paymentStatus;
    @b(a = "rrn")
    private String referenceNumber;
    @b(a = "show_passbook")
    private boolean showPassbook;
    @b(a = "source")
    private String source;
    @b(a = "text")
    private String text;
    @b(a = "transaction_id")
    private String transactionId;

    public int getPaymentStatus() {
        return this.paymentStatus;
    }

    public String getSource() {
        return this.source;
    }

    public String getTransactionId() {
        return this.transactionId;
    }

    public String getDate() {
        return this.date;
    }

    public String getAmount() {
        return this.amount;
    }

    public String getText() {
        return this.text;
    }

    public boolean isShowPassbook() {
        return this.showPassbook;
    }

    public String getMaskedNumber() {
        return this.maskedNumber;
    }

    public String getReferenceNumber() {
        return this.referenceNumber;
    }

    public String getExpectedDate() {
        return this.expectedDate;
    }
}
