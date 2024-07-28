package com.google.android.gms.common.api.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.internal.d;
import com.google.android.gms.common.api.l;
import com.google.android.gms.common.d;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public final class ay implements bk, cs {

    /* renamed from: a  reason: collision with root package name */
    final Lock f8441a;

    /* renamed from: b  reason: collision with root package name */
    final Condition f8442b;

    /* renamed from: c  reason: collision with root package name */
    final Context f8443c;

    /* renamed from: d  reason: collision with root package name */
    final d f8444d;

    /* renamed from: e  reason: collision with root package name */
    final ba f8445e;

    /* renamed from: f  reason: collision with root package name */
    final Map<a.c<?>, a.f> f8446f;

    /* renamed from: g  reason: collision with root package name */
    final Map<a.c<?>, ConnectionResult> f8447g = new HashMap();

    /* renamed from: h  reason: collision with root package name */
    final com.google.android.gms.common.internal.d f8448h;

    /* renamed from: i  reason: collision with root package name */
    final Map<a<?>, Boolean> f8449i;
    final a.C0125a<? extends com.google.android.gms.signin.d, com.google.android.gms.signin.a> j;
    volatile av k;
    int l;
    final as m;
    final bl n;
    private ConnectionResult o = null;

    public ay(Context context, as asVar, Lock lock, Looper looper, d dVar, Map<a.c<?>, a.f> map, com.google.android.gms.common.internal.d dVar2, Map<a<?>, Boolean> map2, a.C0125a<? extends com.google.android.gms.signin.d, com.google.android.gms.signin.a> aVar, ArrayList<cq> arrayList, bl blVar) {
        this.f8443c = context;
        this.f8441a = lock;
        this.f8444d = dVar;
        this.f8446f = map;
        this.f8448h = dVar2;
        this.f8449i = map2;
        this.j = aVar;
        this.m = asVar;
        this.n = blVar;
        ArrayList arrayList2 = arrayList;
        int size = arrayList2.size();
        int i2 = 0;
        while (i2 < size) {
            Object obj = arrayList2.get(i2);
            i2++;
            ((cq) obj).f8538b = this;
        }
        this.f8445e = new ba(this, looper);
        this.f8442b = lock.newCondition();
        this.k = new ap(this);
    }

    public final boolean a(q qVar) {
        return false;
    }

    public final void f() {
    }

    public final <A extends a.b, R extends l, T extends d.a<R, A>> T a(T t) {
        t.e();
        return this.k.a(t);
    }

    public final <A extends a.b, T extends d.a<? extends l, A>> T b(T t) {
        t.e();
        return this.k.b(t);
    }

    public final void a() {
        this.k.c();
    }

    public final ConnectionResult a(TimeUnit timeUnit) {
        a();
        long nanos = timeUnit.toNanos(3);
        while (e()) {
            if (nanos <= 0) {
                try {
                    b();
                    return new ConnectionResult(14, (PendingIntent) null);
                } catch (InterruptedException unused) {
                    Thread.currentThread().interrupt();
                    return new ConnectionResult(15, (PendingIntent) null);
                }
            } else {
                nanos = this.f8442b.awaitNanos(nanos);
            }
        }
        if (d()) {
            return ConnectionResult.f8333a;
        }
        ConnectionResult connectionResult = this.o;
        if (connectionResult != null) {
            return connectionResult;
        }
        return new ConnectionResult(13, (PendingIntent) null);
    }

    public final void b() {
        if (this.k.b()) {
            this.f8447g.clear();
        }
    }

    /* access modifiers changed from: package-private */
    public final void c() {
        this.f8441a.lock();
        try {
            this.m.i();
            this.k = new ab(this);
            this.k.a();
            this.f8442b.signalAll();
        } finally {
            this.f8441a.unlock();
        }
    }

    /* access modifiers changed from: package-private */
    public final void a(ConnectionResult connectionResult) {
        this.f8441a.lock();
        try {
            this.o = connectionResult;
            this.k = new ap(this);
            this.k.a();
            this.f8442b.signalAll();
        } finally {
            this.f8441a.unlock();
        }
    }

    public final boolean d() {
        return this.k instanceof ab;
    }

    public final boolean e() {
        return this.k instanceof ag;
    }

    public final void g() {
        if (d()) {
            ab abVar = (ab) this.k;
            if (abVar.f8398b) {
                abVar.f8398b = false;
                abVar.f8397a.m.f8433e.a();
                abVar.b();
            }
        }
    }

    public final void a(ConnectionResult connectionResult, a<?> aVar, boolean z) {
        this.f8441a.lock();
        try {
            this.k.a(connectionResult, aVar, z);
        } finally {
            this.f8441a.unlock();
        }
    }

    public final void onConnected(Bundle bundle) {
        this.f8441a.lock();
        try {
            this.k.a(bundle);
        } finally {
            this.f8441a.unlock();
        }
    }

    public final void onConnectionSuspended(int i2) {
        this.f8441a.lock();
        try {
            this.k.a(i2);
        } finally {
            this.f8441a.unlock();
        }
    }

    /* access modifiers changed from: package-private */
    public final void a(ax axVar) {
        this.f8445e.sendMessage(this.f8445e.obtainMessage(1, axVar));
    }

    public final void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        String concat = String.valueOf(str).concat("  ");
        printWriter.append(str).append("mState=").println(this.k);
        for (a next : this.f8449i.keySet()) {
            printWriter.append(str).append(next.f8364b).println(AppConstants.COLON);
            this.f8446f.get(next.b()).a(concat, printWriter);
        }
    }
}
