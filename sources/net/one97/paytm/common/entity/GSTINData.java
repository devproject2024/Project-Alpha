package net.one97.paytm.common.entity;

import com.google.gson.a.c;

public class GSTINData implements IJRDataModel {
    private static final long serialVersionUID = 1;
    @c(a = "address")
    private String address = null;
    @c(a = "gstHolderName")
    private String gstHolderName = null;
    @c(a = "gstin")
    private String gstin = null;
    @c(a = "id")
    private int id;
    @c(a = "isVerified")
    private int isVerified;
    @c(a = "state")
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
