package net.one97.paytm.recharge.model.creditcard;

public final class CJRCreditCardResultInfo {
    private String resultCode;
    private String resultMsg;
    private String resultStatus;

    public final String getResultStatus() {
        return this.resultStatus;
    }

    public final void setResultStatus(String str) {
        this.resultStatus = str;
    }

    public final String getResultCode() {
        return this.resultCode;
    }

    public final void setResultCode(String str) {
        this.resultCode = str;
    }

    public final String getResultMsg() {
        return this.resultMsg;
    }

    public final void setResultMsg(String str) {
        this.resultMsg = str;
    }
}
