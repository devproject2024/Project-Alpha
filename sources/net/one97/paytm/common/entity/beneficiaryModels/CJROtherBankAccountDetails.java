package net.one97.paytm.common.entity.beneficiaryModels;

import com.google.gsonhtcfix.a.b;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJROtherBankAccountDetails implements IJRDataModel {
    @b(a = "accountHolderName")
    private String accountHolderName;
    @b(a = "accountNumber")
    private String accountNumber;
    @b(a = "bankName")
    private String bankName;
    @b(a = "ifscCode")
    private String ifscCode;

    public String getAccountNumber() {
        return this.accountNumber;
    }

    public void setAccountNumber(String str) {
        this.accountNumber = str;
    }

    public String getIfscCode() {
        return this.ifscCode;
    }

    public void setIfscCode(String str) {
        this.ifscCode = str;
    }

    public String getBankName() {
        return this.bankName;
    }

    public void setBankName(String str) {
        this.bankName = str;
    }

    public String getAccountHolderName() {
        return this.accountHolderName;
    }

    public void setAccountHolderName(String str) {
        this.accountHolderName = str;
    }
}
