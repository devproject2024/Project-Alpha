package net.one97.paytm.moneytransfer.utils;

import android.content.Context;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import androidx.core.widget.NestedScrollView;

public class LockableScrollView extends NestedScrollView {

    /* renamed from: a  reason: collision with root package name */
    private boolean f54138a = true;

    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        return false;
    }

    public boolean onKeyUp(int i2, KeyEvent keyEvent) {
        return false;
    }

    public LockableScrollView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    public LockableScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public LockableScrollView(Context context) {
        super(context);
    }

    public void setScrollingEnabled(boolean z) {
        this.f54138a = z;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() != 0) {
            return super.onTouchEvent(motionEvent);
        }
        boolean z = this.f54138a;
        return z ? super.onTouchEvent(motionEvent) : z;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (!this.f54138a) {
            return false;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }
}
