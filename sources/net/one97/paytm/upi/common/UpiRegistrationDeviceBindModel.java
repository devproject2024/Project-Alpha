package net.one97.paytm.upi.common;

import com.google.gson.a.c;
import java.util.List;

public class UpiRegistrationDeviceBindModel implements UpiBaseDataModel {
    @c(a = "details")
    List<Details> details;

    public List<Details> getDetails() {
        return this.details;
    }

    public void setDetails(List<Details> list) {
        this.details = list;
    }

    public static class Details implements UpiBaseDataModel {
        @c(a = "mobileNumber")
        private String mMobileNumber;
        @c(a = "paytmUser")
        private boolean mPaytmUser;
        @c(a = "upiUser")
        private boolean mUpiUser;

        public String getMobileNumber() {
            return this.mMobileNumber;
        }

        public void setMobileNumber(String str) {
            this.mMobileNumber = str;
        }

        public boolean isPaytmUser() {
            return this.mPaytmUser;
        }

        public void setPaytmUser(boolean z) {
            this.mPaytmUser = z;
        }

        public boolean isUpiUser() {
            return this.mUpiUser;
        }

        public void setUpiUser(boolean z) {
            this.mUpiUser = z;
        }
    }
}
