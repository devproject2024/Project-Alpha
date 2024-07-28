package com.travel.flight.pojo.flightticket;

import net.one97.paytm.common.entity.shopping.CJRHomePageLayoutV2;
import net.one97.paytm.common.entity.shopping.CJROrderSummary;
import net.one97.paytm.common.entity.shopping.CJROrderedCart;

public class CJRFlightTravellerDetailsItem extends CJRHomePageLayoutV2 {
    /* access modifiers changed from: private */
    public CJROrderedCart cart;
    /* access modifiers changed from: private */
    public CJROrderSummary orderSummary;
    /* access modifiers changed from: private */
    public int position;
    private String promoCode;
    private String promoText;
    /* access modifiers changed from: private */
    public int size;

    public CJROrderSummary getOrderSummary() {
        return this.orderSummary;
    }

    public CJROrderedCart getCart() {
        return this.cart;
    }

    public int getPosition() {
        return this.position;
    }

    public int getSize() {
        return this.size;
    }

    public String getPromoCode() {
        return this.promoCode;
    }

    public String getPromoText() {
        return this.promoText;
    }
}
