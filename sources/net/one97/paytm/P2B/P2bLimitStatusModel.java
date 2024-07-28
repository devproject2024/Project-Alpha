package net.one97.paytm.P2B;

import com.google.gsonhtcfix.a.b;
import com.google.gsonhtcfix.f;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.ArrayList;

public class P2bLimitStatusModel extends IJRPaytmDataModel {
    private static final long serialVersionUID = 1;
    @b(a = "metadata")
    private Object metadata;
    @b(a = "orderId")
    private String orderId;
    @b(a = "requestGuid")
    private String requestGuid;
    @b(a = "response")
    private ArrayList<SendMoneyP2PLimitStatusResponseObjectModel> response;
    @b(a = "status")
    private String status;
    @b(a = "statusCode")
    private String statusCode;
    @b(a = "statusMessage")
    private String statusMessage;
    @b(a = "type")
    private String type;

    public String getType() {
        return this.type;
    }

    public void setType(String str) {
        this.type = str;
    }

    public String getRequestGuid() {
        return this.requestGuid;
    }

    public void setRequestGuid(String str) {
        this.requestGuid = str;
    }

    public String getOrderId() {
        return this.orderId;
    }

    public void setOrderId(String str) {
        this.orderId = str;
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

    public ArrayList<SendMoneyP2PLimitStatusResponseObjectModel> getResponse() {
        return this.response;
    }

    public void setResponse(ArrayList<SendMoneyP2PLimitStatusResponseObjectModel> arrayList) {
        this.response = arrayList;
    }

    public Object getMetadata() {
        return this.metadata;
    }

    public void setMetadata(Object obj) {
        this.metadata = obj;
    }

    public String toString() {
        return new f().a((Object) this);
    }
}
