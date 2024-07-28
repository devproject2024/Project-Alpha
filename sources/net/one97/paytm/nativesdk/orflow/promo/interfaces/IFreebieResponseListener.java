package net.one97.paytm.nativesdk.orflow.promo.interfaces;

import net.one97.paytm.nativesdk.orflow.promo.model.Gratification;
import net.one97.paytm.nativesdk.orflow.promo.model.PromoListItem;

public interface IFreebieResponseListener {
    void onFreebieErrorResponse(String str);

    void onFreebieResponse(String str);

    void onFreebieResponse(Gratification gratification, PromoListItem promoListItem, String str);

    void onFreebieResponse(PromoListItem promoListItem, String str);
}
