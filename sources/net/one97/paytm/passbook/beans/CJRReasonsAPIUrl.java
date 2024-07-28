package net.one97.paytm.passbook.beans;

import com.google.gsonhtcfix.a.b;
import net.one97.paytm.passbook.mapping.IJRDataModel;

public class CJRReasonsAPIUrl extends IJRDataModel {
    @b(a = "file")
    private String file;
    @b(a = "issue_id")
    private Integer issueId;
    @b(a = "key")
    private String key;
    @b(a = "value")
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
