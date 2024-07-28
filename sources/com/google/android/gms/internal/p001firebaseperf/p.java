package com.google.android.gms.internal.p001firebaseperf;

/* renamed from: com.google.android.gms.internal.firebase-perf.p  reason: invalid package */
final /* synthetic */ class p implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final o f9717a;

    p(o oVar) {
        this.f9717a = oVar;
    }

    public final void run() {
        o oVar = this.f9717a;
        av d2 = oVar.d();
        if (d2 != null) {
            oVar.f9714d.add(d2);
        }
    }
}
