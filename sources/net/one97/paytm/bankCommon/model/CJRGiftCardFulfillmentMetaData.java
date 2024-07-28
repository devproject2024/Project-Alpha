package net.one97.paytm.bankCommon.model;

import net.one97.paytm.common.entity.IJRDataModel;

public class CJRGiftCardFulfillmentMetaData implements IJRDataModel {
    private boolean is_self_order;
    private String promocode;
    private String promopin;
    private String voucher_code;

    public String getPromocode() {
        return this.promocode;
    }

    public String getVoucherCode() {
        return this.voucher_code;
    }

    public String getPromopin() {
        return this.promopin;
    }

    public boolean getIsSelfOrder() {
        return this.is_self_order;
    }
}
