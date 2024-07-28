package net.one97.paytm.common.entity;

import com.google.gsonhtcfix.a.b;

public class CJRBadage {
    @b(a = "image")
    private String mImage;
    @b(a = "key")
    private String mKey;
    @b(a = "label")
    private String mLabel;

    public String getmKey() {
        return this.mKey;
    }

    public void setmKey(String str) {
        this.mKey = str;
    }

    public String getmLabel() {
        return this.mLabel;
    }

    public void setmLabel(String str) {
        this.mLabel = str;
    }

    public String getmImage() {
        return this.mImage;
    }

    public void setmImage(String str) {
        this.mImage = str;
    }
}
