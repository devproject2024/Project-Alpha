package com.google.android.gms.measurement.internal;

final class eq implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ fc f11895a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ dy f11896b;

    eq(fc fcVar, dy dyVar) {
        this.f11895a = fcVar;
        this.f11896b = dyVar;
    }

    public final void run() {
        if (this.f11895a.f11949i == null) {
            this.f11896b.f11828c.a("Install Referrer Reporter is null");
            return;
        }
        em emVar = this.f11895a.f11949i;
        emVar.a(emVar.f11884a.k().getPackageName());
    }
}
