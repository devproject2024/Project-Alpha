package net.one97.paytm.nativesdk.orflow.promo.datasource;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import net.one97.paytm.nativesdk.interfaces.PromoSearchListener;

final class PromoSearchRepository$getAllPromos$request$2 implements Response.ErrorListener {
    final /* synthetic */ PromoSearchListener $callback;

    PromoSearchRepository$getAllPromos$request$2(PromoSearchListener promoSearchListener) {
        this.$callback = promoSearchListener;
    }

    public final void onErrorResponse(VolleyError volleyError) {
        this.$callback.onPromoSearchError(volleyError);
    }
}
