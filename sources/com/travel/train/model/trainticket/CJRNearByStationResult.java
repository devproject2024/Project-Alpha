package com.travel.train.model.trainticket;

import com.google.gsonhtcfix.a.a;
import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.List;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRNearByStationResult extends IJRPaytmDataModel implements IJRDataModel {
    @a
    @b(a = "code")
    private Integer code;
    @a
    @b(a = "body")
    private List<CJRNearByStation> mNearByStations = null;
    @a
    @b(a = "status")
    private CJRTrainStatus status;

    public CJRTrainStatus getStatus() {
        return this.status;
    }

    public List<CJRNearByStation> getNearByStations() {
        return this.mNearByStations;
    }

    public Integer getCode() {
        return this.code;
    }
}
