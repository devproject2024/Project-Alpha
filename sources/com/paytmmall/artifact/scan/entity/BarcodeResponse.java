package com.paytmmall.artifact.scan.entity;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;

public class BarcodeResponse extends IJRPaytmDataModel {
    private static final long serialVersionUID = 1;
    @b(a = "error")
    private String error;
    @b(a = "status")
    private BarcodeStatus status;

    public BarcodeStatus getStatus() {
        return this.status;
    }

    public String getError() {
        return this.error;
    }
}
