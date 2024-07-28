package net.one97.paytm.nativesdk.orflow.promo.view;

import net.one97.paytm.nativesdk.orflow.promo.PromoHelper;
import net.one97.paytm.nativesdk.orflow.promo.view.BasePromoPayOptionSheet;

public final class PromoSearchActivity$onVerifyPromoSuccess$1 implements BasePromoPayOptionSheet.OnDismissListener {
    final /* synthetic */ PromoSearchActivity this$0;

    PromoSearchActivity$onVerifyPromoSuccess$1(PromoSearchActivity promoSearchActivity) {
        this.this$0 = promoSearchActivity;
    }

    public final void onDismiss(boolean z) {
        if (!z) {
            PromoHelper.Companion.getInstance().addVerifyPromoObserver(this.this$0);
        }
    }

    public final void closeActivity() {
        PromoHelper.Companion.getInstance().removeVerifyPromoObserver(this.this$0);
        this.this$0.isPromoApplied = true;
        this.this$0.finish();
    }
}
