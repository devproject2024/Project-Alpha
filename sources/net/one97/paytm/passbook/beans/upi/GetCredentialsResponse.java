package net.one97.paytm.passbook.beans.upi;

import com.google.gsonhtcfix.a.b;
import com.google.gsonhtcfix.f;
import net.one97.paytm.passbook.mapping.IJRDataModel;

public class GetCredentialsResponse extends IJRDataModel {
    @b(a = "data")
    private CredentialsData data;
    @b(a = "subtype")
    private String subtype;
    @b(a = "type")
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
        return new f().a((Object) this.data);
    }
}
