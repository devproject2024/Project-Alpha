package net.one97.paytm.bankCommon.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.viewpager.widget.ViewPager;
import net.one97.paytm.bankOpen.R;

public class NonSwipeableViewPager extends ViewPager {

    /* renamed from: a  reason: collision with root package name */
    private boolean f16334a;

    public NonSwipeableViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.NonSwipeableViewPager);
        try {
            this.f16334a = obtainStyledAttributes.getBoolean(R.styleable.NonSwipeableViewPager_swipeable, true);
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.f16334a && super.onInterceptTouchEvent(motionEvent);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.f16334a && super.onTouchEvent(motionEvent);
    }
}
