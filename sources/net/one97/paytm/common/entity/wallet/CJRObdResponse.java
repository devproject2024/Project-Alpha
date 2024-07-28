package net.one97.paytm.common.entity.wallet;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;

public class CJRObdResponse extends IJRPaytmDataModel {
    private static final long serialVersionUID = 1;
    @b(a = "orderId")
    private String mOrderId;
    @b(a = "requestGuid")
    private String mRequestGuid;
    @b(a = "status")
    private String mStatus;
    @b(a = "statusCode")
    private String mStatusCode;
    @b(a = "statusMessage")
    private String mStatusMessage;

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
}
