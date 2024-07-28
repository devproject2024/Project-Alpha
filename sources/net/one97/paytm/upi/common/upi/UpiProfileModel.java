package net.one97.paytm.upi.common.upi;

import com.google.gson.a.c;
import java.util.ArrayList;
import java.util.List;
import net.one97.paytm.upi.common.UpiBaseDataModel;
import net.one97.paytm.upi.common.upi.BankAccountDetails;

public class UpiProfileModel extends UpiProfileBaseResponseModel {
    @c(a = "respDetails")
    private AccountDetails response;

    public AccountDetails getResponse() {
        return this.response;
    }

    public void setResponse(AccountDetails accountDetails) {
        this.response = accountDetails;
    }

    public class AccountDetails implements UpiBaseDataModel {
        @c(a = "metaDetails")
        private NpciMetaDetails npciMetaDetails;
        @c(a = "profileDetail")
        private ProfileDetails profileDetail;

        public AccountDetails() {
        }

        public NpciMetaDetails getNpciMetaDetails() {
            return this.npciMetaDetails;
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
        @c(a = "userPreferences")
        ArrayList<String> userPreferences;

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

        public ArrayList<String> getUserPreferences() {
            return this.userPreferences;
        }

        public void setUserPreferences(ArrayList<String> arrayList) {
            this.userPreferences = arrayList;
        }
    }
}
