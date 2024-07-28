package com.travel.train.model.trainticket;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRTrainBookingInformation extends IJRPaytmDataModel implements IJRDataModel {
    private static final long serialVersionUID = 1;
    @b(a = "body")
    private CJRTrainBookingStatus mTrainBookingStatus;

    public CJRTrainBookingStatus getmTrainBookingStatus() {
        return this.mTrainBookingStatus;
    }
}
