package com.paytmmall.artifact.search.entity;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;

public class CJRSearchPopularProduct extends IJRPaytmDataModel {
    @b(a = "image_url")
    private String mImageUrl;
    @b(a = "price")
    private String mPrice;
    @b(a = "text")
    private String mText;
    @b(a = "newurl")
    private String mUrl;

    public String getmText() {
        return this.mText;
    }

    public void setmText(String str) {
        this.mText = str;
    }

    public String getmUrl() {
        return this.mUrl;
    }

    public void setmUrl(String str) {
        this.mUrl = str;
    }

    public String getmImageUrl() {
        return this.mImageUrl;
    }

    public void setmImageUrl(String str) {
        this.mImageUrl = str;
    }

    public String getmPrice() {
        return this.mPrice;
    }

    public void setmPrice(String str) {
        this.mPrice = str;
    }
}
