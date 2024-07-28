package com.business.merchant_payments.model.orderSummaryList;

import com.business.merchant_payments.model.primary.TotalAmount;
import com.business.merchant_payments.payment.model.orderDetail.OrderDetail;
import com.google.gson.a.a;
import com.google.gson.a.c;
import java.util.List;

public final class DaywiseOrderList {
    @c(a = "date")
    @a
    public String date;
    @c(a = "orderList")
    @a
    public List<OrderDetail> orderList;
    @c(a = "totalAmount")
    @a
    public TotalAmount totalAmount;
    @c(a = "totalCount")
    @a
    public String totalCount;

    public final String getDate() {
        return this.date;
    }

    public final void setDate(String str) {
        this.date = str;
    }

    public final String getTotalCount() {
        return this.totalCount;
    }

    public final void setTotalCount(String str) {
        this.totalCount = str;
    }

    public final TotalAmount getTotalAmount() {
        return this.totalAmount;
    }

    public final void setTotalAmount(TotalAmount totalAmount2) {
        this.totalAmount = totalAmount2;
    }

    public final List<OrderDetail> getOrderList() {
        return this.orderList;
    }

    public final void setOrderList(List<OrderDetail> list) {
        this.orderList = list;
    }
}
