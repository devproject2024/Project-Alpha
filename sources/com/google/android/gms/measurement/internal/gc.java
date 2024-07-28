package com.google.android.gms.measurement.internal;

import com.google.android.gms.internal.measurement.lw;

final class gc implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ lw f12012a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ zzan f12013b;

    /* renamed from: c  reason: collision with root package name */
    private final /* synthetic */ String f12014c;

    /* renamed from: d  reason: collision with root package name */
    private final /* synthetic */ AppMeasurementDynamiteService f12015d;

    gc(AppMeasurementDynamiteService appMeasurementDynamiteService, lw lwVar, zzan zzan, String str) {
        this.f12015d = appMeasurementDynamiteService;
        this.f12012a = lwVar;
        this.f12013b = zzan;
        this.f12014c = str;
    }

    public final void run() {
        this.f12015d.f11680a.i().a(this.f12012a, this.f12013b, this.f12014c);
    }
}
