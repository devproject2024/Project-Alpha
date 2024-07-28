package com.travel.train.model.trainticket;

import com.paytm.network.model.IJRPaytmDataModel;
import net.one97.paytm.common.entity.IJRDataModel;

public class BoardingStationData extends IJRPaytmDataModel implements IJRDataModel {
    public String stationTitle;
    public String travelDate;

    public String getStationTitle() {
        return this.stationTitle;
    }

    public void setStationTitle(String str) {
        this.stationTitle = str;
    }

    public String getTravelDate() {
        return this.travelDate;
    }

    public void setTravelDate(String str) {
        this.travelDate = str;
    }
}
