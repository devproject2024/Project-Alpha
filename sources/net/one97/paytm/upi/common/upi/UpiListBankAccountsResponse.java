package net.one97.paytm.upi.common.upi;

import com.google.gson.a.c;
import java.util.ArrayList;
import net.one97.paytm.upi.common.UpiBaseDataModel;
import net.one97.paytm.upi.common.upi.BankAccountDetails;

public class UpiListBankAccountsResponse extends UpiProfileBaseResponseModel {
    @c(a = "respDetails")
    private AccountDetails accountDetails;

    public AccountDetails getAccountDetails() {
        return this.accountDetails;
    }

    public class AccountDetails implements UpiBaseDataModel {
        @c(a = "accounts")
        private ArrayList<BankAccountDetails.BankAccount> accounts;

        public AccountDetails() {
        }

        public ArrayList<BankAccountDetails.BankAccount> getAccounts() {
            return this.accounts;
        }
    }
}
