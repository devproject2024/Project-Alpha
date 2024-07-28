package org.npci.upi.security.pinactivitycomponent.widget;

import android.animation.Animator;

class h implements Animator.AnimatorListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FormItemEditText f73043a;

    h(FormItemEditText formItemEditText) {
        this.f73043a = formItemEditText;
    }

    public void onAnimationCancel(Animator animator) {
    }

    public void onAnimationEnd(Animator animator) {
        this.f73043a.s.a(this.f73043a.getText());
    }

    public void onAnimationRepeat(Animator animator) {
    }

    public void onAnimationStart(Animator animator) {
    }
}
