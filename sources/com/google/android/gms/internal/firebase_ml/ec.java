package com.google.android.gms.internal.firebase_ml;

import android.app.Application;
import android.content.Context;
import com.google.android.gms.common.api.internal.c;
import com.google.android.gms.common.internal.j;
import com.google.android.gms.common.internal.q;
import com.google.firebase.components.b;
import com.google.firebase.components.e;
import com.google.firebase.components.n;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

public final class ec {
    /* access modifiers changed from: package-private */

    /* renamed from: a  reason: collision with root package name */
    public static final j f9842a = new j("ModelResourceManager", "");

    /* renamed from: c  reason: collision with root package name */
    public static final b<?> f9843c = b.a(ec.class).a(n.b(Context.class)).a(ed.f9852a).a();

    /* renamed from: b  reason: collision with root package name */
    final AtomicLong f9844b = new AtomicLong(300000);

    /* renamed from: d  reason: collision with root package name */
    private final dl f9845d = dl.b();

    /* renamed from: e  reason: collision with root package name */
    private final Set<ea> f9846e = new HashSet();
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public final Set<ea> f9847f = new HashSet();

    /* renamed from: g  reason: collision with root package name */
    private final ConcurrentHashMap<ea, a> f9848g = new ConcurrentHashMap<>();

    private ec(Context context) {
        if (context instanceof Application) {
            c.a((Application) context);
        } else {
            f9842a.c("No valid Application available and auto-manage cannot work");
        }
        c.a().a((c.a) new eb(this));
        if (c.a().b()) {
            this.f9844b.set(2000);
        }
    }

    class a implements Callable<Void> {

        /* renamed from: a  reason: collision with root package name */
        private final ea f9849a;

        /* renamed from: b  reason: collision with root package name */
        private final String f9850b;

        a(ea eaVar, String str) {
            this.f9849a = eaVar;
            this.f9850b = str;
        }

