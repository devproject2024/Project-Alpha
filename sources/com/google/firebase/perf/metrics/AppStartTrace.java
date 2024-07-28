package com.google.firebase.perf.metrics;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.internal.p001firebaseperf.v;
import com.google.android.gms.internal.p001firebaseperf.zzbg;
import com.google.firebase.perf.internal.g;
import java.lang.ref.WeakReference;
import java.util.concurrent.TimeUnit;

public class AppStartTrace implements Application.ActivityLifecycleCallbacks {

    /* renamed from: a  reason: collision with root package name */
    private static final long f39257a = TimeUnit.MINUTES.toMicros(1);

    /* renamed from: b  reason: collision with root package name */
    private static volatile AppStartTrace f39258b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f39259c = false;

    /* renamed from: d  reason: collision with root package name */
    private g f39260d = null;

    /* renamed from: e  reason: collision with root package name */
    private final v f39261e;

    /* renamed from: f  reason: collision with root package name */
    private Context f39262f;

    /* renamed from: g  reason: collision with root package name */
    private WeakReference<Activity> f39263g;

    /* renamed from: h  reason: collision with root package name */
    private WeakReference<Activity> f39264h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f39265i = false;
    /* access modifiers changed from: private */
    public zzbg j = null;
    private zzbg k = null;
    private zzbg l = null;
    /* access modifiers changed from: private */
    public boolean m = false;

    public static void setLauncherActivityOnCreateTime(String str) {
    }

    public static void setLauncherActivityOnResumeTime(String str) {
    }

    public static void setLauncherActivityOnStartTime(String str) {
    }

    public void onActivityDestroyed(Activity activity) {
    }

    public void onActivityPaused(Activity activity) {
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public static class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private final AppStartTrace f39266a;

        public a(AppStartTrace appStartTrace) {
            this.f39266a = appStartTrace;
        }

        public final void run() {
            if (this.f39266a.j == null) {
                boolean unused = this.f39266a.m = true;
            }
        }
    }

    public static AppStartTrace a() {
        if (f39258b != null) {
            return f39258b;
        }
        return a(new v());
    }

    private static AppStartTrace a(v vVar) {
        if (f39258b == null) {
            synchronized (AppStartTrace.class) {
                if (f39258b == null) {
                    f39258b = new AppStartTrace(vVar);
                }
            }
        }
        return f39258b;
    }

