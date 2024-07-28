package com.travel.flight.pojo.flightticket;

import com.paytm.network.model.IJRPaytmDataModel;

public final class FlightBundle extends IJRPaytmDataModel {
    private FlightSellingBundleResponse data;
    private Integer status_code;

    public FlightBundle(Integer num, FlightSellingBundleResponse flightSellingBundleResponse) {
        this.status_code = num;
        this.data = flightSellingBundleResponse;
    }

    public final FlightSellingBundleResponse getData() {
        return this.data;
    }

    public final Integer getStatus_code() {
        return this.status_code;
    }

    public final void setData(FlightSellingBundleResponse flightSellingBundleResponse) {
        this.data = flightSellingBundleResponse;
    }

    public final void setStatus_code(Integer num) {
        this.status_code = num;
    }
}
