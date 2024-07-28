package com.paytm.android.chat.view.kpswitch.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import com.paytm.android.chat.view.kpswitch.a.c;

public class KPSwitchRootRelativeLayout extends RelativeLayout {

    /* renamed from: a  reason: collision with root package name */
    private c f42619a;

    public KPSwitchRootRelativeLayout(Context context) {
        super(context);
        a();
    }

    public KPSwitchRootRelativeLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    public KPSwitchRootRelativeLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        a();
    }

    private void a() {
        this.f42619a = new c(this);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        this.f42619a.a(View.MeasureSpec.getSize(i2), View.MeasureSpec.getSize(i3));
        super.onMeasure(i2, i3);
    }
}
