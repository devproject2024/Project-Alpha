package com.paytm.notification.models;

import com.google.gson.a.c;
import java.util.HashMap;

public final class Notification {
    @c(a = "content")
    private Content content;
    @c(a = "extra")
    private HashMap<String, String> extras;
    @c(a = "interactive")
    private Interactive interactive;

    public final Content getContent() {
        return this.content;
    }

    public final void setContent(Content content2) {
        this.content = content2;
    }

    public final Interactive getInteractive() {
        return this.interactive;
    }

    public final void setInteractive(Interactive interactive2) {
        this.interactive = interactive2;
    }

    public final HashMap<String, String> getExtras() {
        return this.extras;
    }

    public final void setExtras(HashMap<String, String> hashMap) {
        this.extras = hashMap;
    }

    public final String toString() {
        return "Notification(content=" + this.content + ", interactive=" + this.interactive + ", extras=" + this.extras + ')';
    }
}
