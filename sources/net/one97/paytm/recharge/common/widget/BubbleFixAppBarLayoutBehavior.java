package net.one97.paytm.recharge.common.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.h.u;
import com.google.android.material.appbar.AppBarLayout;

public class BubbleFixAppBarLayoutBehavior extends AppBarLayout.Behavior {
    public /* synthetic */ void onNestedScroll(CoordinatorLayout coordinatorLayout, View view, View view2, int i2, int i3, int i4, int i5, int i6) {
        AppBarLayout appBarLayout = (AppBarLayout) view;
        super.onNestedScroll(coordinatorLayout, appBarLayout, view2, i2, i3, i4, i5, i6);
        View view3 = view2;
        a(i5, appBarLayout, view2, i6);
    }

    public BubbleFixAppBarLayoutBehavior() {
    }

    public BubbleFixAppBarLayoutBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void onNestedPreScroll(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, int i2, int i3, int[] iArr, int i4) {
        super.onNestedPreScroll(coordinatorLayout, appBarLayout, view, i2, i3, iArr, i4);
        a(i3, appBarLayout, view, i4);
    }

    private void a(int i2, AppBarLayout appBarLayout, View view, int i3) {
        if (i3 == 1) {
            int topAndBottomOffset = getTopAndBottomOffset();
            if ((i2 < 0 && topAndBottomOffset == 0) || (i2 > 0 && topAndBottomOffset == (-appBarLayout.getTotalScrollRange()))) {
                u.I(view);
            }
        }
    }
}
