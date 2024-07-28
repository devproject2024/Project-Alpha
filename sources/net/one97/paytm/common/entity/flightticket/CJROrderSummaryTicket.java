package net.one97.paytm.common.entity.flightticket;

import net.one97.paytm.common.entity.IJRDataModel;

public class CJROrderSummaryTicket implements IJRDataModel {
    private String O1;
    private String O2;

    public String getO1() {
        return this.O1;
    }

    public void setO1(String str) {
        this.O1 = str;
    }

    public String getO2() {
        return this.O2;
    }

    public void setO2(String str) {
        this.O2 = str;
    }
}
