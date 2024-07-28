package com.paytmmall.artifact.cart.entity;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;

public class CJREMIModel extends IJRPaytmDataModel {
    private static final long serialVersionUID = 1;
    @b(a = "bank_name")
    private String bankName;
    @b(a = "bank_id")
    private int bank_id;
    @b(a = "cashback_amount")
    private int cashbackAmount;
    @b(a = "offerIcon")
    private String imgUrl;
    @b(a = "offer_desc")
    private String offerDetails;
    @b(a = "plan_id")
    private int plan_id;

    public String getCashbackDetails() {
        return "";
    }

    public int getBank_id() {
        return this.bank_id;
    }

    public void setBank_id(int i2) {
        this.bank_id = i2;
    }

    public int getPlan_id() {
        return this.plan_id;
    }

    public void setPlan_id(int i2) {
        this.plan_id = i2;
    }

    public String getBankName() {
        return this.bankName;
    }

    public void setBankName(String str) {
        this.bankName = str;
    }

    public String getOfferDetails() {
        return this.offerDetails;
    }

    public void setOfferDetails(String str) {
        this.offerDetails = str;
    }

    public int getCashbackAmount() {
        return this.cashbackAmount;
    }

    public void setCashbackAmount(int i2) {
        this.cashbackAmount = i2;
    }

    public String getCashbackText(String str, String str2) {
        return " " + str2 + " " + getCashbackAmount() + " " + str + " ";
    }

    public void setImgUrl(String str) {
        this.imgUrl = str;
    }

    public String getImageUrl() {
        return this.imgUrl;
    }
}
