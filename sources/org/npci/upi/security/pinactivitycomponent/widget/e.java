package org.npci.upi.security.pinactivitycomponent.widget;

import android.animation.Animator;

class e implements Animator.AnimatorListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FormItemEditText f73039a;

    e(FormItemEditText formItemEditText) {
        this.f73039a = formItemEditText;
    }

    public void onAnimationCancel(Animator animator) {
    }

    public void onAnimationEnd(Animator animator) {
        this.f73039a.s.a(this.f73039a.getText());
    }

    public void onAnimationRepeat(Animator animator) {
    }

    public void onAnimationStart(Animator animator) {
    }
}
