package net.one97.paytmflight.common.entity.flightticket;

import net.one97.paytm.common.entity.IJRDataModel;

public class CJROrderSummaryCancallationProtect implements IJRDataModel {
    private String footer;
    private String header;
    private String img_url;
    private String link;
    private String link_string;
    private String link_url;
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

    public String getLink_string() {
        return this.link_string;
    }

    public void setLink_string(String str) {
        this.link_string = str;
    }

    public String getLink() {
        return this.link;
    }

    public void setLink(String str) {
        this.link = str;
    }

    public String getImg_url() {
        return this.img_url;
    }

    public void setImg_url(String str) {
        this.img_url = str;
    }

    public String getLink_url() {
        return this.link_url;
    }

    public void setLink_url(String str) {
        this.link_url = str;
    }

    public String getFooter() {
        return this.footer;
    }

    public void setFooter(String str) {
        this.footer = str;
    }
}
