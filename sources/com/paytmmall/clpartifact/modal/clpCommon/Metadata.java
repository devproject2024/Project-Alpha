package com.paytmmall.clpartifact.modal.clpCommon;

import com.google.gson.a.c;
import java.io.Serializable;

public class Metadata implements Serializable {
    @c(a = "app_version")
    private Boolean mAppVersion;
    @c(a = "group_tag")
    private String mGroupTag;
    @c(a = "is_fallback")
    private Boolean mIsFallback;
    @c(a = "region")
    private Boolean mRegion;

    public Boolean getAppVersion() {
        return this.mAppVersion;
    }

    public void setAppVersion(Boolean bool) {
        this.mAppVersion = bool;
    }

    public String getGroupTag() {
        return this.mGroupTag;
    }

    public void setGroupTag(String str) {
        this.mGroupTag = str;
    }

    public Boolean getIsFallback() {
        return this.mIsFallback;
    }

    public void setIsFallback(Boolean bool) {
        this.mIsFallback = bool;
    }

    public Boolean getRegion() {
        return this.mRegion;
    }

    public void setRegion(Boolean bool) {
        this.mRegion = bool;
    }
}
