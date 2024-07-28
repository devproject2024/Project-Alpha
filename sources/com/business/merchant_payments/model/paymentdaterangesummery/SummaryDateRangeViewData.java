package com.business.merchant_payments.model.paymentdaterangesummery;

import kotlin.g.b.k;

public final class SummaryDateRangeViewData {
    public String paymentAmout;
    public String totalNoOfPayments;

    public static /* synthetic */ SummaryDateRangeViewData copy$default(SummaryDateRangeViewData summaryDateRangeViewData, String str, String str2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = summaryDateRangeViewData.paymentAmout;
        }
        if ((i2 & 2) != 0) {
            str2 = summaryDateRangeViewData.totalNoOfPayments;
        }
        return summaryDateRangeViewData.copy(str, str2);
    }

    public final String component1() {
        return this.paymentAmout;
    }

    public final String component2() {
        return this.totalNoOfPayments;
    }

    public final SummaryDateRangeViewData copy(String str, String str2) {
        return new SummaryDateRangeViewData(str, str2);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SummaryDateRangeViewData)) {
            return false;
        }
        SummaryDateRangeViewData summaryDateRangeViewData = (SummaryDateRangeViewData) obj;
        return k.a((Object) this.paymentAmout, (Object) summaryDateRangeViewData.paymentAmout) && k.a((Object) this.totalNoOfPayments, (Object) summaryDateRangeViewData.totalNoOfPayments);
    }

    public final int hashCode() {
        String str = this.paymentAmout;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.totalNoOfPayments;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        return hashCode + i2;
    }

    public final String toString() {
        return "SummaryDateRangeViewData(paymentAmout=" + this.paymentAmout + ", totalNoOfPayments=" + this.totalNoOfPayments + ")";
    }

    public SummaryDateRangeViewData(String str, String str2) {
        this.paymentAmout = str;
        this.totalNoOfPayments = str2;
    }

    public final String getPaymentAmout() {
        return this.paymentAmout;
    }

    public final String getTotalNoOfPayments() {
        return this.totalNoOfPayments;
    }

    public final void setPaymentAmout(String str) {
        this.paymentAmout = str;
    }

    public final void setTotalNoOfPayments(String str) {
        this.totalNoOfPayments = str;
    }
}
