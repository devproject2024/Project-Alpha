package com.google.android.gms.measurement.internal;

import com.google.android.gms.internal.measurement.lw;

final class hc implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ lw f12092a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ AppMeasurementDynamiteService f12093b;

    hc(AppMeasurementDynamiteService appMeasurementDynamiteService, lw lwVar) {
        this.f12093b = appMeasurementDynamiteService;
        this.f12092a = lwVar;
    }

    public final void run() {
        this.f12093b.f11680a.i().a(this.f12092a);
    }
}
