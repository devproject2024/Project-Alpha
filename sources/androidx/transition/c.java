package androidx.transition;

import android.graphics.Rect;
import android.view.ViewGroup;

public final class c extends aq {

    /* renamed from: a  reason: collision with root package name */
    private float f4774a = 3.0f;

    public final long a(ViewGroup viewGroup, Transition transition, y yVar, y yVar2) {
        int i2;
        int i3;
        int i4;
        if (yVar == null && yVar2 == null) {
            return 0;
        }
        if (yVar2 == null || b(yVar) == 0) {
            i2 = -1;
        } else {
            yVar = yVar2;
            i2 = 1;
        }
        int a2 = aq.a(yVar, 0);
        int a3 = aq.a(yVar, 1);
        Rect f2 = transition.f();
        if (f2 != null) {
            i4 = f2.centerX();
            i3 = f2.centerY();
        } else {
            int[] iArr = new int[2];
            viewGroup.getLocationOnScreen(iArr);
            int round = Math.round(((float) (iArr[0] + (viewGroup.getWidth() / 2))) + viewGroup.getTranslationX());
            i3 = Math.round(((float) (iArr[1] + (viewGroup.getHeight() / 2))) + viewGroup.getTranslationY());
            i4 = round;
        }
        float a4 = a((float) a2, (float) a3, (float) i4, (float) i3) / a(0.0f, 0.0f, (float) viewGroup.getWidth(), (float) viewGroup.getHeight());
        long j = transition.f4692c;
        if (j < 0) {
            j = 300;
        }
        return (long) Math.round((((float) (j * ((long) i2))) / this.f4774a) * a4);
    }

    private static float a(float f2, float f3, float f4, float f5) {
        float f6 = f4 - f2;
        float f7 = f5 - f3;
        return (float) Math.sqrt((double) ((f6 * f6) + (f7 * f7)));
    }
}
