package com.travel.bus.pojo.busticket;

import com.google.gson.a.a;
import com.google.gson.a.c;
import com.paytm.network.model.IJRPaytmDataModel;

public class CJRBusOrderSummaryRatingFooter extends IJRPaytmDataModel {
    @c(a = "link_target")
    @a
    private CJRBusOrderSummaryRatingLink linkTarget;
    @c(a = "link_text")
    @a
    private String linkText;
    @c(a = "message")
    @a
    private String message;

    public String getLinkText() {
        return this.linkText;
    }

    public void setLinkText(String str) {
        this.linkText = str;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String str) {
        this.message = str;
    }

    public CJRBusOrderSummaryRatingLink getLinkTarget() {
        return this.linkTarget;
    }

    public void setLinkTarget(CJRBusOrderSummaryRatingLink cJRBusOrderSummaryRatingLink) {
        this.linkTarget = cJRBusOrderSummaryRatingLink;
    }
}
