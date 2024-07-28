package com.travel.booking.datamodel;

import java.util.List;

public final class FlightTravelInfo {
    private String airline_code;
    private String airline_logo;
    private String airline_name;
    private String arrival_time_airport;
    private String arrival_utc;
    private String backgroundImage;
    private String departure_formatted;
    private String departure_time_airport;
    private String departure_utc;
    private String duration;
    private Integer hop_count;
    private List<String> hop_names;
    private List<String> seats;
    private String verticalLogo;

    public final String getDeparture_time_airport() {
        return this.departure_time_airport;
    }

    public final void setDeparture_time_airport(String str) {
        this.departure_time_airport = str;
    }

    public final String getBackgroundImage() {
        return this.backgroundImage;
    }

    public final void setBackgroundImage(String str) {
        this.backgroundImage = str;
    }

    public final String getDeparture_formatted() {
        return this.departure_formatted;
    }

    public final void setDeparture_formatted(String str) {
        this.departure_formatted = str;
    }

    public final List<String> getSeats() {
        return this.seats;
    }

    public final void setSeats(List<String> list) {
        this.seats = list;
    }

    public final String getArrival_utc() {
        return this.arrival_utc;
    }

    public final void setArrival_utc(String str) {
        this.arrival_utc = str;
    }

    public final String getAirline_name() {
        return this.airline_name;
    }

    public final void setAirline_name(String str) {
        this.airline_name = str;
    }

    public final String getAirline_logo() {
        return this.airline_logo;
    }

    public final void setAirline_logo(String str) {
        this.airline_logo = str;
    }

    public final String getDuration() {
        return this.duration;
    }

    public final void setDuration(String str) {
        this.duration = str;
    }

    public final String getVerticalLogo() {
        return this.verticalLogo;
    }

    public final void setVerticalLogo(String str) {
        this.verticalLogo = str;
    }

    public final List<String> getHop_names() {
        return this.hop_names;
    }

    public final void setHop_names(List<String> list) {
        this.hop_names = list;
    }

    public final Integer getHop_count() {
        return this.hop_count;
    }

    public final void setHop_count(Integer num) {
        this.hop_count = num;
    }

    public final String getAirline_code() {
        return this.airline_code;
    }

    public final void setAirline_code(String str) {
        this.airline_code = str;
    }

    public final String getArrival_time_airport() {
        return this.arrival_time_airport;
    }

    public final void setArrival_time_airport(String str) {
        this.arrival_time_airport = str;
    }

    public final String getDeparture_utc() {
        return this.departure_utc;
    }

    public final void setDeparture_utc(String str) {
        this.departure_utc = str;
    }
}
