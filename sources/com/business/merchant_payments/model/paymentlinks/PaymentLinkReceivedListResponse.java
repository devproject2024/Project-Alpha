package com.business.merchant_payments.model.paymentlinks;

import com.business.merchant_payments.model.v2.OrderDetailV2Model;
import com.google.gson.a.c;
import java.util.List;

public class PaymentLinkReceivedListResponse {
    @c(a = "orderList")
    public List<OrderDetailV2Model> orderList;
    @c(a = "pageNum")
    public String pageNum;
    @c(a = "pageSize")
    public String pageSize;
    @c(a = "resultInfo")
    public ResultInfo resultInfo;

    public void setOrderList(List<OrderDetailV2Model> list) {
        this.orderList = list;
    }

    public List<OrderDetailV2Model> getOrderList() {
        return this.orderList;
    }

    public void setPageSize(String str) {
        this.pageSize = str;
    }

    public String getPageSize() {
        return this.pageSize;
    }

    public void setPageNum(String str) {
        this.pageNum = str;
    }

    public String getPageNum() {
        return this.pageNum;
    }

    public void setResultInfo(ResultInfo resultInfo2) {
        this.resultInfo = resultInfo2;
    }

    public ResultInfo getResultInfo() {
        return this.resultInfo;
    }

    public String toString() {
        return "Response{orderList = '" + this.orderList + '\'' + ",pageSize = '" + this.pageSize + '\'' + ",pageNum = '" + this.pageNum + '\'' + ",resultInfo = '" + this.resultInfo + '\'' + "}";
    }
}
