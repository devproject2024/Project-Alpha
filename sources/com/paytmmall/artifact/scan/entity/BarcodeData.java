package com.paytmmall.artifact.scan.entity;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;

public class BarcodeData extends IJRPaytmDataModel {
    private static final long serialVersionUID = 1;
    @b(a = "deep_link")
    private String deepLink;

    public String getDeepLink() {
        return this.deepLink;
    }
}
