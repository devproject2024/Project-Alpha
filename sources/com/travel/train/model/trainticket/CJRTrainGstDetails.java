package com.travel.train.model.trainticket;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRTrainGstDetails extends IJRPaytmDataModel implements IJRDataModel {
    @b(a = "area")
    private String area;
    @b(a = "city")
    private String city;
    @b(a = "flat")
    private String flat;
    @b(a = "gstIn")
    private String gstIn;
    @b(a = "nameOnGst")
    private String nameOnGst;
    @b(a = "pin")
    private String pin;
    @b(a = "state")
    private String state;
    @b(a = "street")
    private String street;

    public String getArea() {
        return this.area;
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

    public String getPin() {
        return this.pin;
    }

    public void setPin(String str) {
        this.pin = str;
    }

    public String getStreet() {
        return this.street;
    }

    public void setStreet(String str) {
        this.street = str;
    }

    public String getFlat() {
        return this.flat;
    }

    public void setFlat(String str) {
        this.flat = str;
    }

    public String getNameOnGst() {
        return this.nameOnGst;
    }

    public void setNameOnGst(String str) {
        this.nameOnGst = str;
    }

    public String getGstIn() {
        return this.gstIn;
    }

    public void setGstIn(String str) {
        this.gstIn = str;
    }
}
