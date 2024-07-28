package net.one97.paytm.nativesdk.orflow.promo.view;

import net.one97.paytm.nativesdk.R;
import net.one97.paytm.nativesdk.app.PaytmSDKRequestClient;

public final class PromoPayOptionsBottomSheet$applyOfferPostPaid$1 implements PaytmSDKRequestClient.ApplyAnotherOfferListener {
    final /* synthetic */ PromoPayOptionsBottomSheet this$0;

    PromoPayOptionsBottomSheet$applyOfferPostPaid$1(PromoPayOptionsBottomSheet promoPayOptionsBottomSheet) {
        this.this$0 = promoPayOptionsBottomSheet;
    }

    public final void onSuccess() {
        PromoPayOptionsBottomSheet promoPayOptionsBottomSheet = this.this$0;
        promoPayOptionsBottomSheet.onPromoCodeRemoved(promoPayOptionsBottomSheet.getString(R.string.native_insufficent_balance));
    }

    public final void onError(PaytmSDKRequestClient.ApiResponseError apiResponseError) {
        PromoPayOptionsBottomSheet promoPayOptionsBottomSheet = this.this$0;
        promoPayOptionsBottomSheet.onPromoCodeRemoved(promoPayOptionsBottomSheet.getString(R.string.native_insufficent_balance));
    }
}
