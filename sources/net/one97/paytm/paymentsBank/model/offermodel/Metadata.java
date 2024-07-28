package net.one97.paytm.paymentsBank.model.offermodel;

import com.google.gson.a.c;

public class Metadata {
    @c(a = "app_version")
    private boolean appVersion;
    @c(a = "region")
    private boolean region;

    public void setAppVersion(boolean z) {
        this.appVersion = z;
    }

    public boolean isAppVersion() {
        return this.appVersion;
    }

    public void setRegion(boolean z) {
        this.region = z;
    }

    public boolean isRegion() {
        return this.region;
    }

    public String toString() {
        return "Metadata{app_version = '" + this.appVersion + '\'' + ",region = '" + this.region + '\'' + "}";
    }
}
