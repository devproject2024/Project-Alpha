package com.google.android.play.core.d;

import android.os.RemoteException;
import com.google.android.play.core.b.ar;
import com.google.android.play.core.b.at;
import com.google.android.play.core.b.c;
import com.google.android.play.core.e.p;

final class s extends c {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ int f37447a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ p f37448b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ z f37449c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    s(z zVar, p pVar, int i2, p pVar2) {
        super(pVar);
        this.f37449c = zVar;
        this.f37447a = i2;
        this.f37448b = pVar2;
    }

    public final void a() {
        try {
            ((ar) this.f37449c.f37454b.f37315e).a(this.f37449c.f37455d, this.f37447a, z.b(), (at) new t(this.f37449c, this.f37448b));
        } catch (RemoteException e2) {
            z.f37452a.c("cancelInstall(%d)", Integer.valueOf(this.f37447a));
            this.f37448b.b((Exception) new RuntimeException(e2));
        }
    }
}
