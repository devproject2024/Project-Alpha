package com.google.android.gms.internal.clearcut;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.api.e;
import com.google.android.gms.common.internal.d;
import com.google.android.gms.common.internal.g;

public final class gd extends g<gh> {
    public gd(Context context, Looper looper, d dVar, e.b bVar, e.c cVar) {
        super(context, looper, 40, dVar, bVar, cVar);
    }

    public final /* synthetic */ IInterface a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.clearcut.internal.IClearcutLoggerService");
        return queryLocalInterface instanceof gh ? (gh) queryLocalInterface : new gi(iBinder);
    }

    public final String a() {
        return "com.google.android.gms.clearcut.service.START";
    }

    public final String b() {
        return "com.google.android.gms.clearcut.internal.IClearcutLoggerService";
    }

    public final int e() {
        return 11925000;
    }
}
