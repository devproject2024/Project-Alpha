package com.paytmmall.artifact.ReturnReplace.entity;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;

public class CJRCSTDeepLink extends IJRPaytmDataModel {
    @b(a = "deeplink")
    private String deeplink;
    @b(a = "issue_id")
    private String issue_id;
    private final Long serialVersionUID = 1L;
    @b(a = "value")
    private String value;

    public String getIssue_id() {
        return this.issue_id;
    }

    public void setIssue_id(String str) {
        this.issue_id = str;
    }

    public String getDeeplink() {
        return this.deeplink;
    }

    public void setDeeplink(String str) {
        this.deeplink = str;
    }

    public String getValue() {
        return this.value;
    }

    public void setValue(String str) {
        this.value = str;
    }
}
