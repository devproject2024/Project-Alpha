package net.one97.paytm.feed.f.a;

import java.io.Serializable;

public final class c implements Serializable {
    @com.google.gson.a.c(a = "message")
    private String message;
    @com.google.gson.a.c(a = "title")
    private String title;

    public final String getTitle() {
        return this.title;
    }

    public final void setTitle(String str) {
        this.title = str;
    }

    public final String getMessage() {
        return this.message;
    }

    public final void setMessage(String str) {
        this.message = str;
    }
}
