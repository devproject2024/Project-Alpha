package com.paytm.notification.models;

import com.google.gson.a.c;

public final class Style {
    @c(a = "big_picture")
    private String bigPicture;
    @c(a = "summary")
    private String summary;
    @c(a = "title")
    private String title;
    @c(a = "type")
    private String type;

    public static /* synthetic */ void summary$annotations() {
    }

    public final String getType() {
        return this.type;
    }

    public final void setType(String str) {
        this.type = str;
    }

    public final String getBigPicture() {
        return this.bigPicture;
    }

    public final void setBigPicture(String str) {
        this.bigPicture = str;
    }

    public final String getTitle() {
        return this.title;
    }

    public final void setTitle(String str) {
        this.title = str;
    }

    public final String getSummary() {
        return this.summary;
    }

    public final void setSummary(String str) {
        this.summary = str;
    }

    public final String toString() {
        return "Style(type=" + this.type + ", bigPicture=" + this.bigPicture + ", title=" + this.title + ", summary=" + this.summary + ')';
    }
}
