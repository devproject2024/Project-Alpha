package net.one97.paytm.recharge.legacy.catalog.model.v2;

import net.one97.paytm.common.entity.IJRDataModel;

public class CJRButtonPrefetch implements IJRDataModel {
    private CJRPrefetchObj prefetchObjOne;
    private CJRPrefetchObj prefetchObjZero;

    public CJRPrefetchObj getPrefetchObjZero() {
        return this.prefetchObjZero;
    }

    public void setPrefetchObjZero(CJRPrefetchObj cJRPrefetchObj) {
        this.prefetchObjZero = cJRPrefetchObj;
    }

    public CJRPrefetchObj getPrefetchObjOne() {
        return this.prefetchObjOne;
    }

    public void setPrefetchObjOne(CJRPrefetchObj cJRPrefetchObj) {
        this.prefetchObjOne = cJRPrefetchObj;
    }
}
