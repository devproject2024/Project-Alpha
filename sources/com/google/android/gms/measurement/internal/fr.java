package com.google.android.gms.measurement.internal;

final class fr implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ String f11991a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ String f11992b;

    /* renamed from: c  reason: collision with root package name */
    private final /* synthetic */ String f11993c;

    /* renamed from: d  reason: collision with root package name */
    private final /* synthetic */ long f11994d;

    /* renamed from: e  reason: collision with root package name */
    private final /* synthetic */ fd f11995e;

    fr(fd fdVar, String str, String str2, String str3, long j) {
        this.f11995e = fdVar;
        this.f11991a = str;
        this.f11992b = str2;
        this.f11993c = str3;
        this.f11994d = j;
    }

    public final void run() {
        String str = this.f11991a;
        if (str == null) {
            this.f11995e.f11950a.f12266b.h().a(this.f11992b, (hi) null);
            return;
        }
        this.f11995e.f11950a.f12266b.h().a(this.f11992b, new hi(this.f11993c, str, this.f11994d));
    }
}
