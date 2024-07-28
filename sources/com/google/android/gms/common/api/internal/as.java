package com.google.android.gms.common.api.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.util.Log;
import com.alipay.mobile.nebula.util.H5Utils;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.e;
import com.google.android.gms.common.api.internal.d;
import com.google.android.gms.common.api.l;
import com.google.android.gms.common.c;
import com.google.android.gms.common.internal.h;
import com.google.android.gms.common.internal.s;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;

public final class as extends e implements bl {

    /* renamed from: a  reason: collision with root package name */
    final Queue<d.a<?, ?>> f8429a = new LinkedList();

    /* renamed from: b  reason: collision with root package name */
    final Map<a.c<?>, a.f> f8430b;

    /* renamed from: c  reason: collision with root package name */
    Set<Scope> f8431c = new HashSet();

    /* renamed from: d  reason: collision with root package name */
    Set<bx> f8432d = null;

    /* renamed from: e  reason: collision with root package name */
    final cc f8433e;

    /* renamed from: f  reason: collision with root package name */
    private final Lock f8434f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f8435g;

    /* renamed from: h  reason: collision with root package name */
    private final h f8436h;

    /* renamed from: i  reason: collision with root package name */
    private bk f8437i = null;
    private final int j;
    private final Context k;
    private final Looper l;
    private volatile boolean m;
    private long n = 120000;
    private long o = 5000;
    private final at p;
    private final c q;
    private zabq r;
    private final com.google.android.gms.common.internal.d s;
    private final Map<a<?>, Boolean> t;
    private final a.C0125a<? extends com.google.android.gms.signin.d, com.google.android.gms.signin.a> u;
    private final l v = new l();
    private final ArrayList<cq> w;
    private Integer x = null;
    private final h.a y = new ar(this);

    public as(Context context, Lock lock, Looper looper, com.google.android.gms.common.internal.d dVar, c cVar, a.C0125a<? extends com.google.android.gms.signin.d, com.google.android.gms.signin.a> aVar, Map<a<?>, Boolean> map, List<e.b> list, List<e.c> list2, Map<a.c<?>, a.f> map2, int i2, int i3, ArrayList<cq> arrayList) {
        this.k = context;
        this.f8434f = lock;
        this.f8435g = false;
        this.f8436h = new h(looper, this.y);
        this.l = looper;
        this.p = new at(this, looper);
        this.q = cVar;
        this.j = i2;
        if (this.j >= 0) {
            this.x = Integer.valueOf(i3);
        }
        this.t = map;
        this.f8430b = map2;
        this.w = arrayList;
        this.f8433e = new cc(this.f8430b);
        for (e.b a2 : list) {
            this.f8436h.a(a2);
        }
        for (e.c a3 : list2) {
            this.f8436h.a(a3);
        }
        this.s = dVar;
        this.u = aVar;
    }

    private static String c(int i2) {
        return i2 != 1 ? i2 != 2 ? i2 != 3 ? H5Utils.NETWORK_TYPE_UNKNOWN : "SIGN_IN_MODE_NONE" : "SIGN_IN_MODE_OPTIONAL" : "SIGN_IN_MODE_REQUIRED";
    }

    public final <C extends a.f> C a(a.c<C> cVar) {
        C c2 = (a.f) this.f8430b.get(cVar);
        s.a(c2, (Object) "Appropriate Api was not requested.");
        return c2;
    }

    public final void d() {
        this.f8434f.lock();
        try {
            boolean z = false;
            if (this.j >= 0) {
                if (this.x != null) {
                    z = true;
                }
                s.a(z, (Object) "Sign-in mode should have been set explicitly by auto-manage.");
            } else if (this.x == null) {
                this.x = Integer.valueOf(a((Iterable<a.f>) this.f8430b.values(), false));
            } else if (this.x.intValue() == 2) {
                throw new IllegalStateException("Cannot call connect() when SignInMode is set to SIGN_IN_MODE_OPTIONAL. Call connect(SIGN_IN_MODE_OPTIONAL) instead.");
            }
            a(this.x.intValue());
        } finally {
            this.f8434f.unlock();
        }
    }

    public final void a(int i2) {
        this.f8434f.lock();
        boolean z = true;
        if (!(i2 == 3 || i2 == 1 || i2 == 2)) {
            z = false;
        }
        try {
            StringBuilder sb = new StringBuilder(33);
            sb.append("Illegal sign-in mode: ");
            sb.append(i2);
            s.b(z, sb.toString());
            b(i2);
            l();
        } finally {
            this.f8434f.unlock();
        }
    }

