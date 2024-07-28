package com.business.merchant_payments.payment.model.orderDetail;

import com.google.gson.a.a;
import com.google.gson.a.c;
import java.io.Serializable;

public final class AdditionalInfo implements Serializable {
    @c(a = "cancelRequestType")
    @a
    public String cancelRequestType;
    @c(a = "comment")
    @a
    public String comment;
    @c(a = "customerName")
    @a
    public String customerName;
    @c(a = "maskedCardNo")
    @a
    public String maskedCardNo;
    @c(a = "payMethod")
    @a
    public final String payMethod;
    @c(a = "payMethodIconUrl")
    @a
    public String payMethodIconUrl;
    @c(a = "paytmUserId")
    @a
    public String paytmUserId;
    @c(a = "splitAmount")
    @a
    public SplitAmount splitAmount;
    @c(a = "txnAmount")
    @a
    public TxnAmount txnAmount;
    @c(a = "userEmail")
    @a
    public String userEmail;
    @c(a = "userMobile")
    @a
    public String userMobile;
    @c(a = "virtualPaymentAddr")
    @a
    public String virtualPaymentAddr;

    public final String getCancelRequestType() {
        return this.cancelRequestType;
    }

    public final void setCancelRequestType(String str) {
        this.cancelRequestType = str;
    }

    public final String getPaytmUserId() {
        return this.paytmUserId;
    }

    public final void setPaytmUserId(String str) {
        this.paytmUserId = str;
    }

    public final String getUserMobile() {
        return this.userMobile;
    }

    public final void setUserMobile(String str) {
        this.userMobile = str;
    }

    public final String getVirtualPaymentAddr() {
        return this.virtualPaymentAddr;
    }

    public final void setVirtualPaymentAddr(String str) {
        this.virtualPaymentAddr = str;
    }

    public final SplitAmount getSplitAmount() {
        return this.splitAmount;
    }

    public final void setSplitAmount(SplitAmount splitAmount2) {
        this.splitAmount = splitAmount2;
    }

    public final TxnAmount getTxnAmount() {
        return this.txnAmount;
    }

    public final void setTxnAmount(TxnAmount txnAmount2) {
        this.txnAmount = txnAmount2;
    }

    public final String getComment() {
        return this.comment;
    }

    public final void setComment(String str) {
        this.comment = str;
    }

    public final String getPayMethod() {
        return this.payMethod;
    }

    public final String getMaskedCardNo() {
        return this.maskedCardNo;
    }

    public final void setMaskedCardNo(String str) {
        this.maskedCardNo = str;
    }

    public final String getCustomerName() {
        return this.customerName;
    }

    public final void setCustomerName(String str) {
        this.customerName = str;
    }

    public final String getPayMethodIconUrl() {
        return this.payMethodIconUrl;
    }

    public final void setPayMethodIconUrl(String str) {
        this.payMethodIconUrl = str;
    }

    public final String getUserEmail() {
        return this.userEmail;
    }

    public final void setUserEmail(String str) {
        this.userEmail = str;
    }
}
