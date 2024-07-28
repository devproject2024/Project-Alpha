package com.google.firebase.installations;

import android.text.TextUtils;
import com.google.android.gms.common.internal.s;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.f;
import com.google.firebase.e.h;
import com.google.firebase.installations.a.b;
import com.google.firebase.installations.a.c;
import com.google.firebase.installations.a.d;
import com.google.firebase.installations.b.d;
import com.google.firebase.installations.b.e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public final class c implements g {
    private static final Object l = new Object();
    private static final ThreadFactory m = new ThreadFactory() {

        /* renamed from: a  reason: collision with root package name */
        private final AtomicInteger f38971a = new AtomicInteger(1);

        public final Thread newThread(Runnable runnable) {
            return new Thread(runnable, String.format("firebase-installations-executor-%d", new Object[]{Integer.valueOf(this.f38971a.getAndIncrement())}));
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private final com.google.firebase.c f38962a;

    /* renamed from: b  reason: collision with root package name */
    private final com.google.firebase.installations.b.c f38963b;

    /* renamed from: c  reason: collision with root package name */
    private final com.google.firebase.installations.a.c f38964c;

    /* renamed from: d  reason: collision with root package name */
    private final o f38965d;

    /* renamed from: e  reason: collision with root package name */
    private final b f38966e;

    /* renamed from: f  reason: collision with root package name */
    private final m f38967f;

    /* renamed from: g  reason: collision with root package name */
    private final Object f38968g;

    /* renamed from: h  reason: collision with root package name */
    private final ExecutorService f38969h;

    /* renamed from: i  reason: collision with root package name */
    private final ExecutorService f38970i;
    private String j;
    private final List<n> k;

    c(com.google.firebase.c cVar, h hVar, com.google.firebase.b.c cVar2) {
        this(new ThreadPoolExecutor(0, 1, 30, TimeUnit.SECONDS, new LinkedBlockingQueue(), m), cVar, new com.google.firebase.installations.b.c(cVar.a(), hVar, cVar2), new com.google.firebase.installations.a.c(cVar), new o(), new b(cVar), new m());
    }

    private c(ExecutorService executorService, com.google.firebase.c cVar, com.google.firebase.installations.b.c cVar2, com.google.firebase.installations.a.c cVar3, o oVar, b bVar, m mVar) {
        this.f38968g = new Object();
        this.k = new ArrayList();
        this.f38962a = cVar;
        this.f38963b = cVar2;
        this.f38964c = cVar3;
        this.f38965d = oVar;
        this.f38966e = bVar;
        this.f38967f = mVar;
        this.f38969h = executorService;
        this.f38970i = new ThreadPoolExecutor(0, 1, 30, TimeUnit.SECONDS, new LinkedBlockingQueue(), m);
    }

    private void c() {
        s.a(e(), (Object) "Please set your Application ID. A valid Firebase App ID is required to communicate with Firebase server APIs: It identifies your application with Firebase.Please refer to https://firebase.google.com/support/privacy/init-options.");
        s.a(d(), (Object) "Please set your Project ID. A valid Firebase Project ID is required to communicate with Firebase server APIs: It identifies your application with Firebase.Please refer to https://firebase.google.com/support/privacy/init-options.");
        s.a(f(), (Object) "Please set a valid API key. A Firebase API key is required to communicate with Firebase server APIs: It authenticates your project with Google.Please refer to https://firebase.google.com/support/privacy/init-options.");
        s.b(o.a(e()), "Please set your Application ID. A valid Firebase App ID is required to communicate with Firebase server APIs: It identifies your application with Firebase.Please refer to https://firebase.google.com/support/privacy/init-options.");
        s.b(o.b(f()), "Please set a valid API key. A Firebase API key is required to communicate with Firebase server APIs: It authenticates your project with Google.Please refer to https://firebase.google.com/support/privacy/init-options.");
    }

    private String d() {
        return this.f38962a.c().f38757d;
    }

    private String e() {
        return this.f38962a.c().f38755b;
    }

    private String f() {
        return this.f38962a.c().f38754a;
    }

    public final Task<String> a() {
        c();
        String g2 = g();
        if (g2 != null) {
            return com.google.android.gms.tasks.h.a(g2);
        }
        f fVar = new f();
        a((n) new k(fVar));
        Task<String> a2 = fVar.a();
        this.f38969h.execute(d.a(this));
        return a2;
    }

    public final Task<l> b() {
        c();
        f fVar = new f();
        a((n) new j(this.f38965d, fVar));
        Task<l> a2 = fVar.a();
        this.f38969h.execute(e.a(this));
        return a2;
    }

    private void a(n nVar) {
        synchronized (this.f38968g) {
            this.k.add(nVar);
        }
    }

    private void a(d dVar) {
        synchronized (this.f38968g) {
            Iterator<n> it2 = this.k.iterator();
            while (it2.hasNext()) {
                if (it2.next().a(dVar)) {
                    it2.remove();
                }
            }
        }
    }

    private void a(d dVar, Exception exc) {
        synchronized (this.f38968g) {
            Iterator<n> it2 = this.k.iterator();
            while (it2.hasNext()) {
                if (it2.next().a(dVar, exc)) {
                    it2.remove();
                }
            }
        }
    }

    private synchronized void a(String str) {
        this.j = str;
    }

    private synchronized String g() {
        return this.j;
    }

    /* access modifiers changed from: private */
    public final void a(boolean z) {
        d h2 = h();
        if (z) {
            h2 = h2.h().b((String) null).a();
        }
        a(h2);
        this.f38970i.execute(f.a(this, z));
    }

    private d h() {
        d a2;
        String str;
        synchronized (l) {
            b a3 = b.a(this.f38962a.a(), "generatefid.lock");
            try {
                a2 = this.f38964c.a();
                if (a2.l()) {
                    if (this.f38962a.b().equals("CHIME_ANDROID_SDK") || this.f38962a.g()) {
                        if (a2.b() == c.a.ATTEMPT_MIGRATION) {
                            str = this.f38966e.b();
                            if (TextUtils.isEmpty(str)) {
                                str = m.a();
                            }
                            a2 = this.f38964c.a(a2.h().a(str).a(c.a.UNREGISTERED).a());
                        }
                    }
                    str = m.a();
                    a2 = this.f38964c.a(a2.h().a(str).a(c.a.UNREGISTERED).a());
                }
                if (a3 != null) {
                    a3.a();
                }
            } catch (Throwable th) {
                if (a3 != null) {
                    a3.a();
                }
                throw th;
            }
        }
        return a2;
    }

    /* renamed from: com.google.firebase.installations.c$2  reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f38972a = new int[d.b.values().length];

        /* renamed from: b  reason: collision with root package name */
        static final /* synthetic */ int[] f38973b = new int[e.b.values().length];

        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x003d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x001f */
        static {
            /*
                com.google.firebase.installations.b.e$b[] r0 = com.google.firebase.installations.b.e.b.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f38973b = r0
                r0 = 1
                int[] r1 = f38973b     // Catch:{ NoSuchFieldError -> 0x0014 }
                com.google.firebase.installations.b.e$b r2 = com.google.firebase.installations.b.e.b.OK     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r1[r2] = r0     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                r1 = 2
                int[] r2 = f38973b     // Catch:{ NoSuchFieldError -> 0x001f }
                com.google.firebase.installations.b.e$b r3 = com.google.firebase.installations.b.e.b.BAD_CONFIG     // Catch:{ NoSuchFieldError -> 0x001f }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                r2[r3] = r1     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                int[] r2 = f38973b     // Catch:{ NoSuchFieldError -> 0x002a }
                com.google.firebase.installations.b.e$b r3 = com.google.firebase.installations.b.e.b.AUTH_ERROR     // Catch:{ NoSuchFieldError -> 0x002a }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x002a }
                r4 = 3
                r2[r3] = r4     // Catch:{ NoSuchFieldError -> 0x002a }
            L_0x002a:
                com.google.firebase.installations.b.d$b[] r2 = com.google.firebase.installations.b.d.b.values()
                int r2 = r2.length
                int[] r2 = new int[r2]
                f38972a = r2
                int[] r2 = f38972a     // Catch:{ NoSuchFieldError -> 0x003d }
                com.google.firebase.installations.b.d$b r3 = com.google.firebase.installations.b.d.b.OK     // Catch:{ NoSuchFieldError -> 0x003d }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x003d }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x003d }
            L_0x003d:
                int[] r0 = f38972a     // Catch:{ NoSuchFieldError -> 0x0047 }
                com.google.firebase.installations.b.d$b r2 = com.google.firebase.installations.b.d.b.BAD_CONFIG     // Catch:{ NoSuchFieldError -> 0x0047 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0047 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0047 }
            L_0x0047:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.installations.c.AnonymousClass2.<clinit>():void");
        }
    }

    private com.google.firebase.installations.a.d i() {
        com.google.firebase.installations.a.d a2;
        synchronized (l) {
            b a3 = b.a(this.f38962a.a(), "generatefid.lock");
            try {
                a2 = this.f38964c.a();
                if (a3 != null) {
                    a3.a();
                }
            } catch (Throwable th) {
                if (a3 != null) {
                    a3.a();
                }
                throw th;
            }
        }
        return a2;
    }

    /*  JADX ERROR: IndexOutOfBoundsException in pass: RegionMakerVisitor
        java.lang.IndexOutOfBoundsException: Index: 0, Size: 0
        	at java.util.ArrayList.rangeCheck(ArrayList.java:659)
        	at java.util.ArrayList.get(ArrayList.java:435)
        	at jadx.core.dex.nodes.InsnNode.getArg(InsnNode.java:101)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:611)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:561)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:49)
        */
    static /* synthetic */ void a(com.google.firebase.installations.c r10, boolean r11) {
        /*
            com.google.firebase.installations.a.d r0 = r10.i()
            boolean r1 = r0.j()     // Catch:{ h -> 0x0174 }
            r2 = 2
            r3 = 1
            r4 = 0
            if (r1 != 0) goto L_0x008f
            boolean r1 = r0.k()     // Catch:{ h -> 0x0174 }
            if (r1 == 0) goto L_0x0015
            goto L_0x008f
        L_0x0015:
            if (r11 != 0) goto L_0x001f
            boolean r11 = com.google.firebase.installations.o.a((com.google.firebase.installations.a.d) r0)     // Catch:{ h -> 0x0174 }
            if (r11 == 0) goto L_0x001e
            goto L_0x001f
        L_0x001e:
            return
        L_0x001f:
            com.google.firebase.installations.b.c r11 = r10.f38963b     // Catch:{ h -> 0x0174 }
            java.lang.String r1 = r10.f()     // Catch:{ h -> 0x0174 }
            java.lang.String r5 = r0.a()     // Catch:{ h -> 0x0174 }
            java.lang.String r6 = r10.d()     // Catch:{ h -> 0x0174 }
            java.lang.String r7 = r0.d()     // Catch:{ h -> 0x0174 }
            com.google.firebase.installations.b.e r11 = r11.a((java.lang.String) r1, (java.lang.String) r5, (java.lang.String) r6, (java.lang.String) r7)     // Catch:{ h -> 0x0174 }
            int[] r1 = com.google.firebase.installations.c.AnonymousClass2.f38973b     // Catch:{ h -> 0x0174 }
            com.google.firebase.installations.b.e$b r5 = r11.c()     // Catch:{ h -> 0x0174 }
            int r5 = r5.ordinal()     // Catch:{ h -> 0x0174 }
            r1 = r1[r5]     // Catch:{ h -> 0x0174 }
            if (r1 == r3) goto L_0x006d
            if (r1 == r2) goto L_0x0065
            r11 = 3
            if (r1 != r11) goto L_0x005b
            r10.a((java.lang.String) r4)     // Catch:{ h -> 0x0174 }
            com.google.firebase.installations.a.d$a r11 = r0.h()     // Catch:{ h -> 0x0174 }
            com.google.firebase.installations.a.c$a r1 = com.google.firebase.installations.a.c.a.NOT_GENERATED     // Catch:{ h -> 0x0174 }
            com.google.firebase.installations.a.d$a r11 = r11.a((com.google.firebase.installations.a.c.a) r1)     // Catch:{ h -> 0x0174 }
            com.google.firebase.installations.a.d r11 = r11.a()     // Catch:{ h -> 0x0174 }
            goto L_0x011d
        L_0x005b:
            com.google.firebase.installations.h r11 = new com.google.firebase.installations.h     // Catch:{ h -> 0x0174 }
            java.lang.String r1 = "Firebase Installations Service is unavailable. Please try again later."
            com.google.firebase.installations.h$a r2 = com.google.firebase.installations.h.a.UNAVAILABLE     // Catch:{ h -> 0x0174 }
            r11.<init>(r1, r2)     // Catch:{ h -> 0x0174 }
            throw r11     // Catch:{ h -> 0x0174 }
        L_0x0065:
            java.lang.String r11 = "BAD CONFIG"
            com.google.firebase.installations.a.d r11 = r0.a(r11)     // Catch:{ h -> 0x0174 }
            goto L_0x011d
        L_0x006d:
            java.lang.String r1 = r11.a()     // Catch:{ h -> 0x0174 }
            long r2 = r11.b()     // Catch:{ h -> 0x0174 }
            long r4 = com.google.firebase.installations.o.a()     // Catch:{ h -> 0x0174 }
            com.google.firebase.installations.a.d$a r11 = r0.h()     // Catch:{ h -> 0x0174 }
            com.google.firebase.installations.a.d$a r11 = r11.b((java.lang.String) r1)     // Catch:{ h -> 0x0174 }
            com.google.firebase.installations.a.d$a r11 = r11.a((long) r2)     // Catch:{ h -> 0x0174 }
            com.google.firebase.installations.a.d$a r11 = r11.b((long) r4)     // Catch:{ h -> 0x0174 }
            com.google.firebase.installations.a.d r11 = r11.a()     // Catch:{ h -> 0x0174 }
            goto L_0x011d
        L_0x008f:
            java.lang.String r11 = r0.a()     // Catch:{ h -> 0x0174 }
            if (r11 == 0) goto L_0x00a7
            java.lang.String r11 = r0.a()     // Catch:{ h -> 0x0174 }
            int r11 = r11.length()     // Catch:{ h -> 0x0174 }
            r1 = 11
            if (r11 != r1) goto L_0x00a7
            com.google.firebase.installations.a.b r11 = r10.f38966e     // Catch:{ h -> 0x0174 }
            java.lang.String r4 = r11.a()     // Catch:{ h -> 0x0174 }
        L_0x00a7:
            r9 = r4
            com.google.firebase.installations.b.c r4 = r10.f38963b     // Catch:{ h -> 0x0174 }
            java.lang.String r5 = r10.f()     // Catch:{ h -> 0x0174 }
            java.lang.String r6 = r0.a()     // Catch:{ h -> 0x0174 }
            java.lang.String r7 = r10.d()     // Catch:{ h -> 0x0174 }
            java.lang.String r8 = r10.e()     // Catch:{ h -> 0x0174 }
            com.google.firebase.installations.b.d r11 = r4.a(r5, r6, r7, r8, r9)     // Catch:{ h -> 0x0174 }
            int[] r1 = com.google.firebase.installations.c.AnonymousClass2.f38972a     // Catch:{ h -> 0x0174 }
            com.google.firebase.installations.b.d$b r4 = r11.e()     // Catch:{ h -> 0x0174 }
            int r4 = r4.ordinal()     // Catch:{ h -> 0x0174 }
            r1 = r1[r4]     // Catch:{ h -> 0x0174 }
            if (r1 == r3) goto L_0x00df
            if (r1 != r2) goto L_0x00d5
            java.lang.String r11 = "BAD CONFIG"
            com.google.firebase.installations.a.d r11 = r0.a(r11)     // Catch:{ h -> 0x0174 }
            goto L_0x011d
        L_0x00d5:
            com.google.firebase.installations.h r11 = new com.google.firebase.installations.h     // Catch:{ h -> 0x0174 }
            java.lang.String r1 = "Firebase Installations Service is unavailable. Please try again later."
            com.google.firebase.installations.h$a r2 = com.google.firebase.installations.h.a.UNAVAILABLE     // Catch:{ h -> 0x0174 }
            r11.<init>(r1, r2)     // Catch:{ h -> 0x0174 }
            throw r11     // Catch:{ h -> 0x0174 }
        L_0x00df:
            java.lang.String r1 = r11.b()     // Catch:{ h -> 0x0174 }
            java.lang.String r2 = r11.c()     // Catch:{ h -> 0x0174 }
            long r3 = com.google.firebase.installations.o.a()     // Catch:{ h -> 0x0174 }
            com.google.firebase.installations.b.e r5 = r11.d()     // Catch:{ h -> 0x0174 }
            java.lang.String r5 = r5.a()     // Catch:{ h -> 0x0174 }
            com.google.firebase.installations.b.e r11 = r11.d()     // Catch:{ h -> 0x0174 }
            long r6 = r11.b()     // Catch:{ h -> 0x0174 }
            com.google.firebase.installations.a.d$a r11 = r0.h()     // Catch:{ h -> 0x0174 }
            com.google.firebase.installations.a.d$a r11 = r11.a((java.lang.String) r1)     // Catch:{ h -> 0x0174 }
            com.google.firebase.installations.a.c$a r1 = com.google.firebase.installations.a.c.a.REGISTERED     // Catch:{ h -> 0x0174 }
            com.google.firebase.installations.a.d$a r11 = r11.a((com.google.firebase.installations.a.c.a) r1)     // Catch:{ h -> 0x0174 }
            com.google.firebase.installations.a.d$a r11 = r11.b((java.lang.String) r5)     // Catch:{ h -> 0x0174 }
            com.google.firebase.installations.a.d$a r11 = r11.c(r2)     // Catch:{ h -> 0x0174 }
            com.google.firebase.installations.a.d$a r11 = r11.a((long) r6)     // Catch:{ h -> 0x0174 }
            com.google.firebase.installations.a.d$a r11 = r11.b((long) r3)     // Catch:{ h -> 0x0174 }
            com.google.firebase.installations.a.d r11 = r11.a()     // Catch:{ h -> 0x0174 }
        L_0x011d:
            java.lang.Object r1 = l
            monitor-enter(r1)
            com.google.firebase.c r0 = r10.f38962a     // Catch:{ all -> 0x0171 }
            android.content.Context r0 = r0.a()     // Catch:{ all -> 0x0171 }
            java.lang.String r2 = "generatefid.lock"
            com.google.firebase.installations.b r0 = com.google.firebase.installations.b.a(r0, r2)     // Catch:{ all -> 0x0171 }
            com.google.firebase.installations.a.c r2 = r10.f38964c     // Catch:{ all -> 0x016a }
            r2.a(r11)     // Catch:{ all -> 0x016a }
            if (r0 == 0) goto L_0x0136
            r0.a()     // Catch:{ all -> 0x0171 }
        L_0x0136:
            monitor-exit(r1)     // Catch:{ all -> 0x0171 }
            boolean r0 = r11.i()
            if (r0 == 0) goto L_0x0144
            java.lang.String r0 = r11.a()
            r10.a((java.lang.String) r0)
        L_0x0144:
            boolean r0 = r11.j()
            if (r0 == 0) goto L_0x0155
            com.google.firebase.installations.h r0 = new com.google.firebase.installations.h
            com.google.firebase.installations.h$a r1 = com.google.firebase.installations.h.a.BAD_CONFIG
            r0.<init>(r1)
            r10.a((com.google.firebase.installations.a.d) r11, (java.lang.Exception) r0)
            return
        L_0x0155:
            boolean r0 = r11.l()
            if (r0 == 0) goto L_0x0166
            java.io.IOException r0 = new java.io.IOException
            java.lang.String r1 = "Installation ID could not be validated with the Firebase servers (maybe it was deleted). Firebase Installations will need to create a new Installation ID and auth token. Please retry your last request."
            r0.<init>(r1)
            r10.a((com.google.firebase.installations.a.d) r11, (java.lang.Exception) r0)
            return
        L_0x0166:
            r10.a((com.google.firebase.installations.a.d) r11)
            return
        L_0x016a:
            r10 = move-exception
            if (r0 == 0) goto L_0x0170
            r0.a()     // Catch:{ all -> 0x0171 }
        L_0x0170:
            throw r10     // Catch:{ all -> 0x0171 }
        L_0x0171:
            r10 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x0171 }
            throw r10
        L_0x0174:
            r11 = move-exception
            r10.a((com.google.firebase.installations.a.d) r0, (java.lang.Exception) r11)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.installations.c.a(com.google.firebase.installations.c, boolean):void");
    }
}
