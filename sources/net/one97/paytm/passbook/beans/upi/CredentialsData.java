package net.one97.paytm.passbook.beans.upi;

import com.google.gsonhtcfix.a.b;
import net.one97.paytm.passbook.mapping.IJRDataModel;

public class CredentialsData extends IJRDataModel {
    @b(a = "code")
    private String code;
    @b(a = "encryptedBase64String")
    private String encryptedBase64String;
    @b(a = "ki")
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
