package net.one97.paytm.recharge.legacy.catalog.model;

import android.text.TextUtils;
import com.google.gsonhtcfix.a.b;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRUtilityInputFieldsV2 implements IJRDataModel {
    @b(a = "body")
    private String body;
    @b(a = "config_key")
    private String configKey;
    @b(a = "date_format")
    private String date_format;
    @b(a = "heading")
    private String heading;
    @b(a = "hide")
    private String hideInputField;
    @b(a = "isAlphanumeric")
    private boolean isAlphanumeric = true;
    @b(a = "is_shown")
    private boolean isShown = false;
    @b(a = "keyboard_type")
    private String keyboardType;
    @b(a = "read_only")
    private int mReadOnly;
    @b(a = "mandatory")
    private boolean mandatory;
    @b(a = "match_with")
    private String matchWith;
    @b(a = "max")
    private String max;
    @b(a = "max_date")
    private String maxDate;
    @b(a = "message")
    private String message;
    @b(a = "min")
    private String min;
    @b(a = "min_date")
    private String minDate;
    @b(a = "optional")
    private boolean optional;
    @b(a = "regex")
    private String regex;
    @b(a = "right_button_label")
    private String right_button_label;
    @b(a = "right_button_url")
    private String right_button_url;
    @b(a = "sample_bill")
    private String sample_bill_url;
    @b(a = "show_phonebook")
    private String showPhoneBook;
    @b(a = "tab_info")
    private String tabInfo;
    @b(a = "text_space_separation")
    private String textSpaceSeparation;
    @b(a = "title")
    private String title;
    @b(a = "type")
    private String type;
    @b(a = "value")
    private String value;

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public String getConfigKey() {
        return this.configKey;
    }

    public String getMatchWithKey() {
        return this.matchWith;
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

    public boolean getMandatory() {
        return this.mandatory;
    }

    public void setMandatory(boolean z) {
        this.mandatory = z;
    }

    public String getRegex() {
        return this.regex;
    }

    public String getMessage() {
        return this.message;
    }

    public void setRegex(String str) {
        this.regex = str;
    }

    public String getMin() {
        return this.min;
    }

    public String getMax() {
        return this.max;
    }

    public String getSample_bill_url() {
        return this.sample_bill_url;
    }

    public String getRight_button_label() {
        return this.right_button_label;
    }

    public String getRight_button_url() {
        return this.right_button_url;
    }

    public boolean isShown() {
        return this.isShown;
    }

    public void setShown(boolean z) {
        this.isShown = z;
    }

    public void setShowPhoneBook(String str) {
        this.showPhoneBook = str;
    }

    public String getShowPhoneBook() {
        return this.showPhoneBook;
    }

    public void setAlphanumeric(boolean z) {
        this.isAlphanumeric = z;
    }

    public boolean getAlphanumeric() {
        return this.isAlphanumeric;
    }

    public boolean isHideInputField() {
        return "TRUE".equalsIgnoreCase(this.hideInputField);
    }

    public String getTextSpaceSeparation() {
        return this.textSpaceSeparation;
    }

    public String getKeyboardType() {
        return this.keyboardType;
    }

    public void setHideInputField(String str) {
        this.hideInputField = str;
    }

    public boolean ismReadOnly() {
        return this.mReadOnly == 1;
    }

    public boolean isOptional() {
        return this.optional;
    }

    public void setOptional(boolean z) {
        this.optional = z;
    }

    public String getBody() {
        return this.body;
    }

    public void setBody(String str) {
        this.body = str;
    }

    public String getHeading() {
        return this.heading;
    }

    public void setHeading(String str) {
        this.heading = str;
    }

    public String getValue() {
        return this.value;
    }

    public void setValue(String str) {
        this.value = str;
    }

    public String getMinDate() {
        return this.minDate;
    }

    public void setMinDate(String str) {
        this.minDate = str;
    }

    public String getMaxDate() {
        return this.maxDate;
    }

    public void setMaxDate(String str) {
        this.maxDate = str;
    }

    public String getDate_format() {
        return this.date_format;
    }

    public void setDate_format(String str) {
        this.date_format = str;
    }

    public List<String> getValuesList() {
        ArrayList arrayList = new ArrayList();
        if (TextUtils.isEmpty(this.value)) {
            return arrayList;
        }
        String[] split = this.value.split(AppConstants.COMMA);
        return split.length > 0 ? Arrays.asList(split) : arrayList;
    }

    public String getTabInfo() {
        return this.tabInfo;
    }

    public void setTabInfo(String str) {
        this.tabInfo = str;
    }

    public void setRight_button_url(String str) {
        this.right_button_url = str;
    }

    public void setRight_button_label(String str) {
        this.right_button_label = str;
    }
}
