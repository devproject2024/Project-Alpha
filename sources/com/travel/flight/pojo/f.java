package com.travel.flight.pojo;

import java.io.Serializable;

public final class f implements Serializable {
    private int adult = 0;
    private int child = 0;
    private String dateDetail = "";
    private String destAirportName;
    private String destCityName;
    private String destCountryCode;
    private String destCountryName;
    private String destShortCityName;
    private int infant = 0;
    private boolean isNonstopSelected = false;
    private boolean isRoundTrip = false;
    private String sourceAirportName;
    private String sourceCityName;
    private String sourceCountryCode;
    private String sourceCountryName;
    private String sourceShortCityName;
    private String travellerDetails = "";
    private String travellerclass;

    public final String getSourceCityName() {
        return this.sourceCityName;
    }

    public final void setSourceCityName(String str) {
        this.sourceCityName = str;
    }

    public final String getSourceShortCityName() {
        return this.sourceShortCityName;
    }

    public final void setSourceShortCityName(String str) {
        this.sourceShortCityName = str;
    }

    public final String getDestCityName() {
        return this.destCityName;
    }

    public final void setDestCityName(String str) {
        this.destCityName = str;
    }

    public final String getDestShortCityName() {
        return this.destShortCityName;
    }

    public final void setDestShortCityName(String str) {
        this.destShortCityName = str;
    }

    public final String getDateDetail() {
        return this.dateDetail;
    }

    public final void setDateDetail(String str) {
        this.dateDetail = str;
    }

    public final String getTravellerDetails() {
        return this.travellerDetails;
    }

    public final void setTravellerDetails(String str) {
        this.travellerDetails = str;
    }

    public final boolean isRoundTrip() {
        return this.isRoundTrip;
    }

    public final void setRoundTrip(boolean z) {
        this.isRoundTrip = z;
    }

    public final String getSourceCountryName() {
        return this.sourceCountryName;
    }

    public final void setSourceCountryName(String str) {
        this.sourceCountryName = str;
    }

    public final String getDestCountryName() {
        return this.destCountryName;
    }

    public final void setDestCountryName(String str) {
        this.destCountryName = str;
    }

    public final String getSourceAirportName() {
        return this.sourceAirportName;
    }

    public final void setSourceAirportName(String str) {
        this.sourceAirportName = str;
    }

    public final String getDestAirportName() {
        return this.destAirportName;
    }

    public final void setDestAirportName(String str) {
        this.destAirportName = str;
    }

    public final int getAdult() {
        return this.adult;
    }

    public final void setAdult(int i2) {
        this.adult = i2;
    }

    public final int getChild() {
        return this.child;
    }

    public final void setChild(int i2) {
        this.child = i2;
    }

    public final int getInfant() {
        return this.infant;
    }

    public final void setInfant(int i2) {
        this.infant = i2;
    }

    public final String getTravellerclass() {
        return this.travellerclass;
    }

    public final void setTravellerclass(String str) {
        this.travellerclass = str;
    }

    public final boolean isNonstopSelected() {
        return this.isNonstopSelected;
    }

    public final void setNonstopSelected(boolean z) {
        this.isNonstopSelected = z;
    }

    public final String getSourceCountryCode() {
        return this.sourceCountryCode;
    }

    public final void setSourceCountryCode(String str) {
        this.sourceCountryCode = str;
    }

    public final String getDestCountryCode() {
        return this.destCountryCode;
    }

    public final void setDestCountryCode(String str) {
        this.destCountryCode = str;
    }
}
