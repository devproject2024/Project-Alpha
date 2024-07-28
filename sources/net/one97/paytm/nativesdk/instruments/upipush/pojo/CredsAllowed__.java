package net.one97.paytm.nativesdk.instruments.upipush.pojo;

import com.google.gson.a.a;
import com.google.gson.a.c;
import net.one97.paytm.nativesdk.common.model.BaseDataModel;

public class CredsAllowed__ implements BaseDataModel {
    @c(a = "credsAllowedDLength")
    @a
    private String credsAllowedDLength;
    @c(a = "credsAllowedDType")
    @a
    private String credsAllowedDType;
    @c(a = "credsAllowedSubType")
    @a
    private String credsAllowedSubType;
    @c(a = "credsAllowedType")
    @a
    private String credsAllowedType;
    @c(a = "dLength")
    @a
    private String dLength;

    public String getDLength() {
        return this.dLength;
    }

    public void setDLength(String str) {
        this.dLength = str;
    }

    public String getCredsAllowedDLength() {
        return this.credsAllowedDLength;
    }

    public void setCredsAllowedDLength(String str) {
        this.credsAllowedDLength = str;
    }

    public String getCredsAllowedDType() {
        return this.credsAllowedDType;
    }

    public void setCredsAllowedDType(String str) {
        this.credsAllowedDType = str;
    }

    public String getCredsAllowedSubType() {
        return this.credsAllowedSubType;
    }

    public void setCredsAllowedSubType(String str) {
        this.credsAllowedSubType = str;
    }

    public String getCredsAllowedType() {
        return this.credsAllowedType;
    }

    public void setCredsAllowedType(String str) {
        this.credsAllowedType = str;
    }
}
