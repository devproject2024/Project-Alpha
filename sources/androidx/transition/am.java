package androidx.transition;

import android.view.View;

class am extends al {

    /* renamed from: a  reason: collision with root package name */
    private static boolean f4761a = true;

    am() {
    }

    public void a(View view, int i2, int i3, int i4, int i5) {
        if (f4761a) {
            try {
                view.setLeftTopRightBottom(i2, i3, i4, i5);
            } catch (NoSuchMethodError unused) {
                f4761a = false;
            }
        }
    }
}
