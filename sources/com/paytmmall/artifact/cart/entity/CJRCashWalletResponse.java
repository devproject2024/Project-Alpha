package com.paytmmall.artifact.cart.entity;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;

public class CJRCashWalletResponse extends IJRPaytmDataModel {
    private static final long serialVersionUID = 1;
    @b(a = "amount")
    private double mAmount;
    @b(a = "otherSubWalletBalance")
    private double mOtherSubWalletBalance;
    @b(a = "paytmWalletBalance")
    private double mPaytmWalletBalance;
    @b(a = "totalBalance")
    private double mTotalBalance;
    @b(a = "walletGrade")
    private String mWalletGrade;

    public String getWalletGrade() {
        return this.mWalletGrade;
    }

    public void setWalletGrade(String str) {
        this.mWalletGrade = str;
    }

    public double getAmount() {
        return this.mAmount;
    }

    public void setAmount(double d2) {
        this.mAmount = d2;
    }

    public double getTotalBalance() {
        return this.mTotalBalance;
    }

    public void setTotalBalance(double d2) {
        this.mTotalBalance = d2;
    }

    public double getPaytmWalletBalance() {
        return this.mPaytmWalletBalance;
    }

    public void setPaytmWalletBalance(double d2) {
        this.mPaytmWalletBalance = d2;
    }

    public double getOtherSubWalletBalance() {
        return this.mOtherSubWalletBalance;
    }

    public void setOtherSubWalletBalance(double d2) {
        this.mOtherSubWalletBalance = d2;
    }
}
