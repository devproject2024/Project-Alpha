package net.one97.paytm.o2o.amusementpark.utils;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.viewpager.widget.ViewPager;

public class ParkViewPager extends ViewPager {

    /* renamed from: a  reason: collision with root package name */
    private int f73628a = 0;

    public ParkViewPager(Context context) {
        super(context);
    }

    public ParkViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void onMeasure(int i2, int i3) {
        try {
            View childAt = getChildAt(this.f73628a);
            if (childAt != null) {
                childAt.measure(i2, View.MeasureSpec.makeMeasureSpec(0, 0));
                i3 = View.MeasureSpec.makeMeasureSpec(childAt.getMeasuredHeight(), 1073741824);
                i2 = View.MeasureSpec.makeMeasureSpec(childAt.getMeasuredWidth(), 1073741824);
            }
        } catch (Exception unused) {
        }
        super.onMeasure(i2, i3);
    }
}
