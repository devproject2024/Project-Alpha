package net.one97.paytm.common.entity.flightticket;

import net.one97.paytm.common.entity.IJRDataModel;

public class CJROrderSummaryOrigin implements IJRDataModel {
    private String airport;
    private String city;
    private String iata;

    public String getAirport() {
        return this.airport;
    }

    public void setAirport(String str) {
        this.airport = str;
    }

    public String getIata() {
        return this.iata;
    }

    public void setIata(String str) {
        this.iata = str;
    }

    public String getCity() {
        return this.city;
    }

    public void setCity(String str) {
        this.city = str;
    }

    public String toString() {
        return "ClassPojo [airport = " + this.airport + ", iata = " + this.iata + ", city = " + this.city + "]";
    }
}
