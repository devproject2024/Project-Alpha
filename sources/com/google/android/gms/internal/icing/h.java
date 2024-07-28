package com.google.android.gms.internal.icing;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.api.e;
import com.google.android.gms.common.internal.d;
import com.google.android.gms.common.internal.g;

public final class h extends g<b> {
    public h(Context context, Looper looper, d dVar, e.b bVar, e.c cVar) {
        super(context, looper, 19, dVar, bVar, cVar);
    }

    public final String a() {
        return "com.google.android.gms.icing.LIGHTWEIGHT_INDEX_SERVICE";
    }

    public final String b() {
        return "com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearch";
    }

    public final int e() {
        return 12600000;
    }

    public final /* synthetic */ IInterface a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearch");
        if (queryLocalInterface instanceof b) {
            return (b) queryLocalInterface;
        }
        return new e(iBinder);
    }
}
