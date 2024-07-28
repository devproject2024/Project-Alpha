package com.travel.citybus.best.model;

import com.google.gsonhtcfix.a.b;

public class BestPassData {
    @b(a = "balance")
    private Double balance;
    @b(a = "operator_user_id")
    private String operatorUserId;
    @b(a = "pass_id")
    private String passId;
    @b(a = "topup_details")
    private BestTopupDetails topupDetails;

    public String getPassId() {
        return this.passId;
    }

    public String getOperatorUserId() {
        return this.operatorUserId;
    }

    public Double getBalance() {
        return this.balance;
    }

    public BestTopupDetails getTopupDetails() {
        return this.topupDetails;
    }
}
