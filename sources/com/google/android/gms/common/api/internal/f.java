package com.google.android.gms.common.api.internal;

import android.app.Application;
import android.app.PendingIntent;
import android.content.Context;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.d;
import com.google.android.gms.common.api.e;
import com.google.android.gms.common.api.internal.c;
import com.google.android.gms.common.api.internal.k;
import com.google.android.gms.common.internal.c;
import com.google.android.gms.common.internal.k;
import com.google.android.gms.common.internal.l;
import com.google.android.gms.common.internal.q;
import com.google.android.gms.common.internal.s;
import com.google.android.gms.common.internal.u;
import com.google.android.gms.tasks.Task;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public final class f implements Handler.Callback {

    /* renamed from: a  reason: collision with root package name */
    public static final Status f8584a = new Status(4, "Sign-out occurred while this API call was in progress.");
    /* access modifiers changed from: package-private */

    /* renamed from: b  reason: collision with root package name */
    public static final Object f8585b = new Object();
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public static final Status f8586h = new Status(4, "The user must be signed in to make this API call.");
    private static f l;

    /* renamed from: c  reason: collision with root package name */
    public final AtomicInteger f8587c = new AtomicInteger(1);

    /* renamed from: d  reason: collision with root package name */
    public final AtomicInteger f8588d = new AtomicInteger(0);
    /* access modifiers changed from: package-private */

    /* renamed from: e  reason: collision with root package name */
    public z f8589e = null;
    /* access modifiers changed from: package-private */

    /* renamed from: f  reason: collision with root package name */
    public final Set<b<?>> f8590f = new androidx.a.b();

    /* renamed from: g  reason: collision with root package name */
    public final Handler f8591g;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public long f8592i = 5000;
    /* access modifiers changed from: private */
    public long j = 120000;
    /* access modifiers changed from: private */
    public long k = 10000;
    /* access modifiers changed from: private */
    public final Context m;
    private final com.google.android.gms.common.c n;
    /* access modifiers changed from: private */
    public final k o;
    /* access modifiers changed from: private */
    public final Map<b<?>, a<?>> p = new ConcurrentHashMap(5, 0.75f, 1);
    private final Set<b<?>> q = new androidx.a.b();

    public static f a(Context context) {
        f fVar;
        synchronized (f8585b) {
            if (l == null) {
                HandlerThread handlerThread = new HandlerThread("GoogleApiHandler", 9);
                handlerThread.start();
                l = new f(context.getApplicationContext(), handlerThread.getLooper(), com.google.android.gms.common.c.a());
            }
            fVar = l;
        }
        return fVar;
    }

    static class c {

        /* renamed from: a  reason: collision with root package name */
        final b<?> f8608a;

        /* renamed from: b  reason: collision with root package name */
        final Feature f8609b;

        private c(b<?> bVar, Feature feature) {
            this.f8608a = bVar;
            this.f8609b = feature;
        }

        public final boolean equals(Object obj) {
            if (obj != null && (obj instanceof c)) {
                c cVar = (c) obj;
                if (!q.a(this.f8608a, cVar.f8608a) || !q.a(this.f8609b, cVar.f8609b)) {
                    return false;
                }
                return true;
            }
            return false;
        }

        public final int hashCode() {
            return Arrays.hashCode(new Object[]{this.f8608a, this.f8609b});
        }

        public final String toString() {
            return q.a((Object) this).a("key", this.f8608a).a("feature", this.f8609b).toString();
        }

        /* synthetic */ c(b bVar, Feature feature, byte b2) {
            this(bVar, feature);
        }
    }

    class b implements bt, c.C0130c {

        /* renamed from: a  reason: collision with root package name */
        final a.f f8602a;

        /* renamed from: b  reason: collision with root package name */
        final b<?> f8603b;

        /* renamed from: c  reason: collision with root package name */
        boolean f8604c = false;

        /* renamed from: e  reason: collision with root package name */
        private l f8606e = null;

        /* renamed from: f  reason: collision with root package name */
        private Set<Scope> f8607f = null;

        public b(a.f fVar, b<?> bVar) {
            this.f8602a = fVar;
            this.f8603b = bVar;
        }

        public final void a(ConnectionResult connectionResult) {
            f.this.f8591g.post(new bi(this, connectionResult));
        }

        public final void b(ConnectionResult connectionResult) {
            a aVar = (a) f.this.p.get(this.f8603b);
            s.a(f.this.f8591g);
            aVar.f8593a.f();
            aVar.onConnectionFailed(connectionResult);
        }

        public final void a(l lVar, Set<Scope> set) {
            if (lVar == null || set == null) {
                Log.wtf("GoogleApiManager", "Received null response from onSignInSuccess", new Exception());
                b(new ConnectionResult(4));
                return;
            }
            this.f8606e = lVar;
            this.f8607f = set;
            a();
        }

        /* access modifiers changed from: package-private */
        public final void a() {
            l lVar;
            if (this.f8604c && (lVar = this.f8606e) != null) {
                this.f8602a.a(lVar, this.f8607f);
            }
        }
    }

    public static f a() {
        f fVar;
        synchronized (f8585b) {
            s.a(l, (Object) "Must guarantee manager is non-null before using getInstance");
            fVar = l;
        }
        return fVar;
    }

    public static void b() {
        synchronized (f8585b) {
            if (l != null) {
                f fVar = l;
                fVar.f8588d.incrementAndGet();
                fVar.f8591g.sendMessageAtFrontOfQueue(fVar.f8591g.obtainMessage(10));
            }
        }
    }

    public class a<O extends a.d> implements e.b, e.c, cs {

        /* renamed from: a  reason: collision with root package name */
        final a.f f8593a;

        /* renamed from: b  reason: collision with root package name */
        final Set<ck> f8594b = new HashSet();

        /* renamed from: c  reason: collision with root package name */
        final Map<k.a<?>, bn> f8595c = new HashMap();

        /* renamed from: d  reason: collision with root package name */
        final int f8596d;

        /* renamed from: e  reason: collision with root package name */
        final bs f8597e;

        /* renamed from: f  reason: collision with root package name */
        boolean f8598f;

        /* renamed from: g  reason: collision with root package name */
        final List<c> f8599g = new ArrayList();

        /* renamed from: i  reason: collision with root package name */
        private final Queue<bo> f8601i = new LinkedList();
        private final a.b j;
        private final b<O> k;
        private final cz l;
        private ConnectionResult m = null;

        public a(d<O> dVar) {
            this.f8593a = dVar.zaa(f.this.f8591g.getLooper(), (a<O>) this);
            a.f fVar = this.f8593a;
            if (fVar instanceof u) {
                this.j = ((u) fVar).f8867a;
            } else {
                this.j = fVar;
            }
            this.k = dVar.getApiKey();
            this.l = new cz();
            this.f8596d = dVar.getInstanceId();
            if (this.f8593a.i()) {
                this.f8597e = dVar.zaa(f.this.m, f.this.f8591g);
            } else {
                this.f8597e = null;
            }
        }

        public final void onConnected(Bundle bundle) {
            if (Looper.myLooper() == f.this.f8591g.getLooper()) {
                i();
            } else {
                f.this.f8591g.post(new bc(this));
            }
        }

        /* access modifiers changed from: private */
        public final void i() {
            d();
            b(ConnectionResult.f8333a);
            f();
            Iterator<bn> it2 = this.f8595c.values().iterator();
            while (it2.hasNext()) {
                bn next = it2.next();
                if (a(next.f8469a.f8625b) != null) {
                    it2.remove();
                } else {
                    try {
                        next.f8469a.a(this.j, new com.google.android.gms.tasks.f());
                    } catch (DeadObjectException unused) {
                        onConnectionSuspended(1);
                        this.f8593a.f();
                    } catch (RemoteException unused2) {
                        it2.remove();
                    }
                }
            }
            b();
            j();
        }

        public final void onConnectionSuspended(int i2) {
            if (Looper.myLooper() == f.this.f8591g.getLooper()) {
                a();
            } else {
                f.this.f8591g.post(new be(this));
            }
        }

        /* access modifiers changed from: package-private */
        public final void a() {
            d();
            this.f8598f = true;
            this.l.c();
            f.this.f8591g.sendMessageDelayed(Message.obtain(f.this.f8591g, 9, this.k), f.this.f8592i);
            f.this.f8591g.sendMessageDelayed(Message.obtain(f.this.f8591g, 11, this.k), f.this.j);
            f.this.o.f8860a.clear();
        }

        private final boolean a(ConnectionResult connectionResult) {
            synchronized (f.f8585b) {
                if (f.this.f8589e == null || !f.this.f8590f.contains(this.k)) {
                    return false;
                }
                f.this.f8589e.b(connectionResult, this.f8596d);
                return true;
            }
        }

        public final void a(ConnectionResult connectionResult, com.google.android.gms.common.api.a<?> aVar, boolean z) {
            if (Looper.myLooper() == f.this.f8591g.getLooper()) {
                onConnectionFailed(connectionResult);
            } else {
                f.this.f8591g.post(new bd(this, connectionResult));
            }
        }

        public final void onConnectionFailed(ConnectionResult connectionResult) {
            s.a(f.this.f8591g);
            bs bsVar = this.f8597e;
            if (!(bsVar == null || bsVar.f8476a == null)) {
                bsVar.f8476a.f();
            }
            d();
            f.this.o.f8860a.clear();
            b(connectionResult);
            if (connectionResult.f8334b == 4) {
                a(f.f8586h);
            } else if (this.f8601i.isEmpty()) {
                this.m = connectionResult;
            } else if (!a(connectionResult) && !f.this.a(connectionResult, this.f8596d)) {
                if (connectionResult.f8334b == 18) {
                    this.f8598f = true;
                }
                if (this.f8598f) {
                    f.this.f8591g.sendMessageDelayed(Message.obtain(f.this.f8591g, 9, this.k), f.this.f8592i);
                    return;
                }
                String str = this.k.f8451a.f8364b;
                String valueOf = String.valueOf(connectionResult);
                StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 63 + String.valueOf(valueOf).length());
                sb.append("API: ");
                sb.append(str);
                sb.append(" is not available on this device. Connection failed with: ");
                sb.append(valueOf);
                a(new Status(17, sb.toString()));
            }
        }

        /* access modifiers changed from: package-private */
        public final void b() {
            ArrayList arrayList = new ArrayList(this.f8601i);
            int size = arrayList.size();
            int i2 = 0;
            while (i2 < size) {
                Object obj = arrayList.get(i2);
                i2++;
                bo boVar = (bo) obj;
                if (!this.f8593a.g()) {
                    return;
                }
                if (b(boVar)) {
                    this.f8601i.remove(boVar);
                }
            }
        }

        public final void a(bo boVar) {
            s.a(f.this.f8591g);
            if (!this.f8593a.g()) {
                this.f8601i.add(boVar);
                ConnectionResult connectionResult = this.m;
                if (connectionResult == null || !connectionResult.a()) {
                    g();
                } else {
                    onConnectionFailed(this.m);
                }
            } else if (b(boVar)) {
                j();
            } else {
                this.f8601i.add(boVar);
            }
        }

        public final void c() {
            s.a(f.this.f8591g);
            a(f.f8584a);
            this.l.b();
            for (k.a ciVar : (k.a[]) this.f8595c.keySet().toArray(new k.a[this.f8595c.size()])) {
                a((bo) new ci(ciVar, new com.google.android.gms.tasks.f()));
            }
            b(new ConnectionResult(4));
            if (this.f8593a.g()) {
                this.f8593a.a((c.e) new bg(this));
            }
        }

        public final void d() {
            s.a(f.this.f8591g);
            this.m = null;
        }

        public final ConnectionResult e() {
            s.a(f.this.f8591g);
            return this.m;
        }

        private final boolean b(bo boVar) {
            if (!(boVar instanceof au)) {
                c(boVar);
                return true;
            }
            au auVar = (au) boVar;
            Feature a2 = a(auVar.a(this));
            if (a2 == null) {
                c(boVar);
                return true;
            }
            if (auVar.b(this)) {
                c cVar = new c(this.k, a2, (byte) 0);
                int indexOf = this.f8599g.indexOf(cVar);
                if (indexOf >= 0) {
                    c cVar2 = this.f8599g.get(indexOf);
                    f.this.f8591g.removeMessages(15, cVar2);
                    f.this.f8591g.sendMessageDelayed(Message.obtain(f.this.f8591g, 15, cVar2), f.this.f8592i);
                } else {
                    this.f8599g.add(cVar);
                    f.this.f8591g.sendMessageDelayed(Message.obtain(f.this.f8591g, 15, cVar), f.this.f8592i);
                    f.this.f8591g.sendMessageDelayed(Message.obtain(f.this.f8591g, 16, cVar), f.this.j);
                    ConnectionResult connectionResult = new ConnectionResult(2, (PendingIntent) null);
                    if (!a(connectionResult)) {
                        f.this.a(connectionResult, this.f8596d);
                    }
                }
            } else {
                auVar.a((RuntimeException) new com.google.android.gms.common.api.q(a2));
            }
            return false;
        }

        private final void c(bo boVar) {
            boVar.a(this.l, h());
            try {
                boVar.c(this);
            } catch (DeadObjectException unused) {
                onConnectionSuspended(1);
                this.f8593a.f();
            }
        }

        public final void a(Status status) {
            s.a(f.this.f8591g);
            for (bo a2 : this.f8601i) {
                a2.a(status);
            }
            this.f8601i.clear();
        }

        /* access modifiers changed from: package-private */
        public final void f() {
            if (this.f8598f) {
                f.this.f8591g.removeMessages(11, this.k);
                f.this.f8591g.removeMessages(9, this.k);
                this.f8598f = false;
            }
        }

        private final void j() {
            f.this.f8591g.removeMessages(12, this.k);
            f.this.f8591g.sendMessageDelayed(f.this.f8591g.obtainMessage(12, this.k), f.this.k);
        }

        /* access modifiers changed from: package-private */
        public final boolean a(boolean z) {
            s.a(f.this.f8591g);
            if (!this.f8593a.g() || this.f8595c.size() != 0) {
                return false;
            }
            if (this.l.a()) {
                if (z) {
                    j();
                }
                return false;
            }
            this.f8593a.f();
            return true;
        }

        public final void g() {
            s.a(f.this.f8591g);
            if (!this.f8593a.g() && !this.f8593a.h()) {
                int a2 = f.this.o.a(f.this.m, this.f8593a);
                if (a2 != 0) {
                    onConnectionFailed(new ConnectionResult(a2, (PendingIntent) null));
                    return;
                }
                b bVar = new b(this.f8593a, this.k);
                if (this.f8593a.i()) {
                    this.f8597e.a((bt) bVar);
                }
                this.f8593a.a((c.C0130c) bVar);
            }
        }

        private final void b(ConnectionResult connectionResult) {
            for (ck next : this.f8594b) {
                String str = null;
                if (q.a(connectionResult, ConnectionResult.f8333a)) {
                    str = this.f8593a.j();
                }
                next.a(this.k, connectionResult, str);
            }
            this.f8594b.clear();
        }

        public final boolean h() {
            return this.f8593a.i();
        }

        private final Feature a(Feature[] featureArr) {
            if (!(featureArr == null || featureArr.length == 0)) {
                Feature[] k2 = this.f8593a.k();
                if (k2 == null) {
                    k2 = new Feature[0];
                }
                androidx.a.a aVar = new androidx.a.a(k2.length);
                for (Feature feature : k2) {
                    aVar.put(feature.f8338a, Long.valueOf(feature.a()));
                }
                for (Feature feature2 : featureArr) {
                    if (!aVar.containsKey(feature2.f8338a) || ((Long) aVar.get(feature2.f8338a)).longValue() < feature2.a()) {
                        return feature2;
                    }
                }
            }
            return null;
        }

        /* access modifiers changed from: package-private */
        public final void a(c cVar) {
            Feature[] a2;
            if (this.f8599g.remove(cVar)) {
                f.this.f8591g.removeMessages(15, cVar);
                f.this.f8591g.removeMessages(16, cVar);
                Feature feature = cVar.f8609b;
                ArrayList arrayList = new ArrayList(this.f8601i.size());
                for (bo boVar : this.f8601i) {
                    if ((boVar instanceof au) && (a2 = ((au) boVar).a(this)) != null && com.google.android.gms.common.util.b.a((T[]) a2, feature)) {
                        arrayList.add(boVar);
                    }
                }
                ArrayList arrayList2 = arrayList;
                int size = arrayList2.size();
                int i2 = 0;
                while (i2 < size) {
                    Object obj = arrayList2.get(i2);
                    i2++;
                    bo boVar2 = (bo) obj;
                    this.f8601i.remove(boVar2);
                    boVar2.a((RuntimeException) new com.google.android.gms.common.api.q(feature));
                }
            }
        }
    }

    private f(Context context, Looper looper, com.google.android.gms.common.c cVar) {
        this.m = context;
        this.f8591g = new com.google.android.gms.internal.base.k(looper, this);
        this.n = cVar;
        this.o = new com.google.android.gms.common.internal.k(cVar);
        Handler handler = this.f8591g;
        handler.sendMessage(handler.obtainMessage(6));
    }

    public final void a(d<?> dVar) {
        Handler handler = this.f8591g;
        handler.sendMessage(handler.obtainMessage(7, dVar));
    }

    private final void b(d<?> dVar) {
        b<?> apiKey = dVar.getApiKey();
        a aVar = this.p.get(apiKey);
        if (aVar == null) {
            aVar = new a(dVar);
            this.p.put(apiKey, aVar);
        }
        if (aVar.h()) {
            this.q.add(apiKey);
        }
        aVar.g();
    }

    public final void a(z zVar) {
        synchronized (f8585b) {
            if (this.f8589e != zVar) {
                this.f8589e = zVar;
                this.f8590f.clear();
            }
            this.f8590f.addAll(zVar.f8639b);
        }
    }

    public final Task<Map<b<?>, String>> a(Iterable<? extends com.google.android.gms.common.api.f<?>> iterable) {
        ck ckVar = new ck(iterable);
        Handler handler = this.f8591g;
        handler.sendMessage(handler.obtainMessage(2, ckVar));
        return ckVar.f8523b.f12478a;
    }

    public final void c() {
        Handler handler = this.f8591g;
        handler.sendMessage(handler.obtainMessage(3));
    }

    public final <O extends a.d> Task<Void> a(d<O> dVar, n<a.b, ?> nVar, v<a.b, ?> vVar) {
        com.google.android.gms.tasks.f fVar = new com.google.android.gms.tasks.f();
        ch chVar = new ch(new bn(nVar, vVar), fVar);
        Handler handler = this.f8591g;
        handler.sendMessage(handler.obtainMessage(8, new bm(chVar, this.f8588d.get(), dVar)));
        return fVar.f12478a;
    }

    public final boolean handleMessage(Message message) {
        a aVar;
        Status status;
        long j2 = 300000;
        switch (message.what) {
            case 1:
                if (((Boolean) message.obj).booleanValue()) {
                    j2 = 10000;
                }
                this.k = j2;
                this.f8591g.removeMessages(12);
                for (b<?> obtainMessage : this.p.keySet()) {
                    Handler handler = this.f8591g;
                    handler.sendMessageDelayed(handler.obtainMessage(12, obtainMessage), this.k);
                }
                break;
            case 2:
                ck ckVar = (ck) message.obj;
                Iterator<b<?>> it2 = ckVar.f8522a.keySet().iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        break;
                    } else {
                        b next = it2.next();
                        a aVar2 = this.p.get(next);
                        if (aVar2 == null) {
                            ckVar.a(next, new ConnectionResult(13), (String) null);
                            break;
                        } else if (aVar2.f8593a.g()) {
                            ckVar.a(next, ConnectionResult.f8333a, aVar2.f8593a.j());
                        } else if (aVar2.e() != null) {
                            ckVar.a(next, aVar2.e(), (String) null);
                        } else {
                            s.a(f.this.f8591g);
                            aVar2.f8594b.add(ckVar);
                            aVar2.g();
                        }
                    }
                }
            case 3:
                for (a next2 : this.p.values()) {
                    next2.d();
                    next2.g();
                }
                break;
            case 4:
            case 8:
            case 13:
                bm bmVar = (bm) message.obj;
                a aVar3 = this.p.get(bmVar.f8468c.getApiKey());
                if (aVar3 == null) {
                    b(bmVar.f8468c);
                    aVar3 = this.p.get(bmVar.f8468c.getApiKey());
                }
                if (aVar3.h() && this.f8588d.get() != bmVar.f8467b) {
                    bmVar.f8466a.a(f8584a);
                    aVar3.c();
                    break;
                } else {
                    aVar3.a(bmVar.f8466a);
                    break;
                }
            case 5:
                int i2 = message.arg1;
                ConnectionResult connectionResult = (ConnectionResult) message.obj;
                Iterator<a<?>> it3 = this.p.values().iterator();
                while (true) {
                    if (it3.hasNext()) {
                        aVar = it3.next();
                        if (aVar.f8596d == i2) {
                        }
                    } else {
                        aVar = null;
                    }
                }
                if (aVar == null) {
                    StringBuilder sb = new StringBuilder(76);
                    sb.append("Could not find API instance ");
                    sb.append(i2);
                    sb.append(" while trying to fail enqueued calls.");
                    Log.wtf("GoogleApiManager", sb.toString(), new Exception());
                    break;
                } else {
                    String b2 = this.n.b(connectionResult.f8334b);
                    String str = connectionResult.f8336d;
                    StringBuilder sb2 = new StringBuilder(String.valueOf(b2).length() + 69 + String.valueOf(str).length());
                    sb2.append("Error resolution was canceled by the user, original error message: ");
                    sb2.append(b2);
                    sb2.append(": ");
                    sb2.append(str);
                    aVar.a(new Status(17, sb2.toString()));
                    break;
                }
            case 6:
                if (this.m.getApplicationContext() instanceof Application) {
                    c.a((Application) this.m.getApplicationContext());
                    c.a().a((c.a) new bb(this));
                    if (!c.a().b()) {
                        this.k = 300000;
                        break;
                    }
                }
                break;
            case 7:
                b((d<?>) (d) message.obj);
                break;
            case 9:
                if (this.p.containsKey(message.obj)) {
                    a aVar4 = this.p.get(message.obj);
                    s.a(f.this.f8591g);
                    if (aVar4.f8598f) {
                        aVar4.g();
                        break;
                    }
                }
                break;
            case 10:
                for (b<?> remove : this.q) {
                    this.p.remove(remove).c();
                }
                this.q.clear();
                break;
            case 11:
                if (this.p.containsKey(message.obj)) {
                    a aVar5 = this.p.get(message.obj);
                    s.a(f.this.f8591g);
                    if (aVar5.f8598f) {
                        aVar5.f();
                        if (f.this.n.a(f.this.m) == 18) {
                            status = new Status(8, "Connection timed out while waiting for Google Play services update to complete.");
                        } else {
                            status = new Status(8, "API failed to connect while resuming due to an unknown error.");
                        }
                        aVar5.a(status);
                        aVar5.f8593a.f();
                        break;
                    }
                }
                break;
            case 12:
                if (this.p.containsKey(message.obj)) {
                    this.p.get(message.obj).a(true);
                    break;
                }
                break;
            case 14:
                aa aaVar = (aa) message.obj;
                b<?> bVar = aaVar.f8395a;
                if (this.p.containsKey(bVar)) {
                    aaVar.f8396b.a(Boolean.valueOf(this.p.get(bVar).a(false)));
                    break;
                } else {
                    aaVar.f8396b.a(Boolean.FALSE);
                    break;
                }
            case 15:
                c cVar = (c) message.obj;
                if (this.p.containsKey(cVar.f8608a)) {
                    a aVar6 = this.p.get(cVar.f8608a);
                    if (aVar6.f8599g.contains(cVar) && !aVar6.f8598f) {
                        if (aVar6.f8593a.g()) {
                            aVar6.b();
                            break;
                        } else {
                            aVar6.g();
                            break;
                        }
                    }
                }
                break;
            case 16:
                c cVar2 = (c) message.obj;
                if (this.p.containsKey(cVar2.f8608a)) {
                    this.p.get(cVar2.f8608a).a(cVar2);
                    break;
                }
                break;
            default:
                int i3 = message.what;
                StringBuilder sb3 = new StringBuilder(31);
                sb3.append("Unknown message id: ");
                sb3.append(i3);
                return false;
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public final PendingIntent a(b<?> bVar, int i2) {
        a aVar = this.p.get(bVar);
        if (aVar == null) {
            return null;
        }
        com.google.android.gms.signin.d dVar = aVar.f8597e == null ? null : aVar.f8597e.f8476a;
        if (dVar == null) {
            return null;
        }
        return PendingIntent.getActivity(this.m, i2, dVar.d(), 134217728);
    }

    /* access modifiers changed from: package-private */
    public final boolean a(ConnectionResult connectionResult, int i2) {
        return this.n.a(this.m, connectionResult, i2);
    }

    public final void b(ConnectionResult connectionResult, int i2) {
        if (!a(connectionResult, i2)) {
            Handler handler = this.f8591g;
            handler.sendMessage(handler.obtainMessage(5, i2, 0, connectionResult));
        }
    }
}
