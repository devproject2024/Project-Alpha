package net.one97.paytm.common.entity.wallet.universalp2p;

import com.google.gson.a.c;
import net.one97.paytm.common.entity.IJRDataModel;

public class ValidateOtpResponse implements IJRDataModel {
    @c(a = "error")
    private Error error;
    @c(a = "statusCode")
    private String statusCode;
    @c(a = "statusMessage")
    private String statusMessage;

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

    public Error getError() {
        return this.error;
    }

    public void setError(Error error2) {
        this.error = error2;
    }

    public static class Error {
        @c(a = "errorCode")
        private String errorCode;
        @c(a = "errorMsg")
        private String errorMsg;

        public String getErrorMessage() {
            return this.errorMsg;
        }

        public void setErrorMessage(String str) {
            this.errorMsg = str;
        }

        public String getErrorCode() {
            return this.errorCode;
        }

        public void setErrorCode(String str) {
            this.errorCode = str;
        }
    }
}
