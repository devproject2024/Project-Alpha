package com.travel.flight.pojo.flightticket;

import net.one97.paytm.common.entity.IJRDataModel;

public class FlightSearchResultMetaQuery implements IJRDataModel {
    private String accept;
    private String adults;
    private String children;
    private String departureDate;
    private String destination;
    private String destination_city;
    private String destination_country;
    private String destination_country_code;
    private String infants;
    private String journey_type;
    private String origin;
    private String origin_city;
    private String origin_country;
    private String origin_country_code;
    private String returnDate;
    private String traveller_class;

    public String getDestination_country() {
        return this.destination_country;
    }

    public void setDestination_country(String str) {
        this.destination_country = str;
    }

    public String getInfants() {
        return this.infants;
    }

    public void setInfants(String str) {
        this.infants = str;
    }

    public String getAdults() {
        return this.adults;
    }

    public void setAdults(String str) {
        this.adults = str;
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

    public String getOrigin_country_code() {
        return this.origin_country_code;
    }

    public void setOrigin_country_code(String str) {
        this.origin_country_code = str;
    }

    public String getDestination_city() {
        return this.destination_city;
    }

    public void setDestination_city(String str) {
        this.destination_city = str;
    }

    public String getOrigin_country() {
        return this.origin_country;
    }

    public void setOrigin_country(String str) {
        this.origin_country = str;
    }

    public String getAccept() {
        return this.accept;
    }

    public void setAccept(String str) {
        this.accept = str;
    }

    public String getOrigin_city() {
        return this.origin_city;
    }

    public void setOrigin_city(String str) {
        this.origin_city = str;
    }

    public String getReturnDate() {
        return this.returnDate;
    }

    public void setReturnDate(String str) {
        this.returnDate = str;
    }

    public String getTraveller_class() {
        return this.traveller_class;
    }

    public void setTraveller_class(String str) {
        this.traveller_class = str;
    }

    public String getChildren() {
        return this.children;
    }

    public void setChildren(String str) {
        this.children = str;
    }

    public String getDestination_country_code() {
        return this.destination_country_code;
    }

    public void setDestination_country_code(String str) {
        this.destination_country_code = str;
    }

    public String getDepartureDate() {
        return this.departureDate;
    }

    public void setDepartureDate(String str) {
        this.departureDate = str;
    }

    public String getJourney_type() {
        return this.journey_type;
    }

    public void setJourney_type(String str) {
        this.journey_type = str;
    }
}
