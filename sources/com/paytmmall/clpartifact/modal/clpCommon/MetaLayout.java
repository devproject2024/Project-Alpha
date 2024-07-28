package com.paytmmall.clpartifact.modal.clpCommon;

import com.google.gson.a.c;
import java.io.Serializable;

public class MetaLayout implements Serializable {
    @c(a = "bg_color")
    private String mBgColor;
    @c(a = "bg_gradient")
    private String[] mBgGradient;
    @c(a = "bg_image_url")
    private String mBgImage;

    public String getBgColor() {
        return this.mBgColor;
    }

    public void setBgColor(String str) {
        this.mBgColor = str;
    }

    public String getmBgImage() {
        return this.mBgImage;
    }

    public String[] getMBgGradient() {
        return this.mBgGradient;
    }
}
