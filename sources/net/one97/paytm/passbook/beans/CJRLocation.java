package net.one97.paytm.passbook.beans;

import com.google.gson.a.c;
import net.one97.paytm.passbook.mapping.IJRDataModel;

public class CJRLocation extends IJRDataModel {
    @c(a = "latitude")
    private double latitude;
    @c(a = "longitude")
    private double longitude;

    public double getLongitude() {
        return this.longitude;
    }

    public void setLongitude(double d2) {
        this.longitude = d2;
    }

    public double getLatitude() {
        return this.latitude;
    }

    public void setLatitude(double d2) {
        this.latitude = d2;
    }
}
