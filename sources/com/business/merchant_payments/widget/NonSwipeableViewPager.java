package com.business.merchant_payments.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.animation.DecelerateInterpolator;
import android.widget.Scroller;
import androidx.viewpager.widget.ViewPager;
import java.lang.reflect.Field;

public class NonSwipeableViewPager extends ViewPager {
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return false;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        return false;
    }

    public NonSwipeableViewPager(Context context) {
        super(context);
    }

    public NonSwipeableViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    private void setMyScroller() {
        try {
            Field declaredField = ViewPager.class.getDeclaredField("mScroller");
            declaredField.setAccessible(true);
            declaredField.set(this, new MyScroller(this, getContext()));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public class MyScroller extends Scroller {
        public MyScroller(NonSwipeableViewPager nonSwipeableViewPager, Context context) {
            super(context, new DecelerateInterpolator());
        }

        public void startScroll(int i2, int i3, int i4, int i5, int i6) {
            super.startScroll(i2, i3, i4, i5, 350);
        }
    }
}
