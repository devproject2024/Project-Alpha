package net.one97.paytm.fastag.model;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;

public class CJRExistingAttribute extends IJRPaytmDataModel {
    private static final long serialVersionUID = 1;
    @b(a = "Size")
    private String mSize;

    public String getSize() {
        return this.mSize;
    }
}
