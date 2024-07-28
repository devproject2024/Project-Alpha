package net.one97.paytm.nativesdk.orflow.promo.view;

import com.android.volley.VolleyError;
import net.one97.paytm.nativesdk.instruments.upicollect.models.VerifyVpaResponse;
import net.one97.paytm.nativesdk.paymethods.datasource.PaymentMethodDataSource;

public final class PromoPayOptionViewModel$validateVPA$1 implements PaymentMethodDataSource.Callback<VerifyVpaResponse> {
    final /* synthetic */ PromoPayOptionViewModel this$0;

    PromoPayOptionViewModel$validateVPA$1(PromoPayOptionViewModel promoPayOptionViewModel) {
        this.this$0 = promoPayOptionViewModel;
    }

    public final void onResponse(VerifyVpaResponse verifyVpaResponse) {
        this.this$0.getValidateVPAObserver().postValue(verifyVpaResponse);
    }

    public final void onErrorResponse(VolleyError volleyError, VerifyVpaResponse verifyVpaResponse) {
        this.this$0.getValidateVPAObserver().postValue(null);
    }
}
