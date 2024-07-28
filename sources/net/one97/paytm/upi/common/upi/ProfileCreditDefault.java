package net.one97.paytm.upi.common.upi;

import com.google.gson.a.c;
import net.one97.paytm.upi.common.UpiBaseDataModel;

public class ProfileCreditDefault implements UpiBaseDataModel {
    @c(a = "default-credit-account")
    private String account;
    @c(a = "default-credit-bank")
    private String bank;
    @c(a = "default-credit-ifsc")
    private String ifsc;

    public String getAccount() {
        return this.account;
    }

    public void setAccount(String str) {
        this.account = str;
    }

    public String getBank() {
        return this.bank;
    }

    public void setBank(String str) {
        this.bank = str;
    }

    public String getIfsc() {
        return this.ifsc;
    }

    public void setIfsc(String str) {
        this.ifsc = str;
    }
}
