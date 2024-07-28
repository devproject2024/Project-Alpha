package net.one97.paytm.o2o.movies.utils;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.viewpager.widget.ViewPager;

public class DynamicHeightViewPager extends ViewPager {
    public DynamicHeightViewPager(Context context) {
        super(context);
        a();
    }

    public DynamicHeightViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    public void onMeasure(int i2, int i3) {
        View childAt = getChildAt(getCurrentItem());
        if (childAt != null) {
            childAt.measure(i2, View.MeasureSpec.makeMeasureSpec(0, 0));
            i3 = View.MeasureSpec.makeMeasureSpec(childAt.getMeasuredHeight(), 1073741824);
        }
        super.onMeasure(i2, i3);
    }

    private void a() {
        addOnPageChangeListener(new ViewPager.h() {
            public final void onPageSelected(int i2) {
                DynamicHeightViewPager.this.requestLayout();
            }
        });
    }
}
