package com.travel.bus.pojo.bussearch;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;

public class CJRDictionaryItem extends IJRPaytmDataModel {
    @b(a = "bus_city_id")
    private String busCityId;
    @b(a = "distance")
    private String distance;
    @b(a = "name")
    private String name;
    @b(a = "type")
    private String type;

    public String getName() {
        return this.name;
    }

    public String getBusCityId() {
        return this.busCityId;
    }

    public String getType() {
        return this.type;
    }

    public String getDistance() {
        return this.distance;
    }
}
