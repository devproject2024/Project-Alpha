package net.one97.paytm.common.entity.offline_pg.paymethodrequest;

import java.util.HashMap;

public class CJRFastForwardRequestDetail {
    String additionalInfo;
    String appIP;
    String authMode;
    String channel;
    String currency;
    String customerId;
    String deviceId;
    HashMap<String, String> extendInfo;
    String industryType;
    String merchantUniqueReference;
    String mid;
    private String orderId;
    String paymentMode;
    private String refId;
    String reqType;
    String signature;
    String txnAmount;
    String udf1;
    String udf2;
    String udf3;

    public String getSignature() {
        return this.signature;
    }

    public void setSignature(String str) {
        this.signature = str;
    }

    public String getMid() {
        return this.mid;
    }

    public void setMid(String str) {
        this.mid = str;
    }

    public String getReqType() {
        return this.reqType;
    }

    public void setReqType(String str) {
        this.reqType = str;
    }

    public String getTxnAmount() {
        return this.txnAmount;
    }

    public void setTxnAmount(String str) {
        this.txnAmount = str;
    }

    public String getCustomerId() {
        return this.customerId;
    }

    public void setCustomerId(String str) {
        this.customerId = str;
    }

    public String getIndustryType() {
        return this.industryType;
    }

    public void setIndustryType(String str) {
        this.industryType = str;
    }

    public String getCurrency() {
        return this.currency;
    }

    public void setCurrency(String str) {
        this.currency = str;
    }

    public String getDeviceId() {
        return this.deviceId;
    }

    public void setDeviceId(String str) {
        this.deviceId = str;
    }

    public String getPaymentMode() {
        return this.paymentMode;
    }

    public void setPaymentMode(String str) {
        this.paymentMode = str;
    }

    public String getAppIP() {
        return this.appIP;
    }

    public void setAppIP(String str) {
        this.appIP = str;
    }

    public String getAuthMode() {
        return this.authMode;
    }

    public void setAuthMode(String str) {
        this.authMode = str;
    }

    public String getChannel() {
        return this.channel;
    }

    public void setChannel(String str) {
        this.channel = str;
    }

    public HashMap<String, String> getExtendInfo() {
        return this.extendInfo;
    }

    public void setExtendInfo(HashMap<String, String> hashMap) {
        this.extendInfo = hashMap;
    }

    public void setUdf1(String str) {
        this.udf1 = str;
    }

    public void setUdf2(String str) {
        this.udf2 = str;
    }

    public void setUdf3(String str) {
        this.udf3 = str;
    }

    public void setAdditionalInfo(String str) {
        this.additionalInfo = str;
    }

    public void setMerchantUniqueReference(String str) {
        this.merchantUniqueReference = str;
    }

    public void setOrderId(String str) {
        this.orderId = str;
    }

    public String getRefId() {
        return this.refId;
    }

    public void setRefId(String str) {
        this.refId = str;
    }
}
