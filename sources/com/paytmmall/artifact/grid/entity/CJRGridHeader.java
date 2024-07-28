package com.paytmmall.artifact.grid.entity;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;

public class CJRGridHeader extends IJRPaytmDataModel {
    private static final long serialVersionUID = 1;
    @b(a = "image_url")
    private String mImageUrl;
    @b(a = "text")
    private String mText;

    public String getImageUrl() {
        return this.mImageUrl;
    }

    public String getText() {
        return this.mText;
    }

    public void setImageUrl(String str) {
        this.mImageUrl = str;
    }

    public void setHeaderText(String str) {
        this.mText = str;
    }
}
