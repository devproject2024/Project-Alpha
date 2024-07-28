package androidx.core.app;

import android.app.Activity;
import android.app.Application;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;

final class c {

    /* renamed from: a  reason: collision with root package name */
    protected static final Class<?> f2668a = d();

    /* renamed from: b  reason: collision with root package name */
    protected static final Field f2669b = b();

    /* renamed from: c  reason: collision with root package name */
    protected static final Field f2670c = c();

    /* renamed from: d  reason: collision with root package name */
    protected static final Method f2671d = a(f2668a);

    /* renamed from: e  reason: collision with root package name */
    protected static final Method f2672e = b(f2668a);

    /* renamed from: f  reason: collision with root package name */
    protected static final Method f2673f = c(f2668a);

    /* renamed from: g  reason: collision with root package name */
    private static final Handler f2674g = new Handler(Looper.getMainLooper());

    static boolean a(Activity activity) {
        Object obj;
        final Application application;
        final a aVar;
        if (Build.VERSION.SDK_INT >= 28) {
            activity.recreate();
            return true;
        } else if (a() && f2673f == null) {
            return false;
        } else {
            if (f2672e == null && f2671d == null) {
                return false;
            }
            try {
                final Object obj2 = f2670c.get(activity);
                if (obj2 == null || (obj = f2669b.get(activity)) == null) {
                    return false;
                }
                application = activity.getApplication();
                aVar = new a(activity);
                application.registerActivityLifecycleCallbacks(aVar);
                f2674g.post(new Runnable() {
                    public final void run() {
                        a.this.f2681a = obj2;
                    }
                });
                if (a()) {
                    f2673f.invoke(obj, new Object[]{obj2, null, null, 0, Boolean.FALSE, null, null, Boolean.FALSE, Boolean.FALSE});
                } else {
                    activity.recreate();
                }
                f2674g.post(new Runnable() {
                    public final void run() {
                        application.unregisterActivityLifecycleCallbacks(aVar);
                    }
                });
                return true;
            } catch (Throwable unused) {
                return false;
            }
        }
    }

    static final class a implements Application.ActivityLifecycleCallbacks {

        /* renamed from: a  reason: collision with root package name */
        Object f2681a;

        /* renamed from: b  reason: collision with root package name */
        private Activity f2682b;

        /* renamed from: c  reason: collision with root package name */
        private final int f2683c;

        /* renamed from: d  reason: collision with root package name */
        private boolean f2684d = false;

        /* renamed from: e  reason: collision with root package name */
        private boolean f2685e = false;

        /* renamed from: f  reason: collision with root package name */
        private boolean f2686f = false;

        public final void onActivityCreated(Activity activity, Bundle bundle) {
        }

        public final void onActivityResumed(Activity activity) {
        }

        public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        public final void onActivityStopped(Activity activity) {
        }

        a(Activity activity) {
            this.f2682b = activity;
            this.f2683c = this.f2682b.hashCode();
        }

        public final void onActivityStarted(Activity activity) {
            if (this.f2682b == activity) {
                this.f2684d = true;
            }
        }

        public final void onActivityPaused(Activity activity) {
            if (this.f2685e && !this.f2686f && !this.f2684d && c.a(this.f2681a, this.f2683c, activity)) {
                this.f2686f = true;
                this.f2681a = null;
            }
        }

        public final void onActivityDestroyed(Activity activity) {
            if (this.f2682b == activity) {
                this.f2682b = null;
                this.f2685e = true;
            }
        }
    }

    protected static boolean a(Object obj, int i2, Activity activity) {
        try {
            final Object obj2 = f2670c.get(activity);
            if (obj2 == obj) {
                if (activity.hashCode() == i2) {
                    final Object obj3 = f2669b.get(activity);
                    f2674g.postAtFrontOfQueue(new Runnable() {
                        public final void run() {
                            try {
                                if (c.f2671d != null) {
                                    c.f2671d.invoke(obj3, new Object[]{obj2, Boolean.FALSE, "AppCompat recreation"});
                                    return;
                                }
                                c.f2672e.invoke(obj3, new Object[]{obj2, Boolean.FALSE});
                            } catch (RuntimeException e2) {
                                if (e2.getClass() == RuntimeException.class && e2.getMessage() != null && e2.getMessage().startsWith("Unable to stop")) {
                                    throw e2;
                                }
                            } catch (Throwable unused) {
                            }
                        }
                    });
                    return true;
                }
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    private static Method a(Class<?> cls) {
        if (cls == null) {
            return null;
        }
        try {
            Method declaredMethod = cls.getDeclaredMethod("performStopActivity", new Class[]{IBinder.class, Boolean.TYPE, String.class});
            declaredMethod.setAccessible(true);
            return declaredMethod;
        } catch (Throwable unused) {
            return null;
        }
    }

    private static Method b(Class<?> cls) {
        if (cls == null) {
            return null;
        }
        try {
            Method declaredMethod = cls.getDeclaredMethod("performStopActivity", new Class[]{IBinder.class, Boolean.TYPE});
            declaredMethod.setAccessible(true);
            return declaredMethod;
        } catch (Throwable unused) {
            return null;
        }
    }

    private static boolean a() {
        return Build.VERSION.SDK_INT == 26 || Build.VERSION.SDK_INT == 27;
    }

    private static Method c(Class<?> cls) {
        if (a() && cls != null) {
            try {
                Method declaredMethod = cls.getDeclaredMethod("requestRelaunchActivity", new Class[]{IBinder.class, List.class, List.class, Integer.TYPE, Boolean.TYPE, Configuration.class, Configuration.class, Boolean.TYPE, Boolean.TYPE});
                declaredMethod.setAccessible(true);
                return declaredMethod;
            } catch (Throwable unused) {
            }
        }
        return null;
    }

    private static Field b() {
        try {
            Field declaredField = Activity.class.getDeclaredField("mMainThread");
            declaredField.setAccessible(true);
            return declaredField;
        } catch (Throwable unused) {
            return null;
        }
    }

    private static Field c() {
        try {
            Field declaredField = Activity.class.getDeclaredField("mToken");
            declaredField.setAccessible(true);
            return declaredField;
        } catch (Throwable unused) {
            return null;
        }
    }

    private static Class<?> d() {
        try {
            return Class.forName("android.app.ActivityThread");
        } catch (Throwable unused) {
            return null;
        }
    }
}
