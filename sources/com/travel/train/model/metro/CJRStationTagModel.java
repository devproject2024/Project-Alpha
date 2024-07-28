package com.travel.train.model.metro;

import com.paytm.network.model.IJRPaytmDataModel;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.IJRDataModel;

public final class CJRStationTagModel extends IJRPaytmDataModel implements IJRDataModel {
    private String stationString;

    public CJRStationTagModel(String str) {
        k.c(str, "stationString");
        this.stationString = str;
    }

    public final String getStationString() {
        return this.stationString;
    }

    public final void setStationString(String str) {
        k.c(str, "<set-?>");
        this.stationString = str;
    }
}
