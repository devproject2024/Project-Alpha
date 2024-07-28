package com.travel.citybus.best.model;

import com.google.gsonhtcfix.a.b;
import java.io.Serializable;

public class BestEPurse implements Serializable {
    @b(a = "activeTicket")
    private BestToken activeTicket;
    @b(a = "amountBalance")
    private float amountBalance;
    @b(a = "bonusFactor")
    private float bonusFactor;
    @b(a = "data")
    private BestToken data;
    @b(a = "denomination")
    private float denomination;
    @b(a = "logo")
    private String logo;
    @b(a = "maxPassengerCount")
    private int maxPassengerCount;
    @b(a = "maximumBalance")
    private float maximumBalance;
    @b(a = "minimumBalance")
    private float minBalance;
    @b(a = "passNumber")
    private String passNumber;
    @b(a = "userId")
    private String userId;

    public String getPassNumber() {
        return this.passNumber;
    }

    public String getUserId() {
        return this.userId;
    }

    public float getAmountBalance() {
        return this.amountBalance;
    }

    public BestToken getToken() {
        return this.data;
    }

    public void setToken(BestToken bestToken) {
        this.data = bestToken;
    }

    public float getMinBalance() {
        return this.minBalance;
    }

    public BestToken getActiveTicket() {
        return this.activeTicket;
    }

    public float getMaximumBalance() {
        return this.maximumBalance;
    }

    public float getDenomination() {
        return this.denomination;
    }

    public float getBonusFactor() {
        return this.bonusFactor;
    }

    public int getMaxPassengerCount() {
        return this.maxPassengerCount;
    }

    public String getLogo() {
        return this.logo;
    }
}
