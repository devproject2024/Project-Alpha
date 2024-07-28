package com.appsflyer.internal.model.event;

import android.content.Context;

public class ProxyEvent extends BackgroundEvent {

    /* renamed from: ɪ  reason: contains not printable characters */
    private String f278;

    public ProxyEvent() {
        super((String) null, (Boolean) null, Boolean.FALSE, (Boolean) null, (Context) null);
    }

    public BackgroundEvent body(String str) {
        this.f278 = str;
        return this;
    }

    public String body() {
        return this.f278;
    }
}
