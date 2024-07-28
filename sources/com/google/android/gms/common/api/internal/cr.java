package com.google.android.gms.common.api.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.internal.d;
import com.google.android.gms.common.api.l;
import com.google.android.gms.common.d;
import com.google.android.gms.common.internal.s;
import com.google.android.gms.internal.base.k;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;

final class cr implements bk {

    /* renamed from: a  reason: collision with root package name */
    final ay f8540a;

    /* renamed from: b  reason: collision with root package name */
    final ay f8541b;

    /* renamed from: c  reason: collision with root package name */
    Bundle f8542c;

    /* renamed from: d  reason: collision with root package name */
    ConnectionResult f8543d = null;

    /* renamed from: e  reason: collision with root package name */
    ConnectionResult f8544e = null;

    /* renamed from: f  reason: collision with root package name */
    boolean f8545f = false;

    /* renamed from: g  reason: collision with root package name */
    final Lock f8546g;

    /* renamed from: h  reason: collision with root package name */
    private final Context f8547h;

    /* renamed from: i  reason: collision with root package name */
    private final as f8548i;
    private final Looper j;
    private final Map<a.c<?>, ay> k;
    private final Set<q> l = Collections.newSetFromMap(new WeakHashMap());
    private final a.f m;
    private int n = 0;

    public static cr a(Context context, as asVar, Lock lock, Looper looper, d dVar, Map<a.c<?>, a.f> map, com.google.android.gms.common.internal.d dVar2, Map<a<?>, Boolean> map2, a.C0125a<? extends com.google.android.gms.signin.d, com.google.android.gms.signin.a> aVar, ArrayList<cq> arrayList) {
        Map<a<?>, Boolean> map3 = map2;
        androidx.a.a aVar2 = new androidx.a.a();
        androidx.a.a aVar3 = new androidx.a.a();
        a.f fVar = null;
        for (Map.Entry next : map.entrySet()) {
            a.f fVar2 = (a.f) next.getValue();
            if (fVar2.c()) {
                fVar = fVar2;
            }
            if (fVar2.i()) {
                aVar2.put((a.c) next.getKey(), fVar2);
            } else {
                aVar3.put((a.c) next.getKey(), fVar2);
            }
        }
        s.a(!aVar2.isEmpty(), (Object) "CompositeGoogleApiClient should not be used without any APIs that require sign-in.");
        androidx.a.a aVar4 = new androidx.a.a();
        androidx.a.a aVar5 = new androidx.a.a();
        for (a next2 : map2.keySet()) {
            a.c<?> b2 = next2.b();
            if (aVar2.containsKey(b2)) {
                aVar4.put(next2, map3.get(next2));
            } else if (aVar3.containsKey(b2)) {
                aVar5.put(next2, map3.get(next2));
            } else {
                throw new IllegalStateException("Each API in the isOptionalMap must have a corresponding client in the clients map.");
            }
        }
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = arrayList;
        int size = arrayList4.size();
        int i2 = 0;
        while (i2 < size) {
            Object obj = arrayList4.get(i2);
            i2++;
            cq cqVar = (cq) obj;
            if (aVar4.containsKey(cqVar.f8537a)) {
                arrayList2.add(cqVar);
            } else if (aVar5.containsKey(cqVar.f8537a)) {
                arrayList3.add(cqVar);
            } else {
                throw new IllegalStateException("Each ClientCallbacks must have a corresponding API in the isOptionalMap");
            }
        }
        return new cr(context, asVar, lock, looper, dVar, aVar2, aVar3, dVar2, aVar, fVar, arrayList2, arrayList3, aVar4, aVar5);
    }

    private cr(Context context, as asVar, Lock lock, Looper looper, d dVar, Map<a.c<?>, a.f> map, Map<a.c<?>, a.f> map2, com.google.android.gms.common.internal.d dVar2, a.C0125a<? extends com.google.android.gms.signin.d, com.google.android.gms.signin.a> aVar, a.f fVar, ArrayList<cq> arrayList, ArrayList<cq> arrayList2, Map<a<?>, Boolean> map3, Map<a<?>, Boolean> map4) {
        this.f8547h = context;
        this.f8548i = asVar;
        this.f8546g = lock;
        this.j = looper;
        this.m = fVar;
        Context context2 = context;
        Lock lock2 = lock;
        Looper looper2 = looper;
        d dVar3 = dVar;
        ay ayVar = r2;
        ay ayVar2 = new ay(context2, this.f8548i, lock2, looper2, dVar3, map2, (com.google.android.gms.common.internal.d) null, map4, (a.C0125a<? extends com.google.android.gms.signin.d, com.google.android.gms.signin.a>) null, arrayList2, new ct(this, (byte) 0));
        this.f8540a = ayVar;
        this.f8541b = new ay(context2, this.f8548i, lock2, looper2, dVar3, map, dVar2, map3, aVar, arrayList, new cv(this, (byte) 0));
        androidx.a.a aVar2 = new androidx.a.a();
        for (a.c<?> put : map2.keySet()) {
            aVar2.put(put, this.f8540a);
        }
        for (a.c<?> put2 : map.keySet()) {
            aVar2.put(put2, this.f8541b);
        }
        this.k = Collections.unmodifiableMap(aVar2);
    }

    public final <A extends a.b, R extends l, T extends d.a<R, A>> T a(T t) {
        if (!c(t)) {
            return this.f8540a.a(t);
        }
        if (!h()) {
            return this.f8541b.a(t);
        }
        t.b(new Status(4, (String) null, i()));
        return t;
    }

