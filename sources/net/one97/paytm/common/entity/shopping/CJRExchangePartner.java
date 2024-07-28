package net.one97.paytm.common.entity.shopping;

import com.google.gsonhtcfix.a.b;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRExchangePartner implements IJRDataModel {
    @b(a = "merchant_id")
    private int mMerchantid;
    @b(a = "partner_id")
    private int mPartnerId;
    @b(a = "product_id")
    private int mProductid;

    public int getPartner_id() {
        return this.mPartnerId;
    }

    public int getMerchant_id() {
        return this.mMerchantid;
    }

    public int getProduct_id() {
        return this.mProductid;
    }
}
