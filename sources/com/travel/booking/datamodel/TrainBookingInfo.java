package com.travel.booking.datamodel;

import java.util.List;

public final class TrainBookingInfo {
    private String journeyClass;
    private String journeyQuota;
    private String pnrNumber;
    private List<String> seats;
    private String trainName;
    private String trainNumber;

    public final String getTrainName() {
        return this.trainName;
    }

    public final void setTrainName(String str) {
        this.trainName = str;
    }

    public final String getJourneyQuota() {
        return this.journeyQuota;
    }

    public final void setJourneyQuota(String str) {
        this.journeyQuota = str;
    }

    public final String getTrainNumber() {
        return this.trainNumber;
    }

    public final void setTrainNumber(String str) {
        this.trainNumber = str;
    }

    public final List<String> getSeats() {
        return this.seats;
    }

    public final void setSeats(List<String> list) {
        this.seats = list;
    }

    public final String getJourneyClass() {
        return this.journeyClass;
    }

    public final void setJourneyClass(String str) {
        this.journeyClass = str;
    }

    public final String getPnrNumber() {
        return this.pnrNumber;
    }

    public final void setPnrNumber(String str) {
        this.pnrNumber = str;
    }
}
