package com.travel.train.model.trainticket;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRTravelDetails extends IJRPaytmDataModel implements IJRDataModel {
    @b(a = "SRP")
    private CJRTrainQuickSRP srp;

    public CJRTrainQuickSRP getSrp() {
        return this.srp;
    }
}
