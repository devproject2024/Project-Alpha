package net.one97.paytm.nativesdk.instruments.upicollect.models;

public class Body {
    private String accountNumber;
    private String aggMid;
    private String allowUnverifiedAccount;
    private String channelId;
    private ExtendInfo extendInfo;
    private String mid;
    private String orderId;
    private String paymentFlow;
    private String paymentMode;
    private String refUrl;
    private String requestType;
    private String txnNote;
    private String txnToken;
    private String validateAccountNumber;

    public String getMid() {
        return this.mid;
    }

    public void setMid(String str) {
        this.mid = str;
    }

    public String getOrderId() {
        return this.orderId;
    }

    public void setOrderId(String str) {
        this.orderId = str;
    }

    public String getTxnToken() {
        return this.txnToken;
    }

    public void setTxnToken(String str) {
        this.txnToken = str;
    }

    public String getChannelId() {
        return this.channelId;
    }

    public void setChannelId(String str) {
        this.channelId = str;
    }

    public String getAggMid() {
        return this.aggMid;
    }

    public void setAggMid(String str) {
        this.aggMid = str;
    }

    public String getAccount_number() {
        return this.accountNumber;
    }

    public void setAccount_number(String str) {
        this.accountNumber = str;
    }

    public String getValidateAccountNumber() {
        return this.validateAccountNumber;
    }

    public void setValidateAccountNumber(String str) {
        this.validateAccountNumber = str;
    }

    public String getAllowUnverifiedAccount() {
        return this.allowUnverifiedAccount;
    }

    public void setAllowUnverifiedAccount(String str) {
        this.allowUnverifiedAccount = str;
    }

    public String getRefUrl() {
        return this.refUrl;
    }

    public void setRefUrl(String str) {
        this.refUrl = str;
    }

    public String getTxnNote() {
        return this.txnNote;
    }

    public void setTxnNote(String str) {
        this.txnNote = str;
    }

    public String getAccountNumber() {
        return this.accountNumber;
    }

    public void setAccountNumber(String str) {
        this.accountNumber = str;
    }

    public String getRequestType() {
        return this.requestType;
    }

    public void setRequestType(String str) {
        this.requestType = str;
    }

    public String getPaymentMode() {
        return this.paymentMode;
    }

    public void setPaymentMode(String str) {
        this.paymentMode = str;
    }

    public String getPaymentFlow() {
        return this.paymentFlow;
    }

    public void setPaymentFlow(String str) {
        this.paymentFlow = str;
    }

    public ExtendInfo getExtendInfo() {
        return this.extendInfo;
    }

    public void setExtendInfo(ExtendInfo extendInfo2) {
        this.extendInfo = extendInfo2;
    }
}
