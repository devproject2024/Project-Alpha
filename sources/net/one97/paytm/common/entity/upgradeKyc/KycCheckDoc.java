package net.one97.paytm.common.entity.upgradeKyc;

import com.paytm.network.model.IJRPaytmDataModel;
import net.one97.paytm.common.entity.IJRDataModel;

public class KycCheckDoc extends IJRPaytmDataModel implements IJRDataModel {
    private Data data;
    private String message;
    private String responseCode;
    private String status;

    public void setStatus(String str) {
        this.status = str;
    }

    public void setResponseCode(String str) {
        this.responseCode = str;
    }

    public void setMessage(String str) {
        this.message = str;
    }

    public String getStatus() {
        return this.status;
    }

    public String getResponseCode() {
        return this.responseCode;
    }

    public String getMessage() {
        return this.message;
    }

    public Data getData() {
        return this.data;
    }

    public void setData(Data data2) {
        this.data = data2;
    }

    public class Data {
        private String mobile;
        private String verifyOtp;

        public Data() {
        }

        public String getMobile() {
            return this.mobile;
        }

        public void setMobile(String str) {
            this.mobile = str;
        }

        public String getVerifyOtp() {
            return this.verifyOtp;
        }

        public void setVerifyOtp(String str) {
            this.verifyOtp = str;
        }
    }
}
