package com.travel.bus.pojo.busticket;

import com.google.gson.a.a;
import com.google.gson.a.c;
import com.paytm.network.model.IJRPaytmDataModel;

public class CJRBusOrderSummaryRatingHeader extends IJRPaytmDataModel {
    @c(a = "title")
    @a
    private String title;

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String str) {
        this.title = str;
    }
}
