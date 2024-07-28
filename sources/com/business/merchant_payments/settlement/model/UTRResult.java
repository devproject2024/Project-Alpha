package com.business.merchant_payments.settlement.model;

import android.text.TextUtils;
import com.business.merchant_payments.PaymentsConfig;
import com.business.merchant_payments.common.utility.AppUtility;
import com.business.merchant_payments.model.BaseModel;
import com.google.gson.a.c;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;

public class UTRResult extends BaseModel implements Comparable<UTRResult> {
    public static final long serialVersionUID = 1;
    @c(a = "cbAmount")
    public String cbAmount;
    @c(a = "chargeBackAmount")
    public String chargeBackAmount;
    @c(a = "commission")
    public String commission;
    @c(a = "commissionAmount")
    public String commissionAmount;
    public String consolidateUtr;
    @c(a = "creationDate")
    public long creationDate;
    @c(a = "grossAmt")
    public String grossAmt;
    public String mSelectedDate;
    public String mStoredPendingReconIds;
    public String mStoredTxnReconIds;
    @c(a = "payAmount")
    public String payAmount;
    @c(a = "payoutDate")
    public String payoutDate;
    public double pendingChargeBack;
    public double pendingCommission;
    public double pendingGrossAmount;
    public double pendingPayoutAmount;
    public double pendingRefundAmount;
    public double pendingServiceTax;
    public double pendingTxnAmount;
    @c(a = "reconId")
    public String reconId;
    @c(a = "refundAmount")
    public String refundAmount;
    @c(a = "refundWithdrawAmount")
    public String refundWithdrawAmount;
    @c(a = "serviceTax")
    public String serviceTax;
    @c(a = "settledAmount")
    public String settledAmount;
    public SettlementBills settlementBills;
    @c(a = "settlementDate")
    public long settlementDate;
    public boolean showPendingAmount;
    public boolean showTransferredAmount;
    @c(a = "txnAmount")
    public String txnAmount;
    @c(a = "utr")
    public String utr;
    @c(a = "utrNo")
    public String utrNo;

    public String getPayoutDate() {
        SettlementBills settlementBills2 = this.settlementBills;
        if (settlementBills2 == null) {
            return this.payoutDate;
        }
        return settlementBills2.getSettlementTime();
    }

    public String getUtrNo() {
        SettlementBills settlementBills2 = this.settlementBills;
        if (settlementBills2 == null) {
            return this.utrNo;
        }
        return (settlementBills2.getUtrNoList() == null || this.settlementBills.getUtrNoList().size() <= 0) ? "" : this.settlementBills.getUtrNoList().get(0);
    }

    public SettlementBills getSettlementBills() {
        return this.settlementBills;
    }

    public void setSettlementBills(SettlementBills settlementBills2) {
        this.settlementBills = settlementBills2;
    }

    public String getConsolidateUtr() {
        return this.consolidateUtr;
    }

    public void setConsolidateUtr(String str) {
        this.consolidateUtr = str;
    }

    public double getPendingPayoutAmount() {
        SettlementBills settlementBills2 = this.settlementBills;
        if (settlementBills2 == null) {
            return this.pendingPayoutAmount;
        }
        if (settlementBills2.getNetAmount() != null) {
            return getValue(this.settlementBills.getNetAmount().getValue()).doubleValue();
        }
        return 0.0d;
    }

    public void setPendingPayoutAmount(double d2) {
        this.pendingPayoutAmount = d2;
    }

    public boolean isShowPendingAmount() {
        return this.showPendingAmount;
    }

    public void setShowPendingAmount(boolean z) {
        this.showPendingAmount = z;
    }

    public boolean isShowTransferredAmount() {
        return this.showTransferredAmount;
    }

    public void setShowTransferredAmount(boolean z) {
        this.showTransferredAmount = z;
    }

    public long getCreationDate() {
        if (this.settlementBills == null) {
            if (!AppUtility.isNonEmptyString(this.payoutDate)) {
                return this.creationDate;
            }
            try {
                return new SimpleDateFormat("yyyy-MM-dd", Locale.US).parse(this.payoutDate).getTime();
            } catch (ParseException e2) {
                e2.printStackTrace();
                return 0;
            }
        } else if (!AppUtility.isNonEmptyString(this.payoutDate)) {
            return this.creationDate;
        } else {
            try {
                return new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZZZZZ", Locale.US).parse(this.payoutDate).getTime();
            } catch (ParseException e3) {
                e3.printStackTrace();
                return 0;
            }
        }
    }

