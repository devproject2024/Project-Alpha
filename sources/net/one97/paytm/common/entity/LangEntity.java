package net.one97.paytm.common.entity;

import com.google.gsonhtcfix.a.b;

public class LangEntity implements IJRDataModel {
    @b(a = "key")
    private String key;
    @b(a = "message")
    private String value;

    public LangEntity() {
    }

    public LangEntity(String str, String str2) {
        this.key = str;
        this.value = str2;
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
