package com.business.merchant_payments.settlement.model;

import android.text.TextUtils;
import com.business.merchant_payments.model.BaseModel;
import com.google.gson.a.c;
import java.util.List;

public class UtrSummaryModel extends BaseModel {
    public static final long serialVersionUID = 1;
    @c(a = "response")
    public UTRResponse UTRResponse;
    public String dateFilterText = "today";
    public boolean isSkeleton = false;
    public String mBankAccount;
    public String mCancelAmount;
    public String mChargeBackAmount;
    public String mCommission;
    public String mEndDate;
    public String mFromToDate;
    public String mNetTotal;
    public String mPendingAmount;
    public String mRefundToBankAmmount;
    public String mServiceTax;
    public String mStartDate;
    public String mTotalDeductions;
    public String mTotalPaymentCollected;
    public String mTotalSettlement;
    @c(a = "results")
    public List<UTRResult> results;
    @c(a = "status")
    public String status;
    @c(a = "statusCode")
    public String statusCode;
    @c(a = "statusMessage")
    public Object statusMessage;
    public UTRV2Responses utrv2Responses;

    public UTRV2Responses getUtrV2Response() {
        return this.utrv2Responses;
    }

    public void setUtrV2Response(UTRV2Responses uTRV2Responses) {
        this.utrv2Responses = uTRV2Responses;
    }

    public String getPendingAmount() {
        return this.mPendingAmount;
    }

    public String CalculateDashboardPendingAmount() {
        UTRResponse uTRResponse = this.UTRResponse;
        if (!(uTRResponse == null || uTRResponse.getDashboardSummaryResponseObject() == null)) {
            DashboardSummaryResponseObject dashboardSummaryResponseObject = this.UTRResponse.getDashboardSummaryResponseObject();
            String totalCollectedAmount = dashboardSummaryResponseObject.getTotalCollectedAmount();
            String totalNetAmount = dashboardSummaryResponseObject.getTotalNetAmount();
            String totalChargeBackAmount = dashboardSummaryResponseObject.getTotalChargeBackAmount();
            String totalCommissionAmount = dashboardSummaryResponseObject.getTotalCommissionAmount();
            String totalGstAmount = dashboardSummaryResponseObject.getTotalGstAmount();
            String totalRefundAmount = dashboardSummaryResponseObject.getTotalRefundAmount();
            Double valueOf = Double.valueOf(0.0d);
            Double valueOf2 = Double.valueOf(0.0d);
            Double valueOf3 = Double.valueOf(0.0d);
            Double valueOf4 = Double.valueOf(0.0d);
            Double valueOf5 = Double.valueOf(0.0d);
            Double valueOf6 = Double.valueOf(0.0d);
            if (!TextUtils.isEmpty(totalCollectedAmount)) {
                valueOf = Double.valueOf(Double.parseDouble(totalCollectedAmount));
            }
            if (!TextUtils.isEmpty(totalNetAmount)) {
                valueOf2 = Double.valueOf(Double.parseDouble(totalNetAmount));
            }
            if (!TextUtils.isEmpty(totalChargeBackAmount)) {
                valueOf3 = Double.valueOf(Double.parseDouble(totalChargeBackAmount));
            }
            if (!TextUtils.isEmpty(totalCommissionAmount)) {
                valueOf4 = Double.valueOf(Double.parseDouble(totalCommissionAmount));
            }
            if (!TextUtils.isEmpty(totalGstAmount)) {
                valueOf5 = Double.valueOf(Double.parseDouble(totalGstAmount));
            }
            if (!TextUtils.isEmpty(totalRefundAmount)) {
                valueOf6 = Double.valueOf(Double.parseDouble(totalRefundAmount));
            }
            double doubleValue = ((((valueOf.doubleValue() - valueOf2.doubleValue()) - valueOf3.doubleValue()) - valueOf4.doubleValue()) - valueOf5.doubleValue()) - valueOf6.doubleValue();
            if (doubleValue > 0.0d) {
                return Double.toString(doubleValue);
            }
        }
        return null;
    }

    public void setPendingAmount(String str) {
        this.mPendingAmount = str;
    }

    public String getmStartDate() {
        return this.mStartDate;
    }

    public void setmStartDate(String str) {
        this.mStartDate = str;
    }

    public String getmEndDate() {
        return this.mEndDate;
    }

    public void setmEndDate(String str) {
        this.mEndDate = str;
    }

    public String getmServiceTax() {
        return this.mServiceTax;
    }

    public void setmServiceTax(String str) {
        this.mServiceTax = str;
    }

    public String getmChargeBackAmount() {
        return this.mChargeBackAmount;
    }

    public void setmChargeBackAmount(String str) {
        this.mChargeBackAmount = str;
    }

    public String getmRefundToBankAmmount() {
        return this.mRefundToBankAmmount;
    }

    public void setmRefundToBankAmmount(String str) {
        this.mRefundToBankAmmount = str;
    }

    public String getmCommission() {
        return this.mCommission;
    }

    public void setmCommission(String str) {
        this.mCommission = str;
    }

    public String getmFromToDate() {
        return this.mFromToDate;
    }

    public void setmFromToDate(String str) {
        this.mFromToDate = str;
    }

    public String getmTotalSettlement() {
        return this.mTotalSettlement;
    }

    public void setmTotalSettlement(String str) {
        this.mTotalSettlement = str;
    }

