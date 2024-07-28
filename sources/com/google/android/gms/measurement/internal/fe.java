package com.google.android.gms.measurement.internal;

final class fe implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ gf f11953a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ fc f11954b;

    fe(fc fcVar, gf gfVar) {
        this.f11954b = fcVar;
        this.f11953a = gfVar;
    }

    public final void run() {
        fc.a(this.f11954b, this.f11953a);
        this.f11954b.a();
    }
}
