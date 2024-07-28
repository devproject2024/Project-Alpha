package com.google.android.gms.auth.api.signin.internal;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.e;
import com.google.android.gms.common.h;
import com.google.android.gms.common.internal.d;
import com.google.android.gms.common.internal.g;
import com.google.android.gms.internal.p000authapi.a;

public final class i extends g<u> {

    /* renamed from: a  reason: collision with root package name */
    final GoogleSignInOptions f8266a;

    public i(Context context, Looper looper, d dVar, GoogleSignInOptions googleSignInOptions, e.b bVar, e.c cVar) {
        super(context, looper, 91, dVar, bVar, cVar);
        GoogleSignInOptions.a aVar;
        if (googleSignInOptions != null) {
            aVar = new GoogleSignInOptions.a(googleSignInOptions);
        } else {
            aVar = new GoogleSignInOptions.a();
        }
        aVar.f8221b = a.a();
        if (!dVar.f8818c.isEmpty()) {
            for (Scope a2 : dVar.f8818c) {
                aVar.a(a2, new Scope[0]);
            }
        }
        this.f8266a = aVar.b();
    }

    public final String a() {
        return "com.google.android.gms.auth.api.signin.service.START";
    }

    public final String b() {
        return "com.google.android.gms.auth.api.signin.internal.ISignInService";
    }

    public final boolean c() {
        return true;
    }

    public final int e() {
        return h.f8688b;
    }

    public final /* synthetic */ IInterface a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.auth.api.signin.internal.ISignInService");
        if (queryLocalInterface instanceof u) {
            return (u) queryLocalInterface;
        }
        return new t(iBinder);
    }

    public final Intent d() {
        return h.a(this.f8796d, this.f8266a);
    }
}
