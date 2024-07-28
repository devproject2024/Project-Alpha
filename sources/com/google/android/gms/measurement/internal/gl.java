package com.google.android.gms.measurement.internal;

final class gl implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ gd f12050a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ ge f12051b;

    gl(ge geVar, gd gdVar) {
        this.f12051b = geVar;
        this.f12050a = gdVar;
    }

    public final void run() {
        this.f12051b.a(this.f12050a);
    }
}
