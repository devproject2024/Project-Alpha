package net.one97.paytm.paymentsBank.slfd.interestprojection.model;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import java.io.Serializable;
import java.util.List;
import net.one97.paytm.common.entity.IJRDataModel;

public class FDTrialRedeemAmount extends IJRPaytmDataModel implements IJRDataModel {
    @com.google.gsonhtcfix.a.a
    @b(a = "fd_list")
    private List<a> fdList = null;
    @com.google.gsonhtcfix.a.a
    @b(a = "message")
    private String message;
    @com.google.gsonhtcfix.a.a
    @b(a = "response_code")
    private Integer responseCode;
    @com.google.gsonhtcfix.a.a
    @b(a = "status")
    private String status;
    @com.google.gsonhtcfix.a.a
    @b(a = "txn_id")
    private String txnId;

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String str) {
        this.message = str;
    }

    public List<a> getFdList() {
        return this.fdList;
    }

    public void setFdList(List<a> list) {
        this.fdList = list;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String str) {
        this.status = str;
    }

    public Integer getResponseCode() {
        return this.responseCode;
    }

    public void setResponseCode(Integer num) {
        this.responseCode = num;
    }

    public String getTxnId() {
        return this.txnId;
    }

    public void setTxnId(String str) {
        this.txnId = str;
    }

    public class a implements Serializable {
        @com.google.gsonhtcfix.a.a
        @b(a = "booking_amount")
        private Double bookingAmount;
        @com.google.gsonhtcfix.a.a
        @b(a = "booking_date")
        private String bookingDate;
        @com.google.gsonhtcfix.a.a
        @b(a = "fd_id")
        private String fdId;
        @com.google.gsonhtcfix.a.a
        @b(a = "interest_earned")
        private double interestEarned;
        @com.google.gsonhtcfix.a.a
        @b(a = "interest_rate")
        private double interestRate;
        @com.google.gsonhtcfix.a.a
        @b(a = "net_amount_payout")
        private Double netAmountPayout;
        @com.google.gsonhtcfix.a.a
        @b(a = "net_invested_amount")
        private Double netInvestedAmount;
        @com.google.gsonhtcfix.a.a
        @b(a = "redemption_amount")
        private double redemptionAmount;
        @com.google.gsonhtcfix.a.a
        @b(a = "redemption_status")
        private String redemptionStatus;

        public a() {
        }

        public final String getFdId() {
            return this.fdId;
        }

        public final void setFdId(String str) {
            this.fdId = str;
        }

        public final Double getBookingAmount() {
            return this.bookingAmount;
        }

        public final void setBookingAmount(Double d2) {
            this.bookingAmount = d2;
        }

        public final String getBookingDate() {
            return this.bookingDate;
        }

        public final void setBookingDate(String str) {
            this.bookingDate = str;
        }

        public final Double getNetInvestedAmount() {
            return this.netInvestedAmount;
        }

        public final void setNetInvestedAmount(Double d2) {
            this.netInvestedAmount = d2;
        }

        public final Double getNetAmountPayout() {
            return this.netAmountPayout;
        }

        public final void setNetAmountPayout(Double d2) {
            this.netAmountPayout = d2;
        }

        public final String getRedemptionStatus() {
            return this.redemptionStatus;
        }

        public final void setRedemptionStatus(String str) {
            this.redemptionStatus = str;
        }

        public final double getRedemptionAmount() {
            return this.redemptionAmount;
        }

        public final void setRedemptionAmount(double d2) {
            this.redemptionAmount = d2;
        }

        public final double getInterestRate() {
            return this.interestRate;
        }

        public final void setInterestRate(double d2) {
            this.interestRate = d2;
        }

        public final double getInterestEarned() {
            return this.interestEarned;
        }

        public final void setInterestEarned(double d2) {
            this.interestEarned = d2;
        }
    }
}
