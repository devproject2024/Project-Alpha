package com.paytmmall.artifact.cart.entity;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;

public class WishListTag extends IJRPaytmDataModel {
    @b(a = "display_name")
    private String mDisplayName;
    @b(a = "name")
    private String name;

    public String getmDisplayName() {
        return this.mDisplayName;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setmDisplayName(String str) {
        this.mDisplayName = str;
    }
}
