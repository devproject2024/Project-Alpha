package net.one97.paytm.passbook.beans;

import net.one97.paytm.passbook.mapping.IJRDataModel;

public class SubWalletDetailsResponse extends IJRDataModel {
    private String balance;
    private String expiry;
    private String externalMappingId;
    private String id;
    private String ppiDetailsId;
    private String status;
    private String subWalletType;
    private SubwalletTxnInfo subwalletTxnInfo;

    public String getId() {
        return this.id;
    }

    public void setId(String str) {
        this.id = str;
    }

    public String getSubWalletType() {
        return this.subWalletType;
    }

    public void setSubWalletType(String str) {
        this.subWalletType = str;
    }

    public String getBalance() {
        return this.balance;
    }

    public void setBalance(String str) {
        this.balance = str;
    }

    public SubwalletTxnInfo getSubwalletTxnInfo() {
        return this.subwalletTxnInfo;
    }

    public void setSubwalletTxnInfo(SubwalletTxnInfo subwalletTxnInfo2) {
        this.subwalletTxnInfo = subwalletTxnInfo2;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String str) {
        this.status = str;
    }

    public String getExternalMappingId() {
        return this.externalMappingId;
    }

    public void setExternalMappingId(String str) {
        this.externalMappingId = str;
    }

    public String getPpiDetailsId() {
        return this.ppiDetailsId;
    }

    public void setPpiDetailsId(String str) {
        this.ppiDetailsId = str;
    }

    public String getExpiry() {
        return this.expiry;
    }

    public void setExpiry(String str) {
        this.expiry = str;
    }

    public String toString() {
        return "ClassPojo [id = " + this.id + ", subWalletType = " + this.subWalletType + ", balance = " + this.balance + ", subwalletTxnInfo = " + this.subwalletTxnInfo + ", status = " + this.status + ", externalMappingId = " + this.externalMappingId + ", ppiDetailsId = " + this.ppiDetailsId + ", expiry = " + this.expiry + "]";
    }
}
