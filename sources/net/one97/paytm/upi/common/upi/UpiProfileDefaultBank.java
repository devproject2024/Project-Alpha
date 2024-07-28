package net.one97.paytm.upi.common.upi;

import com.google.gson.a.c;
import net.one97.paytm.upi.common.UpiBaseDataModel;
import net.one97.paytm.upi.common.models.IsDisabled;
import net.one97.paytm.upi.common.upi.BankAccountDetails;

public class UpiProfileDefaultBank implements UpiBaseDataModel {
    private String balance;
    @c(a = "defaultCredit")
    private BankAccountDetails.BankAccount creditBank;
    @c(a = "defaultDebit")
    private BankAccountDetails.BankAccount debitBank;
    @c(a = "defaultCreditAccRefId")
    private String defaultCreditAccRefId;
    @c(a = "defaultDebitAccRefId")
    private String defaultDebitAccRefId;
    private boolean isDefaultInstrunment;
    @c(a = "isPrimary")
    private boolean isPrimary;
    private boolean isRequestInProgress;
    private IsDisabled isUpiDisable;
    private IsDisabled isUpiOptionDisable;
    private PAYMENT_MODE paymentMode = PAYMENT_MODE.UPI;
    @c(a = "qrData")
    private String qrData;
    @c(a = "name")
    private String virtualAddress;

    public enum PAYMENT_MODE {
        UPI,
        IMPS
    }

    public String getVirtualAddress() {
        return this.virtualAddress;
    }

    public void setVirtualAddress(String str) {
        this.virtualAddress = str;
    }

    public String getQrData() {
        return this.qrData;
    }

    public void setQrData(String str) {
        this.qrData = str;
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

    public String getDefaultDebitAccRefId() {
        return this.defaultDebitAccRefId;
    }

    public String getDefaultCreditAccRefId() {
        return this.defaultCreditAccRefId;
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

    public void setPaymentMode(PAYMENT_MODE payment_mode) {
        this.paymentMode = payment_mode;
    }

    public PAYMENT_MODE getPaymentMode() {
        return this.paymentMode;
    }

    public String getBalance() {
        return this.balance;
    }

    public void setBalance(String str) {
        this.balance = str;
    }

    public boolean isRequestInProgress() {
        return this.isRequestInProgress;
    }

    public void setRequestInProgress(boolean z) {
        this.isRequestInProgress = z;
    }
}
