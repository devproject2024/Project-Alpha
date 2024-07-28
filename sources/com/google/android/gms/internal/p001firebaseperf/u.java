package com.google.android.gms.internal.p001firebaseperf;

import java.util.concurrent.Callable;

/* renamed from: com.google.android.gms.internal.firebase-perf.u  reason: invalid package */
final /* synthetic */ class u implements Callable {

    /* renamed from: a  reason: collision with root package name */
    private final s f9732a;

    u(s sVar) {
        this.f9732a = sVar;
    }

    public final Object call() {
        s sVar = this.f9732a;
        return Boolean.valueOf(sVar.f9721a.add(sVar.d()));
    }
}
