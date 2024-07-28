package com.google.android.gms.common.api.internal;

final class da implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ LifecycleCallback f8570a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ String f8571b;

    /* renamed from: c  reason: collision with root package name */
    private final /* synthetic */ db f8572c;

    da(db dbVar, LifecycleCallback lifecycleCallback, String str) {
        this.f8572c = dbVar;
        this.f8570a = lifecycleCallback;
        this.f8571b = str;
    }

    public final void run() {
        if (this.f8572c.f8575c > 0) {
            this.f8570a.a(this.f8572c.f8576d != null ? this.f8572c.f8576d.getBundle(this.f8571b) : null);
        }
        if (this.f8572c.f8575c >= 2) {
            this.f8570a.b();
        }
        if (this.f8572c.f8575c >= 3) {
            this.f8570a.c();
        }
        if (this.f8572c.f8575c >= 4) {
            this.f8570a.d();
        }
        int unused = this.f8572c.f8575c;
    }
}
