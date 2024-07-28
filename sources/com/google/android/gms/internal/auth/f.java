package com.google.android.gms.internal.auth;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.text.TextUtils;
import com.google.android.gms.auth.api.b;
import com.google.android.gms.auth.api.c;
import com.google.android.gms.common.api.e;
import com.google.android.gms.common.h;
import com.google.android.gms.common.internal.d;
import com.google.android.gms.common.internal.g;
import java.util.HashSet;
import java.util.Set;

public final class f extends g<g> {

    /* renamed from: a  reason: collision with root package name */
    private final Bundle f9075a;

    public f(Context context, Looper looper, d dVar, c cVar, e.b bVar, e.c cVar2) {
        super(context, looper, 16, dVar, bVar, cVar2);
        if (cVar == null) {
            this.f9075a = new Bundle();
            return;
        }
        throw new NoSuchMethodError();
    }

    public final String a() {
        return "com.google.android.gms.auth.service.START";
    }

    public final String b() {
        return "com.google.android.gms.auth.api.internal.IAuthService";
    }

    public final int e() {
        return h.f8688b;
    }

    public final Bundle p() {
        return this.f9075a;
    }

    public final /* synthetic */ IInterface a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.auth.api.internal.IAuthService");
        if (queryLocalInterface instanceof g) {
            return (g) queryLocalInterface;
        }
        return new h(iBinder);
    }

    public final boolean i() {
        Set set;
        d dVar = this.f8837i;
        if (TextUtils.isEmpty(dVar.f8816a != null ? dVar.f8816a.name : null)) {
            return false;
        }
        d.b bVar = dVar.f8819d.get(b.f8118a);
        if (bVar == null || bVar.f8834a.isEmpty()) {
            set = dVar.f8817b;
        } else {
            set = new HashSet(dVar.f8817b);
            set.addAll(bVar.f8834a);
        }
        return !set.isEmpty();
    }
}
