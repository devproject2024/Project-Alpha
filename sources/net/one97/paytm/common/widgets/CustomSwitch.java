package net.one97.paytm.common.widgets;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.CompoundButton;
import android.widget.Switch;

public class CustomSwitch extends Switch {

    /* renamed from: a  reason: collision with root package name */
    private CompoundButton.OnCheckedChangeListener f49781a;

    public CustomSwitch(Context context) {
        super(context);
    }

    public CustomSwitch(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        super.setOnCheckedChangeListener(onCheckedChangeListener);
        this.f49781a = onCheckedChangeListener;
    }

    public CompoundButton.OnCheckedChangeListener getCustomCheckedChangeListener() {
        return this.f49781a;
    }
}
