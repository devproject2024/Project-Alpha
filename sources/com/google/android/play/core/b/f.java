package com.google.android.play.core.b;

final class f extends c {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ l f37305a;

    f(l lVar) {
        this.f37305a = lVar;
    }

    public final void a() {
        if (this.f37305a.f37315e != null) {
            this.f37305a.f37311a.d("Unbind from service.", new Object[0]);
            this.f37305a.f37316g.unbindService(this.f37305a.l);
            this.f37305a.f37317h = false;
            this.f37305a.f37315e = null;
            this.f37305a.l = null;
        }
    }
}
