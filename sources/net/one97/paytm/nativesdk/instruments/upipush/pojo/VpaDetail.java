package net.one97.paytm.nativesdk.instruments.upipush.pojo;

import com.google.gson.a.a;
import com.google.gson.a.c;
import net.one97.paytm.nativesdk.instruments.upipush.model.BaseVpaDetail;

public class VpaDetail implements BaseVpaDetail {
    @c(a = "defaultCredit")
    @a
    private DefaultCredit defaultCredit;
    @c(a = "defaultDebit")
    @a
    private DefaultDebit defaultDebit;
    @c(a = "name")
    @a
    private String name;
    @c(a = "primary")
    @a
    private Boolean primary;

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    public DefaultCredit getDefaultCredit() {
        return this.defaultCredit;
    }

    public void setDefaultCredit(DefaultCredit defaultCredit2) {
        this.defaultCredit = defaultCredit2;
    }

    public DefaultDebit getDefaultDebit() {
        return this.defaultDebit;
    }

    public void setDefaultDebit(DefaultDebit defaultDebit2) {
        this.defaultDebit = defaultDebit2;
    }

    public Boolean getPrimary() {
        return this.primary;
    }

    public void setPrimary(Boolean bool) {
        this.primary = bool;
    }
}
