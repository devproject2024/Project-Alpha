package net.one97.paytm.upi.common.upi;

import com.google.gson.a.c;
import java.util.ArrayList;
import net.one97.paytm.upi.common.UpiBaseDataModel;

public class SignupStepCodeResponse implements UpiBaseDataModel {
    @c(a = "details")
    private Details details;
    @c(a = "respCode")
    private String respCode;
    @c(a = "respMessage")
    private String respMessage;
    @c(a = "serialNo")
    private int serialNo;
    @c(a = "showMessage")
    private boolean showMessage;
    @c(a = "status")
    private String status;
    @c(a = "stepCode")
    private String stepCode;

    public String getRespCode() {
        return this.respCode;
    }

    public String getStatus() {
        return this.status;
    }

    public String getStepCode() {
        return this.stepCode;
    }

    public String getRespMessage() {
        return this.respMessage;
    }

    public int getSerialNo() {
        return this.serialNo;
    }

    public boolean isShowMessage() {
        return this.showMessage;
    }

    public Details getDetails() {
        return this.details;
    }

    public class Details implements UpiBaseDataModel {
        @c(a = "deviceMobileNumber")
        private String deviceMobileNumber;
        @c(a = "vpaDetails")
        private ArrayList<VpaDetails> vpaDetails;

        public Details() {
        }

        public String getDeviceMobileNumber() {
            return this.deviceMobileNumber;
        }

        public ArrayList<VpaDetails> getVpaDetails() {
            return this.vpaDetails;
        }
    }

    public class VpaDetails implements UpiBaseDataModel {
        @c(a = "vpa")
        private String vpa;

        public VpaDetails() {
        }

        public String getVpa() {
            return this.vpa;
        }
    }
}
