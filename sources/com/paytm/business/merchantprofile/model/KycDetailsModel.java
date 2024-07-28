package com.paytm.business.merchantprofile.model;

import com.google.gson.a.c;

public class KycDetailsModel extends EncryptedBaseModel {
    public static final long serialVersionUID = 1;
    @c(a = "bankAccountNo")
    public String bankAccountNo;
    @c(a = "gstin")
    public String gstin;
    @c(a = "ifscCode")
    public String ifscCode;
    @c(a = "panNo")
    public String panNo;
    public String signatoryName;

    public String getSignatoryName() {
        return this.signatoryName;
    }

    public void setSignatoryName(String str) {
        this.signatoryName = str;
    }

    public String getPanNo() {
        return this.panNo;
    }

    public String getBankAccountNo() {
        return this.bankAccountNo;
    }

    public String getIfscCode() {
        return this.ifscCode;
    }

    public String getGstin() {
        return this.gstin;
    }

    public void setPanNo(String str) {
        this.panNo = str;
    }

    public void setBankAccountNo(String str) {
        this.bankAccountNo = str;
    }

    public void setIfscCode(String str) {
        this.ifscCode = str;
    }

    public void setGstin(String str) {
        this.gstin = str;
    }

    public void encryptData() {
        setBankAccountNo(AESSecurityUtil.encrypt(getBankAccountNo()));
        setGstin(AESSecurityUtil.encrypt(getGstin()));
        setIfscCode(AESSecurityUtil.encrypt(getIfscCode()));
        setPanNo(AESSecurityUtil.encrypt(getPanNo()));
        setSignatoryName(AESSecurityUtil.encrypt(getSignatoryName()));
    }

    public void decryptData() {
        setBankAccountNo(AESSecurityUtil.decrypt(getBankAccountNo()));
        setGstin(AESSecurityUtil.decrypt(getGstin()));
        setIfscCode(AESSecurityUtil.decrypt(getIfscCode()));
        setPanNo(AESSecurityUtil.decrypt(getPanNo()));
        setSignatoryName(AESSecurityUtil.decrypt(getSignatoryName()));
    }
}
