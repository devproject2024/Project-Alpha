package com.travel.train.model.trainticket;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.ArrayList;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.common.entity.trainticket.CJRTrainOrderSummaryContactUs;

public class CJRTrainOrderSummaryBody extends IJRPaytmDataModel implements IJRDataModel {
    @b(a = "booking_details")
    private CJRTrainBookingDetails bookingDetails;
    @b(a = "booking_id")
    private String bookingId;
    @b(a = "cancellation_charges")
    private CJRTrainCancellationCharges cancellationCharges;
    @b(a = "cashback")
    private a cashback;
    @b(a = "contactus_details")
    private ArrayList<CJRTrainOrderSummaryContactUs> contactUsDetails = null;
    @b(a = "cp_actions")
    private ArrayList<CJRTrainOrderSummaryAction> cpActions = null;
    @b(a = "fare_details_collapsible")
    private CJRTrainOrderFareCollapse fareCollapse;
    @b(a = "fare_details")
    private ArrayList<CJRTrainFareDetail> fareDetails = null;
    @b(a = "footer")
    private CJRTrainOrderSummaryFooter footer;
    @b(a = "gst_details")
    private CJRTrainGstDetails gstDetails;
    @b(a = "no_of_pax")
    private int noOfPax;
    @b(a = "order_actions")
    private ArrayList<CJRTrainOrderSummaryAction> orderActions = null;
    @b(a = "order_status")
    private CJRTrainOrderSummaryStatus orderStatus;
    @b(a = "pax_info")
    private ArrayList<CJRTrainOrderPaxInfo> paxInfo = null;
    @b(a = "payments")
    private ArrayList<CJRTrainOrderPayment> payments = null;
    @b(a = "promo_info")
    private CJRTrainPromoInfo promoInfo;
    @b(a = "promotional_banners")
    private ArrayList<CJRTrainPromotionalBanner> promotionalBanners = null;
    @b(a = "refund_details")
    private ArrayList<CJRTrainFareDetail> refundDetails = null;
    @b(a = "refunds")
    private ArrayList<CJRTrainOrderPayment> refunds = null;
    @b(a = "status_bar")
    private CJRTrainTimerStatusBar statusBar;
    @b(a = "text_holder")
    private CJRTrainOrderTextHolder textHolder;
    @b(a = "tip_enabled")
    private boolean tipEnabled;
    @b(a = "tip_text")
    private String tipText;

    public class a {
        @b(a = "enabled")

        /* renamed from: a  reason: collision with root package name */
        public boolean f27720a;
    }

    public String getBookingId() {
        return this.bookingId;
    }

    public CJRTrainOrderSummaryStatus getOrderStatus() {
        return this.orderStatus;
    }

    public CJRTrainTimerStatusBar getStatusBar() {
        return this.statusBar;
    }

    public ArrayList<CJRTrainOrderSummaryAction> getOrderActions() {
        return this.orderActions;
    }

    public CJRTrainBookingDetails getBookingDetails() {
        return this.bookingDetails;
    }

    public Integer getNoOfPax() {
        return Integer.valueOf(this.noOfPax);
    }

    public ArrayList<CJRTrainOrderPaxInfo> getPaxInfo() {
        return this.paxInfo;
    }

    public CJRTrainOrderTextHolder getTextHolder() {
        return this.textHolder;
    }

    public ArrayList<CJRTrainPromotionalBanner> getPromotionalBanners() {
        return this.promotionalBanners;
    }

    public ArrayList<CJRTrainOrderSummaryAction> getCpActions() {
        return this.cpActions;
    }

    public CJRTrainPromoInfo getPromoInfo() {
        return this.promoInfo;
    }

    public ArrayList<CJRTrainFareDetail> getFareDetails() {
        return this.fareDetails;
    }

    public ArrayList<CJRTrainOrderPayment> getPayments() {
        return this.payments;
    }

    public CJRTrainCancellationCharges getCancellationCharges() {
        return this.cancellationCharges;
    }

    public CJRTrainGstDetails getGstDetails() {
        return this.gstDetails;
    }

    public CJRTrainOrderSummaryFooter getFooter() {
        return this.footer;
    }

    public ArrayList<CJRTrainOrderPayment> getRefunds() {
        return this.refunds;
    }

    public ArrayList<CJRTrainFareDetail> getRefundDetails() {
        return this.refundDetails;
    }

    public ArrayList<CJRTrainOrderSummaryContactUs> getContactUsDetails() {
        return this.contactUsDetails;
    }

    public boolean isTipEnabled() {
        return this.tipEnabled;
    }

    public String getTipText() {
        return this.tipText;
    }

    public CJRTrainOrderFareCollapse getFareCollapse() {
        return this.fareCollapse;
    }

    public a getCashback() {
        return this.cashback;
    }
}
