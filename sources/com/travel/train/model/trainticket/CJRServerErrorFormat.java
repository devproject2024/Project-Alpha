package com.travel.train.model.trainticket;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;

public class CJRServerErrorFormat extends IJRPaytmDataModel {
    @b(a = "code")
    private Integer code;
    @b(a = "error")
    private String error;
    @b(a = "requestid")
    private String requestid;
    @b(a = "status")
    private CJRServerErrorStatus status;

    public String getError() {
        return this.error;
    }

    public void setError(String str) {
        this.error = str;
    }

    public Integer getCode() {
        return this.code;
    }

    public void setCode(Integer num) {
        this.code = num;
    }

    public CJRServerErrorStatus getStatus() {
        return this.status;
    }

    public void setStatus(CJRServerErrorStatus cJRServerErrorStatus) {
        this.status = cJRServerErrorStatus;
    }

    public String getRequestid() {
        return this.requestid;
    }

    public void setRequestid(String str) {
        this.requestid = str;
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

    public class CJRServerErrorStatus extends IJRPaytmDataModel {
        @b(a = "message")
        private CJRMessageFormat message;
        @b(a = "result")
        private String result;

        public CJRServerErrorStatus() {
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
}
