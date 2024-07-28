package com.google.android.gms.measurement.internal;

import java.util.concurrent.atomic.AtomicReference;

final class gt implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ AtomicReference f12073a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ ge f12074b;

    gt(ge geVar, AtomicReference atomicReference) {
        this.f12074b = geVar;
        this.f12073a = atomicReference;
    }

    public final void run() {
        synchronized (this.f12073a) {
            try {
                this.f12073a.set(Double.valueOf(this.f12074b.H_().c(this.f12074b.c().z(), o.L)));
                this.f12073a.notify();
            } catch (Throwable th) {
                this.f12073a.notify();
                throw th;
            }
        }
    }
}
