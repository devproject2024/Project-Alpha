package com.travel.flight.pojo.flightticket;

import java.util.ArrayList;
import net.one97.paytm.common.entity.shopping.CJRHomePageLayoutV2;
import net.one97.paytm.common.entity.shopping.CJROrderSummaryAction;
import net.one97.paytm.common.entity.shopping.CJROrderedCart;

public class CJRSummaryItem extends CJRHomePageLayoutV2 {
    /* access modifiers changed from: private */
    public CJRSummaryBannerItem mBannerItem;
    /* access modifiers changed from: private */
    public CJRSummaryContactUsItem mContactUsItem;
    /* access modifiers changed from: private */
    public CJRSummaryDescFlightItem mDescFlightItem;
    /* access modifiers changed from: private */
    public CJRSummaryDescItem mDescItem;
    /* access modifiers changed from: private */
    public CJRFlightTravellerDetailsItem mFlightTravellerDetailsItem;
    /* access modifiers changed from: private */
    public CJRSummaryFoodItem mFoodItem;
    /* access modifiers changed from: private */
    public String mLayout;
    /* access modifiers changed from: private */
    public String mLifafaUrl;
    /* access modifiers changed from: private */
    public CJRSummaryMovieDescItem mMovieDescItem;
    /* access modifiers changed from: private */
    public CJRSummaryMoviePaymentItem mMoviePaymentItem;
    /* access modifiers changed from: private */
    public CJRSummarySendTicketItem mMovieSendTicketItem;
    /* access modifiers changed from: private */
    public CJRNPSCaptureDataModel mNPSModel;
    /* access modifiers changed from: private */
    public String mOrderId;
    /* access modifiers changed from: private */
    public ArrayList<CJROrderedCart> mOrderedCartList;
    /* access modifiers changed from: private */
    public CJRSummaryPaymentItem mPaymentItem;
    /* access modifiers changed from: private */
    public d mRefundModel;
    /* access modifiers changed from: private */
    public CJRSummaryHeaderItem mSummaryHeader;
    private ArrayList<CJROrderSummaryAction> mTapActionList;
    /* access modifiers changed from: private */
    public CJRTrainTravellerDetailsItem mTravellerDetailsItem;
    /* access modifiers changed from: private */
    public CJROrderedCart orderedCart;

    public CJROrderedCart getOrderedCart() {
        return this.orderedCart;
    }

    public CJRFlightTravellerDetailsItem getmFlightTravellerDetailsItem() {
        return this.mFlightTravellerDetailsItem;
    }

    public void setmFlightTravellerDetailsItem(CJRFlightTravellerDetailsItem cJRFlightTravellerDetailsItem) {
        this.mFlightTravellerDetailsItem = cJRFlightTravellerDetailsItem;
    }

    public CJRSummaryDescItem getDescItem() {
        return this.mDescItem;
    }

    public CJRSummaryDescFlightItem getDescFlightItem() {
        return this.mDescFlightItem;
    }

    public CJRSummaryHeaderItem getSummaryHeader() {
        return this.mSummaryHeader;
    }

    public CJRSummaryContactUsItem getContactUsItem() {
        return this.mContactUsItem;
    }

    public String getLayout() {
        return this.mLayout;
    }

    public ArrayList<CJROrderedCart> getmOrderedCartList() {
        return this.mOrderedCartList;
    }

    public CJRSummaryPaymentItem getPaymentItem() {
        return this.mPaymentItem;
    }

    public CJRTrainTravellerDetailsItem getTravellerDetailsItem() {
        return this.mTravellerDetailsItem;
    }

    public CJRSummaryBannerItem getBannerItem() {
        return this.mBannerItem;
    }

    public CJRSummaryMovieDescItem getMovieDescItem() {
        return this.mMovieDescItem;
    }

    public CJRSummaryMoviePaymentItem getMoviePaymentItem() {
        return this.mMoviePaymentItem;
    }

    public CJRSummarySendTicketItem getMovieSendTicketItem() {
        return this.mMovieSendTicketItem;
    }

    public CJRNPSCaptureDataModel getNPSModel() {
        return this.mNPSModel;
    }

    public d getRefundModel() {
        return this.mRefundModel;
    }

    public CJRSummaryFoodItem getFoodItem() {
        return this.mFoodItem;
    }

    public String getmLifafaUrl() {
        return this.mLifafaUrl;
    }

    public String getmOrderId() {
        return this.mOrderId;
    }
}
