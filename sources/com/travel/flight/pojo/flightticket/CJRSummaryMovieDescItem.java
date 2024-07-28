package com.travel.flight.pojo.flightticket;

import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.common.entity.shopping.CJROrderSummary;
import net.one97.paytm.common.entity.shopping.CJROrderSummaryMetadataResponse;
import net.one97.paytm.common.entity.shopping.CJROrderedCart;

public class CJRSummaryMovieDescItem implements IJRDataModel {
    /* access modifiers changed from: private */
    public String cancelledMsg;
    /* access modifiers changed from: private */
    public String durationBeforeShowTime;
    /* access modifiers changed from: private */
    public String encryptedOrderId;
    /* access modifiers changed from: private */
    public int foodItems;
    /* access modifiers changed from: private */
    public double grandTotal;
    /* access modifiers changed from: private */
    public CJROrderSummaryMetadataResponse metaDataresponse;
    /* access modifiers changed from: private */
    public String movieDuration;
    /* access modifiers changed from: private */
    public String movieInsuranceEndDate;
    /* access modifiers changed from: private */
    public int movieInsurancePresent;
    /* access modifiers changed from: private */
    public CJROrderedCart movieItem;
    /* access modifiers changed from: private */
    public String movieLanguage;
    /* access modifiers changed from: private */
    public String movieName;
    /* access modifiers changed from: private */
    public String movieShowTime;
    /* access modifiers changed from: private */
    public int movieTicketCount;
    /* access modifiers changed from: private */
    public int movieTicketStatus;
    /* access modifiers changed from: private */
    public String orderId;
    /* access modifiers changed from: private */
    public CJROrderSummary summary;
    /* access modifiers changed from: private */
    public String uniqueBookingId;

    public String getMovieDuration() {
        return this.movieDuration;
    }

    public String getMovieName() {
        return this.movieName;
    }

    public String getMovieLanguage() {
        return this.movieLanguage;
    }

    public String getMovieShowTime() {
        return this.movieShowTime;
    }

    public CJROrderSummary getSummary() {
        return this.summary;
    }

    public CJROrderSummaryMetadataResponse getMetaDataresponse() {
        return this.metaDataresponse;
    }

    public CJROrderedCart getMovieItem() {
        return this.movieItem;
    }

    public String getUniqueBookingId() {
        return this.uniqueBookingId;
    }

    public String getEncryptedOrderId() {
        return this.encryptedOrderId;
    }

    public int getMovieTicketStatus() {
        return this.movieTicketStatus;
    }

    public int getMovieTicketCount() {
        return this.movieTicketCount;
    }

    public int getMovieInsurancePresent() {
        return this.movieInsurancePresent;
    }

    public String getMovieInsuranceEndDate() {
        return this.movieInsuranceEndDate;
    }

    public String getDurationBeforeShowTime() {
        return this.durationBeforeShowTime;
    }

    public String getCancelledMsg() {
        return this.cancelledMsg;
    }

    public String getOrderId() {
        return this.orderId;
    }

    public double getGrandTotal() {
        return this.grandTotal;
    }

    public int getFoodItems() {
        return this.foodItems;
    }
}
