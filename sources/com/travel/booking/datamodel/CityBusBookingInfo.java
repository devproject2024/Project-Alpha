package com.travel.booking.datamodel;

public final class CityBusBookingInfo {
    private CityBusRouteInfo busInfo;
    private String expiryTime;
    private String formattedPassengerCount;
    private String formattedTotalAmount;
    private Integer passengerCount;
    private String tokenId;
    private String totalAmount;

    public final String getTokenId() {
        return this.tokenId;
    }

    public final void setTokenId(String str) {
        this.tokenId = str;
    }

    public final String getTotalAmount() {
        return this.totalAmount;
    }

    public final void setTotalAmount(String str) {
        this.totalAmount = str;
    }

    public final String getFormattedTotalAmount() {
        return this.formattedTotalAmount;
    }

    public final void setFormattedTotalAmount(String str) {
        this.formattedTotalAmount = str;
    }

    public final Integer getPassengerCount() {
        return this.passengerCount;
    }

    public final void setPassengerCount(Integer num) {
        this.passengerCount = num;
    }

    public final String getFormattedPassengerCount() {
        return this.formattedPassengerCount;
    }

    public final void setFormattedPassengerCount(String str) {
        this.formattedPassengerCount = str;
    }

    public final String getExpiryTime() {
        return this.expiryTime;
    }

    public final void setExpiryTime(String str) {
        this.expiryTime = str;
    }

    public final CityBusRouteInfo getBusInfo() {
        return this.busInfo;
    }

    public final void setBusInfo(CityBusRouteInfo cityBusRouteInfo) {
        this.busInfo = cityBusRouteInfo;
    }
}
