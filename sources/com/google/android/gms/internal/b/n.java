package com.google.android.gms.internal.b;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.internal.e;
import com.google.android.gms.common.api.internal.m;
import com.google.android.gms.common.h;
import com.google.android.gms.common.internal.d;
import com.google.android.gms.common.internal.g;

public final class n extends g<j> {
    public n(Context context, Looper looper, d dVar, e eVar, m mVar) {
        super(context, looper, 126, dVar, eVar, mVar);
    }

    public final String a() {
        return "com.google.android.gms.auth.api.phone.service.SmsRetrieverApiService.START";
    }

    public final String b() {
        return "com.google.android.gms.auth.api.phone.internal.ISmsRetrieverApiService";
    }

    public final int e() {
        return h.f8688b;
    }

    public final Feature[] o() {
        return e.f9098e;
    }

    public final /* synthetic */ IInterface a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.auth.api.phone.internal.ISmsRetrieverApiService");
        if (queryLocalInterface instanceof j) {
            return (j) queryLocalInterface;
        }
        return new l(iBinder);
    }
}
