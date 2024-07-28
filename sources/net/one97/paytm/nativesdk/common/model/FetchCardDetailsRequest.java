package net.one97.paytm.nativesdk.common.model;

import net.one97.paytm.nativesdk.instruments.upipush.pojo.IJRDataModel;

public class FetchCardDetailsRequest implements IJRDataModel {
    private Body body;
    private Head head;

    public Head getHead() {
        return this.head;
    }

    public void setHead(Head head2) {
        this.head = head2;
    }

    public Body getBody() {
        return this.body;
    }

    public void setBody(Body body2) {
        this.body = body2;
    }

    public static class Head implements IJRDataModel {
        private String channelId;
        private String requestId;
        private String requestTimestamp;
        private String token;
        private String tokenType;
        private String version;

        public String getRequestId() {
            return this.requestId;
        }

        public void setRequestId(String str) {
            this.requestId = str;
        }

        public String getRequestTimestamp() {
            return this.requestTimestamp;
        }

        public void setRequestTimestamp(String str) {
            this.requestTimestamp = str;
        }

        public String getChannelId() {
            return this.channelId;
        }

        public void setChannelId(String str) {
            this.channelId = str;
        }

        public String getVersion() {
            return this.version;
        }

        public void setVersion(String str) {
            this.version = str;
        }

        public String getTokenType() {
            return this.tokenType;
        }

        public void setTokenType(String str) {
            this.tokenType = str;
        }

        public String getToken() {
            return this.token;
        }

        public void setToken(String str) {
            this.token = str;
        }
    }

    public static class Body implements IJRDataModel {
        private String cardNumber;
        private String eightDigitBinRequired;
        private String mid;
        private String savedCardId;

        public String getMid() {
            return this.mid;
        }

        public void setMid(String str) {
            this.mid = str;
        }

        public String getCardNumber() {
            return this.cardNumber;
        }

        public void setCardNumber(String str) {
            this.cardNumber = str;
        }

        public String getSavedCardId() {
            return this.savedCardId;
        }

        public void setSavedCardId(String str) {
            this.savedCardId = str;
        }

        public String getEightDigitBinRequired() {
            return this.eightDigitBinRequired;
        }

        public void setEightDigitBinRequired(String str) {
            this.eightDigitBinRequired = str;
        }
    }
}
