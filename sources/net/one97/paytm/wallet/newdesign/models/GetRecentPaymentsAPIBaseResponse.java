package net.one97.paytm.wallet.newdesign.models;

import com.google.gson.a.a;
import com.google.gson.a.c;
import java.util.ArrayList;
import net.one97.paytm.network.CJRWalletDataModel;

public class GetRecentPaymentsAPIBaseResponse extends CJRWalletDataModel {
    @c(a = "orderId")
    @a
    private String orderId;
    @c(a = "requestGuid")
    @a
    private String requestGuid;
    @c(a = "response")
    @a
    private ArrayList<GetRecentPaymentsResponse> response = null;
    @c(a = "status")
    @a
    private String status;
    @c(a = "statusCode")
    @a
    private String statusCode;
    @c(a = "statusMessage")
    @a
    private String statusMessage;

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

    public ArrayList<GetRecentPaymentsResponse> getResponse() {
        return this.response;
    }

    public void setResponse(ArrayList<GetRecentPaymentsResponse> arrayList) {
        this.response = arrayList;
    }
}
