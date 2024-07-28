package com.paytmmall.artifact.cart.entity;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;

public class GSTINData extends IJRPaytmDataModel {
    private static final long serialVersionUID = 1;
    @b(a = "address")
    private String address = null;
    @b(a = "gstHolderName")
    private String gstHolderName = null;
    @b(a = "gstin")
    private String gstin = null;
    @b(a = "id")
    private int id;
    @b(a = "isVerified")
    private int isVerified;
    @b(a = "state")
    private String state = null;

    public int getId() {
        return this.id;
    }

    public int getIsVerified() {
        return this.isVerified;
    }

    public String getGstin() {
        return this.gstin;
    }

    public void setGstin(String str) {
        this.gstin = str;
    }

    public String getGstHolderName() {
        return this.gstHolderName;
    }

    public void setGstHolderName(String str) {
        this.gstHolderName = str;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String str) {
        this.address = str;
    }

    public String getState() {
        return this.state;
    }

    public void setState(String str) {
        this.state = str;
    }
}
