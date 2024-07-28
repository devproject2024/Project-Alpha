package com.travel.bus.pojo.busticket;

import com.google.gsonhtcfix.a.b;
import net.one97.paytm.common.entity.IJRDataModel;

public class BusEcosystemOffer implements IJRDataModel {
    @b(a = "icon")
    private String icon;
    @b(a = "title")
    private String title;

    public String getTitle() {
        return this.title;
    }

    public String getIcon() {
        return this.icon;
    }
}
