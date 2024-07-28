package com.paytm.android.chat.view.kpswitch.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.paytm.android.chat.view.kpswitch.a;
import com.paytm.android.chat.view.kpswitch.a.b;

public class KPSwitchPanelLinearLayout extends LinearLayout implements a {

    /* renamed from: a  reason: collision with root package name */
    private b f42615a;

    public KPSwitchPanelLinearLayout(Context context) {
        super(context);
        a((AttributeSet) null);
    }

    public KPSwitchPanelLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(attributeSet);
    }

    public KPSwitchPanelLinearLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        a(attributeSet);
    }

    private void a(AttributeSet attributeSet) {
        this.f42615a = new b(this, attributeSet);
    }

    public final boolean a() {
        return this.f42615a.f42594c;
    }

    public void setVisibility(int i2) {
        if (!this.f42615a.a(i2)) {
            super.setVisibility(i2);
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        int[] a2 = this.f42615a.a(i2, i3);
        super.onMeasure(a2[0], a2[1]);
    }

    public final boolean b() {
        return this.f42615a.b();
    }

    public final void c() {
        super.setVisibility(0);
    }

    public final void d() {
        this.f42615a.f42592a = true;
    }

    public void setIgnoreRecommendHeight(boolean z) {
        this.f42615a.f42593b = z;
    }
}
