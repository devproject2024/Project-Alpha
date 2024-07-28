package net.one97.paytm.upi.common.upi;

import com.google.gson.a.c;
import java.util.ArrayList;
import java.util.Iterator;
import net.one97.paytm.upi.common.UpiBaseDataModel;
import net.one97.paytm.upi.common.upi.UpiProfileModel;
import net.one97.paytm.upi.util.UpiConstants;

public class UpiCreateProfileResponse extends UpiProfileBaseResponseModel {
    @c(a = "respDetails")
    private AccountDetails accountDetails;

    public AccountDetails getAccountDetails() {
        return this.accountDetails;
    }

    public class AccountDetails implements UpiBaseDataModel {
        @c(a = "profileDetail")
        private UpiProfileModel.ProfileDetails profileDetail;
        @c(a = "stepResponses")
        private ArrayList<SignupStepCodeResponse> stepResponses;

        public AccountDetails() {
        }

        public UpiProfileModel.ProfileDetails getProfileDetail() {
            return this.profileDetail;
        }

        public ArrayList<SignupStepCodeResponse> getStepResponses() {
            ArrayList<SignupStepCodeResponse> arrayList = new ArrayList<>();
            Iterator<SignupStepCodeResponse> it2 = this.stepResponses.iterator();
            while (it2.hasNext()) {
                SignupStepCodeResponse next = it2.next();
                if (next.getStepCode().equalsIgnoreCase(UpiConstants.SignUpStepCodes.REGISTER_DEVICE)) {
                    arrayList.add(next);
                }
            }
            Iterator<SignupStepCodeResponse> it3 = this.stepResponses.iterator();
            while (it3.hasNext()) {
                SignupStepCodeResponse next2 = it3.next();
                if (next2.getStepCode().equalsIgnoreCase(UpiConstants.SignUpStepCodes.CREATE_VPA)) {
                    arrayList.add(next2);
                }
            }
            Iterator<SignupStepCodeResponse> it4 = this.stepResponses.iterator();
            while (it4.hasNext()) {
                SignupStepCodeResponse next3 = it4.next();
                if (next3.getStepCode().equalsIgnoreCase(UpiConstants.SignUpStepCodes.FETCH_ACCOUNT)) {
                    arrayList.add(next3);
                }
            }
            Iterator<SignupStepCodeResponse> it5 = this.stepResponses.iterator();
            while (it5.hasNext()) {
                SignupStepCodeResponse next4 = it5.next();
                if (next4.getStepCode().equalsIgnoreCase(UpiConstants.SignUpStepCodes.LINK_ACCOUNT)) {
                    arrayList.add(next4);
                }
            }
            return arrayList;
        }
    }
}
