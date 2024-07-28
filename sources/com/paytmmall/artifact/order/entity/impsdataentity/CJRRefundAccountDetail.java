package com.paytmmall.artifact.order.entity.impsdataentity;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.HashMap;

public class CJRRefundAccountDetail extends IJRPaytmDataModel {
    @b(a = "assetId")
    private String assetId;
    @b(a = "bankName")
    private String bankName;
    @b(a = "holderName")
    private HashMap<String, String> holderName = new HashMap<>();
    @b(a = "maskedAccountNumber")
    private String maskedAccountNumber;

    public String getMaskedAccountNumber() {
        return this.maskedAccountNumber;
    }

    public void setMaskedAccountNumber(String str) {
        this.maskedAccountNumber = str;
    }

    public String getAssetId() {
        return this.assetId;
    }

    public void setAssetId(String str) {
        this.assetId = str;
    }

    public String getBankName() {
        return this.bankName;
    }

    public void setBankName(String str) {
        this.bankName = str;
    }

    public HashMap<String, String> getHolderName() {
        return this.holderName;
    }
}
