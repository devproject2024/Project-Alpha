package net.one97.paytm.games.view.pfg.banner;

import android.view.View;
import androidx.viewpager.widget.ViewPager;

public final class a implements ViewPager.f {
    public final void transformPage(View view, float f2) {
        if (f2 < -1.0f) {
            f2 = -1.0f;
        } else if (f2 > 1.0f) {
            f2 = 1.0f;
        }
        view.setScaleY(((f2 < 0.0f ? f2 + 1.0f : 1.0f - f2) * 0.1f) + 0.9f);
    }
}
