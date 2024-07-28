package net.one97.paytm.common.entity.wallet.universalp2p;

import com.google.gson.a.c;
import net.one97.paytm.common.entity.IJRDataModel;

public class P2PPreferenceResponseEntity implements IJRDataModel {
    @c(a = "error")
    private Errordesc error;
    private String iv;
    private String key;
    @c(a = "message")
    private String message;
    private boolean needToVerifyOtp;
    @c(a = "referenceNumber")
    private String referenceNumber;
    @c(a = "status")
    private String status;
    @c(a = "statusCode")
    private String statusCode;
    @c(a = "statusMessage")
    private String statusMessage;

    public String getKey() {
        return this.key;
    }

    public void setKey(String str) {
        this.key = str;
    }

    public String getIv() {
        return this.iv;
    }

    public void setIv(String str) {
        this.iv = str;
    }

    public Errordesc getError() {
        return this.error;
    }

    public void setError(Errordesc errordesc) {
        this.error = errordesc;
    }

    public String getStatusMessage() {
        return this.statusMessage;
    }

    public void setStatusMessage(String str) {
        this.statusMessage = str;
    }

    public String getStatusCode() {
        return this.statusCode;
    }

    public void setStatusCode(String str) {
        this.statusCode = str;
    }

    public boolean isNeedToVerifyOtp() {
        return this.needToVerifyOtp;
    }

    public void setNeedToVerifyOtp(boolean z) {
        this.needToVerifyOtp = z;
    }

    public String getReferenceNumber() {
        return this.referenceNumber;
    }

    public void setReferenceNumber(String str) {
        this.referenceNumber = str;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String str) {
        this.status = str;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String str) {
        this.message = str;
    }

    public static class Errordesc implements IJRDataModel {
        @c(a = "errorCode")
        private String errorCode;
        @c(a = "errorMsg")
        private String errorMsg;

        public String getErrorCode() {
            return this.errorCode;
        }

        public void setErrorCode(String str) {
            this.errorCode = str;
        }

        public String getErrorMsg() {
            return this.errorMsg;
        }

        public void setErrorMsg(String str) {
            this.errorMsg = str;
        }
    }
}
