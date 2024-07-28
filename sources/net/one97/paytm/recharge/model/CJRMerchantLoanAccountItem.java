package net.one97.paytm.recharge.model;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.HashMap;
import net.one97.paytm.common.entity.IJRDataModel;

public final class CJRMerchantLoanAccountItem extends IJRPaytmDataModel implements IJRDataModel {
    @b(a = "account_activation_date")
    private String accountActivationDate;
    @b(a = "account_number")
    private String accountNumber;
    @b(a = "account_status")
    private String accountStatus;
    @b(a = "approved_loan_amount")
    private double approvedLoanAmount;
    @b(a = "billing_cycle")
    private String billingCycle;
    @b(a = "billing_details")
    private HashMap<String, Object> billingDetails;
    @b(a = "customer_id")
    private String customerId;
    @b(a = "disbursed_amount")
    private double disbursedAmount;
    @b(a = "display_name")
    private String displayName;
    @b(a = "dpd")
    private String dpd;
    @b(a = "excess_amount")
    private double excessAmount;
    @b(a = "installment_due_days")
    private String installmentDueDays;
    @b(a = "interest_collected")
    private double interestCollected;
    @b(a = "lender")
    private String lender;
    @b(a = "merchant_id")
    private String merchantId;
    @b(a = "meta_data")
    private HashMap<String, Object> meta_data;
    @b(a = "next_incentive_amount")
    private double nextIncentiveAmount;
    @b(a = "next_incentive_date")
    private String nextIncentiveDate;
    @b(a = "next_incentive_day")
    private String nextIncentiveDay;
    @b(a = "outstanding_principal")
    private double outstandingPrincipal;
    @b(a = "outstanding_loan_amount")
    private double outstanding_loan_amount;
    @b(a = "penalty_collected")
    private double penaltyCollected;
    @b(a = "processing_fee")
    private HashMap<String, Object> processingFee;
    @b(a = "remaining_loan")
    private double remaining_loan;
    @b(a = "remaining_tenure")
    private double remaining_tenure;
    @b(a = "repayment_product_id")
    private String repaymentProductId;
    @b(a = "roi_offered")
    private double roiOffered;
    @b(a = "standard_edi")
    private double standardEdi;
    @b(a = "standing_instruction_details")
    private HashMap<String, Object> standingInstructionDetails;
    @b(a = "total_incentive_amount")
    private double totalIncentiveAmount;
    @b(a = "totalIncentives")
    private double totalIncentives;
    @b(a = "total_interest_applied")
    private double totalInterestApplied;
    @b(a = "total_penalty_applied")
    private double totalPenaltyApplied;
    @b(a = "total_loan_tenure")
    private double total_loan_tenure;

    public final double getTotalIncentives() {
        return this.totalIncentives;
    }

    public final void setTotalIncentives(double d2) {
        this.totalIncentives = d2;
    }

    public final double getApprovedLoanAmount() {
        return this.approvedLoanAmount;
    }

    public final void setApprovedLoanAmount(double d2) {
        this.approvedLoanAmount = d2;
    }

    public final String getAccountNumber() {
        return this.accountNumber;
    }

    public final void setAccountNumber(String str) {
        this.accountNumber = str;
    }

    public final double getPenaltyCollected() {
        return this.penaltyCollected;
    }

    public final void setPenaltyCollected(double d2) {
        this.penaltyCollected = d2;
    }

    public final HashMap<String, Object> getBillingDetails() {
        return this.billingDetails;
    }

    public final void setBillingDetails(HashMap<String, Object> hashMap) {
        this.billingDetails = hashMap;
    }

    public final String getRepaymentProductId() {
        return this.repaymentProductId;
    }

    public final void setRepaymentProductId(String str) {
        this.repaymentProductId = str;
    }

    public final String getInstallmentDueDays() {
        return this.installmentDueDays;
    }

    public final void setInstallmentDueDays(String str) {
        this.installmentDueDays = str;
    }

    public final String getAccountActivationDate() {
        return this.accountActivationDate;
    }

    public final void setAccountActivationDate(String str) {
        this.accountActivationDate = str;
    }

    public final String getMerchantId() {
        return this.merchantId;
    }

    public final void setMerchantId(String str) {
        this.merchantId = str;
    }

    public final String getAccountStatus() {
        return this.accountStatus;
    }

