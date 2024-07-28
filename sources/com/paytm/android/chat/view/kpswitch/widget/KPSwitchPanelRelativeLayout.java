package com.paytm.android.chat.view.kpswitch.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import com.paytm.android.chat.view.kpswitch.a;
import com.paytm.android.chat.view.kpswitch.a.b;

public class KPSwitchPanelRelativeLayout extends RelativeLayout implements a {

    /* renamed from: a  reason: collision with root package name */
    private b f42616a;

    public KPSwitchPanelRelativeLayout(Context context) {
        super(context);
        a((AttributeSet) null);
    }

    public KPSwitchPanelRelativeLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(attributeSet);
    }

    public KPSwitchPanelRelativeLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        a(attributeSet);
    }

    private void a(AttributeSet attributeSet) {
        this.f42616a = new b(this, attributeSet);
    }

    public void setVisibility(int i2) {
        if (!this.f42616a.a(i2)) {
            super.setVisibility(i2);
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        int[] a2 = this.f42616a.a(i2, i3);
        super.onMeasure(a2[0], a2[1]);
    }

    public final boolean a() {
        return this.f42616a.f42594c;
    }

    public final boolean b() {
        return this.f42616a.b();
    }

    public final void c() {
        super.setVisibility(0);
    }

    public final void d() {
        this.f42616a.f42592a = true;
    }

    public void setIgnoreRecommendHeight(boolean z) {
        this.f42616a.f42593b = z;
    }
}
