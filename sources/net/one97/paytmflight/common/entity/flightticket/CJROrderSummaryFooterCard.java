package net.one97.paytmflight.common.entity.flightticket;

import net.one97.paytm.common.entity.IJRDataModel;

public class CJROrderSummaryFooterCard implements IJRDataModel {
    private String header;
    private String link_string;
    private String link_url;
    private String message;

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String str) {
        this.message = str;
    }

    public String getLink_url() {
        return this.link_url;
    }

    public void setLink_url(String str) {
        this.link_url = str;
    }

    public String getLink_string() {
        return this.link_string;
    }

    public void setLink_string(String str) {
        this.link_string = str;
    }

    public String getHeader() {
        return this.header;
    }

    public void setHeader(String str) {
        this.header = str;
    }
}
