package com.google.android.gms.location;

import android.app.Activity;
import android.content.Context;
import android.location.Location;
import android.os.Looper;
import com.google.android.gms.common.api.d;
import com.google.android.gms.common.api.internal.k;
import com.google.android.gms.common.api.internal.l;
import com.google.android.gms.common.api.internal.r;
import com.google.android.gms.common.api.internal.u;
import com.google.android.gms.internal.location.ac;
import com.google.android.gms.internal.location.g;
import com.google.android.gms.internal.location.zzad;
import com.google.android.gms.internal.location.zzbd;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.f;

public final class b extends d<Object> {
    public b(Activity activity) {
        super(activity, f.f11372a, null, (r) new com.google.android.gms.common.api.internal.a());
    }

    public b(Context context) {
        super(context, f.f11372a, null, (r) new com.google.android.gms.common.api.internal.a());
    }

    public final Task<Location> a() {
        return doRead(new ad());
    }

    public final Task<Void> a(d dVar) {
        return u.a(doUnregisterEventListener(l.a(dVar, d.class.getSimpleName())));
    }

    static class a extends g {

        /* renamed from: a  reason: collision with root package name */
        private final f<Void> f11371a;

        public a(f<Void> fVar) {
            this.f11371a = fVar;
        }

        public final void a(zzad zzad) {
            u.a(zzad.f10400a, this.f11371a);
        }
    }

    public final Task<Void> a(LocationRequest locationRequest, d dVar, Looper looper) {
        zzbd a2 = zzbd.a(locationRequest);
        k a3 = l.a(dVar, ac.a(looper), d.class.getSimpleName());
        return doRegisterEventListener(new ae(a3, a2, a3), new af(this, a3.f8618b));
    }
}
