package net.one97.paytm.passbook.beans.statement;

import com.google.gsonhtcfix.a.b;
import net.one97.paytm.passbook.mapping.IJRDataModel;

public class CJRPassbookStatementDownloadResponse extends IJRDataModel {
    @b(a = "metadata")
    private String mMetadata;
    @b(a = "orderId")
    private String mOrderId;
    @b(a = "requestGuid")
    private String mRequestGuid;
    @b(a = "response")
    private String mResponse;
    @b(a = "status")
    private String mStatus;
    @b(a = "statusCode")
    private String mStatusCode;
    @b(a = "statusMessage")
    private String mStatusMessage;
    @b(a = "type")
    private String mType;

    public String getType() {
        return this.mType;
    }

    public String getRequestGuid() {
        return this.mRequestGuid;
    }

    public String getOrderId() {
        return this.mOrderId;
    }

    public String getStatus() {
        return this.mStatus;
    }

    public String getStatusCode() {
        return this.mStatusCode;
    }

    public String getStatusMessage() {
        return this.mStatusMessage;
    }

    public String getResponse() {
        return this.mResponse;
    }

    public String getMetadata() {
        return this.mMetadata;
    }
}
