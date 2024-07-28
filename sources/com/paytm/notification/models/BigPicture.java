package com.paytm.notification.models;

import com.google.gson.a.c;

public final class BigPicture {
    @c(a = "alert")
    private String alert;
    @c(a = "interactive")
    private Interactive interactive;
    @c(a = "style")
    private Style style;
    @c(a = "urlType")
    private String urlType;

    public final String getAlert() {
        return this.alert;
    }

    public final void setAlert(String str) {
        this.alert = str;
    }

    public final Interactive getInteractive() {
        return this.interactive;
    }

    public final void setInteractive(Interactive interactive2) {
        this.interactive = interactive2;
    }

    public final String getUrlType() {
        return this.urlType;
    }

    public final void setUrlType(String str) {
        this.urlType = str;
    }

    public final Style getStyle() {
        return this.style;
    }

    public final void setStyle(Style style2) {
        this.style = style2;
    }

    public final String toString() {
        return "BigPicture(alert=" + this.alert + ", interactive=" + this.interactive + ", urlType=" + this.urlType + ", style=" + this.style + ')';
    }
}
