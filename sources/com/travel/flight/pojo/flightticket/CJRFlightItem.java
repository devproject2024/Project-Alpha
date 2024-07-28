package com.travel.flight.pojo.flightticket;

import com.google.gsonhtcfix.a.b;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRFlightItem implements IJRDataModel {
    @b(a = "class")
    private String _class;
    @b(a = "airline")
    private String airline;
    @b(a = "airline_code")
    private String airlineCode;
    @b(a = "arrival_time")
    private String arrivalTime;
    @b(a = "arrival_time_local")
    private String arrivalTimeLocal;
    @b(a = "departure_time")
    private String departureTime;
    @b(a = "departure_time_local")
    private String departureTimeLocal;
    @b(a = "duration")
    private String duration;
    @b(a = "airline_color_code")
    private String flightColorCode;
    @b(a = "flight_no")
    private String flightNo;
    @b(a = "layover")
    private String layover;
    @b(a = "origin")
    private CJRFlightOrigin origin;
    @b(a = "terminal")
    private String terminal;

    public String getFlightColorCode() {
        return this.flightColorCode;
    }

    public void setFlightColorCode(String str) {
        this.flightColorCode = str;
    }

    public CJRFlightOrigin getOrigin() {
        return this.origin;
    }

    public void setOrigin(CJRFlightOrigin cJRFlightOrigin) {
        this.origin = cJRFlightOrigin;
    }

    public String getAirline() {
        return this.airline;
    }

    public void setAirline(String str) {
        this.airline = str;
    }

    public String getAirlineCode() {
        return this.airlineCode;
    }

    public void setAirlineCode(String str) {
        this.airlineCode = str;
    }

    public String get_class() {
        return this._class;
    }

    public void set_class(String str) {
        this._class = str;
    }

    public String getDepartureTime() {
        return this.departureTime;
    }

    public void setDepartureTime(String str) {
        this.departureTime = str;
    }

    public String getDepartureTimeLocal() {
        return this.departureTimeLocal;
    }

    public void setDepartureTimeLocal(String str) {
        this.departureTimeLocal = str;
    }

    public String getArrivalTime() {
        return this.arrivalTime;
    }

    public void setArrivalTime(String str) {
        this.arrivalTime = str;
    }

    public String getArrivalTimeLocal() {
        return this.arrivalTimeLocal;
    }

    public void setArrivalTimeLocal(String str) {
        this.arrivalTimeLocal = str;
    }

    public String getLayover() {
        return this.layover;
    }

    public void setLayover(String str) {
        this.layover = str;
    }

    public String getDuration() {
        return this.duration;
    }

    public void setDuration(String str) {
        this.duration = str;
    }

    public String getTerminal() {
        return this.terminal;
    }

    public void setTerminal(String str) {
        this.terminal = str;
    }

    public String getFlightNo() {
        return this.flightNo;
    }

    public void setFlightNo(String str) {
        this.flightNo = str;
    }
}
