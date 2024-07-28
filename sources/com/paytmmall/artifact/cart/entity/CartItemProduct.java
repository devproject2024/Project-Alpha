package com.paytmmall.artifact.cart.entity;

import com.google.gsonhtcfix.a.a;
import com.google.gsonhtcfix.a.b;

public class CartItemProduct {
    @a
    @b(a = "merchant_id")
    private long merchantId;

    public long getMerchantId() {
        return this.merchantId;
    }

    public void setMerchantId(long j) {
        this.merchantId = j;
    }
}
