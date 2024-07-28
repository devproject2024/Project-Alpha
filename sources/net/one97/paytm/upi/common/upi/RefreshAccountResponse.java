package net.one97.paytm.upi.common.upi;

import com.google.gson.a.c;
import net.one97.paytm.upi.common.UpiBaseDataModel;
import net.one97.paytm.upi.common.upi.BankAccountDetails;

public class RefreshAccountResponse extends UpiProfileBaseResponseModel {
    @c(a = "respDetails")
    private RefreshedBankAccount refreshedBankAccountList;

    public RefreshedBankAccount getRefreshedBankAccount() {
        return this.refreshedBankAccountList;
    }

    public class RefreshedBankAccount implements UpiBaseDataModel {
        @c(a = "account")
        BankAccountDetails.BankAccount bankAccount;

        public RefreshedBankAccount() {
        }

        public BankAccountDetails.BankAccount getBankAccount() {
            return this.bankAccount;
        }

        public void setBankAccountList(BankAccountDetails.BankAccount bankAccount2) {
            this.bankAccount = bankAccount2;
        }
    }
}
