package net.one97.paytm.wallet.utility;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.viewpager.widget.ViewPager;

public class CJRViewPagerAddmoney extends ViewPager {

    /* renamed from: a  reason: collision with root package name */
    private int f72249a = 0;

    public CJRViewPagerAddmoney(Context context) {
        super(context);
    }

    public CJRViewPagerAddmoney(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void onMeasure(int i2, int i3) {
        try {
            View childAt = getChildAt(this.f72249a);
            if (childAt != null) {
                childAt.measure(i2, View.MeasureSpec.makeMeasureSpec(0, 0));
                i3 = View.MeasureSpec.makeMeasureSpec(childAt.getMeasuredHeight(), 1073741824);
                i2 = View.MeasureSpec.makeMeasureSpec(childAt.getMeasuredWidth(), 1073741824);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        super.onMeasure(i2, i3);
    }
}
