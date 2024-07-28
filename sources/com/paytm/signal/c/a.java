package com.paytm.signal.c;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.g.b.k;

public final class a {

    /* renamed from: d  reason: collision with root package name */
    public static final C0747a f43618d = new C0747a((byte) 0);
    /* access modifiers changed from: private */
    public static a j;

    /* renamed from: a  reason: collision with root package name */
    public final ArrayList<b> f43619a;
    /* access modifiers changed from: package-private */

    /* renamed from: b  reason: collision with root package name */
    public boolean f43620b;

    /* renamed from: c  reason: collision with root package name */
    public Application.ActivityLifecycleCallbacks f43621c;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public Handler f43622e;

    /* renamed from: f  reason: collision with root package name */
    private Runnable f43623f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public int f43624g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public long f43625h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public WeakReference<Activity> f43626i;

    public interface b extends Application.ActivityLifecycleCallbacks {
    }

    public static class c implements b {
        public void onActivityCreated(Activity activity, Bundle bundle) {
            k.c(activity, "activity");
        }

        public void onActivityDestroyed(Activity activity) {
            k.c(activity, "activity");
        }

        public void onActivityPaused(Activity activity) {
            k.c(activity, "activity");
        }

        public void onActivityResumed(Activity activity) {
            k.c(activity, "activity");
        }

        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
            k.c(activity, "activity");
            k.c(bundle, "bundle");
        }

        public void onActivityStarted(Activity activity) {
            k.c(activity, "activity");
        }

        public void onActivityStopped(Activity activity) {
            k.c(activity, "activity");
        }
    }

    public /* synthetic */ a(byte b2) {
        this();
    }

    public static final /* synthetic */ Runnable c(a aVar) {
        Runnable runnable = aVar.f43623f;
        if (runnable == null) {
            k.a("backgroundRunnable");
        }
        return runnable;
    }

    private a() {
        this.f43622e = new Handler(Looper.getMainLooper());
        this.f43619a = new ArrayList<>();
        this.f43621c = new d(this);
        this.f43623f = new Runnable(this) {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ a f43627a;

            {
                this.f43627a = r1;
            }

            public final void run() {
                this.f43627a.f43620b = false;
                Iterator it2 = new ArrayList(this.f43627a.f43619a).iterator();
                while (it2.hasNext()) {
                    it2.next();
                    long unused = this.f43627a.f43625h;
                }
            }
        };
    }

    public static final class d implements Application.ActivityLifecycleCallbacks {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f43628a;

        d(a aVar) {
            this.f43628a = aVar;
        }

        public final void onActivityCreated(Activity activity, Bundle bundle) {
            k.c(activity, "activity");
            Iterator it2 = new ArrayList(this.f43628a.f43619a).iterator();
            while (it2.hasNext()) {
                b bVar = (b) it2.next();
                if (bVar != null) {
                    bVar.onActivityCreated(activity, bundle == null ? new Bundle() : bundle);
                }
            }
        }

        public final void onActivityStarted(Activity activity) {
            k.c(activity, "activity");
            this.f43628a.f43622e.removeCallbacks(a.c(this.f43628a));
            a aVar = this.f43628a;
            aVar.f43624g = aVar.f43624g + 1;
            if (!this.f43628a.f43620b) {
                this.f43628a.f43620b = true;
                System.currentTimeMillis();
                Iterator it2 = new ArrayList(this.f43628a.f43619a).iterator();
                while (it2.hasNext()) {
                    it2.next();
                }
            }
            Iterator it3 = new ArrayList(this.f43628a.f43619a).iterator();
            while (it3.hasNext()) {
                ((b) it3.next()).onActivityStarted(activity);
            }
        }

        public final void onActivityResumed(Activity activity) {
            k.c(activity, "activity");
            this.f43628a.f43626i = new WeakReference(activity);
            Iterator it2 = new ArrayList(this.f43628a.f43619a).iterator();
            while (it2.hasNext()) {
                ((b) it2.next()).onActivityResumed(activity);
            }
        }

        public final void onActivityPaused(Activity activity) {
            k.c(activity, "activity");
            this.f43628a.f43626i = null;
            Iterator it2 = new ArrayList(this.f43628a.f43619a).iterator();
            while (it2.hasNext()) {
                ((b) it2.next()).onActivityPaused(activity);
            }
        }

        public final void onActivityStopped(Activity activity) {
            k.c(activity, "activity");
            if (this.f43628a.f43624g > 0) {
                a aVar = this.f43628a;
                aVar.f43624g = aVar.f43624g - 1;
            }
            if (this.f43628a.f43624g == 0 && this.f43628a.f43620b) {
                this.f43628a.f43625h = System.currentTimeMillis() + 200;
                this.f43628a.f43622e.postDelayed(a.c(this.f43628a), 200);
            }
            Iterator it2 = new ArrayList(this.f43628a.f43619a).iterator();
            while (it2.hasNext()) {
                ((b) it2.next()).onActivityStopped(activity);
            }
        }

        public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
            k.c(activity, "activity");
            k.c(bundle, "bundle");
            Iterator it2 = new ArrayList(this.f43628a.f43619a).iterator();
            while (it2.hasNext()) {
                b bVar = (b) it2.next();
                if (bVar != null) {
                    bVar.onActivitySaveInstanceState(activity, bundle);
                }
            }
        }

        public final void onActivityDestroyed(Activity activity) {
            k.c(activity, "activity");
            Iterator it2 = new ArrayList(this.f43628a.f43619a).iterator();
            while (it2.hasNext()) {
                b bVar = (b) it2.next();
                if (bVar != null) {
                    bVar.onActivityDestroyed(activity);
                }
            }
        }
    }

    /* renamed from: com.paytm.signal.c.a$a  reason: collision with other inner class name */
    public static final class C0747a {
        private C0747a() {
        }

        public /* synthetic */ C0747a(byte b2) {
            this();
        }
    }
}
