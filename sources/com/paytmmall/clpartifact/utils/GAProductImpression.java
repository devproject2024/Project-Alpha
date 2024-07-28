package com.paytmmall.clpartifact.utils;

import com.google.gson.a.c;
import com.google.gson.f;
import com.paytmmall.clpartifact.ga.GaEvent;
import java.util.ArrayList;
import java.util.List;

public class GAProductImpression implements GaEvent {
    @c(a = "impressions")
    private List<GAImpression> impressionsList = new ArrayList();
    @c(a = "currenyCode")
    private String mCurrency;

    public String getmCurrency() {
        return this.mCurrency;
    }

    public void setmCurrency(String str) {
        this.mCurrency = str;
    }

    public List<GAImpression> getImpressionsList() {
        return this.impressionsList;
    }

    public void setImpressionsList(List<GAImpression> list) {
        this.impressionsList = list;
    }

    public String toJson() {
        return new f().b(this);
    }
}
