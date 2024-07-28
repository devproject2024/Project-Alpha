package com.travel.booking.datamodel;

import com.google.gsonhtcfix.a.b;
import java.util.List;

public final class BookingInfo {
    private List<Action> actions;
    private String arrivalDate;
    private String bgImage;
    @b(a = "busInfo")
    private BusBookingInfo busBookingInfo;
    @b(a = "cityBusInfo")
    private CityBusBookingInfo cityBusBookingInfo;
    private String colorCode;
    private String departureDate;
    private String destination;
    @b(a = "flightInfo")
    private FlightBookingInfo flightBookingInfo;
    private String formattedAirlinenameandCode;
    private String formattedArrivalDate;
    private String formattedArrivalTime;
    private String formattedDepartureDate;
    private String formattedDepartureTime;
    private String formattedDuration;
    private String formattedPNR;
    private String formattedSeatInfo;
    @b(a = "hotelInfo")
    private HotelBookingInfo hotelBookingInfo;
    private Boolean isdatePassed;
    private String orderId;
    private String origin;
    private String refundStatus;
    private String returnformattedAirlinenameandCode;
    private String returnformattedArrivalDate;
    private String returnformattedArrivalTime;
    private String returnformattedDepartureDate;
    private String returnformattedDepartureTime;
    private String returnformattedDuration;
    private String status;
    @b(a = "trainInfo")
    private TrainBookingInfo trainBookingInfo;
    private String vertical;
    private String verticalLogo;

    public final String getOrderId() {
        return this.orderId;
    }

    public final void setOrderId(String str) {
        this.orderId = str;
    }

    public final String getOrigin() {
        return this.origin;
    }

    public final void setOrigin(String str) {
        this.origin = str;
    }

    public final String getDestination() {
        return this.destination;
    }

    public final void setDestination(String str) {
        this.destination = str;
    }

    public final String getRefundStatus() {
        return this.refundStatus;
    }

    public final void setRefundStatus(String str) {
        this.refundStatus = str;
    }

    public final String getVertical() {
        return this.vertical;
    }

    public final void setVertical(String str) {
        this.vertical = str;
    }

    public final String getBgImage() {
        return this.bgImage;
    }

    public final void setBgImage(String str) {
        this.bgImage = str;
    }

    public final String getArrivalDate() {
        return this.arrivalDate;
    }

    public final void setArrivalDate(String str) {
        this.arrivalDate = str;
    }

    public final String getVerticalLogo() {
        return this.verticalLogo;
    }

    public final void setVerticalLogo(String str) {
        this.verticalLogo = str;
    }

    public final String getDepartureDate() {
        return this.departureDate;
    }

    public final void setDepartureDate(String str) {
        this.departureDate = str;
    }

    public final List<Action> getActions() {
        return this.actions;
    }

    public final void setActions(List<Action> list) {
        this.actions = list;
    }

    public final String getColorCode() {
        return this.colorCode;
    }

    public final void setColorCode(String str) {
        this.colorCode = str;
    }

    public final String getStatus() {
        return this.status;
    }

    public final void setStatus(String str) {
        this.status = str;
    }

    public final BusBookingInfo getBusBookingInfo() {
        return this.busBookingInfo;
    }

    public final void setBusBookingInfo(BusBookingInfo busBookingInfo2) {
        this.busBookingInfo = busBookingInfo2;
    }

    public final TrainBookingInfo getTrainBookingInfo() {
        return this.trainBookingInfo;
    }

    public final void setTrainBookingInfo(TrainBookingInfo trainBookingInfo2) {
        this.trainBookingInfo = trainBookingInfo2;
    }

    public final FlightBookingInfo getFlightBookingInfo() {
        return this.flightBookingInfo;
    }

    public final void setFlightBookingInfo(FlightBookingInfo flightBookingInfo2) {
        this.flightBookingInfo = flightBookingInfo2;
    }

