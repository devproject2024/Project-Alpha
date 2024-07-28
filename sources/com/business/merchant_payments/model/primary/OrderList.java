package com.business.merchant_payments.model.primary;

import com.business.merchant_payments.payment.model.orderDetail.OrderDetail;
import com.google.gson.a.a;
import com.google.gson.a.c;
import java.util.List;

public final class OrderList {
    @c(a = "orderList")
    @a
    public List<OrderDetail> orderList;
    @c(a = "pageNum")
    @a
    public String pageNum;
    @c(a = "pageSize")
    @a
    public String pageSize;
    @c(a = "resultInfo")
    @a
    public ResultInfo resultInfo;

    public final List<OrderDetail> getOrderList() {
        return this.orderList;
    }

    public final void setOrderList(List<OrderDetail> list) {
        this.orderList = list;
    }

    public final String getPageNum() {
        return this.pageNum;
    }

    public final void setPageNum(String str) {
        this.pageNum = str;
    }

    public final String getPageSize() {
        return this.pageSize;
    }

    public final void setPageSize(String str) {
        this.pageSize = str;
    }

    public final ResultInfo getResultInfo() {
        return this.resultInfo;
    }

    public final void setResultInfo(ResultInfo resultInfo2) {
        this.resultInfo = resultInfo2;
    }
}
