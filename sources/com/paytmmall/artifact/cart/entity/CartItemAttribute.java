package com.paytmmall.artifact.cart.entity;

import com.google.gsonhtcfix.a.a;
import com.google.gsonhtcfix.a.b;

public class CartItemAttribute {
    @a
    @b(a = "brand")
    public String brand;
    @a
    @b(a = "model")
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
