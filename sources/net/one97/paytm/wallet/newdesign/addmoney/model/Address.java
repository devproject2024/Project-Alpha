package net.one97.paytm.wallet.newdesign.addmoney.model;

import net.one97.paytm.common.entity.IJRDataModel;

public class Address implements IJRDataModel {
    String cityName;
    String countryName;
    String stateName;
    String zipCode;

    public String getCountryName() {
        return this.countryName;
    }

    public String getStateName() {
        return this.stateName;
    }

    public String getCityName() {
        return this.cityName;
    }

    public String getZipCode() {
        return this.zipCode;
    }
}