    public void setCreationDate(long j) {
        this.creationDate = j;
    }

    public String getmSelectedDate() {
        return this.mSelectedDate;
    }

    public void setmSelectedDate(String str) {
        this.mSelectedDate = str;
    }

    public String getStoredTxnReconIds() {
        return this.mStoredTxnReconIds;
    }

    public void setStoredTxnReconIds(String str) {
        this.mStoredTxnReconIds = str;
    }

    public String getUtr() {
        if (AppUtility.isNonEmptyString(getUtrNo())) {
            return getUtrNo();
        }
        return this.utr;
    }

    public void setUtr(String str) {
        this.utr = str;
    }

    public String getReconId() {
        return this.reconId;
    }

    public void setReconId(String str) {
        this.reconId = str;
    }

    public double getTxnAmount() {
        if (AppUtility.isNonEmptyString(this.txnAmount)) {
            return Double.parseDouble(this.txnAmount);
        }
        return 0.0d;
    }

    public void setTxnAmount(double d2) {
        this.txnAmount = String.valueOf(d2);
    }

    public double getRefundWithdrawAmount() {
        if (AppUtility.isNonEmptyString(this.refundAmount)) {
            return Double.parseDouble(this.refundAmount);
        }
        if (AppUtility.isNonEmptyString(this.refundWithdrawAmount)) {
            return Double.parseDouble(this.refundWithdrawAmount);
        }
        return 0.0d;
    }

    public void setRefundWithdrawAmount(double d2) {
        this.refundWithdrawAmount = String.valueOf(d2);
    }

    public double getChargeBackAmount() {
        if (AppUtility.isNonEmptyString(this.cbAmount)) {
            return Double.parseDouble(this.cbAmount);
        }
        if (AppUtility.isNonEmptyString(this.chargeBackAmount)) {
            return Double.parseDouble(this.chargeBackAmount);
        }
        return 0.0d;
    }

    public void setChargeBackAmount(double d2) {
        this.chargeBackAmount = String.valueOf(d2);
    }

    public double getGrossAmt() {
        if (AppUtility.isNonEmptyString(this.grossAmt)) {
            return Double.parseDouble(this.grossAmt);
        }
        return 0.0d;
    }

    public void setGrossAmt(double d2) {
        this.grossAmt = String.valueOf(d2);
    }

    public double getCommission() {
        if (AppUtility.isNonEmptyString(this.commissionAmount)) {
            return Double.parseDouble(this.commissionAmount);
        }
        if (AppUtility.isNonEmptyString(this.commission)) {
            return Double.parseDouble(this.commission);
        }
        return 0.0d;
    }

    public void setCommission(double d2) {
        this.commission = String.valueOf(d2);
    }

    public double getServiceTax() {
        if (AppUtility.isNonEmptyString(this.serviceTax)) {
            return Double.parseDouble(this.serviceTax);
        }
        return 0.0d;
    }

    public void setServiceTax(double d2) {
        this.serviceTax = String.valueOf(d2);
    }

    public double getPayAmount() {
        SettlementBills settlementBills2 = this.settlementBills;
        if (settlementBills2 == null) {
            if (PaymentsConfig.getInstance().getMerchantDataProvider().q()) {
                if (AppUtility.isNonEmptyString(this.settledAmount)) {
                    return Double.parseDouble(this.settledAmount);
                }
            } else if (AppUtility.isNonEmptyString(this.grossAmt)) {
                return Double.parseDouble(this.grossAmt);
            }
            return 0.0d;
        } else if (settlementBills2.getNetAmount() != null) {
            return getValue(this.settlementBills.getNetAmount().getValue()).doubleValue();
        } else {
            return 0.0d;
        }
    }

    public void setPayAmount(double d2) {
        if (PaymentsConfig.getInstance().getMerchantDataProvider().q()) {
            this.settledAmount = String.valueOf(d2);
        } else {
            this.grossAmt = String.valueOf(d2);
        }
    }

    public void setSettledAmount(double d2) {
        this.settledAmount = String.valueOf(d2);
    }

