package com.travel.booking.datamodel;

import java.util.List;

public final class BusBookingInfo {
    private String busType;
    private String duration;
    private String operatorName;
    private List<String> seats;

    public final String getDuration() {
        return this.duration;
    }

    public final void setDuration(String str) {
        this.duration = str;
    }

    public final String getBusType() {
        return this.busType;
    }

    public final void setBusType(String str) {
        this.busType = str;
    }

    public final String getOperatorName() {
        return this.operatorName;
    }

    public final void setOperatorName(String str) {
        this.operatorName = str;
    }

    public final List<String> getSeats() {
        return this.seats;
    }

    public final void setSeats(List<String> list) {
        this.seats = list;
    }
}
