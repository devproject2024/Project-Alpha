package com.business.merchant_payments.utility;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.appbar.AppBarLayout;
import kotlin.g.b.k;

public final class CustomScrollBehaviourMP extends AppBarLayout.Behavior {
    public boolean isShouldScroll = true;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CustomScrollBehaviourMP(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        k.d(context, "context");
        k.d(attributeSet, "attrs");
    }

    public final boolean isShouldScroll() {
        return this.isShouldScroll;
    }

    public final void setShouldScroll(boolean z) {
        this.isShouldScroll = z;
    }

    public final boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, View view2, int i2, int i3) {
        k.d(coordinatorLayout, "parent");
        k.d(appBarLayout, "child");
        k.d(view, "directTargetChild");
        k.d(view2, "target");
        return this.isShouldScroll;
    }

    public final boolean onTouchEvent(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, MotionEvent motionEvent) {
        k.d(coordinatorLayout, "parent");
        k.d(appBarLayout, "child");
        k.d(motionEvent, "ev");
        return this.isShouldScroll && super.onTouchEvent(coordinatorLayout, appBarLayout, motionEvent);
    }
}
