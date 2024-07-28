package com.google.firebase.perf.internal;

final class n implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ boolean f39219a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ g f39220b;

    n(g gVar, boolean z) {
        this.f39220b = gVar;
        this.f39219a = z;
    }

    public final void run() {
        g gVar = this.f39220b;
        boolean z = this.f39219a;
        x xVar = gVar.f39200b;
        xVar.f39241b.a(z);
        xVar.f39242c.a(z);
    }
}
