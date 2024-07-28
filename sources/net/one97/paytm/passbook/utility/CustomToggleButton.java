package net.one97.paytm.passbook.utility;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.CompoundButton;
import android.widget.ToggleButton;

public class CustomToggleButton extends ToggleButton {

    /* renamed from: a  reason: collision with root package name */
    private CompoundButton.OnCheckedChangeListener f59203a;

    public CustomToggleButton(Context context, AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, i3);
    }

    public CustomToggleButton(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    public CustomToggleButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public CustomToggleButton(Context context) {
        super(context);
    }

    public void setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        super.setOnCheckedChangeListener(onCheckedChangeListener);
        this.f59203a = onCheckedChangeListener;
    }

    public CompoundButton.OnCheckedChangeListener getCustomOnCheckedChangeListener() {
        return this.f59203a;
    }
}
