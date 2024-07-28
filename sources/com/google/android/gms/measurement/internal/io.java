package com.google.android.gms.measurement.internal;

import android.content.Intent;

public final /* synthetic */ class io implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final il f12218a;

    /* renamed from: b  reason: collision with root package name */
    private final int f12219b;

    /* renamed from: c  reason: collision with root package name */
    private final dy f12220c;

    /* renamed from: d  reason: collision with root package name */
    private final Intent f12221d;

    public io(il ilVar, int i2, dy dyVar, Intent intent) {
        this.f12218a = ilVar;
        this.f12219b = i2;
        this.f12220c = dyVar;
        this.f12221d = intent;
    }

    public final void run() {
        il ilVar = this.f12218a;
        int i2 = this.f12219b;
        dy dyVar = this.f12220c;
        Intent intent = this.f12221d;
        if (((ip) ilVar.f12213a).a(i2)) {
            dyVar.k.a("Local AppMeasurementService processed last upload request. StartId", Integer.valueOf(i2));
            ilVar.c().k.a("Completed wakeful intent.");
            ((ip) ilVar.f12213a).a(intent);
        }
    }
}
