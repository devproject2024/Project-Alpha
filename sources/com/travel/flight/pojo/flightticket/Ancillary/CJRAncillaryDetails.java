package com.travel.flight.pojo.flightticket.Ancillary;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import com.travel.flight.pojo.flightticket.CJRStatus;

public class CJRAncillaryDetails extends IJRPaytmDataModel {
    private static final long serialVersionUID = 1;
    @b(a = "body")
    private CJRAncillaryBodyDetails body;
    @b(a = "status")
    private CJRStatus mStatus;

    public CJRStatus getmStatus() {
        return this.mStatus;
    }

    public CJRAncillaryBodyDetails getBody() {
        return this.body;
    }
}
