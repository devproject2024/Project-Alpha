package com.business.merchant_payments.model.v2;

import com.business.merchant_payments.model.paymentlinks.ResultInfo;
import com.google.gson.a.a;
import com.google.gson.a.c;
import java.util.List;

public class OrderListV2 {
    @c(a = "orderList")
    @a
    public List<OrderDetailV2Model> orderList = null;
    @c(a = "pageNum")
    @a
    public String pageNum;
    @c(a = "pageSize")
    @a
    public String pageSize;
    @c(a = "resultInfo")
    @a
    public ResultInfo resultInfo;

    public List<OrderDetailV2Model> getOrderList() {
        return this.orderList;
    }

    public void setOrderList(List<OrderDetailV2Model> list) {
        this.orderList = list;
    }

    public String getPageNum() {
        return this.pageNum;
    }

    public void setPageNum(String str) {
        this.pageNum = str;
    }

    public String getPageSize() {
        return this.pageSize;
    }

    public void setPageSize(String str) {
        this.pageSize = str;
    }

    public ResultInfo getResultInfo() {
        return this.resultInfo;
    }

    public void setResultInfo(ResultInfo resultInfo2) {
        this.resultInfo = resultInfo2;
    }
}
