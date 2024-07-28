package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.os.Build;
import java.io.File;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class bd<T> {

    /* renamed from: a  reason: collision with root package name */
    private static final Object f10481a = new Object();

    /* renamed from: b  reason: collision with root package name */
    private static Context f10482b = null;

    /* renamed from: c  reason: collision with root package name */
    private static boolean f10483c = false;

    /* renamed from: d  reason: collision with root package name */
    private static br<bq<az>> f10484d;

    /* renamed from: h  reason: collision with root package name */
    private static final AtomicInteger f10485h = new AtomicInteger();

    /* renamed from: e  reason: collision with root package name */
    private final bj f10486e;

    /* renamed from: f  reason: collision with root package name */
    private final String f10487f;

    /* renamed from: g  reason: collision with root package name */
    private final T f10488g;

    /* renamed from: i  reason: collision with root package name */
    private volatile int f10489i;
    private volatile T j;

    public static void a(Context context) {
        synchronized (f10481a) {
            Context applicationContext = context.getApplicationContext();
            if (applicationContext != null) {
                context = applicationContext;
            }
            if (f10482b != context) {
                ap.b();
                bm.a();
                ay.a();
                f10485h.incrementAndGet();
                f10482b = context;
                f10484d = bv.a(bg.f10491a);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public abstract T a(Object obj);

    static void a() {
        f10485h.incrementAndGet();
    }

    private bd(bj bjVar, String str, T t) {
        this.f10489i = -1;
        if (bjVar.f10493b != null) {
            this.f10486e = bjVar;
            this.f10487f = str;
            this.f10488g = t;
            return;
        }
        throw new IllegalArgumentException("Must pass a valid SharedPreferences file name or ContentProvider URI");
    }

    private final String a(String str) {
        if (str != null && str.isEmpty()) {
            return this.f10487f;
        }
        String valueOf = String.valueOf(str);
        String valueOf2 = String.valueOf(this.f10487f);
        return valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf);
    }

    public final String b() {
        return a(this.f10486e.f10495d);
    }

    /* JADX WARNING: Removed duplicated region for block: B:49:0x00ec  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00ed  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final T c() {
        /*
            r6 = this;
            java.util.concurrent.atomic.AtomicInteger r0 = f10485h
            int r0 = r0.get()
            int r1 = r6.f10489i
            if (r1 >= r0) goto L_0x011d
            monitor-enter(r6)
            int r1 = r6.f10489i     // Catch:{ all -> 0x011a }
            if (r1 >= r0) goto L_0x0118
            android.content.Context r1 = f10482b     // Catch:{ all -> 0x011a }
            if (r1 == 0) goto L_0x0110
            com.google.android.gms.internal.measurement.br<com.google.android.gms.internal.measurement.bq<com.google.android.gms.internal.measurement.az>> r1 = f10484d     // Catch:{ all -> 0x011a }
            java.lang.Object r1 = r1.zza()     // Catch:{ all -> 0x011a }
            com.google.android.gms.internal.measurement.bq r1 = (com.google.android.gms.internal.measurement.bq) r1     // Catch:{ all -> 0x011a }
            boolean r2 = r1.zza()     // Catch:{ all -> 0x011a }
            r3 = 0
            if (r2 == 0) goto L_0x006c
            java.lang.Object r1 = r1.zzb()     // Catch:{ all -> 0x011a }
            com.google.android.gms.internal.measurement.az r1 = (com.google.android.gms.internal.measurement.az) r1     // Catch:{ all -> 0x011a }
            com.google.android.gms.internal.measurement.bj r2 = r6.f10486e     // Catch:{ all -> 0x011a }
            android.net.Uri r2 = r2.f10493b     // Catch:{ all -> 0x011a }
            com.google.android.gms.internal.measurement.bj r4 = r6.f10486e     // Catch:{ all -> 0x011a }
            java.lang.String r4 = r4.f10495d     // Catch:{ all -> 0x011a }
            java.lang.String r5 = r6.f10487f     // Catch:{ all -> 0x011a }
            if (r2 == 0) goto L_0x0064
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x011a }
            java.util.Map<java.lang.String, java.util.Map<java.lang.String, java.lang.String>> r1 = r1.f10473a     // Catch:{ all -> 0x011a }
            java.lang.Object r1 = r1.get(r2)     // Catch:{ all -> 0x011a }
            java.util.Map r1 = (java.util.Map) r1     // Catch:{ all -> 0x011a }
            if (r1 != 0) goto L_0x0043
            goto L_0x0064
        L_0x0043:
            if (r4 == 0) goto L_0x005d
            java.lang.String r2 = java.lang.String.valueOf(r4)     // Catch:{ all -> 0x011a }
            java.lang.String r3 = java.lang.String.valueOf(r5)     // Catch:{ all -> 0x011a }
            int r4 = r3.length()     // Catch:{ all -> 0x011a }
            if (r4 == 0) goto L_0x0058
            java.lang.String r5 = r2.concat(r3)     // Catch:{ all -> 0x011a }
            goto L_0x005d
        L_0x0058:
            java.lang.String r5 = new java.lang.String     // Catch:{ all -> 0x011a }
            r5.<init>(r2)     // Catch:{ all -> 0x011a }
        L_0x005d:
            java.lang.Object r1 = r1.get(r5)     // Catch:{ all -> 0x011a }
            r3 = r1
            java.lang.String r3 = (java.lang.String) r3     // Catch:{ all -> 0x011a }
        L_0x0064:
            if (r3 == 0) goto L_0x0109
            java.lang.Object r1 = r6.a((java.lang.Object) r3)     // Catch:{ all -> 0x011a }
            goto L_0x010b
        L_0x006c:
            android.content.Context r1 = f10482b     // Catch:{ all -> 0x011a }
            com.google.android.gms.internal.measurement.ay r1 = com.google.android.gms.internal.measurement.ay.a((android.content.Context) r1)     // Catch:{ all -> 0x011a }
            java.lang.String r2 = "gms:phenotype:phenotype_flag:debug_bypass_phenotype"
            java.lang.Object r1 = r1.a((java.lang.String) r2)     // Catch:{ all -> 0x011a }
            java.lang.String r1 = (java.lang.String) r1     // Catch:{ all -> 0x011a }
            if (r1 == 0) goto L_0x008a
            java.util.regex.Pattern r2 = com.google.android.gms.internal.measurement.ao.f10446b     // Catch:{ all -> 0x011a }
            java.util.regex.Matcher r1 = r2.matcher(r1)     // Catch:{ all -> 0x011a }
            boolean r1 = r1.matches()     // Catch:{ all -> 0x011a }
            if (r1 == 0) goto L_0x008a
            r1 = 1
            goto L_0x008b
        L_0x008a:
            r1 = 0
        L_0x008b:
            if (r1 != 0) goto L_0x00c7
            com.google.android.gms.internal.measurement.bj r1 = r6.f10486e     // Catch:{ all -> 0x011a }
            android.net.Uri r1 = r1.f10493b     // Catch:{ all -> 0x011a }
            if (r1 == 0) goto L_0x00b0
            android.content.Context r1 = f10482b     // Catch:{ all -> 0x011a }
            com.google.android.gms.internal.measurement.bj r2 = r6.f10486e     // Catch:{ all -> 0x011a }
            android.net.Uri r2 = r2.f10493b     // Catch:{ all -> 0x011a }
            boolean r1 = com.google.android.gms.internal.measurement.bb.a(r1, r2)     // Catch:{ all -> 0x011a }
            if (r1 == 0) goto L_0x00ae
            android.content.Context r1 = f10482b     // Catch:{ all -> 0x011a }
            android.content.ContentResolver r1 = r1.getContentResolver()     // Catch:{ all -> 0x011a }
            com.google.android.gms.internal.measurement.bj r2 = r6.f10486e     // Catch:{ all -> 0x011a }
            android.net.Uri r2 = r2.f10493b     // Catch:{ all -> 0x011a }
            com.google.android.gms.internal.measurement.ap r1 = com.google.android.gms.internal.measurement.ap.a(r1, r2)     // Catch:{ all -> 0x011a }
            goto L_0x00b6
        L_0x00ae:
            r1 = r3
            goto L_0x00b6
        L_0x00b0:
            android.content.Context r1 = f10482b     // Catch:{ all -> 0x011a }
            com.google.android.gms.internal.measurement.bm r1 = com.google.android.gms.internal.measurement.bm.a((android.content.Context) r1)     // Catch:{ all -> 0x011a }
        L_0x00b6:
            if (r1 == 0) goto L_0x00e9
            java.lang.String r2 = r6.b()     // Catch:{ all -> 0x011a }
            java.lang.Object r1 = r1.a(r2)     // Catch:{ all -> 0x011a }
            if (r1 == 0) goto L_0x00e9
            java.lang.Object r1 = r6.a((java.lang.Object) r1)     // Catch:{ all -> 0x011a }
            goto L_0x00ea
        L_0x00c7:
            java.lang.String r1 = "PhenotypeFlag"
            r2 = 3
            boolean r1 = android.util.Log.isLoggable(r1, r2)     // Catch:{ all -> 0x011a }
            if (r1 == 0) goto L_0x00e9
            java.lang.String r1 = "Bypass reading Phenotype values for flag: "
            java.lang.String r2 = r6.b()     // Catch:{ all -> 0x011a }
            java.lang.String r2 = java.lang.String.valueOf(r2)     // Catch:{ all -> 0x011a }
            int r4 = r2.length()     // Catch:{ all -> 0x011a }
            if (r4 == 0) goto L_0x00e4
            r1.concat(r2)     // Catch:{ all -> 0x011a }
            goto L_0x00e9
        L_0x00e4:
            java.lang.String r2 = new java.lang.String     // Catch:{ all -> 0x011a }
            r2.<init>(r1)     // Catch:{ all -> 0x011a }
        L_0x00e9:
            r1 = r3
        L_0x00ea:
            if (r1 == 0) goto L_0x00ed
            goto L_0x010b
        L_0x00ed:
            android.content.Context r1 = f10482b     // Catch:{ all -> 0x011a }
            com.google.android.gms.internal.measurement.ay r1 = com.google.android.gms.internal.measurement.ay.a((android.content.Context) r1)     // Catch:{ all -> 0x011a }
            com.google.android.gms.internal.measurement.bj r2 = r6.f10486e     // Catch:{ all -> 0x011a }
            java.lang.String r2 = r2.f10494c     // Catch:{ all -> 0x011a }
            java.lang.String r2 = r6.a((java.lang.String) r2)     // Catch:{ all -> 0x011a }
            java.lang.Object r1 = r1.a(r2)     // Catch:{ all -> 0x011a }
            if (r1 == 0) goto L_0x0105
            java.lang.Object r3 = r6.a((java.lang.Object) r1)     // Catch:{ all -> 0x011a }
        L_0x0105:
            r1 = r3
            if (r1 == 0) goto L_0x0109
            goto L_0x010b
        L_0x0109:
            T r1 = r6.f10488g     // Catch:{ all -> 0x011a }
        L_0x010b:
            r6.j = r1     // Catch:{ all -> 0x011a }
            r6.f10489i = r0     // Catch:{ all -> 0x011a }
            goto L_0x0118
        L_0x0110:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException     // Catch:{ all -> 0x011a }
            java.lang.String r1 = "Must call PhenotypeFlag.init() first"
            r0.<init>(r1)     // Catch:{ all -> 0x011a }
            throw r0     // Catch:{ all -> 0x011a }
        L_0x0118:
            monitor-exit(r6)     // Catch:{ all -> 0x011a }
            goto L_0x011d
        L_0x011a:
            r0 = move-exception
            monitor-exit(r6)     // Catch:{ all -> 0x011a }
            throw r0
        L_0x011d:
            T r0 = r6.j
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.bd.c():java.lang.Object");
    }

    static final /* synthetic */ bq d() {
        new bc();
        Context context = f10482b;
        String str = Build.TYPE;
        String str2 = Build.TAGS;
        String str3 = Build.HARDWARE;
        boolean z = false;
        if ((str.equals("eng") || str.equals("userdebug")) && ((str3.equals("goldfish") || str3.equals("ranchu") || str3.equals("robolectric")) && (str2.contains("dev-keys") || str2.contains("test-keys")))) {
            z = true;
        }
        if (z) {
            if (aq.a() && !context.isDeviceProtectedStorage()) {
                context = context.createDeviceProtectedStorageContext();
            }
            bq<File> a2 = bc.a(context);
            if (a2.zza()) {
                return bq.zza(bc.a(a2.zzb()));
            }
        }
        return bq.zzc();
    }

    /* synthetic */ bd(bj bjVar, String str, Object obj, byte b2) {
        this(bjVar, str, obj);
    }

    static /* synthetic */ bd a(bj bjVar, String str, long j2) {
        return new bf(bjVar, str, Long.valueOf(j2));
    }

    static /* synthetic */ bd a(bj bjVar, String str, boolean z) {
        return new bi(bjVar, str, Boolean.valueOf(z));
    }

    static /* synthetic */ bd a(bj bjVar, String str) {
        return new bh(bjVar, str, Double.valueOf(-3.0d));
    }

    static /* synthetic */ bd a(bj bjVar, String str, String str2) {
        return new bk(bjVar, str, str2);
    }
}
