package com.travel.train.model.trainticket;

import com.google.gsonhtcfix.a.a;
import com.google.gsonhtcfix.a.b;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRTrainLSStation implements IJRDataModel {
    @a
    @b(a = "actual_arrival_date")
    private String actual_arrival_date;
    @a
    @b(a = "actual_arrival_time")
    private String actual_arrival_time;
    @a
    @b(a = "actual_departure_date")
    private String actual_departure_date;
    @a
    @b(a = "actual_departure_time")
    private String actual_departure_time;
    @a
    @b(a = "arrivalTime")
    private String arrivalTime;
    @a
    @b(a = "dayCount")
    private String dayCount;
    @a
    @b(a = "departureTime")
    private String departureTime;
    @a
    @b(a = "distance")
    private String distance;
    @a
    @b(a = "expected_platform")
    private String expected_platform;
    @a
    @b(a = "haltTime")
    private String haltTime;
    private boolean isChanged;
    @a
    @b(a = "routeNumber")
    private String routeNumber;
    @a
    @b(a = "stationCode")
    private String stationCode;
    @a
    @b(a = "stationName")
    private String stationName;
    @a
    @b(a = "stnSerialNumber")
    private String stnSerialNumber;

    public String getDistance() {
        return this.distance;
    }

    public String getDepartureTime() {
        return this.departureTime;
    }

    public String getRouteNumber() {
        return this.routeNumber;
    }

    public String getStationName() {
        return this.stationName;
    }

    public String getDayCount() {
        return this.dayCount;
    }

    public String getStnSerialNumber() {
        return this.stnSerialNumber;
    }

    public String getHaltTime() {
        return this.haltTime;
    }

    public String getArrivalTime() {
        return this.arrivalTime;
    }

    public String getStationCode() {
        return this.stationCode;
    }

    public String getActualArrivalDate() {
        return this.actual_arrival_date;
    }

    public String getActualArrivalTime() {
        return this.actual_arrival_time;
    }

    public String getActualDepartureDate() {
        return this.actual_departure_date;
    }

    public String getActualDepartureTime() {
        return this.actual_departure_time;
    }

    public String getExpectedPlatform() {
        return this.expected_platform;
    }

    public boolean getIsChanged() {
        return this.isChanged;
    }

    public void setIsChanged(boolean z) {
        this.isChanged = z;
    }
}
