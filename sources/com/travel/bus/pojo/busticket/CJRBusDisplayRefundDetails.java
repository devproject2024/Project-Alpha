package com.travel.bus.pojo.busticket;

import com.google.gsonhtcfix.a.b;
import java.util.List;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRBusDisplayRefundDetails implements IJRDataModel {
    @b(a = "refund_details")
    private List<CJRBusRefundCardDetails> cjrBusRefundCardDetailsList = null;
    @b(a = "index")
    private Integer index;
    @b(a = "is_visible")
    private Boolean isVisible;
    @b(a = "label")
    private String label;
    @b(a = "text_style")
    private String textStyle;

    public String getLabel() {
        return this.label;
    }

    public void setLabel(String str) {
        this.label = str;
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

    public Integer getIndex() {
        return this.index;
    }

    public void setIndex(Integer num) {
        this.index = num;
    }

    public List<CJRBusRefundCardDetails> getRefundDetails() {
        return this.cjrBusRefundCardDetailsList;
    }

    public void setRefundDetails(List<CJRBusRefundCardDetails> list) {
        this.cjrBusRefundCardDetailsList = list;
    }
}
