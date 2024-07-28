package com.paytmmall.artifact.cart.entity;

import java.util.Map;

public class CJRCartProductCountMap {
    private String productId;
    private Map<String, String> promoData;
    private int quantity;

    public String getProductId() {
        return this.productId;
    }

    public void setProductId(String str) {
        this.productId = str;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public void setQuantity(int i2) {
        this.quantity = i2;
    }

    public Map<String, String> getPromoData() {
        return this.promoData;
    }

    public void setPromoData(Map<String, String> map) {
        this.promoData = map;
    }
}
