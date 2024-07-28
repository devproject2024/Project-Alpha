package com.travel.customViews;

import android.view.View;
import androidx.viewpager.widget.ViewPager;
import kotlin.g.b.k;

public final class d implements ViewPager.f {

    /* renamed from: a  reason: collision with root package name */
    public static final a f23418a = new a((byte) 0);

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public final void transformPage(View view, float f2) {
        k.c(view, "view");
        int width = view.getWidth();
        int height = view.getHeight();
        if (f2 <= 1.0f) {
            float abs = 1.0f - Math.abs(f2);
            if (0.9f >= abs) {
                abs = 0.9f;
            }
            float f3 = 1.0f - abs;
            float f4 = (((float) height) * f3) / 2.0f;
            float f5 = (((float) width) * f3) / 2.0f;
            if (f2 < 0.0f) {
                view.setTranslationX(f5 - (f4 / 2.0f));
            } else {
                view.setTranslationX((-f5) + (f4 / 2.0f));
            }
            view.setScaleX(abs);
            view.setScaleY(abs);
        }
    }
}
