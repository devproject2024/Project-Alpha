package net.one97.paytm.common.entity.recharge;

import com.google.gsonhtcfix.a.b;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRDisplayValues implements IJRDataModel {
    private static final long serialVersionUID = 1;
    @b(a = "label")
    private String mLabel;
    @b(a = "value")
    private String mValue;

    public String getLabel() {
        return this.mLabel;
    }

    public String getValue() {
        return this.mValue;
    }

    public void setmLabel(String str) {
        this.mLabel = str;
    }

    public void setmValue(String str) {
        this.mValue = str;
    }
}
