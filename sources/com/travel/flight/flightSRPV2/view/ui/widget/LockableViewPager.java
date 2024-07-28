package com.travel.flight.flightSRPV2.view.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.viewpager.widget.ViewPager;
import com.business.merchant_payments.common.utility.AppConstants;
import kotlin.g.b.k;

public final class LockableViewPager extends ViewPager {

    /* renamed from: a  reason: collision with root package name */
    private boolean f24327a;

    public final boolean getSwipeLocked() {
        return this.f24327a;
    }

    public final void setSwipeLocked(boolean z) {
        this.f24327a = z;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LockableViewPager(Context context) {
        super(context);
        k.c(context, "context");
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LockableViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        k.c(context, "context");
        k.c(attributeSet, "attrs");
    }

    public final boolean onTouchEvent(MotionEvent motionEvent) {
        k.c(motionEvent, AppConstants.NOTIFICATION_DETAILS.EVENT);
        return !this.f24327a && super.onTouchEvent(motionEvent);
    }

    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        k.c(motionEvent, AppConstants.NOTIFICATION_DETAILS.EVENT);
        return !this.f24327a && super.onInterceptTouchEvent(motionEvent);
    }

    public final boolean canScrollHorizontally(int i2) {
        return !this.f24327a && super.canScrollHorizontally(i2);
    }
}
