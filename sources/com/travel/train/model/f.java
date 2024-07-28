package com.travel.train.model;

import com.google.gsonhtcfix.a.b;
import java.io.Serializable;

public final class f implements Serializable {
    @b(a = "contact_emails")
    private String[] contactEmails;
    @b(a = "contact_phones")
    private String[] contactPhones;
    @b(a = "token")
    private String token;

    public final String getToken() {
        return this.token;
    }

    public final void setToken(String str) {
        this.token = str;
    }

    public final String[] getContactPhones() {
        return this.contactPhones;
    }

    public final void setContactPhones(String[] strArr) {
        this.contactPhones = strArr;
    }

    public final String[] getContactEmails() {
        return this.contactEmails;
    }

    public final void setContactEmails(String[] strArr) {
        this.contactEmails = strArr;
    }
}
