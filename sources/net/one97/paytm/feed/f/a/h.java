package net.one97.paytm.feed.f.a;

import com.google.gson.a.c;
import java.io.Serializable;

public final class h implements Serializable {
    @c(a = "message")
    private c message;
    @c(a = "result")
    private String result;

    public final String getResult() {
        return this.result;
    }

    public final void setResult(String str) {
        this.result = str;
    }

    public final c getMessage() {
        return this.message;
    }

    public final void setMessage(c cVar) {
        this.message = cVar;
    }
}
