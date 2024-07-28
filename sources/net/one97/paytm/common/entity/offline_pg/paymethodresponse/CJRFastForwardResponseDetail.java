package net.one97.paytm.common.entity.offline_pg.paymethodresponse;

import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.common.entity.offline_pg.MerchantInfo;

public class CJRFastForwardResponseDetail implements IJRDataModel {
    public static final String MERCHANT_VELOCITY_BREACH = "MERCHANT_VELOCITY_LIMIT_BREACH";
    public static final String STATUS_FAILURE = "TXN_FAILURE";
    public static final String STATUS_PENDING = "PENDING";
    public static final String STATUS_SUCCESS = "TXN_SUCCESS";
    public static final String STATUS_TXN_PENDING = "TXN_PENDING";
    String bankName;
    String custId;
    MerchantInfo merchantInfo;
    String orderId;
    String paymentMode;
    String prn;
    ResultInfo resultInfo;
    String signature;
    String txnAmount;
    String txnId;

    public MerchantInfo getMerchantInfo() {
        return this.merchantInfo;
    }

    public void setMerchantInfo(MerchantInfo merchantInfo2) {
        this.merchantInfo = merchantInfo2;
    }

    public void setPrn(String str) {
        this.prn = str;
    }

    public ResultInfo getResultInfo() {
        return this.resultInfo;
    }

    public void setResultInfo(ResultInfo resultInfo2) {
        this.resultInfo = resultInfo2;
    }

    public String getSignature() {
        return this.signature;
    }

    public void setSignature(String str) {
        this.signature = str;
    }

    public String getTxnId() {
        return this.txnId;
    }

    public void setTxnId(String str) {
        this.txnId = str;
    }

    public String getOrderId() {
        return this.orderId;
    }

    public void setOrderId(String str) {
        this.orderId = str;
    }

    public String getTxnAmount() {
        return this.txnAmount;
    }

    public void setTxnAmount(String str) {
        this.txnAmount = str;
    }

    public String getPaymentMode() {
        return this.paymentMode;
    }

    public void setPaymentMode(String str) {
        this.paymentMode = str;
    }

    public String getBankName() {
        return this.bankName;
    }

    public void setBankName(String str) {
        this.bankName = str;
    }

    public String getCustId() {
        return this.custId;
    }

    public void setCustId(String str) {
        this.custId = str;
    }

    public String getPrn() {
        return this.prn;
    }
}
