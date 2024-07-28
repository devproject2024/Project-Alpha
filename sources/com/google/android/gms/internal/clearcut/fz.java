package com.google.android.gms.internal.clearcut;

import android.os.RemoteException;
import com.google.android.gms.clearcut.a;
import com.google.android.gms.clearcut.zze;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.e;
import com.google.android.gms.common.api.internal.d;
import com.google.android.gms.common.api.l;

final class fz extends d.a<Status, gd> {

    /* renamed from: d  reason: collision with root package name */
    private final zze f9382d;

    fz(zze zze, e eVar) {
        super(a.f8298a, eVar);
        this.f9382d = zze;
    }

    public final /* synthetic */ l a(Status status) {
        return status;
    }

    public final /* synthetic */ void a(a.b bVar) throws RemoteException {
        gd gdVar = (gd) bVar;
        gc gcVar = new gc(this);
        try {
            zze zze = this.f9382d;
            if (zze.f8322d != null && zze.f8321c.f9387f.length == 0) {
                zze.f8321c.f9387f = zze.f8322d.a();
            }
            if (zze.f8323e != null && zze.f8321c.f9389h.length == 0) {
                zze.f8321c.f9389h = zze.f8323e.a();
            }
            ga gaVar = zze.f8321c;
            byte[] bArr = new byte[gaVar.d()];
            ex.a(gaVar, bArr, bArr.length);
            zze.f8320b = bArr;
            ((gh) gdVar.r()).a(gcVar, this.f9382d);
        } catch (RuntimeException unused) {
            b(new Status(10, "MessageProducer"));
        }
    }
}
