package com.google.android.gms.common.api.internal;

import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.ResolveAccountResponse;
import com.google.android.gms.common.internal.l;
import com.google.android.gms.signin.internal.zak;

final class ao extends ax {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ ag f8424a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ zak f8425b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ao(av avVar, ag agVar, zak zak) {
        super(avVar);
        this.f8424a = agVar;
        this.f8425b = zak;
    }

    public final void a() {
        ag agVar = this.f8424a;
        zak zak = this.f8425b;
        if (agVar.b(0)) {
            ConnectionResult connectionResult = zak.f12452a;
            if (connectionResult.b()) {
                ResolveAccountResponse resolveAccountResponse = zak.f12453b;
                ConnectionResult connectionResult2 = resolveAccountResponse.f8753b;
                if (!connectionResult2.b()) {
                    String valueOf = String.valueOf(connectionResult2);
                    StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 48);
                    sb.append("Sign-in succeeded with resolve account failure: ");
                    sb.append(valueOf);
                    Log.wtf("GACConnecting", sb.toString(), new Exception());
                    agVar.b(connectionResult2);
                    return;
                }
                agVar.f8409g = true;
                agVar.f8410h = l.a.a(resolveAccountResponse.f8752a);
                agVar.f8411i = resolveAccountResponse.f8754c;
                agVar.j = resolveAccountResponse.f8755d;
                agVar.e();
            } else if (agVar.a(connectionResult)) {
                agVar.f();
                agVar.e();
            } else {
                agVar.b(connectionResult);
            }
        }
    }
}
