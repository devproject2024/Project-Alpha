package com.paytmmall.artifact.scan.entity;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.ArrayList;

public class CJRBrtsDestination extends IJRPaytmDataModel {
    private static final long serialVersionUID = 1;
    @b(a = "typeOfBus")
    private ArrayList<String> mBusTypes;
    @b(a = "destinationId")
    private String mDestinationId;
    @b(a = "destinationName")
    private String mDestinationName;
    @b(a = "routeInfoList")
    private ArrayList<CJRBrtsRoute> routeInfoList;

    public String getDestinationName() {
        return this.mDestinationName;
    }

    public void setDestinationName(String str) {
        this.mDestinationName = str;
    }

    public String getDestinationId() {
        return this.mDestinationId;
    }

    public ArrayList<String> getBusTypes() {
        return this.mBusTypes;
    }

    public ArrayList<CJRBrtsRoute> getRouteInfoList() {
        return this.routeInfoList;
    }

    public void setRouteInfoList(ArrayList<CJRBrtsRoute> arrayList) {
        this.routeInfoList = arrayList;
    }

    public boolean equals(Object obj) {
        return this.mDestinationName.equals(((CJRBrtsDestination) obj).getDestinationName());
    }

    public int hashCode() {
        return this.mDestinationName.hashCode();
    }

    public void setmDestinationId(String str) {
        this.mDestinationId = str;
    }
}
