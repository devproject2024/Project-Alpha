package net.one97.travelpass.model;

import com.google.gsonhtcfix.a.b;
import java.io.Serializable;

public final class a implements Serializable {
    @b(a = "code")
    private Integer code;
    @b(a = "error")
    private String error;
    @b(a = "requestid")
    private String requestid;
    @b(a = "status")
    private CJRErrorStatus status;

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

    public final CJRErrorStatus getStatus() {
        return this.status;
    }

    public final void setStatus(CJRErrorStatus cJRErrorStatus) {
        this.status = cJRErrorStatus;
    }

    public final String getRequestid() {
        return this.requestid;
    }

    public final void setRequestid(String str) {
        this.requestid = str;
    }
}
