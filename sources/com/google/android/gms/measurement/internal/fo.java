package com.google.android.gms.measurement.internal;

final class fo implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ zzan f11983a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ String f11984b;

    /* renamed from: c  reason: collision with root package name */
    private final /* synthetic */ fd f11985c;

    fo(fd fdVar, zzan zzan, String str) {
        this.f11985c = fdVar;
        this.f11983a = zzan;
        this.f11984b = str;
    }

    public final void run() {
        this.f11985c.f11950a.l();
        this.f11985c.f11950a.a(this.f11983a, this.f11984b);
    }
}
