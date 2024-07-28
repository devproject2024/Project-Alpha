package com.travel.flight.pojo.flightticket;

import java.util.ArrayList;
import net.one97.paytm.common.entity.shopping.CJRHomePageLayoutV2;
import net.one97.paytm.common.entity.shopping.CJROrderSummaryPayment;
import net.one97.paytm.common.entity.shopping.CJROrderSummaryTransaction;
import net.one97.paytm.common.entity.trainticket.CJRFareDetails;
import net.one97.paytm.common.entity.trainticket.CJRTrainSummaryMetadataResponse;

public class CJRSummaryPaymentItem extends CJRHomePageLayoutV2 {
    /* access modifiers changed from: private */
    public CJRFareDetails fareDetails;
    public ArrayList<CJROrderSummaryPayment> mPaymentInfo;
    /* access modifiers changed from: private */
    public CJRTrainSummaryMetadataResponse metaData;
    /* access modifiers changed from: private */
    public ArrayList<CJROrderSummaryTransaction> transactionList;

    public CJRFareDetails getFareDetails() {
        return this.fareDetails;
    }

    public CJRTrainSummaryMetadataResponse getMetaDataTrain() {
        return this.metaData;
    }

    public ArrayList<CJROrderSummaryTransaction> getTransactionList() {
        return this.transactionList;
    }

    public ArrayList<CJROrderSummaryPayment> getPaymentInfo() {
        return this.mPaymentInfo;
    }
}
