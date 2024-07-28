package com.paytm.paymentsettings.merchantSubscriptions.model;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import kotlin.g.b.g;

public final class ActiveSubscriptionsHead extends IJRPaytmDataModel {
    @b(a = "timestamp")
    private String timestamp;
    @b(a = "version")
    private String version;

    public ActiveSubscriptionsHead() {
        this((String) null, (String) null, 3, (g) null);
    }

    public final String getVersion() {
        return this.version;
    }

    public final void setVersion(String str) {
        this.version = str;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ActiveSubscriptionsHead(String str, String str2, int i2, g gVar) {
        this((i2 & 1) != 0 ? null : str, (i2 & 2) != 0 ? null : str2);
    }

    public final String getTimestamp() {
        return this.timestamp;
    }

    public final void setTimestamp(String str) {
        this.timestamp = str;
    }

    public ActiveSubscriptionsHead(String str, String str2) {
        this.version = str;
        this.timestamp = str2;
    }
}
