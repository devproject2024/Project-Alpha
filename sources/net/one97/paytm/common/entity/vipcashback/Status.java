package net.one97.paytm.common.entity.vipcashback;

import com.google.gson.a.a;
import com.google.gson.a.c;

public class Status {
    @c(a = "message")
    @a
    private Message message;
    @c(a = "result")
    @a
    private String result;

    public String getResult() {
        return this.result;
    }

    public void setResult(String str) {
        this.result = str;
    }

    public Message getMessage() {
        return this.message;
    }

    public void setMessage(Message message2) {
        this.message = message2;
    }
}
