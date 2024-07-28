package com.google.android.gms.location;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.e;
import com.google.android.gms.common.internal.d;
import com.google.android.gms.internal.location.t;

final class m extends a.C0125a<t, Object> {
    m() {
    }

    public final /* synthetic */ a.f buildClient(Context context, Looper looper, d dVar, Object obj, e.b bVar, e.c cVar) {
        return new t(context, looper, bVar, cVar, "locationServices", dVar);
    }
}
