package com.google.android.gms.measurement.internal;

import android.os.Bundle;

final class gj implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ String f12038a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ String f12039b;

    /* renamed from: c  reason: collision with root package name */
    private final /* synthetic */ long f12040c;

    /* renamed from: d  reason: collision with root package name */
    private final /* synthetic */ Bundle f12041d;

    /* renamed from: e  reason: collision with root package name */
    private final /* synthetic */ boolean f12042e;

    /* renamed from: f  reason: collision with root package name */
    private final /* synthetic */ boolean f12043f;

    /* renamed from: g  reason: collision with root package name */
    private final /* synthetic */ boolean f12044g;

    /* renamed from: h  reason: collision with root package name */
    private final /* synthetic */ String f12045h = null;

    /* renamed from: i  reason: collision with root package name */
    private final /* synthetic */ ge f12046i;

    gj(ge geVar, String str, String str2, long j, Bundle bundle, boolean z, boolean z2, boolean z3) {
        this.f12046i = geVar;
        this.f12038a = str;
        this.f12039b = str2;
        this.f12040c = j;
        this.f12041d = bundle;
        this.f12042e = z;
        this.f12043f = z2;
        this.f12044g = z3;
    }

    public final void run() {
        this.f12046i.a(this.f12038a, this.f12039b, this.f12040c, this.f12041d, this.f12042e, this.f12043f, this.f12044g, this.f12045h);
    }
}
