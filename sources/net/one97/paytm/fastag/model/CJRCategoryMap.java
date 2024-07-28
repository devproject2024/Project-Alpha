package net.one97.paytm.fastag.model;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;

public class CJRCategoryMap extends IJRPaytmDataModel {
    @b(a = "id")
    private String mId;
    @b(a = "name")
    private String mName;

    public String getName() {
        return this.mName;
    }

    public String getCategoryId() {
        return this.mId;
    }
}
