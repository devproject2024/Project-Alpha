package com.travel.flight.pojo.model;

import java.io.Serializable;

public final class b implements Serializable {
    @com.google.gsonhtcfix.a.b(a = "message")
    private c message;
    @com.google.gsonhtcfix.a.b(a = "result")
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
