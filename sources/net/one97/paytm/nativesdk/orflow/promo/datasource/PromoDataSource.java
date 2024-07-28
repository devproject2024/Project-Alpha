package net.one97.paytm.nativesdk.orflow.promo.datasource;

import com.android.volley.Response;
import net.one97.paytm.nativesdk.app.VerifyPromoResultListener;
import net.one97.paytm.nativesdk.interfaces.PromoSearchListener;
import net.one97.paytm.nativesdk.orflow.promo.model.OfferDetailModel;
import net.one97.paytm.nativesdk.orflow.promo.model.Request;

public interface PromoDataSource {

    public interface Callback<T> extends Response.ErrorListener, Response.Listener<T> {
    }

    void getAllPromos(Request request, PromoSearchListener promoSearchListener);

    void getOfferDetail(String str, Callback<OfferDetailModel> callback);

    void validatePromo(Request request, VerifyPromoResultListener verifyPromoResultListener);
}
