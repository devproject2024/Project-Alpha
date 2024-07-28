package net.one97.paytm.common.entity.flightticket;

import net.one97.paytm.common.entity.IJRDataModel;

public class CJROrderSummaryFulfillment implements IJRDataModel {
    private CJROrderSummaryFulfillmentResponse fulfillment_response;

    public CJROrderSummaryFulfillmentResponse getFulfillment_response() {
        return this.fulfillment_response;
    }

    public void setFulfillment_response(CJROrderSummaryFulfillmentResponse cJROrderSummaryFulfillmentResponse) {
        this.fulfillment_response = cJROrderSummaryFulfillmentResponse;
    }
}
