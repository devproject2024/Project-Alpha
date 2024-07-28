package com.travel.flight.pojo.flightticket;

import com.google.gsonhtcfix.a.b;
import java.util.ArrayList;
import java.util.List;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRPassenger implements IJRDataModel {
    @b(a = "tooltip")
    private String tooltip;
    @b(a = "validations")
    private List<CJRValidation> validations = new ArrayList();

    public String getTooltip() {
        return this.tooltip;
    }

    public void setTooltip(String str) {
        this.tooltip = str;
    }

    public List<CJRValidation> getValidations() {
        return this.validations;
    }

    public void setValidations(List<CJRValidation> list) {
        this.validations = list;
    }
}
