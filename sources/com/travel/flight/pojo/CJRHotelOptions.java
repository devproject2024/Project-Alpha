package com.travel.flight.pojo;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.List;

public class CJRHotelOptions extends IJRPaytmDataModel {
    private String allHotelsLink;
    private List<b> data;
    private String message;
    private String requestId;
    private String statusCode;
    @b(a = "widget-title")
    private String widgetTitle;

    public String getAllHotelsLink() {
        return this.allHotelsLink;
    }

    public void setAllHotelsLink(String str) {
        this.allHotelsLink = str;
    }

    public List<b> getData() {
        return this.data;
    }

    public void setData(List<b> list) {
        this.data = list;
    }

    public String getRequestId() {
        return this.requestId;
    }

    public void setRequestId(String str) {
        this.requestId = str;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String str) {
        this.message = str;
    }

    public String getWidgetTitle() {
        return this.widgetTitle;
    }

    public void setWidgetTitle(String str) {
        this.widgetTitle = str;
    }

    public String getStatusCode() {
        return this.statusCode;
    }

    public void setStatusCode(String str) {
        this.statusCode = str;
    }
}