    public final HotelBookingInfo getHotelBookingInfo() {
        return this.hotelBookingInfo;
    }

    public final void setHotelBookingInfo(HotelBookingInfo hotelBookingInfo2) {
        this.hotelBookingInfo = hotelBookingInfo2;
    }

    public final CityBusBookingInfo getCityBusBookingInfo() {
        return this.cityBusBookingInfo;
    }

    public final void setCityBusBookingInfo(CityBusBookingInfo cityBusBookingInfo2) {
        this.cityBusBookingInfo = cityBusBookingInfo2;
    }

    public final String getFormattedDepartureTime() {
        return this.formattedDepartureTime;
    }

    public final void setFormattedDepartureTime(String str) {
        this.formattedDepartureTime = str;
    }

    public final String getFormattedDepartureDate() {
        return this.formattedDepartureDate;
    }

    public final void setFormattedDepartureDate(String str) {
        this.formattedDepartureDate = str;
    }

    public final String getFormattedArrivalTime() {
        return this.formattedArrivalTime;
    }

    public final void setFormattedArrivalTime(String str) {
        this.formattedArrivalTime = str;
    }

    public final String getFormattedArrivalDate() {
        return this.formattedArrivalDate;
    }

    public final void setFormattedArrivalDate(String str) {
        this.formattedArrivalDate = str;
    }

    public final String getFormattedSeatInfo() {
        return this.formattedSeatInfo;
    }

    public final void setFormattedSeatInfo(String str) {
        this.formattedSeatInfo = str;
    }

    public final String getFormattedPNR() {
        return this.formattedPNR;
    }

    public final void setFormattedPNR(String str) {
        this.formattedPNR = str;
    }

    public final String getFormattedAirlinenameandCode() {
        return this.formattedAirlinenameandCode;
    }

    public final void setFormattedAirlinenameandCode(String str) {
        this.formattedAirlinenameandCode = str;
    }

    public final Boolean getIsdatePassed() {
        return this.isdatePassed;
    }

    public final void setIsdatePassed(Boolean bool) {
        this.isdatePassed = bool;
    }

    public final String getReturnformattedAirlinenameandCode() {
        return this.returnformattedAirlinenameandCode;
    }

    public final void setReturnformattedAirlinenameandCode(String str) {
        this.returnformattedAirlinenameandCode = str;
    }

    public final String getReturnformattedDepartureTime() {
        return this.returnformattedDepartureTime;
    }

    public final void setReturnformattedDepartureTime(String str) {
        this.returnformattedDepartureTime = str;
    }

    public final String getReturnformattedDepartureDate() {
        return this.returnformattedDepartureDate;
    }

    public final void setReturnformattedDepartureDate(String str) {
        this.returnformattedDepartureDate = str;
    }

    public final String getReturnformattedArrivalTime() {
        return this.returnformattedArrivalTime;
    }

    public final void setReturnformattedArrivalTime(String str) {
        this.returnformattedArrivalTime = str;
    }

    public final String getReturnformattedArrivalDate() {
        return this.returnformattedArrivalDate;
    }

    public final void setReturnformattedArrivalDate(String str) {
        this.returnformattedArrivalDate = str;
    }

    public final String getReturnformattedDuration() {
        return this.returnformattedDuration;
    }

    public final void setReturnformattedDuration(String str) {
        this.returnformattedDuration = str;
    }

    public final String getFormattedDuration() {
        return this.formattedDuration;
    }

    public final void setFormattedDuration(String str) {
        this.formattedDuration = str;
    }

    public final boolean isBusBooking() {
        return this.busBookingInfo != null;
    }

    public final boolean isHotelBooking() {
        return this.hotelBookingInfo != null;
    }

    public final boolean isTrainBooking() {
        return this.trainBookingInfo != null;
    }

    public final boolean isFlightBooking() {
        return this.flightBookingInfo != null;
    }

    public final boolean isCityBusBooking() {
        return this.cityBusBookingInfo != null;
    }
}
