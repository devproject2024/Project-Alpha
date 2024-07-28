package com.paytm.business.merchantprofile.model;

import com.business.common_module.f.a;
import com.google.gson.a.c;

public class StatesModel extends a {
    @c(a = "helplinenumber")
    @com.google.gson.a.a
    public String helplinenumber;
    @c(a = "name")
    @com.google.gson.a.a
    public String name;

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    public String getHelplinenumber() {
        return this.helplinenumber;
    }

    public void setHelplinenumber(String str) {
        this.helplinenumber = str;
    }
}
