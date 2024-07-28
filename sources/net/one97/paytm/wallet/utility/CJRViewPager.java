package net.one97.paytm.wallet.utility;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.viewpager.widget.ViewPager;
import com.paytm.utility.q;

public class CJRViewPager extends ViewPager {

    /* renamed from: a  reason: collision with root package name */
    private int f72248a = 0;

    public CJRViewPager(Context context) {
        super(context);
    }

    public CJRViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void onMeasure(int i2, int i3) {
        try {
            View childAt = getChildAt(this.f72248a);
            if (childAt != null) {
                childAt.measure(i2, View.MeasureSpec.makeMeasureSpec(0, 0));
                i3 = View.MeasureSpec.makeMeasureSpec(childAt.getMeasuredHeight(), 1073741824);
                i2 = View.MeasureSpec.makeMeasureSpec(childAt.getMeasuredWidth(), 1073741824);
            }
        } catch (Exception e2) {
            q.d(String.valueOf(e2));
        }
        super.onMeasure(i2, i3);
    }
}
