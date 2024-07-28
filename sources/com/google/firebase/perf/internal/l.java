package com.google.firebase.perf.internal;

import com.google.android.gms.internal.p001firebaseperf.ar;
import com.google.android.gms.internal.p001firebaseperf.bj;

public final class l implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ bj f39215a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ ar f39216b;

    /* renamed from: c  reason: collision with root package name */
    private final /* synthetic */ g f39217c;

    public l(g gVar, bj bjVar, ar arVar) {
        this.f39217c = gVar;
        this.f39215a = bjVar;
        this.f39216b = arVar;
    }

    public final void run() {
        g.a(this.f39217c, this.f39215a, this.f39216b);
    }
}
