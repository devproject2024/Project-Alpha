package net.one97.travelpass.model;

import java.io.Serializable;

public final class b implements Serializable {
    @com.google.gsonhtcfix.a.b(a = "code")
    private Integer code;
    @com.google.gsonhtcfix.a.b(a = "error")
    private String error;
    @com.google.gsonhtcfix.a.b(a = "requestid")
    private String requestid;
    @com.google.gsonhtcfix.a.b(a = "status")
    private c status;

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

    public final c getStatus() {
        return this.status;
    }

    public final void setStatus(c cVar) {
        this.status = cVar;
    }

    public final String getRequestid() {
        return this.requestid;
    }

    public final void setRequestid(String str) {
        this.requestid = str;
    }
}
