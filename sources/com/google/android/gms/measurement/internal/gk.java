package com.google.android.gms.measurement.internal;

import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

final class gk implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ AtomicReference f12047a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ boolean f12048b = false;

    /* renamed from: c  reason: collision with root package name */
    private final /* synthetic */ ge f12049c;

    gk(ge geVar, AtomicReference atomicReference) {
        this.f12049c = geVar;
        this.f12047a = atomicReference;
    }

    public final void run() {
        this.f12049c.d().a((AtomicReference<List<zzkl>>) this.f12047a, this.f12048b);
    }
}