    public final ConnectionResult a(TimeUnit timeUnit) {
        s.a(Looper.myLooper() != Looper.getMainLooper(), (Object) "blockingConnect must not be called on the UI thread");
        s.a(timeUnit, (Object) "TimeUnit must not be null");
        this.f8434f.lock();
        try {
            if (this.x == null) {
                this.x = Integer.valueOf(a((Iterable<a.f>) this.f8430b.values(), false));
            } else if (this.x.intValue() == 2) {
                throw new IllegalStateException("Cannot call blockingConnect() when sign-in mode is set to SIGN_IN_MODE_OPTIONAL. Call connect(SIGN_IN_MODE_OPTIONAL) instead.");
            }
            b(this.x.intValue());
            this.f8436h.f8842e = true;
            return this.f8437i.a(timeUnit);
        } finally {
            this.f8434f.unlock();
        }
    }

    public final void e() {
        this.f8434f.lock();
        try {
            this.f8433e.a();
            if (this.f8437i != null) {
                this.f8437i.b();
            }
            l lVar = this.v;
            for (k<?> kVar : lVar.f8623a) {
                kVar.f8617a = null;
            }
            lVar.f8623a.clear();
            for (d.a aVar : this.f8429a) {
                aVar.a((cd) null);
                aVar.a();
            }
            this.f8429a.clear();
            if (this.f8437i != null) {
                i();
                this.f8436h.a();
                this.f8434f.unlock();
            }
        } finally {
            this.f8434f.unlock();
        }
    }

    public final boolean f() {
        bk bkVar = this.f8437i;
        return bkVar != null && bkVar.d();
    }

    public final boolean g() {
        bk bkVar = this.f8437i;
        return bkVar != null && bkVar.e();
    }

    private final void b(int i2) {
        Integer num = this.x;
        if (num == null) {
            this.x = Integer.valueOf(i2);
        } else if (num.intValue() != i2) {
            String c2 = c(i2);
            String c3 = c(this.x.intValue());
            StringBuilder sb = new StringBuilder(String.valueOf(c2).length() + 51 + String.valueOf(c3).length());
            sb.append("Cannot use sign-in mode: ");
            sb.append(c2);
            sb.append(". Mode was already set to ");
            sb.append(c3);
            throw new IllegalStateException(sb.toString());
        }
        if (this.f8437i == null) {
            boolean z = false;
            boolean z2 = false;
            for (a.f next : this.f8430b.values()) {
                if (next.i()) {
                    z = true;
                }
                if (next.c()) {
                    z2 = true;
                }
            }
            int intValue = this.x.intValue();
            if (intValue != 1) {
                if (intValue == 2) {
                    if (z) {
                        if (this.f8435g) {
                            this.f8437i = new cw(this.k, this.f8434f, this.l, this.q, this.f8430b, this.s, this.t, this.u, this.w, this, true);
                            return;
                        }
                        this.f8437i = cr.a(this.k, this, this.f8434f, this.l, this.q, this.f8430b, this.s, this.t, this.u, this.w);
                        return;
                    }
                }
            } else if (!z) {
                throw new IllegalStateException("SIGN_IN_MODE_REQUIRED cannot be used on a GoogleApiClient that does not contain any authenticated APIs. Use connect() instead.");
            } else if (z2) {
                throw new IllegalStateException("Cannot use SIGN_IN_MODE_REQUIRED with GOOGLE_SIGN_IN_API. Use connect(SIGN_IN_MODE_OPTIONAL) instead.");
            }
            if (!this.f8435g || z2) {
                this.f8437i = new ay(this.k, this, this.f8434f, this.l, this.q, this.f8430b, this.s, this.t, this.u, this.w, this);
                return;
            }
            this.f8437i = new cw(this.k, this.f8434f, this.l, this.q, this.f8430b, this.s, this.t, this.u, this.w, this, false);
        }
    }

    private final void l() {
        this.f8436h.f8842e = true;
        this.f8437i.a();
    }

    /* access modifiers changed from: package-private */
    public final boolean i() {
        if (!this.m) {
            return false;
        }
        this.m = false;
        this.p.removeMessages(2);
        this.p.removeMessages(1);
        zabq zabq = this.r;
        if (zabq != null) {
            zabq.a();
            this.r = null;
        }
        return true;
    }

    public final void a(e.b bVar) {
        this.f8436h.a(bVar);
    }

