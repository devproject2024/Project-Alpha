package net.one97.paytm.recharge.common.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.viewpager.widget.ViewPager;
import kotlin.g.b.k;

public final class CustomViewPager extends ViewPager {

    /* renamed from: a  reason: collision with root package name */
    private boolean f62104a = true;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CustomViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        k.c(context, "context");
        k.c(attributeSet, "attr");
    }

    public final boolean onTouchEvent(MotionEvent motionEvent) {
        try {
            if (this.f62104a) {
                return super.onTouchEvent(motionEvent);
            }
            return false;
        } catch (IllegalArgumentException unused) {
            return false;
        }
    }

    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        try {
            if (this.f62104a) {
                return super.onInterceptTouchEvent(motionEvent);
            }
        } catch (Exception unused) {
        }
        return false;
    }

    public final void setSwipeEnabled(boolean z) {
        this.f62104a = z;
    }

    public final void setOffscreenPageLimit(int i2) {
        super.setOffscreenPageLimit(i2);
    }
}
