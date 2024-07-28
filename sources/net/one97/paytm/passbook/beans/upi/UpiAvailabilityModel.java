package net.one97.paytm.passbook.beans.upi;

import com.google.gson.a.c;

public class UpiAvailabilityModel implements UpiBaseDataModel {
    @c(a = "response")
    private UpiAvailabilityResponse mResponse;
    @c(a = "status")
    private String mStatus;

    public String getStatus() {
        return this.mStatus;
    }

    public UpiAvailabilityResponse getResponse() {
        return this.mResponse;
    }

    public void setResponse(UpiAvailabilityResponse upiAvailabilityResponse) {
        this.mResponse = upiAvailabilityResponse;
    }

    public void setmStatus(String str) {
        this.mStatus = str;
    }

    public class UpiAvailabilityResponse implements UpiBaseDataModel {
        @c(a = "sameDevice")
        private boolean mIsSameDevice;
        @c(a = "upiUser")
        private boolean mIsUpiUser;
        @c(a = "upiProfileExist")
        private boolean mUpiProfileExist;

        public UpiAvailabilityResponse() {
        }

        public boolean isSameDevice() {
            return this.mIsSameDevice;
        }

        public boolean isUpiUser() {
            return this.mIsUpiUser;
        }

        public void setUpiUser(boolean z) {
            this.mIsUpiUser = z;
        }

        public void setIsSameDevice(boolean z) {
            this.mIsSameDevice = z;
        }

        public boolean isUpiProfileExist() {
            return this.mUpiProfileExist;
        }

        public void setUpiProfileExist(boolean z) {
            this.mUpiProfileExist = z;
        }
    }
}
