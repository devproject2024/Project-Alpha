package com.travel.citybus.brts;

import android.content.Context;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.inputmethod.InputMethodManager;
import android.widget.AutoCompleteTextView;

public class CustomBrtsAutoCompleteTextView extends AutoCompleteTextView {
    public CustomBrtsAutoCompleteTextView(Context context) {
        super(context);
    }

    public CustomBrtsAutoCompleteTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public CustomBrtsAutoCompleteTextView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    public boolean onKeyPreIme(int i2, KeyEvent keyEvent) {
        return (i2 != 4 || !isPopupShowing()) ? super.onKeyPreIme(i2, keyEvent) : ((InputMethodManager) getContext().getSystemService("input_method")).hideSoftInputFromWindow(findFocus().getWindowToken(), 2);
    }
}
