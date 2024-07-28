package com.business.merchant_payments.model;

import com.business.merchant_payments.utility.AESSecurityUtil;
import com.google.gson.a.c;

public class AddressDetailsModel extends EncryptedBaseModel {
    public static final long serialVersionUID = 1;
    @c(a = "address1")
    public String address1;
    @c(a = "address2")
    public String address2;
    @c(a = "address3")
    public String address3;
    @c(a = "city")
    public String city;
    @c(a = "country")
    public String country;
    @c(a = "pin")
    public String pin;
    @c(a = "state")
    public String state;
    public String stateGSTCode = "00";

    public String getAddress1() {
        return this.address1;
    }

    public void setAddress1(String str) {
        this.address1 = str;
    }

    public String getAddress2() {
        return this.address2;
    }

    public void setAddress2(String str) {
        this.address2 = str;
    }

    public String getAddress3() {
        return this.address3;
    }

    public void setAddress3(String str) {
        this.address3 = str;
    }

    public String getCity() {
        return this.city;
    }

    public void setCity(String str) {
        this.city = str;
    }

    public String getState() {
        return this.state;
    }

    public void setState(String str) {
        this.state = str;
    }

    public String getPin() {
        return this.pin;
    }

    public void setPin(String str) {
        this.pin = str;
    }

    public String getCountry() {
        return this.country;
    }

    public void setCountry(String str) {
        this.country = str;
    }

    public String getStateGSTCode() {
        return this.stateGSTCode;
    }

    public void setStateGSTCode(String str) {
        this.stateGSTCode = str;
    }

    public String toString() {
        return "" + this.address1 + this.address2 + this.address3 + this.city + this.state + this.pin + this.country;
    }

    public void encryptData() {
        setAddress1(AESSecurityUtil.encrypt(getAddress1()));
        setAddress2(AESSecurityUtil.encrypt(getAddress2()));
        setAddress3(AESSecurityUtil.encrypt(getAddress3()));
        setCity(AESSecurityUtil.encrypt(getCity()));
        setCountry(AESSecurityUtil.encrypt(getCountry()));
        setPin(AESSecurityUtil.encrypt(getPin()));
        setState(AESSecurityUtil.encrypt(getState()));
        setStateGSTCode(AESSecurityUtil.encrypt(getStateGSTCode()));
    }

    public void decryptData() {
        setAddress1(AESSecurityUtil.decrypt(getAddress1()));
        setAddress2(AESSecurityUtil.decrypt(getAddress2()));
        setAddress3(AESSecurityUtil.decrypt(getAddress3()));
        setCity(AESSecurityUtil.decrypt(getCity()));
        setCountry(AESSecurityUtil.decrypt(getCountry()));
        setPin(AESSecurityUtil.decrypt(getPin()));
        setState(AESSecurityUtil.decrypt(getState()));
        setStateGSTCode(AESSecurityUtil.decrypt(getStateGSTCode()));
    }
}
