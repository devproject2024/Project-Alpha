package net.one97.paytm.fastag.model;

import com.google.gsonhtcfix.a.a;
import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;

public class CSTAttributes extends IJRPaytmDataModel {
    @a
    @b(a = "key")
    private String key;
    @a
    @b(a = "value")
    private String value;

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
