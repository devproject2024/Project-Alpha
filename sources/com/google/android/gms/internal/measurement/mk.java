package com.google.android.gms.internal.measurement;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.RemoteException;
import android.util.Pair;
import com.google.android.gms.common.api.internal.g;
import com.google.android.gms.common.internal.s;
import com.google.android.gms.common.util.e;
import com.google.android.gms.common.util.h;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.measurement.dynamite.ModuleDescriptor;
import com.google.android.gms.measurement.internal.gb;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class mk {

    /* renamed from: b  reason: collision with root package name */
    private static volatile mk f10905b = null;

    /* renamed from: h  reason: collision with root package name */
    private static Boolean f10906h = null;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public static Boolean f10907i = null;
    private static boolean j = false;
    private static Boolean k = null;
    private static String l = "use_dynamite_api";
    private static String m = "allow_remote_dynamite";
    private static boolean n = false;
    private static boolean o = false;

    /* renamed from: a  reason: collision with root package name */
    protected final e f10908a = h.d();
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final String f10909c = "FA";

    /* renamed from: d  reason: collision with root package name */
    private final ExecutorService f10910d = new ThreadPoolExecutor(0, 1, 30, TimeUnit.SECONDS, new LinkedBlockingQueue());

    /* renamed from: e  reason: collision with root package name */
    private final com.google.android.gms.measurement.api.a f10911e = new com.google.android.gms.measurement.api.a(this);
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public List<Pair<gb, b>> f10912f;

    /* renamed from: g  reason: collision with root package name */
    private int f10913g;
    /* access modifiers changed from: private */
    public boolean p;
    private String q;
    /* access modifiers changed from: private */
    public kv r;

    class c implements Application.ActivityLifecycleCallbacks {
        c() {
        }

        public final void onActivityCreated(Activity activity, Bundle bundle) {
            mk.this.a((a) new u(this, activity, bundle));
        }

        public final void onActivityStarted(Activity activity) {
            mk.this.a((a) new w(this, activity));
        }

        public final void onActivityResumed(Activity activity) {
            mk.this.a((a) new v(this, activity));
        }

        public final void onActivityPaused(Activity activity) {
            mk.this.a((a) new y(this, activity));
        }

        public final void onActivityStopped(Activity activity) {
            mk.this.a((a) new x(this, activity));
        }

        public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
            it itVar = new it();
            mk.this.a((a) new aa(this, activity, itVar));
            Bundle b2 = itVar.b(50);
            if (b2 != null) {
                bundle.putAll(b2);
            }
        }

        public final void onActivityDestroyed(Activity activity) {
            mk.this.a((a) new z(this, activity));
        }
    }

    public static mk a(Context context) {
        return a(context, (Bundle) null);
    }

    abstract class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final long f10914a;

        /* renamed from: b  reason: collision with root package name */
        final long f10915b;

        /* renamed from: c  reason: collision with root package name */
        private final boolean f10916c;

        a(mk mkVar) {
            this(true);
        }

        /* access modifiers changed from: package-private */
        public abstract void a() throws RemoteException;

        /* access modifiers changed from: protected */
        public void b() {
        }

        a(boolean z) {
            this.f10914a = mk.this.f10908a.a();
            this.f10915b = mk.this.f10908a.b();
            this.f10916c = z;
        }

        public void run() {
            if (mk.this.p) {
                b();
                return;
            }
            try {
                a();
            } catch (Exception e2) {
                mk.this.a(e2, false, this.f10916c);
                b();
            }
        }
    }

    public static mk a(Context context, Bundle bundle) {
        s.a(context);
        if (f10905b == null) {
            synchronized (mk.class) {
                if (f10905b == null) {
                    f10905b = new mk(context, bundle);
                }
            }
        }
        return f10905b;
    }

    static class b extends mf {

        /* renamed from: a  reason: collision with root package name */
        private final gb f10918a;

        b(gb gbVar) {
            this.f10918a = gbVar;
        }

        public final void a(String str, String str2, Bundle bundle, long j) {
            this.f10918a.a(str, str2, bundle, j);
        }

        public final int s_() {
            return System.identityHashCode(this.f10918a);
        }
    }

    private mk(Context context, Bundle bundle) {
        if (!(!f(context) || c())) {
            this.q = null;
            this.p = true;
            return;
        }
        if (!b((String) null, (String) null)) {
            this.q = "fa";
        } else {
            this.q = null;
        }
        a((a) new b(this, context, bundle));
        Application application = (Application) context.getApplicationContext();
        if (application != null) {
            application.registerActivityLifecycleCallbacks(new c());
        }
    }

    private static boolean f(Context context) {
        try {
            g.a(context);
            if (g.a() != null) {
                return true;
            }
            return false;
        } catch (IllegalStateException unused) {
        }
    }

    /* access modifiers changed from: private */
    public static boolean b(String str, String str2) {
        return (str2 == null || str == null || c()) ? false : true;
    }

    public final void a(a aVar) {
        this.f10910d.execute(aVar);
    }

    /* access modifiers changed from: protected */
    public final kv a(Context context, boolean z) {
        DynamiteModule.b bVar;
        if (z) {
            try {
                bVar = DynamiteModule.f9013f;
            } catch (DynamiteModule.a e2) {
                a(e2, true, false);
                return null;
            }
        } else {
            bVar = DynamiteModule.f9009b;
        }
        return ju.asInterface(DynamiteModule.a(context, bVar, ModuleDescriptor.MODULE_ID).a("com.google.android.gms.measurement.internal.AppMeasurementDynamiteService"));
    }

    /* access modifiers changed from: private */
    public final void a(Exception exc, boolean z, boolean z2) {
        this.p |= z;
        if (!z && z2) {
            a("Error with data collection. Data lost.", (Object) exc);
        }
    }

    private static boolean c() {
        try {
            Class.forName("com.google.firebase.analytics.FirebaseAnalytics");
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    public final long a() {
        it itVar = new it();
        a((a) new j(this, itVar));
        Long l2 = (Long) it.a(itVar.b(500), Long.class);
        if (l2 != null) {
            return l2.longValue();
        }
        long nextLong = new Random(System.nanoTime() ^ this.f10908a.a()).nextLong();
        int i2 = this.f10913g + 1;
        this.f10913g = i2;
        return nextLong + ((long) i2);
    }

    private void a(String str, Object obj) {
        a((a) new m(this, str, obj));
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Can't wrap try/catch for region: R(5:18|19|20|22|23) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:22:0x0052 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void g(android.content.Context r3) {
        /*
            java.lang.Class<com.google.android.gms.internal.measurement.mk> r0 = com.google.android.gms.internal.measurement.mk.class
            monitor-enter(r0)
            java.lang.Boolean r1 = f10906h     // Catch:{ Exception -> 0x0052 }
            if (r1 == 0) goto L_0x000d
            java.lang.Boolean r1 = f10907i     // Catch:{ Exception -> 0x0052 }
            if (r1 == 0) goto L_0x000d
            monitor-exit(r0)     // Catch:{ all -> 0x0050 }
            return
        L_0x000d:
            java.lang.String r1 = "app_measurement_internal_disable_startup_flags"
            boolean r1 = a((android.content.Context) r3, (java.lang.String) r1)     // Catch:{ Exception -> 0x0052 }
            if (r1 == 0) goto L_0x001f
            java.lang.Boolean r3 = java.lang.Boolean.FALSE     // Catch:{ Exception -> 0x0052 }
            f10906h = r3     // Catch:{ Exception -> 0x0052 }
            java.lang.Boolean r3 = java.lang.Boolean.FALSE     // Catch:{ Exception -> 0x0052 }
            f10907i = r3     // Catch:{ Exception -> 0x0052 }
            monitor-exit(r0)     // Catch:{ all -> 0x0050 }
            return
        L_0x001f:
            java.lang.String r1 = "com.google.android.gms.measurement.prefs"
            r2 = 0
            android.content.SharedPreferences r3 = r3.getSharedPreferences(r1, r2)     // Catch:{ Exception -> 0x0052 }
            java.lang.String r1 = l     // Catch:{ Exception -> 0x0052 }
            boolean r1 = r3.getBoolean(r1, r2)     // Catch:{ Exception -> 0x0052 }
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r1)     // Catch:{ Exception -> 0x0052 }
            f10906h = r1     // Catch:{ Exception -> 0x0052 }
            java.lang.String r1 = m     // Catch:{ Exception -> 0x0052 }
            boolean r1 = r3.getBoolean(r1, r2)     // Catch:{ Exception -> 0x0052 }
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r1)     // Catch:{ Exception -> 0x0052 }
            f10907i = r1     // Catch:{ Exception -> 0x0052 }
            android.content.SharedPreferences$Editor r3 = r3.edit()     // Catch:{ Exception -> 0x0052 }
            java.lang.String r1 = l     // Catch:{ Exception -> 0x0052 }
            r3.remove(r1)     // Catch:{ Exception -> 0x0052 }
            java.lang.String r1 = m     // Catch:{ Exception -> 0x0052 }
            r3.remove(r1)     // Catch:{ Exception -> 0x0052 }
            r3.apply()     // Catch:{ Exception -> 0x0052 }
            goto L_0x005a
        L_0x0050:
            r3 = move-exception
            goto L_0x005c
        L_0x0052:
            java.lang.Boolean r3 = java.lang.Boolean.FALSE     // Catch:{ all -> 0x0050 }
            f10906h = r3     // Catch:{ all -> 0x0050 }
            java.lang.Boolean r3 = java.lang.Boolean.FALSE     // Catch:{ all -> 0x0050 }
            f10907i = r3     // Catch:{ all -> 0x0050 }
        L_0x005a:
            monitor-exit(r0)     // Catch:{ all -> 0x0050 }
            return
        L_0x005c:
            monitor-exit(r0)     // Catch:{ all -> 0x0050 }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.mk.g(android.content.Context):void");
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(4:18|19|20|21) */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0056, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
        k = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:?, code lost:
        j = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x006a, code lost:
        throw r0;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:18:0x0058 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean b(android.content.Context r8) {
        /*
            g(r8)
            java.lang.Class<com.google.android.gms.internal.measurement.mk> r8 = com.google.android.gms.internal.measurement.mk.class
            monitor-enter(r8)
            boolean r0 = j     // Catch:{ all -> 0x006b }
            if (r0 == 0) goto L_0x000c
            monitor-exit(r8)     // Catch:{ all -> 0x006b }
            goto L_0x005d
        L_0x000c:
            r0 = 0
            r1 = 1
            java.lang.String r2 = "android.os.SystemProperties"
            java.lang.Class r2 = java.lang.Class.forName(r2)     // Catch:{ Exception -> 0x0058 }
            java.lang.String r3 = "get"
            r4 = 2
            java.lang.Class[] r5 = new java.lang.Class[r4]     // Catch:{ Exception -> 0x0058 }
            java.lang.Class<java.lang.String> r6 = java.lang.String.class
            r7 = 0
            r5[r7] = r6     // Catch:{ Exception -> 0x0058 }
            java.lang.Class<java.lang.String> r6 = java.lang.String.class
            r5[r1] = r6     // Catch:{ Exception -> 0x0058 }
            java.lang.reflect.Method r2 = r2.getMethod(r3, r5)     // Catch:{ Exception -> 0x0058 }
            java.lang.Object[] r3 = new java.lang.Object[r4]     // Catch:{ Exception -> 0x0058 }
            java.lang.String r4 = "measurement.dynamite.enabled"
            r3[r7] = r4     // Catch:{ Exception -> 0x0058 }
            java.lang.String r4 = ""
            r3[r1] = r4     // Catch:{ Exception -> 0x0058 }
            java.lang.Object r2 = r2.invoke(r0, r3)     // Catch:{ Exception -> 0x0058 }
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ Exception -> 0x0058 }
            java.lang.String r3 = "true"
            boolean r3 = r3.equals(r2)     // Catch:{ Exception -> 0x0058 }
            if (r3 == 0) goto L_0x0044
            java.lang.Boolean r2 = java.lang.Boolean.TRUE     // Catch:{ Exception -> 0x0058 }
            k = r2     // Catch:{ Exception -> 0x0058 }
            goto L_0x0053
        L_0x0044:
            java.lang.String r3 = "false"
            boolean r2 = r3.equals(r2)     // Catch:{ Exception -> 0x0058 }
            if (r2 == 0) goto L_0x0051
            java.lang.Boolean r2 = java.lang.Boolean.FALSE     // Catch:{ Exception -> 0x0058 }
            k = r2     // Catch:{ Exception -> 0x0058 }
            goto L_0x0053
        L_0x0051:
            k = r0     // Catch:{ Exception -> 0x0058 }
        L_0x0053:
            j = r1     // Catch:{ all -> 0x006b }
            goto L_0x005c
        L_0x0056:
            r0 = move-exception
            goto L_0x0068
        L_0x0058:
            k = r0     // Catch:{ all -> 0x0056 }
            j = r1     // Catch:{ all -> 0x006b }
        L_0x005c:
            monitor-exit(r8)     // Catch:{ all -> 0x006b }
        L_0x005d:
            java.lang.Boolean r8 = k
            if (r8 != 0) goto L_0x0063
            java.lang.Boolean r8 = f10906h
        L_0x0063:
            boolean r8 = r8.booleanValue()
            return r8
        L_0x0068:
            j = r1     // Catch:{ all -> 0x006b }
            throw r0     // Catch:{ all -> 0x006b }
        L_0x006b:
            r0 = move-exception
            monitor-exit(r8)     // Catch:{ all -> 0x006b }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.mk.b(android.content.Context):boolean");
    }

    private static boolean a(Context context, String str) {
        s.a(str);
        try {
            ApplicationInfo a2 = com.google.android.gms.common.c.c.a(context).a(context.getPackageName(), 128);
            if (a2 != null) {
                if (a2.metaData != null) {
                    return a2.metaData.getBoolean(str);
                }
            }
        } catch (PackageManager.NameNotFoundException unused) {
        }
        return false;
    }
}
