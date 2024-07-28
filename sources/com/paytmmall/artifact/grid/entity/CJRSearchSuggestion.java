package com.paytmmall.artifact.grid.entity;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;

public class CJRSearchSuggestion extends IJRPaytmDataModel {
    private static final long serialVersionUID = 1;
    @b(a = "value")
    private String mValue;

    public String getValue() {
        return this.mValue;
    }

    public CJRSearchSuggestion(String str) {
        this.mValue = str;
    }
}
