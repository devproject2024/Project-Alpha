package com.paytmmall.artifact.cart.entity;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;

public class CJRCartItemMerchantAddress extends IJRPaytmDataModel {
    @b(a = "city")
    private String city;
    @b(a = "state")
    private String state;

    public String getCity() {
        return this.city;
    }

    public String getState() {
        return this.state;
    }
}
