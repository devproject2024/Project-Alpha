package com.paytmmall.artifact.order.entity;

import com.paytmmall.artifact.order.entity.impsdataentity.CJRPostReturnRefundConsultView;
import java.io.Serializable;
import java.util.ArrayList;

public class CJRCancelItemInformation implements Serializable {
    private String cancelStatus;
    private String cancelTime;
    private String cashbackCreditedText;
    private ArrayList<CJRCashback> cashbackModelList;
    private String estimatedRefundTime;
    private String fetchReasonAPI;
    private String itemId;
    private String itemImageUrl;
    private String itemName;
    private String orderId;
    private double paidAmount;
    private String postshipText1;
    private String postshipText2;
    private boolean preshipCancel = false;
    private CJRAttribute productAttributes;
    private CJRPostReturnRefundConsultView refundConsultInfo;
    private String refundSourceText;

    public ArrayList<CJRCashback> getCashbackModelList() {
        return this.cashbackModelList;
    }

    public void setCashbackModelList(ArrayList<CJRCashback> arrayList) {
        this.cashbackModelList = arrayList;
    }

    public CJRAttribute getProductAttributes() {
        return this.productAttributes;
    }

    public void setProductAttributes(CJRAttribute cJRAttribute) {
        this.productAttributes = cJRAttribute;
    }

    public String getPostshipText1() {
        return this.postshipText1;
    }

    public String getPostshipText2() {
        return this.postshipText2;
    }

    public void setPostshipText1(String str) {
        this.postshipText1 = str;
    }

    public void setPostshipText2(String str) {
        this.postshipText2 = str;
    }

    public String getCashbackCreditedText() {
        return this.cashbackCreditedText;
    }

    public void setCashbackCreditedText(String str) {
        this.cashbackCreditedText = str;
    }

    public String getFetchReasonAPI() {
        return this.fetchReasonAPI;
    }

    public void setFetchReasonAPI(String str) {
        this.fetchReasonAPI = str;
    }

    public boolean isPreshipCancel() {
        return this.preshipCancel;
    }

    public void setPreshipCancel(boolean z) {
        this.preshipCancel = z;
    }

    public String getItemImageUrl() {
        return this.itemImageUrl;
    }

    public void setItemImageUrl(String str) {
        this.itemImageUrl = str;
    }

    public String getItemName() {
        return this.itemName;
    }

    public void setItemName(String str) {
        this.itemName = str;
    }

    public String getCancelStatus() {
        return this.cancelStatus;
    }

    public void setCancelStatus(String str) {
        this.cancelStatus = str;
    }

    public String getCancelTime() {
        return this.cancelTime;
    }

    public void setCancelTime(String str) {
        this.cancelTime = str;
    }

    public String getRefundSourceText() {
        return this.refundSourceText;
    }

    public void setRefundSourceText(String str) {
        this.refundSourceText = str;
    }

    public double getPaidAmount() {
        return this.paidAmount;
    }

    public void setPaidAmount(double d2) {
        this.paidAmount = d2;
    }

    public String getEstimatedRefundTime() {
        return this.estimatedRefundTime;
    }

    public void setEstimatedRefundTime(String str) {
        this.estimatedRefundTime = str;
    }

    public String getOrderId() {
        return this.orderId;
    }

    public String getItemId() {
        return this.itemId;
    }

    public void setOrderId(String str) {
        this.orderId = str;
    }

    public void setItemId(String str) {
        this.itemId = str;
    }

    public CJRPostReturnRefundConsultView getRefundConsultInfo() {
        return this.refundConsultInfo;
    }

    public void setRefundConsultInfo(CJRPostReturnRefundConsultView cJRPostReturnRefundConsultView) {
        this.refundConsultInfo = cJRPostReturnRefundConsultView;
    }
}
