package com.travel.flight.pojo.flightticket.Ancillary.request;

import java.util.ArrayList;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRFlightAncillaryReqBodyItemDetail implements IJRDataModel {
    private transient String date;
    private String destination;
    private String flight_number;
    private String origin;
    private ArrayList<CJRAncillarySsrsReqBody> ssrs = new ArrayList<>();

    public String getFlight_number() {
        return this.flight_number;
    }

    public void setFlight_number(String str) {
        this.flight_number = str;
    }

    public String getOrigin() {
        return this.origin;
    }

    public void setOrigin(String str) {
        this.origin = str;
    }

    public String getDestination() {
        return this.destination;
    }

    public void setDestination(String str) {
        this.destination = str;
    }

    public ArrayList<CJRAncillarySsrsReqBody> getSsrs() {
        return this.ssrs;
    }

    public void setSsrs(CJRAncillarySsrsReqBody cJRAncillarySsrsReqBody) {
        this.ssrs.add(cJRAncillarySsrsReqBody);
    }

    public String getDate() {
        return this.date;
    }
}
