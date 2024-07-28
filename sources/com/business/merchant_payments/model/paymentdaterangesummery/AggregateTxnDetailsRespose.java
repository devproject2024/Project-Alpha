package com.business.merchant_payments.model.paymentdaterangesummery;

import com.business.common_module.f.a;
import com.google.gson.a.c;

public final class AggregateTxnDetailsRespose extends a {
    public String fromToDate;
    @c(a = "amount")
    public double mAmmount;
    @c(a = "count")
    public double mCount;
    public String mEndDate;
    @c(a = "expected")
    public boolean mIsExpected;
    public String mStartDate;

    public final double getMAmmount() {
        return this.mAmmount;
    }

    public final void setMAmmount(double d2) {
        this.mAmmount = d2;
    }

    public final double getMCount() {
        return this.mCount;
    }

    public final void setMCount(double d2) {
        this.mCount = d2;
    }

    public final boolean getMIsExpected() {
        return this.mIsExpected;
    }

    public final void setMIsExpected(boolean z) {
        this.mIsExpected = z;
    }

    public final String getMStartDate() {
        return this.mStartDate;
    }

    public final void setMStartDate(String str) {
        this.mStartDate = str;
    }

    public final String getMEndDate() {
        return this.mEndDate;
    }

    public final void setMEndDate(String str) {
        this.mEndDate = str;
    }

    public final String getFromToDate() {
        return this.fromToDate;
    }

    public final void setFromToDate(String str) {
        this.fromToDate = str;
    }
}
