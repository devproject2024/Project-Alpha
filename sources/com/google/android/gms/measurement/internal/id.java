package com.google.android.gms.measurement.internal;

import com.google.android.gms.internal.measurement.lw;

final class id implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ lw f12188a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ String f12189b;

    /* renamed from: c  reason: collision with root package name */
    private final /* synthetic */ String f12190c;

    /* renamed from: d  reason: collision with root package name */
    private final /* synthetic */ AppMeasurementDynamiteService f12191d;

    id(AppMeasurementDynamiteService appMeasurementDynamiteService, lw lwVar, String str, String str2) {
        this.f12191d = appMeasurementDynamiteService;
        this.f12188a = lwVar;
        this.f12189b = str;
        this.f12190c = str2;
    }

    public final void run() {
        this.f12191d.f11680a.i().a(this.f12188a, this.f12189b, this.f12190c);
    }
}
