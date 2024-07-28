package com.business.merchant_payments.event;

public class NoNetworkEvent {
    public String clickType;
    public String clickedFrom;

    public NoNetworkEvent(String str, String str2) {
        this.clickType = str;
        this.clickedFrom = str2;
    }

    public String getClickType() {
        return this.clickType;
    }

    public String getClickedFrom() {
        return this.clickedFrom;
    }
}
