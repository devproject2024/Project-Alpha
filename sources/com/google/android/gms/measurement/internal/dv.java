package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.h;
import com.google.android.gms.common.internal.c;

public final class dv extends c<dq> {
    public dv(Context context, Looper looper, c.a aVar, c.b bVar) {
        super(context, looper, aVar, bVar);
    }

    public final String a() {
        return "com.google.android.gms.measurement.START";
    }

    public final String b() {
        return "com.google.android.gms.measurement.internal.IMeasurementService";
    }

    public final int e() {
        return h.f8688b;
    }

    public final /* synthetic */ IInterface a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.measurement.internal.IMeasurementService");
        if (queryLocalInterface instanceof dq) {
            return (dq) queryLocalInterface;
        }
        return new ds(iBinder);
    }
}
