package com.travel.booking.datamodel;

import kotlin.g.b.k;

public final class EmptyBookingMessage {
    private String subText = "";
    private String text = "";
    private String url = "";

    public final String getText() {
        return this.text;
    }

    public final void setText(String str) {
        k.c(str, "<set-?>");
        this.text = str;
    }

    public final String getSubText() {
        return this.subText;
    }

    public final void setSubText(String str) {
        k.c(str, "<set-?>");
        this.subText = str;
    }

    public final String getUrl() {
        return this.url;
    }

    public final void setUrl(String str) {
        k.c(str, "<set-?>");
        this.url = str;
    }
}
