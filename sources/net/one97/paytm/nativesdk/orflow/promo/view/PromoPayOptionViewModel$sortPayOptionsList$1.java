package net.one97.paytm.nativesdk.orflow.promo.view;

import java.util.Comparator;
import net.one97.paytm.nativesdk.orflow.promo.model.PromoPayOptionAdapterParam;

public final class PromoPayOptionViewModel$sortPayOptionsList$1 implements Comparator<PromoPayOptionAdapterParam> {
    PromoPayOptionViewModel$sortPayOptionsList$1() {
    }

    public final int compare(PromoPayOptionAdapterParam promoPayOptionAdapterParam, PromoPayOptionAdapterParam promoPayOptionAdapterParam2) {
        if (promoPayOptionAdapterParam == null || promoPayOptionAdapterParam2 == null || promoPayOptionAdapterParam.getSortingOrder() == promoPayOptionAdapterParam2.getSortingOrder()) {
            return 0;
        }
        return promoPayOptionAdapterParam.getSortingOrder() < promoPayOptionAdapterParam2.getSortingOrder() ? -1 : 1;
    }
}
