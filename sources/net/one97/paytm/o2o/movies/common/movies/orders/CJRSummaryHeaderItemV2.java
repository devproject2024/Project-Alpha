package net.one97.paytm.o2o.movies.common.movies.orders;

import net.one97.paytm.common.entity.shopping.CJRHomePageLayoutV2;
import net.one97.paytm.common.entity.shopping.CJROrderedCart;
import net.one97.paytm.o2o.movies.entity.CJRCPTermsAndCond;

public class CJRSummaryHeaderItemV2 extends CJRHomePageLayoutV2 {
    /* access modifiers changed from: private */
    public boolean QRcodePresent;
    /* access modifiers changed from: private */
    public String badgeText;
    /* access modifiers changed from: private */
    public String date;
    /* access modifiers changed from: private */
    public CJRCPTermsAndCond insuranceTerms;
    /* access modifiers changed from: private */
    public boolean isCancellationAllowed;
    /* access modifiers changed from: private */
    public Boolean isFromPostOrder;
    /* access modifiers changed from: private */
    public int isInsurancePresent;
    /* access modifiers changed from: private */
    public String merchantName;
    /* access modifiers changed from: private */
    public int movieTicketStatus;
    /* access modifiers changed from: private */
    public String orderId;
    /* access modifiers changed from: private */
    public String orderStatus;
    /* access modifiers changed from: private */
    public CJROrderedCart orderedCartItem;
    /* access modifiers changed from: private */
    public String paymentDescription;
    /* access modifiers changed from: private */
    public String paymentStatus;
    /* access modifiers changed from: private */
    public String paymentSummary;
    /* access modifiers changed from: private */
    public boolean shareBookingId;
    /* access modifiers changed from: private */
    public double subTotal;
    /* access modifiers changed from: private */
    public String summaryType;

    public CJROrderedCart getOrderedCartItem() {
        return this.orderedCartItem;
    }

    public double getSubTotal() {
        return this.subTotal;
    }

    public String getOrderId() {
        return this.orderId;
    }

    public String getDate() {
        return this.date;
    }

    public void setDate(String str) {
        this.date = str;
    }

    public String getOrderStatus() {
        return this.orderStatus;
    }

    public String getPaymentStatus() {
        return this.paymentStatus;
    }

    public String getPaymentDescription() {
        return this.paymentDescription;
    }

    public String getSummaryType() {
        return this.summaryType;
    }

    public String getMerchantName() {
        return this.merchantName;
    }

    public String getPaymentSummary() {
        return this.paymentSummary;
    }

    public String getBadgeText() {
        return this.badgeText;
    }

    public boolean isFromPostOrder() {
        return this.isFromPostOrder.booleanValue();
    }

    public boolean isQRcodePresent() {
        return this.QRcodePresent;
    }

    public int getMovieTicketStatus() {
        return this.movieTicketStatus;
    }

    public int getIsInsurancePresent() {
        return this.isInsurancePresent;
    }

    public CJRCPTermsAndCond getInsuranceTerms() {
        return this.insuranceTerms;
    }

    public boolean isShareBookingId() {
        return this.shareBookingId;
    }

    public boolean isCancellationAllowed() {
        return this.isCancellationAllowed;
    }

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public CJRSummaryHeaderItemV2 f75153a;

        public a() {
            this.f75153a = null;
            this.f75153a = new CJRSummaryHeaderItemV2();
        }
    }
}
