package com.travel.flight.pojo.flightticket.paxinfo;

import net.one97.paytm.common.entity.IJRDataModel;

public class CJRGSTPassengerInfo implements IJRDataModel {
    private String mCompanyAddress;
    private String mCompanyContactNumber;
    private String mCompanyGstEmail;
    private String mCompanyName;
    private String mGSTNumber;
    private String mStateOfResidence;

    public void setCompanyName(String str) {
        this.mCompanyName = str;
    }

    public void setCompanyAddress(String str) {
        this.mCompanyAddress = str;
    }

    public void setStateOfResidence(String str) {
        this.mStateOfResidence = str;
    }

    public void setGSTNumber(String str) {
        this.mGSTNumber = str;
    }

    public String getGSTNumber() {
        return this.mGSTNumber;
    }

    public String getCompanyName() {
        return this.mCompanyName;
    }

    public String getCompanyAddress() {
        return this.mCompanyAddress;
    }

    public String getStateOfResidence() {
        return this.mStateOfResidence;
    }

    public String getCompanyContactNumber() {
        return this.mCompanyContactNumber;
    }

    public void setCompanyContactNumber(String str) {
        this.mCompanyContactNumber = str;
    }

    public String getCompanyGstEmail() {
        return this.mCompanyGstEmail;
    }

    public void setCompanyGstEmail(String str) {
        this.mCompanyGstEmail = str;
    }
}
