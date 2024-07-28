package com.travel.train.model;

import net.one97.paytm.common.entity.IJRDataModel;

public final class CJRUtilityLocationModel implements IJRDataModel {
    private String addressLine;
    private String city;
    private String latitude;
    private String longitude;
    private String pinCode;
    private String state;

    public final String getCity() {
        return this.city;
    }

    public final void setCity(String str) {
        this.city = str;
    }

    public final String getState() {
        return this.state;
    }

    public final void setState(String str) {
        this.state = str;
    }

    public final String getPinCode() {
        return this.pinCode;
    }

    public final void setPinCode(String str) {
        this.pinCode = str;
    }

    public final String getAddressLine() {
        return this.addressLine;
    }

    public final void setAddressLine(String str) {
        this.addressLine = str;
    }

    public final String getLatitude() {
        return this.latitude;
    }

    public final void setLatitude(String str) {
        this.latitude = str;
    }

    public final String getLongitude() {
        return this.longitude;
    }

    public final void setLongitude(String str) {
        this.longitude = str;
    }
}
