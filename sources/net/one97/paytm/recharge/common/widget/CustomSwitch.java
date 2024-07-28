package net.one97.paytm.recharge.common.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.CompoundButton;
import androidx.appcompat.widget.SwitchCompat;

public class CustomSwitch extends SwitchCompat {

    /* renamed from: c  reason: collision with root package name */
    private CompoundButton.OnCheckedChangeListener f62103c;

    public CustomSwitch(Context context) {
        super(context);
    }

    public CustomSwitch(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        super.setOnCheckedChangeListener(onCheckedChangeListener);
        this.f62103c = onCheckedChangeListener;
    }

    public CompoundButton.OnCheckedChangeListener getCustomCheckedChangeListener() {
        return this.f62103c;
    }
}
