package com.travel.bus.pojo.busticket;

import com.google.gsonhtcfix.a.b;
import java.util.List;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRBusRefundCardDetails implements IJRDataModel {
    @b(a = "data")
    private List<CJRBusFareDetails> cjrBusFareDetailsList = null;
    @b(a = "index")
    private Integer index;
    @b(a = "is_visible")
    private Boolean isVisible;
    @b(a = "label")
    private String label;
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

    public Boolean getIsVisible() {
        return this.isVisible;
    }

    public void setIsVisible(Boolean bool) {
        this.isVisible = bool;
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

    public List<CJRBusFareDetails> getData() {
        return this.cjrBusFareDetailsList;
    }

    public void setData(List<CJRBusFareDetails> list) {
        this.cjrBusFareDetailsList = list;
    }
}
