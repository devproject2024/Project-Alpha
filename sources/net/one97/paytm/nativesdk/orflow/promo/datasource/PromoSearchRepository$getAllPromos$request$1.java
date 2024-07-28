package net.one97.paytm.nativesdk.orflow.promo.datasource;

import com.android.volley.Response;
import net.one97.paytm.nativesdk.interfaces.PromoSearchListener;

final class PromoSearchRepository$getAllPromos$request$1<T> implements Response.Listener<String> {
    final /* synthetic */ PromoSearchListener $callback;

    PromoSearchRepository$getAllPromos$request$1(PromoSearchListener promoSearchListener) {
        this.$callback = promoSearchListener;
    }

    public final void onResponse(String str) {
        this.$callback.onPromoSearchSuccess(str);
    }
}
