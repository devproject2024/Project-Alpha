package net.one97.paytm.paymentsBank.slfd.interestprojection.model;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.List;
import net.one97.paytm.common.entity.IJRDataModel;

public class FDTransactionHistoryModel extends IJRPaytmDataModel implements IJRDataModel {
    @com.google.gsonhtcfix.a.a
    @b(a = "booking_amount")
    private double bookingAmount;
    @com.google.gsonhtcfix.a.a
    @b(a = "booking_date")
    private double bookingDate;
    @com.google.gsonhtcfix.a.a
    @b(a = "fd_id")
    private String fdId;
    @com.google.gsonhtcfix.a.a
    @b(a = "fd_status")
    private String fdStatus;
    @com.google.gsonhtcfix.a.a
    @b(a = "interest_paid_out")
    private Double interestPaidOut;
    @com.google.gsonhtcfix.a.a
    @b(a = "interest_rate_annualized")
    private Double interestRateAnnualized;
    @com.google.gsonhtcfix.a.a
    @b(a = "interest_rate_per_annum")
    private Double interestRatePerAnnum;
    @com.google.gsonhtcfix.a.a
    @b(a = "lien_amount")
    private double lienAmount;
    @com.google.gsonhtcfix.a.a
    @b(a = "locked_amount")
    private double lockedAmount;
    @com.google.gsonhtcfix.a.a
    @b(a = "maturity_amount")
    private Double maturityAmount;
    @com.google.gsonhtcfix.a.a
    @b(a = "maturity_date")
    private long maturityDate;
    @com.google.gsonhtcfix.a.a
    @b(a = "message")
    private String message;
    @com.google.gsonhtcfix.a.a
    @b(a = "net_principal_amount")
    private Double netPrincipalAmount;
    @com.google.gsonhtcfix.a.a
    @b(a = "nominee_details")
    private a nomineeDetails;
    @com.google.gsonhtcfix.a.a
    @b(a = "response_code")
    private Integer responseCode;
    @com.google.gsonhtcfix.a.a
    @b(a = "status")
    private String status;
    @com.google.gsonhtcfix.a.a
    @b(a = "tds_deducted")
    private double tdsDeducted;
    @com.google.gsonhtcfix.a.a
    @b(a = "transaction_list")
    private List<Object> transactionList = null;
    @com.google.gsonhtcfix.a.a
    @b(a = "txn_id")
    private String txnId;

    public class a {
    }

    public String getFdId() {
        return this.fdId;
    }

    public void setFdId(String str) {
        this.fdId = str;
    }

    public Double getNetPrincipalAmount() {
        return this.netPrincipalAmount;
    }

    public void setNetPrincipalAmount(Double d2) {
        this.netPrincipalAmount = d2;
    }

    public Double getMaturityAmount() {
        return this.maturityAmount;
    }

    public void setMaturityAmount(Double d2) {
        this.maturityAmount = d2;
    }

    public Double getInterestPaidOut() {
        return this.interestPaidOut;
    }

    public void setInterestPaidOut(Double d2) {
        this.interestPaidOut = d2;
    }

    public a getNomineeDetails() {
        return this.nomineeDetails;
    }

    public void setNomineeDetails(a aVar) {
        this.nomineeDetails = aVar;
    }

    public String getFdStatus() {
        return this.fdStatus;
    }

    public void setFdStatus(String str) {
        this.fdStatus = str;
    }

    public Double getInterestRateAnnualized() {
        return this.interestRateAnnualized;
    }

    public void setInterestRateAnnualized(Double d2) {
        this.interestRateAnnualized = d2;
    }

    public Double getInterestRatePerAnnum() {
        return this.interestRatePerAnnum;
    }

    public void setInterestRatePerAnnum(Double d2) {
        this.interestRatePerAnnum = d2;
    }

    public List<Object> getTransactionList() {
        return this.transactionList;
    }

    public void setTransactionList(List<Object> list) {
        this.transactionList = list;
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

    public double getBookingAmount() {
        return this.bookingAmount;
    }

    public void setBookingAmount(double d2) {
        this.bookingAmount = d2;
    }

    public double getBookingDate() {
        return this.bookingDate;
    }

    public void setBookingDate(double d2) {
        this.bookingDate = d2;
    }

    public long getMaturityDate() {
        return this.maturityDate;
    }

    public void setMaturityDate(long j) {
        this.maturityDate = j;
    }

    public double getTdsDeducted() {
        return this.tdsDeducted;
    }

    public void setTdsDeducted(double d2) {
        this.tdsDeducted = d2;
    }

    public double getLienAmount() {
        return this.lienAmount;
    }

    public void setLienAmount(double d2) {
        this.lienAmount = d2;
    }

    public double getLockedAmount() {
        return this.lockedAmount;
    }

    public void setLockedAmount(double d2) {
        this.lockedAmount = d2;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String str) {
        this.message = str;
    }
}