    public final void b(e.b bVar) {
        h hVar = this.f8436h;
        s.a(bVar);
        synchronized (hVar.f8846i) {
            if (!hVar.f8839b.remove(bVar)) {
                String valueOf = String.valueOf(bVar);
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 52);
                sb.append("unregisterConnectionCallbacks(): listener ");
                sb.append(valueOf);
                sb.append(" not found");
            } else if (hVar.f8844g) {
                hVar.f8840c.add(bVar);
            }
        }
    }

    public final void a(e.c cVar) {
        this.f8436h.a(cVar);
    }

    public final void b(e.c cVar) {
        h hVar = this.f8436h;
        s.a(cVar);
        synchronized (hVar.f8846i) {
            if (!hVar.f8841d.remove(cVar)) {
                String valueOf = String.valueOf(cVar);
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 57);
                sb.append("unregisterConnectionFailedListener(): listener ");
                sb.append(valueOf);
                sb.append(" not found");
            }
        }
    }

    public final void a(Bundle bundle) {
        while (!this.f8429a.isEmpty()) {
            b(this.f8429a.remove());
        }
        h hVar = this.f8436h;
        s.a(hVar.f8845h, "onConnectionSuccess must only be called on the Handler thread");
        synchronized (hVar.f8846i) {
            boolean z = true;
            s.a(!hVar.f8844g);
            hVar.f8845h.removeMessages(1);
            hVar.f8844g = true;
            if (hVar.f8840c.size() != 0) {
                z = false;
            }
            s.a(z);
            ArrayList arrayList = new ArrayList(hVar.f8839b);
            int i2 = hVar.f8843f.get();
            ArrayList arrayList2 = arrayList;
            int size = arrayList2.size();
            int i3 = 0;
            while (i3 < size) {
                Object obj = arrayList2.get(i3);
                i3++;
                e.b bVar = (e.b) obj;
                if (!hVar.f8842e || !hVar.f8838a.g() || hVar.f8843f.get() != i2) {
                    break;
                } else if (!hVar.f8840c.contains(bVar)) {
                    bVar.onConnected(bundle);
                }
            }
            hVar.f8840c.clear();
            hVar.f8844g = false;
        }
    }

    public final void a(ConnectionResult connectionResult) {
        if (!com.google.android.gms.common.d.b(this.k, connectionResult.f8334b)) {
            i();
        }
        if (!this.m) {
            h hVar = this.f8436h;
            s.a(hVar.f8845h, "onConnectionFailure must only be called on the Handler thread");
            hVar.f8845h.removeMessages(1);
            synchronized (hVar.f8846i) {
                ArrayList arrayList = new ArrayList(hVar.f8841d);
                int i2 = hVar.f8843f.get();
                ArrayList arrayList2 = arrayList;
                int size = arrayList2.size();
                int i3 = 0;
                while (true) {
                    if (i3 >= size) {
                        break;
                    }
                    Object obj = arrayList2.get(i3);
                    i3++;
                    e.c cVar = (e.c) obj;
                    if (!hVar.f8842e) {
                        break;
                    } else if (hVar.f8843f.get() != i2) {
                        break;
                    } else if (hVar.f8841d.contains(cVar)) {
                        cVar.onConnectionFailed(connectionResult);
                    }
                }
            }
            this.f8436h.a();
        }
    }

    public final void a(int i2, boolean z) {
        if (i2 == 1 && !z && !this.m) {
            this.m = true;
            if (this.r == null) {
                try {
                    this.r = c.a(this.k.getApplicationContext(), (bj) new aw(this));
                } catch (SecurityException unused) {
                }
            }
            at atVar = this.p;
            atVar.sendMessageDelayed(atVar.obtainMessage(1), this.n);
            at atVar2 = this.p;
            atVar2.sendMessageDelayed(atVar2.obtainMessage(2), this.o);
        }
        for (BasePendingResult c2 : (BasePendingResult[]) this.f8433e.f8506c.toArray(cc.f8505b)) {
            c2.c(cc.f8504a);
        }
        h hVar = this.f8436h;
        s.a(hVar.f8845h, "onUnintentionalDisconnection must only be called on the Handler thread");
        hVar.f8845h.removeMessages(1);
        synchronized (hVar.f8846i) {
            hVar.f8844g = true;
            ArrayList arrayList = new ArrayList(hVar.f8839b);
            int i3 = hVar.f8843f.get();
            ArrayList arrayList2 = arrayList;
            int size = arrayList2.size();
            int i4 = 0;
            while (i4 < size) {
                Object obj = arrayList2.get(i4);
                i4++;
                e.b bVar = (e.b) obj;
                if (!hVar.f8842e || hVar.f8843f.get() != i3) {
                    break;
                } else if (hVar.f8839b.contains(bVar)) {
                    bVar.onConnectionSuspended(i2);
                }
            }
            hVar.f8840c.clear();
            hVar.f8844g = false;
        }
        this.f8436h.a();
        if (i2 == 2) {
            l();
        }
    }

    public final Looper b() {
        return this.l;
    }

    public final boolean a(q qVar) {
        bk bkVar = this.f8437i;
        return bkVar != null && bkVar.a(qVar);
    }

    public final void c() {
        bk bkVar = this.f8437i;
        if (bkVar != null) {
            bkVar.f();
        }
    }

    public final void a(bx bxVar) {
        this.f8434f.lock();
        try {
            if (this.f8432d == null) {
                this.f8432d = new HashSet();
            }
            this.f8432d.add(bxVar);
        } finally {
            this.f8434f.unlock();
        }
    }

    public final void b(bx bxVar) {
        this.f8434f.lock();
        try {
            if (this.f8432d == null) {
                Log.wtf("GoogleApiClientImpl", "Attempted to remove pending transform when no transforms are registered.", new Exception());
            } else if (!this.f8432d.remove(bxVar)) {
                Log.wtf("GoogleApiClientImpl", "Failed to remove pending transform - this may lead to memory leaks!", new Exception());
            } else if (!j()) {
                this.f8437i.g();
            }
        } finally {
            this.f8434f.unlock();
        }
    }

    /* JADX INFO: finally extract failed */
    /* access modifiers changed from: package-private */
    public final boolean j() {
        this.f8434f.lock();
        try {
            if (this.f8432d == null) {
                this.f8434f.unlock();
                return false;
            }
            boolean z = !this.f8432d.isEmpty();
            this.f8434f.unlock();
            return z;
        } catch (Throwable th) {
            this.f8434f.unlock();
            throw th;
        }
    }

    /* access modifiers changed from: package-private */
    public final String k() {
        StringWriter stringWriter = new StringWriter();
        a("", (FileDescriptor) null, new PrintWriter(stringWriter), (String[]) null);
        return stringWriter.toString();
    }

    public final void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.append(str).append("mContext=").println(this.k);
        printWriter.append(str).append("mResuming=").print(this.m);
        printWriter.append(" mWorkQueue.size()=").print(this.f8429a.size());
        printWriter.append(" mUnconsumedApiCalls.size()=").println(this.f8433e.f8506c.size());
        bk bkVar = this.f8437i;
        if (bkVar != null) {
            bkVar.a(str, fileDescriptor, printWriter, strArr);
        }
    }

    public static int a(Iterable<a.f> iterable, boolean z) {
        boolean z2 = false;
        boolean z3 = false;
        for (a.f next : iterable) {
            if (next.i()) {
                z2 = true;
            }
            if (next.c()) {
                z3 = true;
            }
        }
        if (!z2) {
            return 3;
        }
        if (!z3 || !z) {
            return 1;
        }
        return 2;
    }

    public final <A extends a.b, R extends l, T extends d.a<R, A>> T a(T t2) {
        String str;
        s.b(t2.f8568a != null, "This task can not be enqueued (it's probably a Batch or malformed)");
        boolean containsKey = this.f8430b.containsKey(t2.f8568a);
        if (t2.f8569b != null) {
            str = t2.f8569b.f8364b;
        } else {
            str = "the API";
        }
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 65);
        sb.append("GoogleApiClient is not configured to use ");
        sb.append(str);
        sb.append(" required for this call.");
        s.b(containsKey, sb.toString());
        this.f8434f.lock();
        try {
            if (this.f8437i == null) {
                this.f8429a.add(t2);
                return t2;
            }
            T a2 = this.f8437i.a(t2);
            this.f8434f.unlock();
            return a2;
        } finally {
            this.f8434f.unlock();
        }
    }

    public final <A extends a.b, T extends d.a<? extends l, A>> T b(T t2) {
        String str;
        s.b(t2.f8568a != null, "This task can not be executed (it's probably a Batch or malformed)");
        boolean containsKey = this.f8430b.containsKey(t2.f8568a);
        if (t2.f8569b != null) {
            str = t2.f8569b.f8364b;
        } else {
            str = "the API";
        }
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 65);
        sb.append("GoogleApiClient is not configured to use ");
        sb.append(str);
        sb.append(" required for this call.");
        s.b(containsKey, sb.toString());
        this.f8434f.lock();
        try {
            if (this.f8437i == null) {
                throw new IllegalStateException("GoogleApiClient is not connected yet.");
            } else if (this.m) {
                this.f8429a.add(t2);
                while (!this.f8429a.isEmpty()) {
                    d.a remove = this.f8429a.remove();
                    this.f8433e.a(remove);
                    remove.b(Status.f8356c);
                }
                return t2;
            } else {
                T b2 = this.f8437i.b(t2);
                this.f8434f.unlock();
                return b2;
            }
        } finally {
            this.f8434f.unlock();
        }
    }

    static /* synthetic */ void a(as asVar) {
        asVar.f8434f.lock();
        try {
            if (asVar.m) {
                asVar.l();
            }
        } finally {
            asVar.f8434f.unlock();
        }
    }

    static /* synthetic */ void b(as asVar) {
        asVar.f8434f.lock();
        try {
            if (asVar.i()) {
                asVar.l();
            }
        } finally {
            asVar.f8434f.unlock();
        }
    }
}
