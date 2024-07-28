package com.google.android.play.core.d;

import android.os.RemoteException;
import com.google.android.play.core.b.ar;
import com.google.android.play.core.b.c;
import java.util.Collection;
import java.util.List;

final class p extends c {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ List f37439a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ com.google.android.play.core.e.p f37440b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ z f37441c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    p(z zVar, com.google.android.play.core.e.p pVar, List list, com.google.android.play.core.e.p pVar2) {
        super(pVar);
        this.f37441c = zVar;
        this.f37439a = list;
        this.f37440b = pVar2;
    }

    public final void a() {
        try {
            ((ar) this.f37441c.f37454b.f37315e).b(this.f37441c.f37455d, z.a((Collection) this.f37439a), z.b(), new v(this.f37441c, this.f37440b));
        } catch (RemoteException e2) {
            z.f37452a.c("deferredUninstall(%s)", this.f37439a);
            this.f37440b.b((Exception) new RuntimeException(e2));
        }
    }
}
