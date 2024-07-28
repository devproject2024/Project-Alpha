package com.paytmmall.artifact.scan.entity;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;

public class BarcodeStatus extends IJRPaytmDataModel {
    private static final long serialVersionUID = 1;
    @b(a = "data")
    BarcodeData data;
    @b(a = "result")
    private String result;

    public String getResult() {
        return this.result;
    }

    public BarcodeData getData() {
        return this.data;
    }
}
