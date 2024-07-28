package net.one97.paytm.model;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;

public class PolicySummary extends IJRPaytmDataModel {
    @b(a = "lumpsum_coverage")
    private int lumpsumCoverage;
    @b(a = "payout_term")
    private String payoutTerm;
    @b(a = "payout_type")
    private String payoutType;
    @b(a = "policy_term")
    private String policyTerm;

    public void setLumpsumCoverage(int i2) {
        this.lumpsumCoverage = i2;
    }

    public int getLumpsumCoverage() {
        return this.lumpsumCoverage;
    }

    public void setPayoutType(String str) {
        this.payoutType = str;
    }

    public String getPayoutType() {
        return this.payoutType;
    }

    public void setPayoutTerm(String str) {
        this.payoutTerm = str;
    }

    public String getPayoutTerm() {
        return this.payoutTerm;
    }

    public void setPolicyTerm(String str) {
        this.policyTerm = str;
    }

    public String getPolicyTerm() {
        return this.policyTerm;
    }

    public String toString() {
        return "PolicySummary{lumpsum_coverage = '" + this.lumpsumCoverage + '\'' + ",payout_type = '" + this.payoutType + '\'' + ",payout_term = '" + this.payoutTerm + '\'' + ",policy_term = '" + this.policyTerm + '\'' + "}";
    }
}
