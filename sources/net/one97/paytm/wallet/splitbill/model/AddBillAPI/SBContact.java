package net.one97.paytm.wallet.splitbill.model.AddBillAPI;

import net.one97.paytm.network.CJRWalletDataModel;

public class SBContact extends CJRWalletDataModel {
    private String amount;
    private String mobile;
    private String name;
    private String userId;

    public SBContact(String str, String str2, String str3, String str4) {
        this.mobile = str;
        this.amount = str2;
        this.userId = str3;
        this.name = str4;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    public String getMobile() {
        return this.mobile;
    }

    public void setMobile(String str) {
        this.mobile = str;
    }

    public String getAmount() {
        return this.amount;
    }

    public void setAmount(String str) {
        this.amount = str;
    }

    public String getUserId() {
        return this.userId;
    }

    public void setUserId(String str) {
        this.userId = str;
    }
}
