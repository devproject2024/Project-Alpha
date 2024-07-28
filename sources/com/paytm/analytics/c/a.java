package com.paytm.analytics.c;

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
    public static final C0685a f40935d = new C0685a((byte) 0);
    /* access modifiers changed from: private */
    public static a j;

    /* renamed from: a  reason: collision with root package name */
    public final ArrayList<b> f40936a;
    /* access modifiers changed from: package-private */

    /* renamed from: b  reason: collision with root package name */
    public boolean f40937b;

    /* renamed from: c  reason: collision with root package name */
    public Application.ActivityLifecycleCallbacks f40938c;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public Handler f40939e;

    /* renamed from: f  reason: collision with root package name */
    private Runnable f40940f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public int f40941g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public long f40942h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public WeakReference<Activity> f40943i;

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
        Runnable runnable = aVar.f40940f;
        if (runnable == null) {
            k.a("backgroundRunnable");
        }
        return runnable;
    }

    private a() {
        this.f40939e = new Handler(Looper.getMainLooper());
        this.f40936a = new ArrayList<>();
        this.f40938c = new d(this);
        this.f40940f = new Runnable(this) {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ a f40944a;

            {
                this.f40944a = r1;
            }

            public final void run() {
                this.f40944a.f40937b = false;
                Iterator it2 = new ArrayList(this.f40944a.f40936a).iterator();
                while (it2.hasNext()) {
                    it2.next();
                    long unused = this.f40944a.f40942h;
                }
            }
        };
    }

    public static final class d implements Application.ActivityLifecycleCallbacks {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f40945a;

        d(a aVar) {
            this.f40945a = aVar;
        }

        public final void onActivityCreated(Activity activity, Bundle bundle) {
            k.c(activity, "activity");
            Iterator it2 = new ArrayList(this.f40945a.f40936a).iterator();
            while (it2.hasNext()) {
                b bVar = (b) it2.next();
                if (bVar != null) {
                    bVar.onActivityCreated(activity, bundle == null ? new Bundle() : bundle);
                }
            }
        }

        public final void onActivityStarted(Activity activity) {
            k.c(activity, "activity");
            this.f40945a.f40939e.removeCallbacks(a.c(this.f40945a));
            a aVar = this.f40945a;
            aVar.f40941g = aVar.f40941g + 1;
            if (!this.f40945a.f40937b) {
                this.f40945a.f40937b = true;
                System.currentTimeMillis();
                Iterator it2 = new ArrayList(this.f40945a.f40936a).iterator();
                while (it2.hasNext()) {
                    it2.next();
                }
            }
            Iterator it3 = new ArrayList(this.f40945a.f40936a).iterator();
            while (it3.hasNext()) {
                ((b) it3.next()).onActivityStarted(activity);
            }
        }

        public final void onActivityResumed(Activity activity) {
            k.c(activity, "activity");
            this.f40945a.f40943i = new WeakReference(activity);
            Iterator it2 = new ArrayList(this.f40945a.f40936a).iterator();
            while (it2.hasNext()) {
                ((b) it2.next()).onActivityResumed(activity);
            }
        }

        public final void onActivityPaused(Activity activity) {
            k.c(activity, "activity");
            this.f40945a.f40943i = null;
            Iterator it2 = new ArrayList(this.f40945a.f40936a).iterator();
            while (it2.hasNext()) {
                ((b) it2.next()).onActivityPaused(activity);
            }
        }

        public final void onActivityStopped(Activity activity) {
            k.c(activity, "activity");
            if (this.f40945a.f40941g > 0) {
                a aVar = this.f40945a;
                aVar.f40941g = aVar.f40941g - 1;
            }
            if (this.f40945a.f40941g == 0 && this.f40945a.f40937b) {
                this.f40945a.f40942h = System.currentTimeMillis() + 200;
                this.f40945a.f40939e.postDelayed(a.c(this.f40945a), 200);
            }
            Iterator it2 = new ArrayList(this.f40945a.f40936a).iterator();
            while (it2.hasNext()) {
                ((b) it2.next()).onActivityStopped(activity);
            }
        }

        public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
            k.c(activity, "activity");
            k.c(bundle, "bundle");
            Iterator it2 = new ArrayList(this.f40945a.f40936a).iterator();
            while (it2.hasNext()) {
                b bVar = (b) it2.next();
                if (bVar != null) {
                    bVar.onActivitySaveInstanceState(activity, bundle);
                }
            }
        }

        public final void onActivityDestroyed(Activity activity) {
            k.c(activity, "activity");
            Iterator it2 = new ArrayList(this.f40945a.f40936a).iterator();
            while (it2.hasNext()) {
                b bVar = (b) it2.next();
                if (bVar != null) {
                    bVar.onActivityDestroyed(activity);
                }
            }
        }
    }

    /* renamed from: com.paytm.analytics.c.a$a  reason: collision with other inner class name */
    public static final class C0685a {
        private C0685a() {
        }

        public /* synthetic */ C0685a(byte b2) {
            this();
        }
    }
}
