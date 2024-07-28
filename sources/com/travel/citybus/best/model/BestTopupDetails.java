package com.travel.citybus.best.model;

import com.google.gsonhtcfix.a.b;

public class BestTopupDetails {
    @b(a = "amount")
    private Double amount;
    @b(a = "bonus")
    private Double bonus;
    private String merchantReferenceId;
    @b(a = "transaction_id")
    private String transactionId;
    @b(a = "type")
    private String type;

    public String getTransactionId() {
        return this.transactionId;
    }

    public String getMerchantReferenceId() {
        return this.merchantReferenceId;
    }

    public Double getAmount() {
        return this.amount;
    }

    public Double getBonus() {
        return this.bonus;
    }

    public String getType() {
        return this.type;
    }
}
