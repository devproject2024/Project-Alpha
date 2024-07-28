package net.one97.paytm.nativesdk.orflow.promo;

import android.text.TextUtils;
import net.one97.paytm.nativesdk.orflow.promo.interfaces.IFreebieJsonResponseListener;
import net.one97.paytm.nativesdk.orflow.promo.interfaces.IFreebieResponseListener;
import net.one97.paytm.nativesdk.orflow.promo.model.Gratification;
import net.one97.paytm.nativesdk.orflow.promo.model.PromoListItem;

public final class PromoHelper$getFreebies$2 implements IFreebieJsonResponseListener {
    final /* synthetic */ IFreebieResponseListener $freebieResponseListener;
    final /* synthetic */ Gratification $gratification;
    final /* synthetic */ PromoListItem $item;

    public final void onFreebieErrorResponse(String str) {
    }

    PromoHelper$getFreebies$2(IFreebieResponseListener iFreebieResponseListener, Gratification gratification, PromoListItem promoListItem) {
        this.$freebieResponseListener = iFreebieResponseListener;
        this.$gratification = gratification;
        this.$item = promoListItem;
    }

    public final void onFreebieResponse(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.$freebieResponseListener.onFreebieResponse(this.$gratification, this.$item, str);
        }
    }
}
