package net.one97.paytm.common.entity.wallet.edcreceipt;

import net.one97.paytm.common.entity.IJRDataModel;

public class EDCReceiptResponseDataModel implements IJRDataModel {
    private String acquiringBank;
    private String aid;
    private String amount;
    private String apprCode;
    private String cardHolderName;
    private String cardNumber;
    private String cardType;
    private String cardTypeImage;
    private String city;
    private String date;
    private String merImage;
    private String merchantName;
    private String mid;
    private String payMode;
    private String receipturl;
    private String referenceNumber;
    private String resultCode;
    private String resultMsg;
    private String resultStatus;
    private String tid;
    private String txnId;
    private String txnType;

    public String getReceipturl() {
        return this.receipturl;
    }

    public void setReceipturl(String str) {
        this.receipturl = str;
    }

    public String getResultStatus() {
        return this.resultStatus;
    }

    public void setResultStatus(String str) {
        this.resultStatus = str;
    }

    public String getResultCode() {
        return this.resultCode;
    }

    public void setResultCode(String str) {
        this.resultCode = str;
    }

    public String getResultMsg() {
        return this.resultMsg;
    }

    public void setResultMsg(String str) {
        this.resultMsg = str;
    }

    public String getDate() {
        return this.date;
    }

    public void setDate(String str) {
        this.date = str;
    }

    public String getAmount() {
        return this.amount;
    }

    public void setAmount(String str) {
        this.amount = str;
    }

    public String getReferenceNumber() {
        return this.referenceNumber;
    }

    public void setReferenceNumber(String str) {
        this.referenceNumber = str;
    }

    public String getTxnId() {
        return this.txnId;
    }

    public void setTxnId(String str) {
        this.txnId = str;
    }

    public String getMid() {
        return this.mid;
    }

    public void setMid(String str) {
        this.mid = str;
    }

    public String getMerchantName() {
        return this.merchantName;
    }

    public void setMerchantName(String str) {
        this.merchantName = str;
    }

    public String getTid() {
        return this.tid;
    }

    public void setTid(String str) {
        this.tid = str;
    }

    public String getAid() {
        return this.aid;
    }

    public void setAid(String str) {
        this.aid = str;
    }

    public String getApprCode() {
        return this.apprCode;
    }

    public void setApprCode(String str) {
        this.apprCode = str;
    }

    public String getCardNumber() {
        return this.cardNumber;
    }

    public void setCardNumber(String str) {
        this.cardNumber = str;
    }

    public String getAcquiringBank() {
        return this.acquiringBank;
    }

    public void setAcquiringBank(String str) {
        this.acquiringBank = str;
    }

    public String getCity() {
        return this.city;
    }

    public void setCity(String str) {
        this.city = str;
    }

    public String getCardType() {
        return this.cardType;
    }

    public void setCardType(String str) {
        this.cardType = str;
    }

    public String getCardTypeImage() {
        return this.cardTypeImage;
    }

    public void setCardTypeImage(String str) {
        this.cardTypeImage = str;
    }

    public String getMerImage() {
        return this.merImage;
    }

    public void setMerImage(String str) {
        this.merImage = str;
    }

    public String getCardHolderName() {
        return this.cardHolderName;
    }

    public String getPayMode() {
        return this.payMode;
    }

    public String getTxnType() {
        return this.txnType;
    }
}
