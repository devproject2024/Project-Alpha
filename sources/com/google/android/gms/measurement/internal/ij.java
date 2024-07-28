package com.google.android.gms.measurement.internal;

import android.content.ComponentName;

final class ij implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ Cif f12210a;

    ij(Cif ifVar) {
        this.f12210a = ifVar;
    }

    public final void run() {
        hm.a(this.f12210a.f12199c, new ComponentName(this.f12210a.f12199c.k(), "com.google.android.gms.measurement.AppMeasurementService"));
    }
}
