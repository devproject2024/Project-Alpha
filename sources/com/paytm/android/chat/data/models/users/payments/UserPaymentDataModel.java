package com.paytm.android.chat.data.models.users.payments;

import com.google.gsonhtcfix.a.a;
import com.google.gsonhtcfix.a.b;

public final class UserPaymentDataModel {
    @a
    @b(a = "accRefId")
    private String accRefId;
    @a
    @b(a = "account")
    private String account;
    @a
    @b(a = "accountMobile")
    private String accountMobile;
    @a
    @b(a = "accountName")
    private String accountName;
    @a
    @b(a = "app")
    private String app;
    @a
    @b(a = "bankLogoUrl")
    private String bankLogoUrl;
    @a
    @b(a = "bankName")
    private String bankName;
    @a
    @b(a = "identifier")
    private String identifier;
    @a
    @b(a = "ifsc")
    private String ifsc;
    @a
    @b(a = "isVerifiedMerchant")
    private Boolean isVerifiedMerchant;
    @a
    @b(a = "lang")
    private String lang;
    @a
    @b(a = "maskedAccNo")
    private String maskedAccNo;
    @a
    @b(a = "mid")
    private String mid;
    @a
    @b(a = "mobileNumber")
    private String mobileNumber;
    @a
    @b(a = "name")
    private String name;
    @a
    @b(a = "source")
    private String source;
    @a
    @b(a = "ssoToken")
    private String ssoToken;
    @a
    @b(a = "txnCategory")
    private String txnCategory;
    @a
    @b(a = "type")
    private String type;
    @a
    @b(a = "userType")
    private String userType;
    @a
    @b(a = "vpa")
    private String vpa;

    public final String getLang() {
        return this.lang;
    }

    public final void setLang(String str) {
        this.lang = str;
    }

    public final String getAccount() {
        return this.account;
    }

    public final void setAccount(String str) {
        this.account = str;
    }

    public final String getAccountName() {
        return this.accountName;
    }

    public final void setAccountName(String str) {
        this.accountName = str;
    }

    public final String getAccountMobile() {
        return this.accountMobile;
    }

    public final void setAccountMobile(String str) {
        this.accountMobile = str;
    }

    public final String getApp() {
        return this.app;
    }

    public final void setApp(String str) {
        this.app = str;
    }

    public final String getSource() {
        return this.source;
    }

    public final void setSource(String str) {
        this.source = str;
    }

    public final String getSsoToken() {
        return this.ssoToken;
    }

    public final void setSsoToken(String str) {
        this.ssoToken = str;
    }

    public final String getUserType() {
        return this.userType;
    }

    public final void setUserType(String str) {
        this.userType = str;
    }

    public final String getType() {
        return this.type;
    }

    public final void setType(String str) {
        this.type = str;
    }

    public final String getIdentifier() {
        return this.identifier;
    }

    public final void setIdentifier(String str) {
        this.identifier = str;
    }

    public final String getName() {
        return this.name;
    }

    public final void setName(String str) {
        this.name = str;
    }

    public final String getMobileNumber() {
        return this.mobileNumber;
    }

    public final void setMobileNumber(String str) {
        this.mobileNumber = str;
    }

    public final String getBankName() {
        return this.bankName;
    }

    public final void setBankName(String str) {
        this.bankName = str;
    }

    public final String getMaskedAccNo() {
        return this.maskedAccNo;
    }

    public final void setMaskedAccNo(String str) {
        this.maskedAccNo = str;
    }

    public final String getBankLogoUrl() {
        return this.bankLogoUrl;
    }

    public final void setBankLogoUrl(String str) {
        this.bankLogoUrl = str;
    }

    public final String getAccRefId() {
        return this.accRefId;
    }

    public final void setAccRefId(String str) {
        this.accRefId = str;
    }

    public final String getIfsc() {
        return this.ifsc;
    }

    public final void setIfsc(String str) {
        this.ifsc = str;
    }

    public final String getVpa() {
        return this.vpa;
    }

    public final void setVpa(String str) {
        this.vpa = str;
    }

    public final String getMid() {
        return this.mid;
    }

    public final void setMid(String str) {
        this.mid = str;
    }

    public final Boolean isVerifiedMerchant() {
        return this.isVerifiedMerchant;
    }

    public final void setVerifiedMerchant(Boolean bool) {
        this.isVerifiedMerchant = bool;
    }

    public final String getTxnCategory() {
        return this.txnCategory;
    }

    public final void setTxnCategory(String str) {
        this.txnCategory = str;
    }
}
