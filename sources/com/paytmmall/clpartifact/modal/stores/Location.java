package com.paytmmall.clpartifact.modal.stores;

import com.google.gson.a.c;
import java.io.Serializable;

public class Location implements Serializable {
    @c(a = "lat")
    private Double mLat;
    @c(a = "lon")
    private Double mLon;

    public Double getLat() {
        return this.mLat;
    }

    public void setLat(Double d2) {
        this.mLat = d2;
    }

    public Double getLon() {
        return this.mLon;
    }

    public void setLon(Double d2) {
        this.mLon = d2;
    }
}
