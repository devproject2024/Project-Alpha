package com.paytmmall.artifact.cart.entity;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;

public class CJRCategoryMap extends IJRPaytmDataModel {
    @b(a = "id")
    private String mId;
    @b(a = "name")
    private String mName;
    @b(a = "url_key")
    private String urlKey;

    public String getUrlKey() {
        return this.urlKey;
    }

    public String getName() {
        return this.mName;
    }

    public String getCategoryId() {
        return this.mId;
    }
}
