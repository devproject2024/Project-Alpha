package net.one97.paytm.nativesdk.common.model;

public class AccountBalance implements BaseDataModel {
    private String currency;
    private String value;

    public String getCurrency() {
        return this.currency;
    }

    public void setCurrency(String str) {
        this.currency = str;
    }

    public String getValue() {
        return this.value;
    }

    public void setValue(String str) {
        this.value = str;
    }
}
