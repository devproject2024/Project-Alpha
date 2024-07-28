package com.paytmmall.artifact.cart.entity;

import com.google.gsonhtcfix.a.a;
import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.List;

public class ItemBreakup extends IJRPaytmDataModel {
    @a
    @b(a = "effectivePrice")
    private Double effectivePrice;
    @a
    @b(a = "emi")
    private Double emi;
    @a
    @b(a = "gratifications")
    private List<Gratifications> gratifications = null;
    @a
    @b(a = "interest")
    private Integer interest;
    @a
    @b(a = "offerId")
    private String offerId;
    @a
    @b(a = "subventionType")
    private String subventionType;

    public Integer getInterest() {
        return this.interest;
    }

    public void setInterest(Integer num) {
        this.interest = num;
    }

    public String getOfferId() {
        return this.offerId;
    }

    public void setOfferId(String str) {
        this.offerId = str;
    }

    public Double getEmi() {
        return this.emi;
    }

    public void setEmi(Double d2) {
        this.emi = d2;
    }

    public String getSubventionType() {
        return this.subventionType;
    }

    public Double getEffectivePrice() {
        return this.effectivePrice;
    }

    public void setEffectivePrice(Double d2) {
        this.effectivePrice = d2;
    }

    public void setSubventionType(String str) {
        this.subventionType = str;
    }

    public List<Gratifications> getGratifications() {
        return this.gratifications;
    }

    public void setGratifications(List<Gratifications> list) {
        this.gratifications = list;
    }
}
