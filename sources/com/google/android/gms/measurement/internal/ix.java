package com.google.android.gms.measurement.internal;

import android.os.Bundle;

final /* synthetic */ class ix implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final iy f12237a;

    ix(iy iyVar) {
        this.f12237a = iyVar;
    }

    public final void run() {
        iy iyVar = this.f12237a;
        it itVar = iyVar.f12239b;
        long j = iyVar.f12238a;
        itVar.f12232c.h();
        itVar.f12232c.J_().j.a("Application going to the background");
        itVar.f12232c.b().a("auto", "_ab", j, new Bundle());
    }
}
