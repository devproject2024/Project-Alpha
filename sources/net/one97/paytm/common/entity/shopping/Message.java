package net.one97.paytm.common.entity.shopping;

import com.google.gson.a.a;
import com.google.gson.a.c;

public class Message {
    @c(a = "message")
    @a
    private String message;
    @c(a = "title")
    @a
    private String title;

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String str) {
        this.message = str;
    }
}
