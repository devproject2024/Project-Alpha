package net.one97.paytm.common.entity.recharge.v2;

import net.one97.paytm.common.entity.IJRDataModel;

public class CJRUtilityLocationModel implements IJRDataModel {
    private String city;
    private String latitude;
    private String longitude;
    private String state;

    public String getLatitude() {
        return this.latitude;
    }

    public void setLatitude(String str) {
        this.latitude = str;
    }

    public String getLongitude() {
        return this.longitude;
    }

    public void setLongitude(String str) {
        this.longitude = str;
    }

    public String getCity() {
        return this.city;
    }

    public void setCity(String str) {
        this.city = str;
    }

    public String getState() {
        return this.state;
    }

    public void setState(String str) {
        this.state = str;
    }
}
