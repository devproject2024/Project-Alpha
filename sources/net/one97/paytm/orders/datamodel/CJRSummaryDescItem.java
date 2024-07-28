package net.one97.paytm.orders.datamodel;

import net.one97.paytm.common.entity.shopping.CJRHomePageLayoutV2;
import net.one97.paytm.common.entity.shopping.CJROrderSummary;
import net.one97.paytm.common.entity.trainticket.CJRTrainSummaryMetadataResponse;

public class CJRSummaryDescItem extends CJRHomePageLayoutV2 {
    /* access modifiers changed from: private */
    public String bookingStatus;
    /* access modifiers changed from: private */
    public boolean isInOrderDetails;
    /* access modifiers changed from: private */
    public String itemStatus;
    /* access modifiers changed from: private */
    public CJROrderSummary orderSummary;
    /* access modifiers changed from: private */
    public String pnrNumber;
    /* access modifiers changed from: private */
    public CJRTrainSummaryMetadataResponse trainMetaData;

    public CJROrderSummary getOrderSummary() {
        return this.orderSummary;
    }

    public CJRTrainSummaryMetadataResponse getTrainMetaData() {
        return this.trainMetaData;
    }

    public String getPnrNumber() {
        return this.pnrNumber;
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
