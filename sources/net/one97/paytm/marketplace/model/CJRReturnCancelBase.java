package net.one97.paytm.marketplace.model;

import com.google.gsonhtcfix.a.b;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRReturnCancelBase implements IJRDataModel {
    private static final long serialVersionUID = 1;
    @b(a = "cancelled_at")
    private String cancelledTime;
    @b(a = "fulfillment_id")
    private String fulfillmentId;
    @b(a = "item_id")
    private String itemId;
    @b(a = "merchant_id")
    private String merchantID;
    @b(a = "order_id")
    private String orderId;
    @b(a = "return_request_cancel_title")
    private String requestCancelTitle;
    @b(a = "result")
    private String result;
    @b(a = "display")
    private CJRReturnCancelError returnCancelError;

    public String getOrderId() {
        return this.orderId;
    }

    public String getItemId() {
        return this.itemId;
    }

    public String getFulfillmentId() {
        return this.fulfillmentId;
    }

    public String getMerchantID() {
        return this.merchantID;
    }

    public String getResult() {
        return this.result;
    }

    public String getRequestCancelTitle() {
        return this.requestCancelTitle;
    }

    public String getCancelledTime() {
        return this.cancelledTime;
    }

    public CJRReturnCancelError getReturnCancelError() {
        return this.returnCancelError;
    }
}
