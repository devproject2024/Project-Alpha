package net.one97.paytm.common.entity.wallet;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRValidateTransaction extends IJRPaytmDataModel implements IJRDataModel {
    @b(a = "response")
    private CJRSendMoneyResponse mResponse;
    @b(a = "status")
    private String mStatus;
    @b(a = "statusCode")
    private String mStatusCode;
    @b(a = "statusMessage")
    private String mStatusMessage;
    @b(a = "type")
    private String mType;
    @b(a = "orderId")
    private String orderId;
    @b(a = "requestGuid")
    private String reuestGuid;

    public String getStatus() {
        return this.mStatus;
    }

    public String getStatusCode() {
        return this.mStatusCode;
    }

    public String getStatusMessage() {
        return this.mStatusMessage;
    }

    public String getrequestGUID() {
        return this.reuestGuid;
    }

    public String getorderId() {
        return this.orderId;
    }

    public CJRSendMoneyResponse getResponse() {
        return this.mResponse;
    }

    public String getType() {
        return this.mType;
    }

    public void setType(String str) {
        this.mType = str;
    }
}
