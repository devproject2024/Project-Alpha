package net.one97.paytm.nativesdk.transcation;

import android.animation.ValueAnimator;
import android.widget.ProgressBar;
import kotlin.g.b.k;
import kotlin.u;
import net.one97.paytm.nativesdk.R;

final class NativePlusPayActivity$addAutoSubmitOtpUI$1 implements ValueAnimator.AnimatorUpdateListener {
    final /* synthetic */ NativePlusPayActivity this$0;

    NativePlusPayActivity$addAutoSubmitOtpUI$1(NativePlusPayActivity nativePlusPayActivity) {
        this.this$0 = nativePlusPayActivity;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        k.a((Object) valueAnimator, "valueAnimator");
        Object animatedValue = valueAnimator.getAnimatedValue();
        if (animatedValue != null) {
            ((ProgressBar) this.this$0._$_findCachedViewById(R.id.autoSubmitProgressBar)).setProgress(((Integer) animatedValue).intValue());
            return;
        }
        throw new u("null cannot be cast to non-null type kotlin.Int");
    }
}
