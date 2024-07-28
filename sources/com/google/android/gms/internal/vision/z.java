package com.google.android.gms.internal.vision;

import android.content.ContentResolver;
import android.content.Context;
import android.os.Build;
import android.util.Log;
import java.io.File;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class z<T> {

    /* renamed from: a  reason: collision with root package name */
    private static final Object f11274a = new Object();

    /* renamed from: b  reason: collision with root package name */
    private static Context f11275b = null;

    /* renamed from: c  reason: collision with root package name */
    private static boolean f11276c = false;

    /* renamed from: d  reason: collision with root package name */
    private static am<ai<v>> f11277d;

    /* renamed from: h  reason: collision with root package name */
    private static final AtomicInteger f11278h = new AtomicInteger();

    /* renamed from: e  reason: collision with root package name */
    private final ad f11279e;

    /* renamed from: f  reason: collision with root package name */
    private final String f11280f;

    /* renamed from: g  reason: collision with root package name */
    private final T f11281g;

    /* renamed from: i  reason: collision with root package name */
    private volatile int f11282i;
    private volatile T j;

    /* access modifiers changed from: package-private */
    public abstract T a(Object obj);

    public static void a(Context context) {
        synchronized (f11274a) {
            if (f11275b == null) {
                synchronized (f11274a) {
                    Context applicationContext = context.getApplicationContext();
                    if (applicationContext != null) {
                        context = applicationContext;
                    }
                    if (f11275b != context) {
                        l.a();
                        ac.a();
                        p.a();
                        f11278h.incrementAndGet();
                        f11275b = context;
                        f11277d = ap.a(y.f11273a);
                    }
                }
            }
        }
    }

    static void a() {
        f11278h.incrementAndGet();
    }

    private z(ad adVar, String str, T t) {
        this.f11282i = -1;
        if (adVar.f10980a == null && adVar.f10981b == null) {
            throw new IllegalArgumentException("Must pass a valid SharedPreferences file name or ContentProvider URI");
        } else if (adVar.f10980a == null || adVar.f10981b == null) {
            this.f11279e = adVar;
            this.f11280f = str;
            this.f11281g = t;
        } else {
            throw new IllegalArgumentException("Must pass one of SharedPreferences file name or ContentProvider URI");
        }
    }

    private final String a(String str) {
        if (str != null && str.isEmpty()) {
            return this.f11280f;
        }
        String valueOf = String.valueOf(str);
        String valueOf2 = String.valueOf(this.f11280f);
        return valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf);
    }

    public final String b() {
        return a(this.f11279e.f10983d);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v15, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v2, resolved type: java.lang.String} */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0061, code lost:
        if (r3 != null) goto L_0x0063;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0045  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final T c() {
        /*
            r7 = this;
            java.util.concurrent.atomic.AtomicInteger r0 = f11278h
            int r0 = r0.get()
            int r1 = r7.f11282i
            if (r1 >= r0) goto L_0x00aa
            monitor-enter(r7)
            int r1 = r7.f11282i     // Catch:{ all -> 0x00a7 }
            if (r1 >= r0) goto L_0x00a5
            android.content.Context r1 = f11275b     // Catch:{ all -> 0x00a7 }
            if (r1 == 0) goto L_0x009d
            com.google.android.gms.internal.vision.ad r1 = r7.f11279e     // Catch:{ all -> 0x00a7 }
            boolean r1 = r1.f10985f     // Catch:{ all -> 0x00a7 }
            if (r1 == 0) goto L_0x0027
            java.lang.Object r1 = r7.f()     // Catch:{ all -> 0x00a7 }
            if (r1 == 0) goto L_0x0020
            goto L_0x0037
        L_0x0020:
            java.lang.Object r1 = r7.e()     // Catch:{ all -> 0x00a7 }
            if (r1 == 0) goto L_0x0035
            goto L_0x0037
        L_0x0027:
            java.lang.Object r1 = r7.e()     // Catch:{ all -> 0x00a7 }
            if (r1 == 0) goto L_0x002e
            goto L_0x0037
        L_0x002e:
            java.lang.Object r1 = r7.f()     // Catch:{ all -> 0x00a7 }
            if (r1 == 0) goto L_0x0035
            goto L_0x0037
        L_0x0035:
            T r1 = r7.f11281g     // Catch:{ all -> 0x00a7 }
        L_0x0037:
            com.google.android.gms.internal.vision.am<com.google.android.gms.internal.vision.ai<com.google.android.gms.internal.vision.v>> r2 = f11277d     // Catch:{ all -> 0x00a7 }
            java.lang.Object r2 = r2.get()     // Catch:{ all -> 0x00a7 }
            com.google.android.gms.internal.vision.ai r2 = (com.google.android.gms.internal.vision.ai) r2     // Catch:{ all -> 0x00a7 }
            boolean r3 = r2.isPresent()     // Catch:{ all -> 0x00a7 }
            if (r3 == 0) goto L_0x0098
            java.lang.Object r1 = r2.get()     // Catch:{ all -> 0x00a7 }
            com.google.android.gms.internal.vision.v r1 = (com.google.android.gms.internal.vision.v) r1     // Catch:{ all -> 0x00a7 }
            com.google.android.gms.internal.vision.ad r2 = r7.f11279e     // Catch:{ all -> 0x00a7 }
            android.net.Uri r2 = r2.f10981b     // Catch:{ all -> 0x00a7 }
            com.google.android.gms.internal.vision.ad r3 = r7.f11279e     // Catch:{ all -> 0x00a7 }
            java.lang.String r3 = r3.f10980a     // Catch:{ all -> 0x00a7 }
            com.google.android.gms.internal.vision.ad r4 = r7.f11279e     // Catch:{ all -> 0x00a7 }
            java.lang.String r4 = r4.f10983d     // Catch:{ all -> 0x00a7 }
            java.lang.String r5 = r7.f11280f     // Catch:{ all -> 0x00a7 }
            r6 = 0
            if (r2 == 0) goto L_0x0061
            java.lang.String r3 = r2.toString()     // Catch:{ all -> 0x00a7 }
            goto L_0x0063
        L_0x0061:
            if (r3 == 0) goto L_0x008f
        L_0x0063:
            java.util.Map<java.lang.String, java.util.Map<java.lang.String, java.lang.String>> r1 = r1.f11269a     // Catch:{ all -> 0x00a7 }
            java.lang.Object r1 = r1.get(r3)     // Catch:{ all -> 0x00a7 }
            java.util.Map r1 = (java.util.Map) r1     // Catch:{ all -> 0x00a7 }
            if (r1 != 0) goto L_0x006e
            goto L_0x008f
        L_0x006e:
            if (r4 == 0) goto L_0x0088
            java.lang.String r2 = java.lang.String.valueOf(r4)     // Catch:{ all -> 0x00a7 }
            java.lang.String r3 = java.lang.String.valueOf(r5)     // Catch:{ all -> 0x00a7 }
            int r4 = r3.length()     // Catch:{ all -> 0x00a7 }
            if (r4 == 0) goto L_0x0083
            java.lang.String r5 = r2.concat(r3)     // Catch:{ all -> 0x00a7 }
            goto L_0x0088
        L_0x0083:
            java.lang.String r5 = new java.lang.String     // Catch:{ all -> 0x00a7 }
            r5.<init>(r2)     // Catch:{ all -> 0x00a7 }
        L_0x0088:
            java.lang.Object r1 = r1.get(r5)     // Catch:{ all -> 0x00a7 }
            r6 = r1
            java.lang.String r6 = (java.lang.String) r6     // Catch:{ all -> 0x00a7 }
        L_0x008f:
            if (r6 != 0) goto L_0x0094
            T r1 = r7.f11281g     // Catch:{ all -> 0x00a7 }
            goto L_0x0098
        L_0x0094:
            java.lang.Object r1 = r7.a((java.lang.Object) r6)     // Catch:{ all -> 0x00a7 }
        L_0x0098:
            r7.j = r1     // Catch:{ all -> 0x00a7 }
            r7.f11282i = r0     // Catch:{ all -> 0x00a7 }
            goto L_0x00a5
        L_0x009d:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException     // Catch:{ all -> 0x00a7 }
            java.lang.String r1 = "Must call PhenotypeFlag.init() first"
            r0.<init>(r1)     // Catch:{ all -> 0x00a7 }
            throw r0     // Catch:{ all -> 0x00a7 }
        L_0x00a5:
            monitor-exit(r7)     // Catch:{ all -> 0x00a7 }
            goto L_0x00aa
        L_0x00a7:
            r0 = move-exception
            monitor-exit(r7)     // Catch:{ all -> 0x00a7 }
            throw r0
        L_0x00aa:
            T r0 = r7.j
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.vision.z.c():java.lang.Object");
    }

    private final T e() {
        o oVar;
        Object a2;
        boolean z = false;
        if (!this.f11279e.f10986g) {
            String str = (String) p.a(f11275b).a("gms:phenotype:phenotype_flag:debug_bypass_phenotype");
            if (str != null && g.f11159b.matcher(str).matches()) {
                z = true;
            }
        }
        if (!z) {
            if (this.f11279e.f10981b == null) {
                oVar = ac.a(f11275b, this.f11279e.f10980a);
            } else if (!x.a(f11275b, this.f11279e.f10981b)) {
                oVar = null;
            } else if (this.f11279e.f10987h) {
                ContentResolver contentResolver = f11275b.getContentResolver();
                String lastPathSegment = this.f11279e.f10981b.getLastPathSegment();
                String packageName = f11275b.getPackageName();
                StringBuilder sb = new StringBuilder(String.valueOf(lastPathSegment).length() + 1 + String.valueOf(packageName).length());
                sb.append(lastPathSegment);
                sb.append("#");
                sb.append(packageName);
                oVar = l.a(contentResolver, w.a(sb.toString()));
            } else {
                oVar = l.a(f11275b.getContentResolver(), this.f11279e.f10981b);
            }
            if (!(oVar == null || (a2 = oVar.a(b())) == null)) {
                return a(a2);
            }
        } else if (Log.isLoggable("PhenotypeFlag", 3)) {
            String valueOf = String.valueOf(b());
            if (valueOf.length() != 0) {
                "Bypass reading Phenotype values for flag: ".concat(valueOf);
            } else {
                new String("Bypass reading Phenotype values for flag: ");
            }
        }
        return null;
    }

    private final T f() {
        if (!this.f11279e.f10984e && (this.f11279e.f10988i == null || this.f11279e.f10988i.a().booleanValue())) {
            Object a2 = p.a(f11275b).a(this.f11279e.f10984e ? null : a(this.f11279e.f10982c));
            if (a2 != null) {
                return a(a2);
            }
        }
        return null;
    }

    static final /* synthetic */ ai d() {
        new t();
        Context context = f11275b;
        String str = Build.TYPE;
        String str2 = Build.TAGS;
        String str3 = Build.HARDWARE;
        boolean z = false;
        if ((str.equals("eng") || str.equals("userdebug")) && ((str3.equals("goldfish") || str3.equals("ranchu") || str3.equals("robolectric")) && (str2.contains("dev-keys") || str2.contains("test-keys")))) {
            z = true;
        }
        if (z) {
            if (i.a() && !context.isDeviceProtectedStorage()) {
                context = context.createDeviceProtectedStorageContext();
            }
            ai<File> a2 = t.a(context);
            if (a2.isPresent()) {
                return ai.zzc(t.a(a2.get()));
            }
        }
        return ai.zzbx();
    }

    /* synthetic */ z(ad adVar, String str, Object obj, byte b2) {
        this(adVar, str, obj);
    }

    static /* synthetic */ z a(ad adVar, String str, long j2) {
        return new ab(adVar, str, Long.valueOf(j2));
    }

    static /* synthetic */ z a(ad adVar, String str, boolean z) {
        return new aa(adVar, str, Boolean.valueOf(z));
    }
}
