package com.travel.bus.pojo.busticket.BusTravellerExtraDetails;

import com.google.gson.a.c;
import java.util.ArrayList;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRDropdownOptionsModel implements IJRDataModel {
    @c(a = "display")
    private String display;
    @c(a = "show")
    private ArrayList<String> show;
    @c(a = "value")
    private String value;

    public String getValue() {
        return this.value;
    }

    public void setValue(String str) {
        this.value = str;
    }

    public String getDisplay() {
        return this.display;
    }

    public ArrayList<String> getShow() {
        return this.show;
    }
}
