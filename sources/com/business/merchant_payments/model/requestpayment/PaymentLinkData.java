package com.business.merchant_payments.model.requestpayment;

import com.business.merchant_payments.model.BaseModel;

public class PaymentLinkData extends BaseModel {
    public static final long serialVersionUID = 1;
    public boolean active;
    public double amount;
    public String createdDate;
    public int id;
    public boolean isActive;
    public String linkDescription;
    public String linkName;
    public String linkType;
    public String longUrl;
    public String merchantHtml;
    public String mid;
    public String shortUrl;

    public String getId() {
        return "LI_" + this.id;
    }

    public String getEdcId() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.id);
        return sb.toString();
    }

    public String getMid() {
        return this.mid;
    }

    public String getLinkName() {
        return this.linkName;
    }

    public String getLinkDescription() {
        return this.linkDescription;
    }

    public double getAmount() {
        return this.amount;
    }

    public String getLongUrl() {
        return this.longUrl;
    }

    public String getShortUrl() {
        return this.shortUrl;
    }

    public boolean isActive() {
        return this.isActive;
    }

    public String getMerchantHtml() {
        return this.merchantHtml;
    }

    public String getLinkType() {
        return this.linkType;
    }

    public void setAmount(double d2) {
        this.amount = d2;
    }

    public void setLinkDescription(String str) {
        this.linkDescription = str;
    }

    public void setShortUrl(String str) {
        this.shortUrl = str;
    }

    public void setId(int i2) {
        this.id = i2;
    }

    public String getCreatedDate() {
        return this.createdDate;
    }

    public void setCreatedDate(String str) {
        this.createdDate = str;
    }
}
