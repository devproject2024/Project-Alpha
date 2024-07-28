package com.google.android.gms.common.api.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.util.Log;
import com.alipay.mobile.nebula.util.H5Utils;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.e;
import com.google.android.gms.common.api.internal.d;
import com.google.android.gms.common.d;
import com.google.android.gms.common.internal.l;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Future;
import java.util.concurrent.locks.Lock;

public final class ag implements av {

    /* renamed from: a  reason: collision with root package name */
    final ay f8403a;

    /* renamed from: b  reason: collision with root package name */
    final Lock f8404b;

    /* renamed from: c  reason: collision with root package name */
    final Context f8405c;

    /* renamed from: d  reason: collision with root package name */
    final d f8406d;

    /* renamed from: e  reason: collision with root package name */
    com.google.android.gms.signin.d f8407e;

    /* renamed from: f  reason: collision with root package name */
    boolean f8408f;

    /* renamed from: g  reason: collision with root package name */
    boolean f8409g;

    /* renamed from: h  reason: collision with root package name */
    l f8410h;

    /* renamed from: i  reason: collision with root package name */
    boolean f8411i;
    boolean j;
    final com.google.android.gms.common.internal.d k;
    private ConnectionResult l;
    private int m;
    private int n = 0;
    private int o;
    private final Bundle p = new Bundle();
    private final Set<a.c> q = new HashSet();
    private boolean r;
    private final Map<a<?>, Boolean> s;
    private final a.C0125a<? extends com.google.android.gms.signin.d, com.google.android.gms.signin.a> t;
    private ArrayList<Future<?>> u = new ArrayList<>();

    public ag(ay ayVar, com.google.android.gms.common.internal.d dVar, Map<a<?>, Boolean> map, d dVar2, a.C0125a<? extends com.google.android.gms.signin.d, com.google.android.gms.signin.a> aVar, Lock lock, Context context) {
        this.f8403a = ayVar;
        this.k = dVar;
        this.s = map;
        this.f8406d = dVar2;
        this.t = aVar;
        this.f8404b = lock;
        this.f8405c = context;
    }

    private static String c(int i2) {
        return i2 != 0 ? i2 != 1 ? H5Utils.NETWORK_TYPE_UNKNOWN : "STEP_GETTING_REMOTE_SERVICE" : "STEP_SERVICE_BINDINGS_AND_SIGN_IN";
    }

    public final void c() {
    }

    public final void a() {
        this.f8403a.f8447g.clear();
        this.f8408f = false;
        this.l = null;
        this.n = 0;
        this.r = true;
        this.f8409g = false;
        this.f8411i = false;
        HashMap hashMap = new HashMap();
        boolean z = false;
        for (a next : this.s.keySet()) {
            a.f fVar = this.f8403a.f8446f.get(next.b());
            z |= next.f8363a.getPriority() == 1;
            boolean booleanValue = this.s.get(next).booleanValue();
            if (fVar.i()) {
                this.f8408f = true;
                if (booleanValue) {
                    this.q.add(next.b());
                } else {
                    this.r = false;
                }
            }
            hashMap.put(fVar, new ai(this, next, booleanValue));
        }
        if (z) {
            this.f8408f = false;
        }
        if (this.f8408f) {
            this.k.f8824i = Integer.valueOf(System.identityHashCode(this.f8403a.m));
            an anVar = new an(this, (byte) 0);
            a.C0125a<? extends com.google.android.gms.signin.d, com.google.android.gms.signin.a> aVar = this.t;
            Context context = this.f8405c;
            Looper b2 = this.f8403a.m.b();
            com.google.android.gms.common.internal.d dVar = this.k;
            this.f8407e = (com.google.android.gms.signin.d) aVar.buildClient(context, b2, dVar, dVar.f8822g, (e.b) anVar, (e.c) anVar);
        }
        this.o = this.f8403a.f8446f.size();
        this.u.add(az.a().submit(new ah(this, hashMap)));
    }

    /* access modifiers changed from: package-private */
    public final boolean d() {
        this.o--;
        int i2 = this.o;
        if (i2 > 0) {
            return false;
        }
        if (i2 < 0) {
            this.f8403a.m.k();
            Log.wtf("GACConnecting", "GoogleApiClient received too many callbacks for the given step. Clients may be in an unexpected state; GoogleApiClient will now disconnect.", new Exception());
            b(new ConnectionResult(8, (PendingIntent) null));
            return false;
        }
        ConnectionResult connectionResult = this.l;
        if (connectionResult == null) {
            return true;
        }
        this.f8403a.l = this.m;
        b(connectionResult);
        return false;
    }

    /* access modifiers changed from: package-private */
    public final void e() {
        if (this.o == 0) {
            if (!this.f8408f || this.f8409g) {
                ArrayList arrayList = new ArrayList();
                this.n = 1;
                this.o = this.f8403a.f8446f.size();
                for (a.c next : this.f8403a.f8446f.keySet()) {
                    if (!this.f8403a.f8447g.containsKey(next)) {
                        arrayList.add(this.f8403a.f8446f.get(next));
                    } else if (d()) {
                        g();
                    }
                }
                if (!arrayList.isEmpty()) {
                    this.u.add(az.a().submit(new am(this, arrayList)));
                }
            }
        }
    }

    public final void a(Bundle bundle) {
        if (b(1)) {
            if (bundle != null) {
                this.p.putAll(bundle);
            }
            if (d()) {
                g();
            }
        }
    }

