package com.travel.train.model.trainticket;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.List;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRTrainRouteBody extends IJRPaytmDataModel implements IJRDataModel {
    @b(a = "stationList")
    private List<CJRStationList> mStationList;
    @b(a = "trainName")
    private String mTrainName;
    @b(a = "trainNumber")
    private String mTrainNumber;

    public String getmTrainName() {
        return this.mTrainName;
    }

    public String getmTrainNumber() {
        return this.mTrainNumber;
    }

    public List<CJRStationList> getmStationList() {
        return this.mStationList;
    }
}
