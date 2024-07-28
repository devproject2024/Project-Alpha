package com.travel.bus.pojo.hotel;

import com.google.gson.a.a;
import com.google.gson.a.c;
import java.util.List;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRHotelDataModel implements IJRDataModel {
    @c(a = "deepLink")
    @a
    private String deepLink;
    @c(a = "facilities")
    @a
    private List<String> facilities = null;
    @c(a = "name")
    @a
    private String name;
    @c(a = "paytmImages")
    @a
    private CJRPaytmImageModel paytmImages;
    @c(a = "priceData")
    @a
    private CJRPriceDataModel priceData;
    @c(a = "starRating")
    @a
    private int starRating;

    public String getDeepLink() {
        return this.deepLink;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    public List<String> getFacilities() {
        return this.facilities;
    }

    public CJRPaytmImageModel getPaytmImages() {
        return this.paytmImages;
    }

    public CJRPriceDataModel getPriceData() {
        return this.priceData;
    }

    public int getStarRating() {
        return this.starRating;
    }
}
