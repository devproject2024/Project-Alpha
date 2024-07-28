package com.google.android.gms.common.api.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.f;
import com.google.android.gms.common.api.internal.d;
import com.google.android.gms.common.api.l;
import com.google.android.gms.common.d;
import com.google.android.gms.common.internal.d;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public final class cw implements bk {

    /* renamed from: a  reason: collision with root package name */
    final Map<a.c<?>, cx<?>> f8552a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    final Map<a.c<?>, cx<?>> f8553b = new HashMap();

    /* renamed from: c  reason: collision with root package name */
    final as f8554c;

    /* renamed from: d  reason: collision with root package name */
    final Lock f8555d;

    /* renamed from: e  reason: collision with root package name */
    final Condition f8556e;

    /* renamed from: f  reason: collision with root package name */
    final boolean f8557f;

    /* renamed from: g  reason: collision with root package name */
    boolean f8558g;

    /* renamed from: h  reason: collision with root package name */
    Map<b<?>, ConnectionResult> f8559h;

    /* renamed from: i  reason: collision with root package name */
    Map<b<?>, ConnectionResult> f8560i;
    ConnectionResult j;
    private final Map<a<?>, Boolean> k;
    private final f l;
    private final Looper m;
    private final d n;
    private final com.google.android.gms.common.internal.d o;
    private final boolean p;
    private final Queue<d.a<?, ?>> q = new LinkedList();
    private w r;

    public cw(Context context, Lock lock, Looper looper, com.google.android.gms.common.d dVar, Map<a.c<?>, a.f> map, com.google.android.gms.common.internal.d dVar2, Map<a<?>, Boolean> map2, a.C0125a<? extends com.google.android.gms.signin.d, com.google.android.gms.signin.a> aVar, ArrayList<cq> arrayList, as asVar, boolean z) {
        this.f8555d = lock;
        this.m = looper;
        this.f8556e = lock.newCondition();
        this.n = dVar;
        this.f8554c = asVar;
        this.k = map2;
        this.o = dVar2;
        this.p = z;
        HashMap hashMap = new HashMap();
        for (a next : map2.keySet()) {
            hashMap.put(next.b(), next);
        }
        HashMap hashMap2 = new HashMap();
        ArrayList arrayList2 = arrayList;
        int size = arrayList2.size();
        int i2 = 0;
        while (i2 < size) {
            Object obj = arrayList2.get(i2);
            i2++;
            cq cqVar = (cq) obj;
            hashMap2.put(cqVar.f8537a, cqVar);
        }
        for (Map.Entry next2 : map.entrySet()) {
            a aVar2 = (a) hashMap.get(next2.getKey());
            a.f fVar = (a.f) next2.getValue();
            this.k.get(aVar2).booleanValue();
            cx cxVar = r1;
            cx cxVar2 = new cx(context, aVar2, looper, fVar, (cq) hashMap2.get(aVar2), dVar2, aVar);
            this.f8552a.put((a.c) next2.getKey(), cxVar);
            if (fVar.i()) {
                this.f8553b.put((a.c) next2.getKey(), cxVar);
            }
        }
        this.f8557f = false;
        this.l = f.a();
    }

    public final void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
    }

    public final void g() {
    }

    public final <A extends a.b, R extends l, T extends d.a<R, A>> T a(T t) {
        if (this.p && c(t)) {
            return t;
        }
        if (!d()) {
            this.q.add(t);
            return t;
        }
        this.f8554c.f8433e.a(t);
        return this.f8552a.get(t.f8568a).doRead(t);
    }

    public final void a() {
        this.f8555d.lock();
        try {
            if (!this.f8558g) {
                this.f8558g = true;
                this.f8559h = null;
                this.f8560i = null;
                this.r = null;
                this.j = null;
                this.l.c();
                this.l.a((Iterable<? extends f<?>>) this.f8552a.values()).a((Executor) new com.google.android.gms.common.util.a.a(this.m), new cy(this, (byte) 0));
                this.f8555d.unlock();
            }
        } finally {
            this.f8555d.unlock();
        }
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
                nanos = this.f8556e.awaitNanos(nanos);
            }
        }
        if (d()) {
            return ConnectionResult.f8333a;
        }
        ConnectionResult connectionResult = this.j;
        if (connectionResult != null) {
            return connectionResult;
        }
        return new ConnectionResult(13, (PendingIntent) null);
    }

    public final void b() {
        this.f8555d.lock();
        try {
            this.f8558g = false;
            this.f8559h = null;
            this.f8560i = null;
            if (this.r != null) {
                this.r.a();
                this.r = null;
            }
            this.j = null;
            while (!this.q.isEmpty()) {
                d.a remove = this.q.remove();
                remove.a((cd) null);
                remove.a();
            }
            this.f8556e.signalAll();
        } finally {
            this.f8555d.unlock();
        }
    }

    private final ConnectionResult a(a.c<?> cVar) {
        this.f8555d.lock();
        try {
            cx cxVar = this.f8552a.get(cVar);
            if (this.f8559h != null && cxVar != null) {
                return this.f8559h.get(cxVar.getApiKey());
            }
            this.f8555d.unlock();
            return null;
        } finally {
            this.f8555d.unlock();
        }
    }

    public final boolean d() {
        this.f8555d.lock();
        try {
            return this.f8559h != null && this.j == null;
        } finally {
            this.f8555d.unlock();
        }
    }

    public final boolean e() {
        this.f8555d.lock();
        try {
            return this.f8559h == null && this.f8558g;
        } finally {
            this.f8555d.unlock();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x001f A[Catch:{ all -> 0x0044 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean j() {
        /*
            r3 = this;
            java.util.concurrent.locks.Lock r0 = r3.f8555d
            r0.lock()
            boolean r0 = r3.f8558g     // Catch:{ all -> 0x0044 }
            r1 = 0
            if (r0 == 0) goto L_0x003e
            boolean r0 = r3.p     // Catch:{ all -> 0x0044 }
            if (r0 != 0) goto L_0x000f
            goto L_0x003e
        L_0x000f:
            java.util.Map<com.google.android.gms.common.api.a$c<?>, com.google.android.gms.common.api.internal.cx<?>> r0 = r3.f8553b     // Catch:{ all -> 0x0044 }
            java.util.Set r0 = r0.keySet()     // Catch:{ all -> 0x0044 }
            java.util.Iterator r0 = r0.iterator()     // Catch:{ all -> 0x0044 }
        L_0x0019:
            boolean r2 = r0.hasNext()     // Catch:{ all -> 0x0044 }
            if (r2 == 0) goto L_0x0037
            java.lang.Object r2 = r0.next()     // Catch:{ all -> 0x0044 }
            com.google.android.gms.common.api.a$c r2 = (com.google.android.gms.common.api.a.c) r2     // Catch:{ all -> 0x0044 }
            com.google.android.gms.common.ConnectionResult r2 = r3.a((com.google.android.gms.common.api.a.c<?>) r2)     // Catch:{ all -> 0x0044 }
            if (r2 == 0) goto L_0x0031
            boolean r2 = r2.b()     // Catch:{ all -> 0x0044 }
            if (r2 != 0) goto L_0x0019
        L_0x0031:
            java.util.concurrent.locks.Lock r0 = r3.f8555d
            r0.unlock()
            return r1
        L_0x0037:
            java.util.concurrent.locks.Lock r0 = r3.f8555d
            r0.unlock()
            r0 = 1
            return r0
        L_0x003e:
            java.util.concurrent.locks.Lock r0 = r3.f8555d
            r0.unlock()
            return r1
        L_0x0044:
            r0 = move-exception
            java.util.concurrent.locks.Lock r1 = r3.f8555d
            r1.unlock()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.api.internal.cw.j():boolean");
    }

    /* JADX INFO: finally extract failed */
    public final boolean a(q qVar) {
        this.f8555d.lock();
        try {
            if (!this.f8558g || j()) {
                this.f8555d.unlock();
                return false;
            }
            this.l.c();
            this.r = new w(this, qVar);
            this.l.a((Iterable<? extends f<?>>) this.f8553b.values()).a((Executor) new com.google.android.gms.common.util.a.a(this.m), this.r);
            this.f8555d.unlock();
            return true;
        } catch (Throwable th) {
            this.f8555d.unlock();
            throw th;
        }
    }

    public final void f() {
        this.f8555d.lock();
        try {
            f fVar = this.l;
            fVar.f8588d.incrementAndGet();
            fVar.f8591g.sendMessage(fVar.f8591g.obtainMessage(10));
            if (this.r != null) {
                this.r.a();
                this.r = null;
            }
            if (this.f8560i == null) {
                this.f8560i = new androidx.a.a(this.f8553b.size());
            }
            ConnectionResult connectionResult = new ConnectionResult(4);
            for (cx<?> apiKey : this.f8553b.values()) {
                this.f8560i.put(apiKey.getApiKey(), connectionResult);
            }
            if (this.f8559h != null) {
                this.f8559h.putAll(this.f8560i);
            }
        } finally {
            this.f8555d.unlock();
        }
    }

    /* access modifiers changed from: package-private */
    public final void c() {
        com.google.android.gms.common.internal.d dVar = this.o;
        if (dVar == null) {
            this.f8554c.f8431c = Collections.emptySet();
            return;
        }
        HashSet hashSet = new HashSet(dVar.f8817b);
        Map<a<?>, d.b> map = this.o.f8819d;
        for (a next : map.keySet()) {
            ConnectionResult a2 = a(next.b());
            if (a2 != null && a2.b()) {
                hashSet.addAll(map.get(next).f8834a);
            }
        }
        this.f8554c.f8431c = hashSet;
    }

    /* access modifiers changed from: package-private */
    public final void h() {
        while (!this.q.isEmpty()) {
            b(this.q.remove());
        }
        this.f8554c.a((Bundle) null);
    }

    /* access modifiers changed from: package-private */
    public final boolean a(cx<?> cxVar, ConnectionResult connectionResult) {
        return !connectionResult.b() && !connectionResult.a() && this.k.get(cxVar.getApi()).booleanValue() && this.n.a(connectionResult.f8334b);
    }

    /* access modifiers changed from: package-private */
    public final ConnectionResult i() {
        ConnectionResult connectionResult = null;
        ConnectionResult connectionResult2 = null;
        int i2 = 0;
        int i3 = 0;
        for (cx next : this.f8552a.values()) {
            a api = next.getApi();
            ConnectionResult connectionResult3 = this.f8559h.get(next.getApiKey());
            if (!connectionResult3.b() && (!this.k.get(api).booleanValue() || connectionResult3.a() || this.n.a(connectionResult3.f8334b))) {
                if (connectionResult3.f8334b != 4 || !this.p) {
                    int priority = api.f8363a.getPriority();
                    if (connectionResult == null || i2 > priority) {
                        connectionResult = connectionResult3;
                        i2 = priority;
                    }
                } else {
                    int priority2 = api.f8363a.getPriority();
                    if (connectionResult2 == null || i3 > priority2) {
                        connectionResult2 = connectionResult3;
                        i3 = priority2;
                    }
                }
            }
        }
        return (connectionResult == null || connectionResult2 == null || i2 <= i3) ? connectionResult : connectionResult2;
    }

    public final <A extends a.b, T extends d.a<? extends l, A>> T b(T t) {
        a.c<A> cVar = t.f8568a;
        if (this.p && c(t)) {
            return t;
        }
        this.f8554c.f8433e.a(t);
        return this.f8552a.get(cVar).doWrite(t);
    }

    private final <T extends d.a<? extends l, ? extends a.b>> boolean c(T t) {
        a.c<A> cVar = t.f8568a;
        ConnectionResult a2 = a((a.c<?>) cVar);
        if (a2 == null || a2.f8334b != 4) {
            return false;
        }
        t.b(new Status(4, (String) null, this.l.a((b<?>) this.f8552a.get(cVar).getApiKey(), System.identityHashCode(this.f8554c))));
        return true;
    }
}
