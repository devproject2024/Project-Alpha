package net.one97.paytm.common.widgets;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AutoCompleteTextView;
import androidx.core.h.u;

public class CustomAutoCompleteInputLayout extends BaseAutoCompleteLayout implements View.OnFocusChangeListener {

    /* renamed from: e  reason: collision with root package name */
    private AutoCompleteTextView f49757e;

    public CustomAutoCompleteInputLayout(Context context) {
        this(context, (AttributeSet) null, (byte) 0);
    }

    public CustomAutoCompleteInputLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, (byte) 0);
    }

    public CustomAutoCompleteInputLayout(Context context, AttributeSet attributeSet, int i2) {
        this(context, attributeSet, (byte) 0);
    }

    private CustomAutoCompleteInputLayout(Context context, AttributeSet attributeSet, byte b2) {
        super(context, attributeSet);
        setOrientation(1);
        setAddStatesFromChildren(true);
    }

    public void addView(View view, int i2, ViewGroup.LayoutParams layoutParams) {
        if (view instanceof AutoCompleteTextView) {
            setAutoCompleteTextView((AutoCompleteTextView) view);
            super.addView(view, 0, layoutParams);
            return;
        }
        super.addView(view, i2, layoutParams);
    }

    public void onFocusChange(View view, boolean z) {
        if (z && u.M(this)) {
            this.f49757e.showDropDown();
        }
    }

    public AutoCompleteTextView getAutoCompleteTextView() {
        return this.f49757e;
    }

    private void setAutoCompleteTextView(AutoCompleteTextView autoCompleteTextView) {
        if (this.f49757e == null) {
            this.f49757e = autoCompleteTextView;
            this.f49757e.setInputType(33);
            this.f49757e.setOnFocusChangeListener(this);
            isInEditMode();
            return;
        }
        throw new IllegalArgumentException("We already have an AutoCompleteTextView, can only have one");
    }
}
