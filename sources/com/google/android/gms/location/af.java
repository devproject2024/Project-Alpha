package com.google.android.gms.location;

import android.os.RemoteException;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.internal.k;
import com.google.android.gms.common.api.internal.v;
import com.google.android.gms.internal.location.t;
import com.google.android.gms.tasks.f;

final class af extends v<t, d> {

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ b f11369b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    af(b bVar, k.a aVar) {
        super(aVar);
        this.f11369b = bVar;
    }

    public final /* synthetic */ void a(a.b bVar, f fVar) throws RemoteException {
        try {
            ((t) bVar).a(this.f8632a, new ag(fVar));
        } catch (RuntimeException e2) {
            fVar.b((Exception) e2);
        }
    }
}
