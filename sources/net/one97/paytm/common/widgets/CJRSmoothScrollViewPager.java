package net.one97.paytm.common.widgets;

import android.content.Context;
import android.util.AttributeSet;
import android.view.animation.DecelerateInterpolator;
import android.widget.Scroller;
import androidx.viewpager.widget.ViewPager;
import com.paytm.utility.b;
import com.paytm.utility.q;
import java.lang.reflect.Field;

public class CJRSmoothScrollViewPager extends ViewPager {
    public CJRSmoothScrollViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        try {
            Field declaredField = ViewPager.class.getDeclaredField("mScroller");
            declaredField.setAccessible(true);
            declaredField.set(this, new a(getContext()));
        } catch (Exception e2) {
            if (b.v) {
                q.b(e2.getMessage());
            }
        }
    }

    public class a extends Scroller {
        public a(Context context) {
            super(context, new DecelerateInterpolator());
        }

        public final void startScroll(int i2, int i3, int i4, int i5, int i6) {
            super.startScroll(i2, i3, i4, i5, 1000);
        }
    }
}
