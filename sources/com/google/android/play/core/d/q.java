package com.google.android.play.core.d;

import android.os.RemoteException;
import com.google.android.play.core.b.ar;
import com.google.android.play.core.b.c;
import com.google.android.play.core.e.p;
import java.util.Collection;
import java.util.List;

final class q extends c {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ List f37442a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ p f37443b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ z f37444c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    q(z zVar, p pVar, List list, p pVar2) {
        super(pVar);
        this.f37444c = zVar;
        this.f37442a = list;
        this.f37443b = pVar2;
    }

    public final void a() {
        try {
            ((ar) this.f37444c.f37454b.f37315e).c(this.f37444c.f37455d, z.a((Collection) this.f37442a), z.b(), new u(this.f37444c, this.f37443b));
        } catch (RemoteException e2) {
            z.f37452a.c("deferredInstall(%s)", this.f37442a);
            this.f37443b.b((Exception) new RuntimeException(e2));
        }
    }
}
