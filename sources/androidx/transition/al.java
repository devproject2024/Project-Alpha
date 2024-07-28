package androidx.transition;

import android.graphics.Matrix;
import android.view.View;

class al extends ak {

    /* renamed from: a  reason: collision with root package name */
    private static boolean f4758a = true;

    /* renamed from: b  reason: collision with root package name */
    private static boolean f4759b = true;

    /* renamed from: c  reason: collision with root package name */
    private static boolean f4760c = true;

    al() {
    }

    public void a(View view, Matrix matrix) {
        if (f4759b) {
            try {
                view.transformMatrixToGlobal(matrix);
            } catch (NoSuchMethodError unused) {
                f4759b = false;
            }
        }
    }

    public void b(View view, Matrix matrix) {
        if (f4760c) {
            try {
                view.transformMatrixToLocal(matrix);
            } catch (NoSuchMethodError unused) {
                f4760c = false;
            }
        }
    }

    public void c(View view, Matrix matrix) {
        if (f4758a) {
            try {
                view.setAnimationMatrix(matrix);
            } catch (NoSuchMethodError unused) {
                f4758a = false;
            }
        }
    }
}
