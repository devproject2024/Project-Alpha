package net.one97.paytm.paymentsBank.model.slfd;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import net.one97.paytm.common.entity.IJRDataModel;

public final class SlfdBalanceResponseModel extends IJRPaytmDataModel implements IJRDataModel {
    @b(a = "maturity_amount")
    private double maturityAmount;
    @b(a = "message")
    private String message;
    @b(a = "net_investment")
    private double netInvestment;
    @b(a = "response_code")
    private int responseCode;
    @b(a = "status")
    private String status;
    @b(a = "interest_earned")
    private double totalInterestEarned;
    @b(a = "txn_id")
    private String txnId;
    @b(a = "unclear_booking_amount")
    private double unclearBookingAmount;
    @b(a = "unclear_redemption_amount")
    private double unclearRedemptionAmount;

    public final String getMessage() {
        return this.message;
    }

    public final void setMessage(String str) {
        this.message = str;
    }

    public final int getResponseCode() {
        return this.responseCode;
    }

    public final void setResponseCode(int i2) {
        this.responseCode = i2;
    }

    public final String getStatus() {
        return this.status;
    }

    public final void setStatus(String str) {
        this.status = str;
    }

    public final String getTxnId() {
        return this.txnId;
    }

    public final void setTxnId(String str) {
        this.txnId = str;
    }

    public final double getMaturityAmount() {
        return this.maturityAmount;
    }

    public final void setMaturityAmount(double d2) {
        this.maturityAmount = d2;
    }

    public final double getNetInvestment() {
        return this.netInvestment;
    }

    public final void setNetInvestment(double d2) {
        this.netInvestment = d2;
    }

    public final double getUnclearBookingAmount() {
        return this.unclearBookingAmount;
    }

    public final void setUnclearBookingAmount(double d2) {
        this.unclearBookingAmount = d2;
    }

    public final double getUnclearRedemptionAmount() {
        return this.unclearRedemptionAmount;
    }

    public final void setUnclearRedemptionAmount(double d2) {
        this.unclearRedemptionAmount = d2;
    }

    public final double getTotalInterestEarned() {
        return this.totalInterestEarned;
    }

    public final void setTotalInterestEarned(double d2) {
        this.totalInterestEarned = d2;
    }
}
