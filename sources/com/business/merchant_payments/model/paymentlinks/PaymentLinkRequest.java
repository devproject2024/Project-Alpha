package com.business.merchant_payments.model.paymentlinks;

import com.business.merchant_payments.model.BaseModel;

public class PaymentLinkRequest extends BaseModel {
    public boolean isSort = true;
    public String mercUnqRef;
    public String orderCreatedEndTime;
    public String orderCreatedStartTime;
    public int pageNum;
    public int pageSize;

    public PaymentLinkRequest(String str, String str2, String str3, int i2, int i3) {
        this.orderCreatedEndTime = str2;
        this.orderCreatedStartTime = str3;
        this.pageNum = i2;
        this.pageSize = i3;
        this.mercUnqRef = str;
    }

    public String getOrderCreatedEndTime() {
        return this.orderCreatedEndTime;
    }

    public void setOrderCreatedEndTime(String str) {
        this.orderCreatedEndTime = str;
    }

    public int getPageNum() {
        return this.pageNum;
    }

    public void setPageNum(int i2) {
        this.pageNum = i2;
    }

    public int getPageSize() {
        return this.pageSize;
    }

    public void setPageSize(int i2) {
        this.pageSize = i2;
    }

    public String getOrderCreatedStartTime() {
        return this.orderCreatedStartTime;
    }

    public void setOrderCreatedStartTime(String str) {
        this.orderCreatedStartTime = str;
    }
}
