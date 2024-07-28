package com.google.android.gms.signin.internal;

import android.accounts.Account;
import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.internal.b;
import com.google.android.gms.common.api.e;
import com.google.android.gms.common.h;
import com.google.android.gms.common.internal.ResolveAccountRequest;
import com.google.android.gms.common.internal.c;
import com.google.android.gms.common.internal.g;
import com.google.android.gms.common.internal.l;
import com.google.android.gms.common.internal.s;
import com.google.android.gms.signin.d;

public final class a extends g<e> implements d {

    /* renamed from: a  reason: collision with root package name */
    private final boolean f12446a;
    private final com.google.android.gms.common.internal.d j;
    private final Bundle k;
    private Integer l;

    private a(Context context, Looper looper, com.google.android.gms.common.internal.d dVar, Bundle bundle, e.b bVar, e.c cVar) {
        super(context, looper, 44, dVar, bVar, cVar);
        this.f12446a = true;
        this.j = dVar;
        this.k = bundle;
        this.l = dVar.f8824i;
    }

    public final String a() {
        return "com.google.android.gms.signin.service.START";
    }

    public final String b() {
        return "com.google.android.gms.signin.internal.ISignInService";
    }

    public final int e() {
        return h.f8688b;
    }

    public final boolean i() {
        return this.f12446a;
    }

    public final void a(l lVar, boolean z) {
        try {
            ((e) r()).a(lVar, this.l.intValue(), z);
        } catch (RemoteException unused) {
        }
    }

    public final void t() {
        try {
            ((e) r()).a(this.l.intValue());
        } catch (RemoteException unused) {
        }
    }

    public final void a(c cVar) {
        Account account;
        s.a(cVar, (Object) "Expecting a valid ISignInCallbacks");
        try {
            com.google.android.gms.common.internal.d dVar = this.j;
            if (dVar.f8816a != null) {
                account = dVar.f8816a;
            } else {
                account = new Account("<<default account>>", "com.google");
            }
            GoogleSignInAccount googleSignInAccount = null;
            if ("<<default account>>".equals(account.name)) {
                googleSignInAccount = b.a(this.f8796d).a();
            }
            ((e) r()).a(new zai(new ResolveAccountRequest(account, this.l.intValue(), googleSignInAccount)), cVar);
        } catch (RemoteException e2) {
            try {
                cVar.a(new zak());
            } catch (RemoteException unused) {
                Log.wtf("SignInClientImpl", "ISignInCallbacks#onSignInComplete should be executed from the same process, unexpected RemoteException.", e2);
            }
        }
    }

    public final Bundle p() {
        if (!this.f8796d.getPackageName().equals(this.j.f8820e)) {
            this.k.putString("com.google.android.gms.signin.internal.realClientPackageName", this.j.f8820e);
        }
        return this.k;
    }

    public final void u() {
        a((c.C0130c) new c.d());
    }

    public final /* synthetic */ IInterface a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.signin.internal.ISignInService");
        if (queryLocalInterface instanceof e) {
            return (e) queryLocalInterface;
        }
        return new g(iBinder);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public a(android.content.Context r10, android.os.Looper r11, com.google.android.gms.common.internal.d r12, com.google.android.gms.common.api.e.b r13, com.google.android.gms.common.api.e.c r14) {
        /*
            r9 = this;
            com.google.android.gms.signin.a r0 = r12.f8822g
            java.lang.Integer r1 = r12.f8824i
            android.os.Bundle r6 = new android.os.Bundle
            r6.<init>()
            android.accounts.Account r2 = r12.f8816a
            java.lang.String r3 = "com.google.android.gms.signin.internal.clientRequestedAccount"
            r6.putParcelable(r3, r2)
            if (r1 == 0) goto L_0x001b
            int r1 = r1.intValue()
            java.lang.String r2 = "com.google.android.gms.common.internal.ClientSettings.sessionId"
            r6.putInt(r2, r1)
        L_0x001b:
            if (r0 == 0) goto L_0x0072
            boolean r1 = r0.f12430b
            java.lang.String r2 = "com.google.android.gms.signin.internal.offlineAccessRequested"
            r6.putBoolean(r2, r1)
            boolean r1 = r0.f12431c
            java.lang.String r2 = "com.google.android.gms.signin.internal.idTokenRequested"
            r6.putBoolean(r2, r1)
            java.lang.String r1 = r0.f12432d
            java.lang.String r2 = "com.google.android.gms.signin.internal.serverClientId"
            r6.putString(r2, r1)
            r1 = 1
            java.lang.String r2 = "com.google.android.gms.signin.internal.usePromptModeForAuthCode"
            r6.putBoolean(r2, r1)
            boolean r1 = r0.f12433e
            java.lang.String r2 = "com.google.android.gms.signin.internal.forceCodeForRefreshToken"
            r6.putBoolean(r2, r1)
            java.lang.String r1 = r0.f12434f
            java.lang.String r2 = "com.google.android.gms.signin.internal.hostedDomain"
            r6.putString(r2, r1)
            java.lang.String r1 = r0.f12435g
            java.lang.String r2 = "com.google.android.gms.signin.internal.logSessionId"
            r6.putString(r2, r1)
            boolean r1 = r0.f12436h
            java.lang.String r2 = "com.google.android.gms.signin.internal.waitForAccessTokenRefresh"
            r6.putBoolean(r2, r1)
            java.lang.Long r1 = r0.f12437i
            if (r1 == 0) goto L_0x0063
            java.lang.Long r1 = r0.f12437i
            long r1 = r1.longValue()
            java.lang.String r3 = "com.google.android.gms.signin.internal.authApiSignInModuleVersion"
            r6.putLong(r3, r1)
        L_0x0063:
            java.lang.Long r1 = r0.j
            if (r1 == 0) goto L_0x0072
            java.lang.Long r0 = r0.j
            long r0 = r0.longValue()
            java.lang.String r2 = "com.google.android.gms.signin.internal.realClientLibraryVersion"
            r6.putLong(r2, r0)
        L_0x0072:
            r2 = r9
            r3 = r10
            r4 = r11
            r5 = r12
            r7 = r13
            r8 = r14
            r2.<init>(r3, r4, r5, r6, r7, r8)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.signin.internal.a.<init>(android.content.Context, android.os.Looper, com.google.android.gms.common.internal.d, com.google.android.gms.common.api.e$b, com.google.android.gms.common.api.e$c):void");
    }
}
