package com.travel.bus.pojo.hotel;

import com.google.gson.a.a;
import com.google.gson.a.c;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRPriceDataModel implements IJRDataModel {
    @c(a = "originalPrice")
    @a
    private int originalPrice;

    public int getOriginalPrice() {
        return this.originalPrice;
    }
}
