package net.one97.paytm.nativesdk.orflow.promo.view;

import com.android.volley.VolleyError;
import net.one97.paytm.nativesdk.paymethods.datasource.PaymentMethodDataSource;
import net.one97.paytm.nativesdk.paymethods.model.fetchBalance.CJRFetchBalanceResponse;

public final class PromoPayOptionViewModel$checkBalance$1 implements PaymentMethodDataSource.Callback<CJRFetchBalanceResponse> {
    final /* synthetic */ PromoPayOptionViewModel this$0;

    PromoPayOptionViewModel$checkBalance$1(PromoPayOptionViewModel promoPayOptionViewModel) {
        this.this$0 = promoPayOptionViewModel;
    }

    public final void onResponse(CJRFetchBalanceResponse cJRFetchBalanceResponse) {
        this.this$0.getCheckBalanceObserver().postValue(cJRFetchBalanceResponse);
    }

    public final void onErrorResponse(VolleyError volleyError, CJRFetchBalanceResponse cJRFetchBalanceResponse) {
        this.this$0.getCheckBalanceObserver().postValue(null);
    }
}
