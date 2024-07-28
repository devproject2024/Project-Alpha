package com.travel.train.model.trainticket;

import com.paytm.network.model.IJRPaytmDataModel;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRTrainOfferStatus extends IJRPaytmDataModel implements IJRDataModel {
    private String result;

    public String getResult() {
        return this.result;
    }
}
