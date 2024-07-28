package androidx.transition;

import android.view.View;

class ak extends ap {

    /* renamed from: a  reason: collision with root package name */
    private static boolean f4757a = true;

    public final void b(View view) {
    }

    public final void c(View view) {
    }

    ak() {
    }

    public void a(View view, float f2) {
        if (f4757a) {
            try {
                view.setTransitionAlpha(f2);
                return;
            } catch (NoSuchMethodError unused) {
                f4757a = false;
            }
        }
        view.setAlpha(f2);
    }

    public float a(View view) {
        if (f4757a) {
            try {
                return view.getTransitionAlpha();
            } catch (NoSuchMethodError unused) {
                f4757a = false;
            }
        }
        return view.getAlpha();
    }
}
