package net.one97.paytm.p2mNewDesign.entity.nativeOTP;

import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.network.CJRWalletDataModel;

public class DirectFormsResultInfo extends CJRWalletDataModel implements IJRDataModel {
    private boolean bankRetry;
    private String resultCode;
    private String resultMsg;
    private String resultStatus;
    private boolean retry;

    public String getResultStatus() {
        return this.resultStatus;
    }

    public void setResultStatus(String str) {
        this.resultStatus = str;
    }

    public String getResultCode() {
        return this.resultCode;
    }

    public void setResultCode(String str) {
        this.resultCode = str;
    }

    public boolean getRetry() {
        return this.retry;
    }

    public void setRetry(boolean z) {
        this.retry = z;
    }

    public String getResultMsg() {
        return this.resultMsg;
    }

    public void setResultMsg(String str) {
        this.resultMsg = str;
    }

    public boolean isBankRetry() {
        return this.bankRetry;
    }

    public void setBankRetry(boolean z) {
        this.bankRetry = z;
    }

    public String toString() {
        return "ClassPojo [resultStatus = " + this.resultStatus + ", resultCode = " + this.resultCode + ", retry = " + this.retry + ", resultMsg = " + this.resultMsg + "]";
    }
}
