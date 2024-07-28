package net.one97.paytm.common.entity.wallet;

import com.business.merchant_payments.common.utility.AppUtility;
import com.google.gson.a.c;
import com.google.gsonhtcfix.a.a;
import com.paytm.network.model.IJRPaytmDataModel;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRSubscribeFetchStatus extends IJRPaytmDataModel implements IJRDataModel {
    @c(a = "metadata")
    private Object metadata;
    @c(a = "orderId")
    private Object orderId;
    @c(a = "requestGuid")
    private Object requestGuid;
    @c(a = "response")
    private Response response;
    @c(a = "status")
    private String status;
    @c(a = "statusCode")
    private String statusCode;
    @c(a = "statusMessage")
    private String statusMessage;
    @c(a = "type")
    private Object type;

    public Object getType() {
        return this.type;
    }

    public void setType(Object obj) {
        this.type = obj;
    }

    public Object getRequestGuid() {
        return this.requestGuid;
    }

    public void setRequestGuid(Object obj) {
        this.requestGuid = obj;
    }

    public Object getOrderId() {
        return this.orderId;
    }

    public void setOrderId(Object obj) {
        this.orderId = obj;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String str) {
        this.status = str;
    }

    public String getStatusCode() {
        return this.statusCode;
    }

    public void setStatusCode(String str) {
        this.statusCode = str;
    }

    public String getStatusMessage() {
        return this.statusMessage;
    }

    public void setStatusMessage(String str) {
        this.statusMessage = str;
    }

    public Response getResponse() {
        return this.response;
    }

    public void setResponse(Response response2) {
        this.response = response2;
    }

    public Object getMetadata() {
        return this.metadata;
    }

    public void setMetadata(Object obj) {
        this.metadata = obj;
    }

    public class Response {
        @c(a = "cardId")
        @a
        private String cardId;
        @c(a = "custId")
        @a
        private String custId;
        @c(a = "statusMsg")
        @a
        private String statusMsg;
        @c(a = "statusOfLatestTxn")
        @a
        private String statusOfLatestTxn;
        @c(a = "statusOfSubscription")
        @a
        private String statusOfSubscription;
        @c(a = "subscriptionAmount")
        @a
        private String subscriptionAmount;
        @c(a = "subscriptionMessage")
        private String subscriptionMessage;
        @c(a = "timestamp")
        @a
        private String timestamp;
        @c(a = "topUpAmount")
        private String topUpAmount;
        @c(a = "txnId")
        @a
        private String txnId;

        public Response() {
        }

        public String getTopUpAmount() {
            this.topUpAmount = this.topUpAmount.indexOf(AppUtility.CENTER_DOT) < 0 ? this.topUpAmount : this.topUpAmount.replaceAll("0*$", "").replaceAll("\\.$", "");
            return this.topUpAmount;
        }

        public String getSubscriptionMessage() {
            return this.subscriptionMessage;
        }

        public String getCustId() {
            return this.custId;
        }

        public void setCustId(String str) {
            this.custId = str;
        }

        public String getTxnId() {
            return this.txnId;
        }

        public void setTxnId(String str) {
            this.txnId = str;
        }

        public String getStatusOfLatestTxn() {
            return this.statusOfLatestTxn;
        }

        public void setStatusOfLatestTxn(String str) {
            this.statusOfLatestTxn = str;
        }

        public String getStatusMsg() {
            return this.statusMsg;
        }

        public void setStatusMsg(String str) {
            this.statusMsg = str;
        }

        public String getTimestamp() {
            return this.timestamp;
        }

        public void setTimestamp(String str) {
            this.timestamp = str;
        }

        public String getStatusOfSubscription() {
            return this.statusOfSubscription;
        }

        public void setStatusOfSubscription(String str) {
            this.statusOfSubscription = str;
        }

        public String getCardId() {
            return this.cardId;
        }

        public void setCardId(String str) {
            this.cardId = str;
        }

        public String getSubscriptionAmount() {
            this.subscriptionAmount = this.subscriptionAmount.indexOf(AppUtility.CENTER_DOT) < 0 ? this.subscriptionAmount : this.subscriptionAmount.replaceAll("0*$", "").replaceAll("\\.$", "");
            return this.subscriptionAmount;
        }

        public void setSubscriptionAmount(String str) {
            this.subscriptionAmount = str;
        }
    }
}
