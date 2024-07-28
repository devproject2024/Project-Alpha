package com.paytm.business.merchantprofile.model;

import com.google.gson.a.a;
import com.google.gson.a.c;

public class BasicDetailsModel extends EncryptedBaseModel {
    @c(a = "businessName")
    @a
    public String businessName;
    @c(a = "displayName")
    @a
    public String displayName;
    @c(a = "emailId")
    @a
    public String emailId;
    @c(a = "landlineNo")
    @a
    public Object landlineNo;
    @c(a = "mid")
    @a
    public String mid;
    @c(a = "mobileNo")
    @a
    public String mobileNo;

    public String getMid() {
        return this.mid;
    }

    public void setMid(String str) {
        this.mid = str;
    }

    public String getBusinessName() {
        return this.businessName;
    }

    public void setBusinessName(String str) {
        this.businessName = str;
    }

    public String getDisplayName() {
        return this.displayName;
    }

    public void setDisplayName(String str) {
        this.displayName = str;
    }

    public String getEmailId() {
        return this.emailId;
    }

    public void setEmailId(String str) {
        this.emailId = str;
    }

    public String getMobileNo() {
        return this.mobileNo;
    }

    public void setMobileNo(String str) {
        this.mobileNo = str;
    }

    public Object getLandlineNo() {
        return this.landlineNo;
    }

    public void setLandlineNo(Object obj) {
        this.landlineNo = obj;
    }

    public void encryptData() {
        setBusinessName(AESSecurityUtil.encrypt(getBusinessName()));
        setDisplayName(AESSecurityUtil.encrypt(getDisplayName()));
        setEmailId(AESSecurityUtil.encrypt(getEmailId()));
        setMobileNo(AESSecurityUtil.encrypt(getMobileNo()));
        setMid(AESSecurityUtil.encrypt(getMid()));
    }

    public void decryptData() {
        setBusinessName(AESSecurityUtil.decrypt(getBusinessName()));
        setDisplayName(AESSecurityUtil.decrypt(getDisplayName()));
        setEmailId(AESSecurityUtil.decrypt(getEmailId()));
        setMobileNo(AESSecurityUtil.decrypt(getMobileNo()));
        setMid(AESSecurityUtil.decrypt(getMid()));
    }
}
