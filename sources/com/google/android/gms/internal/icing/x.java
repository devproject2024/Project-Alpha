package com.google.android.gms.internal.icing;

import android.content.Context;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class x<T> {

    /* renamed from: a  reason: collision with root package name */
    private static final Object f10279a = new Object();

    /* renamed from: b  reason: collision with root package name */
    private static Context f10280b = null;

    /* renamed from: c  reason: collision with root package name */
    private static boolean f10281c = false;

    /* renamed from: g  reason: collision with root package name */
    private static final AtomicInteger f10282g = new AtomicInteger();

    /* renamed from: d  reason: collision with root package name */
    private final y f10283d;

    /* renamed from: e  reason: collision with root package name */
    private final String f10284e;

    /* renamed from: f  reason: collision with root package name */
    private final T f10285f;

    /* renamed from: h  reason: collision with root package name */
    private volatile int f10286h;

    /* renamed from: i  reason: collision with root package name */
    private volatile T f10287i;

    public static void a(Context context) {
        synchronized (f10279a) {
            Context applicationContext = context.getApplicationContext();
            if (applicationContext != null) {
                context = applicationContext;
            }
            if (f10280b != context) {
                synchronized (o.class) {
                    o.f10265a.clear();
                }
                synchronized (ab.class) {
                    ab.f10049a.clear();
                }
                synchronized (s.class) {
                    s.f10273a = null;
                }
                f10282g.incrementAndGet();
                f10280b = context;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public abstract T a(Object obj);

    static void a() {
        f10282g.incrementAndGet();
    }

    private x(y yVar, String str, T t) {
        this.f10286h = -1;
        if (yVar.f10288a != null) {
            this.f10283d = yVar;
            this.f10284e = str;
            this.f10285f = t;
            return;
        }
        throw new IllegalArgumentException("Must pass a valid SharedPreferences file name or ContentProvider URI");
    }

    private final String a(String str) {
        if (str != null && str.isEmpty()) {
            return this.f10284e;
        }
        String valueOf = String.valueOf(str);
        String valueOf2 = String.valueOf(this.f10284e);
        return valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf);
    }

    public final String b() {
        return a(this.f10283d.f10290c);
    }

    /* JADX WARNING: Removed duplicated region for block: B:35:0x0094  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0095  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final T c() {
        /*
            r5 = this;
            java.util.concurrent.atomic.AtomicInteger r0 = f10282g
            int r0 = r0.get()
            int r1 = r5.f10286h
            if (r1 >= r0) goto L_0x00c5
            monitor-enter(r5)
            int r1 = r5.f10286h     // Catch:{ all -> 0x00c2 }
            if (r1 >= r0) goto L_0x00c0
            android.content.Context r1 = f10280b     // Catch:{ all -> 0x00c2 }
            if (r1 == 0) goto L_0x00b8
            android.content.Context r1 = f10280b     // Catch:{ all -> 0x00c2 }
            com.google.android.gms.internal.icing.s r1 = com.google.android.gms.internal.icing.s.a((android.content.Context) r1)     // Catch:{ all -> 0x00c2 }
            java.lang.String r2 = "gms:phenotype:phenotype_flag:debug_bypass_phenotype"
            java.lang.Object r1 = r1.a((java.lang.String) r2)     // Catch:{ all -> 0x00c2 }
            java.lang.String r1 = (java.lang.String) r1     // Catch:{ all -> 0x00c2 }
            if (r1 == 0) goto L_0x0031
            java.util.regex.Pattern r2 = com.google.android.gms.internal.icing.j.f10251b     // Catch:{ all -> 0x00c2 }
            java.util.regex.Matcher r1 = r2.matcher(r1)     // Catch:{ all -> 0x00c2 }
            boolean r1 = r1.matches()     // Catch:{ all -> 0x00c2 }
            if (r1 == 0) goto L_0x0031
            r1 = 1
            goto L_0x0032
        L_0x0031:
            r1 = 0
        L_0x0032:
            r2 = 0
            if (r1 != 0) goto L_0x006f
            com.google.android.gms.internal.icing.y r1 = r5.f10283d     // Catch:{ all -> 0x00c2 }
            android.net.Uri r1 = r1.f10288a     // Catch:{ all -> 0x00c2 }
            if (r1 == 0) goto L_0x0058
            android.content.Context r1 = f10280b     // Catch:{ all -> 0x00c2 }
            com.google.android.gms.internal.icing.y r3 = r5.f10283d     // Catch:{ all -> 0x00c2 }
            android.net.Uri r3 = r3.f10288a     // Catch:{ all -> 0x00c2 }
            boolean r1 = com.google.android.gms.internal.icing.w.a(r1, r3)     // Catch:{ all -> 0x00c2 }
            if (r1 == 0) goto L_0x0056
            android.content.Context r1 = f10280b     // Catch:{ all -> 0x00c2 }
            android.content.ContentResolver r1 = r1.getContentResolver()     // Catch:{ all -> 0x00c2 }
            com.google.android.gms.internal.icing.y r3 = r5.f10283d     // Catch:{ all -> 0x00c2 }
            android.net.Uri r3 = r3.f10288a     // Catch:{ all -> 0x00c2 }
            com.google.android.gms.internal.icing.o r1 = com.google.android.gms.internal.icing.o.a(r1, r3)     // Catch:{ all -> 0x00c2 }
            goto L_0x005e
        L_0x0056:
            r1 = r2
            goto L_0x005e
        L_0x0058:
            android.content.Context r1 = f10280b     // Catch:{ all -> 0x00c2 }
            com.google.android.gms.internal.icing.ab r1 = com.google.android.gms.internal.icing.ab.a((android.content.Context) r1)     // Catch:{ all -> 0x00c2 }
        L_0x005e:
            if (r1 == 0) goto L_0x0091
            java.lang.String r3 = r5.b()     // Catch:{ all -> 0x00c2 }
            java.lang.Object r1 = r1.a(r3)     // Catch:{ all -> 0x00c2 }
            if (r1 == 0) goto L_0x0091
            java.lang.Object r1 = r5.a((java.lang.Object) r1)     // Catch:{ all -> 0x00c2 }
            goto L_0x0092
        L_0x006f:
            java.lang.String r1 = "PhenotypeFlag"
            r3 = 3
            boolean r1 = android.util.Log.isLoggable(r1, r3)     // Catch:{ all -> 0x00c2 }
            if (r1 == 0) goto L_0x0091
            java.lang.String r1 = "Bypass reading Phenotype values for flag: "
            java.lang.String r3 = r5.b()     // Catch:{ all -> 0x00c2 }
            java.lang.String r3 = java.lang.String.valueOf(r3)     // Catch:{ all -> 0x00c2 }
            int r4 = r3.length()     // Catch:{ all -> 0x00c2 }
            if (r4 == 0) goto L_0x008c
            r1.concat(r3)     // Catch:{ all -> 0x00c2 }
            goto L_0x0091
        L_0x008c:
            java.lang.String r3 = new java.lang.String     // Catch:{ all -> 0x00c2 }
            r3.<init>(r1)     // Catch:{ all -> 0x00c2 }
        L_0x0091:
            r1 = r2
        L_0x0092:
            if (r1 == 0) goto L_0x0095
            goto L_0x00b3
        L_0x0095:
            android.content.Context r1 = f10280b     // Catch:{ all -> 0x00c2 }
            com.google.android.gms.internal.icing.s r1 = com.google.android.gms.internal.icing.s.a((android.content.Context) r1)     // Catch:{ all -> 0x00c2 }
            com.google.android.gms.internal.icing.y r3 = r5.f10283d     // Catch:{ all -> 0x00c2 }
            java.lang.String r3 = r3.f10289b     // Catch:{ all -> 0x00c2 }
            java.lang.String r3 = r5.a((java.lang.String) r3)     // Catch:{ all -> 0x00c2 }
            java.lang.Object r1 = r1.a(r3)     // Catch:{ all -> 0x00c2 }
            if (r1 == 0) goto L_0x00ad
            java.lang.Object r2 = r5.a((java.lang.Object) r1)     // Catch:{ all -> 0x00c2 }
        L_0x00ad:
            r1 = r2
            if (r1 == 0) goto L_0x00b1
            goto L_0x00b3
        L_0x00b1:
            T r1 = r5.f10285f     // Catch:{ all -> 0x00c2 }
        L_0x00b3:
            r5.f10287i = r1     // Catch:{ all -> 0x00c2 }
            r5.f10286h = r0     // Catch:{ all -> 0x00c2 }
            goto L_0x00c0
        L_0x00b8:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException     // Catch:{ all -> 0x00c2 }
            java.lang.String r1 = "Must call PhenotypeFlag.init() first"
            r0.<init>(r1)     // Catch:{ all -> 0x00c2 }
            throw r0     // Catch:{ all -> 0x00c2 }
        L_0x00c0:
            monitor-exit(r5)     // Catch:{ all -> 0x00c2 }
            goto L_0x00c5
        L_0x00c2:
            r0 = move-exception
            monitor-exit(r5)     // Catch:{ all -> 0x00c2 }
            throw r0
        L_0x00c5:
            T r0 = r5.f10287i
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.icing.x.c():java.lang.Object");
    }

    /* synthetic */ x(y yVar, String str, Object obj, byte b2) {
        this(yVar, str, obj);
    }

    static /* synthetic */ x a(y yVar, String str, boolean z) {
        return new z(yVar, str, Boolean.valueOf(z));
    }
}
