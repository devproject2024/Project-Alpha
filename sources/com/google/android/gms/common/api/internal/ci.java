package com.google.android.gms.common.api.internal;

import android.os.RemoteException;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.f;
import com.google.android.gms.common.api.internal.k;
import com.google.android.gms.tasks.f;

public final class ci extends cf<Boolean> {

    /* renamed from: b  reason: collision with root package name */
    private final k.a<?> f8516b;

    public ci(k.a<?> aVar, f<Boolean> fVar) {
        super(4, fVar);
        this.f8516b = aVar;
    }

    public final /* bridge */ /* synthetic */ void a(cz czVar, boolean z) {
    }

    public final /* bridge */ /* synthetic */ void a(RuntimeException runtimeException) {
        super.a(runtimeException);
    }

    public final /* bridge */ /* synthetic */ void a(Status status) {
        super.a(status);
    }

    public final void d(f.a<?> aVar) throws RemoteException {
        bn remove = aVar.f8595c.remove(this.f8516b);
        if (remove != null) {
            remove.f8470b.a(aVar.f8593a, this.f8510a);
            remove.f8469a.f8624a.f8617a = null;
            return;
        }
        this.f8510a.b(Boolean.FALSE);
    }

    public final Feature[] a(f.a<?> aVar) {
        bn bnVar = aVar.f8595c.get(this.f8516b);
        if (bnVar == null) {
            return null;
        }
        return bnVar.f8469a.f8625b;
    }

    public final boolean b(f.a<?> aVar) {
        bn bnVar = aVar.f8595c.get(this.f8516b);
        return bnVar != null && bnVar.f8469a.f8626c;
    }
}
