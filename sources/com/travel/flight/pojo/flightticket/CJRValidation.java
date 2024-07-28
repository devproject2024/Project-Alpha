package com.travel.flight.pojo.flightticket;

import com.google.gsonhtcfix.a.b;
import java.util.ArrayList;
import java.util.List;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRValidation implements IJRDataModel {
    @b(a = "after")
    private String after;
    @b(a = "before")
    private String before;
    @b(a = "key")
    private String key;
    private String mValue;
    @b(a = "max_length")
    private Integer maxLength;
    @b(a = "min_length")
    private Integer minLength;
    @b(a = "name")
    private String name;
    @b(a = "note")
    private String note;
    @b(a = "type")
    private String type;
    @b(a = "values")
    private List<CJRValue> values = new ArrayList();

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String str) {
        this.type = str;
    }

    public String getAfter() {
        return this.after;
    }

    public void setAfter(String str) {
        this.after = str;
    }

    public String getNote() {
        return this.note;
    }

    public void setNote(String str) {
        this.note = str;
    }

    public Integer getMaxLength() {
        return this.maxLength;
    }

    public void setMaxLength(Integer num) {
        this.maxLength = num;
    }

    public Integer getMinLength() {
        return this.minLength;
    }

    public void setMinLength(Integer num) {
        this.minLength = num;
    }

    public List<CJRValue> getValues() {
        return this.values;
    }

    public void setValues(List<CJRValue> list) {
        this.values = list;
    }

    public String getmValue() {
        return this.mValue;
    }

    public void setmValue(String str) {
        this.mValue = str;
    }

    public String getKey() {
        return this.key;
    }

    public void setKey(String str) {
        this.key = str;
    }

    public String getBefore() {
        return this.before;
    }

    public void setBefore(String str) {
        this.before = str;
    }
}
