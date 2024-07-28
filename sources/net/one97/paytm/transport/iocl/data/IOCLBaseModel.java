package net.one97.paytm.transport.iocl.data;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import net.one97.paytm.common.entity.IJRDataModel;

public class IOCLBaseModel extends IJRPaytmDataModel implements IJRDataModel {
    @b(a = "requestId")
    private String requestId;
    @b(a = "response")
    private IOCLCommonResponse response;
    @b(a = "status")
    private String status;
    @b(a = "statusCode")
    private String statusCode;
    @b(a = "statusMessage")
    private String statusMessage;

    public String getRequestId() {
        return this.requestId;
    }

    public void setRequestId(String str) {
        this.requestId = str;
    }

    public String getStatusCode() {
        return this.statusCode;
    }

    public void setStatusCode(String str) {
        this.statusCode = str;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String str) {
        this.status = str;
    }

    public String getStatusMessage() {
        return this.statusMessage;
    }

    public void setStatusMessage(String str) {
        this.statusMessage = str;
    }

    public IOCLCommonResponse getResponse() {
        return this.response;
    }

    public void setResponse(IOCLCommonResponse iOCLCommonResponse) {
        this.response = iOCLCommonResponse;
    }
}
