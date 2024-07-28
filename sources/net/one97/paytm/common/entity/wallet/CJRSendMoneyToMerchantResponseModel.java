package net.one97.paytm.common.entity.wallet;

import com.google.gsonhtcfix.a.b;
import net.one97.paytm.common.entity.CJRDataModelItem;

public class CJRSendMoneyToMerchantResponseModel extends CJRDataModelItem {
    public static final String STATUS_SUCCESS = "SUCCESS";
    private static final long serialVersionUID = 1;
    @b(a = "orderId")
    private String mOrderId;
    @b(a = "requestGuid")
    private String mRequestGuid;
    @b(a = "response")
    private CJRSendMoneyToMerchantResponse mResponse;
    @b(a = "status")
    private String mStatus;
    @b(a = "statusCode")
    private String mStatusCode;
    @b(a = "statusMessage")
    private String mStatusMessage;
    @b(a = "type")
    private String mType;

    public String getName() {
        return null;
    }

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

    public CJRSendMoneyToMerchantResponse getResponse() {
        return this.mResponse;
    }

    public String toString() {
        return "CJRSendMoneyToMerchantResponseModel{mType='" + this.mType + '\'' + ", mRequestGuid='" + this.mRequestGuid + '\'' + ", mOrderId='" + this.mOrderId + '\'' + ", mStatus='" + this.mStatus + '\'' + ", mStatusCode='" + this.mStatusCode + '\'' + ", mStatusMessage='" + this.mStatusMessage + '\'' + ", mResponse=" + this.mResponse + '}';
    }
}
