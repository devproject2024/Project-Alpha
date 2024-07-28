package com.google.android.gms.measurement.internal;

final /* synthetic */ class gh implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final ge f12032a;

    gh(ge geVar) {
        this.f12032a = geVar;
    }

    public final void run() {
        ge geVar = this.f12032a;
        geVar.h();
        if (geVar.I_().v.a()) {
            geVar.J_().j.a("Deferred Deep Link already retrieved. Not fetching again.");
            return;
        }
        long a2 = geVar.I_().w.a();
        geVar.I_().w.a(1 + a2);
        if (a2 >= 5) {
            geVar.J_().f11831f.a("Permanently failed to retrieve Deferred Deep Link. Reached maximum retries.");
            geVar.I_().v.a(true);
            return;
        }
        geVar.y.v();
    }
}
