package net.one97.paytm.passbook.customview;

import android.content.Context;
import android.util.AttributeSet;
import com.paytm.utility.RoboTextView;

public class MarqueeTextView extends RoboTextView {
    public boolean isFocused() {
        return true;
    }

    public MarqueeTextView(Context context) {
        super(context);
    }

    public MarqueeTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public MarqueeTextView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }
}
