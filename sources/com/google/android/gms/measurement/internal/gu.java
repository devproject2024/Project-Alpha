package com.google.android.gms.measurement.internal;

import java.util.concurrent.atomic.AtomicReference;

final class gu implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ AtomicReference f12075a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ ge f12076b;

    gu(ge geVar, AtomicReference atomicReference) {
        this.f12076b = geVar;
        this.f12075a = atomicReference;
    }

    public final void run() {
        synchronized (this.f12075a) {
            try {
                this.f12075a.set(Integer.valueOf(this.f12076b.H_().b(this.f12076b.c().z(), o.K)));
                this.f12075a.notify();
            } catch (Throwable th) {
                this.f12075a.notify();
                throw th;
            }
        }
    }
}
