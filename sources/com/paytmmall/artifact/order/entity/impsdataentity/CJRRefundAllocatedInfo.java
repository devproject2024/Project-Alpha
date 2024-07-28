package com.paytmmall.artifact.order.entity.impsdataentity;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.HashMap;

public class CJRRefundAllocatedInfo extends IJRPaytmDataModel {
    @b(a = "amount")
    private HashMap<String, String> amount = new HashMap<>();
    @b(a = "assetId")
    private String assetId;
    @b(a = "bankName")
    private String bankName;
    @b(a = "custom_texts")
    private HashMap<String, String> custom_texts = new HashMap<>();
    @b(a = "destinationSubText")
    private String destinationSubText;
    @b(a = "destinationText")
    private String destinationText;
    @b(a = "holderName")
    private String holderName;
    @b(a = "maskedAccountNo")
    private String maskedAccountNo;
    @b(a = "maxRefundTime")
    private HashMap<String, String> maxRefundTime = new HashMap<>();
    @b(a = "payMethod")
    private String payMethod;
    @b(a = "source_text")
    private String source_text;
    @b(a = "targetPayMethod")
    private String targetPayMethod;

    public String getDestinationText() {
        return this.destinationText;
    }

    public void setDestinationText(String str) {
        this.destinationText = str;
    }

    public String getDestinationSubText() {
        return this.destinationSubText;
    }

    public void setDestinationSubText(String str) {
        this.destinationSubText = str;
    }

    public String getTargetPayMethod() {
        return this.targetPayMethod;
    }

    public void setTargetPayMethod(String str) {
        this.targetPayMethod = str;
    }

    public String getPayMethod() {
        return this.payMethod;
    }

    public void setPayMethod(String str) {
        this.payMethod = str;
    }

    public String getMaskedAccountNo() {
        return this.maskedAccountNo;
    }

    public void setMaskedAccountNo(String str) {
        this.maskedAccountNo = str;
    }

    public String getBankName() {
        return this.bankName;
    }

    public void setBankName(String str) {
        this.bankName = str;
    }

    public String getHolderName() {
        return this.holderName;
    }

    public void setHolderName(String str) {
        this.holderName = str;
    }

    public HashMap<String, String> getAmount() {
        return this.amount;
    }

    public void setAmount(HashMap<String, String> hashMap) {
        this.amount = hashMap;
    }

    public HashMap<String, String> getMaxRefundTime() {
        return this.maxRefundTime;
    }

    public void setMaxRefundTime(HashMap<String, String> hashMap) {
        this.maxRefundTime = hashMap;
    }

    public HashMap<String, String> getCustom_texts() {
        return this.custom_texts;
    }

    public void setCustom_texts(HashMap<String, String> hashMap) {
        this.custom_texts = hashMap;
    }

    public String getSource_text() {
        return this.source_text;
    }

    public void setSource_text(String str) {
        this.source_text = str;
    }

    public String getAssetId() {
        return this.assetId;
    }

    public void setAssetId(String str) {
        this.assetId = str;
    }
}
