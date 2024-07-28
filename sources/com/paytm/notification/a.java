package com.paytm.notification;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import kotlin.g.b.k;
import kotlin.u;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final C0717a f42997a = new C0717a((byte) 0);
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public static a f42998b;

    public static class b implements Application.ActivityLifecycleCallbacks {
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

    public static void a(Context context) {
        k.c(context, "context");
    }

    public /* synthetic */ a(byte b2) {
        this();
    }

    private a() {
    }

    public static void a(Context context, b bVar) {
        k.c(context, "context");
        k.c(bVar, "listener");
        Context applicationContext = context.getApplicationContext();
        if (applicationContext != null) {
            ((Application) applicationContext).registerActivityLifecycleCallbacks(bVar);
            return;
        }
        throw new u("null cannot be cast to non-null type android.app.Application");
    }

    /* renamed from: com.paytm.notification.a$a  reason: collision with other inner class name */
    public static final class C0717a {
        private C0717a() {
        }

        public /* synthetic */ C0717a(byte b2) {
            this();
        }

        public static a a(Context context) {
            k.c(context, "context");
            if (a.f42998b != null) {
                a a2 = a.f42998b;
                if (a2 != null) {
                    return a2;
                }
                throw new u("null cannot be cast to non-null type com.paytm.notification.ActivityMonitor");
            }
            a.f42998b = new a((byte) 0);
            if (a.f42998b == null) {
                k.a();
            }
            a.a(context);
            a a3 = a.f42998b;
            if (a3 != null) {
                return a3;
            }
            throw new u("null cannot be cast to non-null type com.paytm.notification.ActivityMonitor");
        }
    }
}
