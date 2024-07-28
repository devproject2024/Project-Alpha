package com.business.merchant_payments.model.primary;

import com.google.gson.a.a;
import com.google.gson.a.c;

public final class PrimaryAPIModel {
    @c(a = "orderList")
    @a
    public OrderList orderList;
    @c(a = "orderSummary")
    @a
    public OrderSummary orderSummary;
    @c(a = "rewardsBalance")
    @a
    public RewardsBalance rewardsBalance;
    @c(a = "rewardsBalanceToday")
    @a
    public RewardsBalanceToday rewardsBalanceToday;

    public final OrderSummary getOrderSummary() {
        return this.orderSummary;
    }

    public final void setOrderSummary(OrderSummary orderSummary2) {
        this.orderSummary = orderSummary2;
    }

    public final OrderList getOrderList() {
        return this.orderList;
    }

    public final void setOrderList(OrderList orderList2) {
        this.orderList = orderList2;
    }

    public final RewardsBalance getRewardsBalance() {
        return this.rewardsBalance;
    }

    public final void setRewardsBalance(RewardsBalance rewardsBalance2) {
        this.rewardsBalance = rewardsBalance2;
    }

    public final RewardsBalanceToday getRewardsBalanceToday() {
        return this.rewardsBalanceToday;
    }

    public final void setRewardsBalanceToday(RewardsBalanceToday rewardsBalanceToday2) {
        this.rewardsBalanceToday = rewardsBalanceToday2;
    }
}
