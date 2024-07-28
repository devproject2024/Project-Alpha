package com.google.android.gms.measurement.internal;

import android.text.TextUtils;
import com.google.android.gms.internal.measurement.jn;
import java.util.concurrent.atomic.AtomicReference;

final class gm implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ long f12052a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ ge f12053b;

    gm(ge geVar, long j) {
        this.f12053b = geVar;
        this.f12052a = j;
    }

    public final void run() {
        ge geVar = this.f12053b;
        long j = this.f12052a;
        geVar.h();
        geVar.u();
        geVar.J_().j.a("Resetting analytics data (FE)");
        is s = geVar.s();
        s.h();
        ja jaVar = s.f12228c;
        jaVar.f12245c.c();
        jaVar.f12243a = 0;
        jaVar.f12244b = jaVar.f12243a;
        boolean r = geVar.y.r();
        eh I_ = geVar.I_();
        I_.f11866i.a(j);
        if (!TextUtils.isEmpty(I_.I_().x.a())) {
            I_.x.a((String) null);
        }
        jn.a();
        if (I_.H_().d((String) null, o.aM)) {
            I_.r.a(0);
        }
        if (!I_.H_().b()) {
            I_.c(!r);
        }
        geVar.d().B();
        jn.a();
        if (geVar.H_().d((String) null, o.aM)) {
            geVar.s().f12227b.a();
        }
        geVar.f12017b = !r;
        this.f12053b.d().a((AtomicReference<String>) new AtomicReference());
    }
}
