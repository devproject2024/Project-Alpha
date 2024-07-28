package com.travel.train.model.trainticket;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.ArrayList;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRTrainCity extends IJRPaytmDataModel implements IJRDataModel {
    private static final long serialVersionUID = 1;
    @b(a = "body")
    private ArrayList<CJRTrainStationsList> mTrainOriginCityItems;
    private ArrayList<CJRTrainRecentsItemModel> mTrainSearchedCityDetails;

    public CJRTrainStationsList getTrainStationsList() {
        if (this.mTrainOriginCityItems == null) {
            return null;
        }
        for (int i2 = 0; i2 < this.mTrainOriginCityItems.size(); i2++) {
            CJRTrainStationsList cJRTrainStationsList = this.mTrainOriginCityItems.get(i2);
            if (cJRTrainStationsList != null && cJRTrainStationsList.getStations() != null && cJRTrainStationsList.getStations().size() > 0) {
                return cJRTrainStationsList;
            }
        }
        return null;
    }

    public CJRTrainStationsList getTrainRouteList() {
        if (this.mTrainOriginCityItems == null) {
            return null;
        }
        for (int i2 = 0; i2 < this.mTrainOriginCityItems.size(); i2++) {
            CJRTrainStationsList cJRTrainStationsList = this.mTrainOriginCityItems.get(i2);
            if (cJRTrainStationsList != null && cJRTrainStationsList.getRoutes() != null && cJRTrainStationsList.getRoutes().size() > 0) {
                return cJRTrainStationsList;
            }
        }
        return null;
    }

    public void setTrainStationsList(ArrayList<CJRTrainStationsList> arrayList) {
        this.mTrainOriginCityItems = arrayList;
    }

    public ArrayList<CJRTrainRecentsItemModel> getmTrainSearchedCityDetails() {
        return this.mTrainSearchedCityDetails;
    }

    public void setmTrainSearchedCityDetails(ArrayList<CJRTrainRecentsItemModel> arrayList) {
        this.mTrainSearchedCityDetails = arrayList;
    }
}
