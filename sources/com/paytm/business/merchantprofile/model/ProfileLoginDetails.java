package com.paytm.business.merchantprofile.model;

import com.google.gson.a.c;

public class ProfileLoginDetails extends EncryptedBaseModel {
    public static final long serialVersionUID = 1;
    @c(a = "accountPrimary")
    public String accountPrimary;
    @c(a = "email")
    public String email;
    @c(a = "mobile")
    public String mobile;

    public void setAccountPrimary(String str) {
        this.accountPrimary = str;
    }

    public void setMobile(String str) {
        this.mobile = str;
    }

    public void setEmail(String str) {
        this.email = str;
    }

    public String getAccountPrimary() {
        return this.accountPrimary;
    }

    public String getMobile() {
        return this.mobile;
    }

    public String getEmail() {
        return this.email;
    }

    public String toString() {
        return "ProfileLoginDetails{accountPrimary = '" + this.accountPrimary + '\'' + ",mobile = '" + this.mobile + '\'' + ",email = '" + this.email + '\'' + "}";
    }

    public void encryptData() {
        setAccountPrimary(AESSecurityUtil.encrypt(getAccountPrimary()));
        setEmail(AESSecurityUtil.encrypt(getEmail()));
        setMobile(AESSecurityUtil.encrypt(getMobile()));
    }

    public void decryptData() {
        setAccountPrimary(AESSecurityUtil.decrypt(getAccountPrimary()));
        setEmail(AESSecurityUtil.decrypt(getEmail()));
        setMobile(AESSecurityUtil.decrypt(getMobile()));
    }
}
