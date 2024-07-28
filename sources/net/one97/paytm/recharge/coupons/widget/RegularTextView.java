package net.one97.paytm.recharge.coupons.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;
import com.paytm.utility.w;

@Deprecated
public class RegularTextView extends TextView {
    public RegularTextView(Context context) {
        super(context);
        a();
    }

    public RegularTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    public RegularTextView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        a();
    }

    private void a() {
        if (!isInEditMode()) {
            try {
                if (getTypeface() != null) {
                    if (getTypeface() == null || getTypeface().equals(w.a(getContext(), "Roboto-Regular.ttf"))) {
                        return;
                    }
                }
                setTypeface(w.a(getContext(), "Roboto-Regular.ttf"));
            } catch (Exception unused) {
            }
        }
    }
}
