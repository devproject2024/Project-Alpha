package org.npci.upi.security.pinactivitycomponent;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import androidx.core.h.u;

class t extends AnimatorListenerAdapter {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ boolean f73001a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ int f73002b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ GetCredential f73003c;

    t(GetCredential getCredential, boolean z, int i2) {
        this.f73003c = getCredential;
        this.f73001a = z;
        this.f73002b = i2;
    }

    public void onAnimationEnd(Animator animator) {
        super.onAnimationEnd(animator);
        if (!this.f73001a) {
            this.f73003c.mTransactionDetailScroller.setVisibility(8);
            this.f73003c.mTransactionDetailSpace.setVisibility(8);
            this.f73003c.mTransitionDrawable.resetTransition();
        }
    }

    public void onAnimationStart(Animator animator) {
        super.onAnimationStart(animator);
        if (this.f73001a) {
            this.f73003c.mTransitionDrawable.startTransition(300);
            this.f73003c.mTransactionDetailScroller.setVisibility(0);
            this.f73003c.mTransactionDetailSpace.setVisibility(0);
            if (u.u(this.f73003c.mTransactionDetailScroller) == 0.0f) {
                this.f73003c.mTransactionDetailScroller.setY((float) (this.f73002b * -1));
                return;
            }
            return;
        }
        this.f73003c.mTransitionDrawable.reverseTransition(300);
    }
}
