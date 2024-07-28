package com.paytmmall.artifact.order.entity;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;

public class CJRCancelReasons extends IJRPaytmDataModel {
    @b(a = "categoryId")
    private int categoryId;
    @b(a = "id")
    private String id;
    @b(a = "isActive")
    private int isActive;
    @b(a = "owner")
    private String owner;
    @b(a = "reason")
    private String reason;

    public String getId() {
        return this.id;
    }

    public String getReason() {
        return this.reason;
    }

    public String getOwner() {
        return this.owner;
    }

    public int getCategoryId() {
        return this.categoryId;
    }

    public int getIsActive() {
        return this.isActive;
    }
}
