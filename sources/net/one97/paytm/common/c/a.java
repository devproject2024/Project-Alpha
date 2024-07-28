package net.one97.paytm.common.c;

import android.os.Parcel;
import java.io.Serializable;

public final class a implements Serializable {
    public static final String MAP_DATA_INTENT_KEY = "MAP_DATA_INTENT_KEY";
    private String mAddressHeader = null;
    private double mAddressLatitue;
    private double mAddressLongitude;
    private String mAddressText = null;

    public a() {
    }

    public final String getAddressHeader() {
        return this.mAddressHeader;
    }

    public final void setAddressHeader(String str) {
        this.mAddressHeader = str;
    }

    public final String getAddressText() {
        return this.mAddressText;
    }

    public final void setAddressText(String str) {
        this.mAddressText = str;
    }

    public final double getAddressLatitue() {
        return this.mAddressLatitue;
    }

    public final void setaddressLatitue(double d2) {
        this.mAddressLatitue = d2;
    }

    public final double getAddressLongitude() {
        return this.mAddressLongitude;
    }

    public final void setAddressLongitude(double d2) {
        this.mAddressLongitude = d2;
    }

    public a(Parcel parcel) {
        this.mAddressHeader = parcel.readString();
        this.mAddressText = parcel.readString();
        this.mAddressLatitue = parcel.readDouble();
        this.mAddressLongitude = parcel.readDouble();
    }
}
