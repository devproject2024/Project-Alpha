package net.one97.paytm.upi.common.upi;

import com.google.gson.a.c;
import com.google.gson.f;
import net.one97.paytm.upi.common.UpiBaseDataModel;

public class GetCredentialsResponse implements UpiBaseDataModel {
    @c(a = "data")
    private CredentialsData data;
    @c(a = "subtype")
    private String subtype;
    @c(a = "type")
    private String type;

    public String getType() {
        return this.type;
    }

    public void setType(String str) {
        this.type = str;
    }

    public String getSubtype() {
        return this.subtype;
    }

    public void setSubtype(String str) {
        this.subtype = str;
    }

    public CredentialsData getData() {
        return this.data;
    }

    public void setData(CredentialsData credentialsData) {
        this.data = credentialsData;
    }

    public String getDataString() {
        return new f().b(this.data);
    }
}
