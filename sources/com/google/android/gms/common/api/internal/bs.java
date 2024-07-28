package com.google.android.gms.common.api.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.e;
import com.google.android.gms.common.internal.ResolveAccountResponse;
import com.google.android.gms.common.internal.l;
import com.google.android.gms.common.internal.s;
import com.google.android.gms.signin.c;
import com.google.android.gms.signin.internal.d;
import com.google.android.gms.signin.internal.zak;
import java.util.Set;

public final class bs extends d implements e.b, e.c {

    /* renamed from: b  reason: collision with root package name */
    private static a.C0125a<? extends com.google.android.gms.signin.d, com.google.android.gms.signin.a> f8475b = c.f12438a;

    /* renamed from: a  reason: collision with root package name */
    com.google.android.gms.signin.d f8476a;

    /* renamed from: c  reason: collision with root package name */
    private final Context f8477c;

    /* renamed from: d  reason: collision with root package name */
    private final Handler f8478d;

    /* renamed from: e  reason: collision with root package name */
    private final a.C0125a<? extends com.google.android.gms.signin.d, com.google.android.gms.signin.a> f8479e;

    /* renamed from: f  reason: collision with root package name */
    private Set<Scope> f8480f;

    /* renamed from: g  reason: collision with root package name */
    private com.google.android.gms.common.internal.d f8481g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public bt f8482h;

    public bs(Context context, Handler handler, com.google.android.gms.common.internal.d dVar) {
        this(context, handler, dVar, f8475b);
    }

    public bs(Context context, Handler handler, com.google.android.gms.common.internal.d dVar, a.C0125a<? extends com.google.android.gms.signin.d, com.google.android.gms.signin.a> aVar) {
        this.f8477c = context;
        this.f8478d = handler;
        this.f8481g = (com.google.android.gms.common.internal.d) s.a(dVar, (Object) "ClientSettings must not be null");
        this.f8480f = dVar.f8817b;
        this.f8479e = aVar;
    }

    public final void a(bt btVar) {
        com.google.android.gms.signin.d dVar = this.f8476a;
        if (dVar != null) {
            dVar.f();
        }
        this.f8481g.f8824i = Integer.valueOf(System.identityHashCode(this));
        a.C0125a<? extends com.google.android.gms.signin.d, com.google.android.gms.signin.a> aVar = this.f8479e;
        Context context = this.f8477c;
        Looper looper = this.f8478d.getLooper();
        com.google.android.gms.common.internal.d dVar2 = this.f8481g;
        this.f8476a = (com.google.android.gms.signin.d) aVar.buildClient(context, looper, dVar2, dVar2.f8822g, (e.b) this, (e.c) this);
        this.f8482h = btVar;
        Set<Scope> set = this.f8480f;
        if (set == null || set.isEmpty()) {
            this.f8478d.post(new br(this));
        } else {
            this.f8476a.u();
        }
    }

    public final void onConnected(Bundle bundle) {
        this.f8476a.a(this);
    }

    public final void onConnectionSuspended(int i2) {
        this.f8476a.f();
    }

    public final void onConnectionFailed(ConnectionResult connectionResult) {
        this.f8482h.b(connectionResult);
    }

    public final void a(zak zak) {
        this.f8478d.post(new bu(this, zak));
    }

    static /* synthetic */ void a(bs bsVar, zak zak) {
        ConnectionResult connectionResult = zak.f12452a;
        if (connectionResult.b()) {
            ResolveAccountResponse resolveAccountResponse = zak.f12453b;
            connectionResult = resolveAccountResponse.f8753b;
            if (!connectionResult.b()) {
                String valueOf = String.valueOf(connectionResult);
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 48);
                sb.append("Sign-in succeeded with resolve account failure: ");
                sb.append(valueOf);
                Log.wtf("SignInCoordinator", sb.toString(), new Exception());
            } else {
                bsVar.f8482h.a(l.a.a(resolveAccountResponse.f8752a), bsVar.f8480f);
                bsVar.f8476a.f();
            }
        }
        bsVar.f8482h.b(connectionResult);
        bsVar.f8476a.f();
    }
}
