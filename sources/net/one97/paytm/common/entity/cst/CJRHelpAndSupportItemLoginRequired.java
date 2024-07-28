package net.one97.paytm.common.entity.cst;

import com.google.gsonhtcfix.a.b;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRHelpAndSupportItemLoginRequired implements IJRDataModel {
    @b(a = "file")
    String file;
    @b(a = "issue_id")
    int issueId;
    @b(a = "key")
    String key;
    private final Long serialVersionUID = 1L;
    @b(a = "value")
    String value;

    public int getIssueId() {
        return this.issueId;
    }

    public void setIssueId(int i2) {
        this.issueId = i2;
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

    public boolean isLoginRequired() {
        try {
            return this.value != null && Integer.parseInt(this.value) == 1;
        } catch (Exception unused) {
        }
    }
}
