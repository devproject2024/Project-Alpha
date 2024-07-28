package androidx.transition;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.os.Build;
import android.util.Property;
import android.view.View;
import androidx.core.h.u;

final class aj {

    /* renamed from: a  reason: collision with root package name */
    static final Property<View, Float> f4754a = new Property<View, Float>(Float.class, "translationAlpha") {
        public final /* synthetic */ Object get(Object obj) {
            return Float.valueOf(aj.c((View) obj));
        }

        public final /* synthetic */ void set(Object obj, Object obj2) {
            aj.a((View) obj, ((Float) obj2).floatValue());
        }
    };

    /* renamed from: b  reason: collision with root package name */
    static final Property<View, Rect> f4755b = new Property<View, Rect>(Rect.class, "clipBounds") {
        public final /* synthetic */ Object get(Object obj) {
            return u.L((View) obj);
        }

        public final /* synthetic */ void set(Object obj, Object obj2) {
            u.a((View) obj, (Rect) obj2);
        }
    };

    /* renamed from: c  reason: collision with root package name */
    private static final ap f4756c;

    static {
        if (Build.VERSION.SDK_INT >= 29) {
            f4756c = new ao();
        } else if (Build.VERSION.SDK_INT >= 23) {
            f4756c = new an();
        } else if (Build.VERSION.SDK_INT >= 22) {
            f4756c = new am();
        } else if (Build.VERSION.SDK_INT >= 21) {
            f4756c = new al();
        } else if (Build.VERSION.SDK_INT >= 19) {
            f4756c = new ak();
        } else {
            f4756c = new ap();
        }
    }

    static ai a(View view) {
        if (Build.VERSION.SDK_INT >= 18) {
            return new ah(view);
        }
        return ag.c(view);
    }

    static at b(View view) {
        if (Build.VERSION.SDK_INT >= 18) {
            return new as(view);
        }
        return new ar(view.getWindowToken());
    }

    static void a(View view, float f2) {
        f4756c.a(view, f2);
    }

    static float c(View view) {
        return f4756c.a(view);
    }

    static void d(View view) {
        f4756c.b(view);
    }

    static void e(View view) {
        f4756c.c(view);
    }

    static void a(View view, int i2) {
        f4756c.a(view, i2);
    }

    static void a(View view, Matrix matrix) {
        f4756c.a(view, matrix);
    }

    static void b(View view, Matrix matrix) {
        f4756c.b(view, matrix);
    }

    static void c(View view, Matrix matrix) {
        f4756c.c(view, matrix);
    }

    static void a(View view, int i2, int i3, int i4, int i5) {
        f4756c.a(view, i2, i3, i4, i5);
    }
}
