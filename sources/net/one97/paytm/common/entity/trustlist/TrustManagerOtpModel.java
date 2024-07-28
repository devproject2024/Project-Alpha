package net.one97.paytm.common.entity.trustlist;

public class TrustManagerOtpModel {
    String amount;
    String manaulOtp;
    private String maskNumber;
    MessageInfo otpMsg;
    int retryCount;
    String time;
    String transactionId;

    public TrustManagerOtpModel(MessageInfo messageInfo, String str, String str2, String str3, int i2, String str4, String str5) {
        this.otpMsg = messageInfo;
        this.transactionId = str;
        this.amount = str2;
        this.time = str3;
        this.retryCount = i2;
        this.manaulOtp = str4;
        this.maskNumber = str5;
    }

    public MessageInfo getOtpMsg() {
        return this.otpMsg;
    }

    public String getTransactionId() {
        return this.transactionId;
    }

    public void setTransactionId(String str) {
        this.transactionId = str;
    }

    public String getAmount() {
        return this.amount;
    }

    public void setAmount(String str) {
        this.amount = str;
    }

    public String getTime() {
        return this.time;
    }

    public void setTime(String str) {
        this.time = str;
    }

    public int getRetryCount() {
        return this.retryCount;
    }

    public void setRetryCount(int i2) {
        this.retryCount = i2;
    }

    public String getManaulOtp() {
        return this.manaulOtp;
    }

    public void setManaulOtp(String str) {
        this.manaulOtp = str;
    }

    public String getMaskNumber() {
        return this.maskNumber;
    }
}
