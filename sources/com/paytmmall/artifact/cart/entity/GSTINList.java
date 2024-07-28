package com.paytmmall.artifact.cart.entity;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.ArrayList;
import java.util.List;

public class GSTINList extends IJRPaytmDataModel {
    private static final long serialVersionUID = 1;
    @b(a = "gstinList")
    private ArrayList<GSTINData> gstinList = new ArrayList<>();
    @b(a = "message")
    private String message;
    @b(a = "responseCode")
    private int responseCode;
    @b(a = "status")
    private String status;

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String str) {
        this.status = str;
    }

    public int getResponseCode() {
        return this.responseCode;
    }

    public void setResponseCode(int i2) {
        this.responseCode = i2;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String str) {
        this.message = str;
    }

    public List<GSTINData> getGstinList() {
        return this.gstinList;
    }

    public void setGstinList(ArrayList<GSTINData> arrayList) {
        this.gstinList = arrayList;
    }
}
