package net.one97.paytm.feed.f.a;

import com.google.gson.a.c;
import java.io.Serializable;

public final class i implements Serializable {
    @c(a = "body")
    private b body;
    @c(a = "code")
    private Integer code;
    @c(a = "error")
    private String error;
    @c(a = "meta")
    private d meta;
    @c(a = "status")
    private h status;

    public final String getError() {
        return this.error;
    }

    public final void setError(String str) {
        this.error = str;
    }

    public final h getStatus() {
        return this.status;
    }

    public final void setStatus(h hVar) {
        this.status = hVar;
    }

    public final b getBody() {
        return this.body;
    }

    public final void setBody(b bVar) {
        this.body = bVar;
    }

    public final d getMeta() {
        return this.meta;
    }

    public final void setMeta(d dVar) {
        this.meta = dVar;
    }

    public final Integer getCode() {
        return this.code;
    }

    public final void setCode(Integer num) {
        this.code = num;
    }
}
