package net.one97.paytm.nativesdk.orflow.promo;

import android.text.TextUtils;
import net.one97.paytm.nativesdk.orflow.promo.interfaces.IFreebieJsonResponseListener;
import net.one97.paytm.nativesdk.orflow.promo.interfaces.IFreebieResponseListener;
import net.one97.paytm.nativesdk.orflow.promo.model.PromoListItem;
import net.one97.paytm.nativesdk.orflow.promo.utils.PromoUtils;

public final class PromoHelper$getFreebies$1 implements IFreebieJsonResponseListener {
    final /* synthetic */ IFreebieResponseListener $freebieResponseListener;
    final /* synthetic */ PromoListItem $item;

    public final void onFreebieErrorResponse(String str) {
    }

    PromoHelper$getFreebies$1(IFreebieResponseListener iFreebieResponseListener, PromoListItem promoListItem) {
        this.$freebieResponseListener = iFreebieResponseListener;
        this.$item = promoListItem;
    }

    public final void onFreebieResponse(String str) {
        if (!TextUtils.isEmpty(str)) {
            PromoUtils.log("freebieResponse");
            this.$freebieResponseListener.onFreebieResponse(this.$item, str);
        }
    }
}
