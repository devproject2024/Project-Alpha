package com.travel.train.model;

import com.google.gsonhtcfix.a.b;
import java.io.Serializable;

public class a implements Serializable {
    @b(a = "code")
    private Integer code;
    @b(a = "error")
    private String error;
    @b(a = "internal_code")
    private Integer internalCode;
    @b(a = "requestid")
    private String requestid;
    @b(a = "status")
    private b status;

    public String getError() {
        return this.error;
    }

    public Integer getCode() {
        return this.code;
    }

    public b getStatus() {
        return this.status;
    }

    public String getRequestid() {
        return this.requestid;
    }

    public Integer getInternalCode() {
        return this.internalCode;
    }
}
