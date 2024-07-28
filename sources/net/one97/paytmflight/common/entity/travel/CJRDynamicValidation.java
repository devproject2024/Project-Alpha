package net.one97.paytmflight.common.entity.travel;

import com.google.gsonhtcfix.a.b;
import java.util.ArrayList;
import java.util.List;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRDynamicValidation implements Cloneable, IJRDataModel {
    @b(a = "after")
    private String after;
    @b(a = "before")
    private String before;
    private boolean isReturnTrip = false;
    @b(a = "key")
    private String key;
    private String mAuxValue;
    private String mValue;
    @b(a = "max_length")
    private Integer maxLength;
    @b(a = "min_length")
    private Integer minLength;
    @b(a = "note")
    private String note;
    @b(a = "optional")
    private Boolean optional;
    @b(a = "path")
    private String path;
    @b(a = "str_regex")
    private String regex;
    @b(a = "regex_error_message")
    private String regexErrorMessage;
    @b(a = "type")
    private String type;
    @b(a = "value")
    private String value;
    @b(a = "values")
    private List<CJRDynamicValue> values = new ArrayList();

    public boolean isReturnTrip() {
        return this.isReturnTrip;
    }

    public void setReturnTrip(boolean z) {
        this.isReturnTrip = z;
    }

    public String getPath() {
        return this.path;
    }

    public void setPath(String str) {
        this.path = str;
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

    public List<CJRDynamicValue> getValues() {
        return this.values;
    }

    public void setValues(List<CJRDynamicValue> list) {
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

    public Boolean isOptional() {
        return this.optional;
    }

    public void setOptional(Boolean bool) {
        this.optional = bool;
    }

    public String getValue() {
        return this.value;
    }

    public void setValue(String str) {
        this.value = str;
    }

    public CJRDynamicValidation clone() throws CloneNotSupportedException {
        return (CJRDynamicValidation) super.clone();
    }

    public String getRegex() {
        return this.regex;
    }

    public void setRegex(String str) {
        this.regex = str;
    }

    public String getRegexErrorMessage() {
        return this.regexErrorMessage;
    }

    public void setRegexErrorMessage(String str) {
        this.regexErrorMessage = str;
    }

    public String getmAuxValue() {
        return this.mAuxValue;
    }

    public void setmAuxValue(String str) {
        this.mAuxValue = str;
    }
}
