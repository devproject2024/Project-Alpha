package com.google.android.gms.internal.location;

import android.os.RemoteException;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.internal.k;
import com.google.android.gms.common.api.internal.l;
import com.google.android.gms.common.internal.s;
import com.google.android.gms.location.ao;
import com.google.android.gms.location.e;

final class al extends b {

    /* renamed from: d  reason: collision with root package name */
    private final /* synthetic */ e f10382d;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    al(com.google.android.gms.common.api.e eVar, e eVar2) {
        super(eVar);
        this.f10382d = eVar2;
    }

    public final /* synthetic */ void a(a.b bVar) throws RemoteException {
        k.a a2 = l.a(this.f10382d, e.class.getSimpleName());
        c cVar = new c(this);
        m mVar = ((t) bVar).f10396a;
        mVar.f10384a.b();
        s.a(a2, (Object) "Invalid null listener key");
        synchronized (mVar.f10387d) {
            r remove = mVar.f10387d.remove(a2);
            if (remove != null) {
                remove.a();
                mVar.f10384a.a().a(zzbf.a((ao) remove, (f) cVar));
            }
        }
    }
}
