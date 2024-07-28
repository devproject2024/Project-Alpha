package net.one97.paytm.common.widgets;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.appbar.AppBarLayout;

public final class FlingBehavior extends AppBarLayout.Behavior {

    /* renamed from: a  reason: collision with root package name */
    private boolean f49851a;

    public final /* synthetic */ boolean onNestedFling(CoordinatorLayout coordinatorLayout, View view, View view2, float f2, float f3, boolean z) {
        AppBarLayout appBarLayout = (AppBarLayout) view;
        if ((f3 > 0.0f && !this.f49851a) || (f3 < 0.0f && this.f49851a)) {
            f3 *= -1.0f;
        }
        float f4 = f3;
        if ((view2 instanceof RecyclerView) && f4 < 0.0f) {
            RecyclerView recyclerView = (RecyclerView) view2;
            z = recyclerView.getChildAdapterPosition(recyclerView.getChildAt(0)) > 3;
        }
        return super.onNestedFling(coordinatorLayout, appBarLayout, view2, f2, f4, z);
    }

    public final /* bridge */ /* synthetic */ void onNestedPreScroll(CoordinatorLayout coordinatorLayout, View view, View view2, int i2, int i3, int[] iArr) {
        super.onNestedPreScroll(coordinatorLayout, (AppBarLayout) view, view2, i2, i3, iArr);
        this.f49851a = i3 > 0;
    }

    public FlingBehavior() {
    }

    public FlingBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
