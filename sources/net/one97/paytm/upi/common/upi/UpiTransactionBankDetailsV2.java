package net.one97.paytm.upi.common.upi;

import com.google.gson.a.c;
import net.one97.paytm.upi.common.UpiBaseDataModel;

public class UpiTransactionBankDetailsV2 implements UpiBaseDataModel {
    @c(a = "bankAccount")
    private String mBankAccount;
    @c(a = "bankName")
    private String mBankName;
    @c(a = "ifsc")
    private String mIfsc;
    @c(a = "imageUrl")
    private String mImageUrl;
    @c(a = "mobile")
    private String mMobile;
    @c(a = "name")
    private String mName;
    @c(a = "oauthCustId")
    private String mOauthCustId;
    @c(a = "userId")
    private String mUserId;
    @c(a = "vpa")
    private String mVpa;

    public UpiTransactionBankDetailsV2() {
    }

    public UpiTransactionBankDetailsV2(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9) {
        this.mUserId = str;
        this.mOauthCustId = str2;
        this.mName = str3;
        this.mBankAccount = str4;
        this.mIfsc = str5;
        this.mBankName = str6;
        this.mMobile = str7;
        this.mImageUrl = str8;
        this.mVpa = str9;
    }

    public String getmUserId() {
        return this.mUserId;
    }

    public void setmUserId(String str) {
        this.mUserId = str;
    }

    public String getmOauthCustId() {
        return this.mOauthCustId;
    }

    public void setmOauthCustId(String str) {
        this.mOauthCustId = str;
    }

    public String getmName() {
        return this.mName;
    }

    public void setmName(String str) {
        this.mName = str;
    }

    public String getmBankAccount() {
        return this.mBankAccount;
    }

    public void setmBankAccount(String str) {
        this.mBankAccount = str;
    }

    public String getmIfsc() {
        return this.mIfsc;
    }

    public void setmIfsc(String str) {
        this.mIfsc = str;
    }

    public String getmBankName() {
        return this.mBankName;
    }

    public void setmBankName(String str) {
        this.mBankName = str;
    }

    public String getmMobile() {
        return this.mMobile;
    }

    public void setmMobile(String str) {
        this.mMobile = str;
    }

    public String getmImageUrl() {
        return this.mImageUrl;
    }

    public void setmImageUrl(String str) {
        this.mImageUrl = str;
    }

    public String getmVpa() {
        return this.mVpa;
    }

    public void setmVpa(String str) {
        this.mVpa = str;
    }
}
