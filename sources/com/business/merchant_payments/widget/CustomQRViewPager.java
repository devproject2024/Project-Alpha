package com.business.merchant_payments.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.viewpager.widget.ViewPager;

public class CustomQRViewPager extends ViewPager {
    public int mCurrentPagePosition = 0;

    public CustomQRViewPager(Context context) {
        super(context);
    }

    public CustomQRViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void onMeasure(int i2, int i3) {
        int i4 = 0;
        for (int i5 = 0; i5 < getChildCount(); i5++) {
            View childAt = getChildAt(i5);
            childAt.measure(i2, View.MeasureSpec.makeMeasureSpec(0, 0));
            int measuredHeight = childAt.getMeasuredHeight();
            if (measuredHeight > i4) {
                i4 = measuredHeight;
            }
        }
        super.onMeasure(i2, View.MeasureSpec.makeMeasureSpec(i4, 1073741824));
    }
}
