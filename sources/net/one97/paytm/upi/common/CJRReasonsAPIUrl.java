package net.one97.paytm.upi.common;

import com.google.gson.a.c;

public class CJRReasonsAPIUrl implements UpiBaseDataModel {
    @c(a = "file")
    private String file;
    @c(a = "issue_id")
    private Integer issueId;
    @c(a = "key")
    private String key;
    @c(a = "value")
    private String value;

    public Integer getIssueId() {
        return this.issueId;
    }

    public void setIssueId(Integer num) {
        this.issueId = num;
    }

    public String getKey() {
        return this.key;
    }

    public void setKey(String str) {
        this.key = str;
    }

    public String getValue() {
        return this.value;
    }

    public void setValue(String str) {
        this.value = str;
    }

    public String getFile() {
        return this.file;
    }

    public void setFile(String str) {
        this.file = str;
    }
}
