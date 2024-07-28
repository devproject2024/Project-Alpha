package org.npci.upi.security.pinactivitycomponent.widget;

import android.animation.ValueAnimator;

class f implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ int f73040a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ FormItemEditText f73041b;

    f(FormItemEditText formItemEditText, int i2) {
        this.f73041b = formItemEditText;
        this.f73040a = i2;
    }

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.f73041b.k[this.f73040a] = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        this.f73041b.invalidate();
    }
}
