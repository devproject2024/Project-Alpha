package net.one97.paytm.nativesdk.common.model;

import java.util.ArrayList;
import net.one97.paytm.nativesdk.instruments.upipush.pojo.IJRDataModel;

public class ApplyPromoRequest implements IJRDataModel {
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
        private String custId;
        private String mid;
        private String orderId;
        private ArrayList<PaymentOption> paymentOptions;
        private String promocode;
        private String totalTransactionAmount;

        public String getMid() {
            return this.mid;
        }

        public void setMid(String str) {
            this.mid = str;
        }

        public String getPromocode() {
            return this.promocode;
        }

        public void setPromocode(String str) {
            this.promocode = str;
        }

        public ArrayList<PaymentOption> getPaymentOptions() {
            return this.paymentOptions;
        }

        public void setPaymentOptions(ArrayList<PaymentOption> arrayList) {
            this.paymentOptions = arrayList;
        }

        public String getTotalTransactionAmount() {
            return this.totalTransactionAmount;
        }

        public void setTotalTransactionAmount(String str) {
            this.totalTransactionAmount = str;
        }

        public void setCustId(String str) {
            this.custId = str;
        }

        public String getCustId() {
            return this.custId;
        }

        public String getOrderId() {
            return this.orderId;
        }

        public void setOrderId(String str) {
            this.orderId = str;
        }
    }

    public static class PaymentOption implements IJRDataModel {
        private String bankCode;
        private String cardNo;
        private String payMethod;
        private String savedCardId;
        private String transactionAmount;
        private String vpa;

        public String getTransactionAmount() {
            return this.transactionAmount;
        }

        public void setTransactionAmount(String str) {
            this.transactionAmount = str;
        }

        public String getPayMethod() {
            return this.payMethod;
        }

        public void setPayMethod(String str) {
            this.payMethod = str;
        }

        public String getBankCode() {
            return this.bankCode;
        }

        public void setBankCode(String str) {
            this.bankCode = str;
        }

        public String getCardNo() {
            return this.cardNo;
        }

        public void setCardNo(String str) {
            this.cardNo = str;
        }

        public String getVpa() {
            return this.vpa;
        }

        public void setVpa(String str) {
            this.vpa = str;
        }

        public String getSavedCardId() {
            return this.savedCardId;
        }

        public void setSavedCardId(String str) {
            this.savedCardId = str;
        }
    }
}
