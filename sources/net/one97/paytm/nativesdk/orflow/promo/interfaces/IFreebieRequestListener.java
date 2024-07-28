package net.one97.paytm.nativesdk.orflow.promo.interfaces;

import java.util.HashMap;
import java.util.List;
import net.one97.paytm.nativesdk.orflow.promo.model.CJRPromoData;
import net.one97.paytm.nativesdk.orflow.promo.model.Freebie;

public interface IFreebieRequestListener {
    void applyBulkFreebie(List<CJRPromoData> list, HashMap<Integer, Freebie> hashMap, IFreebieApplyListener iFreebieApplyListener);
}
