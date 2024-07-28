package com.google.android.gms.signin;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.e;
import com.google.android.gms.common.internal.d;

final class b extends a.C0125a<com.google.android.gms.signin.internal.a, a> {
    b() {
    }

    public final /* synthetic */ a.f buildClient(Context context, Looper looper, d dVar, Object obj, e.b bVar, e.c cVar) {
        if (((a) obj) == null) {
            a aVar = a.f12429a;
        }
        return new com.google.android.gms.signin.internal.a(context, looper, dVar, bVar, cVar);
    }
}
