package net.one97.paytm.upi.common.upi;

import com.google.gson.a.c;
import java.util.ArrayList;
import net.one97.paytm.upi.common.UpiBaseDataModel;
import net.one97.paytm.upi.common.upi.UpiProfileModel;

public class SignupLinkBankAccountResponse extends UpiProfileBaseResponseModel {
    @c(a = "respDetails")
    private AccountDetails accountDetails;

    public AccountDetails getAccountDetails() {
        return this.accountDetails;
    }

    public class AccountDetails implements UpiBaseDataModel {
        @c(a = "newAccountsAdded")
        private ArrayList<RefId> newAccountsAdded;
        @c(a = "profileDetail")
        private UpiProfileModel.ProfileDetails profileDetail;

        public AccountDetails() {
        }

        public UpiProfileModel.ProfileDetails getProfileDetail() {
            return this.profileDetail;
        }

        public ArrayList<RefId> getNewAccountsAdded() {
            return this.newAccountsAdded;
        }
    }

    public class RefId implements UpiBaseDataModel {
        @c(a = "accRefId")
        private String accRefId;

        public RefId() {
        }

        public String getAccRefId() {
            return this.accRefId;
        }
    }
}
