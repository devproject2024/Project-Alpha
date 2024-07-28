package com.paytm.notification.models.request;

import com.google.gson.a.c;
import java.util.ArrayList;

public final class FetchInboxRequest {
    @c(a = "device")
    private String device;
    @c(a = "ids")
    private ArrayList<String> ids;
    @c(a = "order")
    private String order;
    @c(a = "tag")
    private String tag;

    public final String getDevice() {
        return this.device;
    }

    public final void setDevice(String str) {
        this.device = str;
    }

    public final String getTag() {
        return this.tag;
    }

    public final void setTag(String str) {
        this.tag = str;
    }

    public final String getOrder() {
        return this.order;
    }

    public final void setOrder(String str) {
        this.order = str;
    }

    public final ArrayList<String> getIds() {
        return this.ids;
    }

    public final void setIds(ArrayList<String> arrayList) {
        this.ids = arrayList;
    }
}
