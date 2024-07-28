package net.one97.paytm.passbook.beans;

import java.util.List;
import net.one97.paytm.passbook.beans.upi.BankAccountDetails;
import net.one97.paytm.passbook.mapping.IJRDataModel;

public class UserVpaInfo extends IJRDataModel {
    private String accountNum;
    private List<BankAccountDetails.BankAccountCredentials> bankCredsAllowed;
    private String bankName;
    private boolean isMpinSet;
    private boolean isPrimaryVpa;
    private String vpa;

    public boolean isMpinSet() {
        return this.isMpinSet;
    }

    public void setIsMpinSet(boolean z) {
        this.isMpinSet = z;
    }

    public String getVpa() {
        return this.vpa;
    }

    public void setVpa(String str) {
        this.vpa = str;
    }

    public String getBankName() {
        return this.bankName;
    }

    public void setBankName(String str) {
        this.bankName = str;
    }

    public String getAccountNum() {
        return this.accountNum;
    }

    public void setAccountNum(String str) {
        this.accountNum = str;
    }

    public List<BankAccountDetails.BankAccountCredentials> getBankCredsAllowed() {
        return this.bankCredsAllowed;
    }

    public void setBankCredsAllowed(List<BankAccountDetails.BankAccountCredentials> list) {
        this.bankCredsAllowed = list;
    }

    public boolean isPrimaryVpa() {
        return this.isPrimaryVpa;
    }

    public void setPrimaryVpa(boolean z) {
        this.isPrimaryVpa = z;
    }
}
