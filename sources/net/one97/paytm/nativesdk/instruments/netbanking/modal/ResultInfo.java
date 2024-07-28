package net.one97.paytm.nativesdk.instruments.netbanking.modal;

public class ResultInfo {
    private String resultCode;
    private String resultMsg;
    private String resultStatus;

    public String getResultMsg() {
        return this.resultMsg;
    }

    public void setResultMsg(String str) {
        this.resultMsg = str;
    }

    public String getResultCode() {
        return this.resultCode;
    }

    public void setResultCode(String str) {
        this.resultCode = str;
    }

    public String getResultStatus() {
        return this.resultStatus;
    }

    public void setResultStatus(String str) {
        this.resultStatus = str;
    }

    public String toString() {
        return "ClassPojo [resultMsg = " + this.resultMsg + ", resultCode = " + this.resultCode + ", resultStatus = " + this.resultStatus + "]";
    }
}
