package net.one97.paytm.nativesdk.common.model;

public class EmiChannelInfos implements BaseDataModel {
    private String interestRate;
    private MaxAmount maxAmount;
    private MinAmount minAmount;
    private String ofMonths;
    private String planId;

    public MinAmount getMinAmount() {
        return this.minAmount;
    }

    public void setMinAmount(MinAmount minAmount2) {
        this.minAmount = minAmount2;
    }

    public MaxAmount getMaxAmount() {
        return this.maxAmount;
    }

    public void setMaxAmount(MaxAmount maxAmount2) {
        this.maxAmount = maxAmount2;
    }

    public String getOfMonths() {
        return this.ofMonths;
    }

    public void setOfMonths(String str) {
        this.ofMonths = str;
    }

    public String getPlanId() {
        return this.planId;
    }

    public void setPlanId(String str) {
        this.planId = str;
    }

    public String getInterestRate() {
        return this.interestRate;
    }

    public void setInterestRate(String str) {
        this.interestRate = str;
    }

    public String toString() {
        return "ClassPojo [minAmount = " + this.minAmount + ", maxAmount = " + this.maxAmount + ", ofMonths = " + this.ofMonths + ", planId = " + this.planId + ", interestRate = " + this.interestRate + "]";
    }
}
