package net.one97.paytm.common.entity.giftcards;

import com.google.gsonhtcfix.a.b;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRGiftCardUserInputField implements IJRDataModel {
    public static final String FIELD_TYPE_CALENDAR = "date";
    public static final String FIELD_TYPE_CHECKBOX = "checkbox";
    public static final String FIELD_TYPE_DROPDOWN = "select";
    public static final String FIELD_TYPE_RADIO = "radio";
    public static final String FIELD_TYPE_TEXTBOX = "text";
    public static final String FIELD_TYPE_TEXT_AREA = "textarea";
    private static final long serialVersionUID = 1;
    private String appliedData;
    @b(a = "config_key")
    private String configKey;
    @b(a = "mandatory")
    private boolean mandatory;
    @b(a = "regex")
    private String regex;
    @b(a = "title")
    private String title;
    @b(a = "type")
    private String type;

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public String getConfigKey() {
        return this.configKey;
    }

    public void setConfigKey(String str) {
        this.configKey = str;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String str) {
        this.type = str;
    }

    public boolean isMandatory() {
        return this.mandatory;
    }

    public void setMandatory(boolean z) {
        this.mandatory = z;
    }

    public String getRegex() {
        return this.regex;
    }

    public void setRegex(String str) {
        this.regex = str;
    }

    public String getAppliedData() {
        return this.appliedData;
    }

    public void setAppliedData(String str) {
        this.appliedData = str;
    }
}
