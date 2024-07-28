package com.google.android.gms.measurement.internal;

import com.google.android.gms.internal.measurement.lw;

final class ju implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ lw f12296a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ AppMeasurementDynamiteService f12297b;

    ju(AppMeasurementDynamiteService appMeasurementDynamiteService, lw lwVar) {
        this.f12297b = appMeasurementDynamiteService;
        this.f12296a = lwVar;
    }

    public final void run() {
        this.f12297b.f11680a.e().a(this.f12296a, this.f12297b.f11680a.q());
    }
}
