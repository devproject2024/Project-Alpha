package com.travel.bus.pojo.hotel;

import com.google.gson.a.a;
import com.google.gson.a.c;
import com.google.gsonhtcfix.f;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.List;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRHotelObject extends IJRPaytmDataModel implements IJRDataModel {
    @c(a = "allHotelsLink")
    @a
    private String allHotelsLink;
    @c(a = "data")
    @a
    private List<CJRHotelDataModel> data = null;
    @c(a = "widget-title")
    @a
    private String widgetTitle;

    public String getWidgetTitle() {
        return this.widgetTitle;
    }

    public String getAllHotelsLink() {
        return this.allHotelsLink;
    }

    public List<CJRHotelDataModel> getData() {
        return this.data;
    }

    public IJRPaytmDataModel parseResponse(String str, f fVar) throws Exception {
        return (IJRPaytmDataModel) new com.google.gson.f().a(str, CJRHotelObject.class);
    }
}
