package net.one97.paytm.common.widgets;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.CheckBox;
import android.widget.CompoundButton;

public class CustomCheckBox extends CheckBox {

    /* renamed from: a  reason: collision with root package name */
    private CompoundButton.OnCheckedChangeListener f49766a;

    public CustomCheckBox(Context context) {
        super(context);
    }

    public CustomCheckBox(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        super.setOnCheckedChangeListener(onCheckedChangeListener);
        this.f49766a = onCheckedChangeListener;
    }

    public CompoundButton.OnCheckedChangeListener getCustomOnCheckedChangeListener() {
        return this.f49766a;
    }
}