        /* access modifiers changed from: private */
        /* JADX WARNING: Removed duplicated region for block: B:12:0x0029  */
        /* JADX WARNING: Removed duplicated region for block: B:14:0x0044  */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Void call() {
            /*
                r4 = this;
                java.lang.String r0 = r4.f9850b
                int r1 = r0.hashCode()
                r2 = 97847535(0x5d508ef, float:2.0033705E-35)
                r3 = 1
                if (r1 == r2) goto L_0x001c
                r2 = 710591710(0x2a5ac4de, float:1.9430592E-13)
                if (r1 == r2) goto L_0x0012
                goto L_0x0026
            L_0x0012:
                java.lang.String r1 = "OPERATION_LOAD"
                boolean r0 = r0.equals(r1)
                if (r0 == 0) goto L_0x0026
                r0 = 0
                goto L_0x0027
            L_0x001c:
                java.lang.String r1 = "OPERATION_RELEASE"
                boolean r0 = r0.equals(r1)
                if (r0 == 0) goto L_0x0026
                r0 = 1
                goto L_0x0027
            L_0x0026:
                r0 = -1
            L_0x0027:
                if (r0 == 0) goto L_0x0044
                if (r0 == r3) goto L_0x002c
                goto L_0x0055
            L_0x002c:
                com.google.android.gms.internal.firebase_ml.ea r0 = r4.f9849a
                com.google.android.gms.common.internal.j r1 = com.google.android.gms.internal.firebase_ml.ec.f9842a
                java.lang.String r2 = "Releasing modelResource"
                r1.b(r2)
                r0.c()
                com.google.android.gms.internal.firebase_ml.ec r1 = com.google.android.gms.internal.firebase_ml.ec.this
                java.util.Set r1 = r1.f9847f
                r1.remove(r0)
                goto L_0x0055
            L_0x0044:
                com.google.android.gms.internal.firebase_ml.ea r0 = r4.f9849a
                com.google.android.gms.internal.firebase_ml.ec r1 = com.google.android.gms.internal.firebase_ml.ec.this     // Catch:{ a -> 0x004c }
                r1.d(r0)     // Catch:{ a -> 0x004c }
                goto L_0x0055
            L_0x004c:
                com.google.android.gms.common.internal.j r0 = com.google.android.gms.internal.firebase_ml.ec.f9842a
                java.lang.String r1 = "Error preloading model resource"
                r0.d(r1)
            L_0x0055:
                r0 = 0
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.firebase_ml.ec.a.call():java.lang.Void");
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            if (!q.a(this.f9849a, aVar.f9849a) || !q.a(this.f9850b, aVar.f9850b)) {
                return false;
            }
            return true;
        }

        public final int hashCode() {
            return Arrays.hashCode(new Object[]{this.f9849a, this.f9850b});
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x003c, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0024, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void a(com.google.android.gms.internal.firebase_ml.ea r4) {
        /*
            r3 = this;
            monitor-enter(r3)
            java.lang.String r0 = "Model source can not be null"
            com.google.android.gms.common.internal.s.a(r4, (java.lang.Object) r0)     // Catch:{ all -> 0x003d }
            com.google.android.gms.common.internal.j r0 = f9842a     // Catch:{ all -> 0x003d }
            java.lang.String r1 = "Add auto-managed model resource"
            r0.a((java.lang.String) r1)     // Catch:{ all -> 0x003d }
            java.util.Set<com.google.android.gms.internal.firebase_ml.ea> r0 = r3.f9846e     // Catch:{ all -> 0x003d }
            boolean r0 = r0.contains(r4)     // Catch:{ all -> 0x003d }
            if (r0 == 0) goto L_0x0025
            com.google.android.gms.common.internal.j r4 = f9842a     // Catch:{ all -> 0x003d }
            java.lang.String r0 = "The model resource is already registered."
            r1 = 4
            boolean r1 = r4.a((int) r1)     // Catch:{ all -> 0x003d }
            if (r1 == 0) goto L_0x0023
            r4.e(r0)     // Catch:{ all -> 0x003d }
        L_0x0023:
            monitor-exit(r3)
            return
        L_0x0025:
            java.util.Set<com.google.android.gms.internal.firebase_ml.ea> r0 = r3.f9846e     // Catch:{ all -> 0x003d }
            r0.add(r4)     // Catch:{ all -> 0x003d }
            if (r4 == 0) goto L_0x003b
            com.google.android.gms.internal.firebase_ml.dl r0 = r3.f9845d     // Catch:{ all -> 0x003d }
            com.google.android.gms.internal.firebase_ml.ec$a r1 = new com.google.android.gms.internal.firebase_ml.ec$a     // Catch:{ all -> 0x003d }
            java.lang.String r2 = "OPERATION_LOAD"
            r1.<init>(r4, r2)     // Catch:{ all -> 0x003d }
            r0.a(r1)     // Catch:{ all -> 0x003d }
            r3.b(r4)     // Catch:{ all -> 0x003d }
        L_0x003b:
            monitor-exit(r3)
            return
        L_0x003d:
            r4 = move-exception
            monitor-exit(r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.firebase_ml.ec.a(com.google.android.gms.internal.firebase_ml.ea):void");
    }

    /* access modifiers changed from: package-private */
    public final synchronized void b(ea eaVar) {
        if (this.f9846e.contains(eaVar)) {
            e(eaVar);
        }
    }

    /* access modifiers changed from: package-private */
    public final synchronized void a() {
        for (ea e2 : this.f9846e) {
            e(e2);
        }
    }

    private final void e(ea eaVar) {
        a f2 = f(eaVar);
        this.f9845d.b(f2);
        long j = this.f9844b.get();
        j jVar = f9842a;
        StringBuilder sb = new StringBuilder(62);
        sb.append("Rescheduling modelResource release after: ");
        sb.append(j);
        jVar.b(sb.toString());
        this.f9845d.a(f2, j);
    }

    public final synchronized void c(ea eaVar) {
        if (eaVar != null) {
            a f2 = f(eaVar);
            this.f9845d.b(f2);
            this.f9845d.a(f2, 0);
        }
    }

    private final a f(ea eaVar) {
        this.f9848g.putIfAbsent(eaVar, new a(eaVar, "OPERATION_RELEASE"));
        return this.f9848g.get(eaVar);
    }

    /* access modifiers changed from: package-private */
    public final void d(ea eaVar) throws com.google.firebase.ml.common.a {
        if (!this.f9847f.contains(eaVar)) {
            try {
                eaVar.b();
                this.f9847f.add(eaVar);
            } catch (RuntimeException e2) {
                throw new com.google.firebase.ml.common.a("The load task failed", 13, e2);
            }
        }
    }

    static final /* synthetic */ ec a(e eVar) {
        return new ec((Context) eVar.a(Context.class));
    }
}
