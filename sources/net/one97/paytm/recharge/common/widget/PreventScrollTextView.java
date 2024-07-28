package net.one97.paytm.recharge.common.widget;

import android.content.Context;
import android.util.AttributeSet;
import com.paytm.utility.RoboTextView;

public class PreventScrollTextView extends RoboTextView {
    public void scrollTo(int i2, int i3) {
    }

    public PreventScrollTextView(Context context) {
        super(context);
    }

    public PreventScrollTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public PreventScrollTextView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }
}
