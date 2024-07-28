package com.travel.booking.datamodel;

public final class Action {
    private String label;
    private String logo;
    private UrlParam urlParams;

    public final UrlParam getUrlParams() {
        return this.urlParams;
    }

    public final void setUrlParams(UrlParam urlParam) {
        this.urlParams = urlParam;
    }

    public final String getLogo() {
        return this.logo;
    }

    public final void setLogo(String str) {
        this.logo = str;
    }

    public final String getLabel() {
        return this.label;
    }

    public final void setLabel(String str) {
        this.label = str;
    }
}
