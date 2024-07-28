package androidx.transition;

import android.graphics.Matrix;
import android.view.View;
import android.view.ViewGroup;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

final class h implements f {

    /* renamed from: a  reason: collision with root package name */
    static Class<?> f4792a;

    /* renamed from: b  reason: collision with root package name */
    static Method f4793b;

    /* renamed from: c  reason: collision with root package name */
    static boolean f4794c;

    /* renamed from: d  reason: collision with root package name */
    private static boolean f4795d;

    /* renamed from: e  reason: collision with root package name */
    private static Method f4796e;

    /* renamed from: f  reason: collision with root package name */
    private static boolean f4797f;

    /* renamed from: g  reason: collision with root package name */
    private final View f4798g;

    public final void a(ViewGroup viewGroup, View view) {
    }

    private h(View view) {
        this.f4798g = view;
    }

    public final void setVisibility(int i2) {
        this.f4798g.setVisibility(i2);
    }

    static void a() {
        if (!f4795d) {
            try {
                f4792a = Class.forName("android.view.GhostView");
            } catch (ClassNotFoundException unused) {
            }
            f4795d = true;
        }
    }

    static f a(View view, ViewGroup viewGroup, Matrix matrix) {
        if (!f4797f) {
            try {
                a();
                Method declaredMethod = f4792a.getDeclaredMethod("addGhost", new Class[]{View.class, ViewGroup.class, Matrix.class});
                f4796e = declaredMethod;
                declaredMethod.setAccessible(true);
            } catch (NoSuchMethodException unused) {
            }
            f4797f = true;
        }
        Method method = f4796e;
        if (method != null) {
            try {
                return new h((View) method.invoke((Object) null, new Object[]{view, viewGroup, matrix}));
            } catch (IllegalAccessException unused2) {
            } catch (InvocationTargetException e2) {
                throw new RuntimeException(e2.getCause());
            }
        }
        return null;
    }
}
