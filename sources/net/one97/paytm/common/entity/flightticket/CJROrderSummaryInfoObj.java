package net.one97.paytm.common.entity.flightticket;

import net.one97.paytm.common.entity.IJRDataModel;

public class CJROrderSummaryInfoObj implements IJRDataModel {
    private String c_sid;

    public String getC_sid() {
        return this.c_sid;
    }

    public void setC_sid(String str) {
        this.c_sid = str;
    }
}
