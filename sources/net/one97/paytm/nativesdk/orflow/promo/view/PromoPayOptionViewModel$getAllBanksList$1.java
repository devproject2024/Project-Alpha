package net.one97.paytm.nativesdk.orflow.promo.view;

import com.android.volley.VolleyError;
import net.one97.paytm.nativesdk.instruments.netbanking.modal.NBResponse;
import net.one97.paytm.nativesdk.paymethods.datasource.PaymentMethodDataSource;

public final class PromoPayOptionViewModel$getAllBanksList$1 implements PaymentMethodDataSource.Callback<NBResponse> {
    final /* synthetic */ PromoPayOptionViewModel this$0;

    PromoPayOptionViewModel$getAllBanksList$1(PromoPayOptionViewModel promoPayOptionViewModel) {
        this.this$0 = promoPayOptionViewModel;
    }

    public final void onResponse(NBResponse nBResponse) {
        this.this$0.getNetBankingResponseObserver().postValue(nBResponse);
    }

    public final void onErrorResponse(VolleyError volleyError, NBResponse nBResponse) {
        this.this$0.getNetBankingResponseObserver().postValue(null);
    }
}
