package com.google.android.gms.measurement.internal;

final class jd extends g {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ jj f12250a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ jf f12251b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    jd(jf jfVar, fv fvVar, jj jjVar) {
        super(fvVar);
        this.f12251b = jfVar;
        this.f12250a = jjVar;
    }

    public final void a() {
        this.f12251b.b();
        this.f12251b.J_().k.a("Starting upload from DelayedRunnable");
        this.f12250a.h();
    }
}
