package net.one97.paytm.fastag.dependencies;

import java.io.Serializable;
import java.util.ArrayList;
import net.one97.paytm.fastag.model.CJRAttribute;
import net.one97.paytm.fastag.model.CJRCashback;
import net.one97.paytm.fastag.model.CJRPostReturnRefundConsultView;

public final class b implements Serializable {
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

    public final ArrayList<CJRCashback> getCashbackModelList() {
        return this.cashbackModelList;
    }

    public final void setCashbackModelList(ArrayList<CJRCashback> arrayList) {
        this.cashbackModelList = arrayList;
    }

    public final CJRAttribute getProductAttributes() {
        return this.productAttributes;
    }

    public final void setProductAttributes(CJRAttribute cJRAttribute) {
        this.productAttributes = cJRAttribute;
    }

    public final String getPostshipText1() {
        return this.postshipText1;
    }

    public final String getPostshipText2() {
        return this.postshipText2;
    }

    public final void setPostshipText1(String str) {
        this.postshipText1 = str;
    }

    public final void setPostshipText2(String str) {
        this.postshipText2 = str;
    }

    public final String getCashbackCreditedText() {
        return this.cashbackCreditedText;
    }

    public final void setCashbackCreditedText(String str) {
        this.cashbackCreditedText = str;
    }

    public final String getFetchReasonAPI() {
        return this.fetchReasonAPI;
    }

    public final void setFetchReasonAPI(String str) {
        this.fetchReasonAPI = str;
    }

    public final boolean isPreshipCancel() {
        return this.preshipCancel;
    }

    public final void setPreshipCancel(boolean z) {
        this.preshipCancel = z;
    }

    public final String getItemImageUrl() {
        return this.itemImageUrl;
    }

    public final void setItemImageUrl(String str) {
        this.itemImageUrl = str;
    }

    public final String getItemName() {
        return this.itemName;
    }

    public final void setItemName(String str) {
        this.itemName = str;
    }

    public final String getCancelStatus() {
        return this.cancelStatus;
    }

    public final void setCancelStatus(String str) {
        this.cancelStatus = str;
    }

    public final String getCancelTime() {
        return this.cancelTime;
    }

    public final void setCancelTime(String str) {
        this.cancelTime = str;
    }

    public final String getRefundSourceText() {
        return this.refundSourceText;
    }

    public final void setRefundSourceText(String str) {
        this.refundSourceText = str;
    }

    public final double getPaidAmount() {
        return this.paidAmount;
    }

    public final void setPaidAmount(double d2) {
        this.paidAmount = d2;
    }

    public final String getEstimatedRefundTime() {
        return this.estimatedRefundTime;
    }

    public final void setEstimatedRefundTime(String str) {
        this.estimatedRefundTime = str;
    }

    public final String getOrderId() {
        return this.orderId;
    }

    public final String getItemId() {
        return this.itemId;
    }

    public final void setOrderId(String str) {
        this.orderId = str;
    }

    public final void setItemId(String str) {
        this.itemId = str;
    }

    public final CJRPostReturnRefundConsultView getRefundConsultInfo() {
        return this.refundConsultInfo;
    }

    public final void setRefundConsultInfo(CJRPostReturnRefundConsultView cJRPostReturnRefundConsultView) {
        this.refundConsultInfo = cJRPostReturnRefundConsultView;
    }
}
