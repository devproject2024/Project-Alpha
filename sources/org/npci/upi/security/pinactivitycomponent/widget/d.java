package org.npci.upi.security.pinactivitycomponent.widget;

import android.animation.ValueAnimator;

class d implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FormItemEditText f73038a;

    d(FormItemEditText formItemEditText) {
        this.f73038a = formItemEditText;
    }

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.f73038a.m.setAlpha(((Integer) valueAnimator.getAnimatedValue()).intValue());
        this.f73038a.invalidate();
    }
}
