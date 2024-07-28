package net.one97.paytm.o2o.movies.common.movies.orders;

import java.util.ArrayList;
import java.util.List;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.common.entity.movies.foodbeverage.CJRSummaryFoodBeveragesResponse;
import net.one97.paytm.common.entity.shopping.CJROrderSummaryPayment;
import net.one97.paytm.common.entity.shopping.CJROrderSummaryTransaction;
import net.one97.paytm.o2o.movies.common.movies.foodbeverage.CJRFoodVoucherItem;

public class CJRSummaryMoviePaymentItem implements IJRDataModel {
    /* access modifiers changed from: private */
    public List<CJRFoodVoucherItem> allFoodVoucher;
    /* access modifiers changed from: private */
    public double discountAmount;
    /* access modifiers changed from: private */
    public CJRSummaryFoodBeveragesResponse foodBeveragesResponse;
    /* access modifiers changed from: private */
    public double grandTotal;
    public ArrayList<CJROrderSummaryPayment> mPaymentInfo;
    /* access modifiers changed from: private */
    public String mTotal3Dprice;
    /* access modifiers changed from: private */
    public Object metaDataObject;
    /* access modifiers changed from: private */
    public CJROrderSummaryMetadataResponseV2 metadataResponse;
    /* access modifiers changed from: private */
    public String orderId;
    /* access modifiers changed from: private */
    public String promoCode;
    /* access modifiers changed from: private */
    public String promoText;
    /* access modifiers changed from: private */
    public String totalFoodPrice;
    /* access modifiers changed from: private */
    public String totalFoodVoucherPrice;
    /* access modifiers changed from: private */
    public ArrayList<CJROrderSummaryTransaction> transactionList;

    public CJRSummaryFoodBeveragesResponse getFoodBeveragesResponse() {
        return this.foodBeveragesResponse;
    }

    public CJROrderSummaryMetadataResponseV2 getMetaDataResponse() {
        return this.metadataResponse;
    }

    public String getPromoCode() {
        return this.promoCode;
    }

    public String getPromoText() {
        return this.promoText;
    }

    public double getGrandTotal() {
        return this.grandTotal;
    }

    public String getOrderId() {
        return this.orderId;
    }

    public Object getMetaDataObject() {
        return this.metaDataObject;
    }

    public ArrayList<CJROrderSummaryPayment> getPaymentInfo() {
        return this.mPaymentInfo;
    }

    public ArrayList<CJROrderSummaryTransaction> getTransactionList() {
        return this.transactionList;
    }

    public String getTotalFoodPrice() {
        return this.totalFoodPrice;
    }

    public String getTotalFoodVoucherPrice() {
        return this.totalFoodVoucherPrice;
    }

    public double getDiscountAmount() {
        return this.discountAmount;
    }

    public String getmTotal3Dprice() {
        return this.mTotal3Dprice;
    }

    public List<CJRFoodVoucherItem> getAllFoodVoucher() {
        return this.allFoodVoucher;
    }

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public CJRSummaryMoviePaymentItem f75155a;

        public a() {
            this.f75155a = null;
            this.f75155a = new CJRSummaryMoviePaymentItem();
        }
    }
}
