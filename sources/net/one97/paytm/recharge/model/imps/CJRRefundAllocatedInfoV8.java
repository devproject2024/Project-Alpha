package net.one97.paytm.recharge.model.imps;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.HashMap;
import kotlin.g.b.k;

public final class CJRRefundAllocatedInfoV8 extends IJRPaytmDataModel {
    @b(a = "amount")
    private HashMap<String, String> amount = new HashMap<>();
    @b(a = "assetId")
    private String assetId;
    @b(a = "iconImageUrl")
    private String bankImageUrl;
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
    @b(a = "accountId")
    private String mAccountId;
    @b(a = "maskedAccountNo")
    private String maskedAccountNo;
    @b(a = "maxRefundTime")
    private HashMap<String, String> maxRefundTime = new HashMap<>();
    @b(a = "payMethod")
    private String payMethod;
    private Integer selectedIndex;
    @b(a = "source_text")
    private String source_text;
    private String status;
    @b(a = "targetPayMethod")
    private String targetPayMethod;

    public final Integer getSelectedIndex() {
        return this.selectedIndex;
    }

    public final void setSelectedIndex(Integer num) {
        this.selectedIndex = num;
    }

    public final String getDestinationText() {
        return this.destinationText;
    }

    public final void setDestinationText(String str) {
        this.destinationText = str;
    }

    public final String getDestinationSubText() {
        return this.destinationSubText;
    }

    public final void setDestinationSubText(String str) {
        this.destinationSubText = str;
    }

    public final String getSource_text() {
        return this.source_text;
    }

    public final void setSource_text(String str) {
        this.source_text = str;
    }

    public final String getTargetPayMethod() {
        return this.targetPayMethod;
    }

    public final void setTargetPayMethod(String str) {
        this.targetPayMethod = str;
    }

    public final String getPayMethod() {
        return this.payMethod;
    }

    public final void setPayMethod(String str) {
        this.payMethod = str;
    }

    public final String getMaskedAccountNo() {
        return this.maskedAccountNo;
    }

    public final void setMaskedAccountNo(String str) {
        this.maskedAccountNo = str;
    }

    public final String getBankName() {
        return this.bankName;
    }

    public final void setBankName(String str) {
        this.bankName = str;
    }

    public final String getAssetId() {
        return this.assetId;
    }

    public final void setAssetId(String str) {
        this.assetId = str;
    }

    public final String getHolderName() {
        return this.holderName;
    }

    public final void setHolderName(String str) {
        this.holderName = str;
    }

    public final HashMap<String, String> getAmount() {
        return this.amount;
    }

    public final void setAmount(HashMap<String, String> hashMap) {
        k.c(hashMap, "<set-?>");
        this.amount = hashMap;
    }

    public final HashMap<String, String> getMaxRefundTime() {
        return this.maxRefundTime;
    }

    public final void setMaxRefundTime(HashMap<String, String> hashMap) {
        k.c(hashMap, "<set-?>");
        this.maxRefundTime = hashMap;
    }

    public final HashMap<String, String> getCustom_texts() {
        return this.custom_texts;
    }

    public final void setCustom_texts(HashMap<String, String> hashMap) {
        k.c(hashMap, "<set-?>");
        this.custom_texts = hashMap;
    }

    public final String getMAccountId() {
        return this.mAccountId;
    }

    public final void setMAccountId(String str) {
        this.mAccountId = str;
    }

    public final String getBankImageUrl() {
        return this.bankImageUrl;
    }

    public final void setBankImageUrl(String str) {
        this.bankImageUrl = str;
    }

    public final String getStatus() {
        return this.status;
    }

    public final void setStatus(String str) {
        this.status = str;
    }
}
