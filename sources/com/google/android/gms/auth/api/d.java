package com.google.android.gms.auth.api;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.e;
import com.google.android.gms.internal.auth.f;

final class d extends a.C0125a<f, c> {
    d() {
    }

    public final /* synthetic */ a.f buildClient(Context context, Looper looper, com.google.android.gms.common.internal.d dVar, Object obj, e.b bVar, e.c cVar) {
        return new f(context, looper, dVar, (c) obj, bVar, cVar);
    }
}
