package net.one97.paytm.nativesdk.orflow.promo.view;

import net.one97.paytm.nativesdk.R;
import net.one97.paytm.nativesdk.app.PaytmSDKRequestClient;

public final class PromoPayOptionsBottomSheet$checkBalanceObserver$1$onChanged$1 implements PaytmSDKRequestClient.ApplyAnotherOfferListener {
    final /* synthetic */ PromoPayOptionsBottomSheet$checkBalanceObserver$1 this$0;

    PromoPayOptionsBottomSheet$checkBalanceObserver$1$onChanged$1(PromoPayOptionsBottomSheet$checkBalanceObserver$1 promoPayOptionsBottomSheet$checkBalanceObserver$1) {
        this.this$0 = promoPayOptionsBottomSheet$checkBalanceObserver$1;
    }

    public final void onSuccess() {
        this.this$0.this$0.onPromoCodeRemoved(this.this$0.this$0.getString(R.string.default_promo_payoption_error_msg));
    }

    public final void onError(PaytmSDKRequestClient.ApiResponseError apiResponseError) {
        this.this$0.this$0.onPromoCodeRemoved(this.this$0.this$0.getString(R.string.default_promo_payoption_error_msg));
    }
}
