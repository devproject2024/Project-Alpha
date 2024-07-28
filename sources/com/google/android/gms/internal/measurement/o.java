package com.google.android.gms.internal.measurement;

import android.os.RemoteException;
import android.util.Pair;
import com.google.android.gms.internal.measurement.mk;
import com.google.android.gms.measurement.internal.gb;

public final class o extends mk.a {

    /* renamed from: c  reason: collision with root package name */
    private final /* synthetic */ gb f10927c;

    /* renamed from: d  reason: collision with root package name */
    private final /* synthetic */ mk f10928d;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public o(mk mkVar, gb gbVar) {
        super(mkVar);
        this.f10928d = mkVar;
        this.f10927c = gbVar;
    }

    /* access modifiers changed from: package-private */
    public final void a() throws RemoteException {
        for (int i2 = 0; i2 < this.f10928d.f10912f.size(); i2++) {
            if (this.f10927c.equals(((Pair) this.f10928d.f10912f.get(i2)).first)) {
                String unused = this.f10928d.f10909c;
                return;
            }
        }
        mk.b bVar = new mk.b(this.f10927c);
        this.f10928d.f10912f.add(new Pair(this.f10927c, bVar));
        this.f10928d.r.registerOnMeasurementEventListener(bVar);
    }
}
