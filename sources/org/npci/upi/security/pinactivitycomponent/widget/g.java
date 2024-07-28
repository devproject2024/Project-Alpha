package org.npci.upi.security.pinactivitycomponent.widget;

import android.animation.ValueAnimator;

class g implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FormItemEditText f73042a;

    g(FormItemEditText formItemEditText) {
        this.f73042a = formItemEditText;
    }

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.f73042a.m.setAlpha(((Integer) valueAnimator.getAnimatedValue()).intValue());
    }
}
