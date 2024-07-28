package com.travel.flight.pojo.model;

import com.google.gsonhtcfix.a.b;
import java.io.Serializable;

public final class a implements Serializable {
    @b(a = "code")
    private Integer code;
    @b(a = "error")
    private String error;
    @b(a = "internal_code")
    private String internal_code;
    @b(a = "requestid")
    private String requestid;
    @b(a = "status")
    private b status;

    public final String getError() {
        return this.error;
    }

    public final void setError(String str) {
        this.error = str;
    }

    public final Integer getCode() {
        return this.code;
    }

    public final void setCode(Integer num) {
        this.code = num;
    }

    public final b getStatus() {
        return this.status;
    }

    public final void setStatus(b bVar) {
        this.status = bVar;
    }

    public final String getRequestid() {
        return this.requestid;
    }

    public final void setRequestid(String str) {
        this.requestid = str;
    }

    public final String getInternalCode() {
        return this.internal_code;
    }

    public final void setInternalCode(String str) {
        this.internal_code = str;
    }
}
