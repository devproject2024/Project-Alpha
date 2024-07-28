package net.one97.paytm.hotel4.utils.location;

import com.paytm.network.model.IJRPaytmDataModel;

public final class CJRUtilityLocationModel extends IJRPaytmDataModel {
    private String city;
    private String latitude;
    private String locality;
    private String longitude;
    private String state;

    public final String getLocality() {
        return this.locality;
    }

    public final void setLocality(String str) {
        this.locality = str;
    }

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