    public final void setAccountStatus(String str) {
        this.accountStatus = str;
    }

    public final double getTotalInterestApplied() {
        return this.totalInterestApplied;
    }

    public final void setTotalInterestApplied(double d2) {
        this.totalInterestApplied = d2;
    }

    public final double getOutstandingPrincipal() {
        return this.outstandingPrincipal;
    }

    public final void setOutstandingPrincipal(double d2) {
        this.outstandingPrincipal = d2;
    }

    public final double getTotalIncentiveAmount() {
        return this.totalIncentiveAmount;
    }

    public final void setTotalIncentiveAmount(double d2) {
        this.totalIncentiveAmount = d2;
    }

    public final double getInterestCollected() {
        return this.interestCollected;
    }

    public final void setInterestCollected(double d2) {
        this.interestCollected = d2;
    }

    public final String getLender() {
        return this.lender;
    }

    public final void setLender(String str) {
        this.lender = str;
    }

    public final String getDisplayName() {
        return this.displayName;
    }

    public final void setDisplayName(String str) {
        this.displayName = str;
    }

    public final double getExcessAmount() {
        return this.excessAmount;
    }

    public final void setExcessAmount(double d2) {
        this.excessAmount = d2;
    }

    public final double getOutstanding_loan_amount() {
        return this.outstanding_loan_amount;
    }

    public final void setOutstanding_loan_amount(double d2) {
        this.outstanding_loan_amount = d2;
    }

    public final double getRemaining_tenure() {
        return this.remaining_tenure;
    }

    public final void setRemaining_tenure(double d2) {
        this.remaining_tenure = d2;
    }

    public final double getTotal_loan_tenure() {
        return this.total_loan_tenure;
    }

    public final void setTotal_loan_tenure(double d2) {
        this.total_loan_tenure = d2;
    }

    public final double getRemaining_loan() {
        return this.remaining_loan;
    }

    public final void setRemaining_loan(double d2) {
        this.remaining_loan = d2;
    }

    public final HashMap<String, Object> getMeta_data() {
        return this.meta_data;
    }

    public final void setMeta_data(HashMap<String, Object> hashMap) {
        this.meta_data = hashMap;
    }

    public final String getDpd() {
        return this.dpd;
    }

    public final void setDpd(String str) {
        this.dpd = str;
    }

    public final String getBillingCycle() {
        return this.billingCycle;
    }

    public final void setBillingCycle(String str) {
        this.billingCycle = str;
    }

    public final String getNextIncentiveDate() {
        return this.nextIncentiveDate;
    }

    public final void setNextIncentiveDate(String str) {
        this.nextIncentiveDate = str;
    }

    public final HashMap<String, Object> getProcessingFee() {
        return this.processingFee;
    }

    public final void setProcessingFee(HashMap<String, Object> hashMap) {
        this.processingFee = hashMap;
    }

    public final double getNextIncentiveAmount() {
        return this.nextIncentiveAmount;
    }

    public final void setNextIncentiveAmount(double d2) {
        this.nextIncentiveAmount = d2;
    }

    public final double getTotalPenaltyApplied() {
        return this.totalPenaltyApplied;
    }

    public final void setTotalPenaltyApplied(double d2) {
        this.totalPenaltyApplied = d2;
    }

    public final double getRoiOffered() {
        return this.roiOffered;
    }

    public final void setRoiOffered(double d2) {
        this.roiOffered = d2;
    }

    public final HashMap<String, Object> getStandingInstructionDetails() {
        return this.standingInstructionDetails;
    }

    public final void setStandingInstructionDetails(HashMap<String, Object> hashMap) {
        this.standingInstructionDetails = hashMap;
    }

    public final double getStandardEdi() {
        return this.standardEdi;
    }

    public final void setStandardEdi(double d2) {
        this.standardEdi = d2;
    }

    public final String getCustomerId() {
        return this.customerId;
    }

    public final void setCustomerId(String str) {
        this.customerId = str;
    }

    public final String getNextIncentiveDay() {
        return this.nextIncentiveDay;
    }

    public final void setNextIncentiveDay(String str) {
        this.nextIncentiveDay = str;
    }

    public final double getDisbursedAmount() {
        return this.disbursedAmount;
    }

    public final void setDisbursedAmount(double d2) {
        this.disbursedAmount = d2;
    }
}
