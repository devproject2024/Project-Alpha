package com.travel.flight.pojo.flightticket.Ancillary.request;

import com.google.gson.a.c;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRAncillarySelectedItem implements IJRDataModel {
    @c(a = "code")
    private String code;
    @c(a = "count")
    private int count;
    private transient boolean isBaggage;
    @c(a = "is_veg")
    private boolean isVeg;
    private transient String name;
    private transient double price;

    public String getCode() {
        return this.code;
    }

    public void setCode(String str) {
        this.code = str;
    }

    public int getCount() {
        return this.count;
    }

    public void setCount(int i2) {
        this.count = i2;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    public boolean isBaggage() {
        return this.isBaggage;
    }

    public void setBaggage(boolean z) {
        this.isBaggage = z;
    }

    public double getPrice() {
        return this.price;
    }

    public void setPrice(double d2) {
        this.price = d2;
    }

    public boolean isVeg() {
        return this.isVeg;
    }

    public void setIsVeg(boolean z) {
        this.isVeg = z;
    }
}
