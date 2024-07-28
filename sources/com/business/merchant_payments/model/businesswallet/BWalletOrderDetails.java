package com.business.merchant_payments.model.businesswallet;

import com.business.merchant_payments.model.BaseModel;
import kotlin.g.b.g;

public final class BWalletOrderDetails extends BaseModel {
    public static final Companion Companion = new Companion((g) null);
    public static final long serialVersionUID = 24235345646754L;
    public int count;
    public String errorMessage;
    public OrderDetail orderDetail;
    public String resultCode;
    public String status;

    public static final class Companion {
        public static /* synthetic */ void getSerialVersionUID$annotations() {
        }

        public Companion() {
        }

        public /* synthetic */ Companion(g gVar) {
            this();
        }
    }

    public final int getCount() {
        return this.count;
    }

    public final void setCount(int i2) {
        this.count = i2;
    }

    public final String getErrorMessage() {
        return this.errorMessage;
    }

    public final void setErrorMessage(String str) {
        this.errorMessage = str;
    }

    public final OrderDetail getOrderDetail() {
        return this.orderDetail;
    }

    public final void setOrderDetail(OrderDetail orderDetail2) {
        this.orderDetail = orderDetail2;
    }

    public final String getResultCode() {
        return this.resultCode;
    }

    public final void setResultCode(String str) {
        this.resultCode = str;
    }

    public final String getStatus() {
        return this.status;
    }

    public final void setStatus(String str) {
        this.status = str;
    }
}
