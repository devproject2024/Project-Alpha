package net.one97.paytmflight.common.entity.flightticket;

import java.util.ArrayList;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJROrderSummaryTaxBreakUp implements IJRDataModel {
    private String key;
    private String text_type;
    private ArrayList<CJROrderSummaryValue> value;
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

    public ArrayList<CJROrderSummaryValue> getValue() {
        return this.value;
    }

    public void setValue(ArrayList<CJROrderSummaryValue> arrayList) {
        this.value = arrayList;
    }

    public String getKey() {
        return this.key;
    }

    public void setKey(String str) {
        this.key = str;
    }

    public String toString() {
        return "ClassPojo [value_type = " + this.value_type + ", text_type = " + this.text_type + ", value = " + this.value + ", key = " + this.key + "]";
    }
}
