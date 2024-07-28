package com.paytmmall.artifact.cart.entity;

import com.google.gsonhtcfix.f;
import com.paytm.network.model.IJRPaytmDataModel;

public class StringModel extends IJRPaytmDataModel {
    private String data;

    public IJRPaytmDataModel parseResponse(String str, f fVar) throws Exception {
        this.data = str;
        return this;
    }

    public String getData() {
        return this.data;
    }
}
