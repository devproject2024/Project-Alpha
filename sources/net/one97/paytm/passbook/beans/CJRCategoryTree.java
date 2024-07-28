package net.one97.paytm.passbook.beans;

import com.google.gsonhtcfix.a.b;
import net.one97.paytm.passbook.mapping.IJRDataModel;

public class CJRCategoryTree extends IJRDataModel {
    @b(a = "url")
    private String murl;

    public String getMurl() {
        return this.murl;
    }

    public void setMurl(String str) {
        this.murl = str;
    }
}
