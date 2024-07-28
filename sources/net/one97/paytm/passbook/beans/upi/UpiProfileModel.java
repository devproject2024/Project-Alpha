package net.one97.paytm.passbook.beans.upi;

import com.google.gson.a.c;
import java.util.ArrayList;
import java.util.List;
import net.one97.paytm.passbook.beans.upi.BankAccountDetails;
import net.one97.paytm.passbook.mapping.IJRDataModel;

public class UpiProfileModel extends IJRDataModel {
    @c(a = "respDetails")
    private AccountDetails response;
    @c(a = "status")
    private String status;

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String str) {
        this.status = str;
    }

    public AccountDetails getResponse() {
        return this.response;
    }

    public void setResponse(AccountDetails accountDetails) {
        this.response = accountDetails;
    }

    public class AccountDetails implements UpiBaseDataModel {
        @c(a = "profileDetail")
        private ProfileDetails profileDetail;

        public AccountDetails() {
        }

        public ProfileDetails getProfileDetail() {
            return this.profileDetail;
        }
    }

    public class ProfileDetails implements UpiBaseDataModel {
        @c(a = "accountsToLink")
        ArrayList<BankAccountDetails.BankAccount> accountsToLink;
        @c(a = "bankAccounts")
        ArrayList<BankAccountDetails.BankAccount> bankAccountList;
        @c(a = "errorCode")
        String errorCode;
        @c(a = "isDeviceBinded")
        boolean isDeviceBinded;
        @c(a = "message")
        String message;
        @c(a = "profileStatus")
        String profileStatus;
        @c(a = "vpaDetails")
        List<UpiProfileDefaultBank> profileVpaList;
        @c(a = "upiLinkedMobileNumber")
        String upiLinkedMobileNumber;

        public ProfileDetails() {
        }

        public ArrayList<BankAccountDetails.BankAccount> getAccountsToLink() {
            return this.accountsToLink;
        }

        public List<UpiProfileDefaultBank> getProfileVpaList() {
            return this.profileVpaList;
        }

        public ArrayList<BankAccountDetails.BankAccount> getBankAccountList() {
            return this.bankAccountList;
        }

        public String getErrorCode() {
            return this.errorCode;
        }

        public String getMessage() {
            return this.message;
        }
    }
}
