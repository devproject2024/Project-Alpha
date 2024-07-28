package net.one97.paytm.common.widgets;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.viewpager.widget.ViewPager;

public class CJRWrapContentViewPager extends ViewPager {

    /* renamed from: a  reason: collision with root package name */
    private View f49745a;

    public CJRWrapContentViewPager(Context context) {
        super(context);
    }

    public CJRWrapContentViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void onMeasure(int i2, int i3) {
        View view = this.f49745a;
        if (view == null) {
            super.onMeasure(i2, i3);
            return;
        }
        int i4 = 0;
        view.measure(i2, View.MeasureSpec.makeMeasureSpec(0, 0));
        int measuredHeight = this.f49745a.getMeasuredHeight();
        if (measuredHeight > 0) {
            i4 = measuredHeight;
        }
        super.onMeasure(i2, View.MeasureSpec.makeMeasureSpec(i4, 1073741824));
    }
}
