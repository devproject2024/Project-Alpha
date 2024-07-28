package net.one97.paytm.common.entity.wallet;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.ArrayList;
import net.one97.paytm.common.entity.IJRDataModel;

public class FeeDetails extends IJRPaytmDataModel implements IJRDataModel {
    @b(a = "allowedFreeLimit")
    private String allowedFreeLimit;
    @b(a = "cardHash")
    private String cardHash;
    @b(a = "cardIndexNo")
    private String cardIndexNo;
    @b(a = "consumedLimit")
    private String consumedLimit;
    @b(a = "feeAmount")
    private String feeAmount;
    @b(a = "feeApplied")
    private boolean feeApplied;
    @b(a = "feeDetailsBreakupList")
    private ArrayList<FeeDetailsBreakupList> feeDetailsBreakupList;
    @b(a = "feePercent")
    private String feePercent;
    @b(a = "msg")
    private String msg;
    @b(a = "offerMsg")
    private String offerMsg;
    @b(a = "orderAmount")
    private String orderAmount;
    @b(a = "payMethod")
    private String payMethod;
    @b(a = "payableAmount")
    private String payableAmount;
    @b(a = "rejectMsg")
    private String rejectMsg;

    public String getCardIndexNo() {
        return this.cardIndexNo;
    }

    public void setCardIndexNo(String str) {
        this.cardIndexNo = str;
    }

    public String getCardHash() {
        return this.cardHash;
    }

    public void setCardHash(String str) {
        this.cardHash = str;
    }

    public boolean isFeeApplied() {
        return this.feeApplied;
    }

    public void setFeeApplied(boolean z) {
        this.feeApplied = z;
    }

    public String getPayMethod() {
        return this.payMethod;
    }

    public void setPayMethod(String str) {
        this.payMethod = str;
    }

    public String getFeePercent() {
        return this.feePercent;
    }

    public void setFeePercent(String str) {
        this.feePercent = str;
    }

    public String getMsg() {
        return this.msg;
    }

    public void setMsg(String str) {
        this.msg = str;
    }

    public String getRejectMsg() {
        return this.rejectMsg;
    }

    public void setRejectMsg(String str) {
        this.rejectMsg = str;
    }

    public String getOfferMsg() {
        return this.offerMsg;
    }

    public void setOfferMsg(String str) {
        this.offerMsg = str;
    }

    public String getOrderAmount() {
        return this.orderAmount;
    }

    public void setOrderAmount(String str) {
        this.orderAmount = str;
    }

    public String getFeeAmount() {
        return this.feeAmount;
    }

    public void setFeeAmount(String str) {
        this.feeAmount = str;
    }

    public String getConsumedLimit() {
        return this.consumedLimit;
    }

    public void setConsumedLimit(String str) {
        this.consumedLimit = str;
    }

    public String getAllowedFreeLimit() {
        return this.allowedFreeLimit;
    }

    public void setAllowedFreeLimit(String str) {
        this.allowedFreeLimit = str;
    }

    public ArrayList<FeeDetailsBreakupList> getFeeDetailsBreakupList() {
        return this.feeDetailsBreakupList;
    }

    public void setFeeDetailsBreakupList(ArrayList<FeeDetailsBreakupList> arrayList) {
        this.feeDetailsBreakupList = arrayList;
    }

    public String getPayableAmount() {
        return this.payableAmount;
    }

    public void setPayableAmount(String str) {
        this.payableAmount = str;
    }
}
