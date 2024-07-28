package net.one97.paytmflight.common.entity.flightticket;

import net.one97.paytm.common.entity.IJRDataModel;

public class CJROrderSummaryTransactionDetails implements IJRDataModel {
    private String title;
    private String type;
    private String value;

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public String getValue() {
        return this.value;
    }

    public void setValue(String str) {
        this.value = str;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String str) {
        this.type = str;
    }
}
