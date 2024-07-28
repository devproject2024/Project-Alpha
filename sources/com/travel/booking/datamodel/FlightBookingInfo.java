package com.travel.booking.datamodel;

import com.google.gsonhtcfix.a.b;
import kotlin.g.b.k;

public final class FlightBookingInfo {
    private String bookingClass;
    private Boolean international;
    private String onwardArrivalTerminal = "";
    private String onwardDepartureTerminal = "";
    private String onwardDestinationAirport = "";
    private String onwardFlight = "";
    @b(a = "onward")
    private FlightTravelInfo onwardInfo;
    private String onwardOriginAirport = "";
    private String returnArrivalTerminal = "";
    private String returnDepartureTerminal = "";
    private String returnDestinationAirport = "";
    private String returnFlight = "";
    @b(a = "return")
    private FlightTravelInfo returnInfo;
    private String returnOriginAirport = "";

    public final String getBookingClass() {
        return this.bookingClass;
    }

    public final void setBookingClass(String str) {
        this.bookingClass = str;
    }

    public final Boolean getInternational() {
        return this.international;
    }

    public final void setInternational(Boolean bool) {
        this.international = bool;
    }

    public final String getOnwardOriginAirport() {
        return this.onwardOriginAirport;
    }

    public final void setOnwardOriginAirport(String str) {
        k.c(str, "<set-?>");
        this.onwardOriginAirport = str;
    }

    public final String getOnwardDestinationAirport() {
        return this.onwardDestinationAirport;
    }

    public final void setOnwardDestinationAirport(String str) {
        k.c(str, "<set-?>");
        this.onwardDestinationAirport = str;
    }

    public final String getReturnOriginAirport() {
        return this.returnOriginAirport;
    }

    public final void setReturnOriginAirport(String str) {
        k.c(str, "<set-?>");
        this.returnOriginAirport = str;
    }

    public final String getReturnDestinationAirport() {
        return this.returnDestinationAirport;
    }

    public final void setReturnDestinationAirport(String str) {
        k.c(str, "<set-?>");
        this.returnDestinationAirport = str;
    }

    public final String getOnwardArrivalTerminal() {
        return this.onwardArrivalTerminal;
    }

    public final void setOnwardArrivalTerminal(String str) {
        k.c(str, "<set-?>");
        this.onwardArrivalTerminal = str;
    }

    public final String getReturnArrivalTerminal() {
        return this.returnArrivalTerminal;
    }

    public final void setReturnArrivalTerminal(String str) {
        k.c(str, "<set-?>");
        this.returnArrivalTerminal = str;
    }

    public final String getOnwardFlight() {
        return this.onwardFlight;
    }

    public final void setOnwardFlight(String str) {
        k.c(str, "<set-?>");
        this.onwardFlight = str;
    }

    public final String getReturnFlight() {
        return this.returnFlight;
    }

    public final void setReturnFlight(String str) {
        k.c(str, "<set-?>");
        this.returnFlight = str;
    }

    public final String getOnwardDepartureTerminal() {
        return this.onwardDepartureTerminal;
    }

    public final void setOnwardDepartureTerminal(String str) {
        k.c(str, "<set-?>");
        this.onwardDepartureTerminal = str;
    }

    public final String getReturnDepartureTerminal() {
        return this.returnDepartureTerminal;
    }

    public final void setReturnDepartureTerminal(String str) {
        k.c(str, "<set-?>");
        this.returnDepartureTerminal = str;
    }

    public final FlightTravelInfo getOnwardInfo() {
        return this.onwardInfo;
    }

    public final void setOnwardInfo(FlightTravelInfo flightTravelInfo) {
        this.onwardInfo = flightTravelInfo;
    }

    public final FlightTravelInfo getReturnInfo() {
        return this.returnInfo;
    }

    public final void setReturnInfo(FlightTravelInfo flightTravelInfo) {
        this.returnInfo = flightTravelInfo;
    }
}
