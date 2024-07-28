package net.one97.paytmflight.common.entity.flightticket;

import net.one97.paytm.common.entity.IJRDataModel;

public class CJROrderSummaryBookingCard implements IJRDataModel {
    private String header;
    private String message;

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String str) {
        this.message = str;
    }

    public String getHeader() {
        return this.header;
    }

    public void setHeader(String str) {
        this.header = str;
    }
}
