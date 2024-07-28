package net.one97.paytm.nativesdk.orflow.promo.view;

import com.android.volley.VolleyError;
import net.one97.paytm.nativesdk.orflow.promo.model.GetCardDetailsResponse;
import net.one97.paytm.nativesdk.paymethods.datasource.PaymentMethodDataSource;

public final class PromoPayOptionViewModel$fetchCardDetails$1 implements PaymentMethodDataSource.Callback<GetCardDetailsResponse> {
    final /* synthetic */ PromoPayOptionViewModel this$0;

    PromoPayOptionViewModel$fetchCardDetails$1(PromoPayOptionViewModel promoPayOptionViewModel) {
        this.this$0 = promoPayOptionViewModel;
    }

    public final void onResponse(GetCardDetailsResponse getCardDetailsResponse) {
        this.this$0.getFetchCardDetailObserver().postValue(getCardDetailsResponse);
    }

    public final void onErrorResponse(VolleyError volleyError, GetCardDetailsResponse getCardDetailsResponse) {
        this.this$0.getFetchCardDetailObserver().postValue(getCardDetailsResponse);
    }
}
