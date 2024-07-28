package net.one97.paytm.fastag.model;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;

public class CJROtherTaxes extends IJRPaytmDataModel {
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
