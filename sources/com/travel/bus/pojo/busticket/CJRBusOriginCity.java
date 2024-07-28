package com.travel.bus.pojo.busticket;

import com.google.gsonhtcfix.f;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

public class CJRBusOriginCity extends IJRPaytmDataModel {
    private static final long serialVersionUID = 1;
    private boolean isSource;
    private ArrayList<CJRBusOriginCityItem> mBusOriginCityItems;
    private Long mServerResponseTime;

    public boolean isSource() {
        return this.isSource;
    }

    public void setSource(boolean z) {
        this.isSource = z;
    }

    public ArrayList<CJRBusOriginCityItem> getmOriginCityItems() {
        return this.mBusOriginCityItems;
    }

    public void setBusOriginCityItems(ArrayList<CJRBusOriginCityItem> arrayList) {
        this.mBusOriginCityItems = arrayList;
    }

    public void setServerResponseTime(Long l) {
        this.mServerResponseTime = l;
    }

    public Long getServerResponseTime() {
        return this.mServerResponseTime;
    }

    public IJRPaytmDataModel parseResponse(String str, f fVar) {
        CJRBusOriginCityItem[] cJRBusOriginCityItemArr = (CJRBusOriginCityItem[]) fVar.a(str, CJRBusOriginCityItem[].class);
        CJRBusOriginCity cJRBusOriginCity = new CJRBusOriginCity();
        if (cJRBusOriginCityItemArr != null) {
            if (isSource()) {
                cJRBusOriginCity.setSource(true);
            } else {
                cJRBusOriginCity.setSource(false);
            }
            cJRBusOriginCity.setBusOriginCityItems(new ArrayList(Arrays.asList(cJRBusOriginCityItemArr)));
            cJRBusOriginCity.setServerResponseTime(Long.valueOf(new Date().getTime()));
        }
        return cJRBusOriginCity;
    }
}
