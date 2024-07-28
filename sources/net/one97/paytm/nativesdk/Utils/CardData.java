package net.one97.paytm.nativesdk.Utils;

import net.one97.paytm.nativesdk.common.model.BaseDataModel;

public class CardData implements BaseDataModel {
    private Double amount;
    private String expiryDate;
    private String firstSixDigit;
    private String lastFourDigit;

    public String getExpiryDate() {
        return "";
    }

    public CardData() {
    }

    public CardData(String str, String str2, String str3) {
        this.expiryDate = str3;
        this.firstSixDigit = str;
        this.lastFourDigit = str2;
    }

    public void setExpiryDate(String str) {
        this.expiryDate = str;
    }

    public String getLastFourDigit() {
        return this.lastFourDigit;
    }

    public void setLastFourDigit(String str) {
        this.lastFourDigit = str;
    }

    public String getFirstSixDigit() {
        return this.firstSixDigit;
    }

    public void setFirstSixDigit(String str) {
        this.firstSixDigit = str;
    }

    public Double getAmount() {
        return this.amount;
    }

    public void setAmount(Double d2) {
        this.amount = d2;
    }
}
