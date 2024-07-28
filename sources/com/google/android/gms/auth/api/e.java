package com.google.android.gms.auth.api;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.auth.api.a;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.e;
import com.google.android.gms.common.internal.d;
import com.google.android.gms.internal.p000authapi.h;

final class e extends a.C0125a<h, a.C0117a> {
    e() {
    }

    public final /* synthetic */ a.f buildClient(Context context, Looper looper, d dVar, Object obj, e.b bVar, e.c cVar) {
        return new h(context, looper, dVar, (a.C0117a) obj, bVar, cVar);
    }
}
