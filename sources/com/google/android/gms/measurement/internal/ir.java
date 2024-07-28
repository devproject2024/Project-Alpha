package com.google.android.gms.measurement.internal;

final class ir implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ long f12224a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ is f12225b;

    ir(is isVar, long j) {
        this.f12225b = isVar;
        this.f12224a = j;
    }

    public final void run() {
        this.f12225b.a(this.f12224a);
    }
}
