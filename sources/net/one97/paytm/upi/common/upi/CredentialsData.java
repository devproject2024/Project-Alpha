package net.one97.paytm.upi.common.upi;

import com.google.gson.a.c;
import net.one97.paytm.upi.common.UpiBaseDataModel;

public class CredentialsData implements UpiBaseDataModel {
    @c(a = "code")
    private String code;
    @c(a = "encryptedBase64String")
    private String encryptedBase64String;
    @c(a = "ki")
    private String ki;

    public String getCode() {
        return this.code;
    }

    public void setCode(String str) {
        this.code = str;
    }

    public String getKi() {
        return this.ki;
    }

    public void setKi(String str) {
        this.ki = str;
    }

    public String getEncryptedBase64String() {
        return this.encryptedBase64String;
    }

    public void setEncryptedBase64String(String str) {
        this.encryptedBase64String = str;
    }
}
