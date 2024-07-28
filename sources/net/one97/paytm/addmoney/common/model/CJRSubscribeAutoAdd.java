package net.one97.paytm.addmoney.common.model;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRSubscribeAutoAdd extends IJRPaytmDataModel implements IJRDataModel {
    @b(a = "metadata")
    private Object metadata;
    @b(a = "orderId")
    private Object orderId;
    @b(a = "requestGuid")
    private Object requestGuid;
    @b(a = "response")
    private Response response;
    @b(a = "status")
    private String status;
    @b(a = "statusCode")
    private String statusCode;
    @b(a = "statusMessage")
    private String statusMessage;
    @b(a = "type")
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
        @b(a = "subscriptionId")
        private String subscriptionId;

        public Response() {
        }

        public String getSubscriptionId() {
            return this.subscriptionId;
        }

        public void setSubscriptionId(String str) {
            this.subscriptionId = str;
        }
    }
}
