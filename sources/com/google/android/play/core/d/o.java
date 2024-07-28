package com.google.android.play.core.d;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.play.core.b.ar;
import com.google.android.play.core.b.at;
import com.google.android.play.core.b.c;
import com.google.android.play.core.e.p;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

final class o extends c {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Collection f37435a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ Collection f37436b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ p f37437c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ z f37438d;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    o(z zVar, p pVar, Collection collection, Collection collection2, p pVar2) {
        super(pVar);
        this.f37438d = zVar;
        this.f37435a = collection;
        this.f37436b = collection2;
        this.f37437c = pVar2;
    }

    public final void a() {
        ArrayList a2 = z.a(this.f37435a);
        a2.addAll(z.b(this.f37436b));
        try {
            ((ar) this.f37438d.f37454b.f37315e).a(this.f37438d.f37455d, (List<Bundle>) a2, z.b(), (at) new x(this.f37438d, this.f37437c));
        } catch (RemoteException e2) {
            z.f37452a.c("startInstall(%s,%s)", this.f37435a, this.f37436b);
            this.f37437c.b((Exception) new RuntimeException(e2));
        }
    }
}
