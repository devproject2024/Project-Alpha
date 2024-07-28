package com.paytmmall.clpartifact.modal.clpCommon;

import com.google.gson.a.c;
import java.io.Serializable;

public final class ItemCTA implements Serializable {
    @c(a = "label")
    private final String label;
    @c(a = "url")
    private final String url;
    @c(a = "url_type")
    private final String url_type;

    public ItemCTA(String str, String str2, String str3) {
        this.label = str;
        this.url = str2;
        this.url_type = str3;
    }

    public final String getLabel() {
        return this.label;
    }

    public final String getUrl() {
        return this.url;
    }

    public final String getUrl_type() {
        return this.url_type;
    }
}
