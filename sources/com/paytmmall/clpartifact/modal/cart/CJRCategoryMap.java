package com.paytmmall.clpartifact.modal.cart;

import com.google.gson.a.c;
import java.io.Serializable;

public class CJRCategoryMap implements Serializable {
    @c(a = "id")
    private String mId;
    @c(a = "name")
    private String mName;
    @c(a = "url_key")
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
