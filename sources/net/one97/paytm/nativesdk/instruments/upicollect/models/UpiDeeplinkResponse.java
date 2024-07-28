package net.one97.paytm.nativesdk.instruments.upicollect.models;

public class UpiDeeplinkResponse {
    private Body body;
    private Header header;

    public Body getBody() {
        return this.body;
    }

    public void setBody(Body body2) {
        this.body = body2;
    }

    public Header getHeader() {
        return this.header;
    }

    public void setHeader(Header header2) {
        this.header = header2;
    }

    public static class Header {
        private String responseTimestamp;
        private String version;

        public String getVersion() {
            return this.version;
        }

        public void setVersion(String str) {
            this.version = str;
        }

        public String getResponseTimestamp() {
            return this.responseTimestamp;
        }

        public void setResponseTimestamp(String str) {
            this.responseTimestamp = str;
        }
    }

    public static class Body {
        private String cashierRequestId;
        private String deepLink;
        private String orderId;
        private String resultCode;
        private String resultCodeId;
        private String resultMsg;
        private String transId;

        public String getResultCodeId() {
            return this.resultCodeId;
        }

        public void setResultCodeId(String str) {
            this.resultCodeId = str;
        }

        public String getResultCode() {
            return this.resultCode;
        }

        public void setResultCode(String str) {
            this.resultCode = str;
        }

        public String getResultMsg() {
            return this.resultMsg;
        }

        public void setResultMsg(String str) {
            this.resultMsg = str;
        }

        public String getDeeplink() {
            return this.deepLink;
        }

        public void setDeeplink(String str) {
            this.deepLink = str;
        }

        public String getOrderId() {
            return this.orderId;
        }

        public void setOrderId(String str) {
            this.orderId = str;
        }

        public void setTransId(String str) {
            this.transId = str;
        }

        public String getCashierRequestId() {
            return this.cashierRequestId;
        }

        public void setCashierRequestId(String str) {
            this.cashierRequestId = str;
        }

        public String getTransId() {
            return this.transId;
        }
    }
}
