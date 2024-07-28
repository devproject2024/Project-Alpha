package com.travel.train.model.trainticket;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.ArrayList;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRTrainStationsList extends IJRPaytmDataModel implements IJRDataModel {
    @b(a = "routes")
    private ArrayList<CJRTrainRouteStations> routes = null;
    @b(a = "stations")
    private ArrayList<CJRTrainStation> stations = null;
    @b(a = "title")
    private String title;

    public String getTitle() {
        return this.title;
    }

    public ArrayList<CJRTrainStation> getStations() {
        return this.stations;
    }

    public void setStations(ArrayList<CJRTrainStation> arrayList) {
        this.stations = arrayList;
    }

    public ArrayList<CJRTrainRouteStations> getRoutes() {
        return this.routes;
    }
}
