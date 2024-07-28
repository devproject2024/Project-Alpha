package net.one97.paytm.upi.util;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.DatePicker;
import android.widget.TimePicker;
import androidx.viewpager.widget.ViewPager;
import net.one97.paytm.upi.R;

public class CustomViewPager extends ViewPager {
    private DatePicker mDatePicker;
    private TimePicker mTimePicker;
    private float mTouchSlop;
    private float x1;
    private float x2;
    private float y1;
    private float y2;

    public CustomViewPager(Context context) {
        super(context);
        init(context);
    }

    public CustomViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    private void init(Context context) {
        this.mTouchSlop = (float) ViewConfiguration.get(context).getScaledPagingTouchSlop();
    }

    public void onMeasure(int i2, int i3) {
        int mode = View.MeasureSpec.getMode(i3);
        if (mode == 0 || mode == Integer.MIN_VALUE) {
            super.onMeasure(i2, i3);
            int i4 = 0;
            for (int i5 = 0; i5 < getChildCount(); i5++) {
                View childAt = getChildAt(i5);
                childAt.measure(i2, View.MeasureSpec.makeMeasureSpec(0, 0));
                int measuredHeight = childAt.getMeasuredHeight();
                if (measuredHeight > i4) {
                    i4 = measuredHeight;
                }
            }
            i3 = View.MeasureSpec.makeMeasureSpec(i4, 1073741824);
        }
        super.onMeasure(i2, i3);
        this.mDatePicker = (DatePicker) findViewById(R.id.datePicker);
        this.mTimePicker = (TimePicker) findViewById(R.id.timePicker);
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        TimePicker timePicker;
        int action = motionEvent.getAction();
        if (action == 0) {
            this.x1 = motionEvent.getX();
            this.y1 = motionEvent.getY();
        } else if (action == 2) {
            this.x2 = motionEvent.getX();
            this.y2 = motionEvent.getY();
            if (isScrollingHorizontal(this.x1, this.y1, this.x2, this.y2)) {
                return super.dispatchTouchEvent(motionEvent);
            }
        }
        int currentItem = getCurrentItem();
        if (currentItem == 0) {
            DatePicker datePicker = this.mDatePicker;
            if (datePicker != null) {
                datePicker.dispatchTouchEvent(motionEvent);
            }
        } else if (currentItem == 1 && (timePicker = this.mTimePicker) != null) {
            timePicker.dispatchTouchEvent(motionEvent);
        }
        return super.onTouchEvent(motionEvent);
    }

    private boolean isScrollingHorizontal(float f2, float f3, float f4, float f5) {
        float f6 = f4 - f2;
        return Math.abs(f6) > this.mTouchSlop && Math.abs(f6) > Math.abs(f5 - f3);
    }
}
