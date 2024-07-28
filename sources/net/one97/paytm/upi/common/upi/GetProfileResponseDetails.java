package net.one97.paytm.upi.common.upi;

import com.google.gson.a.c;
import java.util.List;
import net.one97.paytm.upi.common.UpiBaseDataModel;
import net.one97.paytm.upi.common.upi.BankAccountDetails;

public class GetProfileResponseDetails implements UpiBaseDataModel {
    @c(a = "details")
    private ProfileDetails mProfileDetails;

    public ProfileDetails getProfileDetails() {
        return this.mProfileDetails;
    }

    public class ProfileDetails implements UpiBaseDataModel {
        @c(a = "accounts")
        List<BankAccountDetails.BankAccount> bankAccountList;
        @c(a = "valist")
        List<ProfileVpa> profileVpaList;

        public ProfileDetails() {
        }

        public List<ProfileVpa> getProfileVpaList() {
            return this.profileVpaList;
        }

        public void setProfileVpaList(List<ProfileVpa> list) {
            this.profileVpaList = list;
        }

        public List<BankAccountDetails.BankAccount> getBankAccountList() {
            return this.bankAccountList;
        }

        public void setBankAccountList(List<BankAccountDetails.BankAccount> list) {
            this.bankAccountList = list;
        }
    }
}
