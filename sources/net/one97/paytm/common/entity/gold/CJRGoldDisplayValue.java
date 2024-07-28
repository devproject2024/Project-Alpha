package net.one97.paytm.common.entity.gold;

import com.google.gsonhtcfix.a.b;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRGoldDisplayValue implements IJRDataModel {
    @b(a = "key")
    private String key;
    @b(a = "label")
    private String label;
    @b(a = "value")
    private String value;

    public String getLabel() {
        return this.label;
    }

    public void setLabel(String str) {
        this.label = str;
    }

    public String getValue() {
        return this.value;
    }

    public void setValue(String str) {
        this.value = str;
    }

    public String getKey() {
        return this.key;
    }

    public void setKey(String str) {
        this.key = str;
    }
}
