package com.paytmmall.artifact.cart.entity;

import com.paytm.network.model.IJRPaytmDataModel;

public class CJREMIProductExchangeInfo extends IJRPaytmDataModel {
    private String cashbackText;
    private double cashbackValue;
    private String exchangedProductName;
    private int productId;
    private int quoteAmount;
    private String quoteId;

    public String getQuoteId() {
        return this.quoteId;
    }

    public void setQuoteId(String str) {
        this.quoteId = str;
    }

    public int getProductId() {
        return this.productId;
    }

    public void setProductId(int i2) {
        this.productId = i2;
    }

    public int getQuoteAmount() {
        return this.quoteAmount;
    }

    public void setQuoteAmount(int i2) {
        this.quoteAmount = i2;
    }

    public String getExchangedProductName() {
        return this.exchangedProductName;
    }

    public void setExchangedProductName(String str) {
        this.exchangedProductName = str;
    }

    public double getCashbackValue() {
        return this.cashbackValue;
    }

    public void setCashbackValue(double d2) {
        this.cashbackValue = d2;
    }

    public String getCashbackText() {
        return this.cashbackText;
    }

    public void setCashbackText(String str) {
        this.cashbackText = str;
    }
}
