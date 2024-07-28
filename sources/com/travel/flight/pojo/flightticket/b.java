package com.travel.flight.pojo.flightticket;

import java.io.Serializable;
import java.util.ArrayList;

public final class b implements Serializable, Cloneable {
    public static final int ITEM_TYPE_HEADER = 0;
    public static final int ITEM_TYPE_LINGUISTIC_SEARCH_LIST = 5;
    public static final int ITEM_TYPE_NEARBY_LIST = 4;
    public static final int ITEM_TYPE_RECENT_CITY = 1;
    public static final int ITEM_TYPE_SEARCH_CITY = 2;
    public static final int ITEM_TYPE_SEARCH_LIST = 3;
    private static final long serialVersionUID = 1;
    @com.google.gsonhtcfix.a.b(a = "airport")
    private String airPortName;
    @com.google.gsonhtcfix.a.b(a = "city")
    private String cityName;
    @com.google.gsonhtcfix.a.b(a = "countrycode")
    private String countryCode;
    @com.google.gsonhtcfix.a.b(a = "country")
    private String countryName;
    private int itemType = 2;
    @com.google.gsonhtcfix.a.b(a = "distance")
    private float mDistance;
    @com.google.gsonhtcfix.a.b(a = "nearby_airports_data")
    private ArrayList<b> mNearbyAirportData;
    @com.google.gsonhtcfix.a.b(a = "state")
    private String mState;
    @com.google.gsonhtcfix.a.b(a = "iata")
    private String shortCityName;

    public final float getmDistance() {
        return this.mDistance;
    }

    public final void setmDistance(float f2) {
        this.mDistance = f2;
    }

    public final ArrayList<b> getmNearbyAirportData() {
        return this.mNearbyAirportData;
    }

    public final String getCountryName() {
        return this.countryName;
    }

    public final void setCountryName(String str) {
        this.countryName = str;
    }

    public final String getAirPortName() {
        return this.airPortName;
    }

    public final void setAirPortName(String str) {
        this.airPortName = str;
    }

    public final String getCityName() {
        return this.cityName;
    }

    public final String getShortCityName() {
        return this.shortCityName;
    }

    public final void setCityName(String str) {
        this.cityName = str;
    }

    public final void setShortCityName(String str) {
        this.shortCityName = str;
    }

    public final int getItemType() {
        return this.itemType;
    }

    public final void setItemType(int i2) {
        this.itemType = i2;
    }

    public final b clone() throws CloneNotSupportedException {
        return (b) super.clone();
    }

    public final String getState() {
        return this.mState;
    }

    public final void setState(String str) {
        this.mState = str;
    }

    public final String getCountryCode() {
        return this.countryCode;
    }

    public final void setCountryCode(String str) {
        this.countryCode = str;
    }
}
