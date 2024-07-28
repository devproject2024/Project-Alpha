package net.one97.paytm.common.entity.shopping;

import com.google.gsonhtcfix.a.b;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRSearchSuggestion implements IJRDataModel {
    private static final long serialVersionUID = 1;
    @b(a = "value")
    private String mValue;

    public String getValue() {
        return this.mValue;
    }

    public CJRSearchSuggestion(String str) {
        this.mValue = str;
    }
}
