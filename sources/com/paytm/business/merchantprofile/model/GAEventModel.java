package com.paytm.business.merchantprofile.model;

import kotlin.g.b.k;

public final class GAEventModel {
    public final String eventScreenName;
    public final String url;

    public GAEventModel(String str, String str2) {
        k.d(str, "url");
        k.d(str2, "eventScreenName");
        this.url = str;
        this.eventScreenName = str2;
    }

    public final String getEventScreenName() {
        return this.eventScreenName;
    }

    public final String getUrl() {
        return this.url;
    }
}
