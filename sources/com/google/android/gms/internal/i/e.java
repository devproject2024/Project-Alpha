package com.google.android.gms.internal.i;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.api.e;
import com.google.android.gms.common.internal.d;
import com.google.android.gms.common.internal.g;

public final class e extends g<b> {
    public e(Context context, Looper looper, d dVar, e.b bVar, e.c cVar) {
        super(context, looper, 51, dVar, bVar, cVar);
    }

    public final /* synthetic */ IInterface a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.phenotype.internal.IPhenotypeService");
        return queryLocalInterface instanceof b ? (b) queryLocalInterface : new c(iBinder);
    }

    public final String a() {
        return "com.google.android.gms.phenotype.service.START";
    }

    public final String b() {
        return "com.google.android.gms.phenotype.internal.IPhenotypeService";
    }

    public final int e() {
        return 11925000;
    }
}
