package com.paytmmall.clpartifact.modal.cart;

import com.google.gson.a.c;
import java.io.Serializable;

public class CJRCartItemMerchantAddress implements Serializable {
    @c(a = "city")
    private String city;
    @c(a = "state")
    private String state;

    public String getCity() {
        return this.city;
    }

    public String getState() {
        return this.state;
    }
}
