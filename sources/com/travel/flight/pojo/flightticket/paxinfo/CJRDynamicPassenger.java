package com.travel.flight.pojo.flightticket.paxinfo;

import com.google.gsonhtcfix.a.b;
import java.util.ArrayList;
import java.util.List;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytmflight.common.entity.travel.CJRDynamicValidation;

public class CJRDynamicPassenger implements IJRDataModel {
    @b(a = "tooltip")
    private String tooltip;
    @b(a = "validations")
    private List<CJRDynamicValidation> validations = new ArrayList();

    public String getTooltip() {
        return this.tooltip;
    }

    public List<CJRDynamicValidation> getValidations() {
        return this.validations;
    }
}
