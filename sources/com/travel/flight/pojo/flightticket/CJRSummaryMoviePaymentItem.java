package com.travel.flight.pojo.flightticket;

import java.util.ArrayList;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.common.entity.shopping.CJROrderSummaryMetadataResponse;
import net.one97.paytm.common.entity.shopping.CJROrderSummaryPayment;
import net.one97.paytm.common.entity.shopping.CJROrderSummaryTransaction;

public class CJRSummaryMoviePaymentItem implements IJRDataModel {
    /* access modifiers changed from: private */
    public String bookingID;
    /* access modifiers changed from: private */
    public double grandTotal;
    public ArrayList<CJROrderSummaryPayment> mPaymentInfo;
    /* access modifiers changed from: private */
    public Object metaDataObject;
    /* access modifiers changed from: private */
    public CJROrderSummaryMetadataResponse metadataResponse;
    /* access modifiers changed from: private */
    public String paytmId;
    /* access modifiers changed from: private */
    public String promoCode;
    /* access modifiers changed from: private */
    public String promoText;
    /* access modifiers changed from: private */
    public String totalFoodPrice;
    /* access modifiers changed from: private */
    public ArrayList<CJROrderSummaryTransaction> transactionList;

    public CJROrderSummaryMetadataResponse getMetaDataResponse() {
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

    public String getPaytmId() {
        return this.paytmId;
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

    public String getBookingID() {
        return this.bookingID;
    }
}
