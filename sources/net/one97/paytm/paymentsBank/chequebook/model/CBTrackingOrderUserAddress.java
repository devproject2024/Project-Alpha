package net.one97.paytm.paymentsBank.chequebook.model;

import com.google.gsonhtcfix.a.a;
import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;

public class CBTrackingOrderUserAddress extends IJRPaytmDataModel {
    @a
    @b(a = "address1")
    private String address1;
    @a
    @b(a = "address2")
    private String address2;
    @a
    @b(a = "city")
    private String city;
    @a
    @b(a = "country")
    private String country;
    @a
    @b(a = "countryCode")
    private String countryCode;
    @a
    @b(a = "mobile")
    private String mobile;
    @a
    @b(a = "name")
    private String name;
    @a
    @b(a = "pin")
    private String pin;
    @a
    @b(a = "state")
    private String state;

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

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

    public String getCountryCode() {
        return this.countryCode;
    }

    public void setCountryCode(String str) {
        this.countryCode = str;
    }

    public String getMobile() {
        return this.mobile;
    }

    public void setMobile(String str) {
        this.mobile = str;
    }
}
