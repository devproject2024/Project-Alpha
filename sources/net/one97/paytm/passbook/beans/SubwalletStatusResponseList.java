package net.one97.paytm.passbook.beans;

import net.one97.paytm.passbook.mapping.IJRDataModel;

public class SubwalletStatusResponseList extends IJRDataModel {
    private String createTimestamp;
    private String expiryTimestamp;
    private String issuerId;
    private String issuerName;
    private String issuerPhoneNo;
    private String subWalletType;
    private String txnAmount;
    private String txnId;

    public String getIssuerId() {
        return this.issuerId;
    }

    public void setIssuerId(String str) {
        this.issuerId = str;
    }

    public String getCreateTimestamp() {
        return this.createTimestamp;
    }

    public void setCreateTimestamp(String str) {
        this.createTimestamp = str;
    }

    public String getSubWalletType() {
        return this.subWalletType;
    }

    public void setSubWalletType(String str) {
        this.subWalletType = str;
    }

    public String getIssuerPhoneNo() {
        return this.issuerPhoneNo;
    }

    public void setIssuerPhoneNo(String str) {
        this.issuerPhoneNo = str;
    }

    public String getIssuerName() {
        return this.issuerName;
    }

    public void setIssuerName(String str) {
        this.issuerName = str;
    }

    public String getTxnId() {
        return this.txnId;
    }

    public void setTxnId(String str) {
        this.txnId = str;
    }

    public String getTxnAmount() {
        return this.txnAmount;
    }

    public void setTxnAmount(String str) {
        this.txnAmount = str;
    }

    public String toString() {
        return "ClassPojo [issuerId = " + this.issuerId + ", createTimestamp = " + this.createTimestamp + ", subWalletType = " + this.subWalletType + ", issuerPhoneNo = " + this.issuerPhoneNo + ", issuerName = " + this.issuerName + ", txnId = " + this.txnId + ", txnAmount = " + this.txnAmount + "]";
    }

    public String getExpiryTimestamp() {
        return this.expiryTimestamp;
    }

    public void setExpiryTimestamp(String str) {
        this.expiryTimestamp = str;
    }
}
