package com.google.android.gms.location.places.internal;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.e;
import com.google.android.gms.common.internal.d;
import com.google.android.gms.location.places.f;

public final class b extends a.C0125a<a, f> {
    public final /* synthetic */ a.f buildClient(Context context, Looper looper, d dVar, Object obj, e.b bVar, e.c cVar) {
        if (((f) obj) == null) {
            new f.a();
            f.a.a();
        }
        return new a(context, looper, dVar, bVar, cVar, context.getPackageName(), (byte) 0);
    }
}
