package com.google.android.gms.common.api;

import android.accounts.Account;
import android.content.Context;
import android.os.Looper;
import android.view.View;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.internal.as;
import com.google.android.gms.common.api.internal.bx;
import com.google.android.gms.common.api.internal.cj;
import com.google.android.gms.common.api.internal.cq;
import com.google.android.gms.common.api.internal.d;
import com.google.android.gms.common.api.internal.i;
import com.google.android.gms.common.api.internal.m;
import com.google.android.gms.common.api.internal.q;
import com.google.android.gms.common.internal.d;
import com.google.android.gms.common.internal.s;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

@Deprecated
public abstract class e {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public static final Set<e> f8373a = Collections.newSetFromMap(new WeakHashMap());

    @Deprecated
    public interface b extends com.google.android.gms.common.api.internal.e {
    }

    @Deprecated
    public interface c extends m {
    }

    public abstract ConnectionResult a(TimeUnit timeUnit);

    public abstract void a(b bVar);

    public abstract void a(c cVar);

    public abstract void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr);

    public abstract void b(b bVar);

    public abstract void b(c cVar);

    public abstract void d();

    public abstract void e();

    public abstract boolean f();

    public abstract boolean g();

    public static Set<e> a() {
        Set<e> set;
        synchronized (f8373a) {
            set = f8373a;
        }
        return set;
    }

    public <A extends a.b, R extends l, T extends d.a<R, A>> T a(T t) {
        throw new UnsupportedOperationException();
    }

    public <A extends a.b, T extends d.a<? extends l, A>> T b(T t) {
        throw new UnsupportedOperationException();
    }

    public <C extends a.f> C a(a.c<C> cVar) {
        throw new UnsupportedOperationException();
    }

    public Looper b() {
        throw new UnsupportedOperationException();
    }

    public boolean a(q qVar) {
        throw new UnsupportedOperationException();
    }

    public void c() {
        throw new UnsupportedOperationException();
    }

    public void a(int i2) {
        throw new UnsupportedOperationException();
    }

    public void a(bx bxVar) {
        throw new UnsupportedOperationException();
    }

    public void b(bx bxVar) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private Account f8374a;

        /* renamed from: b  reason: collision with root package name */
        private final Set<Scope> f8375b = new HashSet();

        /* renamed from: c  reason: collision with root package name */
        private final Set<Scope> f8376c = new HashSet();

        /* renamed from: d  reason: collision with root package name */
        private int f8377d;

        /* renamed from: e  reason: collision with root package name */
        private View f8378e;

        /* renamed from: f  reason: collision with root package name */
        private String f8379f;

        /* renamed from: g  reason: collision with root package name */
        private String f8380g;

        /* renamed from: h  reason: collision with root package name */
        private final Map<a<?>, d.b> f8381h = new androidx.a.a();

        /* renamed from: i  reason: collision with root package name */
        private boolean f8382i = false;
        private final Context j;
        private final Map<a<?>, a.d> k = new androidx.a.a();
        private i l;
        private int m = -1;
        private c n;
        private Looper o;
        private com.google.android.gms.common.c p = com.google.android.gms.common.c.a();
        private a.C0125a<? extends com.google.android.gms.signin.d, com.google.android.gms.signin.a> q = com.google.android.gms.signin.c.f12438a;
        private final ArrayList<b> r = new ArrayList<>();
        private final ArrayList<c> s = new ArrayList<>();
        private boolean t = false;

        public a(Context context) {
            this.j = context;
            this.o = context.getMainLooper();
            this.f8379f = context.getPackageName();
            this.f8380g = context.getClass().getName();
        }

        public final a a(b bVar) {
            s.a(bVar, (Object) "Listener must not be null");
            this.r.add(bVar);
            return this;
        }

        public final a a(c cVar) {
            s.a(cVar, (Object) "Listener must not be null");
            this.s.add(cVar);
            return this;
        }

        public final a a(a<? extends a.d.C0127d> aVar) {
            s.a(aVar, (Object) "Api must not be null");
            this.k.put(aVar, (Object) null);
            List<Scope> impliedScopes = aVar.f8363a.getImpliedScopes(null);
            this.f8376c.addAll(impliedScopes);
            this.f8375b.addAll(impliedScopes);
            return this;
        }

        public final e a() {
            s.b(!this.k.isEmpty(), "must call addApi() to add at least one API");
            com.google.android.gms.signin.a aVar = com.google.android.gms.signin.a.f12429a;
            if (this.k.containsKey(com.google.android.gms.signin.c.f12439b)) {
                aVar = (com.google.android.gms.signin.a) this.k.get(com.google.android.gms.signin.c.f12439b);
            }
            com.google.android.gms.common.internal.d dVar = new com.google.android.gms.common.internal.d(this.f8374a, this.f8375b, this.f8381h, this.f8377d, this.f8378e, this.f8379f, this.f8380g, aVar, false);
            Map<a<?>, d.b> map = dVar.f8819d;
            androidx.a.a aVar2 = new androidx.a.a();
            androidx.a.a aVar3 = new androidx.a.a();
            ArrayList arrayList = new ArrayList();
            a aVar4 = null;
            boolean z = false;
            for (a next : this.k.keySet()) {
                a.d dVar2 = this.k.get(next);
                boolean z2 = map.get(next) != null;
                aVar2.put(next, Boolean.valueOf(z2));
                cq cqVar = new cq(next, z2);
                arrayList.add(cqVar);
                a.C0125a a2 = next.a();
                cq cqVar2 = cqVar;
                a aVar5 = next;
                a aVar6 = aVar4;
                a.f buildClient = a2.buildClient(this.j, this.o, dVar, dVar2, (b) cqVar2, (c) cqVar2);
                aVar3.put(aVar5.b(), buildClient);
                if (a2.getPriority() == 1) {
                    z = dVar2 != null;
                }
                if (!buildClient.c()) {
                    aVar4 = aVar6;
                } else if (aVar6 == null) {
                    aVar4 = aVar5;
                } else {
                    String str = aVar5.f8364b;
                    String str2 = aVar6.f8364b;
                    StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 21 + String.valueOf(str2).length());
                    sb.append(str);
                    sb.append(" cannot be used with ");
                    sb.append(str2);
                    throw new IllegalStateException(sb.toString());
                }
            }
            a aVar7 = aVar4;
            if (aVar7 != null) {
                if (!z) {
                    s.a(this.f8374a == null, "Must not set an account in GoogleApiClient.Builder when using %s. Set account in GoogleSignInOptions.Builder instead", aVar7.f8364b);
                    s.a(this.f8375b.equals(this.f8376c), "Must not set scopes in GoogleApiClient.Builder when using %s. Set account in GoogleSignInOptions.Builder instead.", aVar7.f8364b);
                } else {
                    String str3 = aVar7.f8364b;
                    StringBuilder sb2 = new StringBuilder(String.valueOf(str3).length() + 82);
                    sb2.append("With using ");
                    sb2.append(str3);
                    sb2.append(", GamesOptions can only be specified within GoogleSignInOptions.Builder");
                    throw new IllegalStateException(sb2.toString());
                }
            }
            as asVar = new as(this.j, new ReentrantLock(), this.o, dVar, this.p, this.q, aVar2, this.r, this.s, aVar3, this.m, as.a((Iterable<a.f>) aVar3.values(), true), arrayList);
            synchronized (e.f8373a) {
                e.f8373a.add(asVar);
            }
            if (this.m >= 0) {
                cj.b(this.l).a(this.m, asVar, this.n);
            }
            return asVar;
        }
    }
}
