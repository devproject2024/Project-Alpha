package com.google.android.gms.measurement.internal;

final class hn implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ hi f12126a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ hl f12127b;

    hn(hl hlVar, hi hiVar) {
        this.f12127b = hlVar;
        this.f12126a = hiVar;
    }

    public final void run() {
        this.f12127b.a(this.f12126a, false);
        hl hlVar = this.f12127b;
        hlVar.f12113a = null;
        hlVar.d().a((hi) null);
    }
}
