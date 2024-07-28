package net.one97.paytm.o2o.movies.common.movies.orders.datamodel;

import java.util.ArrayList;
import net.one97.paytm.common.entity.shopping.CJRHomePageLayoutV2;
import net.one97.paytm.common.entity.shopping.CJROrderSummaryAction;
import net.one97.paytm.common.entity.shopping.CJROrderedCart;
import net.one97.paytm.o2o.movies.common.movies.orders.CJRSummaryContactUsItemV2;
import net.one97.paytm.o2o.movies.common.movies.orders.CJRSummaryHeaderItemV2;
import net.one97.paytm.o2o.movies.common.movies.orders.CJRSummaryMovieDescItemV2;
import net.one97.paytm.o2o.movies.common.movies.orders.CJRSummaryMoviePaymentItem;
import net.one97.paytm.orders.datamodel.CJRFlightTravellerDetailsItem;
import net.one97.paytm.orders.datamodel.CJRMovieSummaryCatalogV2Item;
import net.one97.paytm.orders.datamodel.CJRMoviesUpcomingItem;
import net.one97.paytm.orders.datamodel.CJRNPSCaptureDataModel;
import net.one97.paytm.orders.datamodel.CJRSummaryBannerItem;
import net.one97.paytm.orders.datamodel.CJRSummaryDescFlightItem;
import net.one97.paytm.orders.datamodel.CJRSummaryDescItem;
import net.one97.paytm.orders.datamodel.CJRSummaryFoodItem;
import net.one97.paytm.orders.datamodel.CJRSummaryPaymentItem;
import net.one97.paytm.orders.datamodel.CJRSummarySendTicketItem;
import net.one97.paytm.orders.datamodel.CJRTrainTravellerDetailsItem;

public class CJRSummaryItem extends CJRHomePageLayoutV2 {
    /* access modifiers changed from: private */
    public CJRSummaryBannerItem mBannerItem;
    /* access modifiers changed from: private */
    public CJRSummaryContactUsItemV2 mContactUsItem;
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
    public CJRSummaryMovieDescItemV2 mMovieDescItem;
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
    public net.one97.paytm.orders.datamodel.a mRefundModel;
    private CJRMovieSummaryCatalogV2Item mSummaryCatalogItem;
    /* access modifiers changed from: private */
    public CJRSummaryHeaderItemV2 mSummaryHeader;
    private ArrayList<CJROrderSummaryAction> mTapActionList;
    /* access modifiers changed from: private */
    public CJRTrainTravellerDetailsItem mTravellerDetailsItem;
    private CJRMoviesUpcomingItem mUpcomingMoviesItem;
    /* access modifiers changed from: private */
    public String orderStatus;
    /* access modifiers changed from: private */
    public CJROrderedCart orderedCart;
    /* access modifiers changed from: private */
    public String paymentStatus;

    public String getPaymentStatus() {
        return this.paymentStatus;
    }

    public String getOrderStatus() {
        return this.orderStatus;
    }

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

    public CJRSummaryHeaderItemV2 getSummaryHeader() {
        return this.mSummaryHeader;
    }

    public CJRSummaryContactUsItemV2 getContactUsItem() {
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

    public CJRSummaryMovieDescItemV2 getMovieDescItem() {
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

    public net.one97.paytm.orders.datamodel.a getRefundModel() {
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

    public CJRMoviesUpcomingItem getUpcomingMoviesItem() {
        return this.mUpcomingMoviesItem;
    }

    public void setUpcomingMoviesItem(CJRMoviesUpcomingItem cJRMoviesUpcomingItem) {
        this.mUpcomingMoviesItem = cJRMoviesUpcomingItem;
    }

    public CJRMovieSummaryCatalogV2Item getmSummaryCatalogItem() {
        return this.mSummaryCatalogItem;
    }

    public void setmSummaryCatalogV2Item(CJRMovieSummaryCatalogV2Item cJRMovieSummaryCatalogV2Item) {
        this.mSummaryCatalogItem = cJRMovieSummaryCatalogV2Item;
    }

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public CJRSummaryItem f75156a;

        public a() {
            this.f75156a = null;
            this.f75156a = new CJRSummaryItem();
        }

        public final a a(CJRSummaryContactUsItemV2 cJRSummaryContactUsItemV2) {
            CJRSummaryContactUsItemV2 unused = this.f75156a.mContactUsItem = cJRSummaryContactUsItemV2;
            return this;
        }

        public final a a(CJRSummaryMovieDescItemV2 cJRSummaryMovieDescItemV2) {
            CJRSummaryMovieDescItemV2 unused = this.f75156a.mMovieDescItem = cJRSummaryMovieDescItemV2;
            return this;
        }

        public final a a(String str) {
            String unused = this.f75156a.mLayout = str;
            return this;
        }
    }
}
