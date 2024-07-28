package com.google.android.gms.internal.p000authapi;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.auth.api.a;
import com.google.android.gms.common.api.e;
import com.google.android.gms.common.internal.d;
import com.google.android.gms.common.internal.g;

/* renamed from: com.google.android.gms.internal.auth-api.h  reason: invalid package */
public final class h extends g<k> {

    /* renamed from: a  reason: collision with root package name */
    private final a.C0117a f9070a;

    public h(Context context, Looper looper, d dVar, a.C0117a aVar, e.b bVar, e.c cVar) {
        super(context, looper, 68, dVar, bVar, cVar);
        this.f9070a = new a.C0117a.C0118a(aVar == null ? a.C0117a.f8079a : aVar).a(a.a()).a();
    }

    public final String a() {
        return "com.google.android.gms.auth.api.credentials.service.START";
    }

    public final String b() {
        return "com.google.android.gms.auth.api.credentials.internal.ICredentialsService";
    }

    public final int e() {
        return 12800000;
    }

    public final Bundle p() {
        a.C0117a aVar = this.f9070a;
        Bundle bundle = new Bundle();
        bundle.putString("consumer_package", aVar.f8080b);
        bundle.putBoolean("force_save_dialog", aVar.f8081c);
        bundle.putString("log_session_id", aVar.f8082d);
        return bundle;
    }

    public final /* synthetic */ IInterface a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.auth.api.credentials.internal.ICredentialsService");
        if (queryLocalInterface instanceof k) {
            return (k) queryLocalInterface;
        }
        return new j(iBinder);
    }
}
