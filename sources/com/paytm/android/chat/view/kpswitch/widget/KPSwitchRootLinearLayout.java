package com.paytm.android.chat.view.kpswitch.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.paytm.android.chat.view.kpswitch.a.c;

public class KPSwitchRootLinearLayout extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    private c f42618a;

    public KPSwitchRootLinearLayout(Context context) {
        super(context);
        a();
    }

    public KPSwitchRootLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    public KPSwitchRootLinearLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        a();
    }

    private void a() {
        this.f42618a = new c(this);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        this.f42618a.a(View.MeasureSpec.getSize(i2), View.MeasureSpec.getSize(i3));
        super.onMeasure(i2, i3);
    }
}
