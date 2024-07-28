package net.one97.paytm.passbook.spendanalytics;

import android.view.View;
import androidx.viewpager.widget.ViewPager;
import kotlin.g.b.k;

public final class b implements ViewPager.f {

    /* renamed from: a  reason: collision with root package name */
    private final float f58554a = 0.85f;

    /* renamed from: b  reason: collision with root package name */
    private final float f58555b = 0.5f;

    public final void transformPage(View view, float f2) {
        k.c(view, "view");
        int width = view.getWidth();
        int height = view.getHeight();
        if (f2 < -1.0f || f2 > 1.0f) {
            view.setAlpha(0.0f);
            return;
        }
        float max = Math.max(this.f58554a, 1.0f - Math.abs(f2));
        float f3 = 1.0f - max;
        float f4 = (((float) height) * f3) / 2.0f;
        float f5 = (((float) width) * f3) / 2.0f;
        if (f2 < 0.0f) {
            view.setTranslationX(f5 - (f4 / 2.0f));
        } else {
            view.setTranslationX((-f5) + (f4 / 2.0f));
        }
        view.setScaleX(max);
        view.setScaleY(max);
        float f6 = this.f58555b;
        float f7 = this.f58554a;
        view.setAlpha(f6 + (((max - f7) / (1.0f - f7)) * (1.0f - f6)));
    }
}
