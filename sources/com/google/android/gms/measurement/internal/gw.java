package com.google.android.gms.measurement.internal;

final class gw implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ boolean f12079a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ ge f12080b;

    gw(ge geVar, boolean z) {
        this.f12080b = geVar;
        this.f12079a = z;
    }

    public final void run() {
        ge.a(this.f12080b, this.f12079a);
    }
}
