package net.one97.paytm.passbook.beans;

import com.google.gsonhtcfix.a.a;
import com.google.gsonhtcfix.a.b;
import net.one97.paytm.passbook.mapping.IJRDataModel;

public class TutorialMessage extends IJRDataModel {
    @a
    @b(a = "metadata")
    private Object metadata;
    @a
    @b(a = "orderId")
    private Object orderId;
    @a
    @b(a = "requestGuid")
    private Object requestGuid;
    @a
    @b(a = "response")
    private Response response;
    @a
    @b(a = "status")
    private Object status;
    @a
    @b(a = "statusCode")
    private String statusCode;
    @a
    @b(a = "statusMessage")
    private String statusMessage;
    @a
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

    public Object getStatus() {
        return this.status;
    }

    public void setStatus(Object obj) {
        this.status = obj;
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
        @a
        @b(a = "helpText")
        private String helpText;

        public Response() {
        }

        public String getHelpText() {
            return this.helpText;
        }

        public void setHelpText(String str) {
            this.helpText = str;
        }
    }
}
