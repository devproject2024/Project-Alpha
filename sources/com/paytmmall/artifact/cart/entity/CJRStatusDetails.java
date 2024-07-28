package com.paytmmall.artifact.cart.entity;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;

public class CJRStatusDetails extends IJRPaytmDataModel {
    @b(a = "status_text")
    private String mStatusText;

    public String getmStatusText() {
        return this.mStatusText;
    }

    public void setmStatusText(String str) {
        this.mStatusText = str;
    }
}
