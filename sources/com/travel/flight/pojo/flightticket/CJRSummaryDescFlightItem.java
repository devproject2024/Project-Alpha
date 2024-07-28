package com.travel.flight.pojo.flightticket;

import net.one97.paytm.common.entity.shopping.CJRHomePageLayoutV2;
import net.one97.paytm.common.entity.shopping.CJROrderSummary;
import net.one97.paytm.common.entity.shopping.CJROrderedCart;

public class CJRSummaryDescFlightItem extends CJRHomePageLayoutV2 {
    /* access modifiers changed from: private */
    public String bookingStatus;
    /* access modifiers changed from: private */
    public CJROrderedCart cart;
    /* access modifiers changed from: private */
    public CJRFlightSummaryMetadataResponse flightMetaData;
    /* access modifiers changed from: private */
    public boolean isInOrderDetails;
    /* access modifiers changed from: private */
    public String itemStatus;
    /* access modifiers changed from: private */
    public String mRoundedTripType;
    /* access modifiers changed from: private */
    public String onwardPnrNumber;
    /* access modifiers changed from: private */
    public CJROrderSummary orderSummary;

    public String getmRoundedTripType() {
        return this.mRoundedTripType;
    }

    public CJROrderedCart getCart() {
        return this.cart;
    }

    public void setCart(CJROrderedCart cJROrderedCart) {
        this.cart = cJROrderedCart;
    }

    public CJROrderSummary getOrderSummary() {
        return this.orderSummary;
    }

    public CJRFlightSummaryMetadataResponse getFlightMetaData() {
        return this.flightMetaData;
    }

    public String getOnwardPnrNumber() {
        return this.onwardPnrNumber;
    }

    public String getItemStatus() {
        return this.itemStatus;
    }

    public boolean getIsInOrderDetails() {
        return this.isInOrderDetails;
    }

    public String getBookingStatus() {
        return this.bookingStatus;
    }
}
