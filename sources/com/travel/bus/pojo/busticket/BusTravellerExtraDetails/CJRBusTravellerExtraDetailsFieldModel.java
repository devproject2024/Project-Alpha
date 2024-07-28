package com.travel.bus.pojo.busticket.BusTravellerExtraDetails;

import com.google.gson.a.c;
import java.util.ArrayList;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRBusTravellerExtraDetailsFieldModel implements IJRDataModel {
    @c(a = "defaultSelected")
    private String defaultSelected;
    @c(a = "error_text")
    private String error_text;
    @c(a = "isPrimaryPax")
    private boolean isPrimaryPax;
    @c(a = "isVisibile")
    private boolean isVisibile;
    @c(a = "key")
    private String key;
    @c(a = "label")
    private String label;
    @c(a = "name")
    private String name;
    @c(a = "options")
    private ArrayList<CJRDropdownOptionsModel> options;
    @c(a = "regex")
    private String regex;
    @c(a = "required")
    private boolean required;
    @c(a = "type")
    private String type;

    public String getKey() {
        return this.key;
    }

    public void setKey(String str) {
        this.key = str;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
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

    public boolean isVisibile() {
        return this.isVisibile;
    }

    public boolean isPrimaryPax() {
        return this.isPrimaryPax;
    }

    public boolean isRequired() {
        return this.required;
    }

    public void setRequired(boolean z) {
        this.required = z;
    }

    public String getDefaultSelected() {
        return this.defaultSelected;
    }

    public ArrayList<CJRDropdownOptionsModel> getOptions() {
        return this.options;
    }

    public String getRegex() {
        return this.regex;
    }

    public String getError_text() {
        return this.error_text;
    }
}
