package com.travel.sale.data.model;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import java.io.Serializable;

public final class TCErrorFormat implements Serializable {
    @b(a = "code")
    private Integer code;
    @b(a = "error")
    private String error;
    @b(a = "requestid")
    private String requestid;
    @b(a = "status")
    private TCErrorStatus status;

    public final String getError() {
        return this.error;
    }

    public final void setError(String str) {
        this.error = str;
    }

    public final Integer getCode() {
        return this.code;
    }

    public final void setCode(Integer num) {
        this.code = num;
    }

    public final TCErrorStatus getStatus() {
        return this.status;
    }

    public final void setStatus(TCErrorStatus tCErrorStatus) {
        this.status = tCErrorStatus;
    }

    public final String getRequestid() {
        return this.requestid;
    }

    public final void setRequestid(String str) {
        this.requestid = str;
    }

    public class TCErrorStatus extends IJRPaytmDataModel {
        @b(a = "message")
        private CJRMessageFormat message;
        @b(a = "result")
        private String result;

        public TCErrorStatus() {
        }

        public String getResult() {
            return this.result;
        }

        public void setResult(String str) {
            this.result = str;
        }

        public CJRMessageFormat getMessage() {
            return this.message;
        }

        public void setMessage(CJRMessageFormat cJRMessageFormat) {
            this.message = cJRMessageFormat;
        }
    }

    public class CJRMessageFormat extends IJRPaytmDataModel {
        @b(a = "action")
        private String action;
        @b(a = "button_text")
        private String buttonText;
        @b(a = "message")
        private String message;
        @b(a = "title")
        private String title;

        public CJRMessageFormat() {
        }

        public String getAction() {
            return this.action;
        }

        public void setAction(String str) {
            this.action = str;
        }

        public String getButtonText() {
            return this.buttonText;
        }

        public void setButtonText(String str) {
            this.buttonText = str;
        }

        public String getTitle() {
            return this.title;
        }

        public void setTitle(String str) {
            this.title = str;
        }

        public String getMessage() {
            return this.message;
        }

        public void setMessage(String str) {
            this.message = str;
        }
    }
}
