package net.one97.paytm.nativesdk.emiSubvention.models;

import com.google.gson.a.a;
import com.google.gson.a.c;

public class Gratifications extends BaseModel {
    @c(a = "label")
    @a
    private String label;
    @c(a = "type")
    @a
    private String type;
    @c(a = "value")
    @a
    private Integer value;

    public Integer getValue() {
        return this.value;
    }

    public void setValue(Integer num) {
        this.value = num;
    }

    public String getLabel() {
        return this.label;
    }

    public void setLabel(String str) {
        this.label = str;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String str) {
        this.type = str;
    }
}
