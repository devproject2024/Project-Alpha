package com.google.firebase.perf.internal;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.util.SparseIntArray;
import androidx.core.app.e;
import com.google.android.gms.internal.p001firebaseperf.al;
import com.google.android.gms.internal.p001firebaseperf.ar;
import com.google.android.gms.internal.p001firebaseperf.by;
import com.google.android.gms.internal.p001firebaseperf.dq;
import com.google.android.gms.internal.p001firebaseperf.v;
import com.google.android.gms.internal.p001firebaseperf.w;
import com.google.android.gms.internal.p001firebaseperf.x;
import com.google.android.gms.internal.p001firebaseperf.zzbg;
import com.google.firebase.perf.metrics.Trace;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class a implements Application.ActivityLifecycleCallbacks {

    /* renamed from: e  reason: collision with root package name */
    private static volatile a f39184e;

    /* renamed from: a  reason: collision with root package name */
    boolean f39185a = true;

    /* renamed from: b  reason: collision with root package name */
    AtomicInteger f39186b = new AtomicInteger(0);

    /* renamed from: c  reason: collision with root package name */
    ar f39187c = ar.BACKGROUND;

    /* renamed from: d  reason: collision with root package name */
    Set<WeakReference<C0658a>> f39188d = new HashSet();

    /* renamed from: f  reason: collision with root package name */
    private boolean f39189f = false;

    /* renamed from: g  reason: collision with root package name */
    private g f39190g = null;

    /* renamed from: h  reason: collision with root package name */
    private final v f39191h;

    /* renamed from: i  reason: collision with root package name */
    private final WeakHashMap<Activity, Boolean> f39192i = new WeakHashMap<>();
    private zzbg j;
    private zzbg k;
    private final Map<String, Long> l = new HashMap();
    private boolean m = false;
    private e n;
    private final WeakHashMap<Activity, Trace> o = new WeakHashMap<>();

    /* renamed from: com.google.firebase.perf.internal.a$a  reason: collision with other inner class name */
    public interface C0658a {
        void zza(ar arVar);
    }

    public static a a() {
        if (f39184e != null) {
            return f39184e;
        }
        return a(new v());
    }

    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    public void onActivityDestroyed(Activity activity) {
    }

    public void onActivityPaused(Activity activity) {
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    private static a a(v vVar) {
        if (f39184e == null) {
            synchronized (a.class) {
                if (f39184e == null) {
                    f39184e = new a(vVar);
                }
            }
        }
        return f39184e;
    }

    private a(v vVar) {
        this.f39191h = vVar;
        this.m = c();
        if (this.m) {
            this.n = new e();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0018, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void a(android.content.Context r2) {
        /*
            r1 = this;
            monitor-enter(r1)
            boolean r0 = r1.f39189f     // Catch:{ all -> 0x0019 }
            if (r0 == 0) goto L_0x0007
            monitor-exit(r1)
            return
        L_0x0007:
            android.content.Context r2 = r2.getApplicationContext()     // Catch:{ all -> 0x0019 }
            boolean r0 = r2 instanceof android.app.Application     // Catch:{ all -> 0x0019 }
            if (r0 == 0) goto L_0x0017
            android.app.Application r2 = (android.app.Application) r2     // Catch:{ all -> 0x0019 }
            r2.registerActivityLifecycleCallbacks(r1)     // Catch:{ all -> 0x0019 }
            r2 = 1
            r1.f39189f = r2     // Catch:{ all -> 0x0019 }
        L_0x0017:
            monitor-exit(r1)
            return
        L_0x0019:
            r2 = move-exception
            monitor-exit(r1)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.perf.internal.a.a(android.content.Context):void");
    }

    public final void a(String str) {
        synchronized (this.l) {
            Long l2 = this.l.get(str);
            if (l2 == null) {
                this.l.put(str, 1L);
            } else {
                this.l.put(str, Long.valueOf(l2.longValue() + 1));
            }
        }
    }

    public synchronized void onActivityStarted(Activity activity) {
        if (this.m) {
            this.n.f2691a.a(activity);
            b();
            Trace trace = new Trace(a(activity), this.f39190g, this.f39191h, this);
            trace.start();
            this.o.put(activity, trace);
        }
    }

    public synchronized void onActivityStopped(Activity activity) {
        Trace trace;
        int i2;
        int i3;
        int i4;
        SparseIntArray sparseIntArray;
        if (this.m && this.o.containsKey(activity) && (trace = this.o.get(activity)) != null) {
            this.o.remove(activity);
            SparseIntArray[] b2 = this.n.f2691a.b(activity);
            if (b2 == null || (sparseIntArray = b2[0]) == null) {
                i4 = 0;
                i3 = 0;
                i2 = 0;
            } else {
                i4 = 0;
                i3 = 0;
                i2 = 0;
                for (int i5 = 0; i5 < sparseIntArray.size(); i5++) {
                    int keyAt = sparseIntArray.keyAt(i5);
                    int valueAt = sparseIntArray.valueAt(i5);
                    i4 += valueAt;
                    if (keyAt > 700) {
                        i2 += valueAt;
                    }
                    if (keyAt > 16) {
                        i3 += valueAt;
                    }
                }
            }
            if (i4 > 0) {
                trace.incrementCounter(x.FRAMES_TOTAL.toString(), (long) i4);
            }
            if (i3 > 0) {
                trace.incrementCounter(x.FRAMES_SLOW.toString(), (long) i3);
            }
            if (i2 > 0) {
                trace.incrementCounter(x.FRAMES_FROZEN.toString(), (long) i2);
            }
            if (al.a(activity.getApplicationContext())) {
                String a2 = a(activity);
                StringBuilder sb = new StringBuilder(String.valueOf(a2).length() + 81);
                sb.append("sendScreenTrace name:");
                sb.append(a2);
                sb.append(" _fr_tot:");
                sb.append(i4);
                sb.append(" _fr_slo:");
                sb.append(i3);
                sb.append(" _fr_fzn:");
                sb.append(i2);
            }
            trace.stop();
        }
        if (this.f39192i.containsKey(activity)) {
            this.f39192i.remove(activity);
            if (this.f39192i.isEmpty()) {
                this.j = new zzbg();
                a(ar.BACKGROUND);
                a(false);
                a(w.FOREGROUND_TRACE_NAME.toString(), this.k, this.j);
            }
        }
    }

    public synchronized void onActivityResumed(Activity activity) {
        if (this.f39192i.isEmpty()) {
            this.k = new zzbg();
            this.f39192i.put(activity, Boolean.TRUE);
            if (this.f39185a) {
                a(ar.FOREGROUND);
                a(true);
                this.f39185a = false;
                return;
            }
            a(ar.FOREGROUND);
            a(true);
            a(w.BACKGROUND_TRACE_NAME.toString(), this.j, this.k);
            return;
        }
        this.f39192i.put(activity, Boolean.TRUE);
    }

    private final void a(ar arVar) {
        this.f39187c = arVar;
        synchronized (this.f39188d) {
            Iterator<WeakReference<C0658a>> it2 = this.f39188d.iterator();
            while (it2.hasNext()) {
                C0658a aVar = (C0658a) it2.next().get();
                if (aVar != null) {
                    aVar.zza(this.f39187c);
                } else {
                    it2.remove();
                }
            }
        }
    }

    private final void a(String str, zzbg zzbg, zzbg zzbg2) {
        b();
        by.a a2 = by.b().a(str).a(zzbg.f9736a).b(zzbg.a(zzbg2)).a(SessionManager.zzcl().zzcm().b());
        int andSet = this.f39186b.getAndSet(0);
        synchronized (this.l) {
            a2.a(this.l);
            if (andSet != 0) {
                a2.a(x.TRACE_STARTED_NOT_STOPPED.toString(), (long) andSet);
            }
            this.l.clear();
        }
        g gVar = this.f39190g;
        if (gVar != null) {
            gVar.a((by) ((dq) a2.k()), ar.FOREGROUND_BACKGROUND);
        }
    }

    private final void a(boolean z) {
        b();
        g gVar = this.f39190g;
        if (gVar != null) {
            gVar.a(z);
        }
    }

    private final void b() {
        if (this.f39190g == null) {
            this.f39190g = g.a();
        }
    }

    private static boolean c() {
        try {
            Class.forName("androidx.core.app.e");
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    private static String a(Activity activity) {
        String valueOf = String.valueOf(activity.getClass().getSimpleName());
        return valueOf.length() != 0 ? "_st_".concat(valueOf) : new String("_st_");
    }
}
