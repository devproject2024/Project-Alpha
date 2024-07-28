package net.one97.paytm.nativesdk.orflow.promo;

import android.text.TextUtils;
import net.one97.paytm.nativesdk.orflow.promo.interfaces.IFreebieJsonResponseListener;
import net.one97.paytm.nativesdk.orflow.promo.interfaces.IFreebieResponseListener;

public final class PromoHelper$getFreebies$3 implements IFreebieJsonResponseListener {
    final /* synthetic */ IFreebieResponseListener $freebieResponseListener;

    PromoHelper$getFreebies$3(IFreebieResponseListener iFreebieResponseListener) {
        this.$freebieResponseListener = iFreebieResponseListener;
    }

    public final void onFreebieErrorResponse(String str) {
        this.$freebieResponseListener.onFreebieErrorResponse(str);
    }

    public final void onFreebieResponse(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.$freebieResponseListener.onFreebieResponse(str);
        }
    }
}
