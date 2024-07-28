package net.one97.paytm.common.entity.shopping;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJROrderedCartInfoObj extends IJRPaytmDataModel implements IJRDataModel {
    private static final long serialVersionUID = 1;
    @b(a = "c_sid")
    private String c_sid;
    @b(a = "pg_cf")
    private String pg_cf;

    public String getCsid() {
        return this.c_sid;
    }

    public void setCsid(String str) {
        this.c_sid = str;
    }

    public String getPgCf() {
        return this.pg_cf;
    }

    public void setPgCf(String str) {
        this.pg_cf = str;
    }
}
