package net.one97.paytm.common.entity.postpaid;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import net.one97.paytm.common.entity.IJRDataModel;

public final class CJRPPKycTnc extends IJRPaytmDataModel implements IJRDataModel {
    @b(a = "code")
    private Object code;
    @b(a = "lender")
    private String lender;
    @b(a = "text")
    private String text;
    @b(a = "version")
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
