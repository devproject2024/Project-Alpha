package com.google.android.gms.measurement.internal;

final class iy implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    long f12238a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ it f12239b;

    iy(it itVar, long j) {
        this.f12239b = itVar;
        this.f12238a = j;
    }

    public final void run() {
        this.f12239b.f12232c.K_().a((Runnable) new ix(this));
    }
}
