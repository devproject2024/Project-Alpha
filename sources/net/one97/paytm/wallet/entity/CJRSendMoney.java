package net.one97.paytm.wallet.entity;

import com.google.gsonhtcfix.a.b;
import net.one97.paytm.common.entity.CJRDataModelItem;

public class CJRSendMoney extends CJRDataModelItem {
    private static final long serialVersionUID = 1;
    private String amount;
    private String comment;
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

    public String getAmount() {
        return this.amount;
    }

    public void setAmount(String str) {
        this.amount = str;
    }

    public String getComment() {
        return this.comment;
    }

    public void setComment(String str) {
        this.comment = str;
    }
}
