package com.google.android.gms.common.api.internal;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.Application;
import android.content.ComponentCallbacks2;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

public final class c implements Application.ActivityLifecycleCallbacks, ComponentCallbacks2 {

    /* renamed from: a  reason: collision with root package name */
    private static final c f8496a = new c();

    /* renamed from: b  reason: collision with root package name */
    private final AtomicBoolean f8497b = new AtomicBoolean();

    /* renamed from: c  reason: collision with root package name */
    private final AtomicBoolean f8498c = new AtomicBoolean();

    /* renamed from: d  reason: collision with root package name */
    private final ArrayList<a> f8499d = new ArrayList<>();

    /* renamed from: e  reason: collision with root package name */
    private boolean f8500e = false;

    public interface a {
        void a(boolean z);
    }

    private c() {
    }

    public final void onActivityDestroyed(Activity activity) {
    }

    public final void onActivityPaused(Activity activity) {
    }

    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public final void onActivityStarted(Activity activity) {
    }

    public final void onActivityStopped(Activity activity) {
    }

    public final void onConfigurationChanged(Configuration configuration) {
    }

    public final void onLowMemory() {
    }

    public static c a() {
        return f8496a;
    }

    public static void a(Application application) {
        synchronized (f8496a) {
            if (!f8496a.f8500e) {
                application.registerActivityLifecycleCallbacks(f8496a);
                application.registerComponentCallbacks(f8496a);
                f8496a.f8500e = true;
            }
        }
    }

    public final boolean b() {
        if (!this.f8498c.get()) {
            if (!(Build.VERSION.SDK_INT >= 16)) {
                return true;
            }
            ActivityManager.RunningAppProcessInfo runningAppProcessInfo = new ActivityManager.RunningAppProcessInfo();
            ActivityManager.getMyMemoryState(runningAppProcessInfo);
            if (!this.f8498c.getAndSet(true) && runningAppProcessInfo.importance > 100) {
                this.f8497b.set(true);
            }
        }
        return this.f8497b.get();
    }

    public final void a(a aVar) {
        synchronized (f8496a) {
            this.f8499d.add(aVar);
        }
    }

    public final void onActivityCreated(Activity activity, Bundle bundle) {
        boolean compareAndSet = this.f8497b.compareAndSet(true, false);
        this.f8498c.set(true);
        if (compareAndSet) {
            a(false);
        }
    }

    public final void onActivityResumed(Activity activity) {
        boolean compareAndSet = this.f8497b.compareAndSet(true, false);
        this.f8498c.set(true);
        if (compareAndSet) {
            a(false);
        }
    }

    public final void onTrimMemory(int i2) {
        if (i2 == 20 && this.f8497b.compareAndSet(false, true)) {
            this.f8498c.set(true);
            a(true);
        }
    }

    private final void a(boolean z) {
        synchronized (f8496a) {
            ArrayList arrayList = this.f8499d;
            int size = arrayList.size();
            int i2 = 0;
            while (i2 < size) {
                Object obj = arrayList.get(i2);
                i2++;
                ((a) obj).a(z);
            }
        }
    }
}
