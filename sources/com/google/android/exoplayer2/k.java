package com.google.android.exoplayer2;

import android.content.Context;
import android.os.Looper;
import com.google.android.exoplayer2.a.a;
import com.google.android.exoplayer2.drm.e;
import com.google.android.exoplayer2.f.d;
import com.google.android.exoplayer2.f.n;
import com.google.android.exoplayer2.g.ae;
import com.google.android.exoplayer2.trackselection.i;

public final class k {

    /* renamed from: a  reason: collision with root package name */
    private static d f32602a;

    public static ag a(Context context, i iVar) {
        h hVar = new h(context);
        f fVar = new f();
        Looper a2 = ae.a();
        new a.C0529a();
        return a(context, hVar, iVar, fVar, (e<com.google.android.exoplayer2.drm.i>) null, a(context), a2);
    }

    public static ag a(Context context, ae aeVar, i iVar, q qVar, e<com.google.android.exoplayer2.drm.i> eVar, d dVar, Looper looper) {
        return new ag(context, aeVar, iVar, qVar, eVar, dVar, looper);
    }

    private static synchronized d a(Context context) {
        d dVar;
        synchronized (k.class) {
            if (f32602a == null) {
                n.a aVar = new n.a(context);
                f32602a = new n(aVar.f32421a, aVar.f32422b, aVar.f32423c, aVar.f32424d, aVar.f32425e, (byte) 0);
            }
            dVar = f32602a;
        }
        return dVar;
    }
}
