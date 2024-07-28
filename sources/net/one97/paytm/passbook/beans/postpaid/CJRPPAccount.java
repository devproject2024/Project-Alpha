package net.one97.paytm.passbook.beans.postpaid;

import com.google.gson.a.c;
import net.one97.paytm.passbook.mapping.IJRDataModel;

public final class CJRPPAccount extends IJRDataModel {
    @c(a = "accountStatus")
    private String accountStatus;
    @c(a = "applicationStatus")
    private String applicationStatus;
    @c(a = "authorisedCreditLimit")
    private Double authorisedCreditLimit;
    @c(a = "availableCreditLimit")
    private Double availableCreditLimit;
    @c(a = "billingDetails")
    private CJRPPBillingDetails billingDetails;
    @c(a = "eligibleCreditLimit")
    private Double eligibleCreditLimit;
    @c(a = "isInvited")
    private String isInvited;
    @c(a = "isUserEligible")
    private boolean isUserEligible;
    @c(a = "lender")
    private String lender;
    @c(a = "lenderDescription")
    private String lenderDescription;
    @c(a = "rejectionReason")
    private String rejectionReason;
    @c(a = "repaymentProductId")
    private String repaymentProductId;
    @c(a = "siEnhancedCreditLimit")
    private Double siEnhancedCreditLimit;
    @c(a = "siMandatory")
    private Boolean siMandatory;
    @c(a = "siStatus")
    private String siStatus;

    public final String getRejectionReason() {
        return this.rejectionReason;
    }

    public final void setRejectionReason(String str) {
        this.rejectionReason = str;
    }

    public final String isInvited() {
        return this.isInvited;
    }

    public final void setInvited(String str) {
        this.isInvited = str;
    }

    public final boolean isUserEligible() {
        return this.isUserEligible;
    }

    public final void setUserEligible(boolean z) {
        this.isUserEligible = z;
    }

    public final String getAccountStatus() {
        return this.accountStatus;
    }

    public final void setAccountStatus(String str) {
        this.accountStatus = str;
    }

    public final Double getAuthorisedCreditLimit() {
        return this.authorisedCreditLimit;
    }

    public final void setAuthorisedCreditLimit(Double d2) {
        this.authorisedCreditLimit = d2;
    }

    public final Double getEligibleCreditLimit() {
        return this.eligibleCreditLimit;
    }

    public final void setEligibleCreditLimit(Double d2) {
        this.eligibleCreditLimit = d2;
    }

    public final String getApplicationStatus() {
        return this.applicationStatus;
    }

    public final void setApplicationStatus(String str) {
        this.applicationStatus = str;
    }

    public final String getLenderDescription() {
        return this.lenderDescription;
    }

    public final void setLenderDescription(String str) {
        this.lenderDescription = str;
    }

    public final String getRepaymentProductId() {
        return this.repaymentProductId;
    }

    public final void setRepaymentProductId(String str) {
        this.repaymentProductId = str;
    }

    public final CJRPPBillingDetails getBillingDetails() {
        return this.billingDetails;
    }

    public final void setBillingDetails(CJRPPBillingDetails cJRPPBillingDetails) {
        this.billingDetails = cJRPPBillingDetails;
    }

    public final String getLender() {
        return this.lender;
    }

    public final void setLender(String str) {
        this.lender = str;
    }

    public final Double getAvailableCreditLimit() {
        return this.availableCreditLimit;
    }

    public final void setAvailableCreditLimit(Double d2) {
        this.availableCreditLimit = d2;
    }

    public final Double getSiEnhancedCreditLimit() {
        return this.siEnhancedCreditLimit;
    }

    public final void setSiEnhancedCreditLimit(Double d2) {
        this.siEnhancedCreditLimit = d2;
    }

    public final String getSiStatus() {
        return this.siStatus;
    }

    public final void setSiStatus(String str) {
        this.siStatus = str;
    }

    public final Boolean getSiMandatory() {
        return this.siMandatory;
    }

    public final void setSiMandatory(Boolean bool) {
        this.siMandatory = bool;
    }
}
