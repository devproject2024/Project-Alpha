package com.travel.flight.pojo.seatancillaryentity.availability;

import com.google.gsonhtcfix.a.a;
import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;

public class CJRSeatLegend extends IJRPaytmDataModel {
    private static final long serialVersionUID = 1;
    @a
    @b(a = "color")
    private String color;
    @a
    @b(a = "pre_select")
    private String preSelect;
    @a
    @b(a = "select")
    private String select;

    public String getSelect() {
        return this.select;
    }

    public void setSelect(String str) {
        this.select = str;
    }

    public String getPreSelect() {
        return this.preSelect;
    }

    public void setPreSelect(String str) {
        this.preSelect = str;
    }

    public String getColor() {
        return this.color;
    }

    public void setColor(String str) {
        this.color = str;
    }
}
