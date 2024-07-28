package com.paytm.notification.models.request;

import com.google.gson.a.c;

public final class GeoLocation {
    @c(a = "city")
    private String city;
    @c(a = "country")
    private String country;
    @c(a = "latitude")
    private double latitude;
    @c(a = "longitude")
    private double longitude;
    @c(a = "region")
    private String region;

    public final double getLatitude() {
        return this.latitude;
    }

    public final void setLatitude(double d2) {
        this.latitude = d2;
    }

    public final double getLongitude() {
        return this.longitude;
    }

    public final void setLongitude(double d2) {
        this.longitude = d2;
    }

    public final String getCountry() {
        return this.country;
    }

    public final void setCountry(String str) {
        this.country = str;
    }

    public final String getRegion() {
        return this.region;
    }

    public final void setRegion(String str) {
        this.region = str;
    }

    public final String getCity() {
        return this.city;
    }

    public final void setCity(String str) {
        this.city = str;
    }
}
