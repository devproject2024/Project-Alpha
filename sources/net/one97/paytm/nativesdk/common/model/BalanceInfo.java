package net.one97.paytm.nativesdk.common.model;

import java.util.ArrayList;

public class BalanceInfo implements BaseDataModel {
    private AccountBalance accountBalance;
    private String payerAccountExists;
    private ArrayList<SubWalletDetail> subWalletDetails;

    public AccountBalance getAccountBalance() {
        return this.accountBalance;
    }

    public void setAccountBalance(AccountBalance accountBalance2) {
        this.accountBalance = accountBalance2;
    }

    public String getPayerAccountExists() {
        return this.payerAccountExists;
    }

    public void setPayerAccountExists(String str) {
        this.payerAccountExists = str;
    }

    public ArrayList<SubWalletDetail> getSubWalletDetails() {
        return this.subWalletDetails;
    }

    public void setSubWalletDetails(ArrayList<SubWalletDetail> arrayList) {
        this.subWalletDetails = arrayList;
    }

    public String toString() {
        return "ClassPojo [accountBalance = " + this.accountBalance + ", payerAccountExists = " + this.payerAccountExists + "]";
    }
}
