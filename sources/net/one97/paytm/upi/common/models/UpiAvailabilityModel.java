package net.one97.paytm.upi.common.models;

import com.google.gson.a.c;
import net.one97.paytm.upi.common.UpiBaseDataModel;

public class UpiAvailabilityModel implements UpiBaseDataModel {
    @c(a = "respDetails")
    private UpiAvailabilityResponse mResponse;
    @c(a = "status")
    private String mStatus;
    @c(a = "respCode")
    private String respCode;
    @c(a = "respMessage")
    private String respMessage;

    public String getStatus() {
        return this.mStatus;
    }

    public String getRespMessage() {
        return this.respMessage;
    }

    public void setRespMessage(String str) {
        this.respMessage = str;
    }

    public String getRespCode() {
        return this.respCode;
    }

    public void setRespCode(String str) {
        this.respCode = str;
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
        @c(a = "bankAccountAdded")
        private boolean mBankAccountAdded;
        @c(a = "sameDevice")
        private boolean mIsSameDevice;
        @c(a = "upiUser")
        private boolean mIsUpiUser;
        @c(a = "deviceBinded")
        private boolean mIsdeviceBinded;
        @c(a = "mpinSet")
        private boolean mPinSet;
        @c(a = "upiProfileExist")
        private boolean mUpiProfileExist;

        public UpiAvailabilityResponse() {
        }

        public boolean ismBankAccountAdded() {
            return this.mBankAccountAdded;
        }

        public void setmBankAccountAdded(boolean z) {
            this.mBankAccountAdded = z;
        }

        public boolean ismPinSet() {
            return this.mPinSet;
        }

        public void setmPinSet(boolean z) {
            this.mPinSet = z;
        }

        public boolean isSameDevice() {
            return this.mIsdeviceBinded;
        }

        public boolean isUpiUser() {
            return this.mIsUpiUser;
        }

        public void setUpiUser(boolean z) {
            this.mIsUpiUser = z;
        }

        public void setIsSameDevice(boolean z) {
            this.mIsdeviceBinded = z;
        }

        public boolean isUpiProfileExist() {
            return this.mUpiProfileExist;
        }

        public void setUpiProfileExist(boolean z) {
            this.mUpiProfileExist = z;
        }
    }
}
