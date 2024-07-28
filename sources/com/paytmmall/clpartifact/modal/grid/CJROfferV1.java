package com.paytmmall.clpartifact.modal.grid;

import com.google.gson.a.c;
import java.io.Serializable;

public class CJROfferV1 implements Serializable {
    @c(a = "subtext")
    private String mSubtext;
    @c(a = "text")
    private String mText;
    @c(a = "type")
    private String mType;

    public String getmSubtext() {
        return this.mSubtext;
    }

    public void setmSubtext(String str) {
        this.mSubtext = str;
    }

    public String getmText() {
        return this.mText;
    }

    public void setmText(String str) {
        this.mText = str;
    }

    public String getmType() {
        return this.mType;
    }

    public void setmType(String str) {
        this.mType = str;
    }
}
