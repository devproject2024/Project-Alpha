package net.one97.paytm.upi.common;

import com.google.gson.a.c;

public class CJRCSTDeepLink implements UpiBaseDataModel {
    @c(a = "deeplink")
    private String deeplink;
    @c(a = "issue_id")
    private String issue_id;
    private final Long serialVersionUID = 1L;
    @c(a = "value")
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
