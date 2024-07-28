package com.google.android.gms.measurement.internal;

import java.util.concurrent.atomic.AtomicReference;

final class gr implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ AtomicReference f12065a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ ge f12066b;

    gr(ge geVar, AtomicReference atomicReference) {
        this.f12066b = geVar;
        this.f12065a = atomicReference;
    }

    public final void run() {
        synchronized (this.f12065a) {
            try {
                this.f12065a.set(Long.valueOf(this.f12066b.H_().a(this.f12066b.c().z(), o.J)));
                this.f12065a.notify();
            } catch (Throwable th) {
                this.f12065a.notify();
                throw th;
            }
        }
    }
}