    public String getmTotalPaymentCollected() {
        return this.mTotalPaymentCollected;
    }

    public void setmTotalPaymentCollected(String str) {
        this.mTotalPaymentCollected = str;
    }

    public String getmTotalDeductions() {
        return this.mTotalDeductions;
    }

    public String calculateDashBoardDeductions() {
        double d2;
        double d3;
        double d4;
        UTRResponse uTRResponse = this.UTRResponse;
        if (!(uTRResponse == null || uTRResponse.getDashboardSummaryResponseObject() == null)) {
            DashboardSummaryResponseObject dashboardSummaryResponseObject = this.UTRResponse.getDashboardSummaryResponseObject();
            String totalChargeBackAmount = dashboardSummaryResponseObject.getTotalChargeBackAmount();
            String totalCommissionAmount = dashboardSummaryResponseObject.getTotalCommissionAmount();
            String totalGstAmount = dashboardSummaryResponseObject.getTotalGstAmount();
            String totalRefundAmount = dashboardSummaryResponseObject.getTotalRefundAmount();
            boolean z = false;
            double d5 = 0.0d;
            if (!TextUtils.isEmpty(totalChargeBackAmount)) {
                d2 = Double.parseDouble(totalChargeBackAmount);
                z = true;
            } else {
                d2 = 0.0d;
            }
            if (!TextUtils.isEmpty(totalCommissionAmount)) {
                d3 = Double.parseDouble(totalCommissionAmount);
                z = true;
            } else {
                d3 = 0.0d;
            }
            if (!TextUtils.isEmpty(totalGstAmount)) {
                d4 = Double.parseDouble(totalGstAmount);
                z = true;
            } else {
                d4 = 0.0d;
            }
            if (!TextUtils.isEmpty(totalRefundAmount)) {
                d5 = Double.parseDouble(totalRefundAmount);
                z = true;
            }
            double d6 = d2 + d3 + d4 + d5;
            if (z) {
                return Double.toString(d6);
            }
        }
        return null;
    }

    public void setmTotalDeductions(String str) {
        this.mTotalDeductions = str;
    }

    public String getmNetTotal() {
        return this.mNetTotal;
    }

    public void setmNetTotal(String str) {
        this.mNetTotal = str;
    }

    public String getBankAccount() {
        return this.mBankAccount;
    }

    public void setBankAccount(String str) {
        this.mBankAccount = str;
    }

    public String getDateFilterText() {
        return this.dateFilterText;
    }

    public void setDateFilterText(String str) {
        this.dateFilterText = str;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String str) {
        this.status = str;
    }

    public String getStatusCode() {
        return this.statusCode;
    }

    public void setStatusCode(String str) {
        this.statusCode = str;
    }

    public Object getStatusMessage() {
        return this.statusMessage;
    }

    public void setStatusMessage(Object obj) {
        this.statusMessage = obj;
    }

    public UTRResponse getUTRResponse() {
        if (this.UTRResponse == null && this.results != null) {
            UTRResponse uTRResponse = new UTRResponse();
            this.UTRResponse = uTRResponse;
            uTRResponse.setUTRResult(this.results);
        }
        return this.UTRResponse;
    }

    public void setUTRResponse(UTRResponse uTRResponse) {
        this.UTRResponse = uTRResponse;
    }

    public String getTotalCollectedAmount() {
        UTRResponse uTRResponse = this.UTRResponse;
        if (uTRResponse == null || uTRResponse.getDashboardSummaryResponseObject() == null) {
            return null;
        }
        return this.UTRResponse.getDashboardSummaryResponseObject().getTotalCollectedAmount();
    }

    public String getTotalNetAmount() {
        UTRResponse uTRResponse = this.UTRResponse;
        if (uTRResponse == null || uTRResponse.getDashboardSummaryResponseObject() == null) {
            return null;
        }
        return this.UTRResponse.getDashboardSummaryResponseObject().getTotalNetAmount();
    }

    public String getTotalChargeBackAmount() {
        UTRResponse uTRResponse = this.UTRResponse;
        if (uTRResponse == null || uTRResponse.getDashboardSummaryResponseObject() == null) {
            return null;
        }
        return this.UTRResponse.getDashboardSummaryResponseObject().getTotalChargeBackAmount();
    }

    public String getTotalCommissionAmount() {
        UTRResponse uTRResponse = this.UTRResponse;
        if (uTRResponse == null || uTRResponse.getDashboardSummaryResponseObject() == null) {
            return null;
        }
        return this.UTRResponse.getDashboardSummaryResponseObject().getTotalCommissionAmount();
    }

    public String getTotalGstAmount() {
        UTRResponse uTRResponse = this.UTRResponse;
        if (uTRResponse == null || uTRResponse.getDashboardSummaryResponseObject() == null) {
            return null;
        }
        return this.UTRResponse.getDashboardSummaryResponseObject().getTotalGstAmount();
    }

    public String getTotalRefundAmount() {
        UTRResponse uTRResponse = this.UTRResponse;
        if (uTRResponse == null || uTRResponse.getDashboardSummaryResponseObject() == null) {
            return null;
        }
        return this.UTRResponse.getDashboardSummaryResponseObject().getTotalRefundAmount();
    }

    public String getmCancelAmount() {
        return this.mCancelAmount;
    }

    public void setmCancelAmount(String str) {
        this.mCancelAmount = str;
    }
}
