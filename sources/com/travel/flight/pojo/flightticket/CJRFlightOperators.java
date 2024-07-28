package com.travel.flight.pojo.flightticket;

import com.google.gsonhtcfix.a.b;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRFlightOperators implements IJRDataModel {
    @b(a = "imgUrl")
    private String imgUrl;
    @b(a = "name")
    private String name;

    public CJRFlightOperators(String str) {
        this.name = str;
    }

    public String getImgUrl() {
        return this.imgUrl;
    }

    public void setImgUrl(String str) {
        this.imgUrl = str;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    public String toString() {
        return "ClassPojo [imgUrl = " + this.imgUrl + ", name = " + this.name + "]";
    }
}
