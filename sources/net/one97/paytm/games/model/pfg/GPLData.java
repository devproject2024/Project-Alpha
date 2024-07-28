package net.one97.paytm.games.model.pfg;

import kotlin.g.b.k;

public final class GPLData {
    private String contentType = "";
    private String event = "";
    private int eventType;
    private String routerPush = "";

    public final String getRouterPush() {
        return this.routerPush;
    }

    public final void setRouterPush(String str) {
        k.c(str, "<set-?>");
        this.routerPush = str;
    }

    public final int getEventType() {
        return this.eventType;
    }

    public final void setEventType(int i2) {
        this.eventType = i2;
    }

    public final String getEvent() {
        return this.event;
    }

    public final void setEvent(String str) {
        k.c(str, "<set-?>");
        this.event = str;
    }

    public final String getContentType() {
        return this.contentType;
    }

    public final void setContentType(String str) {
        k.c(str, "<set-?>");
        this.contentType = str;
    }
}
