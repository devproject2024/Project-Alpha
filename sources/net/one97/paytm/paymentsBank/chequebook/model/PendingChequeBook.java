package net.one97.paytm.paymentsBank.chequebook.model;

import com.google.gsonhtcfix.a.a;
import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;

public class PendingChequeBook extends IJRPaytmDataModel {
    @a
    @b(a = "awb")
    private String awb;
    @a
    @b(a = "chequeBookNumber")
    private String chequeBookNumber;
    @a
    @b(a = "createdAt")
    private long createdAt;
    @a
    @b(a = "createdBy")
    private String createdBy;
    @a
    @b(a = "custId")
    private String custId;
    @a
    @b(a = "deliveryStatus")
    private String deliveryStatus;
    @a
    @b(a = "orderId")
    private String orderId;
    @a
    @b(a = "remark")
    private String remark;
    @a
    @b(a = "status")
    private String status;
    @a
    @b(a = "updatedAt")
    private long updatedAt;
    @a
    @b(a = "updatedBy")
    private String updatedBy;

    public long getCreatedAt() {
        return this.createdAt;
    }

    public long getUpdatedAt() {
        return this.updatedAt;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String str) {
        this.status = str;
    }

    public Object getDeliveryStatus() {
        return this.deliveryStatus;
    }

    public void setDeliveryStatus(String str) {
        this.deliveryStatus = str;
    }

    public String getOrderId() {
        return this.orderId;
    }

    public void setOrderId(String str) {
        this.orderId = str;
    }

    public String getCustId() {
        return this.custId;
    }

    public void setCustId(String str) {
        this.custId = str;
    }

    public String getChequeBookNumber() {
        return this.chequeBookNumber;
    }

    public Object getAwb() {
        return this.awb;
    }

    public void setCreatedAt(long j) {
        this.createdAt = j;
    }

    public String getCreatedBy() {
        return this.createdBy;
    }

    public void setCreatedBy(String str) {
        this.createdBy = str;
    }

    public void setUpdatedAt(long j) {
        this.updatedAt = j;
    }

    public String getRemark() {
        return this.remark;
    }

    public void setRemark(String str) {
        this.remark = str;
    }

    public void setChequeBookNumber(String str) {
        this.chequeBookNumber = str;
    }

    public void setAwb(String str) {
        this.awb = str;
    }

    public String getUpdatedBy() {
        return this.updatedBy;
    }

    public void setUpdatedBy(String str) {
        this.updatedBy = str;
    }
}
