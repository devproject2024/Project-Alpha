package com.google.android.gms.measurement.internal;

import java.util.concurrent.atomic.AtomicReference;

final class gg implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ AtomicReference f12030a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ ge f12031b;

    gg(ge geVar, AtomicReference atomicReference) {
        this.f12031b = geVar;
        this.f12030a = atomicReference;
    }

    public final void run() {
        synchronized (this.f12030a) {
            try {
                this.f12030a.set(Boolean.valueOf(this.f12031b.H_().d(this.f12031b.c().z(), o.H)));
                this.f12030a.notify();
            } catch (Throwable th) {
                this.f12030a.notify();
                throw th;
            }
        }
    }
}
