package net.one97.paytm.fastag.model;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;

public class CJROrderSummaryTransaction extends IJRPaytmDataModel {
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
