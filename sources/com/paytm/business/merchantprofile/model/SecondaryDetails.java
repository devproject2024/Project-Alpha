package com.paytm.business.merchantprofile.model;

import com.business.common_module.f.a;
import com.google.gson.a.c;

public class SecondaryDetails extends a {
    public static final long serialVersionUID = 1;
    @c(a = "additionalContact")
    public String additionalContact;
    @c(a = "secondadry_email")
    public String secondaryEmail;
    @c(a = "secondary_mobileno")
    public String secondaryMobileNo;

    public static long getSerialVersionUID() {
        return 1;
    }

    public String getSecondaryEmail() {
        return this.secondaryEmail;
    }

    public void setSecondaryEmail(String str) {
        this.secondaryEmail = str;
    }

    public String getSecondaryMobileNo() {
        return this.secondaryMobileNo;
    }

    public void setSecondaryMobileNo(String str) {
        this.secondaryMobileNo = str;
    }

    public void setAdditionalContact(String str) {
        this.additionalContact = str;
    }

    public String getAdditionalContact() {
        return this.additionalContact;
    }

    public String toString() {
        return "SecondaryDetails{secondaryEmail='" + this.secondaryEmail + '\'' + ", secondaryMobileNo='" + this.secondaryMobileNo + '\'' + '}';
    }
}
