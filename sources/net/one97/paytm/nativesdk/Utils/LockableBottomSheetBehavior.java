package net.one97.paytm.nativesdk.Utils;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.business.merchant_payments.common.utility.AppConstants;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import kotlin.g.b.k;

public final class LockableBottomSheetBehavior<V extends View> extends BottomSheetBehavior<V> {
    private boolean swipeEnabled;

    public LockableBottomSheetBehavior() {
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LockableBottomSheetBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        k.c(context, "context");
        k.c(attributeSet, "attrs");
    }

    public final boolean getSwipeEnabled() {
        return this.swipeEnabled;
    }

    public final void setSwipeEnabled(boolean z) {
        this.swipeEnabled = z;
    }

    public final boolean onInterceptTouchEvent(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        k.c(coordinatorLayout, "parent");
        k.c(v, "child");
        k.c(motionEvent, AppConstants.NOTIFICATION_DETAILS.EVENT);
        if (this.swipeEnabled) {
            return super.onInterceptTouchEvent(coordinatorLayout, v, motionEvent);
        }
        return false;
    }

    public final boolean onTouchEvent(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        k.c(coordinatorLayout, "parent");
        k.c(v, "child");
        k.c(motionEvent, AppConstants.NOTIFICATION_DETAILS.EVENT);
        if (this.swipeEnabled) {
            return super.onTouchEvent(coordinatorLayout, v, motionEvent);
        }
        return false;
    }

    public final boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, V v, View view, View view2, int i2, int i3) {
        k.c(coordinatorLayout, "coordinatorLayout");
        k.c(v, "child");
        k.c(view, "directTargetChild");
        k.c(view2, "target");
        if (this.swipeEnabled) {
            return super.onStartNestedScroll(coordinatorLayout, v, view, view2, i2, i3);
        }
        return false;
    }

    public final void onNestedPreScroll(CoordinatorLayout coordinatorLayout, V v, View view, int i2, int i3, int[] iArr, int i4) {
        k.c(coordinatorLayout, "coordinatorLayout");
        k.c(v, "child");
        k.c(view, "target");
        k.c(iArr, "consumed");
        if (this.swipeEnabled) {
            super.onNestedPreScroll(coordinatorLayout, v, view, i2, i3, iArr, i4);
        }
    }

    public final void onStopNestedScroll(CoordinatorLayout coordinatorLayout, V v, View view, int i2) {
        k.c(coordinatorLayout, "coordinatorLayout");
        k.c(v, "child");
        k.c(view, "target");
        if (this.swipeEnabled) {
            super.onStopNestedScroll(coordinatorLayout, v, view, i2);
        }
    }

    public final boolean onNestedPreFling(CoordinatorLayout coordinatorLayout, V v, View view, float f2, float f3) {
        k.c(coordinatorLayout, "coordinatorLayout");
        k.c(v, "child");
        k.c(view, "target");
        if (this.swipeEnabled) {
            return super.onNestedPreFling(coordinatorLayout, v, view, f2, f3);
        }
        return false;
    }
}
