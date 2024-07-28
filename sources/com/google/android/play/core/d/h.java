package com.google.android.play.core.d;

final class h implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ d f37419a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ int f37420b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ int f37421c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ i f37422d;

    h(i iVar, d dVar, int i2, int i3) {
        this.f37422d = iVar;
        this.f37419a = dVar;
        this.f37420b = i2;
        this.f37421c = i3;
    }

    public final void run() {
        i iVar = this.f37422d;
        d dVar = this.f37419a;
        iVar.a(new f(dVar.a(), this.f37420b, this.f37421c, dVar.d(), dVar.e(), dVar.i(), dVar.j(), dVar.h(), dVar.k()));
    }
}
