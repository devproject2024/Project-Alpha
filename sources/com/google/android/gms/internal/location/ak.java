package com.google.android.gms.internal.location;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.internal.k;
import com.google.android.gms.common.api.internal.l;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.e;

final class ak extends b {

    /* renamed from: d  reason: collision with root package name */
    private final /* synthetic */ LocationRequest f10380d;

    /* renamed from: e  reason: collision with root package name */
    private final /* synthetic */ e f10381e;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ak(com.google.android.gms.common.api.e eVar, LocationRequest locationRequest, e eVar2) {
        super(eVar);
        this.f10380d = locationRequest;
        this.f10381e = eVar2;
    }

    public final /* synthetic */ void a(a.b bVar) throws RemoteException {
        t tVar = (t) bVar;
        c cVar = new c(this);
        LocationRequest locationRequest = this.f10380d;
        k a2 = l.a(this.f10381e, ac.a(), e.class.getSimpleName());
        synchronized (tVar.f10396a) {
            m mVar = tVar.f10396a;
            mVar.f10384a.b();
            mVar.f10384a.a().a(new zzbf(1, zzbd.a(locationRequest), mVar.a(a2).asBinder(), (PendingIntent) null, (IBinder) null, cVar.asBinder()));
        }
    }
}