    public long getSettlementDate() {
        if (this.settlementBills == null) {
            if (!AppUtility.isNonEmptyString(getPayoutDate())) {
                return this.settlementDate;
            }
            try {
                return new SimpleDateFormat("yyyy-MM-dd", Locale.US).parse(getPayoutDate()).getTime();
            } catch (ParseException e2) {
                e2.printStackTrace();
                return 0;
            }
        } else if (!AppUtility.isNonEmptyString(getPayoutDate())) {
            return this.settlementDate;
        } else {
            try {
                return new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZZZZZ", Locale.US).parse(getPayoutDate()).getTime();
            } catch (ParseException e3) {
                e3.printStackTrace();
                return 0;
            }
        }
    }

    public void setSettlementDate(long j) {
        this.settlementDate = j;
    }

    public int compareTo(UTRResult uTRResult) {
        if (getSettlementDate() > uTRResult.getSettlementDate()) {
            return -1;
        }
        return getSettlementDate() < uTRResult.getSettlementDate() ? 1 : 0;
    }

    public String getStoredPendingReconIds() {
        return this.mStoredPendingReconIds;
    }

    public void setStoredPendingReconIds(String str) {
        this.mStoredPendingReconIds = str;
    }

    public double getPendingRefundAmount() {
        SettlementBills settlementBills2 = this.settlementBills;
        if (settlementBills2 == null) {
            return this.pendingRefundAmount;
        }
        if (settlementBills2.getNetAmountInfo() == null || this.settlementBills.getNetAmountInfo().getRefundAmount() == null) {
            return 0.0d;
        }
        return getValue(this.settlementBills.getNetAmountInfo().getRefundAmount().getValue()).doubleValue();
    }

    public void setPendingRefundAmount(double d2) {
        this.pendingRefundAmount = d2;
    }

    public double getPendingTxnAmount() {
        if (this.settlementBills != null) {
            return getPendingAmountFromBillSettlement();
        }
        return this.pendingTxnAmount;
    }

    private double getPendingAmountFromBillSettlement() {
        if (!TextUtils.isEmpty(this.settlementBills.getNetAmount().getValue())) {
            return Double.valueOf(this.settlementBills.getNetAmount().getValue()).doubleValue();
        }
        return 0.0d;
    }

    public void setPendingTxnAmount(double d2) {
        this.pendingTxnAmount = d2;
    }

    public double getPendingCommission() {
        SettlementBills settlementBills2 = this.settlementBills;
        if (settlementBills2 == null) {
            return this.pendingCommission;
        }
        if (settlementBills2.getNetAmountInfo() == null || this.settlementBills.getNetAmountInfo().getCommission() == null) {
            return 0.0d;
        }
        return getValue(this.settlementBills.getNetAmountInfo().getCommission().getValue()).doubleValue();
    }

    public void setPendingCommission(double d2) {
        this.pendingCommission = d2;
    }

    public double getPendingGrossAmount() {
        SettlementBills settlementBills2 = this.settlementBills;
        if (settlementBills2 == null) {
            return this.pendingGrossAmount;
        }
        return getValue(settlementBills2.getNetAmount().getValue()).doubleValue();
    }

    public void setPendingGrossAmount(double d2) {
        this.pendingGrossAmount = d2;
    }

    public double getPendingChargeBack() {
        SettlementBills settlementBills2 = this.settlementBills;
        if (settlementBills2 == null) {
            return this.pendingChargeBack;
        }
        if (settlementBills2.getNetAmountInfo() == null || this.settlementBills.getNetAmountInfo().getChargebackAmount() == null) {
            return 0.0d;
        }
        return getValue(this.settlementBills.getNetAmountInfo().getChargebackAmount().getValue()).doubleValue();
    }

    public void setPendingChargeBack(double d2) {
        this.pendingChargeBack = d2;
    }

    public double getPendingServiceTax() {
        SettlementBills settlementBills2 = this.settlementBills;
        if (settlementBills2 == null) {
            return this.pendingServiceTax;
        }
        if (settlementBills2.getNetAmountInfo() == null || this.settlementBills.getNetAmountInfo().getGstAmount() == null) {
            return 0.0d;
        }
        return getValue(this.settlementBills.getNetAmountInfo().getGstAmount().getValue()).doubleValue();
    }

    public void setPendingServiceTax(double d2) {
        this.pendingServiceTax = d2;
    }

    public Double getValue(String str) {
        if (!TextUtils.isEmpty(str)) {
            return Double.valueOf(Double.valueOf(str).doubleValue() / 100.0d);
        }
        return Double.valueOf(0.0d);
    }
}
