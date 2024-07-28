package com.google.firebase.perf.internal;

import com.google.android.gms.internal.p001firebaseperf.ar;
import com.google.android.gms.internal.p001firebaseperf.bc;

final class k implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ bc f39212a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ ar f39213b;

    /* renamed from: c  reason: collision with root package name */
    private final /* synthetic */ g f39214c;

    k(g gVar, bc bcVar, ar arVar) {
        this.f39214c = gVar;
        this.f39212a = bcVar;
        this.f39213b = arVar;
    }

    public final void run() {
        g.a(this.f39214c, this.f39212a, this.f39213b);
    }
}
