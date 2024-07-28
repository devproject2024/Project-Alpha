package com.travel.flight.pojo.flightticket;

import com.paytm.network.model.IJRPaytmDataModel;
import java.util.List;

public final class FlightSellingBundleResponse extends IJRPaytmDataModel {
    private String header;
    private List<FlightSellingBundleResponseData> partner_bundles;

    public FlightSellingBundleResponse(String str, List<FlightSellingBundleResponseData> list) {
        this.header = str;
        this.partner_bundles = list;
    }

    public final String getHeader() {
        return this.header;
    }

    public final List<FlightSellingBundleResponseData> getPartner_bundles() {
        return this.partner_bundles;
    }

    public final void setHeader(String str) {
        this.header = str;
    }

    public final void setPartner_bundles(List<FlightSellingBundleResponseData> list) {
        this.partner_bundles = list;
    }
}
