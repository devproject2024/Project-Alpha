package com.google.android.gms.internal.p001firebaseperf;

/* renamed from: com.google.android.gms.internal.firebase-perf.q  reason: invalid package */
final /* synthetic */ class q implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final o f9718a;

    q(o oVar) {
        this.f9718a = oVar;
    }

    public final void run() {
        o oVar = this.f9718a;
        av d2 = oVar.d();
        if (d2 != null) {
            oVar.f9714d.add(d2);
        }
    }
}
