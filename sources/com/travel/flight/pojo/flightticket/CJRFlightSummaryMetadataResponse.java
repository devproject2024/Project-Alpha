package com.travel.flight.pojo.flightticket;

import com.google.gsonhtcfix.a.b;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRFlightSummaryMetadataResponse implements IJRDataModel {
    @b(a = "insurance_type")
    private String insuranceType;

    public String getInsuranceType() {
        return this.insuranceType;
    }
}
