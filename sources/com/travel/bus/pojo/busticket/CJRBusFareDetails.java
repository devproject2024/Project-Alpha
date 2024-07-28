package com.travel.bus.pojo.busticket;

import com.google.gsonhtcfix.a.b;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRBusFareDetails implements IJRDataModel {
    @b(a = "index")
    private Integer index;
    @b(a = "label")
    private String label;
    @b(a = "strike_out")
    private Boolean strikeOut;
    @b(a = "text_style")
    private String textStyle;
    @b(a = "underline_after")
    private Boolean underlineAfter;
    @b(a = "value")
    private String value;

    public String getLabel() {
        return this.label;
    }

    public void setLabel(String str) {
        this.label = str;
    }

    public String getValue() {
        return this.value;
    }

    public void setValue(String str) {
        this.value = str;
    }

    public String getTextStyle() {
        return this.textStyle;
    }

    public void setTextStyle(String str) {
        this.textStyle = str;
    }

    public Boolean getStrikeOut() {
        return this.strikeOut;
    }

    public void setStrikeOut(Boolean bool) {
        this.strikeOut = bool;
    }

    public Boolean getUnderlineAfter() {
        return this.underlineAfter;
    }

    public void setUnderlineAfter(Boolean bool) {
        this.underlineAfter = bool;
    }

    public Integer getIndex() {
        return this.index;
    }

    public void setIndex(Integer num) {
        this.index = num;
    }
}
