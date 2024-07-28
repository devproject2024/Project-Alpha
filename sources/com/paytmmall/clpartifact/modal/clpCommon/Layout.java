package com.paytmmall.clpartifact.modal.clpCommon;

import com.google.gson.a.c;
import java.io.Serializable;

public class Layout implements Serializable {
    @c(a = "bg_image_url")
    private String mBgImageUrl;

    public String getBgImageUrl() {
        return this.mBgImageUrl;
    }

    public void setBgImageUrl(String str) {
        this.mBgImageUrl = str;
    }
}
