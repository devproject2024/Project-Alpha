package androidx.appcompat.widget;

import android.graphics.Rect;
import android.os.Build;
import android.view.View;
import androidx.core.h.u;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public final class ai {

    /* renamed from: a  reason: collision with root package name */
    private static Method f1706a;

    static {
        if (Build.VERSION.SDK_INT >= 18) {
            try {
                Method declaredMethod = View.class.getDeclaredMethod("computeFitSystemWindows", new Class[]{Rect.class, Rect.class});
                f1706a = declaredMethod;
                if (!declaredMethod.isAccessible()) {
                    f1706a.setAccessible(true);
                }
            } catch (NoSuchMethodException unused) {
            }
        }
    }

    public static boolean a(View view) {
        return u.j(view) == 1;
    }

    public static void a(View view, Rect rect, Rect rect2) {
        Method method = f1706a;
        if (method != null) {
            try {
                method.invoke(view, new Object[]{rect, rect2});
            } catch (Exception unused) {
            }
        }
    }

    public static void b(View view) {
        if (Build.VERSION.SDK_INT >= 16) {
            try {
                Method method = view.getClass().getMethod("makeOptionalFitsSystemWindows", new Class[0]);
                if (!method.isAccessible()) {
                    method.setAccessible(true);
                }
                method.invoke(view, new Object[0]);
            } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
            }
        }
    }
}
