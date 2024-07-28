package net.one97.paytm.orders.datamodel;

import java.util.Map;
import net.one97.paytm.common.entity.shopping.CJRHomePageLayoutV2;
import net.one97.paytm.common.entity.shopping.CJROrderSummary;
import net.one97.paytm.common.entity.shopping.CJROrderedCart;

public class CJRTrainTravellerDetailsItem extends CJRHomePageLayoutV2 {
    /* access modifiers changed from: private */
    public CJROrderedCart cart;
    /* access modifiers changed from: private */
    public Map<String, String> configuration;
    /* access modifiers changed from: private */
    public boolean hasLayoutHeader;
    /* access modifiers changed from: private */
    public boolean hasfooter;
    /* access modifiers changed from: private */
    public String mTravellerStatus;
    /* access modifiers changed from: private */
    public CJROrderSummary orderSummary;
    /* access modifiers changed from: private */
    public int position;
    /* access modifiers changed from: private */
    public String promoCode;
    /* access modifiers changed from: private */
    public String promoText;
    /* access modifiers changed from: private */
    public int size;

    public CJROrderSummary getOrderSummary() {
        return this.orderSummary;
    }

    public CJROrderedCart getCart() {
        return this.cart;
    }

    public void setCart(CJROrderedCart cJROrderedCart) {
        this.cart = cJROrderedCart;
    }

    public boolean hasLayoutHeader() {
        return this.hasLayoutHeader;
    }

    public Map<String, String> getConfiguration() {
        return this.configuration;
    }

    public String getTravellerStatus() {
        return this.mTravellerStatus;
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

    public boolean isHasfooter() {
        return this.hasfooter;
    }
}
