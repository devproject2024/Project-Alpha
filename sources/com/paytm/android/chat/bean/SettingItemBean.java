package com.paytm.android.chat.bean;

public class SettingItemBean {
    public static final int SETTING_CONTAIN_ITEM = 0;
    public static final int SETTING_SWITCH_OFF = 2;
    public static final int SETTING_SWITCH_ON = 1;
    int drawableIcon = 0;
    String intro = "";
    int status = 0;
    String title = "";
    String value = "0";

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public String getIntro() {
        return this.intro;
    }

    public void setIntro(String str) {
        this.intro = str;
    }

    public String getValue() {
        return this.value;
    }

    public void setValue(String str) {
        this.value = str;
    }

    public int getStatus() {
        return this.status;
    }

    public void setStatus(int i2) {
        this.status = i2;
    }

    public int getDrawableIcon() {
        return this.drawableIcon;
    }

    public void setDrawableIcon(int i2) {
        this.drawableIcon = i2;
    }
}
