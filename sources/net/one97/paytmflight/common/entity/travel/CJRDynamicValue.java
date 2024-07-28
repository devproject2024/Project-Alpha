package net.one97.paytmflight.common.entity.travel;

import com.google.gsonhtcfix.a.b;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRDynamicValue implements Cloneable, IJRDataModel {
    @b(a = "key")
    private String key;
    @b(a = "value")
    private String value;

    public String getKey() {
        return this.key;
    }

    public void setKey(String str) {
        this.key = str;
    }

    public String getValue() {
        return this.value;
    }

    public void setValue(String str) {
        this.value = str;
    }

    public CJRDynamicValue clone() throws CloneNotSupportedException {
        return (CJRDynamicValue) super.clone();
    }
}
