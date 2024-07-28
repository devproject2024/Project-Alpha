package com.business.merchant_payments.payment.model.datahelpers;

import com.business.merchant_payments.model.nonMigratedPayments.NonMigratedPaymentsModel;
import com.business.merchant_payments.model.orderSummaryList.DaywiseSummaryListModel;
import com.business.merchant_payments.model.paymentdaterangesummery.SummaryDateRangeViewData;
import com.business.merchant_payments.payment.model.PaymentsLoaderModel;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.giftcards.CJRGiftCardUserInputField;

public final class SummaryListDataHelper {
    public HashMap<String, PaymentsDataHelper> helpersMap = new HashMap<>();
    public ArrayList<PaymentsDataHelper> listDataHelpers = new ArrayList<>();
    public boolean mHasMoreRecords = true;
    public int mPageForAPI = 1;
    public SummaryDateRangeViewData summaryDateRangeViewData;

    public static /* synthetic */ void setDataFromSummaryListAPI$default(SummaryListDataHelper summaryListDataHelper, DaywiseSummaryListModel daywiseSummaryListModel, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = true;
        }
        summaryListDataHelper.setDataFromSummaryListAPI(daywiseSummaryListModel, z);
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0046  */
    /* JADX WARNING: Removed duplicated region for block: B:22:? A[ORIG_RETURN, RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void setDataFromSummaryListAPI(com.business.merchant_payments.model.orderSummaryList.DaywiseSummaryListModel r5, boolean r6) {
        /*
            r4 = this;
            java.lang.String r0 = "summaryData"
            kotlin.g.b.k.d(r5, r0)
            java.lang.Boolean r0 = r5.getHasMoreRecords()
            r1 = 0
            if (r0 == 0) goto L_0x0018
            java.lang.Boolean r0 = r5.getHasMoreRecords()
            kotlin.g.b.k.a((java.lang.Object) r0)
            boolean r0 = r0.booleanValue()
            goto L_0x0019
        L_0x0018:
            r0 = 0
        L_0x0019:
            r4.mHasMoreRecords = r0
            java.lang.Integer r0 = r5.getNextPageNumber()
            if (r0 == 0) goto L_0x003e
            java.lang.Integer r0 = r5.getNextPageNumber()
            kotlin.g.b.k.a((java.lang.Object) r0)
            int r0 = r0.intValue()
            int r2 = r4.mPageForAPI
            if (r0 <= r2) goto L_0x003e
            java.lang.Integer r0 = r5.getNextPageNumber()
            kotlin.g.b.k.a((java.lang.Object) r0)
            int r0 = r0.intValue()
            r4.mPageForAPI = r0
            goto L_0x0040
        L_0x003e:
            r4.mHasMoreRecords = r1
        L_0x0040:
            java.util.List r5 = r5.getDaywiseOrderList()
            if (r5 == 0) goto L_0x0080
            java.util.Iterator r5 = r5.iterator()
        L_0x004a:
            boolean r0 = r5.hasNext()
            if (r0 == 0) goto L_0x0080
            java.lang.Object r0 = r5.next()
            com.business.merchant_payments.model.orderSummaryList.DaywiseOrderList r0 = (com.business.merchant_payments.model.orderSummaryList.DaywiseOrderList) r0
            com.business.merchant_payments.payment.model.datahelpers.PaymentsDataHelper r2 = new com.business.merchant_payments.payment.model.datahelpers.PaymentsDataHelper
            r2.<init>()
            r2.setAlternateBackgrounds(r1)
            r3 = 1
            r2.setIsDateRangeScreen(r3)
            r2.setDataFromSummaryAPI(r0, r6)
            java.util.ArrayList<com.business.merchant_payments.payment.model.datahelpers.PaymentsDataHelper> r0 = r4.listDataHelpers
            r0.add(r2)
            java.util.HashMap<java.lang.String, com.business.merchant_payments.payment.model.datahelpers.PaymentsDataHelper> r0 = r4.helpersMap
            java.lang.String r3 = r2.getMDate()
            boolean r0 = r0.containsKey(r3)
            if (r0 != 0) goto L_0x004a
            java.util.HashMap<java.lang.String, com.business.merchant_payments.payment.model.datahelpers.PaymentsDataHelper> r0 = r4.helpersMap
            java.lang.String r3 = r2.getMDate()
            r0.put(r3, r2)
            goto L_0x004a
        L_0x0080:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.business.merchant_payments.payment.model.datahelpers.SummaryListDataHelper.setDataFromSummaryListAPI(com.business.merchant_payments.model.orderSummaryList.DaywiseSummaryListModel, boolean):void");
    }

    public final void setDataFromSummeryApi(SummaryDateRangeViewData summaryDateRangeViewData2) {
        this.summaryDateRangeViewData = summaryDateRangeViewData2;
    }

    public final ArrayList<Object> getSummaryList() {
        ArrayList<Object> arrayList = new ArrayList<>();
        SummaryDateRangeViewData summaryDateRangeViewData2 = this.summaryDateRangeViewData;
        if (!(summaryDateRangeViewData2 == null || summaryDateRangeViewData2.getTotalNoOfPayments() == null)) {
            String totalNoOfPayments = summaryDateRangeViewData2.getTotalNoOfPayments();
            k.a((Object) totalNoOfPayments);
            if (Integer.parseInt(totalNoOfPayments) > 0) {
                arrayList.add(summaryDateRangeViewData2);
            }
        }
        for (PaymentsDataHelper paymentsData : this.listDataHelpers) {
            arrayList.addAll(paymentsData.getPaymentsData());
        }
        if (this.mHasMoreRecords) {
            arrayList.add(new PaymentsLoaderModel());
        }
        return arrayList;
    }

    public final PaymentsDataHelper getPaymentsHelperForDate(String str) {
        k.d(str, CJRGiftCardUserInputField.FIELD_TYPE_CALENDAR);
        PaymentsDataHelper paymentsDataHelper = this.helpersMap.get(str);
        k.a((Object) paymentsDataHelper);
        return paymentsDataHelper;
    }

    public final boolean hasMoreRecords() {
        return this.mHasMoreRecords;
    }

    public final int getPageForAPI() {
        return this.mPageForAPI;
    }

    public final void resetSummaries() {
        this.mHasMoreRecords = true;
        this.mPageForAPI = 1;
        this.listDataHelpers.clear();
        this.helpersMap.clear();
    }

    public final void setDataFromNonMigratedAPI(NonMigratedPaymentsModel nonMigratedPaymentsModel) {
        k.d(nonMigratedPaymentsModel, "data");
        resetSummaries();
        PaymentsDataHelper paymentsDataHelper = new PaymentsDataHelper();
        paymentsDataHelper.setAlternateBackgrounds(false);
        paymentsDataHelper.setIsDateRangeScreen(true);
        paymentsDataHelper.setDataFromNonMigratedPaymentsAPI(nonMigratedPaymentsModel);
        this.listDataHelpers.add(paymentsDataHelper);
        if (!this.helpersMap.containsKey(paymentsDataHelper.getMDate())) {
            this.helpersMap.put(paymentsDataHelper.getMDate(), paymentsDataHelper);
        }
    }
}
