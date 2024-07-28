package net.one97.paytm.nativesdk.instruments.upipush.pojo;

import com.google.gson.a.c;
import net.one97.paytm.nativesdk.instruments.upipush.pojo.BankAccountDetails;

public class UpiProfileDefaultBank implements IJRDataModel {
    @c(a = "defaultCredit")
    private BankAccountDetails.BankAccount creditBank;
    @c(a = "defaultDebit")
    private BankAccountDetails.BankAccount debitBank;
    private boolean isDefaultInstrunment;
    @c(a = "isPrimary")
    private boolean isPrimary;
    private IsDisabled isUpiDisable;
    private IsDisabled isUpiOptionDisable;
    @c(a = "name")
    private String virtualAddress;

    public String getVirtualAddress() {
        return this.virtualAddress;
    }

    public void setVirtualAddress(String str) {
        this.virtualAddress = str;
    }

    public BankAccountDetails.BankAccount getDebitBank() {
        return this.debitBank;
    }

    public void setDebitBank(BankAccountDetails.BankAccount bankAccount) {
        this.debitBank = bankAccount;
    }

    public BankAccountDetails.BankAccount getCreditBank() {
        return this.creditBank;
    }

    public void setCreditBank(BankAccountDetails.BankAccount bankAccount) {
        this.creditBank = bankAccount;
    }

    public boolean isPrimary() {
        return this.isPrimary;
    }

    public void setPrimary(boolean z) {
        this.isPrimary = z;
    }

    public IsDisabled getIsUpiDisable() {
        return this.isUpiDisable;
    }

    public void setIsUpiDisable(IsDisabled isDisabled) {
        this.isUpiDisable = isDisabled;
    }

    public IsDisabled getIsUpiOptionDisable() {
        return this.isUpiOptionDisable;
    }

    public void setIsUpiOptionDisable(IsDisabled isDisabled) {
        this.isUpiOptionDisable = isDisabled;
    }

    public boolean isDefaultInstrunment() {
        return this.isDefaultInstrunment;
    }

    public void setDefaultInstrunment(boolean z) {
        this.isDefaultInstrunment = z;
    }
}
