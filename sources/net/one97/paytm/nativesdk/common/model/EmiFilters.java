package net.one97.paytm.nativesdk.common.model;

import com.google.gson.a.c;

public class EmiFilters implements BaseDataModel {
    @c(a = "bankCode")
    private String bankCode;
    @c(a = "cardType")
    private String cardType;

    public EmiFilters(String str, String str2) {
        this.bankCode = str;
        this.cardType = str2;
    }

    public String getBankCode() {
        return this.bankCode;
    }

    public String getCardType() {
        return this.cardType;
    }
}
