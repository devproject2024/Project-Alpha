package net.one97.paytm.passbook.beans;

import com.google.gsonhtcfix.a.b;
import net.one97.paytm.passbook.mapping.IJRDataModel;

public class CJRCSTTransactionType extends IJRDataModel {
    private static final long serialVersionUID = 1;
    @b(a = "orderId")
    private String orderId;
    @b(a = "requestGuid")
    private String requestGuid;
    @b(a = "response")
    private CJRCSTTransactionDetailResponse response;
    @b(a = "status")
    private String status;
    @b(a = "statusCode")
    private String statusCode;
    @b(a = "statusMessage")
    private String statusMessage;
    @b(a = "type")
    private String type;

    public static long getSerialVersionUID() {
        return 1;
    }

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

    public CJRCSTTransactionDetailResponse getResponse() {
        return this.response;
    }

    public void setResponse(CJRCSTTransactionDetailResponse cJRCSTTransactionDetailResponse) {
        this.response = cJRCSTTransactionDetailResponse;
    }
}
