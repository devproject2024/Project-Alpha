package net.one97.paytmflight.common.entity.flightticket;

import net.one97.paytm.common.entity.IJRDataModel;

public class CJROrderSummaryValue implements IJRDataModel {
    private String key;
    private String text_type;
    private String value;
    private String value_type;

    public String getValue_type() {
        return this.value_type;
    }

    public void setValue_type(String str) {
        this.value_type = str;
    }

    public String getText_type() {
        return this.text_type;
    }

    public void setText_type(String str) {
        this.text_type = str;
    }

    public String getKey() {
        return this.key;
    }

    public void setKey(String str) {
        this.key = str;
    }

    public String toString() {
        return "ClassPojo [value_type = " + this.value_type + ", text_type = " + this.text_type + ", key = " + this.key + "]";
    }

    public String getValue() {
        return this.value;
    }

    public void setValue(String str) {
        this.value = str;
    }
}
