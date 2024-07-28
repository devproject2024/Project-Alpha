package net.one97.paytm.common.entity.cst;

import com.google.gsonhtcfix.a.b;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRHelpAndSupportMallIcon implements IJRDataModel {
    @b(a = "issue_id")
    String issueId;
    @b(a = "key")
    String key;
    @b(a = "value")
    String value;

    public String getIssueId() {
        return this.issueId;
    }

    public void setIssueId(String str) {
        this.issueId = str;
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
}
