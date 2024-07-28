package com.travel.bus.pojo.busticket;

import com.google.gson.a.a;
import com.google.gson.a.c;
import com.paytm.network.model.IJRPaytmDataModel;

public class CJRBusOrderSummaryRatingLink extends IJRPaytmDataModel {
    @c(a = "type")
    @a
    private String type;
    @c(a = "url")
    @a
    private String url;

    public String getType() {
        return this.type;
    }

    public void setType(String str) {
        this.type = str;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String str) {
        this.url = str;
    }
}
