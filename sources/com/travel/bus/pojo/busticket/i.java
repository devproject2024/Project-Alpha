package com.travel.bus.pojo.busticket;

import com.google.gsonhtcfix.a.b;
import java.io.Serializable;

public final class i implements Serializable {
    @b(a = "message")
    private j message;
    @b(a = "result")
    private String result;

    public final String getResult() {
        return this.result;
    }

    public final void setResult(String str) {
        this.result = str;
    }

    public final j getMessage() {
        return this.message;
    }

    public final void setMessage(j jVar) {
        this.message = jVar;
    }
}
