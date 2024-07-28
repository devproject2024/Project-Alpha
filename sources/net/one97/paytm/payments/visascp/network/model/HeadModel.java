package net.one97.paytm.payments.visascp.network.model;

import com.google.gson.a.c;

public class HeadModel extends BaseModel {
    @c(a = "clientId")
    private String mClientId;
    @c(a = "responseTimestamp")
    private String mResponseTimestamp;
    @c(a = "version")
    private String mVersion;

    public String getResponseTimestamp() {
        return this.mResponseTimestamp;
    }

    public String getVersion() {
        return this.mVersion;
    }

    public String getClientId() {
        return this.mClientId;
    }
}
