package net.one97.paytm.paymentsBank.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.CompoundButton;
import android.widget.Switch;

public class SwitchPlus extends Switch {

    /* renamed from: a  reason: collision with root package name */
    int f19641a;

    /* renamed from: b  reason: collision with root package name */
    int f19642b;

    /* renamed from: c  reason: collision with root package name */
    private CompoundButton.OnCheckedChangeListener f19643c;

    public SwitchPlus(Context context) {
        super(context);
    }

    public SwitchPlus(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public SwitchPlus(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    public void setChecked(boolean z) {
        super.setChecked(z);
    }

    public void setOnOffColor(int i2, int i3) {
        this.f19641a = i2;
        this.f19642b = i3;
    }

    public void setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        super.setOnCheckedChangeListener(onCheckedChangeListener);
        this.f19643c = onCheckedChangeListener;
    }

    public CompoundButton.OnCheckedChangeListener getCustomCheckedChangeListener() {
        return this.f19643c;
    }
}
