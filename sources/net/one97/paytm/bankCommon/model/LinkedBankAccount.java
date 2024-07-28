package net.one97.paytm.bankCommon.model;

import java.io.Serializable;

public class LinkedBankAccount implements Serializable {
    private String accountLastFourDigits;
    private String bankAccountHolderName;
    private String bankName;
    private String ifscPrefix;

    public String getAccountNumber() {
        return this.accountLastFourDigits;
    }

    public void setAccountNumber(String str) {
        this.accountLastFourDigits = str;
    }

    public String getBankAccountHolderName() {
        return this.bankAccountHolderName;
    }

    public void setBankAccountHolderName(String str) {
        this.bankAccountHolderName = str;
    }

    public String getBankName() {
        return this.bankName;
    }

    public void setBankName(String str) {
        this.bankName = str;
    }

    public String getIfscCode() {
        return this.ifscPrefix;
    }

    public void setIfscCode(String str) {
        this.ifscPrefix = str;
    }
}
