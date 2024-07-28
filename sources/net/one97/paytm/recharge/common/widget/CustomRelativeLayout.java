package net.one97.paytm.recharge.common.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.RelativeLayout;
import kotlin.g.b.k;

public final class CustomRelativeLayout extends RelativeLayout {
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        k.c(motionEvent, "ev");
        return true;
    }

    public CustomRelativeLayout(Context context) {
        super(context);
    }

    public CustomRelativeLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public CustomRelativeLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }
}
