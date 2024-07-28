package com.travel.flight.pojo.flightticket;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;

public class CJRAirportCity extends IJRPaytmDataModel {
    @b(a = "body")
    private CJRAirportCityItemBody cjrAirportCityItemBody;

    public CJRAirportCityItemBody getCjrAirportCityItemBody() {
        return this.cjrAirportCityItemBody;
    }

    public void setCjrAirportCityItemBody(CJRAirportCityItemBody cJRAirportCityItemBody) {
        this.cjrAirportCityItemBody = cJRAirportCityItemBody;
    }
}
