package com.paytm.notification.models;

import com.google.gson.a.c;
import kotlin.g.b.k;

public final class Context {
    @c(a = "push_id")
    private String pushId = "";
    @c(a = "silent")
    private Boolean silent;
    @c(a = "utm_content")
    private String utmContent = "";
    @c(a = "utm_medium")
    private String utmMedium = "";
    @c(a = "utm_source")
    private String utmSource = "";

    public final String getPushId() {
        return this.pushId;
    }

    public final void setPushId(String str) {
        k.c(str, "<set-?>");
        this.pushId = str;
    }

    public final String getUtmMedium() {
        return this.utmMedium;
    }

    public final void setUtmMedium(String str) {
        k.c(str, "<set-?>");
        this.utmMedium = str;
    }

    public final String getUtmContent() {
        return this.utmContent;
    }

    public final void setUtmContent(String str) {
        k.c(str, "<set-?>");
        this.utmContent = str;
    }

    public final String getUtmSource() {
        return this.utmSource;
    }

    public final void setUtmSource(String str) {
        k.c(str, "<set-?>");
        this.utmSource = str;
    }

    public final Boolean getSilent() {
        return this.silent;
    }

    public final void setSilent(Boolean bool) {
        this.silent = bool;
    }

    public final String toString() {
        return "Context(pushId='" + this.pushId + "', utmMedium='" + this.utmMedium + "', utmContent='" + this.utmContent + "', utmSource='" + this.utmSource + "', silent=" + this.silent + ')';
    }
}
