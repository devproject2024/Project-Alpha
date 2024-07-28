package net.one97.paytm.nativesdk.transcation;

import android.animation.Animator;
import android.widget.RelativeLayout;
import net.one97.paytm.nativesdk.R;

public final class NativePlusPayActivity$addAutoSubmitOtpUI$2 implements Animator.AnimatorListener {
    final /* synthetic */ NativePlusPayActivity this$0;

    public final void onAnimationCancel(Animator animator) {
    }

    public final void onAnimationRepeat(Animator animator) {
    }

    public final void onAnimationStart(Animator animator) {
    }

    NativePlusPayActivity$addAutoSubmitOtpUI$2(NativePlusPayActivity nativePlusPayActivity) {
        this.this$0 = nativePlusPayActivity;
    }

    public final void onAnimationEnd(Animator animator) {
        this.this$0.removeAutoSubmitOtpUI();
        ((RelativeLayout) this.this$0._$_findCachedViewById(R.id.payButton)).performClick();
    }
}
