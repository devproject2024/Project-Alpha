package net.one97.paytm.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.viewpager.widget.ViewPager;

public class CJRCustomHomeViewPager extends ViewPager {
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return false;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        return false;
    }

    public CJRCustomHomeViewPager(Context context) {
        super(context);
    }

    public CJRCustomHomeViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
