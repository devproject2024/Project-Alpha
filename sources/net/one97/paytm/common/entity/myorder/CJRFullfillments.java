package net.one97.paytm.common.entity.myorder;

import com.google.gsonhtcfix.a.b;
import net.one97.paytm.common.entity.IJRDataModel;

public final class CJRFullfillments implements IJRDataModel {
    @b(a = "fulfillment_service_id")
    private Long fulfillmentServiceId = 0L;
    @b(a = "fulfillment_price")
    private double fulfillment_price;
    @b(a = "fulfillment_response")
    private FullfillmentResponse fullfillmentResponse;
    @b(a = "id")
    private Long id;
    @b(a = "status")
    private Integer status;
    @b(a = "status_text")
    private String statusText;

    public final Long getId() {
        return this.id;
    }

    public final void setId(Long l) {
        this.id = l;
    }

    public final Integer getStatus() {
        return this.status;
    }

    public final void setStatus(Integer num) {
        this.status = num;
    }

    public final Long getFulfillmentServiceId() {
        return this.fulfillmentServiceId;
    }

    public final void setFulfillmentServiceId(Long l) {
        this.fulfillmentServiceId = l;
    }

    public final FullfillmentResponse getFullfillmentResponse() {
        return this.fullfillmentResponse;
    }

    public final void setFullfillmentResponse(FullfillmentResponse fullfillmentResponse2) {
        this.fullfillmentResponse = fullfillmentResponse2;
    }

    public final String getStatusText() {
        return this.statusText;
    }

    public final void setStatusText(String str) {
        this.statusText = str;
    }

    public final double getFulfillment_price() {
        return this.fulfillment_price;
    }

    public final void setFulfillment_price(double d2) {
        this.fulfillment_price = d2;
    }
}