    public final void a(ConnectionResult connectionResult, a<?> aVar, boolean z) {
        if (b(1)) {
            b(connectionResult, aVar, z);
            if (d()) {
                g();
            }
        }
    }

    private final void g() {
        this.f8403a.c();
        az.a().execute(new af(this));
        com.google.android.gms.signin.d dVar = this.f8407e;
        if (dVar != null) {
            if (this.f8411i) {
                dVar.a(this.f8410h, this.j);
            }
            a(false);
        }
        for (a.c<?> cVar : this.f8403a.f8447g.keySet()) {
            this.f8403a.f8446f.get(cVar).f();
        }
        this.f8403a.n.a(this.p.isEmpty() ? null : this.p);
    }

    public final <A extends a.b, R extends com.google.android.gms.common.api.l, T extends d.a<R, A>> T a(T t2) {
        this.f8403a.m.f8429a.add(t2);
        return t2;
    }

    public final <A extends a.b, T extends d.a<? extends com.google.android.gms.common.api.l, A>> T b(T t2) {
        throw new IllegalStateException("GoogleApiClient is not connected yet.");
    }

    public final boolean b() {
        h();
        a(true);
        this.f8403a.a((ConnectionResult) null);
        return true;
    }

    public final void a(int i2) {
        b(new ConnectionResult(8, (PendingIntent) null));
    }

    /* access modifiers changed from: package-private */
    public final void f() {
        this.f8408f = false;
        this.f8403a.m.f8431c = Collections.emptySet();
        for (a.c next : this.q) {
            if (!this.f8403a.f8447g.containsKey(next)) {
                this.f8403a.f8447g.put(next, new ConnectionResult(17, (PendingIntent) null));
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final boolean a(ConnectionResult connectionResult) {
        return this.r && !connectionResult.a();
    }

    /* access modifiers changed from: package-private */
    public final void b(ConnectionResult connectionResult) {
        h();
        a(!connectionResult.a());
        this.f8403a.a(connectionResult);
        this.f8403a.n.a(connectionResult);
    }

    private final void a(boolean z) {
        com.google.android.gms.signin.d dVar = this.f8407e;
        if (dVar != null) {
            if (dVar.g() && z) {
                this.f8407e.t();
            }
            this.f8407e.f();
            if (this.k.f8823h) {
                this.f8407e = null;
            }
            this.f8410h = null;
        }
    }

    private final void h() {
        ArrayList arrayList = this.u;
        int size = arrayList.size();
        int i2 = 0;
        while (i2 < size) {
            Object obj = arrayList.get(i2);
            i2++;
            ((Future) obj).cancel(true);
        }
        this.u.clear();
    }

    /* access modifiers changed from: package-private */
    public final boolean b(int i2) {
        if (this.n == i2) {
            return true;
        }
        this.f8403a.m.k();
        String valueOf = String.valueOf(this);
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 23);
        sb.append("Unexpected callback in ");
        sb.append(valueOf);
        int i3 = this.o;
        StringBuilder sb2 = new StringBuilder(33);
        sb2.append("mRemainingConnections=");
        sb2.append(i3);
        String c2 = c(this.n);
        String c3 = c(i2);
        StringBuilder sb3 = new StringBuilder(String.valueOf(c2).length() + 70 + String.valueOf(c3).length());
        sb3.append("GoogleApiClient connecting is in step ");
        sb3.append(c2);
        sb3.append(" but received callback for step ");
        sb3.append(c3);
        new Exception();
        b(new ConnectionResult(8, (PendingIntent) null));
        return false;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x001f, code lost:
        if (r8 != false) goto L_0x0021;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void b(com.google.android.gms.common.ConnectionResult r6, com.google.android.gms.common.api.a<?> r7, boolean r8) {
        /*
            r5 = this;
            com.google.android.gms.common.api.a$a<?, O> r0 = r7.f8363a
            int r0 = r0.getPriority()
            r1 = 0
            r2 = 1
            if (r8 == 0) goto L_0x0021
            boolean r8 = r6.a()
            if (r8 == 0) goto L_0x0012
        L_0x0010:
            r8 = 1
            goto L_0x001f
        L_0x0012:
            com.google.android.gms.common.d r8 = r5.f8406d
            int r3 = r6.f8334b
            r4 = 0
            android.content.Intent r8 = r8.a((android.content.Context) r4, (int) r3, (java.lang.String) r4)
            if (r8 == 0) goto L_0x001e
            goto L_0x0010
        L_0x001e:
            r8 = 0
        L_0x001f:
            if (r8 == 0) goto L_0x002a
        L_0x0021:
            com.google.android.gms.common.ConnectionResult r8 = r5.l
            if (r8 == 0) goto L_0x0029
            int r8 = r5.m
            if (r0 >= r8) goto L_0x002a
        L_0x0029:
            r1 = 1
        L_0x002a:
            if (r1 == 0) goto L_0x0030
            r5.l = r6
            r5.m = r0
        L_0x0030:
            com.google.android.gms.common.api.internal.ay r8 = r5.f8403a
            java.util.Map<com.google.android.gms.common.api.a$c<?>, com.google.android.gms.common.ConnectionResult> r8 = r8.f8447g
            com.google.android.gms.common.api.a$c r7 = r7.b()
            r8.put(r7, r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.api.internal.ag.b(com.google.android.gms.common.ConnectionResult, com.google.android.gms.common.api.a, boolean):void");
    }
}
