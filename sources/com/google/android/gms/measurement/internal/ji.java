package com.google.android.gms.measurement.internal;

final class ji implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ jo f12262a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ jj f12263b;

    ji(jj jjVar, jo joVar) {
        this.f12263b = jjVar;
        this.f12262a = joVar;
    }

    public final void run() {
        jj.a(this.f12263b);
        jj jjVar = this.f12263b;
        jjVar.f12266b.K_().h();
        jjVar.c().z_();
        if (jjVar.f12266b.b().f11861d.a() == 0) {
            jjVar.f12266b.b().f11861d.a(jjVar.f12266b.j().a());
        }
        jjVar.i();
    }
}
