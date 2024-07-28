package com.travel.train.model.trainticket;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRTrainRouteStations extends IJRPaytmDataModel implements IJRDataModel {
    private static final long serialVersionUID = 1;
    @b(a = "destination")
    private CJRTrainOriginCityItem destination;
    @b(a = "display_name")
    private String displayName;
    @b(a = "source")
    private CJRTrainOriginCityItem source;

    public String getDisplayName() {
        return this.displayName;
    }

    public CJRTrainOriginCityItem getSource() {
        return this.source;
    }

    public CJRTrainOriginCityItem getDestination() {
        return this.destination;
    }
}