    private AppStartTrace(v vVar) {
        this.f39261e = vVar;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x001b, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void a(android.content.Context r2) {
        /*
            r1 = this;
            monitor-enter(r1)
            boolean r0 = r1.f39259c     // Catch:{ all -> 0x001c }
            if (r0 == 0) goto L_0x0007
            monitor-exit(r1)
            return
        L_0x0007:
            android.content.Context r2 = r2.getApplicationContext()     // Catch:{ all -> 0x001c }
            boolean r0 = r2 instanceof android.app.Application     // Catch:{ all -> 0x001c }
            if (r0 == 0) goto L_0x001a
            r0 = r2
            android.app.Application r0 = (android.app.Application) r0     // Catch:{ all -> 0x001c }
            r0.registerActivityLifecycleCallbacks(r1)     // Catch:{ all -> 0x001c }
            r0 = 1
            r1.f39259c = r0     // Catch:{ all -> 0x001c }
            r1.f39262f = r2     // Catch:{ all -> 0x001c }
        L_0x001a:
            monitor-exit(r1)
            return
        L_0x001c:
            r2 = move-exception
            monitor-exit(r1)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.perf.metrics.AppStartTrace.a(android.content.Context):void");
    }

    private final synchronized void b() {
        if (this.f39259c) {
            ((Application) this.f39262f).unregisterActivityLifecycleCallbacks(this);
            this.f39259c = false;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0035, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0037, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void onActivityCreated(android.app.Activity r4, android.os.Bundle r5) {
        /*
            r3 = this;
            monitor-enter(r3)
            com.google.firebase.perf.internal.SessionManager r5 = com.google.firebase.perf.internal.SessionManager.zzcl()     // Catch:{ all -> 0x0038 }
            com.google.android.gms.internal.firebase-perf.ar r0 = com.google.android.gms.internal.p001firebaseperf.ar.FOREGROUND     // Catch:{ all -> 0x0038 }
            r5.zzc((com.google.android.gms.internal.p001firebaseperf.ar) r0)     // Catch:{ all -> 0x0038 }
            boolean r5 = r3.m     // Catch:{ all -> 0x0038 }
            if (r5 != 0) goto L_0x0036
            com.google.android.gms.internal.firebase-perf.zzbg r5 = r3.j     // Catch:{ all -> 0x0038 }
            if (r5 == 0) goto L_0x0013
            goto L_0x0036
        L_0x0013:
            java.lang.ref.WeakReference r5 = new java.lang.ref.WeakReference     // Catch:{ all -> 0x0038 }
            r5.<init>(r4)     // Catch:{ all -> 0x0038 }
            r3.f39263g = r5     // Catch:{ all -> 0x0038 }
            com.google.android.gms.internal.firebase-perf.zzbg r4 = new com.google.android.gms.internal.firebase-perf.zzbg     // Catch:{ all -> 0x0038 }
            r4.<init>()     // Catch:{ all -> 0x0038 }
            r3.j = r4     // Catch:{ all -> 0x0038 }
            com.google.android.gms.internal.firebase-perf.zzbg r4 = com.google.firebase.perf.provider.FirebasePerfProvider.zzcw()     // Catch:{ all -> 0x0038 }
            com.google.android.gms.internal.firebase-perf.zzbg r5 = r3.j     // Catch:{ all -> 0x0038 }
            long r4 = r4.a(r5)     // Catch:{ all -> 0x0038 }
            long r0 = f39257a     // Catch:{ all -> 0x0038 }
            int r2 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1))
            if (r2 <= 0) goto L_0x0034
            r4 = 1
            r3.f39265i = r4     // Catch:{ all -> 0x0038 }
        L_0x0034:
            monitor-exit(r3)
            return
        L_0x0036:
            monitor-exit(r3)
            return
        L_0x0038:
            r4 = move-exception
            monitor-exit(r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.perf.metrics.AppStartTrace.onActivityCreated(android.app.Activity, android.os.Bundle):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0018, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void onActivityStarted(android.app.Activity r1) {
        /*
            r0 = this;
            monitor-enter(r0)
            boolean r1 = r0.m     // Catch:{ all -> 0x0019 }
            if (r1 != 0) goto L_0x0017
            com.google.android.gms.internal.firebase-perf.zzbg r1 = r0.k     // Catch:{ all -> 0x0019 }
            if (r1 != 0) goto L_0x0017
            boolean r1 = r0.f39265i     // Catch:{ all -> 0x0019 }
            if (r1 == 0) goto L_0x000e
            goto L_0x0017
        L_0x000e:
            com.google.android.gms.internal.firebase-perf.zzbg r1 = new com.google.android.gms.internal.firebase-perf.zzbg     // Catch:{ all -> 0x0019 }
            r1.<init>()     // Catch:{ all -> 0x0019 }
            r0.k = r1     // Catch:{ all -> 0x0019 }
            monitor-exit(r0)
            return
        L_0x0017:
            monitor-exit(r0)
            return
        L_0x0019:
            r1 = move-exception
            monitor-exit(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.perf.metrics.AppStartTrace.onActivityStarted(android.app.Activity):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0130, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0132, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void onActivityResumed(android.app.Activity r6) {
        /*
            r5 = this;
            monitor-enter(r5)
            boolean r0 = r5.m     // Catch:{ all -> 0x0133 }
            if (r0 != 0) goto L_0x0131
            com.google.android.gms.internal.firebase-perf.zzbg r0 = r5.l     // Catch:{ all -> 0x0133 }
            if (r0 != 0) goto L_0x0131
            boolean r0 = r5.f39265i     // Catch:{ all -> 0x0133 }
            if (r0 == 0) goto L_0x000f
            goto L_0x0131
        L_0x000f:
            java.lang.ref.WeakReference r0 = new java.lang.ref.WeakReference     // Catch:{ all -> 0x0133 }
            r0.<init>(r6)     // Catch:{ all -> 0x0133 }
            r5.f39264h = r0     // Catch:{ all -> 0x0133 }
            com.google.android.gms.internal.firebase-perf.zzbg r0 = new com.google.android.gms.internal.firebase-perf.zzbg     // Catch:{ all -> 0x0133 }
            r0.<init>()     // Catch:{ all -> 0x0133 }
            r5.l = r0     // Catch:{ all -> 0x0133 }
            com.google.android.gms.internal.firebase-perf.zzbg r0 = com.google.firebase.perf.provider.FirebasePerfProvider.zzcw()     // Catch:{ all -> 0x0133 }
            java.lang.Class r6 = r6.getClass()     // Catch:{ all -> 0x0133 }
            java.lang.String r6 = r6.getName()     // Catch:{ all -> 0x0133 }
            com.google.android.gms.internal.firebase-perf.zzbg r1 = r5.l     // Catch:{ all -> 0x0133 }
            long r1 = r0.a(r1)     // Catch:{ all -> 0x0133 }
            java.lang.String r3 = java.lang.String.valueOf(r6)     // Catch:{ all -> 0x0133 }
            int r3 = r3.length()     // Catch:{ all -> 0x0133 }
            int r3 = r3 + 47
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0133 }
            r4.<init>(r3)     // Catch:{ all -> 0x0133 }
            java.lang.String r3 = "onResume(): "
            r4.append(r3)     // Catch:{ all -> 0x0133 }
            r4.append(r6)     // Catch:{ all -> 0x0133 }
            java.lang.String r6 = ": "
            r4.append(r6)     // Catch:{ all -> 0x0133 }
            r4.append(r1)     // Catch:{ all -> 0x0133 }
            java.lang.String r6 = " microseconds"
            r4.append(r6)     // Catch:{ all -> 0x0133 }
            com.google.android.gms.internal.firebase-perf.by$a r6 = com.google.android.gms.internal.p001firebaseperf.by.b()     // Catch:{ all -> 0x0133 }
            com.google.android.gms.internal.firebase-perf.w r1 = com.google.android.gms.internal.p001firebaseperf.w.APP_START_TRACE_NAME     // Catch:{ all -> 0x0133 }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x0133 }
            com.google.android.gms.internal.firebase-perf.by$a r6 = r6.a((java.lang.String) r1)     // Catch:{ all -> 0x0133 }
            long r1 = r0.f9736a     // Catch:{ all -> 0x0133 }
            com.google.android.gms.internal.firebase-perf.by$a r6 = r6.a((long) r1)     // Catch:{ all -> 0x0133 }
            com.google.android.gms.internal.firebase-perf.zzbg r1 = r5.l     // Catch:{ all -> 0x0133 }
            long r1 = r0.a(r1)     // Catch:{ all -> 0x0133 }
            com.google.android.gms.internal.firebase-perf.by$a r6 = r6.b((long) r1)     // Catch:{ all -> 0x0133 }
            java.util.ArrayList r1 = new java.util.ArrayList     // Catch:{ all -> 0x0133 }
            r2 = 3
            r1.<init>(r2)     // Catch:{ all -> 0x0133 }
            com.google.android.gms.internal.firebase-perf.by$a r2 = com.google.android.gms.internal.p001firebaseperf.by.b()     // Catch:{ all -> 0x0133 }
            com.google.android.gms.internal.firebase-perf.w r3 = com.google.android.gms.internal.p001firebaseperf.w.ON_CREATE_TRACE_NAME     // Catch:{ all -> 0x0133 }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x0133 }
            com.google.android.gms.internal.firebase-perf.by$a r2 = r2.a((java.lang.String) r3)     // Catch:{ all -> 0x0133 }
            long r3 = r0.f9736a     // Catch:{ all -> 0x0133 }
            com.google.android.gms.internal.firebase-perf.by$a r2 = r2.a((long) r3)     // Catch:{ all -> 0x0133 }
            com.google.android.gms.internal.firebase-perf.zzbg r3 = r5.j     // Catch:{ all -> 0x0133 }
            long r3 = r0.a(r3)     // Catch:{ all -> 0x0133 }
            com.google.android.gms.internal.firebase-perf.by$a r0 = r2.b((long) r3)     // Catch:{ all -> 0x0133 }
            com.google.android.gms.internal.firebase-perf.ex r0 = r0.k()     // Catch:{ all -> 0x0133 }
            com.google.android.gms.internal.firebase-perf.dq r0 = (com.google.android.gms.internal.p001firebaseperf.dq) r0     // Catch:{ all -> 0x0133 }
            com.google.android.gms.internal.firebase-perf.by r0 = (com.google.android.gms.internal.p001firebaseperf.by) r0     // Catch:{ all -> 0x0133 }
            r1.add(r0)     // Catch:{ all -> 0x0133 }
            com.google.android.gms.internal.firebase-perf.by$a r0 = com.google.android.gms.internal.p001firebaseperf.by.b()     // Catch:{ all -> 0x0133 }
            com.google.android.gms.internal.firebase-perf.w r2 = com.google.android.gms.internal.p001firebaseperf.w.ON_START_TRACE_NAME     // Catch:{ all -> 0x0133 }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x0133 }
            com.google.android.gms.internal.firebase-perf.by$a r2 = r0.a((java.lang.String) r2)     // Catch:{ all -> 0x0133 }
            com.google.android.gms.internal.firebase-perf.zzbg r3 = r5.j     // Catch:{ all -> 0x0133 }
            long r3 = r3.f9736a     // Catch:{ all -> 0x0133 }
            com.google.android.gms.internal.firebase-perf.by$a r2 = r2.a((long) r3)     // Catch:{ all -> 0x0133 }
            com.google.android.gms.internal.firebase-perf.zzbg r3 = r5.j     // Catch:{ all -> 0x0133 }
            com.google.android.gms.internal.firebase-perf.zzbg r4 = r5.k     // Catch:{ all -> 0x0133 }
            long r3 = r3.a(r4)     // Catch:{ all -> 0x0133 }
            r2.b((long) r3)     // Catch:{ all -> 0x0133 }
            com.google.android.gms.internal.firebase-perf.ex r0 = r0.k()     // Catch:{ all -> 0x0133 }
            com.google.android.gms.internal.firebase-perf.dq r0 = (com.google.android.gms.internal.p001firebaseperf.dq) r0     // Catch:{ all -> 0x0133 }
            com.google.android.gms.internal.firebase-perf.by r0 = (com.google.android.gms.internal.p001firebaseperf.by) r0     // Catch:{ all -> 0x0133 }
            r1.add(r0)     // Catch:{ all -> 0x0133 }
            com.google.android.gms.internal.firebase-perf.by$a r0 = com.google.android.gms.internal.p001firebaseperf.by.b()     // Catch:{ all -> 0x0133 }
            com.google.android.gms.internal.firebase-perf.w r2 = com.google.android.gms.internal.p001firebaseperf.w.ON_RESUME_TRACE_NAME     // Catch:{ all -> 0x0133 }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x0133 }
            com.google.android.gms.internal.firebase-perf.by$a r2 = r0.a((java.lang.String) r2)     // Catch:{ all -> 0x0133 }
            com.google.android.gms.internal.firebase-perf.zzbg r3 = r5.k     // Catch:{ all -> 0x0133 }
            long r3 = r3.f9736a     // Catch:{ all -> 0x0133 }
            com.google.android.gms.internal.firebase-perf.by$a r2 = r2.a((long) r3)     // Catch:{ all -> 0x0133 }
            com.google.android.gms.internal.firebase-perf.zzbg r3 = r5.k     // Catch:{ all -> 0x0133 }
            com.google.android.gms.internal.firebase-perf.zzbg r4 = r5.l     // Catch:{ all -> 0x0133 }
            long r3 = r3.a(r4)     // Catch:{ all -> 0x0133 }
            r2.b((long) r3)     // Catch:{ all -> 0x0133 }
            com.google.android.gms.internal.firebase-perf.ex r0 = r0.k()     // Catch:{ all -> 0x0133 }
            com.google.android.gms.internal.firebase-perf.dq r0 = (com.google.android.gms.internal.p001firebaseperf.dq) r0     // Catch:{ all -> 0x0133 }
            com.google.android.gms.internal.firebase-perf.by r0 = (com.google.android.gms.internal.p001firebaseperf.by) r0     // Catch:{ all -> 0x0133 }
            r1.add(r0)     // Catch:{ all -> 0x0133 }
            com.google.android.gms.internal.firebase-perf.by$a r0 = r6.a((java.lang.Iterable<? extends com.google.android.gms.internal.p001firebaseperf.by>) r1)     // Catch:{ all -> 0x0133 }
            com.google.firebase.perf.internal.SessionManager r1 = com.google.firebase.perf.internal.SessionManager.zzcl()     // Catch:{ all -> 0x0133 }
            com.google.firebase.perf.internal.zzs r1 = r1.zzcm()     // Catch:{ all -> 0x0133 }
            com.google.android.gms.internal.firebase-perf.bq r1 = r1.b()     // Catch:{ all -> 0x0133 }
            r0.a((com.google.android.gms.internal.p001firebaseperf.bq) r1)     // Catch:{ all -> 0x0133 }
            com.google.firebase.perf.internal.g r0 = r5.f39260d     // Catch:{ all -> 0x0133 }
            if (r0 != 0) goto L_0x0115
            com.google.firebase.perf.internal.g r0 = com.google.firebase.perf.internal.g.a()     // Catch:{ all -> 0x0133 }
            r5.f39260d = r0     // Catch:{ all -> 0x0133 }
        L_0x0115:
            com.google.firebase.perf.internal.g r0 = r5.f39260d     // Catch:{ all -> 0x0133 }
            if (r0 == 0) goto L_0x0128
            com.google.firebase.perf.internal.g r0 = r5.f39260d     // Catch:{ all -> 0x0133 }
            com.google.android.gms.internal.firebase-perf.ex r6 = r6.k()     // Catch:{ all -> 0x0133 }
            com.google.android.gms.internal.firebase-perf.dq r6 = (com.google.android.gms.internal.p001firebaseperf.dq) r6     // Catch:{ all -> 0x0133 }
            com.google.android.gms.internal.firebase-perf.by r6 = (com.google.android.gms.internal.p001firebaseperf.by) r6     // Catch:{ all -> 0x0133 }
            com.google.android.gms.internal.firebase-perf.ar r1 = com.google.android.gms.internal.p001firebaseperf.ar.FOREGROUND_BACKGROUND     // Catch:{ all -> 0x0133 }
            r0.a((com.google.android.gms.internal.p001firebaseperf.by) r6, (com.google.android.gms.internal.p001firebaseperf.ar) r1)     // Catch:{ all -> 0x0133 }
        L_0x0128:
            boolean r6 = r5.f39259c     // Catch:{ all -> 0x0133 }
            if (r6 == 0) goto L_0x012f
            r5.b()     // Catch:{ all -> 0x0133 }
        L_0x012f:
            monitor-exit(r5)
            return
        L_0x0131:
            monitor-exit(r5)
            return
        L_0x0133:
            r6 = move-exception
            monitor-exit(r5)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.perf.metrics.AppStartTrace.onActivityResumed(android.app.Activity):void");
    }

    public synchronized void onActivityStopped(Activity activity) {
    }
}
