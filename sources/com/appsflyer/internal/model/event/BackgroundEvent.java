package com.appsflyer.internal.model.event;

import android.content.Context;
import com.appsflyer.AFEvent;
import com.appsflyer.AFHelper;

public abstract class BackgroundEvent extends AFEvent {

    /* renamed from: ɪ  reason: contains not printable characters */
    private final boolean f275;

    /* renamed from: ɾ  reason: contains not printable characters */
    private boolean f276;

    /* renamed from: ӏ  reason: contains not printable characters */
    private final boolean f277;

    BackgroundEvent() {
        this((String) null, (Boolean) null, (Boolean) null, (Boolean) null, (Context) null);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BackgroundEvent(String str, Boolean bool, Boolean bool2, Boolean bool3, Context context) {
        super(str, Boolean.valueOf(bool3 != null ? bool3.booleanValue() : false), context);
        boolean z = true;
        this.f275 = bool != null ? bool.booleanValue() : true;
        this.f277 = bool2 != null ? bool2.booleanValue() : z;
    }

    public BackgroundEvent trackingStopped(boolean z) {
        this.f276 = z;
        return this;
    }

    public boolean trackingStopped() {
        return this.f276;
    }

    public boolean readResponse() {
        return this.f275;
    }

    public boolean proxyMode() {
        return this.f277;
    }

    public String body() {
        return AFHelper.convertToJsonObject(params()).toString();
    }
}
