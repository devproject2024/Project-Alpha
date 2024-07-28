package com.travel.bus.pojo.busticket;

import com.google.gson.a.a;
import com.google.gson.a.c;
import com.paytm.network.model.IJRPaytmDataModel;

public class CJRBusOrderSummaryRatingItem extends IJRPaytmDataModel {
    @c(a = "icon_url")
    @a
    private String iconUrl;
    @c(a = "target_url")
    @a
    private String targetUrl;

    public String getTargetUrl() {
        return this.targetUrl;
    }

    public void setTargetUrl(String str) {
        this.targetUrl = str;
    }

    public String getIconUrl() {
        return this.iconUrl;
    }

    public void setIconUrl(String str) {
        this.iconUrl = str;
    }
}
