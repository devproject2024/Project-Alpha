package net.one97.paytm.passbook.beans.upi;

import java.util.List;
import net.one97.paytm.passbook.beans.upi.AccountProviderBody;
import net.one97.paytm.passbook.beans.upi.BankAccountDetails;
import net.one97.paytm.passbook.mapping.IJRDataModel;

public final class UserUpiDetails extends IJRDataModel {
    private List<BankAccountDetails.BankAccount> bankAccountList;
    private String customerCode;
    private String customerType;
    private AccountProviderBody.AccountProvider mAccountProvider;
    private String mProfileId;
    private String mVpa;
    private int selectedBankIdx;

    private UserUpiDetails(Builder builder) {
        this.customerCode = "0000";
        this.customerType = "PERSON";
        this.selectedBankIdx = 0;
        this.mAccountProvider = builder.accountProvider;
        this.mVpa = builder.vpa;
        this.bankAccountList = builder.bankAccountList;
        this.selectedBankIdx = builder.selectedBankIdx;
    }

    public static class Builder {
        /* access modifiers changed from: private */
        public AccountProviderBody.AccountProvider accountProvider;
        /* access modifiers changed from: private */
        public List<BankAccountDetails.BankAccount> bankAccountList;
        /* access modifiers changed from: private */
        public int selectedBankIdx;
        /* access modifiers changed from: private */
        public String vpa;

        public Builder(UserUpiDetails userUpiDetails) {
            this.accountProvider = userUpiDetails.getAccountProvider();
            this.vpa = userUpiDetails.getVpa();
            this.bankAccountList = userUpiDetails.getBankAccountList();
            this.selectedBankIdx = userUpiDetails.getSelectedBankIdx();
        }

        public Builder(AccountProviderBody.AccountProvider accountProvider2, String str) {
            this.accountProvider = accountProvider2;
            this.vpa = str;
        }

        public UserUpiDetails build() {
            return new UserUpiDetails(this);
        }

        public Builder setBankAccountList(List<BankAccountDetails.BankAccount> list) {
            this.bankAccountList = list;
            return this;
        }

        public Builder setSelectedBankIdx(int i2) {
            this.selectedBankIdx = i2;
            return this;
        }
    }

    public final AccountProviderBody.AccountProvider getAccountProvider() {
        return this.mAccountProvider;
    }

    public final String getVpa() {
        return this.mVpa;
    }

    public final List<BankAccountDetails.BankAccount> getBankAccountList() {
        return this.bankAccountList;
    }

    public final int getSelectedBankIdx() {
        return this.selectedBankIdx;
    }

    public final BankAccountDetails.BankAccount getSelectedBankAccount() {
        List<BankAccountDetails.BankAccount> list = this.bankAccountList;
        if (list == null) {
            return null;
        }
        return list.get(this.selectedBankIdx);
    }

    public final String getCustomerCode() {
        return this.customerCode;
    }

    public final String getCustomerType() {
        return this.customerType;
    }
}
