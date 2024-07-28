package com.paytmmall.artifact.order.entity;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;

public class CJROrdersummaryFooter extends IJRPaytmDataModel {
    private static final long serialVersionUID = 1;
    @b(a = "description")
    private String mDescription;
    @b(a = "header")
    private String mHeader;

    public String getHeader() {
        return this.mHeader;
    }

    public String getDescription() {
        return this.mDescription;
    }
}
