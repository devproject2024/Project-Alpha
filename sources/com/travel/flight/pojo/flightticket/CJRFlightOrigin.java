package com.travel.flight.pojo.flightticket;

import com.google.gsonhtcfix.a.b;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRFlightOrigin implements IJRDataModel {
    @b(a = "airport")
    private String flightOriginAirport;
    @b(a = "city")
    private String flightOriginCity;
    @b(a = "iata")
    private String flightOriginCode;

    public String getFlightOriginCode() {
        return this.flightOriginCode;
    }

    public void setFlightOriginCode(String str) {
        this.flightOriginCode = str;
    }

    public String getFlightOriginCity() {
        return this.flightOriginCity;
    }

    public void setFlightOriginCity(String str) {
        this.flightOriginCity = str;
    }

    public String getFlightOriginAirport() {
        return this.flightOriginAirport;
    }

    public void setFlightOriginAirport(String str) {
        this.flightOriginAirport = str;
    }
}
