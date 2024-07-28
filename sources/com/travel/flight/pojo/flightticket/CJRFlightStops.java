package com.travel.flight.pojo.flightticket;

import com.google.gsonhtcfix.a.b;
import java.util.List;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRFlightStops implements Cloneable, IJRDataModel {
    private static final long serialVersionUID = 1;
    @b(a = "additional_info")
    private CJRFlightsAdditionalInfo additionalInfo;
    @b(a = "airline")
    private String mAirLine;
    @b(a = "airlineCode")
    private String mAirLineCode;
    @b(a = "aircraftTypeDisplayName")
    private String mAircraftTypeDisplayName;
    @b(a = "amenities")
    private List<String> mAmenities;
    @b(a = "arrivalTerminal")
    private String mArrivalTerminal;
    @b(a = "arrivalTimeLocal")
    private String mArrivalTime;
    @b(a = "departureTerminal")
    private String mDepartureTerminal;
    @b(a = "departureTimeLocal")
    private String mDepartureTime;
    @b(a = "destination")
    private String mDestination;
    @b(a = "destination_airport")
    private String mDestinationAirport;
    @b(a = "destination_city")
    private String mDestinationCity;
    @b(a = "duration")
    private String mDuration;
    @b(a = "flightNumber")
    private String mFlightNumber;
    @b(a = "inclusions")
    private List<String> mInclusions;
    @b(a = "layover")
    private String mLayover;
    @b(a = "notes")
    private List<String> mNotes;
    @b(a = "origin")
    private String mOrigin;
    @b(a = "origin_airport")
    private String mOriginAirport;
    @b(a = "origin_city")
    private String mOriginCity;

    public String getmFlightNumber() {
        return this.mFlightNumber;
    }

    public void setmFlightNumber(String str) {
        this.mFlightNumber = str;
    }

    public String getmOrigin() {
        return this.mOrigin;
    }

    public void setmOrigin(String str) {
        this.mOrigin = str;
    }

    public String getmDestination() {
        return this.mDestination;
    }

    public void setmDestination(String str) {
        this.mDestination = str;
    }

    public String getmArrivalTime() {
        return this.mArrivalTime;
    }

    public void setmArrivalTime(String str) {
        this.mArrivalTime = str;
    }

    public String getmAirLineCode() {
        return this.mAirLineCode;
    }

    public void setmAirLineCode(String str) {
        this.mAirLineCode = str;
    }

    public String getmDepartureTime() {
        return this.mDepartureTime;
    }

    public void setmDepartureTime(String str) {
        this.mDepartureTime = str;
    }

    public String getmDuration() {
        return this.mDuration;
    }

    public void setmDuration(String str) {
        this.mDuration = str;
    }

    public String getmAirLine() {
        return this.mAirLine;
    }

    public void setmAirLine(String str) {
        this.mAirLine = str;
    }

    public String getmLayover() {
        return this.mLayover;
    }

    public void setmLayover(String str) {
        this.mLayover = str;
    }

    public String getOriginCity() {
        return this.mOriginCity;
    }

    public String getOriginAirport() {
        return this.mOriginAirport;
    }

    public String getDestinationCity() {
        return this.mDestinationCity;
    }

    public String getDestinationAirport() {
        return this.mDestinationAirport;
    }

    public CJRFlightStops clone() throws CloneNotSupportedException {
        return (CJRFlightStops) super.clone();
    }

    public String getDepartureTerminal() {
        return this.mDepartureTerminal;
    }

    public void setDepartureTerminal(String str) {
        this.mDepartureTerminal = str;
    }

    public String getArrivalTerminal() {
        return this.mArrivalTerminal;
    }

    public void setArrivalTerminal(String str) {
        this.mArrivalTerminal = str;
    }

    public void setmAmenities(List<String> list) {
        this.mAmenities = list;
    }

    public String getmInclusions() {
        String str = "";
        if (this.mInclusions != null) {
            for (int i2 = 0; i2 < this.mInclusions.size(); i2++) {
                str = str + this.mInclusions.get(i2) + ". ";
            }
        }
        return str;
    }

    public void setmInclusions(List<String> list) {
        this.mInclusions = list;
    }

    public String getmNotes() {
        String str = "";
        if (this.mNotes != null) {
            for (int i2 = 0; i2 < this.mNotes.size(); i2++) {
                str = str + this.mNotes.get(i2) + ". ";
            }
        }
        return str.trim();
    }

    public void setmNotes(List<String> list) {
        this.mNotes = list;
    }

    public CJRFlightsAdditionalInfo getAdditionalInfo() {
        return this.additionalInfo;
    }

    public void setAdditionalInfo(CJRFlightsAdditionalInfo cJRFlightsAdditionalInfo) {
        this.additionalInfo = cJRFlightsAdditionalInfo;
    }

    public String getmAircraftTypeDisplayName() {
        return this.mAircraftTypeDisplayName;
    }

    public void setmAircraftTypeDisplayName(String str) {
        this.mAircraftTypeDisplayName = str;
    }
}
