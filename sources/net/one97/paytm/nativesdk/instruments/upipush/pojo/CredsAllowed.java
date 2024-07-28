package net.one97.paytm.nativesdk.instruments.upipush.pojo;

import com.google.gson.a.a;
import com.google.gson.a.c;
import net.one97.paytm.nativesdk.common.model.BaseDataModel;

public class CredsAllowed implements BaseDataModel {
    @c(a = "CredsAllowedDLength")
    @a
    private String CredsAllowedDLength;
    @c(a = "CredsAllowedDType")
    @a
    private String CredsAllowedDType;
    @c(a = "CredsAllowedSubType")
    @a
    private String CredsAllowedSubType;
    @c(a = "CredsAllowedType")
    @a
    private String CredsAllowedType;
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
        return this.CredsAllowedDLength;
    }

    public void setCredsAllowedDLength(String str) {
        this.CredsAllowedDLength = str;
    }

    public String getCredsAllowedDType() {
        return this.CredsAllowedDType;
    }

    public void setCredsAllowedDType(String str) {
        this.CredsAllowedDType = str;
    }

    public String getCredsAllowedSubType() {
        return this.CredsAllowedSubType;
    }

    public void setCredsAllowedSubType(String str) {
        this.CredsAllowedSubType = str;
    }

    public String getCredsAllowedType() {
        return this.CredsAllowedType;
    }

    public void setCredsAllowedType(String str) {
        this.CredsAllowedType = str;
    }
}
