package com.google.firebase.perf.internal;

import com.google.android.gms.internal.p001firebaseperf.ar;
import com.google.android.gms.internal.p001firebaseperf.by;

final class i implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ by f39208a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ ar f39209b;

    /* renamed from: c  reason: collision with root package name */
    private final /* synthetic */ g f39210c;

    i(g gVar, by byVar, ar arVar) {
        this.f39210c = gVar;
        this.f39208a = byVar;
        this.f39209b = arVar;
    }

    public final void run() {
        g.a(this.f39210c, this.f39208a, this.f39209b);
    }
}
