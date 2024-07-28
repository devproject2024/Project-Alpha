package com.paytm.business.merchantprofile.model;

import com.business.common_module.f.a;
import com.google.gson.a.c;
import java.util.List;

public class HelpLineModel extends a {
    @c(a = "default")
    @com.google.gson.a.a
    public String defaultHelpLine;
    @c(a = "states")
    @com.google.gson.a.a
    public List<StatesModel> states = null;

    public String getDefaultHelpLine() {
        return this.defaultHelpLine;
    }

    public void setDefaultHelpLine(String str) {
        this.defaultHelpLine = str;
    }

    public List<StatesModel> getStates() {
        return this.states;
    }

    public void setStates(List<StatesModel> list) {
        this.states = list;
    }
}
