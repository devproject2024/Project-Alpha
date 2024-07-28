package com.travel.flight.pojo.flightticket.Ancillary;

import com.google.gsonhtcfix.a.b;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRAncillaryItemDetail implements IJRDataModel {
    private static final long serialVersionUID = 1;
    @b(a = "departure_date")
    private String departureDate;
    @b(a = "destination")
    private String destination;
    @b(a = "flight_number")
    private String flightNumber;
    private int hopsindex = 0;
    private boolean isonwardJrny = true;
    @b(a = "validations")
    private CJRAncillaryItemValidations itemValidations;
    @b(a = "origin")
    private String mOrigin;
    private int passengarId = 0;
    @b(a = "ssrs")
    private CJRAncillarySSRSItem ssrsItem;

    public String getFlightNumber() {
        return this.flightNumber;
    }

    public void setFlightNumber(String str) {
        this.flightNumber = str;
    }

    public String getmOrigin() {
        return this.mOrigin;
    }

    public void setmOrigin(String str) {
        this.mOrigin = str;
    }

    public String getDestination() {
        return this.destination;
    }

    public void setDestination(String str) {
        this.destination = str;
    }

    public String getDepartureDate() {
        return this.departureDate;
    }

    public void setDepartureDate(String str) {
        this.departureDate = str;
    }

    public CJRAncillarySSRSItem getSsrsItem() {
        return this.ssrsItem;
    }

    public CJRAncillaryItemValidations getItemValidations() {
        return this.itemValidations;
    }

    public void setItemValidations(CJRAncillaryItemValidations cJRAncillaryItemValidations) {
        this.itemValidations = cJRAncillaryItemValidations;
    }

    public boolean isIsonwardJrny() {
        return this.isonwardJrny;
    }

    public void setIsonwardJrny(boolean z) {
        this.isonwardJrny = z;
    }

    public int getHopsindex() {
        return this.hopsindex;
    }

    public void setHopsindex(int i2) {
        this.hopsindex = i2;
    }

    public int getPassengarId() {
        return this.passengarId;
    }

    public void setPassengarId(int i2) {
        this.passengarId = i2;
    }
}
