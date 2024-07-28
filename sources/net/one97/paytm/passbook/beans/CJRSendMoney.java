package net.one97.paytm.passbook.beans;

import com.google.gsonhtcfix.a.b;

public class CJRSendMoney extends CJRDataModelItem {
    private static final long serialVersionUID = 1;
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

    public String getName() {
        return null;
    }

    public String getmStatus() {
        return this.mStatus;
    }

    public void setmStatus(String str) {
        this.mStatus = str;
    }

    public String getmStatusMessage() {
        return this.mStatusMessage;
    }

    public void setmStatusMessage(String str) {
        this.mStatusMessage = str;
    }

    public CJRSendMoneyResponse getmResponse() {
        return this.mResponse;
    }

    public void setmResponse(CJRSendMoneyResponse cJRSendMoneyResponse) {
        this.mResponse = cJRSendMoneyResponse;
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
}
