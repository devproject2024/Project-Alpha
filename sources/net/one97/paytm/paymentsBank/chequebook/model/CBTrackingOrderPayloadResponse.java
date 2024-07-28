package net.one97.paytm.paymentsBank.chequebook.model;

import com.google.gsonhtcfix.a.a;
import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.ArrayList;

public class CBTrackingOrderPayloadResponse extends IJRPaytmDataModel {
    @a
    @b(a = "cancellationReason")
    private String cancellationReason;
    @a
    @b(a = "courierDetail")
    private CBTrackingOrderCourierDetail courierDetail;
    @a
    @b(a = "createdAt")
    private String createdAt;
    @a
    @b(a = "currentStatus")
    private String currentStatus;
    @a
    @b(a = "currentStatusId")
    private String currentStatusId;
    @a
    @b(a = "customerId")
    private String customerId;
    @a
    @b(a = "deliveredAt")
    private String deliveredAt;
    @a
    @b(a = "expectedDateOfDelivery")
    private String expectedDateOfDelivery;
    @a
    @b(a = "name")
    private String name;
    @a
    @b(a = "orderId")
    private String orderId;
    @a
    @b(a = "paymentStatus")
    private String paymentStatus;
    @a
    @b(a = "price")
    private String price;
    @a
    @b(a = "productId")
    private String productId;
    @a
    @b(a = "quantity")
    private int quantity;
    @a
    @b(a = "reIssue")
    private String reIssue;
    @a
    @b(a = "statusFlow")
    private ArrayList<CBTrackingOrderStatusFlow> statusFlow;
    @a
    @b(a = "userDetail")
    private CBTrackingOrderUserDetails userDetail;

    public String getOrderId() {
        return this.orderId;
    }

    public void setOrderId(String str) {
        this.orderId = str;
    }

    public String getPrice() {
        return this.price;
    }

    public void setPrice(String str) {
        this.price = str;
    }

    public String getPaymentStatus() {
        return this.paymentStatus;
    }

    public void setPaymentStatus(String str) {
        this.paymentStatus = str;
    }

    public String getCreatedAt() {
        return this.createdAt;
    }

    public void setCreatedAt(String str) {
        this.createdAt = str;
    }

    public String getExpectedDateOfDelivery() {
        return this.expectedDateOfDelivery;
    }

    public void setExpectedDateOfDelivery(String str) {
        this.expectedDateOfDelivery = str;
    }

    public String getCurrentStatus() {
        return this.currentStatus;
    }

    public void setCurrentStatus(String str) {
        this.currentStatus = str;
    }

    public String getCurrentStatusId() {
        return this.currentStatusId;
    }

    public void setCurrentStatusId(String str) {
        this.currentStatusId = str;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public void setQuantity(int i2) {
        this.quantity = i2;
    }

    public String getCancellationReason() {
        return this.cancellationReason;
    }

    public void setCancellationReason(String str) {
        this.cancellationReason = str;
    }

    public String getReIssue() {
        return this.reIssue;
    }

    public void setReIssue(String str) {
        this.reIssue = str;
    }

    public String getCustomerId() {
        return this.customerId;
    }

    public void setCustomerId(String str) {
        this.customerId = str;
    }

    public String getProductId() {
        return this.productId;
    }

    public void setProductId(String str) {
        this.productId = str;
    }

    public ArrayList<CBTrackingOrderStatusFlow> getStatusFlow() {
        return this.statusFlow;
    }

    public void setStatusFlow(ArrayList<CBTrackingOrderStatusFlow> arrayList) {
        this.statusFlow = arrayList;
    }

    public CBTrackingOrderUserDetails getUserDetail() {
        return this.userDetail;
    }

    public void setUserDetail(CBTrackingOrderUserDetails cBTrackingOrderUserDetails) {
        this.userDetail = cBTrackingOrderUserDetails;
    }

    public CBTrackingOrderCourierDetail getCourierDetail() {
        return this.courierDetail;
    }

    public void setCourierDetail(CBTrackingOrderCourierDetail cBTrackingOrderCourierDetail) {
        this.courierDetail = cBTrackingOrderCourierDetail;
    }

    public String getDeliveredAt() {
        return this.deliveredAt;
    }

    public void setDeliveredAt(String str) {
        this.deliveredAt = str;
    }
}
