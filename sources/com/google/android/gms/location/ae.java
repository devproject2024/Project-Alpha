package com.google.android.gms.location;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.internal.k;
import com.google.android.gms.common.api.internal.n;
import com.google.android.gms.internal.location.m;
import com.google.android.gms.internal.location.t;
import com.google.android.gms.internal.location.zzbd;
import com.google.android.gms.internal.location.zzbf;
import com.google.android.gms.location.b;
import com.google.android.gms.tasks.f;

final class ae extends n<t, d> {

    /* renamed from: d  reason: collision with root package name */
    private final /* synthetic */ zzbd f11367d;

    /* renamed from: e  reason: collision with root package name */
    private final /* synthetic */ k f11368e;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ae(k kVar, zzbd zzbd, k kVar2) {
        super(kVar);
        this.f11367d = zzbd;
        this.f11368e = kVar2;
    }

    public final /* synthetic */ void a(a.b bVar, f fVar) throws RemoteException {
        t tVar = (t) bVar;
        b.a aVar = new b.a(fVar);
        zzbd zzbd = this.f11367d;
        k kVar = this.f11368e;
        synchronized (tVar.f10396a) {
            m mVar = tVar.f10396a;
            mVar.f10384a.b();
            mVar.f10384a.a().a(new zzbf(1, zzbd, (IBinder) null, (PendingIntent) null, mVar.b(kVar).asBinder(), aVar.asBinder()));
        }
    }
}
