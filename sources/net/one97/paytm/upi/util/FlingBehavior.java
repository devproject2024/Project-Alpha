package net.one97.paytm.upi.util;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.appbar.AppBarLayout;

public final class FlingBehavior extends AppBarLayout.Behavior {
    private static final int TOP_CHILD_FLING_THRESHOLD = 3;
    private boolean isPositive;

    public FlingBehavior() {
    }

    public FlingBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public final boolean onNestedFling(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, float f2, float f3, boolean z) {
        if ((f3 > 0.0f && !this.isPositive) || (f3 < 0.0f && this.isPositive)) {
            f3 *= -1.0f;
        }
        float f4 = f3;
        if ((view instanceof RecyclerView) && f4 < 0.0f) {
            RecyclerView recyclerView = (RecyclerView) view;
            z = false;
            if (recyclerView.getChildAdapterPosition(recyclerView.getChildAt(0)) > 3) {
                z = true;
            }
        }
        return super.onNestedFling(coordinatorLayout, appBarLayout, view, f2, f4, z);
    }

    public final void onNestedPreScroll(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, int i2, int i3, int[] iArr) {
        super.onNestedPreScroll(coordinatorLayout, appBarLayout, view, i2, i3, iArr);
        this.isPositive = i3 > 0;
    }
}
