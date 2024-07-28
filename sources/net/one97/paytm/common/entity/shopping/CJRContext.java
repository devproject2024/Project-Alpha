package net.one97.paytm.common.entity.shopping;

import com.google.gsonhtcfix.a.b;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRContext implements IJRDataModel {
    @b(a = "request_id")
    public String mrequestid;
    @b(a = "user")
    public CJRUser user;

    public String getMrequestid() {
        return this.mrequestid;
    }
}
