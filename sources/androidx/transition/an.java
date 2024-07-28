package androidx.transition;

import android.os.Build;
import android.view.View;

class an extends am {

    /* renamed from: a  reason: collision with root package name */
    private static boolean f4762a = true;

    an() {
    }

    public void a(View view, int i2) {
        if (Build.VERSION.SDK_INT == 28) {
            super.a(view, i2);
        } else if (f4762a) {
            try {
                view.setTransitionVisibility(i2);
            } catch (NoSuchMethodError unused) {
                f4762a = false;
            }
        }
    }
}
