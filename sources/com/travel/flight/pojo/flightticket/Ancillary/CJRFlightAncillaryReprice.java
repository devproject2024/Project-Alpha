package com.travel.flight.pojo.flightticket.Ancillary;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import com.travel.flight.pojo.flightticket.CJROnwardReturnFlightInformation;
import com.travel.flight.pojo.flightticket.CJRStatus;

public class CJRFlightAncillaryReprice extends IJRPaytmDataModel {
    private static final long serialVersionUID = 1;
    @b(a = "body")
    private CJROnwardReturnFlightInformation mOnwardReturnFlights;
    @b(a = "status")
    private CJRStatus mStatus;

    public CJRStatus getmStatus() {
        return this.mStatus;
    }

    public CJROnwardReturnFlightInformation getmOnwardReturnFlights() {
        return this.mOnwardReturnFlights;
    }
}
