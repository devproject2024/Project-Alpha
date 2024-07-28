package net.one97.paytm.paymentsBank.slfd.model;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import net.one97.paytm.common.entity.IJRDataModel;

public class FixedDepositModel extends IJRPaytmDataModel implements IJRDataModel {
    @b(a = "amount")
    private double mAmount;
    @b(a = "bookingDateTime")
    private String mBookingDateTime;
    @b(a = "bookingTransactionId")
    private String mBookingTransactionId;
    @b(a = "effOpenDate")
    private String mEffOpenDate;
    @b(a = "fdNumber")
    private String mFdNumber;
    @b(a = "interestRate")
    private double mInterestRate;
    private boolean mIsSelectable;
    private boolean mIsSelected;
    @b(a = "maturityAmt")
    private double mMaturityAmt;
    @b(a = "recordNum")
    private int mRecordNum;
    @b(a = "status")
    private String mStatus;
    @b(a = "tenureDays")
    private int mTenureDays;
    @b(a = "tenureMonth")
    private int mTenureMonth;

    public String getBookingTransactionId() {
        return this.mBookingTransactionId;
    }

    public String getBookingDateTime() {
        return this.mBookingDateTime;
    }

    public double getAmount() {
        return this.mAmount;
    }

    public String getFdNumber() {
        return this.mFdNumber;
    }

    public String getEffOpenDate() {
        return this.mEffOpenDate;
    }

    public double getInterestRate() {
        return this.mInterestRate;
    }

    public double getMaturityAmt() {
        return this.mMaturityAmt;
    }

    public int getTenureMonth() {
        return this.mTenureMonth;
    }

    public int getTenureDays() {
        return this.mTenureDays;
    }

    public String getStatus() {
        return this.mStatus;
    }

    public int getRecordNum() {
        return this.mRecordNum;
    }

    public void setSelected(boolean z) {
        this.mIsSelected = z;
    }

    public boolean isSelected() {
        return this.mIsSelected;
    }

    public void setSelectable(boolean z) {
        this.mIsSelectable = z;
    }

    public boolean isSelectable() {
        return this.mIsSelectable;
    }
}
