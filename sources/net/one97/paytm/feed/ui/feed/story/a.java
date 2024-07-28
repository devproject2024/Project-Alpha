package net.one97.paytm.feed.ui.feed.story;

import android.view.View;
import androidx.viewpager.widget.ViewPager;

public final class a implements ViewPager.f {
    public final void transformPage(View view, float f2) {
        view.setCameraDistance(20000.0f);
        if (f2 >= -1.0f) {
            if (f2 <= 0.0f) {
                view.setAlpha(1.0f);
                view.setPivotX((float) view.getWidth());
                view.setRotationY(Math.abs(f2) * 90.0f);
                return;
            } else if (f2 <= 1.0f) {
                view.setAlpha(1.0f);
                view.setPivotX(0.0f);
                view.setRotationY(Math.abs(f2) * -90.0f);
                return;
            }
        }
        view.setAlpha(0.0f);
    }
}
