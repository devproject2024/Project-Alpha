package net.one97.paytm.common.widgets;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;
import com.paytm.utility.w;

public class MediumTextView extends TextView {
    public MediumTextView(Context context) {
        super(context);
        a();
    }

    public MediumTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    public MediumTextView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        a();
    }

    private void a() {
        if (!isInEditMode()) {
            try {
                if (getTypeface() != null) {
                    if (getTypeface() == null || getTypeface().equals(w.a(getContext(), "Roboto-Medium.ttf"))) {
                        return;
                    }
                }
                setTypeface(w.a(getContext(), "Roboto-Medium.ttf"));
            } catch (Exception unused) {
            }
        }
    }
}
