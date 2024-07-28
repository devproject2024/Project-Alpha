package net.one97.paytm.recharge.legacy.catalog.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.widget.RadioButton;

@Deprecated
public class RechargeListRowCheckBox extends RadioButton {
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        return false;
    }

    public boolean onKeyMultiple(int i2, int i3, KeyEvent keyEvent) {
        return false;
    }

    public boolean onKeyPreIme(int i2, KeyEvent keyEvent) {
        return false;
    }

    public boolean onKeyShortcut(int i2, KeyEvent keyEvent) {
        return false;
    }

    public boolean onKeyUp(int i2, KeyEvent keyEvent) {
        return false;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        return false;
    }

    public boolean onTrackballEvent(MotionEvent motionEvent) {
        return false;
    }

    public RechargeListRowCheckBox(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    public RechargeListRowCheckBox(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public RechargeListRowCheckBox(Context context) {
        super(context);
    }
}
