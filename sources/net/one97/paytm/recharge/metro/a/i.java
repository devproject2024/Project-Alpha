package net.one97.paytm.recharge.metro.a;

import android.view.View;
import android.view.ViewParent;
import android.widget.TextView;
import androidx.viewpager.widget.ViewPager;
import com.alipay.mobile.h5container.api.H5Param;
import kotlin.g.b.k;
import kotlin.u;
import net.one97.paytm.recharge.R;

public final class i implements ViewPager.f {
    public final void transformPage(View view, float f2) {
        k.c(view, H5Param.PAGE);
        if (f2 >= -1.0f && f2 <= 1.0f) {
            ViewParent parent = view.getParent();
            if (parent != null) {
                ViewPager viewPager = (ViewPager) parent;
                int left = ((view.getLeft() - viewPager.getScrollX()) + (view.getMeasuredWidth() / 2)) - (viewPager.getMeasuredWidth() / 2);
                float abs = 1.0f - Math.abs((((float) left) * 0.25f) / ((float) viewPager.getMeasuredWidth()));
                TextView textView = (TextView) view.findViewById(R.id.tv_qr_msg);
                TextView textView2 = (TextView) view.findViewById(R.id.tv_ticket_time);
                if (abs > 0.0f) {
                    k.a((Object) textView, "txtQrMsg");
                    float f3 = (float) (-left);
                    textView.setTranslationX(f3);
                    k.a((Object) textView2, "txtValidity");
                    textView2.setTranslationX(f3);
                    return;
                }
                return;
            }
            throw new u("null cannot be cast to non-null type androidx.viewpager.widget.ViewPager");
        }
    }
}
