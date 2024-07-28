package net.one97.paytm.hotel4.service.model.promocode;

import com.paytm.network.model.IJRPaytmDataModel;

public final class PromoCodeApply extends IJRPaytmDataModel {
    private PromoCodeApplyData data;

    public final PromoCodeApplyData getData() {
        return this.data;
    }

    public final void setData(PromoCodeApplyData promoCodeApplyData) {
        this.data = promoCodeApplyData;
    }
}
