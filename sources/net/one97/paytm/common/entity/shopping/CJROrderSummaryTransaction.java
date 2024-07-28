package net.one97.paytm.common.entity.shopping;

import com.google.gsonhtcfix.a.b;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJROrderSummaryTransaction implements IJRDataModel {
    private static final long serialVersionUID = 1;
    @b(a = "title")
    private String mTitle;
    @b(a = "type")
    private String mType;
    @b(a = "value")
    private String mValue;

    public String getTitle() {
        return this.mTitle;
    }

    public String getValue() {
        return this.mValue;
    }

    public String getType() {
        return this.mType;
    }
}
