package net.one97.paytm.common.widgets;

import android.content.Context;
import android.util.AttributeSet;
import com.google.android.material.textfield.TextInputLayout;

abstract class BaseAutoCompleteLayout extends TextInputLayout {
    public BaseAutoCompleteLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    public BaseAutoCompleteLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public BaseAutoCompleteLayout(Context context) {
        super(context);
    }
}
