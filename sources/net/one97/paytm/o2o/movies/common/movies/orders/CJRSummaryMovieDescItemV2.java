package net.one97.paytm.o2o.movies.common.movies.orders;

import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.common.entity.shopping.CJROrderSummary;
import net.one97.paytm.common.entity.shopping.CJROrderedCart;
import net.one97.paytm.o2o.movies.entity.CJRInsuranceConfig;

public class CJRSummaryMovieDescItemV2 implements IJRDataModel {
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
    public CJRInsuranceConfig insuranceConfig;
    /* access modifiers changed from: private */
    public CJROrderSummaryMetadataResponseV2 metaDataresponse;
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
    public boolean shareBookingId;
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

    public CJROrderSummaryMetadataResponseV2 getMetaDataresponse() {
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

    public CJRInsuranceConfig getInsuranceConfig() {
        return this.insuranceConfig;
    }

    public boolean isShareBookingId() {
        return this.shareBookingId;
    }

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public CJRSummaryMovieDescItemV2 f75154a;

        public a() {
            this.f75154a = null;
            this.f75154a = new CJRSummaryMovieDescItemV2();
        }
    }
}
