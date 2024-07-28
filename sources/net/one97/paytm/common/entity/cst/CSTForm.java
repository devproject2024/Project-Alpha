package net.one97.paytm.common.entity.cst;

import com.google.gsonhtcfix.a.b;
import net.one97.paytm.common.entity.IJRDataModel;

public class CSTForm implements IJRDataModel {
    @b(a = "display_text")
    private String display_text;
    @b(a = "file")
    private String file;
    @b(a = "id")
    private int id;
    @b(a = "issue_id")
    private int issue_id;
    @b(a = "key")
    private String key;
    @b(a = "value")
    private String value;

    public String getDisplay_text() {
        return this.display_text;
    }

    public void setDisplay_text(String str) {
        this.display_text = str;
    }

    public String getFile() {
        return this.file;
    }

    public void setFile(String str) {
        this.file = str;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int i2) {
        this.id = i2;
    }

    public int getIssue_id() {
        return this.issue_id;
    }

    public void setIssue_id(int i2) {
        this.issue_id = i2;
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
