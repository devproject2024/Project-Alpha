package com.google.android.play.core.d;

import android.os.RemoteException;
import com.google.android.play.core.b.ar;
import com.google.android.play.core.b.c;
import com.google.android.play.core.e.p;

final class r extends c {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ p f37445a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ z f37446b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    r(z zVar, p pVar, p pVar2) {
        super(pVar);
        this.f37446b = zVar;
        this.f37445a = pVar2;
    }

    public final void a() {
        try {
            ((ar) this.f37446b.f37454b.f37315e).a(this.f37446b.f37455d, new w(this.f37446b, this.f37445a));
        } catch (RemoteException e2) {
            z.f37452a.c("getSessionStates", new Object[0]);
            this.f37445a.b((Exception) new RuntimeException(e2));
        }
    }
}
