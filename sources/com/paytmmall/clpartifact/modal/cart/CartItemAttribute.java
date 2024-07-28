package com.paytmmall.clpartifact.modal.cart;

import com.google.gson.a.a;
import com.google.gson.a.c;

public class CartItemAttribute {
    @c(a = "brand")
    @a
    public String brand;
    @c(a = "model")
    @a
    public String model;

    public String getModel() {
        return this.model;
    }

    public void setModel(String str) {
        this.model = str;
    }

    public String getBrand() {
        return this.brand;
    }

    public void setBrand(String str) {
        this.brand = str;
    }
}