    public final <A extends a.b, T extends d.a<? extends l, A>> T b(T t) {
        if (!c(t)) {
            return this.f8540a.b(t);
        }
        if (!h()) {
            return this.f8541b.b(t);
        }
        t.b(new Status(4, (String) null, i()));
        return t;
    }

    public final void a() {
        this.n = 2;
        this.f8545f = false;
        this.f8544e = null;
        this.f8543d = null;
        this.f8540a.a();
        this.f8541b.a();
    }

    public final ConnectionResult a(TimeUnit timeUnit) {
        throw new UnsupportedOperationException();
    }

    public final void b() {
        this.f8544e = null;
        this.f8543d = null;
        this.n = 0;
        this.f8540a.b();
        this.f8541b.b();
        c();
    }

    public final boolean d() {
        this.f8546g.lock();
        try {
            boolean z = true;
            if (!this.f8540a.d() || (!this.f8541b.d() && !h() && this.n != 1)) {
                z = false;
            }
            return z;
        } finally {
            this.f8546g.unlock();
        }
    }

    public final boolean e() {
        this.f8546g.lock();
        try {
            return this.n == 2;
        } finally {
            this.f8546g.unlock();
        }
    }

    public final boolean a(q qVar) {
        this.f8546g.lock();
        try {
            if ((e() || d()) && !this.f8541b.d()) {
                this.l.add(qVar);
                if (this.n == 0) {
                    this.n = 1;
                }
                this.f8544e = null;
                this.f8541b.a();
                return true;
            }
            this.f8546g.unlock();
            return false;
        } finally {
            this.f8546g.unlock();
        }
    }

    public final void g() {
        this.f8540a.g();
        this.f8541b.g();
    }

    public final void f() {
        this.f8546g.lock();
        try {
            boolean e2 = e();
            this.f8541b.b();
            this.f8544e = new ConnectionResult(4);
            if (e2) {
                new k(this.j).post(new cu(this));
            } else {
                c();
            }
        } finally {
            this.f8546g.unlock();
        }
    }

    private final void a(ConnectionResult connectionResult) {
        int i2 = this.n;
        if (i2 != 1) {
            if (i2 != 2) {
                Log.wtf("CompositeGAC", "Attempted to call failure callbacks in CONNECTION_MODE_NONE. Callbacks should be disabled via GmsClientSupervisor", new Exception());
                this.n = 0;
            }
            this.f8548i.a(connectionResult);
        }
        c();
        this.n = 0;
    }

    private final void c() {
        for (q a2 : this.l) {
            a2.a();
        }
        this.l.clear();
    }

    private final boolean h() {
        ConnectionResult connectionResult = this.f8544e;
        return connectionResult != null && connectionResult.f8334b == 4;
    }

    private final PendingIntent i() {
        if (this.m == null) {
            return null;
        }
        return PendingIntent.getActivity(this.f8547h, System.identityHashCode(this.f8548i), this.m.d(), 134217728);
    }

    private static boolean b(ConnectionResult connectionResult) {
        return connectionResult != null && connectionResult.b();
    }

    public final void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.append(str).append("authClient").println(AppConstants.COLON);
        this.f8541b.a(String.valueOf(str).concat("  "), fileDescriptor, printWriter, strArr);
        printWriter.append(str).append("anonClient").println(AppConstants.COLON);
        this.f8540a.a(String.valueOf(str).concat("  "), fileDescriptor, printWriter, strArr);
    }

    private final boolean c(d.a<? extends l, ? extends a.b> aVar) {
        a.c<A> cVar = aVar.f8568a;
        s.b(this.k.containsKey(cVar), "GoogleApiClient is not configured to use the API required for this call.");
        return this.k.get(cVar).equals(this.f8541b);
    }

    static /* synthetic */ void a(cr crVar) {
        if (b(crVar.f8543d)) {
            if (b(crVar.f8544e) || crVar.h()) {
                int i2 = crVar.n;
                if (i2 != 1) {
                    if (i2 != 2) {
                        Log.wtf("CompositeGAC", "Attempted to call success callbacks in CONNECTION_MODE_NONE. Callbacks should be disabled via GmsClientSupervisor", new AssertionError());
                        crVar.n = 0;
                        return;
                    }
                    crVar.f8548i.a(crVar.f8542c);
                }
                crVar.c();
                crVar.n = 0;
                return;
            }
            ConnectionResult connectionResult = crVar.f8544e;
            if (connectionResult == null) {
                return;
            }
            if (crVar.n == 1) {
                crVar.c();
                return;
            }
            crVar.a(connectionResult);
            crVar.f8540a.b();
        } else if (crVar.f8543d == null || !b(crVar.f8544e)) {
            ConnectionResult connectionResult2 = crVar.f8543d;
            if (connectionResult2 != null && crVar.f8544e != null) {
                if (crVar.f8541b.l < crVar.f8540a.l) {
                    connectionResult2 = crVar.f8544e;
                }
                crVar.a(connectionResult2);
            }
        } else {
            crVar.f8541b.b();
            crVar.a(crVar.f8543d);
        }
    }

    static /* synthetic */ void a(cr crVar, int i2, boolean z) {
        crVar.f8548i.a(i2, z);
        crVar.f8544e = null;
        crVar.f8543d = null;
    }
}
