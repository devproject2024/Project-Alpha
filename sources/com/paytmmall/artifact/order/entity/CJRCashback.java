package com.paytmmall.artifact.order.entity;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;

public class CJRCashback extends IJRPaytmDataModel {
    private static final long serialVersionUID = 1;
    @b(a = "amount")
    private double cashBackAmount;
    @b(a = "cashback_text")
    private String cashbackText;

    public String getCashbackText() {
        return this.cashbackText;
    }

    public double getCashBackAmount() {
        return this.cashBackAmount;
    }
}
