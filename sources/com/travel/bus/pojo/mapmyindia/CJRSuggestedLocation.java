package com.travel.bus.pojo.mapmyindia;

import com.google.gsonhtcfix.a.a;
import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;

public class CJRSuggestedLocation extends IJRPaytmDataModel {
    @a
    @b(a = "latitude")
    private Double latitude;
    @a
    @b(a = "longitude")
    private Double longitude;
    @a
    @b(a = "p")
    private Integer p;
    @a
    @b(a = "placeAddress")
    private String placeAddress;
    @a
    @b(a = "placeName")
    private String placeName;
    @a
    @b(a = "type")
    private String type;

    public String getType() {
        return this.type;
    }

    public void setType(String str) {
        this.type = str;
    }

    public String getPlaceAddress() {
        return this.placeAddress;
    }

    public Double getLatitude() {
        return this.latitude;
    }

    public Double getLongitude() {
        return this.longitude;
    }

    public String getPlaceName() {
        return this.placeName;
    }

    public Integer getP() {
        return this.p;
    }
}
