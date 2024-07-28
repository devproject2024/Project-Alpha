package net.one97.paytm.passbook.beans;

import com.google.gsonhtcfix.a.b;
import net.one97.paytm.passbook.mapping.IJRDataModel;

public class CJRBrandCover extends IJRDataModel {
    @b(a = "name")
    public String mname;
    @b(a = "url")
    public String murl;

    public String getMname() {
        return this.mname;
    }

    public void setMname(String str) {
        this.mname = str;
    }

    public String getMurl() {
        return this.murl;
    }

    public void setMurl(String str) {
        this.murl = str;
    }
}
