package com.google.android.gms.common.api.internal;

final class dd implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ LifecycleCallback f8581a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ String f8582b;

    /* renamed from: c  reason: collision with root package name */
    private final /* synthetic */ dc f8583c;

    dd(dc dcVar, LifecycleCallback lifecycleCallback, String str) {
        this.f8583c = dcVar;
        this.f8581a = lifecycleCallback;
        this.f8582b = str;
    }

    public final void run() {
        if (this.f8583c.f8579c > 0) {
            this.f8581a.a(this.f8583c.f8580d != null ? this.f8583c.f8580d.getBundle(this.f8582b) : null);
        }
        if (this.f8583c.f8579c >= 2) {
            this.f8581a.b();
        }
        if (this.f8583c.f8579c >= 3) {
            this.f8581a.c();
        }
        if (this.f8583c.f8579c >= 4) {
            this.f8581a.d();
        }
        int unused = this.f8583c.f8579c;
    }
}
