package com.travel.train.model;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;

public class CJRTrainResendContactDataResponse extends IJRPaytmDataModel {
    @b(a = "contact_emails")
    private String[] contactEmails;
    @b(a = "contact_phones")
    private String[] contactPhones;
    @b(a = "default_email")
    private String defaultEmail;
    @b(a = "default_phone")
    private String defaultPhone;

    public String getDefaultEmail() {
        return this.defaultEmail;
    }

    public String getDefaultPhone() {
        return this.defaultPhone;
    }

    public String[] getContactPhones() {
        return this.contactPhones;
    }

    public String[] getContactEmails() {
        return this.contactEmails;
    }
}
