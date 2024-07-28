package com.travel.train.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.viewpager.widget.ViewPager;

public class CJRWrapContentViewPager extends ViewPager {

    /* renamed from: a  reason: collision with root package name */
    public int f28339a = 20;

    public CJRWrapContentViewPager(Context context) {
        super(context);
    }

    public CJRWrapContentViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, View.MeasureSpec.makeMeasureSpec(this.f28339a, 1073741824));
    }
}
