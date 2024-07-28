package net.one97.paytm.passbook.beans.postpaid;

import com.google.gson.a.c;
import net.one97.paytm.passbook.mapping.IJRDataModel;

public final class CJRPPKycTnc extends IJRDataModel {
    @c(a = "code")
    private Object code;
    @c(a = "lender")
    private String lender;
    @c(a = "text")
    private String text;
    @c(a = "version")
    private String version;

    public final String getLender() {
        return this.lender;
    }

    public final void setLender(String str) {
        this.lender = str;
    }

    public final String getText() {
        return this.text;
    }

    public final void setText(String str) {
        this.text = str;
    }

    public final Object getCode() {
        return this.code;
    }

    public final void setCode(Object obj) {
        this.code = obj;
    }

    public final String getVersion() {
        return this.version;
    }

    public final void setVersion(String str) {
        this.version = str;
    }
}
