package com.google.android.gms.common.api.internal;

import android.os.RemoteException;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.internal.f;
import com.google.android.gms.tasks.f;

public final class ch extends cf<Void> {

    /* renamed from: b  reason: collision with root package name */
    private final n<a.b, ?> f8514b;

    /* renamed from: c  reason: collision with root package name */
    private final v<a.b, ?> f8515c;

    public ch(bn bnVar, f<Void> fVar) {
        super(3, fVar);
        this.f8514b = bnVar.f8469a;
        this.f8515c = bnVar.f8470b;
    }

    public final /* bridge */ /* synthetic */ void a(cz czVar, boolean z) {
    }

    public final void d(f.a<?> aVar) throws RemoteException {
        this.f8514b.a(aVar.f8593a, this.f8510a);
        if (this.f8514b.f8624a.f8618b != null) {
            aVar.f8595c.put(this.f8514b.f8624a.f8618b, new bn(this.f8514b, this.f8515c));
        }
    }

    public final Feature[] a(f.a<?> aVar) {
        return this.f8514b.f8625b;
    }

    public final boolean b(f.a<?> aVar) {
        return this.f8514b.f8626c;
    }

    public final /* bridge */ /* synthetic */ void a(RuntimeException runtimeException) {
        super.a(runtimeException);
    }

    public final /* bridge */ /* synthetic */ void a(Status status) {
        super.a(status);
    }
}
