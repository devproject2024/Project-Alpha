package com.paytm.notification.models;

import com.google.gson.a.c;

public final class Message {
    @c(a = "body")
    private String body;
    @c(a = "expiry")
    private String expiry;
    @c(a = "title")
    private String title;
    @c(a = "urlType")
    private String urlType;

    public final String getTitle() {
        return this.title;
    }

    public final void setTitle(String str) {
        this.title = str;
    }

    public final String getBody() {
        return this.body;
    }

    public final void setBody(String str) {
        this.body = str;
    }

    public final String getUrlType() {
        return this.urlType;
    }

    public final void setUrlType(String str) {
        this.urlType = str;
    }

    public final String getExpiry() {
        return this.expiry;
    }

    public final void setExpiry(String str) {
        this.expiry = str;
    }

    public final String toString() {
        return "Message(title=" + this.title + ", body=" + this.body + ", urlType=" + this.urlType + ", expiry=" + this.expiry + ')';
    }
}
