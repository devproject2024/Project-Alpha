package com.travel.flight.pojo.flightticket.FareRules;

import net.one97.paytm.common.entity.IJRDataModel;

public class CJRFareRulesJorneyRoute implements IJRDataModel {
    private String airlineCode;
    private String destination;
    private String origin;

    public String getAirlineCode() {
        return this.airlineCode;
    }

    public void setAirlineCode(String str) {
        this.airlineCode = str;
    }

    public String getOrigin() {
        return this.origin;
    }

    public String getDestination() {
        return this.destination;
    }
}
