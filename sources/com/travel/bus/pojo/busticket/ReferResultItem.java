package com.travel.bus.pojo.busticket;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;

public class ReferResultItem extends IJRPaytmDataModel {
    private static final long serialVersionUID = 1;
    @b(a = "amount")
    private int amount;
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

    public String getDate() {
        return this.date;
    }

    public int getAmount() {
        return this.amount;
    }
}
