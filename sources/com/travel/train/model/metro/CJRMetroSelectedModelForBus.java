package com.travel.train.model.metro;

import com.paytm.network.model.IJRPaytmDataModel;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRMetroSelectedModelForBus extends IJRPaytmDataModel implements IJRDataModel {
    public CJRStationAutoSuggestModel selectedStation;
    public int type;

    public CJRMetroSelectedModelForBus(int i2, CJRStationAutoSuggestModel cJRStationAutoSuggestModel) {
        this.type = i2;
        this.selectedStation = cJRStationAutoSuggestModel;
    }
}
