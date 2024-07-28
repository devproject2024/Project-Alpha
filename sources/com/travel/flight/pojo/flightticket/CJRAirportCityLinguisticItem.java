package com.travel.flight.pojo.flightticket;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;

public class CJRAirportCityLinguisticItem extends IJRPaytmDataModel {
    private String cityName;
    @b(a = "display_name")
    private String display_name;
    private int itemType = 5;
    @b(a = "destination")
    private b mDestination;
    @b(a = "source")
    private b mSource;

    public b getmSource() {
        return this.mSource;
    }

    public void setmSource(b bVar) {
        this.mSource = bVar;
    }

    public b getmDestination() {
        return this.mDestination;
    }

    public void setmDestination(b bVar) {
        this.mDestination = bVar;
    }

    public String getDisplay_name() {
        return this.display_name;
    }

    public void setDisplay_name(String str) {
        this.display_name = str;
    }

    public int getItemType() {
        return this.itemType;
    }

    public void setItemType(int i2) {
        this.itemType = i2;
    }

    public String getCityName() {
        return this.cityName;
    }

    public void setCityName(String str) {
        this.cityName = str;
    }
}
