package net.one97.paytm.common.widgets;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.viewpager.widget.ViewPager;
import com.paytm.utility.b;
import com.paytm.utility.q;

public class CJRCustomViewPager extends ViewPager {
    public CJRCustomViewPager(Context context) {
        super(context);
    }

    public CJRCustomViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public boolean canScroll(View view, boolean z, int i2, int i3, int i4) {
        if (view != this) {
            try {
                if ((view instanceof ViewPager) && b.d() < 11) {
                    ViewPager viewPager = (ViewPager) view;
                    int currentItem = viewPager.getCurrentItem();
                    if (currentItem == viewPager.getAdapter().getCount() - 1 && i2 < 0) {
                        return false;
                    }
                    if (currentItem == 0) {
                        if (i2 > 0) {
                            return false;
                        }
                    }
                    return true;
                }
            } catch (Exception e2) {
                q.b(e2.getMessage());
                return false;
            }
        }
        if (view == this || !(view instanceof CJRHorizontalListView)) {
            return super.canScroll(view, z, i2, i3, i4);
        }
        CJRHorizontalListView cJRHorizontalListView = (CJRHorizontalListView) view;
        int count = cJRHorizontalListView.getAdapter().getCount();
        int lastVisiblePosition = cJRHorizontalListView.getLastVisiblePosition();
        int firstVisiblePosition = cJRHorizontalListView.getFirstVisiblePosition();
        if (lastVisiblePosition == count - 1 && i2 < 0 && cJRHorizontalListView.getChildAt(cJRHorizontalListView.getChildCount() - 1) != null && cJRHorizontalListView.getChildAt(cJRHorizontalListView.getChildCount() - 1).getRight() <= cJRHorizontalListView.getWidth()) {
            return false;
        }
        if (firstVisiblePosition == 0 && i2 > 0 && cJRHorizontalListView.getChildAt(0) != null) {
            if (cJRHorizontalListView.getChildAt(0).getLeft() >= 0) {
                return false;
            }
        }
        return true;
    }
}
