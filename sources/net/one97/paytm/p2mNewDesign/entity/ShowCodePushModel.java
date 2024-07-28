package net.one97.paytm.p2mNewDesign.entity;

import net.one97.paytm.common.entity.IJRDataModel;

public class ShowCodePushModel implements IJRDataModel {
    public static final String SCPM_AMOUNT = "amount";
    public static final String SCPM_MERCHANT_LOGO_URL = "merchantLogoUrl";
    public static final String SCPM_MERCHANT_NAME = "merchantName";
    public static final String SCPM_ORDER_ID = "orderId";
    public static final String SCPM_SHOW_CONFIRMATION_SCREEN = "showConfirmationScreen";
    public static final String SCPM_STAUS = "status";
    public static final String SCPM_TIMESTAMP = "timestamp";
    public static final String SCPM_TXN_ID = "txnId";
    public String amount;
    public String merchantLogoUrl;
    public String merchantName;
    public String orderId;
    public String paymentMode;
    public String status;
    public String timeStamp;
    public String txnId;

    public String getTimeStamp() {
        return this.timeStamp;
    }

    public void setTimeStamp(String str) {
        this.timeStamp = str;
    }

    public String getAmount() {
        return this.amount;
    }

    public void setAmount(String str) {
        this.amount = str;
    }

    public String getOrderId() {
        return this.orderId;
    }

    public void setOrderId(String str) {
        this.orderId = str;
    }

    public String getTxnId() {
        return this.txnId;
    }

    public void setTxnId(String str) {
        this.txnId = str;
    }

    public String getMerchantName() {
        return this.merchantName;
    }

    public void setMerchantName(String str) {
        this.merchantName = str;
    }

    public String getMerchantLogoUrl() {
        return this.merchantLogoUrl;
    }

    public void setMerchantLogoUrl(String str) {
        this.merchantLogoUrl = str;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String str) {
        this.status = str;
    }

    public String getPaymentMode() {
        return this.paymentMode;
    }

    public void setPaymentMode(String str) {
        this.paymentMode = str;
    }
}
