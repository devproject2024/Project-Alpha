package com.travel.train.model.metro;

import com.paytm.network.model.IJRPaytmDataModel;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRParcelableMetroStationModel extends IJRPaytmDataModel implements IJRDataModel {
    public String destinationStation;
    public String destinationStationCode;
    public String metroCityName;
    public String modeId;
    public String sourceStation;
    public String sourceStationCode;

    public CJRParcelableMetroStationModel(String str, String str2, String str3, String str4, String str5, String str6) {
        this.sourceStation = str;
        this.sourceStationCode = str2;
        this.destinationStation = str3;
        this.destinationStationCode = str4;
        this.modeId = str5;
        this.metroCityName = str6;
    }
}
