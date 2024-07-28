package com.travel.flight.pojo;

import com.google.gsonhtcfix.a.a;
import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import kotlin.g.b.k;

public final class ModifiedParentOrder extends IJRPaytmDataModel {
    @a
    @b(a = "message")
    private final String message;
    @a
    @b(a = "order_id")
    private final String orderId;

    public final String getMessage() {
        return this.message;
    }

    public ModifiedParentOrder(String str, String str2) {
        k.c(str, "message");
        k.c(str2, "orderId");
        this.message = str;
        this.orderId = str2;
    }

    public final String getOrderId() {
        return this.orderId;
    }
}
