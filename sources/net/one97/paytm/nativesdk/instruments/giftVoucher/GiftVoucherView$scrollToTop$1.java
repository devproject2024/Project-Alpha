package net.one97.paytm.nativesdk.instruments.giftVoucher;

import android.animation.ObjectAnimator;
import kotlin.g.b.k;
import net.one97.paytm.nativesdk.instruments.Instruments;

final class GiftVoucherView$scrollToTop$1 implements Runnable {
    final /* synthetic */ GiftVoucherView this$0;

    GiftVoucherView$scrollToTop$1(GiftVoucherView giftVoucherView) {
        this.this$0 = giftVoucherView;
    }

    public final void run() {
        Instruments access$getInstruments$p = this.this$0.instruments;
        k.a((Object) access$getInstruments$p, "instruments");
        ObjectAnimator.ofInt(access$getInstruments$p.getScrollView(), "scrollY", new int[]{(int) this.this$0.getView().getY()}).setDuration(500).start();
    }
}
