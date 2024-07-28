package com.google.android.play.core.b;

import android.os.IBinder;
import android.os.IInterface;

final class i extends c {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ IBinder f37306a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ k f37307b;

    i(k kVar, IBinder iBinder) {
        this.f37307b = kVar;
        this.f37306a = iBinder;
    }

    public final void a() {
        l lVar = this.f37307b.f37309a;
        lVar.f37315e = (IInterface) lVar.j.a(this.f37306a);
        l.f(this.f37307b.f37309a);
        this.f37307b.f37309a.f37317h = false;
        for (Runnable run : this.f37307b.f37309a.f37313c) {
            run.run();
        }
        this.f37307b.f37309a.f37313c.clear();
    }
}
