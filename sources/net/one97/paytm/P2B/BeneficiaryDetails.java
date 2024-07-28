package net.one97.paytm.P2B;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;

public class BeneficiaryDetails extends IJRPaytmDataModel {
    @b(a = "ahn")
    String accountHolderName;
    @b(a = "acn")
    String accountNumber;
    @b(a = "bn")
    String bankName;
    @b(a = "ifsc")
    String ifscCode;
    @b(a = "type")
    String type;

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

    public String getAccountHolderName() {
        return this.accountHolderName;
    }

    public void setAccountHolderName(String str) {
        this.accountHolderName = str;
    }

    public String getBankName() {
        return this.bankName;
    }

    public void setBankName(String str) {
        this.bankName = str;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String str) {
        this.type = str;
    }
}
