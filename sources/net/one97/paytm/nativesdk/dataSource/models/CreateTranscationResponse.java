package net.one97.paytm.nativesdk.dataSource.models;

import net.one97.paytm.nativesdk.common.model.ResultInfo;

public class CreateTranscationResponse {
    private Body body;
    private Head head;

    public Body getBody() {
        return this.body;
    }

    public void setBody(Body body2) {
        this.body = body2;
    }

    public Head getHead() {
        return this.head;
    }

    public void setHead(Head head2) {
        this.head = head2;
    }

    public String toString() {
        return "ClassPojo [body = " + this.body + ", head = " + this.head + "]";
    }

    public static class Body {
        private String authenticated;
        private String extendInfo;
        private ResultInfo resultInfo;
        private String txnToken;

        public String getToken() {
            return this.txnToken;
        }

        public void setToken(String str) {
            this.txnToken = str;
        }

        public String getAuthenticated() {
            return this.authenticated;
        }

        public void setAuthenticated(String str) {
            this.authenticated = str;
        }

        public ResultInfo getResultInfo() {
            return this.resultInfo;
        }

        public void setResultInfo(ResultInfo resultInfo2) {
            this.resultInfo = resultInfo2;
        }

        public String getExtendInfo() {
            return this.extendInfo;
        }

        public void setExtendInfo(String str) {
            this.extendInfo = str;
        }

        public String toString() {
            return "ClassPojo [token = " + this.txnToken + ", authenticated = " + this.authenticated + ", resultInfo = " + this.resultInfo + ", extendInfo = " + this.extendInfo + "]";
        }
    }

    public static class Head {
        private String clientId;
        private String responseTimestamp;
        private String signature;
        private String version;

        public String getResponseTimestamp() {
            return this.responseTimestamp;
        }

        public void setResponseTimestamp(String str) {
            this.responseTimestamp = str;
        }

        public String getSignature() {
            return this.signature;
        }

        public void setSignature(String str) {
            this.signature = str;
        }

        public String getClientId() {
            return this.clientId;
        }

        public void setClientId(String str) {
            this.clientId = str;
        }

        public String getVersion() {
            return this.version;
        }

        public void setVersion(String str) {
            this.version = str;
        }

        public String toString() {
            return "ClassPojo [responseTimestamp = " + this.responseTimestamp + ", signature = " + this.signature + ", clientId = " + this.clientId + ", version = " + this.version + "]";
        }
    }
}
