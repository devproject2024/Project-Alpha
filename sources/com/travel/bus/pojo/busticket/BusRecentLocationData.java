package com.travel.bus.pojo.busticket;

import net.one97.paytm.common.entity.IJRDataModel;

public class BusRecentLocationData implements IJRDataModel {
    private Double latitude;
    private Double longitude;
    private String placeId;
    private String primaryText;
    private String secondaryText;

    public String getPrimaryText() {
        return this.primaryText;
    }

    public void setPrimaryText(String str) {
        this.primaryText = str;
    }

    public String getSecondaryText() {
        return this.secondaryText;
    }

    public void setSecondaryText(String str) {
        this.secondaryText = str;
    }

    public Double getLatitude() {
        return this.latitude;
    }

    public void setLatitude(Double d2) {
        this.latitude = d2;
    }

    public Double getLongitude() {
        return this.longitude;
    }

    public void setLongitude(Double d2) {
        this.longitude = d2;
    }

    public String getPlaceId() {
        return this.placeId;
    }

    public void setPlaceId(String str) {
        this.placeId = str;
    }
}
