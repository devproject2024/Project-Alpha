package com.google.android.gms.measurement.internal;

import com.google.android.gms.internal.measurement.lw;

final class je implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ lw f12252a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ String f12253b;

    /* renamed from: c  reason: collision with root package name */
    private final /* synthetic */ String f12254c;

    /* renamed from: d  reason: collision with root package name */
    private final /* synthetic */ boolean f12255d;

    /* renamed from: e  reason: collision with root package name */
    private final /* synthetic */ AppMeasurementDynamiteService f12256e;

    je(AppMeasurementDynamiteService appMeasurementDynamiteService, lw lwVar, String str, String str2, boolean z) {
        this.f12256e = appMeasurementDynamiteService;
        this.f12252a = lwVar;
        this.f12253b = str;
        this.f12254c = str2;
        this.f12255d = z;
    }

    public final void run() {
        this.f12256e.f11680a.i().a(this.f12252a, this.f12253b, this.f12254c, this.f12255d);
    }
}
