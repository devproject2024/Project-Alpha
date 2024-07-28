package com.paytmmall.clpartifact.modal.clpCommon;

import com.google.gson.a.c;
import java.io.Serializable;

public class SubApi implements Serializable {
    @c(a = "name")
    private String mName;
    @c(a = "version")
    private Long mVersion;

    public String getName() {
        return this.mName;
    }

    public void setName(String str) {
        this.mName = str;
    }

    public Long getVersion() {
        return this.mVersion;
    }

    public void setVersion(Long l) {
        this.mVersion = l;
    }
}
