package net.one97.paytm.nativesdk.common.model;

public class MinAmount implements BaseDataModel {
    private String currency;
    private String value;

    public String getValue() {
        return this.value;
    }

    public void setValue(String str) {
        this.value = str;
    }

    public String getCurrency() {
        return this.currency;
    }

    public void setCurrency(String str) {
        this.currency = str;
    }

    public String toString() {
        return "ClassPojo [value = " + this.value + ", currency = " + this.currency + "]";
    }
}
