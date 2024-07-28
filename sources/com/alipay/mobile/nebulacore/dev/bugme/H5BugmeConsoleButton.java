package com.alipay.mobile.nebulacore.dev.bugme;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ImageButton;
import com.paytmmall.clpartifact.customViews.PriceRangeSeekBar;

public class H5BugmeConsoleButton extends ImageButton {
    private static final int THRESH_HOLD = 10;
    private float mDX;
    private float mDY;
    private boolean mMoving = false;
    private float mStartX;
    private float mStartY;

    public H5BugmeConsoleButton(Context context) {
        super(context);
    }

    public H5BugmeConsoleButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public H5BugmeConsoleButton(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & PriceRangeSeekBar.INVALID_POINTER_ID;
        if (action == 0) {
            this.mMoving = false;
            this.mDX = getX() - motionEvent.getRawX();
            this.mDY = getY() - motionEvent.getRawY();
            this.mStartX = getX();
            this.mStartY = getY();
        } else if (action == 2) {
            this.mMoving = Math.abs((this.mStartX - motionEvent.getRawX()) - this.mDX) >= 10.0f || Math.abs((this.mStartY - motionEvent.getRawY()) - this.mDY) >= 10.0f;
            animate().x(motionEvent.getRawX() + this.mDX).y(motionEvent.getRawY() + this.mDY).setDuration(0).start();
        }
        return this.mMoving || super.onTouchEvent(motionEvent);
    }
}
