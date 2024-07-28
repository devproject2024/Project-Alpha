package net.one97.paytm.upi.common;

import com.google.gson.a.c;

public class UpiInitiateSmsModel implements UpiBaseDataModel {
    @c(a = "respCode")
    private String mResponseCode;
    @c(a = "respMessage")
    private String mResponseMessage;
    @c(a = "seqNo")
    private String mSeqNo;
    @c(a = "status")
    private String mStatus;
    @c(a = "verification-data")
    private String mVerificationData;

    public String getStatus() {
        return this.mStatus;
    }

    public void setStatus(String str) {
        this.mStatus = str;
    }

    public String getResponseCode() {
        return this.mResponseCode;
    }

    public void setResponseCode(String str) {
        this.mResponseCode = str;
    }

    public String getResponseMessage() {
        return this.mResponseMessage;
    }

    public void setResponseMessage(String str) {
        this.mResponseMessage = str;
    }

    public String getSeqNo() {
        return this.mSeqNo;
    }

    public void setSeqNo(String str) {
        this.mSeqNo = str;
    }

    public String getVerificationData() {
        return this.mVerificationData;
    }

    public void setVerificationData(String str) {
        this.mVerificationData = str;
    }
}
