package net.one97.paytm.upi.common.upi;

import com.google.gson.a.c;
import net.one97.paytm.upi.common.UpiBaseDataModel;

public class ProfileVpa implements UpiBaseDataModel {
    @c(a = "credit")
    private ProfileCreditDefault credit;
    @c(a = "debit")
    private ProfileDebitDefault debit;
    @c(a = "va")
    private String virtualAddress;

    public String getVirtualAddress() {
        return this.virtualAddress;
    }

    public void setVirtualAddress(String str) {
        this.virtualAddress = str;
    }

    public ProfileDebitDefault getDebit() {
        return this.debit;
    }

    public void setDebit(ProfileDebitDefault profileDebitDefault) {
        this.debit = profileDebitDefault;
    }

    public ProfileCreditDefault getCredit() {
        return this.credit;
    }

    public void setCredit(ProfileCreditDefault profileCreditDefault) {
        this.credit = profileCreditDefault;
    }
}
