package androidx.core.app;

import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public final class d {

    static class a {

        /* renamed from: a  reason: collision with root package name */
        private static Method f2687a;

        /* renamed from: b  reason: collision with root package name */
        private static boolean f2688b;

        /* renamed from: c  reason: collision with root package name */
        private static Method f2689c;

        /* renamed from: d  reason: collision with root package name */
        private static boolean f2690d;

        public static IBinder a(Bundle bundle, String str) {
            if (!f2688b) {
                try {
                    Method method = Bundle.class.getMethod("getIBinder", new Class[]{String.class});
                    f2687a = method;
                    method.setAccessible(true);
                } catch (NoSuchMethodException unused) {
                }
                f2688b = true;
            }
            Method method2 = f2687a;
            if (method2 != null) {
                try {
                    return (IBinder) method2.invoke(bundle, new Object[]{str});
                } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException unused2) {
                    f2687a = null;
                }
            }
            return null;
        }

        public static void a(Bundle bundle, String str, IBinder iBinder) {
            if (!f2690d) {
                try {
                    Method method = Bundle.class.getMethod("putIBinder", new Class[]{String.class, IBinder.class});
                    f2689c = method;
                    method.setAccessible(true);
                } catch (NoSuchMethodException unused) {
                }
                f2690d = true;
            }
            Method method2 = f2689c;
            if (method2 != null) {
                try {
                    method2.invoke(bundle, new Object[]{str, iBinder});
                } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException unused2) {
                    f2689c = null;
                }
            }
        }
    }

    public static IBinder a(Bundle bundle, String str) {
        if (Build.VERSION.SDK_INT >= 18) {
            return bundle.getBinder(str);
        }
        return a.a(bundle, str);
    }

    public static void a(Bundle bundle, String str, IBinder iBinder) {
        if (Build.VERSION.SDK_INT >= 18) {
            bundle.putBinder(str, iBinder);
        } else {
            a.a(bundle, str, iBinder);
        }
    }
}
