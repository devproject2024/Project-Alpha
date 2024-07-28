package net.one97.paytm.bankCommon.model;

import com.google.gsonhtcfix.a.b;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJROtherTaxes implements IJRDataModel {
    @b(a = "label")
    private String mLabel;
    @b(a = "value")
    private String mValue;

    public String getValue() {
        return this.mValue;
    }

    public String getLabel() {
        return this.mLabel;
    }
}
