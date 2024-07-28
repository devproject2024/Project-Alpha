package net.one97.paytm.common.entity.brandStoreModels;

import com.google.gsonhtcfix.a.b;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRCategoryTree implements IJRDataModel {
    @b(a = "url")
    private String murl;

    public String getMurl() {
        return this.murl;
    }

    public void setMurl(String str) {
        this.murl = str;
    }
}
