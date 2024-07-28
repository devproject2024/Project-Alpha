package net.one97.paytm.p2mNewDesign.entity;

import com.google.gson.a.c;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.p2mNewDesign.models.BankAccountsV2;
import net.one97.paytm.p2mNewDesign.models.IsDisabledV2;
import net.one97.paytm.upi.common.UpiBaseDataModel;

public class UpiProfileDefaultBank implements IJRDataModel, UpiBaseDataModel {
    @c(a = "defaultCredit")
    private BankAccountsV2 creditBank;
    @c(a = "defaultDebit")
    private BankAccountsV2 debitBank;
    private IsDisabledV2 isUpiDisable;
    private IsDisabledV2 isUpiOptionDisable;
    @c(a = "primary")
    private boolean primary;
    @c(a = "name")
    private String virtualAddress;

    public String getVirtualAddress() {
        return this.virtualAddress;
    }

    public void setVirtualAddress(String str) {
        this.virtualAddress = str;
    }

    public BankAccountsV2 getDebitBank() {
        return this.debitBank;
    }

    public void setDebitBank(BankAccountsV2 bankAccountsV2) {
        this.debitBank = bankAccountsV2;
    }

    public BankAccountsV2 getCreditBank() {
        return this.creditBank;
    }

    public void setCreditBank(BankAccountsV2 bankAccountsV2) {
        this.creditBank = bankAccountsV2;
    }

    public boolean isPrimary() {
        return this.primary;
    }

    public void setPrimary(boolean z) {
        this.primary = z;
    }

    public IsDisabledV2 getIsUpiDisable() {
        return this.isUpiDisable;
    }

    public void setIsUpiDisable(IsDisabledV2 isDisabledV2) {
        this.isUpiDisable = isDisabledV2;
    }

    public IsDisabledV2 getIsUpiOptionDisable() {
        return this.isUpiOptionDisable;
    }

    public void setIsUpiOptionDisable(IsDisabledV2 isDisabledV2) {
        this.isUpiOptionDisable = isDisabledV2;
    }
}
