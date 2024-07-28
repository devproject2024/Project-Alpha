package com.travel.travels.model;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;

public class ReferResultItem extends IJRPaytmDataModel {
    private static final long serialVersionUID = 1;
    @b(a = "amount")
    private int amount;
    @b(a = "createdOn")
    private String createdOn;
    @b(a = "date")
    private String date;
    @b(a = "message")
    private String message;
    @b(a = "name")
    private String name;
    @b(a = "vertical")
    private String vertical;

    public String getVertical() {
        return this.vertical;
    }

    public void setVertical(String str) {
        this.vertical = str;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    public String getDate() {
        return this.date;
    }

    public void setDate(String str) {
        this.date = str;
    }

    public int getAmount() {
        return this.amount;
    }

    public void setAmount(int i2) {
        this.amount = i2;
    }

    public String getCreatedOn() {
        return this.createdOn;
    }

    public void setCreatedOn(String str) {
        this.createdOn = str;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String str) {
        this.message = str;
    }
}
