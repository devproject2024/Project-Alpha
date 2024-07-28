package net.one97.paytm.recharge.common.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import net.one97.paytm.common.widgets.CJRCustomViewPager;

public class CJRUnScrollableViewPager extends CJRCustomViewPager {

    /* renamed from: a  reason: collision with root package name */
    public View f61973a;

    /* renamed from: b  reason: collision with root package name */
    public int f61974b = 1;

    /* renamed from: c  reason: collision with root package name */
    private int f61975c = 1;

    public CJRUnScrollableViewPager(Context context) {
        super(context);
    }

    public CJRUnScrollableViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void onMeasure(int i2, int i3) {
        View view = this.f61973a;
        if (view == null) {
            super.onMeasure(i2, i3);
            return;
        }
        int i4 = 0;
        view.measure(i2, View.MeasureSpec.makeMeasureSpec(0, 0));
        int measuredHeight = this.f61973a.getMeasuredHeight();
        if (measuredHeight > 0) {
            if (this.f61975c == 0) {
                measuredHeight *= this.f61974b;
            }
            i4 = measuredHeight;
        }
        super.onMeasure(i2, View.MeasureSpec.makeMeasureSpec(i4, 1073741824));
    }

    public void setViewType(int i2) {
        this.f61975c = i2;
    }
}
