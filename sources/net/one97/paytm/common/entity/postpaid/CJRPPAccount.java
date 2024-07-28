package net.one97.paytm.common.entity.postpaid;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import net.one97.paytm.common.entity.IJRDataModel;

public final class CJRPPAccount extends IJRPaytmDataModel implements IJRDataModel {
    @b(a = "accountStatus")
    private String accountStatus;
    @b(a = "applicationStatus")
    private String applicationStatus;
    @b(a = "authorisedCreditLimit")
    private Double authorisedCreditLimit;
    @b(a = "availableCreditLimit")
    private Double availableCreditLimit;
    @b(a = "billingDetails")
    private CJRPPBillingDetails billingDetails;
    @b(a = "eligibleCreditLimit")
    private Double eligibleCreditLimit;
    @b(a = "isInvited")
    private String isInvited;
    @b(a = "isUserEligible")
    private boolean isUserEligible;
    @b(a = "lender")
    private String lender;
    @b(a = "lenderDescription")
    private String lenderDescription;
    @b(a = "rejectionReason")
    private String rejectionReason;
    @b(a = "repaymentProductId")
    private String repaymentProductId;
    @b(a = "siEnhancedCreditLimit")
    private Double siEnhancedCreditLimit;
    @b(a = "siMandatory")
    private Boolean siMandatory;
    @b(a = "siStatus")
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
